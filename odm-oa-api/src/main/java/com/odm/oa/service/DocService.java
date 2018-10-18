package com.odm.oa.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.common.utils.Constants;
import com.odm.oa.common.utils.JwtTokenUtil;
import com.odm.oa.dao.mapper.FtFileMapper;
import com.odm.oa.dao.mapper.FtFileShareMapper;
import com.odm.oa.dao.mapper.FtFileUserauthMapper;
import com.odm.oa.dao.mapper.FtFolderMapper;
import com.odm.oa.dao.pojo.FtFile;
import com.odm.oa.dao.pojo.FtFileShare;
import com.odm.oa.dao.pojo.FtFileUserauth;
import com.odm.oa.dao.pojo.FtFolder;
import com.odm.oa.dao.pojo.ex.FolderRequest;
import com.odm.oa.dao.pojo.ex.ShareRequest;
import com.odm.oa.dao.pojo.pagination.DocPagination;

@Service
public class DocService {
	private static Logger logger = LogManager.getLogger(DocService.class);
	@Value("${filePath}")
	private String filePath;
	@Autowired
	private FtFolderMapper folderMapper;
	@Autowired
	private FtFileMapper fileMapper;
	@Autowired
	private FtFileShareMapper shareMapper;
	@Autowired
	private FtFileUserauthMapper userMapper;


	/**
	 * 显示所有文件夹
	 * 
	 * @param request
	 * @return
	 */
	public PageInfo<FtFolder> getPage(DocPagination request) {
		// 只是列出文件夹，显示文件出现问题
		logger.info("method: getList param：" + JSONObject.toJSONString(request));
		if (request.getPageNum() == null) {
			request.setPageNum(1);
		}
		if (request.getPageSize() == null) {
			request.setPageSize(10);
		}
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		request.setCrUser(JwtTokenUtil.getUserIdFromContext());
		List<FtFolder> list = folderMapper.pageList(request);
		PageInfo<FtFolder> pageInfo = new PageInfo<FtFolder>(list);
		logger.info("method: getList result：" + JSONObject.toJSONString(pageInfo));
		return pageInfo;
	}


	/**
	 * 查询根目录
	 * 
	 * @param id
	 * @return
	 */
	public PageInfo<FtFolder> getRootDir(DocPagination request) {
		// 存在问题
		request.setCrUser(JwtTokenUtil.getUserIdFromContext());
		List<FtFolder> list = folderMapper.selectRootDir(request);
		PageInfo<FtFolder> pageInfo = new PageInfo<FtFolder>(list);
		return pageInfo;
	}


	/**
	 * 查询子文件
	 * 
	 * @param id
	 * @return
	 */
	public PageInfo<FtFile> getCFile(Integer id) {
		// 存在问题
		List<FtFile> list = fileMapper.selectCFileByPId(id);
		PageInfo<FtFile> pageInfo = new PageInfo<FtFile>(list);
		return pageInfo;
	}

	/**
	 * 查询子文件夹
	 * 
	 * @param id
	 * @return
	 */
	public PageInfo<FtFolder> getCFolder(Integer id) {
		List<FtFolder> list = folderMapper.selectByPId(id);
		PageInfo<FtFolder> pageInfo = new PageInfo<FtFolder>(list);
		return pageInfo;
	}

	/**
	 * 查询分享根目录
	 * 
	 * @param id
	 * @return
	 */
	public PageInfo<FtFolder> getShareRootDir(DocPagination request) {
		// 存在问题
		request.setViewUserName(JwtTokenUtil.getUserIdFromContext());
		List<FtFolder> list = folderMapper.selectShareRootDir(request);
		PageInfo<FtFolder> pageInfo = new PageInfo<FtFolder>(list);
		return pageInfo;
	}

	/**
	 * 查询分享子文件夹
	 * 
	 * @param id
	 * @return
	 */
	public PageInfo<FtFolder> getShareCFolder(Integer id) {
		FtFolder fatherFolder = folderMapper.selectByPrimaryKey(id);
		if (null == fatherFolder.getpFolderId()) {
			FtFileUserauth user = userMapper.selectByUserName(fatherFolder.getViewAuthUsers());
			FtFolder shareCFolder = folderMapper.selectByPrimaryKey(user.getRefId());
			List<FtFolder> list = new ArrayList<FtFolder>();
			list.add(shareCFolder);
			PageInfo<FtFolder> pageInfo = new PageInfo<FtFolder>(list);
			return pageInfo;
		} else {
			List<FtFolder> list = folderMapper.selectByPId(id);
			PageInfo<FtFolder> pageInfo = new PageInfo<FtFolder>(list);
			return pageInfo;
		}
	}

