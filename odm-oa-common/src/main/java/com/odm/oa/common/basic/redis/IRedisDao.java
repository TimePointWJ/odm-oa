//package com.odm.oa.common.basic.redis;
//
//import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;
//
//import redis.clients.jedis.Jedis;
//
//public interface IRedisDao {
//
//	/**
//	 * 设置一个key的过期时间（单位：秒）
//	 * 
//	 * @param key
//	 *            key值
//	 * @param seconds
//	 *            多少秒后过期
//	 * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
//	 */
//	public abstract long expire(String key, int seconds);
//
//	/**
//	 * 设置一个key在某个时间点过期
//	 * 
//	 * @param key
//	 *            key值
//	 * @param unixTimestamp
//	 *            unix时间戳，从1970-01-01 00:00:00开始到现在的秒数
//	 * @return 1：设置了过期时间 0：没有设置过期时间/不能设置过期时间
//	 */
//	public abstract long expireAt(String key, int unixTimestamp);
//
//	/**
//	 * 截断一个List
//	 * 
//	 * @param key
//	 *            列表key
//	 * @param start
//	 *            开始位置 从0开始
//	 * @param end
//	 *            结束位置
//	 * @return 状态码
//	 */
//	public abstract String trimList(String key, long start, long end);
//
//	/**
//	 * 检查Set长度
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract long countSet(String key);
//
//	/**
//	 * 添加到Set中（同时设置过期时间）
//	 * 
//	 * @param key
//	 *            key值
//	 * @param seconds
//	 *            过期时间 单位s
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean addSet(String key, int seconds, String... value);
//
//	/**
//	 * 添加到Set中
//	 * 
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean addSet(String key, String... value);
//
//	/**
//	 * @param key
//	 * @param value
//	 * @return 判断值是否包含在set中
//	 */
//	public abstract boolean containsInSet(String key, String value);
//
//	/**
//	 * 获取Set
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract Set<String> getSet(String key);
//
//	/**
//	 * 从set中删除value
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract boolean removeSetValue(String key, String... value);
//
//	/**
//	 * 从list中删除value 默认count 1
//	 * 
//	 * @param key
//	 * @param values
//	 *            值list
//	 * @return
//	 */
//	public abstract int removeListValue(String key, List<String> values);
//
//	/**
//	 * 从list中删除value
//	 * 
//	 * @param key
//	 * @param count
//	 * @param values
//	 *            值list
//	 * @return
//	 */
//	public abstract int removeListValue(String key, long count, List<String> values);
//
//	/**
//	 * 从list中删除value
//	 * 
//	 * @param key
//	 * @param count
//	 *            要删除个数
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean removeListValue(String key, long count, String value);
//
//	/**
//	 * 截取List
//	 * 
//	 * @param key
//	 * @param start
//	 *            起始位置
//	 * @param end
//	 *            结束位置
//	 * @return
//	 */
//	public abstract List<String> rangeList(String key, long start, long end);
//
//	/**
//	 * 检查List长度
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract long countList(String key);
//
//	/**
//	 * 添加到List中（同时设置过期时间）
//	 * 
//	 * @param key
//	 *            key值
//	 * @param seconds
//	 *            过期时间 单位s
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean addList(String key, int seconds, String... value);
//
//	/**
//	 * 添加到List
//	 * 
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean addList(String key, String... value);
//
//	/**
//	 * 添加到List(只新增)
//	 * 
//	 * @param key
//	 * @param list
//	 * @return
//	 */
//	public abstract boolean addList(String key, List<String> list);
//
//	/**
//	 * 获取List
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract List<String> getList(String key);
//
//	/**
//	 * 设置HashSet对象
//	 * 
//	 * @param field
//	 *            域名
//	 * @param key
//	 *            键值
//	 * @param value
//	 *            Json String or String value
//	 * @return
//	 */
//	public abstract boolean setHSet(String key, String field, String value);
//
//	/**
//	 * 获得HashSet对象
//	 * 
//	 * @param field
//	 *            域名
//	 * @param key
//	 *            键值
//	 * @return Json String or String value
//	 */
//	public abstract String getHSet(String key, String field);
//
//	/**
//	 * 删除HashSet对象
//	 * 
//	 * @param field
//	 *            域名
//	 * @param key
//	 *            键值
//	 * @return 删除的记录数
//	 */
//	public abstract long delHSet(String key, String field);
//
//	/**
//	 * 删除HashSet对象
//	 * 
//	 * @param field
//	 *            域名
//	 * @param key
//	 *            键值
//	 * @return 删除的记录数
//	 */
//	public abstract long delHSet(String key, String... field);
//
//	/**
//	 * 判断key是否存在
//	 * 
//	 * @param field
//	 *            域名
//	 * @param key
//	 *            键值
//	 * @return
//	 */
//	public abstract boolean existsHSet(String key, String field);
//
//	/**
//	 * 验证redis是否存在key
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public boolean existsKey(String key);
//
//	/**
//	 * 返回 field 指定的哈希集中所有字段的value值
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract List<String> hvals(String key);
//
//	/**
//	 * 返回 key 指定的哈希集中所有字段的key值
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract Set<String> hkeys(String key);
//
//	/**
//	 * 返回 key 指定的哈希key值总数
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract long lenHset(String key);
//
//	/**
//	 * 设置排序集合
//	 * 
//	 * @param key
//	 * @param score
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean setSortedSet(String key, long score, String value);
//
//	/**
//	 * 获得排序集合
//	 * 
//	 * @param key
//	 * @param startScore
//	 * @param endScore
//	 * @param orderByDesc
//	 * @return
//	 */
//	public abstract Set<String> getSoredSet(String key, long startScore, long endScore, boolean orderByDesc);
//
//	/**
//	 * 计算排序长度
//	 * 
//	 * @param key
//	 * @param startScore
//	 * @param endScore
//	 * @return
//	 */
//	public abstract long countSoredSet(String key, long startScore, long endScore);
//
//	/**
//	 * 删除排序集合
//	 * 
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean delSortedSet(String key, String value);
//
//	/**
//	 * 获得排序集合
//	 * 
//	 * @param key
//	 * @param startRange
//	 * @param endRange
//	 * @param orderByDesc
//	 * @return
//	 */
//	public abstract Set<String> getSoredSetByRange(String key, int startRange, int endRange, boolean orderByDesc);
//
//	/**
//	 * 获得排序打分
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract Double getScore(String key, String member);
//
//	/**
//	 * 设置对象
//	 * 
//	 * @param key：键值
//	 * @param second：保存多少秒
//	 * @param value：值
//	 * @return
//	 */
//	public abstract boolean set(String key, int second, String value);
//
//	/**
//	 * 设置值
//	 * 
//	 * @param key
//	 * @param value
//	 * @return
//	 */
//	public abstract boolean set(String key, String value);
//
//	/**
//	 * 根据key判断defaultValue是否存在
//	 * 
//	 * @param key
//	 * @param defaultValue
//	 * @return
//	 */
//	public abstract String get(String key, String defaultValue);
//
//	/**
//	 * 删除key所对应的值
//	 * 
//	 * @param key
//	 * @return
//	 */
//	public abstract boolean del(String key);
//
//	/**
//	 * 递增存储在由指定的值的key的数量
//	 * 
//	 * @param key
//	 * @return回复整数，键增量后的值
//	 * 
//	 * @case 127.0.0.1:6379> SET visitors 1000</br>
//	 *       OK</br>
//	 *       redis 127.0.0.1:6379> INCR visitors</br>
//	 *       (integer) 1001</br>
//	 *       redis 127.0.0.1:6379> GET visitors</br>
//	 *       (integer) 1001</br>
//	 */
//	public abstract long incr(String key);
//
//	/**
//	 * 减小存储在由指定的值的key的数量
//	 * 
//	 * @param key
//	 * @return回复整数，key增量后的值
//	 * 
//	 * @case redis 127.0.0.1:6379> SET visitors 1000</br>
//	 *       OK</br>
//	 *       redis 127.0.0.1:6379> DECRBY visitors 5</br>
//	 *       (integer) 995</br>
//	 */
//	public abstract long decr(String key);
//
//	/**
//	 * 得到key所对应的value
//	 * 
//	 * @param key
//	 * @return：string
//	 */
//	public abstract String get(String key);
//
//	/**
//	 * 得到key所对应的value
//	 * 
//	 * @param pattern
//	 * @return：string
//	 * 
//	 * @case Set keys = RedisUtil.keys("*");
//	 */
//	public abstract TreeSet<String> keys(String pattern);
//
//	/**
//	 * 获取jedisCluster
//	 * 
//	 * @return
//	 */
//	public abstract Jedis getJedis();
//
//	Set<String> fuzzyGet(String pattern);
//
//}
