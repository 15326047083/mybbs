package com.mybbs.po;

import java.util.Date;

/**
 * 回复
 * 
 * @author leiyuan
 *
 */
public class Reply {

	private int id;
	private int userId;
	private int discussId;
	private String info;
	private Date time;

	public Reply() {

	}

	public Reply(int id, int userId, int discussId, String info, Date time) {
		// super();
		this.id = id;
		this.userId = userId;
		this.discussId = discussId;
		this.info = info;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", userId=" + userId + ", discussId=" + discussId + ", info=" + info + ", time="
				+ time + "]";
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

}
