package com.odm.oa.common.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbXmlUtils {

	public static <T> Marshaller getMarshaller(Class<T> c, String encoding) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(c);
		Marshaller marshaller = context.createMarshaller();
		// 编码格式
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		// 是否格式化生成的xml串
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// 是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

		return marshaller;
	}

	public static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * pojo转换成xml 默认编码UTF-8
	 *
	 * @param obj
	 *            待转化的对象
	 * @return xml格式字符串
	 * @throws Exception
	 *             JAXBException
	 */
	public static String convertToXml(Object obj) throws Exception {
		return convertToXml(obj, DEFAULT_ENCODING);
	}

	/**
	 * pojo转换成xml
	 *
	 * @param obj
	 *            待转化的对象
	 * @param encoding
	 *            编码
	 * @return xml格式字符串
	 * @throws Exception
	 *             JAXBException
	 */
	public static String convertToXml(Object obj, String encoding) throws Exception {
		String result = null;
		Marshaller marshaller = getMarshaller(obj.getClass(), encoding);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		result = writer.toString();

		return result;
	}

	/**
	 * xml转换成JavaBean
	 *
	 * @param xml
	 *            xml格式字符串
	 * @param t
	 *            待转化的对象
	 * @return 转化后的对象
	 * @throws Exception
	 *             JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToJavaBean(Class<T> t, String xml) throws JAXBException {
		T obj = null;
		JAXBContext context = JAXBContext.newInstance(t);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		obj = (T) unmarshaller.unmarshal(new StringReader(xml));
		return obj;
	}
}
