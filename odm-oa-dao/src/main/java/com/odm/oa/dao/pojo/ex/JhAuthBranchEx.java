package com.odm.oa.dao.pojo.ex;

import java.util.List;

import com.odm.oa.dao.pojo.JhAuthBranch;

public class JhAuthBranchEx extends JhAuthBranch {

	private List<JhAuthUserEx> users;

	public List<JhAuthUserEx> getUsers() {
		return users;
	}

	public void setUsers(List<JhAuthUserEx> users) {
		this.users = users;
	}

}
