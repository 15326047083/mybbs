package com.mybbs.po;

import java.util.Date;

/**
 * 评论
 * 
 * @author leiyuan
 *
 */
public class Discuss {

	private int id;
	private int userId;
	private int postId;
	private String info;
	private Date time;
	private int photoNum;

	public Discuss() {

	}

	public Discuss(int id, int userId, int postId, String info, Date time, int photoNum) {
		// super();
		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.info = info;
		this.time = time;
		this.photoNum = photoNum;
	}

	@Override
	public String toString() {
		return "Discuss [id=" + id + ", userId=" + userId + ", postId=" + postId + ", info=" + info + ", time=" + time
				+ ", photoNum=" + photoNum + "]";
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

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}

}
