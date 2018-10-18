package com.odm.oa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.common.utils.Constants;
import com.odm.oa.common.utils.JwtTokenUtil;
import com.odm.oa.dao.mapper.JhAuthBranchMapper;
import com.odm.oa.dao.mapper.JhAuthUserMapper;
import com.odm.oa.dao.pojo.JhAuthBranch;
import com.odm.oa.dao.pojo.ex.JhAuthBranchEx;
import com.odm.oa.dao.pojo.pagination.JhAuthBranchPagination;

@Service
public class JhAuthBranchService {

	@Autowired
	private JhAuthBranchMapper branchMapper;
	@Autowired
	private JhAuthUserMapper userMapper;

	/**
	 * 查询部门信息列表
	 */
	public PageInfo<JhAuthBranchEx> paginationBranch(JhAuthBranchPagination request) {
		PageHelper.startPage(request.getPageNum(), request.getPageSize());
		// 获取员工列表信息
		List<JhAuthBranchEx> list = branchMapper.paginationBranch(request);
		// 查询部门的员工列表
		for (JhAuthBranchEx bEx : list) {
			bEx.setUsers(userMapper.selectUsersByDeptCode(bEx.getDeptCode()));
		}
		PageInfo<JhAuthBranchEx> pageInfo = new PageInfo<JhAuthBranchEx>(list);
		return pageInfo;
	}

	/**
	 * 添加部门
	 */
	@Transactional(rollbackFor = Exception.class)
	public void insertDept(JhAuthBranch request, BaseResponse<String> response) {
		if (checkDeptName(Constants.INSERT_FLG, request)) {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
			// response.setStatusMsg(Constants.DEPT_NAME_ALREADY_EXIST);
		} else {
			// request.setDelFlg(Constants.DEL_FLG);
			request.setDelFlg("0");
			request.setCrUser(JwtTokenUtil.getUserIdFromContext());// 新员工自己添加的
			request.setCrDate(new Date());
			branchMapper.insert(request);
			// 添加成功
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		}
	}

	/**
	 * 修改部门
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateDept(JhAuthBranch request, BaseResponse<String> response) {
		if (checkDeptName(Constants.UPDATE_FLG, request)) {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
			// response.setStatusMsg(Constants.DEPT_NAME_ALREADY_EXIST);
		} else {
			request.setUpUser(JwtTokenUtil.getUserIdFromContext());
			request.setUpDate(new Date());
			branchMapper.updateByPrimaryKey(request);
			// 修改成功
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		}
	}

	/**
	 * 删除部门
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteDept(Integer[] deptcodes) {
		for (Integer deptcode : deptcodes) {
			JhAuthBranch dept = branchMapper.selectByPrimaryKey(deptcode);
			// dept.setDelFlg(Constants.IS_DELETE);
			dept.setDelFlg("1");
			dept.setUpUser(JwtTokenUtil.getUserIdFromContext());
			dept.setUpDate(new Date());
			branchMapper.updateByPrimaryKey(dept);
		}
	}

	public boolean checkDeptName(String insertOrUpdateFlg, JhAuthBranch request) {
		JhAuthBranch dept = branchMapper.selectByName(request.getDepeName());
		if (Constants.INSERT_FLG.equals(insertOrUpdateFlg)) {
			// 如果是添加，只要存在相同就不行，
			if (dept != null) {
				return true;
			}
		} else if (Constants.UPDATE_FLG.equals(insertOrUpdateFlg)) {
			// 如果是修改，那就除了自己以外，如果查询的dept不是他本身，就是别人的重复
			if (dept != null && dept.getDeptCode() != request.getDeptCode()) {
				return true;
			}
		}
		return false;
	}

}
