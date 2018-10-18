//package com.odm.oa.common.basic.redis;
//
//import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;
//
//import javax.annotation.Resource;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Repository;
//
//import redis.clients.jedis.Jedis;
//
//@Repository(value = "redisSupport")
//public class RedisSupport implements IRedisDao {
//
//	protected static Logger logger = LogManager.getLogger(RedisSupport.class.getName());
//
//	@Resource(name = "jedis")
//	private Jedis jedis;
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#expire(java.lang.String, int)
//	 */
//	@Override
//	public long expire(String key, int seconds) {
//		if (key == null || key.equals("")) {
//			return 0;
//		}
//		try {
//			return jedis.expire(key, seconds);
//		} catch (Exception ex) {
//			logger.error("EXPIRE error[key=" + key + " seconds=" + seconds + "]" + ex.getMessage(), ex);
//		}
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#expireAt(java.lang.String,
//	 * int)
//	 */
//	@Override
//	public long expireAt(String key, int unixTimestamp) {
//		if (key == null || key.equals("")) {
//			return 0;
//		}
//
//		try {
//			return jedis.expireAt(key, unixTimestamp);
//		} catch (Exception ex) {
//			logger.error("EXPIRE error[key=" + key + " unixTimestamp=" + unixTimestamp + "]" + ex.getMessage(), ex);
//		} finally {
//		}
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#trimList(java.lang.String,
//	 * long, long)
//	 */
//	@Override
//	public String trimList(String key, long start, long end) {
//		if (key == null || key.equals("")) {
//			return "-";
//		}
//		try {
//			return jedis.ltrim(key, start, end);
//		} catch (Exception ex) {
//			logger.error("LTRIM 出错[key=" + key + " start=" + start + " end=" + end + "]" + ex.getMessage(), ex);
//		} finally {
//		}
//		return "-";
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#countSet(java.lang.String)
//	 */
//	@Override
//	public long countSet(String key) {
//		if (key == null) {
//			return 0;
//		}
//		try {
//			return jedis.scard(key);
//		} catch (Exception ex) {
//			logger.error("countSet error.", ex);
//		} finally {
//		}
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#addSet(java.lang.String, int,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean addSet(String key, int seconds, String... value) {
//		boolean result = addSet(key, value);
//		if (result) {
//			long i = expire(key, seconds);
//			return i == 1;
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#addSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean addSet(String key, String... value) {
//		if (key == null || value == null) {
//			return false;
//		}
//		try {
//			jedis.sadd(key, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("setList error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#containsInSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean containsInSet(String key, String value) {
//		if (key == null || value == null) {
//			return false;
//		}
//		try {
//			return jedis.sismember(key, value);
//		} catch (Exception ex) {
//			logger.error("setList error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getSet(java.lang.String)
//	 */
//	@Override
//	public Set<String> getSet(String key) {
//		try {
//			return jedis.smembers(key);
//		} catch (Exception ex) {
//			logger.error("getList error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#removeSetValue(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean removeSetValue(String key, String... value) {
//		try {
//			jedis.srem(key, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("getList error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#removeListValue(java.lang.String,
//	 * java.util.List)
//	 */
//	@Override
//	public int removeListValue(String key, List<String> values) {
//		return removeListValue(key, 1, values);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#removeListValue(java.lang.String,
//	 * long, java.util.List)
//	 */
//	@Override
//	public int removeListValue(String key, long count, List<String> values) {
//		int result = 0;
//		if (values != null && values.size() > 0) {
//			for (String value : values) {
//				if (removeListValue(key, count, value)) {
//					result++;
//				}
//			}
//		}
//		return result;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#removeListValue(java.lang.String,
//	 * long, java.lang.String)
//	 */
//	@Override
//	public boolean removeListValue(String key, long count, String value) {
//		try {
//			jedis.lrem(key, count, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("getList error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#rangeList(java.lang.String,
//	 * long, long)
//	 */
//	@Override
//	public List<String> rangeList(String key, long start, long end) {
//		if (key == null || key.equals("")) {
//			return null;
//		}
//
//		try {
//			return jedis.lrange(key, start, end);
//		} catch (Exception ex) {
//			logger.error("rangeList 出错[key=" + key + " start=" + start + " end=" + end + "]" + ex.getMessage(), ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#countList(java.lang.String)
//	 */
//	@Override
//	public long countList(String key) {
//		if (key == null) {
//			return 0;
//		}
//		try {
//			return jedis.llen(key);
//		} catch (Exception ex) {
//			logger.error("countList error.", ex);
//		} finally {
//		}
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#addList(java.lang.String,
//	 * int, java.lang.String)
//	 */
//	@Override
//	public boolean addList(String key, int seconds, String... value) {
//		boolean result = addList(key, value);
//		if (result) {
//			long i = expire(key, seconds);
//			return i == 1;
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#addList(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean addList(String key, String... value) {
//		if (key == null || value == null) {
//			return false;
//		}
//		try {
//			jedis.lpush(key, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("setList error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#addList(java.lang.String,
//	 * java.util.List)
//	 */
//	@Override
//	public boolean addList(String key, List<String> list) {
//		if (key == null || list == null || list.size() == 0) {
//			return false;
//		}
//		for (String value : list) {
//			addList(key, value);
//		}
//		return true;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getList(java.lang.String)
//	 */
//	@Override
//	public List<String> getList(String key) {
//		try {
//			return jedis.lrange(key, 0, -1);
//		} catch (Exception ex) {
//			logger.error("getList error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#setHSet(java.lang.String,
//	 * java.lang.String, java.lang.String)
//	 */
//	@Override
//	public boolean setHSet(String key, String field, String value) {
//		if (value == null)
//			return false;
//		try {
//			jedis.hset(key, field, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("setHSet error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getHSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public String getHSet(String key, String field) {
//		try {
//			return jedis.hget(key, field);
//		} catch (Exception ex) {
//			logger.error("getHSet error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#delHSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public long delHSet(String key, String field) {
//		long count = 0;
//		try {
//			count = jedis.hdel(key, field);
//		} catch (Exception ex) {
//			logger.error("delHSet error.", ex);
//		} finally {
//		}
//		return count;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#delHSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public long delHSet(String key, String... field) {
//		long count = 0;
//		try {
//			count = jedis.hdel(key, field);
//		} catch (Exception ex) {
//			logger.error("delHSet error.", ex);
//		} finally {
//		}
//		return count;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#existsHSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean existsHSet(String key, String field) {
//		boolean isExist = false;
//		try {
//			isExist = jedis.hexists(key, field);
//		} catch (Exception ex) {
//			logger.error("existsHSet error.", ex);
//		} finally {
//		}
//		return isExist;
//	}
//
//	/**
//	 * 验证redis是否存在key
//	 *
//	 * @param key
//	 * @return
//	 */
//	@Override
//	public boolean existsKey(String key) {
//		boolean isExist = false;
//		try {
//			isExist = jedis.exists(key);
//		} catch (Exception ex) {
//			logger.error("existsHSet error.", ex);
//		} finally {
//		}
//		return isExist;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#hvals(java.lang.String)
//	 */
//	@Override
//	public List<String> hvals(String key) {
//		List<String> retList = null;
//		try {
//			retList = jedis.hvals(key);
//		} catch (Exception ex) {
//			logger.error("hvals error.", ex);
//		} finally {
//		}
//		return retList;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#hkeys(java.lang.String)
//	 */
//	@Override
//	public Set<String> hkeys(String key) {
//		Set<String> retList = null;
//		try {
//			retList = jedis.hkeys(key);
//		} catch (Exception ex) {
//			logger.error("hkeys error.", ex);
//		} finally {
//		}
//		return retList;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#lenHset(java.lang.String)
//	 */
//	@Override
//	public long lenHset(String key) {
//		long retList = 0;
//		try {
//			retList = jedis.hlen(key);
//		} catch (Exception ex) {
//			logger.error("hkeys error.", ex);
//		} finally {
//		}
//		return retList;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#setSortedSet(java.lang.String,
//	 * long, java.lang.String)
//	 */
//	@Override
//	public boolean setSortedSet(String key, long score, String value) {
//		try {
//			jedis.zadd(key, score, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("setSortedSet error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getSoredSet(java.lang.String,
//	 * long, long, boolean)
//	 */
//	@Override
//	public Set<String> getSoredSet(String key, long startScore, long endScore, boolean orderByDesc) {
//		try {
//			if (orderByDesc) {
//				return jedis.zrevrangeByScore(key, endScore, startScore);
//			} else {
//				return jedis.zrangeByScore(key, startScore, endScore);
//			}
//		} catch (Exception ex) {
//			logger.error("getSoredSet error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#countSoredSet(java.lang.String,
//	 * long, long)
//	 */
//	@Override
//	public long countSoredSet(String key, long startScore, long endScore) {
//		try {
//			Long count = jedis.zcount(key, startScore, endScore);
//			return count == null ? 0L : count;
//		} catch (Exception ex) {
//			logger.error("countSoredSet error.", ex);
//		} finally {
//		}
//		return 0L;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.travelsky.ypb.dao.redis.impl.IRedisDao#delSortedSet(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean delSortedSet(String key, String value) {
//		try {
//			long count = jedis.zrem(key, value);
//			return count > 0;
//		} catch (Exception ex) {
//			logger.error("delSortedSet error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getSoredSetByRange(java.lang.
//	 * String, int, int, boolean)
//	 */
//	@Override
//	public Set<String> getSoredSetByRange(String key, int startRange, int endRange, boolean orderByDesc) {
//		try {
//			if (orderByDesc) {
//				return jedis.zrevrange(key, startRange, endRange);
//			} else {
//				return jedis.zrange(key, startRange, endRange);
//			}
//		} catch (Exception ex) {
//			logger.error("getSoredSetByRange error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getScore(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public Double getScore(String key, String member) {
//		try {
//			return jedis.zscore(key, member);
//		} catch (Exception ex) {
//			logger.error("getSoredSet error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#set(java.lang.String, int,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean set(String key, int second, String value) {
//		try {
//			jedis.setex(key, second, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("set error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#set(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public boolean set(String key, String value) {
//		try {
//			jedis.set(key, value);
//			return true;
//		} catch (Exception ex) {
//			logger.error("set error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#get(java.lang.String,
//	 * java.lang.String)
//	 */
//	@Override
//	public String get(String key, String defaultValue) {
//		try {
//			return jedis.get(key) == null ? defaultValue : jedis.get(key);
//		} catch (Exception ex) {
//			logger.error("get error.", ex);
//		} finally {
//		}
//		return defaultValue;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#del(java.lang.String)
//	 */
//	@Override
//	public boolean del(String key) {
//		try {
//			jedis.del(key);
//			return true;
//		} catch (Exception ex) {
//			logger.error("del error.", ex);
//		} finally {
//		}
//		return false;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#incr(java.lang.String)
//	 */
//	@Override
//	public long incr(String key) {
//		try {
//			return jedis.incr(key);
//		} catch (Exception ex) {
//			logger.error("incr error.", ex);
//		} finally {
//		}
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#decr(java.lang.String)
//	 */
//	@Override
//	public long decr(String key) {
//		try {
//			return jedis.decr(key);
//		} catch (Exception ex) {
//			logger.error("incr error.", ex);
//		} finally {
//		}
//		return 0;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#get(java.lang.String)
//	 */
//	@Override
//	public String get(String key) {
//		try {
//			return jedis.get(key);
//		} catch (Exception ex) {
//			logger.error("incr error.", ex);
//		} finally {
//		}
//		return null;
//	}
//
//	public Jedis getjedis() {
//		return jedis;
//	}
//
//	@Override
//	public TreeSet<String> keys(String pattern) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Jedis getJedis() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#keys(java.lang.String)
//	 */
//	// public TreeSet<String> keys(String pattern) {
//	// TreeSet<String> keys = new TreeSet<String>();
//	// Map<String, JedisPool> clusterNodes = jedis.getClusterNodes();
//	// try {
//	// for (String k : clusterNodes.keySet()) {
//	// logger.info("Getting keys from: " + k + "");
//	// JedisPool jp = clusterNodes.get(k);
//	// Jedis connection = jp.getResource();
//	// try {
//	// keys.addAll(connection.keys(pattern));
//	// } catch (Exception e) {
//	// logger.error("Getting keys error: {}", e);
//	// } finally {
//	// logger.debug("Connection closed.");
//	// connection.close();//用完一定要close这个链接！！！
//	// }
//	// }
//	// return keys;
//	// } catch (Exception ex) {
//	// logger.error("Keys gotten!");
//	// } finally {
//	// }
//	// return null;
//	// }
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see com.travelsky.ypb.dao.redis.impl.IRedisDao#getjedis()
//	 */
//
//	@Override
//	public Set<String> fuzzyGet(String pattern) {
//		return jedis.keys(pattern);
//	}
//}
