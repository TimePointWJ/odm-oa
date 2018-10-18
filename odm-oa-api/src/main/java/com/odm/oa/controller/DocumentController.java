package com.odm.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.odm.oa.common.basic.controller.BasicController;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.common.utils.Constants;
import com.odm.oa.dao.pojo.FtFile;
import com.odm.oa.dao.pojo.FtFolder;
import com.odm.oa.dao.pojo.ex.FolderRequest;
import com.odm.oa.dao.pojo.ex.ShareRequest;
import com.odm.oa.dao.pojo.pagination.DocPagination;
import com.odm.oa.service.DocService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { "文件信息" })
@RestController
@RequestMapping("/service/doc")
public class DocumentController extends BasicController {
	@Autowired
	private DocService docService;

	/**
	 * 所有文件夹的查询
	 * 
	 * @param httpSession
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/folderList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<PageInfo<FtFolder>> list(HttpSession httpSession,
			@ApiParam(name = "DocPagination", value = "文件夹信息", required = true) @RequestBody DocPagination request) {
		// 返回参数初始化

		logger.info("DocumentController > getList" + JSONObject.toJSONString(request));
		BaseResponse<PageInfo<FtFolder>> response = new BaseResponse<>();
		logger.info("--------------------------------获取文件夹信息开始--------------------------------");
		PageInfo<FtFolder> responseData = docService.getPage(request);
		response.setResponseData(responseData);
		// response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		logger.info("--------------------------------获取文件夹信息结束--------------------------------");
		return response;
	}

	/**
	 * 根目录查询
	 * 
	 * @param httpSession
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showOriginDir", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<PageInfo<FtFolder>> rootList(HttpSession httpSession,
			@ApiParam(name = "DocPagination", value = "文件夹信息", required = true) @RequestBody DocPagination request) {
		// 返回参数初始化

		logger.info("DocumentController > rootList" + JSONObject.toJSONString(request));
		BaseResponse<PageInfo<FtFolder>> response = new BaseResponse<>();
		logger.info("--------------------------------获取根目录文件夹信息开始--------------------------------");
		PageInfo<FtFolder> responseData = docService.getRootDir(request);
		response.setResponseData(responseData);
		// response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		logger.info("--------------------------------获取根目录文件夹信息结束--------------------------------");
		return response;
	}

	/**
	 * 获取所选文件夹的所有子文件信息
	 * 
	 * @param httpSession
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findCFile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<PageInfo<FtFile>> cFileList(HttpSession httpSession,
			@ApiParam(name = "id", value = "父文件夹id", required = true) @RequestBody FtFolder ff) {
		// 返回参数初始化
		logger.info("DocController > getCFile" + ff.getId());
		BaseResponse<PageInfo<FtFile>> response = new BaseResponse<>();
		logger.info("--------------------------------搜索子文件信息开始--------------------------------");
		PageInfo<FtFile> responseData = docService.getCFile(ff.getId());
		response.setResponseData(responseData);
		// response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		logger.info("--------------------------------搜索子文件信息结束--------------------------------");
		return response;
	}

	/**
	 * 获取所选文件夹的所有子文件夹信息
	 * 
	 * @param httpSession
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findCFolder", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<PageInfo<FtFolder>> cFolderList(HttpSession httpSession,
			@ApiParam(name = "id", value = "父文件夹id", required = true) @RequestBody FtFolder ff) {
		// 返回参数初始化
		logger.info("DocController > getCFolder" + ff.getId());
		BaseResponse<PageInfo<FtFolder>> response = new BaseResponse<>();
		logger.info("--------------------------------搜索子文件夹开始--------------------------------");
		PageInfo<FtFolder> responseData = docService.getCFolder(ff.getId());
		response.setResponseData(responseData);
		// response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		logger.info("--------------------------------搜索子文件 结束--------------------------------");
		return response;
	}

	/**
	 * 新建文件夹
	 */
	@ApiOperation(value = "createFolder", notes = "add folder info")
	@RequestMapping(value = "/createFolder", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> insertGoods(@ApiParam("查询参数") @RequestBody FolderRequest request) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			docService.createFolder(request, response);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 删除文件夹
	 */
	@ApiOperation(value = "deleteFolder", notes = "delete folder info")
	@RequestMapping(value = "/deleteFolder", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> deleteFolder(@ApiParam("查询参数") @RequestBody FtFolder f) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			docService.deleteFolder(f.getId());
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 删除文件
	 */
	@ApiOperation(value = "deleteFile", notes = "delete file info")
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> deleteFile(@ApiParam("查询参数") @RequestBody FtFolder f) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			docService.deleteFile(f.getId());
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 修改文件夹信息
	 */
	@ApiOperation(value = "updateFolder", notes = "update folder info")
	@RequestMapping(value = "/updateFolder", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> updateGoods(@ApiParam("查询参数") @RequestBody FolderRequest request) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			docService.updateFolder(request, response);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param fatherFolderName
	 * @return
	 */
	@ApiOperation(value = "上传文件", notes = "上传文件")
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public BaseResponse<List<String>> upload(@RequestParam("file") MultipartFile[] file,
			@RequestParam("fatherFolderName") String fatherFolderName) {
		// 返回参数初始化
		BaseResponse<List<String>> response = new BaseResponse<List<String>>();
		docService.writeToService(file, fatherFolderName, response);
		return response;
	}

	/**
	 * 下载文件
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "下载文件", notes = "下载文件")
	@RequestMapping(value = "/download", method = RequestMethod.POST, produces = { "application/json;charset=utf-8" })
	public BaseResponse<List<String>> download(HttpServletResponse res, @RequestParam Integer id) {
		BaseResponse<List<String>> response = new BaseResponse<List<String>>();
		docService.downloadService(res, id, response);
		return null;
	}

	/**
	 * 分享后台api
	 */
	@ApiOperation(value = "shareFolder", notes = "share folder info")
	@RequestMapping(value = "/shareFolder", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> shareFolder(@ApiParam("查询参数") @RequestBody ShareRequest request) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			docService.shareFolder(request, response);
			//docService.shareFolderRecord(request.getShareRefId(), request.getSharePersonNames());
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 分享根目录查询
	 * 
	 * @param httpSession
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showShareOriginDir", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<PageInfo<FtFolder>> shareList(HttpSession httpSession,
			@ApiParam(name = "DocPagination", value = "文件夹信息", required = true) @RequestBody DocPagination request) {
		// 返回参数初始化

		logger.info("DocumentController > rootList" + JSONObject.toJSONString(request));
		BaseResponse<PageInfo<FtFolder>> response = new BaseResponse<>();
		logger.info("--------------------------------获取根目录文件夹信息开始--------------------------------");
		PageInfo<FtFolder> responseData = docService.getShareRootDir(request);
		response.setResponseData(responseData);
		// response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		logger.info("--------------------------------获取根目录文件夹信息结束--------------------------------");
		return response;
	}

	/**
	 * 获取所选文件夹的所有子文件夹信息
	 * 
	 * @param httpSession
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findShareCFolder", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<PageInfo<FtFolder>> cShareFolderList(HttpSession httpSession,
			@ApiParam(name = "id", value = "父文件夹id", required = true) @RequestBody FtFolder ff) {
		// 返回参数初始化
		logger.info("DocController > getCFolder" + ff.getId());
		BaseResponse<PageInfo<FtFolder>> response = new BaseResponse<>();
		logger.info("--------------------------------搜索子文件夹开始--------------------------------");
		PageInfo<FtFolder> responseData = docService.getShareCFolder(ff.getId());
		response.setResponseData(responseData);
		// response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		logger.info("--------------------------------搜索子文件 结束--------------------------------");
		return response;
	}
}
