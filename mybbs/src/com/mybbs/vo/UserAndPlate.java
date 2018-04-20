package com.mybbs.vo;

public class UserAndPlate {
	private int userId;
	private String userName;
	private String email;
	private int plateId;
	private String plateName;
	private String info;
	private int areaId;
	private int postNum;
	
	public UserAndPlate(){
		
	}
	
	

	public UserAndPlate(int userId, String userName, String email, int plateId, String plateName, String info,
			int areaId, int postNum) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.plateId = plateId;
		this.plateName = plateName;
		this.info = info;
		this.areaId = areaId;
		this.postNum = postNum;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	@Override
	public String toString() {
		return "UserAndPlate [userId=" + userId + ", userName=" + userName + ", email=" + email + ", plateId=" + plateId
				+ ", plateName=" + plateName + ", info=" + info + ", areaId=" + areaId + ", postNum=" + postNum + "]";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPlateId() {
		return plateId;
	}
	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	
}
