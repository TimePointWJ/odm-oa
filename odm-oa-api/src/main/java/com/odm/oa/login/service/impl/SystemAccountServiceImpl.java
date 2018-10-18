package com.odm.oa.login.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.common.utils.Constants;
import com.odm.oa.common.utils.JwtTokenUtil;
import com.odm.oa.dao.mapper.JhAuthUserMapper;
import com.odm.oa.dao.pojo.JhAuthUser;
import com.odm.oa.dao.pojo.ex.JhAuthUserEx;
import com.odm.oa.login.response.LoginToken;
import com.odm.oa.login.response.UserInfo;
import com.odm.oa.login.service.SystemAccountService;

/**
 * create UserService by HJR 用户信息管理service
 * 
 * 2017/12/9 下午23:30
 */
@Service
public class SystemAccountServiceImpl implements SystemAccountService {

	private static Logger logger = LogManager.getLogger(SystemAccountServiceImpl.class);

	@Autowired
	private JhAuthUserMapper userMapper;

	/**
	 * 获取用户信息，并判断用户是否存在，一家密码是否正确
	 * 
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public BaseResponse<LoginToken> validateLogin(JhAuthUser param) {

		logger.info("method: validateLogin param：" + JSON.toJSONString(param));

		// 返回参数初始化
		BaseResponse<LoginToken> res = new BaseResponse<>();
		try {
			// 通过用户名查询用户信息
			JhAuthUserEx user = userMapper.selectUserByUserName(param.getUserName());
			// 判断渠道的用户信息是否为空
			if (user == null) {
				// 返回错误信息
				res.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
				res.setStatusMsg("用户名或密码不正确");
			} else {
				logger.info("通过用户名查询用户信息：" + JSON.toJSONString(user));
				// 将用户信息转换成JSON
				String userStr = JSON.toJSONString(user);
				// 将JSON转换成返回参数中的对象
				LoginToken token = JSON.parseObject(userStr, LoginToken.class);
				String pwd = user.getUserPass();
				// 判断用户密码是否正确
				if (!pwd.equals(param.getUserPass())) {
					// 返回错误信息
					res.setStatusCode(201);
					res.setStatusMsg("用户名或密码不正确");
				} else {
					// 获取并设置token信息到返回参数中
					// String tokenStr =
					// JwtTokenUtil.generateToken(param.getAccount());
					String tokenStr = JwtTokenUtil.generateToken(param.getUserName());
					logger.info(" 获取并设置tokentokenStr:" + tokenStr);
					token.setToken(tokenStr);
					token.setRoleId(user.getRoleCode());
					res.setResponseData(token);

					// setRedis(param);
					// redis.set(tokenStr, Constants.REDIS_SESSION, param.getUserId());
				}
			}
		} catch (Exception e) {
			logger.error("通过用户名查询用户信息异常", e);
			// 返回错误信息
			res.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED_999);
			res.setStatusMsg("后台系统异常");
		}
		// 返回最终结果
		return res;
	}

	/**
	 * 根据账号获取用户
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public BaseResponse<LoginToken> selectUserByUserName(String userName) {
		BaseResponse<LoginToken> result = new BaseResponse<>();
		// try {
		// JhAuthUser sys = userMapper.selectUserByUserName(userName);
		// if (sys != null) {
		// String userStr = JSON.toJSONString(sys);
		// LoginToken token = JSON.parseObject(userStr, LoginToken.class);
		// String tokenStr = JwtTokenUtil.generateToken(sys.getUserName());
		// logger.info(" 获取并设置tokentokenStr:" + tokenStr);
		// token.setToken(tokenStr);
		// result.setResponseData(token);
		// result.setStatusCode(Constants.RESPONSE_STATUS_CODE_SUCCESS);
		// } else
		// result.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		// } catch (Exception e) {
		// logger.error("查询用户信息异常", e);
		// result.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);
		// }
		return result;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public UserInfo getUserInfoById(String userId) {
		logger.info("用户ID：" + userId);
		UserInfo info = new UserInfo();
		info.setName(userId);
		// 第一，现根据用户取角色，然后根据角色取权限，把全部权限拿到之后，权限去重
		// 第二，在代码中直接一步实现，去重也实现
		// List<String> privilegeList =
		// userMapper.selectPrivilegeByUsrId(userId);
		// String[] roleList = privilegeList.toArray(new
		// String[privilegeList.size()]);
		String[] roleList = new String[] { "admin" };
		info.setRole(roleList);
		return info;
	}
}