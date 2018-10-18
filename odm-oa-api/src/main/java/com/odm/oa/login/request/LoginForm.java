package com.odm.oa.login.request;

/**
 * create LoginForm by HJR
 * 
 * 2017/12/9  下午23:30
 */
public class LoginForm {

    private String username;// 用户名
    
    private String password;// 密碼
    
    private String code;// 验证码

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
}
