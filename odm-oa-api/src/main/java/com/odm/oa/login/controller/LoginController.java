package com.odm.oa.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.odm.oa.common.basic.controller.BasicController;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.dao.pojo.JhAuthUser;
import com.odm.oa.login.request.LoginForm;
import com.odm.oa.login.response.LoginToken;
import com.odm.oa.login.service.SystemAccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author xiel
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController extends BasicController{

    @Autowired
    private SystemAccountService userService;

    @ResponseBody
	@ApiOperation(value = "登录", httpMethod = "POST", response = LoginForm.class, notes = "Login controller")
    @RequestMapping( value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public BaseResponse<LoginToken> login(HttpSession httpSession,
			@ApiParam(name = "loginForm", value = "login user info", required = true) @RequestBody LoginForm loginForm) {
    	logger.info("method start");
    	BaseResponse<LoginToken> result = new BaseResponse<>();
    	if (StringUtils.isEmpty(loginForm.getUsername())) {
    		result.setStatusCode(201);
    		result.setStatusMsg("用户名不得为空");
			return result;
		}
		if (StringUtils.isEmpty(loginForm.getPassword())) {
			result.setStatusCode(201);
    		result.setStatusMsg("密码不得为空");
			return result;
		}

		JhAuthUser param = new JhAuthUser();
		param.setUserName(loginForm.getUsername());
		param.setUserPass(loginForm.getPassword());
		result = userService.validateLogin(param);

		logger.info("method end");
        return result;
    }
}
