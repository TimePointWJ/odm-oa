package com.odm.oa.common.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.odm.oa.common.utils.UuidUtil;

/**
 * create BasicController by huc 2017/12/7 下午8:39
 */
public class BasicController {

	protected static Logger logger = LogManager.getLogger(BasicController.class.getName());

	protected String resourcesId;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	SerializerFeature[] feature = { SerializerFeature.DisableCircularReferenceDetect,
			SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteMapNullValue };

	/**
	 * 得到32位的UUID
	 * 
	 * @return
	 */
	public String get32UUID() {

		return UuidUtil.get32UUID();
	}

	@InitBinder
	public void initMethod(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		String resources = request.getParameter("resources_id");
		if (resources != null)
			resourcesId = resources;
	}

}
