package com.odm.oa.common.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;

/**
 * ip地址处理类
 * 
 * @author xiel
 *
 */
public class IPTools {
	Logger logger = LogManager.getLogger(this.getClass().getName());
	private static IPTools iptools = new IPTools();
	private DbSearcher _searcher = null;

	public static IPTools getInstance() {
		return iptools;
	}

	/**
	 * ip地址文件导入方法
	 */
	public IPTools() {
		try {
			String ipdata = SpringUtil.getApplicationContext().getEnvironment().getProperty("ipdataPath");
			_searcher = new DbSearcher(new DbConfig(), ipdata);
		} catch (Exception e) {
			logger.error("ip地址文件获取失败", e);
		}
	}

	/**
	 * 通过ip文件查找地址方法
	 * 
	 * @param remote
	 * @return
	 */
	public IP findGeography(String remote) {
		IP ip = new IP();
		try {
			DataBlock block = _searcher.binarySearch(remote != null ? remote : "127.0.0.1");
			if (block != null && block.getRegion() != null) {
				String[] region = block.getRegion().split("[\\|]");
				if (region.length == 5) {
					ip.setCountry(region[0]);
					if (!StringUtils.isBlank(region[1]) && !region[1].equalsIgnoreCase("null")) {
						ip.setRegion(region[1]);
					} else {
						ip.setRegion("");
					}
					if (!StringUtils.isBlank(region[2]) && !region[2].equalsIgnoreCase("null")) {
						ip.setProvince(region[2]);
					} else {
						ip.setProvince("");
					}
					if (!StringUtils.isBlank(region[3]) && !region[3].equalsIgnoreCase("null")) {
						ip.setCity(region[3]);
					} else {
						ip.setCity("");
					}
					if (!StringUtils.isBlank(region[4]) && !region[4].equalsIgnoreCase("null")) {
						ip.setIsp(region[4]);
					} else {
						ip.setIsp("");
					}
				}
			}
		} catch (Exception ex) {
			logger.error("ip地址获取失败", ex);
		}
		return ip;
	}
}
