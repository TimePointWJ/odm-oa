///** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. */
//package com.odm.oa.common.basic.redis;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import redis.clients.jedis.Jedis;
//
///**
// * redis初始化配置文件 Created by lishang on 2018-05-02.
// */
////@Configuration
//// @EnableTransactionManagement //等价于<tx:annotation-driven />
//public class MyConfiguration /* implements TransactionManagementConfigurer */ {
//
//	private static Logger logger = LogManager.getLogger(MyConfiguration.class);
//
////	@Value(value = "${REDIS_IP}")
//	private String redisIp;
//
////	@Value(value = "${REDIS_PORT}")
//	private int redisPort;
//
////	@Value(value = "${REDIS_PORT_PWD}")
//	private String redisPwd;
//
//	/**
//	 * 单点Factory
//	 *
//	 */
////	@Configuration
//	class JedisClusterFactory {
//
////		@Bean(name = "jedis")
//		public Jedis jedisCluster() throws Exception {
//			Jedis jedisCluster = null;
//
//			try {
//				jedisCluster = new Jedis(redisIp, redisPort);
//				jedisCluster.auth(redisPwd);
//				logger.info("redis 连接成功");
//			} catch (Exception e) {
//				logger.error("redis 连接成功", e);
//			}
//
//			return jedisCluster;
//		}
//	}
//
//	// @Override
//	// public PlatformTransactionManager annotationDrivenTransactionManager() {
//	// return new DataSourceTransactionManager(druidDataSource());
//	// }
//	//
//	// @Bean
//	// @ConfigurationProperties(prefix = "spring.datasource")
//	// public DruidDataSource druidDataSource() {
//	// DruidDataSource druidDataSource = new DruidDataSource();
//	// return druidDataSource;
//	// }
//
//}
