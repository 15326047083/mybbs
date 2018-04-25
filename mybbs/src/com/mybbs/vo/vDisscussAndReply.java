package com.mybbs.vo;

public class vDisscussAndReply {
	private int id;
	private int userId;
	private int discussId;
	private int postId;
	private String userName;
	private String info;
	private String time;
	@Override
	public String toString() {
		return "vDisscussAndReply [id=" + id + ", userId=" + userId + ", discussId=" + discussId + ", postId=" + postId
				+ ", userName=" + userName + ", info=" + info + ", time=" + time + "]";
	}
	public vDisscussAndReply(int id, int userId, int discussId, int postId, String userName, String info, String time) {
		super();
		this.id = id;
		this.userId = userId;
		this.discussId = discussId;
		this.postId = postId;
		this.userName = userName;
		this.info = info;
		this.time = time;
	}
	
	public vDisscussAndReply() {
		
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
	public int getDiscussId() {
		return discussId;
	}
	public void setDiscussId(int discussId) {
		this.discussId = discussId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
}
