package com.odm.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.common.utils.Constants;
import com.odm.oa.dao.pojo.JhAuthBranch;
import com.odm.oa.dao.pojo.ex.JhAuthBranchEx;
import com.odm.oa.dao.pojo.pagination.JhAuthBranchPagination;
import com.odm.oa.service.JhAuthBranchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { "部门" })
@RestController
@RequestMapping("/service/dept")
public class JhAuthBranchController {

	@Autowired
	private JhAuthBranchService branchService;

	/**
	 * 查询部门信息列表
	 * 
	 * @return
	 */
	@ApiOperation(value = "paginationBranch", notes = "add user info")
	@RequestMapping(value = "/paginationBranch", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<PageInfo<JhAuthBranchEx>> paginationBranch(
			@ApiParam("查询参数") @RequestBody JhAuthBranchPagination request) {
		// 返回参数初始化
		BaseResponse<PageInfo<JhAuthBranchEx>> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			PageInfo<JhAuthBranchEx> responseData = branchService.paginationBranch(request);
			response.setResponseData(responseData);
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 添加部门信息
	 */
	@ApiOperation(value = "insertDept", notes = "add user info")
	@RequestMapping(value = "/insertDept", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> insertDept(@ApiParam("查询参数") @RequestBody JhAuthBranch request) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			branchService.insertDept(request, response);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 修改部门信息
	 */
	@ApiOperation(value = "updateDept", notes = "add user info")
	@RequestMapping(value = "/updateDept", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> updateDept(@ApiParam("查询参数") @RequestBody JhAuthBranch request) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			branchService.updateDept(request, response);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 删除部门信息
	 */
	@ApiOperation(value = "deleteDept", notes = "add user info")
	@RequestMapping(value = "/deleteDept", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> deleteDept(@ApiParam("查询参数") @RequestBody Integer[] deptcodes) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			branchService.deleteDept(deptcodes);
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

	/**
	 * 查看部门信息
	 */
	@ApiOperation(value = "selectDept", notes = "add user info")
	@RequestMapping(value = "/selectDept", method = RequestMethod.POST, produces = { "application/json" })
	public BaseResponse<String> selectDept(@ApiParam("查询参数") @RequestBody JhAuthBranch request) {
		// 返回参数初始化
		BaseResponse<String> response = new BaseResponse<>();
		boolean valid = true;
		if (valid) {
			branchService.updateDept(request, response);
		} else {
			response.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		}
		return response;
	}

}
