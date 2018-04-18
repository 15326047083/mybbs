package com.mybbs.po;

import java.util.Date;

/**
 * 帖子
 * 
 * @author leiyuan
 *
 */
public class Post {

	private int id;
	private int userId;
	private int plateId;
	private String title;
	private String info;
	private Date time;
	private String flag;// 是否被管理员删除 0为没删 1为以删除
	private int photonum;// 照片数量 默认-1；
	public Post(int id, int userId, int plateId, String title, String info, Date time, String flag, int photonum) {
		//super();
		this.id = id;
		this.userId = userId;
		this.plateId = plateId;
		this.title = title;
		this.info = info;
		this.time = time;
		this.flag = flag;
		this.photonum = photonum;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", plateId=" + plateId + ", title=" + title + ", info=" + info
				+ ", time=" + time + ", flag=" + flag + ", photonum=" + photonum + "]";
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getPhotonum() {
		return photonum;
	}
	public void setPhotonum(int photonum) {
		this.photonum = photonum;
	}
	

}
