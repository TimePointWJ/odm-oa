package com.odm.oa.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 微信接口调用工具类
 * 
 * @author xielin
 *
 */
public class WechatApiUtils {

	private static Logger logger = LogManager.getLogger(WechatApiUtils.class);

	/**
	 * 获取token
	 * 
	 * @param appid
	 * @param secret
	 * @return
	 */
	public static String getToken(String appid, String secret) {
		String parm = "grant_type=client_credential&appid=" + appid + "&secret=" + secret;
		return sendGet("https://api.weixin.qq.com/cgi-bin/token", parm);
	}

	/**
	 * 通过code获取token
	 * 
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 */
	public static String getAccessTokenByCode(String appid, String secret, String code) {
		String parm = "appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
		return sendGet("https://api.weixin.qq.com/sns/oauth2/access_token", parm);
	}

	/**
	 * 通过token和openId获取用户信息
	 * 
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static String getUserInfo(String accessToken, String openId) {
		String param = "access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN";
		return sendGet("https://api.weixin.qq.com/sns/userinfo", param);
	}

	/**
	 * 通过token和openId获取用户信息(不用code)
	 * 
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public static String getUserInfos(String accessToken, String openId) {
		String param = "access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN";
		return sendGet("https://api.weixin.qq.com/cgi-bin/user/info", param);
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				logger.info(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送GET请求出现异常！", e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				logger.error("关闭输入流出现异常！", e2);
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 1.获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 2.中文有乱码的需要将PrintWriter改为如下
			// out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送 POST 请求出现异常！", e);
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				logger.error("关闭输出流、输入流失败", ex);
			}
		}
		logger.info("post推送结果：" + result);
		return result;
	}

	/**
	 * 微信公众号接口配置验证
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param token
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {
		String[] arr = new String[] { token, timestamp, nonce };
		// 按自然顺序排序
		Arrays.sort(arr);
		// 生成字符串
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}

		// sha1 加密
		String temp = getSha1(content.toString());
		return temp.equals(signature);
	}

	/**
	 * 获取Sha1加密内容
	 * 
	 * @param str
	 * @return
	 */
	private static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] buf = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (NoSuchAlgorithmException e) {
			logger.error("Sha1加密失败1", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("Sha1加密失败2", e);
		}
		return null;
	}

}