	/**
	 * 新建文件夹
	 */
	@Transactional(rollbackFor = Exception.class)
	public void createFolder(FolderRequest request, BaseResponse<String> response) {
		if (checkFolderName(Constants.INSERT_FLG, request)) {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
			response.setStatusMsg(Constants.FOLDER_NAME_ALREADY_EXIST);
		} else {
			String dirName = request.getName();
			if (request.getpFolderName() == null) {
				// 如果新建的文件夹的父name为空，则在d:\directory根据新建的名称去确定dirName，然后再建立文件夹
				File dir = new File("D:" + File.separator + "directory" + File.separator + request.getFolderType()
						+ File.separator + JwtTokenUtil.getUserIdFromContext() + File.separator + dirName);
				if (!dir.exists()) {
					System.out.println(dir.mkdirs());
				}
				request.setpFolderId(0);
				request.setFoldDownloadUrl(dir.getPath());
			} else {
				// 根据pName获取对应的父文件夹的路径,并在父文件夹下面建子文件夹
				FtFolder fatherFolder = folderMapper.selectByName(request.getpFolderName());
				// String fatherName = fatherFolder.getName();
				String fatherPath = fatherFolder.getFoldDownloadUrl();
				File dir = new File(fatherPath + File.separator + dirName);
				if (!dir.exists()) {
					System.out.println(dir.mkdirs());
				}
				request.setFoldDownloadUrl(dir.getPath());
				request.setpFolderId(fatherFolder.getId());
			}
			request.setCrUser(JwtTokenUtil.getUserIdFromContext());
			request.setDelFlg(false);
			// request.setFolderType("文件夹");
			request.setCrDate(new Date());
			folderMapper.insert(request);
			// 新建成功
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		}
	}
	/*
	 * 删除文件夹
	 */

	@Transactional(rollbackFor = Exception.class)
	public void deleteFolder(Integer id) {
		FtFolder folder = folderMapper.selectByPrimaryKey(id);
		// 删除文件夹及所有的子文件夹以及文件
		String path = folder.getFoldDownloadUrl();
		// File file = new File(path);
		// DocService.deleteMethod(file);
		// 本地删除此文件夹下面的所有
		DocService.delFolder(path);
		folder.setDelFlg(Constants.IS_DELETE);
		folder.setUpUser(JwtTokenUtil.getUserIdFromContext());
		folder.setUpDate(new Date());
		folderMapper.updateByPrimaryKey(folder);
		List<FtFile> list1 = fileMapper.selectCFileByPId(id.intValue());
		if (null == list1 || list1.size() == 0) {
		} else {
			for (int i1 = 0; i1 < list1.size(); i1++) {
				FtFile file = (FtFile) list1.get(i1);
				file.setDelFlg("1");
				file.setUpUser(JwtTokenUtil.getUserIdFromContext());
				file.setUpDate(new Date());
				fileMapper.updateByPrimaryKey(file);
			}
		}
		List<FtFolder> list2 = folderMapper.selectByPId(id);
		if (null == list2 || list2.size() == 0) {
		} else {
			for (int i2 = 0; i2 < list2.size(); i2++) {
				FtFolder cFolder = (FtFolder) list2.get(i2);
				cFolder.setpFolderId(id);
				cFolder.setDelFlg(Constants.IS_DELETE);
				cFolder.setUpUser(JwtTokenUtil.getUserIdFromContext());
				cFolder.setUpDate(new Date());
				cFolder.setFoldDownloadUrl(folder.getFoldDownloadUrl() + File.separator + cFolder.getName());
				folderMapper.updateByPrimaryKey(cFolder);
				List<FtFolder> list3 = folderMapper.selectByPId(cFolder.getId());
				List<FtFile> list4 = fileMapper.selectCFileByPId(cFolder.getId());
				if (null == list4 || list4.size() == 0) {
				} else {
					for (int i4 = 0; i4 < list4.size(); i4++) {
						FtFile file = (FtFile) list4.get(i4);
						file.setDelFlg("1");
						file.setUpUser(JwtTokenUtil.getUserIdFromContext());
						file.setUpDate(new Date());
						fileMapper.updateByPrimaryKey(file);
					}
				}
				if (null == list3 || list3.size() == 0) {
				} else {
					for (int i3 = 0; i3 < list3.size(); i3++) {
						FtFolder ccFolder = (FtFolder) list3.get(i3);
						this.deleteFolder(ccFolder.getId());
					}
				}
			}
		}
	}

