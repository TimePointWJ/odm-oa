package com.odm.oa.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IdentifyRecordUtils {
	/**
	 * 11:22
	 */
	public static int getHour(String date) {
		return Integer.parseInt(date.substring(0, 2));
	}

	/**
	 * 11:22
	 */
	public static int getMinute(String date) {
		return Integer.parseInt(date.substring(3));
	}

	/**
	 * 11:22返回date
	 */
	public static Date getHourMinute(Calendar c, String time) {
		if (time != null && !"".equals(time)) {
			c.set(Calendar.HOUR_OF_DAY, IdentifyRecordUtils.getHour(time));
			c.set(Calendar.MINUTE, IdentifyRecordUtils.getMinute(time));
			return c.getTime();
		}
		return null;
	}

	/**
	 * 两个Date拼接成String
	 */
	public static String DateToString(Date begin, Date end) {
		return dateFormat(begin) + "~" + dateFormat(end);
	}

	/**
	 * format "yyyy-MM-dd HH:mm"
	 */
	public static String dateFormat(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}

	/**
	 * 计算两个日期相差天数
	 */
	public static int countTwoDays(Date date1, Date date2) {
		return (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
	}

	/**
	 * 获取时间是 “ ”+时：分
	 */
	public static String getHourMinute(Date date) {
		if (date != null) {
			return new SimpleDateFormat(" HH:mm").format(date);
		}
		return null;
	}

	/**
	 * 11:00 12:00 取早的
	 */
	public static String compareTwoStart(String time1, String time2) {
		if (checkNull(time2)) {
			return time1;
		}
		if (checkNull(time1)) {
			return time2;
		}
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time1.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time1.substring(3)));
		Date date1 = c.getTime();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time2.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time2.substring(3)));
		Date date2 = c.getTime();
		if (date1.getTime() <= date2.getTime()) {
			return time1;
		} else {
			return time2;
		}
	}

	/**
	 * 11:00 12:00 取晚的
	 */
	public static String compareTwoEnd(String time1, String time2) {
		if (checkNull(time2)) {
			return time1;
		}
		if (checkNull(time1)) {
			return time2;
		}
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time1.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time1.substring(3)));
		Date date1 = c.getTime();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time2.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time2.substring(3)));
		Date date2 = c.getTime();
		if (date1.getTime() >= date2.getTime()) {
			return time1;
		} else {
			return time2;
		}
	}

	/**
	 * 11:00 12:00 13:00 取早
	 */
	public static String compareThreeStart(String time1, String time2, String time3) {
		// 如果三个都为null，返回null
		if (checkNull(time1) && checkNull(time2) && checkNull(time3)) {
			return null;
		}
		// 如果一个为null，返回另两个中的一个
		if (checkNull(time1)) {
			return compareTwoStart(time2, time3);
		}
		if (checkNull(time2)) {
			return compareTwoStart(time1, time3);
		}
		if (checkNull(time3)) {
			return compareTwoStart(time2, time1);
		}
		// 三个都有值
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time1.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time1.substring(3)));
		Date date1 = c.getTime();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time2.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time2.substring(3)));
		Date date2 = c.getTime();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time3.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time3.substring(3)));
		Date date3 = c.getTime();
		if (date1.getTime() <= date2.getTime() && date1.getTime() <= date3.getTime()) {
			return time1;
		}
		if (date2.getTime() <= date3.getTime() && date2.getTime() <= date1.getTime()) {
			return time2;
		}
		if (date3.getTime() <= date1.getTime() && date3.getTime() <= date2.getTime()) {
			return time3;
		}
		return null;
	}

	/**
	 * 11:00 12:00 13:00取晚
	 */
	public static String compareThreeEnd(String time1, String time2, String time3) {
		// 如果三个都为null，返回null
		if (checkNull(time1) && checkNull(time2) && checkNull(time3)) {
			return null;
		}
		// 如果一个为null，返回另两个中的一个
		if (checkNull(time1)) {
			return compareTwoEnd(time2, time3);
		}
		if (checkNull(time2)) {
			return compareTwoEnd(time1, time3);
		}
		if (checkNull(time3)) {
			return compareTwoEnd(time2, time1);
		}
		// 三个都有值
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time1.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time1.substring(3)));
		Date date1 = c.getTime();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time2.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time2.substring(3)));
		Date date2 = c.getTime();
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time3.substring(0, 2)));
		c.set(Calendar.MINUTE, Integer.parseInt(time3.substring(3)));
		Date date3 = c.getTime();
		if (date1.getTime() >= date2.getTime() && date1.getTime() >= date3.getTime()) {
			return time1;
		}
		if (date2.getTime() >= date3.getTime() && date2.getTime() >= date1.getTime()) {
			return time2;
		}
		if (date3.getTime() >= date1.getTime() && date3.getTime() >= date2.getTime()) {
			return time3;
		}
		return null;
	}

	/**
	 * check为Null
	 */
	public static boolean checkNull(String s1) {
		return s1 == null || "".equals(s1);
	}

	/**
	 * check两个String为不为null
	 */
	public static boolean checkTwoStrNotNull(String s1, String s2) {
		return s1 != null && !"".equals(s1) && s2 != null && !"".equals(s2);
	}
}
