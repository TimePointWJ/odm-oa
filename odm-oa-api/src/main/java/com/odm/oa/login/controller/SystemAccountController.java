package com.odm.oa.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.odm.oa.common.basic.controller.BasicController;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.common.utils.JwtTokenUtil;
import com.odm.oa.login.response.UserInfo;
import com.odm.oa.login.service.SystemAccountService;

/**
 * 系统用户管理
 * 
 * @author xiel
 *
 */
@RestController
@RequestMapping("/service/user")
public class SystemAccountController extends BasicController {

	private static Logger logger = LogManager.getLogger(SystemAccountController.class);
	@Autowired
	private SystemAccountService accountService;

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = { "application/json; charset=utf-8" })
	public BaseResponse<UserInfo> getUserInfo(HttpServletRequest request,
			@RequestParam(name = "token", required = true) String token) {
		logger.info("method start");
		logger.info("url:/service/user/info" + token);
		String name = JwtTokenUtil.getUsernameFromToken(token);
		logger.info("token" + token);
		// 初始化分业数据
		BaseResponse<UserInfo> result = new BaseResponse<>();
		// 一览数据设置
		result.setResponseData(accountService.getUserInfoById(name));

		logger.info("Response data" + JSONObject.toJSONString(result));
		logger.info("method end");
		// 返回结果
		return result;
	}

}