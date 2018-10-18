package com.odm.oa.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class WebTool {

	private WebTool() {
		throw new IllegalStateException("WebTool class");
	}

	/**
	 * 功能：判断字符串变量是否为空 输入：字符串 输出：布尔变量 备注：无
	 */
	public static boolean isNull(String value) {
		return value == null || value.trim().length() == 0;
	}

	/**
	 * 功能：判断对象是否为NULL
	 */
	public static boolean isNull(Object object) {
		return null == object;
	}

	/** 判断List是否为空 */
	public static boolean isNull(@SuppressWarnings("rawtypes") List list) {
		return (null == list || list.isEmpty());
	}

	/** 判断Map是否为空 */
	public static boolean isNull(@SuppressWarnings("rawtypes") Map map) {
		return (null == map || map.size() == 0);
	}

	/** 判断String[]是否为空 */
	public static boolean isNull(String[] strs) {
		return (null == strs || strs.length == 0);
	}

	/** 判断int[]是否为空 */
	public static boolean isNull(int[] strs) {
		return (null == strs || strs.length == 0);
	}

	/** 判断日期变量是否为空 */
	public static boolean isNull(Date date) {
		return date == null;
	}

	/** 判断整型变量是否为空 */
	public static boolean isNull(Integer value) {
		return value == null || value.intValue() < 0;
	}

	/** 判断长整型变量是否为空 */
	public static boolean isNull(Long value) {
		return value == null || value.longValue() < 0;
	}

	public static boolean isNull(java.util.Calendar calendar) {
		return calendar == null || calendar.getTime() == null;
	}

	public static String getDateStringBySimpleDateFormat(Date date) {
		if (WebTool.isNull(date)) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

}
