//package com.odm.oa.common.utils;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.time.StopWatch;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SmsUtil {
//
//	private final static Logger log = LoggerFactory.getLogger(SmsUtil.class);
//
//	private static String ENCODING = "UTF-8";
//
//	@Value(value = "${CELLER_PHONE_AUTHORITY_SMS_SEND_URL}")
//	private String URI_SEND_SMS;
//
//	// private static SmsUtil instance;
//
//	@Value(value = "${CELLER_PHONE_AUTHORITY_APIKEY}")
//	private String APIKEY;
//
//	// private SmsUtil(String apikey) {
//	// APIKEY = apikey;
//	// }
//
//	// public static synchronized SmsUtil getInstance() {
//	// String apikey = null;
//	// if (instance == null) {
//	// instance = new SmsUtil(apikey);
//	// }
//	// return instance;
//	// }
//
//	/**
//	 * SMS送信
//	 * 
//	 * @param mobile
//	 *            携帯番号
//	 * @param smsText
//	 *            SMS内容
//	 * @return json
//	 * @throws IOException
//	 */
//	public String sendSms(String mobile, String smsText) {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("apikey", APIKEY);
//		params.put("text", smsText);
//		params.put("mobile", mobile);
//		StopWatch watch = new StopWatch();
//		watch.start();
//		log.info("[IF] SMS发信开始");
//		String response = post(URI_SEND_SMS, params);
//		log.info("[IF] SMS发信 处理结束 " + watch.getTime() + "ms");
//		return response;
//		// 戻す値：
//		// {"code":0,"msg":"发送成功","count":1,"fee":0.05,"unit":"RMB","mobile":"18000000000","sid":1900000000000}
//	}
//
//	/**
//	 * HttpClient 3.1をベースのPOSTメッソト
//	 *
//	 * @param url
//	 *            url
//	 * @param paramsMap
//	 *            params
//	 * @return ResponseBody
//	 */
//	private String post(String url, Map<String, String> paramsMap) {
//
//		/** 試行回数 */
//		final int MAX_COUNT = 5;
//		String responseBodyAsString = "";
//		Exception tempE = null;
//		for (int count = 0; count < MAX_COUNT; count++) {
//			try {
//				responseBodyAsString = postToHost(url, paramsMap);
//			} catch (HttpException e) {
//				tempE = e;
//				break;
//			} catch (UnknownHostException e) {
//				tempE = e;
//				continue;
//			} catch (IOException e) {
//				tempE = e;
//				break;
//			}
//			break;
//		}
//		if (StringUtils.isEmpty(responseBodyAsString)) {
//			if (tempE != null) {
//				log.error("HTTP调用失败。", tempE);
//			} else {
//				log.error("HTTP调用失败。");
//			}
//		}
//
//		return responseBodyAsString;
//	}
//
//	private String postToHost(String url, Map<String, String> paramsMap) throws HttpException, IOException {
//		HttpClient client = new HttpClient();
//		PostMethod method = new PostMethod(url);
//		if (paramsMap != null) {
//			NameValuePair[] namePairs = new NameValuePair[paramsMap.size()];
//			int i = 0;
//			for (Map.Entry<String, String> param : paramsMap.entrySet()) {
//				NameValuePair pair = new NameValuePair(param.getKey(), param.getValue());
//				namePairs[i++] = pair;
//			}
//			method.setRequestBody(namePairs);
//			HttpMethodParams param = method.getParams();
//			param.setContentCharset(ENCODING);
//		}
//		client.executeMethod(method);
//		return method.getResponseBodyAsString();
//	}
//}
