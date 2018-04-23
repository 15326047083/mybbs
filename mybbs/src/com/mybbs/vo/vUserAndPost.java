package com.mybbs.vo;

public class vUserAndPost {
	private int id;
	private int userId;
	private String userName;
	private String plateName;
	private int plateId;
	private String title;
	private String info;
	private String time;

	private int photoNum;// 照片数量 默认-1；
	
	public vUserAndPost() {
		
	}

	@Override
	public String toString() {
		return "vUserAndPost [id=" + id + ", userId=" + userId + ", userName=" + userName + ", plateId=" + plateId
				+ ", title=" + title + ", info=" + info + ", time=" + time + ", photoNum=" + photoNum + "]";
	}

	public vUserAndPost(int id, int userId, String userName, int plateId, String title, String info, String time,
			int photoNum,String plateName) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.plateId = plateId;
		this.title = title;
		this.info = info;
		this.time = time;
		this.photoNum = photoNum;
		this.plateName=plateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	
	
	
}
