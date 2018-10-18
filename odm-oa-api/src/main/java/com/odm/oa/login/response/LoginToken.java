package com.odm.oa.login.response;

import com.odm.oa.dao.pojo.JhAuthUser;

import lombok.Getter;
import lombok.Setter;

/**
 * create LoginToken by HJR
 * 
 * 2017/12/9  下午23:30
 */
@Getter
@Setter
public class LoginToken extends JhAuthUser{
    
	private String token;
	private String roleId;
}
