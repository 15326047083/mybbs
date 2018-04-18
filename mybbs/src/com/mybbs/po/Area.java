package com.mybbs.po;

/**
 * 区
 * 
 * @author leiyuan
 *
 */
public class Area {

	private int id;
	private String name;
	private String info;
	private int plateNum;

	public Area() {

	}

	public Area(int id, String name, String info, int plateNum) {
		// super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.setPlateNum(plateNum);
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", info=" + info + "]";
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

	public int getPlateNum() {
		return plateNum;
	}

	public void setPlateNum(int plateNum) {
		this.plateNum = plateNum;
	}

}
