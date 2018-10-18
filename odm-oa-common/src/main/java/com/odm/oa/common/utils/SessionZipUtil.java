package com.odm.oa.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpSession;

/**
 * @author lishang 由于Session中大对象的存在，提供此类用于Session对象的压缩和读取
 *
 */
public class SessionZipUtil {

	/**
	 * 将需存入session中的对象序列化，压缩后，存入Session
	 * 
	 * @param session
	 * @param key
	 * @param value
	 */
	public static void setAttribute(HttpSession session, String key, Object value) {

		if (session == null || WebTool.isNull(key) || value == null)
			return;

		byte[] byteArrayOfObj = null;
		ByteArrayOutputStream byteOut = null;
		GZIPOutputStream zipOut = null;
		ObjectOutputStream objOut = null;
		boolean operationResult = true;
		try {
			byteOut = new ByteArrayOutputStream(1024 * 1024);

			zipOut = new GZIPOutputStream(byteOut);

			objOut = new ObjectOutputStream(zipOut);

			objOut.writeObject(value);

		} catch (IOException e) {
			operationResult = false;
		} finally {
			if (objOut != null)
				try {
					objOut.flush();
					objOut.close();
				} catch (IOException e) {
				}
			if (zipOut != null)
				try {
					zipOut.close();
					byteArrayOfObj = byteOut.toByteArray();
				} catch (IOException e) {
				}
			if (byteOut != null)
				try {
					byteOut.close();
				} catch (IOException e) {
				}

		}

		if (operationResult) {
			session.setAttribute(key, byteArrayOfObj);
			value = null;
		} else {
			session.setAttribute(key, value);
		}

	}

	/**
	 * 从压缩session中获取属性的拷贝 返回的对象与session中的属性无关联
	 * 
	 * @param session
	 * @param key
	 * @return
	 */
	public static Object getAttribute(HttpSession session, String key) {

		if (session == null || WebTool.isNull(key))
			return null;

		Object sessionObj = session.getAttribute(key);

		byte[] byteArray = null;

		if (sessionObj != null && sessionObj.getClass() == byte[].class) {
			byteArray = (byte[]) session.getAttribute(key);
		} else {
			return sessionObj;
		}
		if (byteArray == null)
			return null;

		Object obj = null;
		ByteArrayInputStream byteIn = null;
		GZIPInputStream zipIn = null;
		ObjectInputStream objIn = null;
		try {
			byteIn = new ByteArrayInputStream(byteArray);
			zipIn = new GZIPInputStream(byteIn);
			objIn = new ObjectInputStream(zipIn);
			obj = objIn.readObject();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} finally {

			if (objIn != null)
				try {
					objIn.close();
				} catch (IOException e) {
				}

			if (zipIn != null)
				try {
					zipIn.close();
				} catch (IOException e) {
				}
			if (byteIn != null)
				try {
					byteIn.close();
				} catch (IOException e) {
				}
		}

		return obj;

	}

}
