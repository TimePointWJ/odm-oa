package com.odm.oa.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUploadExcelUtils {
	/**
	 * 检查String是否为Date
	 */
	public static boolean checkDate(String date) {
		if (date != null) {
			// 去两边空格
			date = date.trim();
			// 20171212
			if (date.length() != 8) {
				return false;
			}
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				sdf.parse(date);
			} catch (ParseException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查手机号码
	 */
	public static boolean checkMobilePhone(String mobilePhone) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobilePhone);
		return m.matches();
	}

	/**
	 * 检查座机号码
	 */
	public static boolean checkLandline(String landline) {
		Pattern p = Pattern.compile("^[0]{1}[0-9]{2,3}-[0-9]{7,8}$");
		Matcher m = p.matcher(landline);
		return m.matches();
	}

	/**
	 * 检查Long类型
	 */
	public static boolean checkLong(String string) {
		try {
			Long.parseLong(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 检查e-mail
	 */
	public static boolean checkEmail(String email) {
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 检查Integer类型
	 */
	public static boolean checkInteger(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 检查double类型
	 */
	public static boolean checkDouble(String string) {
		try {
			Double.parseDouble(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 不为空
	 */
	public static boolean checkNull(String string) {
		if (string != null && !"".equals(string)) {
			return true;
		}
		return false;
	}
}
