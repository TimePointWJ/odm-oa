package com.odm.oa.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CommEntityUtils {
	/**
	 * insert时设值共通属性，delflg，createId，creatTime,version
	 */
	public static Object insertCommEntity(Class<?> clazz, Object object) throws Exception {
		List<Field> child = Arrays.asList(clazz.getDeclaredFields());
		List<Field> parent = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
		List<Field> fields = new ArrayList<>(child);
		List<Field> parentFields = new ArrayList<>(parent);
		fields.addAll(parentFields);
		for (Field field : fields) {
			String name = field.getName();
			if (name == null) {
				continue;
			}
			String setMethodStr = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
			Method setMethod = clazz.getMethod(setMethodStr, new Class[] { field.getType() });
			PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
			Method getMethod = pd.getReadMethod();
			// 设值delFlg为false
			if (name != null && Constants.DEL_FLG_STR.equals(name)) {
				setMethod.invoke(object, Constants.DEL_FLG);
			} else if (name != null && Constants.CREATE_ID_STR.equals(name)) {
				setMethod.invoke(object, JwtTokenUtil.getUserIdFromContext());
			} else if (name != null && Constants.CREATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			} else if (name != null && Constants.VERSION_STR.equals(name)) {
				int version = 0;
				if (getMethod.invoke(object) != null) {
					version = (int) getMethod.invoke(object);
				}
				setMethod.invoke(object, version + 1);
			} else if (name != null && Constants.UPDATE_ID_STR.equals(name)) {
				setMethod.invoke(object, JwtTokenUtil.getUserIdFromContext());
			} else if (name != null && Constants.UPDATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			}
		}
		return object;
	}

	/**
	 * update时设值共通属性，delflg，updateId，updateTime,version
	 */
	public static Object updateCommEntity(Class<?> clazz, Object object) throws Exception {
		List<Field> child = Arrays.asList(clazz.getDeclaredFields());
		List<Field> parent = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
		List<Field> fields = new ArrayList<>(child);
		List<Field> parentFields = new ArrayList<>(parent);
		fields.addAll(parentFields);
		for (Field field : fields) {
			String name = field.getName();
			if (name == null) {
				continue;
			}
			String setMethodStr = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
			Method setMethod = clazz.getMethod(setMethodStr, new Class[] { field.getType() });
			PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
			Method getMethod = pd.getReadMethod();
			// 设值delFlg为false
			if (name != null && Constants.DEL_FLG_STR.equals(name)) {
				setMethod.invoke(object, Constants.DEL_FLG);
			} else if (name != null && Constants.UPDATE_ID_STR.equals(name)) {
				setMethod.invoke(object, JwtTokenUtil.getUserIdFromContext());
			} else if (name != null && Constants.UPDATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			} else if (name != null && Constants.VERSION_STR.equals(name)) {
				int version = 0;
				if (getMethod.invoke(object) != null) {
					version = (int) getMethod.invoke(object);
				}
				setMethod.invoke(object, version + 1);
			}
		}
		return object;
	}

	/**
	 * delete时设值共通属性，delflg，updateId，updateTime,version
	 */
	public static Object deleteCommEntity(Class<?> clazz, Object object) throws Exception {
		List<Field> child = Arrays.asList(clazz.getDeclaredFields());
		List<Field> parent = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
		List<Field> fields = new ArrayList<>(child);
		List<Field> parentFields = new ArrayList<>(parent);
		fields.addAll(parentFields);
		for (Field field : fields) {
			String name = field.getName();
			if (name == null) {
				continue;
			}
			String setMethodStr = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
			Method setMethod = clazz.getMethod(setMethodStr, new Class[] { field.getType() });
			PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
			Method getMethod = pd.getReadMethod();
			// 设值delFlg为true
			if (name != null && Constants.DEL_FLG_STR.equals(name)) {
				setMethod.invoke(object, Constants.IS_DELETE);
			} else if (name != null && Constants.UPDATE_ID_STR.equals(name)) {
				setMethod.invoke(object, JwtTokenUtil.getUserIdFromContext());
			} else if (name != null && Constants.UPDATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			} else if (name != null && Constants.VERSION_STR.equals(name)) {
				int version = 0;
				if (getMethod.invoke(object) != null) {
					version = (int) getMethod.invoke(object);
				}
				setMethod.invoke(object, version + 1);
			}
		}
		return object;
	}

	/**
	 * insert时设值共通属性，delflg，createId，creatTime,version
	 */
	public static Object insertCommEntityNoLogin(Class<?> clazz, Object object) throws Exception {
		List<Field> child = Arrays.asList(clazz.getDeclaredFields());
		List<Field> parent = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
		List<Field> fields = new ArrayList<>(child);
		List<Field> parentFields = new ArrayList<>(parent);
		fields.addAll(parentFields);
		for (Field field : fields) {
			String name = field.getName();
			if (name == null) {
				continue;
			}
			String setMethodStr = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
			Method setMethod = clazz.getMethod(setMethodStr, new Class[] { field.getType() });
			PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
			Method getMethod = pd.getReadMethod();
			// 设值delFlg为false
			if (name != null && Constants.DEL_FLG_STR.equals(name)) {
				setMethod.invoke(object, Constants.DEL_FLG);
			} else if (name != null && Constants.CREATE_ID_STR.equals(name)) {
				setMethod.invoke(object, Constants.NO_LOGIN_USER_ID);
			} else if (name != null && Constants.CREATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			} else if (name != null && Constants.VERSION_STR.equals(name)) {
				int version = 0;
				if (getMethod.invoke(object) != null) {
					version = (int) getMethod.invoke(object);
				}
				setMethod.invoke(object, version + 1);
			} else if (name != null && Constants.UPDATE_ID_STR.equals(name)) {
				setMethod.invoke(object, Constants.NO_LOGIN_USER_ID);
			} else if (name != null && Constants.UPDATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			}
		}
		return object;
	}

	/**
	 * update时设值共通属性，delflg，updateId，updateTime,version
	 */
	public static Object updateCommEntityNoLogin(Class<?> clazz, Object object) throws Exception {
		List<Field> child = Arrays.asList(clazz.getDeclaredFields());
		List<Field> parent = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
		List<Field> fields = new ArrayList<>(child);
		List<Field> parentFields = new ArrayList<>(parent);
		fields.addAll(parentFields);
		for (Field field : fields) {
			String name = field.getName();
			if (name == null) {
				continue;
			}
			String setMethodStr = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
			Method setMethod = clazz.getMethod(setMethodStr, new Class[] { field.getType() });
			PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
			Method getMethod = pd.getReadMethod();
			// 设值delFlg为false
			if (name != null && Constants.DEL_FLG_STR.equals(name)) {
				setMethod.invoke(object, Constants.DEL_FLG);
			} else if (name != null && Constants.UPDATE_ID_STR.equals(name)) {
				setMethod.invoke(object, Constants.NO_LOGIN_USER_ID);
			} else if (name != null && Constants.UPDATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			} else if (name != null && Constants.VERSION_STR.equals(name)) {
				int version = 0;
				if (getMethod.invoke(object) != null) {
					version = (int) getMethod.invoke(object);
				}
				setMethod.invoke(object, version + 1);
			}
		}
		return object;
	}

	/**
	 * delete时设值共通属性，delflg，updateId，updateTime,version
	 */
	public static Object deleteCommEntityNoLogin(Class<?> clazz, Object object) throws Exception {
		List<Field> child = Arrays.asList(clazz.getDeclaredFields());
		List<Field> parent = Arrays.asList(clazz.getSuperclass().getDeclaredFields());
		List<Field> fields = new ArrayList<>(child);
		List<Field> parentFields = new ArrayList<>(parent);
		fields.addAll(parentFields);
		for (Field field : fields) {
			String name = field.getName();
			if (name == null) {
				continue;
			}
			String setMethodStr = "set" + name.toUpperCase().substring(0, 1) + name.substring(1);
			Method setMethod = clazz.getMethod(setMethodStr, new Class[] { field.getType() });
			PropertyDescriptor pd = new PropertyDescriptor(name, clazz);
			Method getMethod = pd.getReadMethod();
			// 设值delFlg为true
			if (name != null && Constants.DEL_FLG_STR.equals(name)) {
				setMethod.invoke(object, Constants.IS_DELETE);
			} else if (name != null && Constants.UPDATE_ID_STR.equals(name)) {
				setMethod.invoke(object, Constants.NO_LOGIN_USER_ID);
			} else if (name != null && Constants.UPDATE_TIME_STR.equals(name)) {
				setMethod.invoke(object, new Date());
			} else if (name != null && Constants.VERSION_STR.equals(name)) {
				int version = 0;
				if (getMethod.invoke(object) != null) {
					version = (int) getMethod.invoke(object);
				}
				setMethod.invoke(object, version + 1);
			}
		}
		return object;
	}
}
