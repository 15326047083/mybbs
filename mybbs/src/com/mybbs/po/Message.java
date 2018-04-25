package com.mybbs.po;

/**
 * 私信
 * 
 * @author leiyuan
 *
 */
public class Message {
	private int id;
	private String info;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	

	public Message(int id, String info) {
		super();
		this.id = id;
		this.info = info;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", info=" + info + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
