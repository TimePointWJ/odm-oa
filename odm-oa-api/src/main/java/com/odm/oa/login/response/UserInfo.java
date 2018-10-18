package com.odm.oa.login.response;

public class UserInfo {

    private String[] role;
    private String name;
    private String avatar;
    private String introduction;
    private String schoolDataRole;
    private String gradeDataRole;
    private String classDataRole;
    
    public String getSchoolDataRole() {
		return schoolDataRole;
	}

	public void setSchoolDataRole(String schoolDataRole) {
		this.schoolDataRole = schoolDataRole;
	}

	public String getGradeDataRole() {
		return gradeDataRole;
	}

	public void setGradeDataRole(String gradeDataRole) {
		this.gradeDataRole = gradeDataRole;
	}

	public String getClassDataRole() {
		return classDataRole;
	}

	public void setClassDataRole(String classDataRole) {
		this.classDataRole = classDataRole;
	}

	public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
