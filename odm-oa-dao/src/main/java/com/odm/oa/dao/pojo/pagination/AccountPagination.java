package com.odm.oa.dao.pojo.pagination;

public class AccountPagination extends PaginationBase {

	private String userIdSearch;// 查询条件用户账号

	private String postNameSearch;// 查询条件用户职务

	private String nameSearch;// 查询条件用户姓名

	private String mobilePhoneSearch;// 查询条件用户手机号码

	private String accountKbnSearch;// 查询条件用户账号类别

	private String name;// 用户姓名

	private String postName;// 用户职务

	private String roleTypeSearch;// 用户职务类型

	public String getUserIdSearch() {
		return userIdSearch;
	}

	public void setUserIdSearch(String userIdSearch) {
		this.userIdSearch = userIdSearch;
	}

	public String getPostNameSearch() {
		return postNameSearch;
	}

	public void setPostNameSearch(String postNameSearch) {
		this.postNameSearch = postNameSearch;
	}

	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}

	public String getMobilePhoneSearch() {
		return mobilePhoneSearch;
	}

	public void setMobilePhoneSearch(String mobilePhoneSearch) {
		this.mobilePhoneSearch = mobilePhoneSearch;
	}

	public String getAccountKbnSearch() {
		return accountKbnSearch;
	}

	public void setAccountKbnSearch(String accountKbnSearch) {
		this.accountKbnSearch = accountKbnSearch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getRoleTypeSearch() {
		return roleTypeSearch;
	}

	public void setRoleTypeSearch(String roleTypeSearch) {
		this.roleTypeSearch = roleTypeSearch;
	}

}
