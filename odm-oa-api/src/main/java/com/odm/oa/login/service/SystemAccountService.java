package com.odm.oa.login.service;

import com.odm.oa.common.basic.response.BaseResponse;
import com.odm.oa.dao.pojo.JhAuthUser;
import com.odm.oa.login.response.LoginToken;
import com.odm.oa.login.response.UserInfo;

/**
 * @author xiel
 *
 */
public interface SystemAccountService {
	/**
	 * @param param
	 * @return
	 */
	BaseResponse<LoginToken> validateLogin(JhAuthUser param);

	/**
	 * @param param
	 * @return
	 */
	BaseResponse<LoginToken> selectUserByUserName(String userName);

	UserInfo getUserInfoById(String userId);
}
