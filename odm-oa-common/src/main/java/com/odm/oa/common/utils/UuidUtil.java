package com.odm.oa.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UuidUtil {

	private UuidUtil() {
		throw new IllegalStateException("TravelskyConstants class");
	}

	public static String get32UUID() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}

	/**
	 * @return
	 */
	public static String getOrderId() {
		String userId = "12345678910";
		return getOrderId(userId, Constants.SINGLE_CHANNEL_WEB, Constants.CHANNEL_OF_PAYMENT_ALIPAY);
	}

	/**
	 * 下单渠道1位+支付渠道1位+业务类型1位+时间信息2位+下单时间的Unix时间戳后8位 （加上随机码随机后的数字）+时间信息2位+用户user id后4位
	 *
	 * @param userId
	 *            用户ID(手机号)
	 * @param singleChannel
	 *            下单渠道
	 * @param channelOfPayment
	 *            支付渠道
	 * @return
	 */
	public static String getOrderId(String userId, String singleChannel, String channelOfPayment) {
		StringBuilder numStr = new StringBuilder();
		String dataStr = new SimpleDateFormat(Constants.YMDHMSS).format(new Date());
		numStr.append(singleChannel);// 下单渠道
		numStr.append(channelOfPayment);// 支付渠道
		numStr.append(dataStr.substring(Constants.INT_2, Constants.INT_4));// 月份
		numStr.append(dataStr.substring(dataStr.length() - 8));// 时间戳后八位
		numStr.append(dataStr.substring(Constants.INT_4, Constants.INT_6));// 日
		numStr.append(userId.substring(userId.length() - Constants.INT_4));// 用户Id后四位
		return numStr.toString();
	}

	/**
	 * 
	 * @param orderId
	 *            (订单号)
	 * @param functionName(1：退货
	 *            2：退换 3：移机 4：安装 5：推广)
	 * @param count(次数)
	 * @return
	 */
	public static String getId(String orderId, String functionName, int count) {
		String str1 = "";
		String str2 = "";
		switch (functionName) {
		case Constants.FUNCTION_NAME_1:
			str1 = Constants.STRING_1;
			break;
		case Constants.FUNCTION_NAME_2:
			str1 = Constants.STRING_2;
			break;
		case Constants.FUNCTION_NAME_3:
			str1 = Constants.STRING_3;
			break;
		case Constants.FUNCTION_NAME_4:
			str1 = Constants.STRING_4;
			break;
		case Constants.FUNCTION_NAME_5:
			str1 = Constants.STRING_5;
			break;
		}
		str2 = String.format("%02d", count);
		return orderId + str1 + str2;
	}

	public static void main(String[] args) {
		System.out.println(getOrderId());
		System.out.println(getOrderId("13478954534", "1", "3"));
		System.out.println(getOrderId("13478954534", "1", "3"));
	}
}
