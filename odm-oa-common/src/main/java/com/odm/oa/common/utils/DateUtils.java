package com.odm.oa.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述：日期处理常用类
 * 
 * @author tongbiao
 */

public class DateUtils {
	public static final String Y_M_D = "yyyy-MM-dd";
	public static final String Y_M_D_HM = "yyyy-MM-dd HH:mm";
	public static final String Y_M_D_HM_CN = "yyyy年MM月dd日 HH:mm";
	public static final String Y_M_D_HMS = "yyyy-MM-dd HH:mm:ss";
	public static final String YMD = "yyyyMMdd";
	public static final String YMDHM = "yyyyMMddHHmm";
	public static final String YMDHMS = "yyyyMMddHHmmss";
	public static final String ymd = "yyyy/MM/dd";
	public static final String ymd_HM = "yyyy/MM/dd HH:mm";
	public static final String ymd_HMS = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 功能：指定日期加上指定天数
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * 功能：指定日期加上指定天数
	 *
	 * @param date
	 *            日期
	 * @param hours
	 *            小时数
	 * @return 返回相加后的日期
	 */
	public static Date addHour(Date date, int hours) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, hours);
		return c.getTime();
	}

	/**
	 * 功能：指定日期加上指定天数
	 * 
	 * @param date
	 *            日期
	 * @param minute
	 *            分钟
	 * @return 返回相加后的日期
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	/**
	 * 
	 * 功能：添加指定秒杀的时间
	 *
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, second);
		return c.getTime();
	}

	/**
	 * 功能：传入时间按所需格式返回时间字符串 default format: yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            java.util.Date格式
	 * @param format
	 *            yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date == null) {
				date = new Date();// 如果时间为空,则默认为当前时间
			}
			if (StringUtils.isEmpty(format)) {// 默认格式化形式
				format = Y_M_D_HMS;
			}
			DateFormat df = new SimpleDateFormat(format);
			result = df.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能：传入时间字符串按所需格式返回时间
	 * 
	 * @param dateStr
	 *            时间字符串
	 * @param format
	 *            跟传入dateStr时间的格式必须一样 yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static Date format(String dateStr, String format) {
		if (StringUtils.isEmpty(dateStr)) {
			return new Date();
		}

		if (StringUtils.isEmpty(format)) {
			format = "yyyy-MM-dd";
		}
		Date date = null;
		try {
			DateFormat f = new SimpleDateFormat(format);
			date = f.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 功能：时间字符串格式转换
	 * 
	 * @param dateStr
	 *            时间字符串
	 * @param format
	 *            时间字符串的格式
	 * @param toFormat
	 *            格式为的格式
	 * @return
	 */
	public static String format(String dateStr, String format, String toFormat) {
		return format(format(dateStr, format), toFormat);
	}

	/**
	 * 功能：返回年
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);

	}

	/**
	 * 功能：返回月
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能：返回日
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能：返回小时
	 * 
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能：返回分
	 * 
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 功能：返回星期 1：星期一，2:星期二 ... 6:星期六 7:星期日
	 * 
	 * @param date
	 * @return
	 */
	public static int getChinaWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 0) {
			return 7;
		} else {
			return week;
		}
	}

	/**
	 * 功能：返回秒
	 * 
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 功能：返回毫秒
	 * 
	 * @param date
	 * @return
	 */
	public static long getMillis(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 功能：获取当前月的第一天日期
	 * 
	 * @return
	 */
	public static Date getMonFirstDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date) - 1, 1);
		return c.getTime();
	}

	/**
	 * 功能：获取当前月的最后一天日期
	 * 
	 * @return
	 */
	public static Date getMonLastDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date), 1);
		return addDate(c.getTime(), -1);
	}

	/**
	 * 功能：获取上个月的最后一天日期
	 * 
	 * @return
	 */
	public static Date getMonUpDay() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.set(getYear(date), getMonth(date) - 1, 1);
		return addDate(c.getTime(), -1);
	}

	/** 获得给定日期当月的天数 */
	public static int getDays(Calendar cal) {
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 当前时间加 减days
	 * 
	 * @param diffDay
	 * @return
	 */
	public static Date getAddDay(int diffDay) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, diffDay);
		return addDate(c.getTime(), diffDay);
	}

	/**
	 * 验证输入的日期是否合法
	 * 
	 * @param expDate
	 * @return
	 */
	public static boolean checkExpDate(String expDate) {
		int year = Integer.parseInt(expDate.substring(0, 4));
		int month = Integer.parseInt(expDate.substring(4, 6));
		int day = Integer.parseInt(expDate.substring(6, 8));
		if (month > 12 || month < 1) {
			return false;
		}

		int[] monthLengths = new int[] { 0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (isLeapYear(year)) {
			monthLengths[2] = 29;
		} else {
			monthLengths[2] = 28;
		}

		int monthLength = monthLengths[month];
		if (day < 1 || day > monthLength) {
			return false;
		}
		return true;
	}

	/**
	 * 是否是闰年
	 */
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}

	public static int statisSubDay(Date endDate, Date startDate) {

		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);

		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(endDate);
		toCalendar.set(Calendar.HOUR_OF_DAY, 0);
		toCalendar.set(Calendar.MINUTE, 0);
		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);
		Long tempString = (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
		return Integer.valueOf(tempString.toString());
	}

	/**
	 * when start <= target <= end, return true
	 * 
	 * @param start
	 * @param end
	 * @param target
	 * @return
	 */
	public static boolean isBetween(Date start, Date end, Date target) {
		if (target == null) {
			return false;
		} else {
			if (start == null && end != null) {
				return !target.after(end);
			} else if (start != null && end == null) {
				return !target.before(start);
			} else if (start != null && end != null) {
				return !target.before(start) && !target.after(end);
			} else {
				return false;
			}
		}
	}

	/**
	 * 功能：传入时间按所需格式返回时间字符串
	 * 
	 * @param date
	 *            java.util.Date格式
	 * @param format
	 *            yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String formatType(Date date, String format) {
		String result = "";
		try {
			if (date == null) {
				date = new Date();// 如果时间为空,则默认为当前时间
			}
			if (format == null || "".equals(format)) {// 默认格式化形式
				format = "yyyy-MM-dd";
			}
			DateFormat df = new SimpleDateFormat(format);
			result = df.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能：传入时间字符串按所需格式返回时间
	 * 
	 * @param dateStr
	 *            时间字符串
	 * @param format
	 *            跟传入dateStr时间的格式必须一样 yyyy-MM-dd HH:mm:ss | yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static Date parse(String dateStr, String format) {
		if (dateStr == null || "".equals(dateStr)) {
			return new Date();
		}

		if (format == null || "".equals(format)) {
			format = "yyyy-MM-dd";
		}
		Date date = null;
		try {
			DateFormat f = new SimpleDateFormat(format);
			date = f.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 格式化时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getChinaFormatDay(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		return sf.format(date);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 功能：获取当前日期 格式:2008-02-02 23:11:10
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		Date date = new Date();
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 功能：获取当前日期 格式:20080202231110
	 *
	 * @return
	 */
	public static String getCurrentDateTimeToyyyyMMddHHmmss() {
		Date date = new Date();
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	/**
	 * 智能转换日期
	 * 
	 * @param text
	 * @return
	 */
	public static Date smartFormat(String text) {
		Date date = null;
		try {
			if (text == null || text.length() == 0) {
				date = null;
			} else if (text.length() == 10) {
				date = formatStringToDate(text, Y_M_D);
			} else if (text.length() == 13) {
				date = new Date(Long.parseLong(text));
			} else if (text.length() == 14) {
				date = formatStringToDate(text, YMDHMS);
			} else if (text.length() == 16) {
				date = formatStringToDate(text, Y_M_D_HM);
			} else if (text.length() == 19) {
				date = formatStringToDate(text, Y_M_D_HMS);
			} else {
				throw new IllegalArgumentException("日期长度不符合要求!");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("日期转换失败!");
		}
		return date;
	}

	/**
	 * 把字符串格式化成日期
	 * 
	 * @param argDateStr
	 * @param argFormat
	 * @return
	 */
	public static Date formatStringToDate(String argDateStr, String argFormat) throws Exception {
		if (argDateStr == null || argDateStr.trim().length() < 1) {
			throw new Exception("参数[日期]不能为空!");
		}
		String strFormat = argFormat;
		if (strFormat != null && !"".equals(strFormat)) {
			strFormat = Y_M_D;
			if (argDateStr.length() > 16) {
				strFormat = Y_M_D_HMS;
			} else if (argDateStr.length() > 10) {
				strFormat = Y_M_D_HM;
			}
		}
		SimpleDateFormat sdfFormat = new SimpleDateFormat(strFormat);
		// 严格模式
		sdfFormat.setLenient(false);
		try {
			return sdfFormat.parse(argDateStr);
		} catch (ParseException e) {
			throw new Exception(e);
		}
	}

	/**
	 * end > start
	 * 
	 * @param start
	 * @param end
	 * @param type
	 *            秒：S，分：m，时：H，日：D， 周：W，月：M，年：Y
	 * @return
	 */
	public static long getIntevalMinutes(Date start, Date end, String type) {
		long result = 0;
		if (start == null || end == null || end.before(start)) {
			return 0;
		}

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(start);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(start);

		int years = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
		int months = endCal.get(Calendar.MONTH) - startCal.get(Calendar.MONTH);

		long diff = end.getTime() - start.getTime();
		long inteval = 1;
		switch (type) {
		case "S":
			inteval *= 1000;
			break;
		case "m":
			inteval *= 1000 * 60;
			break;
		case "H":
			inteval *= 1000 * 60 * 60;
			break;
		case "D":
			inteval *= 1000 * 60 * 60 * 24;
			break;
		case "W":
			inteval *= 1000 * 60 * 60 * 24 * 7;
			break;
		}

		result = diff / inteval;

		if ("M".equals(type)) {
			result = years * 12 + months;
		} else if ("Y".equals(type)) {
			result = years;
		}

		return result;
	}

	/*
	 * public static void main(String[] a) { Date d1 =
	 * format("2018-06-25 10:10:00",Y_M_D_HMS); Date d2 =
	 * format("2018-06-25 11:12:00",Y_M_D_HMS);
	 * 
	 * System.out.println(getIntevalMinutes(d1,d2,"m")); }
	 */
}
