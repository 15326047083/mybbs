package com.mybbs.po;

/**
 * 板块
 * 
 * @author leiyuan
 *
 */
public class Plate {

	private int id;
	private String name;
	private String info;
	private int areaId;
	private int postNum;

	public Plate() {

	}

	@Override
	public String toString() {
		return "Plate [id=" + id + ", name=" + name + ", info=" + info + ", areaId=" + areaId + ", postNum=" + postNum
				+ "]";
	}

	public Plate(int id, String name, String info, int areaId, int postNum) {
		// super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.areaId = areaId;
		this.postNum = postNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getpostNum() {
		return postNum;
	}

	public void setpostNum(int plateNum) {
		this.postNum = plateNum;
	}

}
