package com.odm.oa.dao.pojo.pagination;

public class DocPagination extends PaginationBase {
	private String name;
	private int id;
	private String crUser;
	private String folderType;
	private String remark;
	private String viewUserName;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFolderType() {
		return folderType;
	}

	public void setFolderType(String folderType) {
		this.folderType = folderType;
	}

	public String getCrUser() {
		return crUser;
	}

	public void setCrUser(String crUser) {
		this.crUser = crUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getViewUserName() {
		return viewUserName;
	}

	public void setViewUserName(String viewUserName) {
		this.viewUserName = viewUserName;
	}

}
