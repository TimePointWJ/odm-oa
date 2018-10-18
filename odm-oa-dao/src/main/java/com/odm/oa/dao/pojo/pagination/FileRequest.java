package com.odm.oa.dao.pojo.pagination;

//import org.springframework.web.multipart.MultipartFile;

public class FileRequest {
	// private MultipartFile[] file;
	private String fatherFolderName;

	// public MultipartFile[] getFile() {
	// return file;
	// }

	// public void setFile(MultipartFile[] file) {
	// this.file = file;
	// }

	public String getFatherFolderName() {
		return fatherFolderName;
	}

	public void setFatherFolderName(String fatherFolderName) {
		this.fatherFolderName = fatherFolderName;
	}

}
