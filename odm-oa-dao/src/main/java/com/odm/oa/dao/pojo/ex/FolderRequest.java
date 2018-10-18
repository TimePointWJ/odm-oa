package com.odm.oa.dao.pojo.ex;

import com.odm.oa.dao.pojo.FtFolder;

public class FolderRequest extends FtFolder {
	String pFolderName;
	// String remark; // person：个人 share：共享 3：company



	public String getpFolderName() {
		return pFolderName;
	}

	public void setpFolderName(String pFolderName) {
		this.pFolderName = pFolderName;
	}

}
