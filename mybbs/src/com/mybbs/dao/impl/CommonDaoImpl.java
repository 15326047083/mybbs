package com.mybbs.dao.impl;

import com.mybbs.dao.CommonDao;

public class CommonDaoImpl<T> implements CommonDao<T> {

	public void newCommon(T common) {
		// TODO Auto-generated method stub
		System.out.println(common.getClass().getFields());
		System.out.println(common.getClass().getDeclaredFields());
		System.out.println(common.getClass().getSimpleName());
		Class clazz = Class.forName("");// 根据类名获得其对应的Class对象 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
		Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
		for (Field f : fields) {
			System.out.println(f.getType().getName());// 打印每个属性的类型名字
		}
	}

	@Override
	public void updateCommon(T common) {
		// TODO Auto-generated method stub

	}

}