	/**
	 * 删除文件
	 */
	/*
	 * @Transactional(rollbackFor = Exception.class) public void deleteFile(Long[]
	 * ids) { for (Long id : ids) { FtFile file =
	 * fileMapper.selectByPrimaryKey(id.intValue()); // 删除文件夹及所有的子文件夹以及文件 String
	 * path = file.getFileUrl(); File f = new File(path); f.delete();
	 * file.setDelFlg("1"); file.setUpUser(JwtTokenUtil.getUserIdFromContext());
	 * file.setUpDate(new Date()); fileMapper.updateByPrimaryKey(file); // to-do
	 * 有问题在删除的时候虽然本地删除了，但是数据库的记录 只是删除了父文件夹 } }
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteFile(Integer id) {
		FtFile file = fileMapper.selectByPrimaryKey(id.intValue());
		// 删除文件夹及所有的子文件夹以及文件
		String path = file.getFileUrl();
		File f = new File(path);
		f.delete();
		file.setDelFlg("1");
		file.setUpUser(JwtTokenUtil.getUserIdFromContext());
		file.setUpDate(new Date());
		fileMapper.updateByPrimaryKey(file);
		// to-do 有问题在删除的时候虽然本地删除了，但是数据库的记录 只是删除了父文件夹(已经解决）
	}

	/**
	 * 修改文件夹信息
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateFolder(FolderRequest request, BaseResponse<String> response) {
		if (checkFolderName(Constants.UPDATE_FLG, request)) {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
			response.setStatusMsg(Constants.FOLDER_NAME_ALREADY_EXIST);
		} else {
			FtFolder oldFolder = folderMapper.selectByPrimaryKey(request.getId());
			if (request.getpFolderId() == null) {
				// 如果接受到的父id是空的话，说明就是修改操作，把空值变成原来的值就行了
				request.setpFolderId(oldFolder.getpFolderId());
			} else {
				// to-do 移动文件夹位置
			}
			String path = oldFolder.getFoldDownloadUrl();
			File oldF = new File(path);
			String rootPath = oldF.getParent();
			File newFile = new File(rootPath + File.separator + request.getName());
			oldF.renameTo(newFile);
			request.setFoldDownloadUrl(newFile.getPath());
			request.setDelFlg(Constants.DEL_FLG);
			request.setUpUser(JwtTokenUtil.getUserIdFromContext());
			request.setUpDate(new Date());
			folderMapper.updateByPrimaryKey(request);
			// 修改成功
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		}
	}

	/**
	 * 内部分享文件夹
	 */
	@Transactional(rollbackFor = Exception.class)
	public void shareFolder(ShareRequest request, BaseResponse<String> response) {
		logger.info("method: shareFolder param：" + JSONObject.toJSONString(request));
		String names[] = request.getSharePersonNames();
		// a).修改分享记录表（内部分享）
		FtFileShare record = new FtFileShare();
		Integer id = request.getShareRefId();
		record.setShareType(request.getShareType());
		record.setRefId(id);
		record.setDelFlg(Constants.String_DEL_FLG);
		record.setCrUser(JwtTokenUtil.getUserIdFromContext());
		record.setCrDate(new Date());
		shareMapper.insert(record);
		//把所有的share接受者遍历
		for (String name : names) {
			// b).修改分享用戶文件表
			FtFileUserauth shareUser = new FtFileUserauth();
			shareUser.setAuthUser(name);
			shareUser.setRefId(id);
			shareUser.setDelFlg(Constants.String_DEL_FLG);
			shareUser.setCrUser(JwtTokenUtil.getUserIdFromContext());
			shareUser.setCrDate(new Date());
			userMapper.insert(shareUser);
			// c).修改folder表，将主动的分享人文件复制到被动人那（拷贝，另外注意路径），同时记录更新
			// 存在问题子文件的记录没有在文件表中得到更新
			// 拆开做 c1).通过name把文件夹拷贝到本地 ; c2).把RefId拿出来去跟新文件夹或者文件记录，类似于删除记录的方法
			FtFolder folder = folderMapper.selectByPrimaryKey(id);
			String sourcePath = folder.getFoldDownloadUrl();
			String newPath = "D:\\directory\\share\\" + name + "\\" + JwtTokenUtil.getUserIdFromContext() + "\\"
					+ folder.getName();
			try {
				DocService.copyDir(sourcePath, newPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 拆开的方法放在外面
			FtFolder addShareFolder = new FtFolder();
			addShareFolder.setName(folder.getName());
			addShareFolder.setpFolderId(0);
			addShareFolder.setFoldDownloadUrl(newPath);
			addShareFolder.setFolderType("share");
			addShareFolder.setCrUser(JwtTokenUtil.getUserIdFromContext());
			addShareFolder.setDelFlg(Constants.DEL_FLG);
			addShareFolder.setCrDate(new Date());
			folderMapper.insert(addShareFolder);
			//在拆开的时候遇到问题，想到一种解决方法： 本地 真分享，页面记录伪分享，但是效果一样（把remark加上share，space当作pid；删除的时候删本地）
			FtFolder shareFatherFolder = new FtFolder();
			shareFatherFolder.setName(JwtTokenUtil.getUserIdFromContext());
			shareFatherFolder.setViewAuthUsers(name);
			// shareFatherFolder.setpFolderId(0);
			shareFatherFolder
					.setFoldDownloadUrl("D:\\directory\\share\\" + name + "\\" + JwtTokenUtil.getUserIdFromContext());
			shareFatherFolder.setFolderType("share");
			shareFatherFolder.setDelFlg(Constants.DEL_FLG);
			shareFatherFolder.setCrDate(new Date());
			shareFatherFolder.setCrUser(JwtTokenUtil.getUserIdFromContext());
			shareFatherFolder.setDelFlg(Constants.DEL_FLG);
			shareFatherFolder.setRemark("pretendShare");
			folderMapper.insert(shareFatherFolder);
			// 改变被分享文件夹的伪指针
			folder.setRemark("pretendShare");
			folder.setViewAuthUsers(name);
			// folder.setFolderLev(request.getShareRefId());
			folderMapper.updateByPrimaryKey(folder);
		}
		// 分享成功
		response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
	}


	/**
	 * 上传文件
	 */
	public void writeToService(MultipartFile[] multfilel, String fatherFolderName,
			BaseResponse<List<String>> response) {
		try {
			List<String> urls = new ArrayList<>();
			logger.info(multfilel);
			for (MultipartFile multfile : multfilel) {
				boolean exitFlg = false;
				logger.info("==写入服务器开始==");
				logger.info(multfile.getOriginalFilename());
				FileInputStream fis = (FileInputStream) multfile.getInputStream();
				FtFolder fatherFolder = folderMapper.selectByName(fatherFolderName);
				String fatherPath = fatherFolder.getFoldDownloadUrl();
				String fileName = multfile.getOriginalFilename();
				String fileNameArray[] = fileName.split("\\.");
				// int index = pathName.indexOf('.');
				String filePath = fatherPath + File.separator + fileName;
				File file = new File(filePath);
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();// 创建目录
				}
				if (file.exists()) {
					exitFlg = true;
				} else {
					file.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(file);// 指定文件输出数据
				int data = -1;
				while ((data = fis.read()) != -1) {
					fos.write(data);// 往要输出文件写数据
				}
				fos.close();
				fis.close();
				if (!exitFlg) {// 文件存在就添加进数据库
					com.odm.oa.dao.pojo.FtFile uploadFile = new com.odm.oa.dao.pojo.FtFile();
					uploadFile.setName(fileNameArray[0]);
					uploadFile.setFolderId(fatherFolder.getId());
					uploadFile.setFileSize(String.valueOf(multfile.getSize() / 1024) + "kb");
					uploadFile.setFileExtendName(fileNameArray[1]);
					uploadFile.setFileUrl(filePath);
					uploadFile.setDelFlg("0");
					uploadFile.setFileVersion(1);
					uploadFile.setCrUser(JwtTokenUtil.getUserIdFromContext());
					uploadFile.setCrDate(new Date());
					fileMapper.insert(uploadFile);
				}
				urls.add(filePath);
			}
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
			response.setResponseData(urls);
			logger.info("==写入成功==filePath>>" + urls);
		} catch (IOException e) {
			logger.info("==catch，写入失败==");
			logger.error(e);
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
			response.setStatusMsg("上传失败!");
			e.printStackTrace();
		}
	}

	/* 下载文件 */
	public void downloadService(HttpServletResponse res, Integer id, BaseResponse<List<String>> response) {
		FtFile file = fileMapper.selectByPrimaryKey(id);
		String originPath = file.getFileUrl();
		File originFile = new File(originPath);
		String fileName = file.getName();
		res.reset();
		res.setContentType("application/octet-stream");
		// 设置文件名
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName); //
		byte[] buffer = new byte[1024];
		FileInputStream fis = null; // 文件输入流
		BufferedInputStream bis = null;
		OutputStream os = null; // 输出流
		try {
			os = res.getOutputStream();
			fis = new FileInputStream(originFile);
			bis = new BufferedInputStream(fis);
			int data;
			while ((data = bis.read(buffer)) != -1) {
				os.write(buffer, 0, data);
			}
			os.close();
			bis.close();
		} catch (IOException e) {
			logger.info("==catch，导出失败==");
			logger.error(e);
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
			response.setStatusMsg("下载失败!");
			e.printStackTrace();
		}
	}

	/***
	 * 删除指定文件夹下所有文件
	 * 
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/***
	 * 删除文件夹
	 * 
	 * @param folderPath文件夹完整绝对路径
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 刪除文件夾下面的所有文件和子文件夾 方法2
	public static void deleteMethod(File f) {
		if (f == null) {
			return;
		} else if (f.exists()) {// 如果此抽象指定的对象存在并且不为空。
			if (f.isFile()) {
				f.delete();// 如果此抽象路径代表的是文件，直接删除。
			} else if (f.isDirectory()) {// 如果此抽象路径指代的是目录
				String[] str = f.list();// 得到目录下的所有路径
				if (str == null) {
					f.delete();// 如果这个目录下面是空，则直接删除
				} else {// 如果目录不为空，则遍历名字，得到此抽象路径的字符串形式。
					for (String st : str) {
						deleteMethod(new File(f, st));
					} // 遍历清楚所有当前文件夹里面的所有文件。
					f.delete();// 清楚文件夹里面的东西后再来清楚这个空文件夹
				}
			}
		}
	}

	// 拷贝文件夹
	public static void copyDir(String sourcePath, String newPath) throws IOException {
		File file = new File(sourcePath);
		String[] filePath = file.list();

		if (!(new File(newPath)).exists()) {
			(new File(newPath)).mkdir();
		}

		for (int i = 0; i < filePath.length; i++) {
			if ((new File(sourcePath + File.separator + filePath[i])).isDirectory()) {
				copyDir(sourcePath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
			}

			if (new File(sourcePath + File.separator + filePath[i]).isFile()) {
				copyFile(sourcePath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
			}

		}
	}

	// 拷贝文件
	public static void copyFile(String oldPath, String newPath) throws IOException {
		File oldFile = new File(oldPath);
		File file = new File(newPath);
		// 当时少加了这个，本地拷贝一直有问，没有效果但是不报错，debug发现报错了然后被try-catch捕获io异常，加上这句就好了
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();// 创建目录
		}
		// 新建文件输入流并对它进行缓冲
		FileInputStream input = new FileInputStream(oldFile);
		BufferedInputStream inBuff = new BufferedInputStream(input);
		// 新建文件输出流并对它进行缓冲
		FileOutputStream output = new FileOutputStream(file);
		BufferedOutputStream outBuff = new BufferedOutputStream(output);
		// 缓冲数组
		byte[] b = new byte[1024 * 5];
		int len;
		while ((len = inBuff.read(b)) != -1) {
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();
		// 关闭流
		inBuff.close();
		outBuff.close();
		output.close();
		input.close();
	}
	// 修改或者添加的时候判断名称是否重复
	public boolean checkFolderName(String insertOrUpdateFlg, FolderRequest request) {
		FtFolder folder = folderMapper.selectByName(request.getName());
		if (Constants.INSERT_FLG.equals(insertOrUpdateFlg)) {
			// 如果是添加文件夹，只要存在相同的就不行
			if (folder != null) {
				return true;
			}
		} else if (Constants.UPDATE_FLG.equals(insertOrUpdateFlg)) {
			// 如果是修改文件夹，那么除了自己以外不能重复
			if (folder != null && folder.getId() != request.getId()) {
					return true;
			}
		}
		return false;
	}
}
