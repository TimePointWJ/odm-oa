package com.odm.oa.common.utils;

import com.github.pagehelper.Page;

public class PageUtil {
	/**
	 * 设置分页信息
	 * 
	 * @param list
	 *            返回页面的list
	 * @param data
	 *            sql查询的list
	 */
	public static void setPageInfo(@SuppressWarnings("rawtypes") Page list, @SuppressWarnings("rawtypes") Page data) {
		list.setTotal(data.getTotal());
		list.setPageNum(data.getPageNum());
		list.setPageSize(data.getPageSize());
	}
}
