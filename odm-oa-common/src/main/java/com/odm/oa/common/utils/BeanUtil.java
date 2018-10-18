package com.odm.oa.common.utils;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {
	/**
	 * Object 类型的
	 * 
	 * @param obj1
	 * @param obj2
	 */
	public static void copyProperties(Object obj1, Object obj2) throws Exception {
		BeanUtils.copyProperties(obj1, obj2);
	}

	/**
	 * List 类型的
	 * 
	 * @param <T>
	 * @param <E>
	 * 
	 * @param obj1
	 * @param obj2
	 * @throws InstantiationException
	 */
	public static <T, E> void copyProperties(Class<T> clazz, List<T> list1, List<E> list2) throws Exception {
		for (int i = 0; i < list2.size(); i++) {
			T t = clazz.newInstance();
			BeanUtils.copyProperties(t, list2.get(i));
			list1.add(t);
		}
	}
}
