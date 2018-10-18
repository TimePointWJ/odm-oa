package com.odm.oa.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.core.ApplicationContext;

/**
 * <p>
 * Title: Constants.java
 * </p>
 * <p>
 * Description: 常量类
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author HJR
 * @date 2017年12月8日上午22:51:09
 */
public class Constants {

	private Constants() {
		throw new IllegalStateException("Constants class");
	}

	/**
	 * 业务操作成功
	 */
	public static final Integer RESPONSE_STATUS_CODE_SUCCESS = 200;

	/**
	 * 业务操作成功消息
	 */
	public static final String RESPONSE_STATUS_MSG_SUCCESS = "success";
	/**
	 * 二维码生成失败
	 */
	public static final String QR_CODE_STATUS_MSG_ERROR = "二维码生成失败";
	/**
	 * 业务操作失败消息
	 */
	public static final String RESPONSE_STATUS_MSG_ERROR = "error";
	/**
	 * 库存二维码唯一
	 */
	public static final String INVENTORY_QRCODE_UNIQUE_MSG_ERROR = "库存二维码唯一";
	/**
	 * 库存中商品不存在
	 */
	public static final String INVENTORY_NO_COMMODITY_MSG_ERROR = "库存中商品不存在";
	/**
	 * 库存状态有误
	 */
	public static final String INVENTORY_IN_STATUS_MSG_ERROR = "库存状态有误";
	/**
	 * 库存状态有误
	 */
	public static final String INVENTORY_CHECK_REPEAT_MSG_ERROR = "此商品盘点重复";
	/**
	 * 订单未查到
	 */
	public static final String ORDER_ID_STATUS_MSG_ERROR = "订单号未查到";
	/**
	 * 二维码批次序列
	 */
	public static final String PRODUCT_BATCH_NO_LIST = "product_batch_no";
	/**
	 * 二维码批次序列
	 */
	public static final String WECHAT_SCENEID_LIST = "wechat_sceneId";
	/**
	 * 运营二维码生成sceneId
	 */
	public static final String WECHAT_SCENEID_SPAN_LIST = "wechat_sceneId_span";
	/**
	 * 结束时间不能比开始时间早
	 */
	public static final String ORDER_TIME_STATUS_MSG_ERROR = "亲！时间区间错了哦";
	/**
	 * 优惠券修改后数量小于已领取数量
	 */
	public static final String RESPONSE_COUNT_MSG_ERROR = "优惠券修改后数量不能小于已领取数量";
	/**
	 * 订单状态错误
	 */
	public static final String ORDER_STATUS_STATUS_MSG_ERROR = "订单状态错误";
	/**
	 * 出库单已经开始出库
	 */
	public static final String OUT_STORAGE_LIST_ALREADY_OUT_STATUS_MSG_ERROR = "出库单已经开始出库";
	/**
	 * 业务操作失败
	 */
	public static final Integer RESPONSE_STATUS_CODE_FAILED = 201;

	/**
	 * 参数错误
	 */
	public static final Integer RESPONSE_STATUS_CODE_FAILED_202 = 202;

	/**
	 * 未支付
	 */
	public static final Integer RESPONSE_STATUS_CODE_FAILED_301 = 301;

	/**
	 * 参数错误消息
	 */
	public static final String ERROR_MSG_202 = "参数错误";

	/**
	 * 后台系统异常
	 */
	public static final Integer RESPONSE_STATUS_CODE_FAILED_999 = 999;

	/**
	 * 系统毫秒格式化格式去掉年份前两位
	 */
	public static final String YMDHMSS = "yyMMddHHmmssSSS";

	/**
	 * 后台系统异常消息
	 */
	public static final String ERROR_MSG_999 = "后台系统异常";

	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_MENULIST = "menuList"; // 当前菜单
	public static final String SESSION_ALLMENULIST = "allmenuList"; // 全部菜单
	public static final String SESSION_USERROL = "USERROL"; // 用户对象
	public static final String SESSION_USERNAME = "USERNAME"; // 用户名
	public static final String LOGIN = "/login"; // 登录地址

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	public static final String EVALUATE_0 = "0"; // 评论未审核
	public static final String EVALUATE_1 = "1"; // 审核通过
	public static final String EVALUATE_2 = "2"; // 审核不通过
	public static final String EVALUATE_3 = "3"; // 审核通过后删除

	// 下拉列表Map
	public static final String COMBO_BOX_TYPE_DEPT = "deptMap";// 部门
	public static final String COMBO_BOX_TYPE_USER = "userMap";// 用户
	public static final String COMBO_BOX_TYPE_MODULE = "moduleMap";// 菜单
	public static final String COMBO_BOX_TYPE_ROLE = "roleMap";// 角色
	public static final String COMBO_BOX_TYPE_DICTIONARY = "dictionaryMap";// 数据字典

	// 下拉列表数据类型(0:String类型型 1:对象类型)
	public static final String COMBO_BOX_MAP_TYPE_0 = "0";
	public static final String COMBO_BOX_MAP_TYPE_1 = "1";
	// 删除标识
	public static final Boolean DEL_FLG = false;
	public static final Boolean IS_DELETE = true;
	// 版本号
	public static final int VERSION = 1;

	/**
	 * 地区区分1：省 2：市 3：区
	 */
	public static final String AREA_KBN_1 = "1";
	public static final String AREA_KBN_2 = "2";
	public static final String AREA_KBN_3 = "3";

	public static final String BIND_SUCCESS = "操作成功！";

	public static final String BIND_ERROR = "操作失败！";

	public static final String ZERO = "0";

	public static final String BLANK = "";
	public static final String STRING_0 = "0";
	public static final String STRING_1 = "1";
	public static final String STRING_2 = "2";
	public static final String STRING_3 = "3";
	public static final String STRING_4 = "4";
	public static final String STRING_5 = "5";
	public static final String STRING_6 = "6";
	public static final String STRING_7 = "7";
	public static final String STRING_8 = "8";
	public static final String STRING_9 = "9";
	public static final String STRING_10 = "10";
	public static final String STRING_11 = "11";
	public static final String STRING_12 = "12";
	public static final String STRING_13 = "13";
	public static final String STRING_14 = "14";
	public static final String STRING_15 = "15";
	public static final String STRING_16 = "16";
	public static final String STRING_17 = "17";
	public static final String STRING_18 = "18";
	public static final String STRING_19 = "19";
	public static final String STRING_20 = "20";
	public static final String STRING_22 = "22";

	public static final String STRING_01 = "01";

	// 用户默认密码
	public static final String DEFAULT_USER_PASSWORD = "123456";// NOSONARTLINT

	@SuppressWarnings("serial")
	public final static Map<Integer, String> GET_WEEK = new HashMap<Integer, String>() {// NOSONARTLINT
		{// NOSONARTLINT
			put(1, "周一");
			put(2, "周二");
			put(3, "周三");
			put(4, "周四");
			put(5, "周五");
			put(6, "周六");
			put(7, "周日");
		}
	};
	public static final String STR_SCHOOL = "school";
	public static final String STR_DORM = "dormBuilding";
	// delflg
	public static final String DEL_FLG_STR = "delFlg";
	// version
	public static final String VERSION_STR = "version";
	// createId
	public static final String CREATE_ID_STR = "createId";
	// createTime
	public static final String CREATE_TIME_STR = "createTime";
	// updateId
	public static final String UPDATE_ID_STR = "updateId";
	// updateTime
	public static final String UPDATE_TIME_STR = "updateTime";

	// long
	public static final Long LONG_1 = 1l;
	public static final Long LONG_0 = 0l;
	// 序列名称
	public static final String SEQ_NAME_IN_STORAGE_LIST_ID = "in_storage_list_id";
	public static final String SEQ_NAME_INVENTORY_CHECK_ID = "inventory_check_id";

	// redis相关配置
	public static final String REDIS_IP_TEST = "47.101.50.97";
	// public static final String REDIS_IP_TEST =
	// "r-uf64657dfcf87674.redis.rds.aliyuncs.com";
	public static final int REDIS_PORT_TEST = 6379;
	public static final String REDIS_PORT_PWD = "Nutak888888";

	public static final String COMMA = ",";
	public static final String REDIS_KEY_MODULE = "module";
	public static final String REDIS_KEY_USERID = "userId";
	public static final int REDIS_SESSION = 30 * 60;// redis的缓存设置为30min

	// 商品编号重复
	public static final String COMMODITY_ID_EXIST = "商品编号已存在";
	// 在库标识 1：在库，0：出库
	public static final String INVENTORY_IN_STATUS_1 = "1";
	public static final String INVENTORY_IN_STATUS_0 = "0";
	// 退货标识 0：未退货，1：未拆包装退货，2：已拆包装退货
	public static final String INVENTORY_BACK_STATUS_0 = "0";
	public static final String INVENTORY_BACK_STATUS_1 = "1";
	public static final String INVENTORY_BACK_STATUS_2 = "2";
	// 退换标识0：未退换，1:退换拆下已下单，2：已拆卸，3：退回物流中，4：退货已入库，5：新货出库物流中，6：新货已到未安装，7：新货已安装
	// 8:退货未拆卸取消退换
	public static final String INSTALL_EXCHANGE_STATUS_0 = "0";
	public static final String INSTALL_EXCHANGE_STATUS_1 = "1";
	public static final String INSTALL_EXCHANGE_STATUS_2 = "2";
	public static final String INSTALL_EXCHANGE_STATUS_3 = "3";
	public static final String INSTALL_EXCHANGE_STATUS_4 = "4";
	public static final String INSTALL_EXCHANGE_STATUS_5 = "5";
	public static final String INSTALL_EXCHANGE_STATUS_6 = "6";
	public static final String INSTALL_EXCHANGE_STATUS_7 = "7";
	public static final String INSTALL_EXCHANGE_STATUS_8 = "8";
	// 取消订单非删除
	public static final boolean DEL_EXCHANGE_FLG_FALSE = false;
	// 原产品编号默认
	public static final Long OLD_COMONDITY_ID = 1L;
	// 原退回编号默认
	public static final String OLD_EXPRESS_ID = "1";
	// 退货状态默认处理状态
	public static final String RETURN_RETURN_STATUS_0 = "0";// 0：退货申请中
	public static final String RETURN_RETURN_STATUS_1 = "1";// 1:退款一审审核中
	public static final String RETURN_RETURN_STATUS_2 = "2";// 2:退货审核驳回
	public static final String RETURN_RETURN_STATUS_3 = "3";// 3：退货审核通过拆卸下单
	public static final String RETURN_RETURN_STATUS_4 = "4";// 4：已拆卸
	public static final String RETURN_RETURN_STATUS_5 = "5";// 5：退回物流中
	public static final String RETURN_RETURN_STATUS_6 = "6";// 6：退货已入库
	public static final String RETURN_RETURN_STATUS_7 = "7";// 7：退货完成
	public static final String RETURN_RETURN_STATUS_8 = "8";// 8:待二审
	public static final String RETURN_RETURN_STATUS_9 = "9";// 9:二审审核中
	public static final String RETURN_RETURN_STATUS_10 = "10";// 10：二审审核通过
	public static final String RETURN_RETURN_STATUS_11 = "11";// 11：二审审核拒绝
	public static final String RETURN_RETURN_STATUS_12 = "12";// 12：等待退款
	public static final String RETURN_RETURN_STATUS_13 = "13";// 13：拒绝退款
	public static final String RETURN_RETURN_STATUS_14 = "14";// 14：退款完成
	// 优惠券审核状态：1:待审核、2：审核通过、3：审核不通过
	public static final String CONPON_APPROVAL_STATUS_0 = "0";
	public static final String CONPON_APPROVAL_STATUS_1 = "1";
	public static final String CONPON_APPROVAL_STATUS_2 = "2";
	// 优惠券状态1：正常、2：发布申请中、3：数量修改申请中、4：终止申请中、5：终止
	public static final String CONPON_CONPON_STATUS_0 = "0";
	public static final String CONPON_CONPON_STATUS_1 = "1";
	public static final String CONPON_CONPON_STATUS_2 = "2";
	public static final String CONPON_CONPON_STATUS_3 = "3";
	public static final String CONPON_CONPON_STATUS_4 = "4";
	// 优惠券优先级默认(5) 调大 >(4) 新人卷>(3) 现金卷>(2) 满减卷>(1) 折扣卷>(0) 调小
	public static final Integer CONPON_PRIORITY_1 = 1;
	public static final Integer CONPON_PRIORITY_2 = 2;
	public static final Integer CONPON_PRIORITY_3 = 3;
	public static final Integer CONPON_PRIORITY_4 = 4;
	// 1：现金券、2：满减券、3：折扣券、4：新人券
	public static final String CONPON_CONPON_TYPE_0 = "0";
	public static final String CONPON_CONPON_TYPE_1 = "1";
	public static final String CONPON_CONPON_TYPE_2 = "2";
	public static final String CONPON_CONPON_TYPE_3 = "3";
	// 1：所有人可用、2：指定人员可用、3：指定人员不可用
	public static final String CONPON_CONPON_USE_PERSON_0 = "0";
	public static final String CONPON_CONPON_USE_PERSON_1 = "1";
	public static final String CONPON_CONPON_USE_PERSON_2 = "2";
	// 指定人使用类型 1：可用、不可用
	public static final String CONPON_USE_TYPE_0 = "0";
	public static final String CONPON_USE_TYPE_1 = "1";
	// 1：所有套餐可用、2：指定套餐可用、3：指定套餐不可用
	public static final String CONPON_CONPON_USE_SET_0 = "0";
	public static final String CONPON_CONPON_USE_SET_1 = "1";
	public static final String CONPON_CONPON_USE_SET_2 = "2";
	// 指定人使用类型 1：可用、不可用
	public static final String CONPON_SET_USE_TYPE_0 = "0";
	public static final String CONPON_SET_USE_TYPE_1 = "1";
	// 优惠券是否使用
	public static final String CUSTOMER_CONPON_STATUS_1 = "1";// 未使用
	public static final String CUSTOMER_CONPON_STATUS_2 = "2";// 已使用
	public static final String CUSTOMER_CONPON_STATUS_3 = "3";// 过期
	public static final String CUSTOMER_CONPON_STATUS_4 = "4";// 终止

	// 已领取数量默认为0
	public static final Integer CONPON_RECEIVE_COUNT = 0;
	// 已使用数量默认为0
	public static final Integer CONPON_USED_COUNT = 0;
	// 退还管理序列名称
	public static final String SEQ_NAME_EXCHANGE_ID = "exchange_id";
	// SYSTEM_MANAGE appid
	public static final String SYSTEM_MANAGE_APPID = "appid";
	// SYSTEM_MANAGE secret
	public static final String SYSTEM_MANAGE_SECRET = "secret";
	// 新人优惠券id
	public static final String OPERATE_QR_CODE_CONPON = "operate_qr_code_conpon";
	// SYSTEM_MANAGE product_qr_code_url
	public static final String SYSTEM_MANAGE_PRODUCT_QR_CODE_URL = "product_qr_code_url";
	// 页面访问日志访问类型编号access_customer_type
	public static final String PAGE_ACCESS_LOG_CUSTOMER_TYPE_1 = "1";
	public static final String PAGE_ACCESS_LOG_CUSTOMER_TYPE_2 = "2";
	public static final String PAGE_ACCESS_LOG_CUSTOMER_TYPE_3 = "3";
	// 页面访问日志访问ISP编号
	public static final String PAGE_ACCESS_LOG_ISP_1 = "1";
	public static final String PAGE_ACCESS_LOG_ISP_2 = "2";
	public static final String PAGE_ACCESS_LOG_ISP_3 = "3";
	public static final String PAGE_ACCESS_LOG_ISP_4 = "4";
	// 页面访问日志访问ISP类型
	public static final String PAGE_ACCESS_LOG_ISP_TYPE_1 = "移动";
	public static final String PAGE_ACCESS_LOG_ISP_TYPE_2 = "电信";
	public static final String PAGE_ACCESS_LOG_ISP_TYPE_3 = "联通";
	// 页面访问日志访问渠道编号access_channel 1：PC官网，2：手机官网
	public static final String PAGE_ACCESS_LOG_ACCESS_CHANNEL_1 = "1";
	public static final String PAGE_ACCESS_LOG_ACCESS_CHANNEL_2 = "2";
	// 页面访问日志设备信息编号access_mechine_info id
	// 1:iphone,2:android,3:windows,4:mac,5:linux
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_1 = "1";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_2 = "2";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_3 = "3";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_4 = "4";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_5 = "5";
	// 页面访问日志设备信息类型access_mechine_info type
	// 1:iphone,2:android,3:windows,4:mac,5:linux
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_TYPE_1 = "iPhone";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_TYPE_2 = "Android";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_TYPE_3 = "Windows";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_TYPE_4 = "Mac";
	public static final String PAGE_ACCESS_LOG_ACCESS_MECHINE_INFO_TYPE_5 = "Linux"; // 评论用
	// 正向词汇文件路径
	public static final String POSITIVE_PATH = "positive.txt";
	// 负向词汇文件路径
	public static final String NEGATIVE_PATH = "negative.txt";
	// 敏感词汇文件路径
	public static final String SENSITIVE_PATH = "sensitive.txt";
	public static final String POSITIVE = "product_positive_path";
	public static final String NEGATIVE = "product_negative_path";
	public static final String SENSITIVE = "product_sensitive_path";
	public static final String REDIS_KEY_POSITIVE = "FilterKeyWord:positive";
	public static final String REDIS_KEY_NEGATIVE = "FilterKeyWord:negative";
	public static final String REDIS_KEY_SENSITIVE = "FilterKeyWord:sensitive";
	public static final String POSITIVE_WORD = "0";
	public static final String NEGATIVE_WORD = "1";
	// Excel文件路径
	public static final String QR_CODE_EXCEL_URL = "qr_code_excel_url";

	// 聚合URL
	public static final String GET_JUHE_DATA_URL = "http://web.juhe.cn:8080/environment/air/pm?city={0}&key={1}";
	// GET
	public static final String GET = "GET";
	// POST
	public static final String POST = "POST";

	public static final String PATH_PATTERNS = "/**"; // url请求的路径模式

	public static final String NO_INTERCEPTOR_PATH = ".*/((tohomepage)|(tologin)|(login)|(logout)|(static)|(code))"; // 不对匹配该值的访问路径拦截（正则）

	public static final ApplicationContext WEB_APP_CONTEXT = null; // 该值会在web容器启动时由WebAppContextListener初始化
	// GET
	public static final String MOVE_MAGAHE_STATUS_0 = "0";// 移机状态，默认为0，表示移机申请
	public static final String MOVE_MAGAHE_STATUS_1 = "1";// 表示拆卸下单
	public static final String MOVE_MAGAHE_STATUS_2 = "2";// 表示已拆卸
	public static final String MOVE_MAGAHE_STATUS_3 = "3";// 表示安装下单
	public static final String MOVE_MAGAHE_STATUS_4 = "4";// 表示已下单
	// 未登录，userid共通
	public static final String NO_LOGIN_USER_ID = "guest";
	public static final String RETURN_MAGAHE_STATUS_0 = "0";// 退货状态，默认为0，表示退货申请
	public static final String RETURN_MAGAHE_STATUS_1 = "1";// 表示拆卸下单
	public static final String RETURN_MAGAHE_STATUS_2 = "2";// 表示已拆卸
	public static final String RETURN_MAGAHE_STATUS_3 = "3";// 表示返回物流
	public static final String RETURN_MAGAHE_STATUS_4 = "4";// 表示退货入库
	public static final String RETURN_MAGAHE_STATUS_5 = "5";// 表示退货完成
	public static final String RETURN_MAGAHE_STATUS_6 = "6";// 表示退货驳回

	public static final String RETURN_MAGAHE_TYPE_0 = "0";// 表示7天内未安装退货
	public static final String RETURN_MAGAHE_TYPE_1 = "1";// 表示7天内安装后退货
	public static final String RETURN_MAGAHE_TYPE_2 = "2";// 表示非违约退货
	public static final String RETURN_MAGAHE_TYPE_3 = "3";// 表示违约退货

	// 符号类
	public static final String STRING_POINT = ".";
	public static final String STRING_COMMA = ",";
	public static final String STRING_BAR = "-";
	public static final String STRING_QUESTION = "?";
	public static final String STRING_EQUAL = "=";

	// int 常量
	public static final int INT_0 = 0;
	public static final int INT_1 = 1;
	public static final int INT_2 = 2;
	public static final int INT_3 = 3;
	public static final int INT_4 = 4;
	public static final int INT_5 = 5;
	public static final int INT_6 = 6;
	public static final int INT_7 = 7;
	public static final int INT_8 = 8;
	public static final int INT_9 = 9;
	public static final int INT_10 = 10;
	public static final int INT_11 = 11;
	public static final int INT_12 = 12;
	public static final int INT_13 = 13;
	public static final int INT_14 = 14;
	public static final int INT_15 = 15;
	public static final int INT_16 = 16;
	public static final int INT_17 = 17;
	public static final int INT_18 = 18;
	public static final int INT_19 = 19;
	public static final int INT_20 = 20;

	// 订单状态常量
	public static final String ORDER_STATUS_0 = "0";// 订单作废
	public static final String ORDER_STATUS_1 = "1";// 待支付
	public static final String ORDER_STATUS_2 = "2";// 已支付，待确认
	public static final String ORDER_STATUS_3 = "3";// 支付成功
	public static final String ORDER_STATUS_4 = "4";// 代发货
	public static final String ORDER_STATUS_5 = "5";// 准备出库
	public static final String ORDER_STATUS_6 = "6";// 快递已揽货，配送中
	public static final String ORDER_STATUS_7 = "7";// 快递已签收
	public static final String ORDER_STATUS_8 = "8";// 未安装退货申请
	public static final String ORDER_STATUS_9 = "9";// 未安装退货中
	public static final String ORDER_STATUS_10 = "10";// 未安装已退货，退货申请中
	public static final String ORDER_STATUS_11 = "11";// 未安装，已退款
	public static final String ORDER_STATUS_12 = "12";// 已安装
	public static final String ORDER_STATUS_13 = "13";// 已安装退货申请中
	public static final String ORDER_STATUS_14 = "14";// 已安装退货中
	public static final String ORDER_STATUS_15 = "15";// 已安装，已退货，退款申请中
	public static final String ORDER_STATUS_16 = "16";// 已安装，已退款
	public static final String ORDER_STATUS_17 = "17";// 订单完成

	// 交易类型
	public static final String PAY_TYPE_0 = "0";// 购买
	public static final String PAY_TYPE_1 = "1";// 退款

	// 支付状态
	public static final String PAY_STATUS_0 = "0";// 等待支付
	public static final String PAY_STATUS_1 = "1";// 支付中
	public static final String PAY_STATUS_2 = "2";// 支付完成
	public static final String PAY_STATUS_3 = "3";// 支付取消
	public static final String PAY_STATUS_4 = "4";// 支付拒绝
	public static final String PAY_STATUS_5 = "5";// 支付放弃

	// 支付方式类型
	public static final String PAY_METHOD_1 = "1";// 微信
	public static final String PAY_METHOD_2 = "2";// 支付宝

	/**
	 * 下单渠道（官网）
	 */
	public static final String SINGLE_CHANNEL_WEB = "1";

	/**
	 * 下单渠道（微信公众号）
	 */
	public static final String SINGLE_CHANNEL_WECHAT = "2";

	/**
	 * 支付渠道（支付宝）
	 */
	public static final String CHANNEL_OF_PAYMENT_ALIPAY = "3";

	/**
	 * 支付渠道（微信）
	 */
	public static final String CHANNEL_OF_PAYMENT_WECHAT = "4";
	// 实物存在，db中没有
	public static final String INVENTORY_CHECK_DB_NO = "1";
	// 实物没又，db中存在
	public static final String INVENTORY_CHECK_REAL_NO = "2";

	// Task Name
	public static final String TASK_NAME_UPDATECELLPHONE = "UpdateCellerPhoneAuthorityTblTask";
	public static final String TASK_NAME_CONTRACT_EXTEND = "ContractExtentionReminderTask";
	public static final String TASK_NAME_CONTRACT_BROKEN = "ContractBrokenReminderTask";
	public static final String TASK_NAME_OUTSTORAGE = "OutStorageReminderTask";
	public static final String TASK_NAME_VIOLATE_MANAGE = "ViolateManageReminderTask";
	public static final String TASK_NAME_WECHAT_SEND = "SendWechatContantTask";
	public static final String TASK_NAME_MACHINE_STATUS = "MachineStatusTask";
	public static final String TASK_NAME_MAIN_ORDER = "MainOrderTask";
	public static final String TASK_NAME_INVENTORY_DAILY_LOG = "InventoryDailyLogTask"; // 系统配置-下次基准日
	public static final String NEXT_BASE_DATE = "next_base_date";
	public static final String TASK_NAME_PRODUCT_STAT = "ProductDailyStatTask"; // 产品分析把期任务
	public static final String TASK_NAME_CUSTOMER_STAT = "CustomerDailyStatTask"; // 顾客分析把期任务
	public static final String TASK_NAME_MARKET_STAT = "MarketingDailyStatTask"; // 营销分析把期任务
	public static final String TASK_NAME_SALES_STAT = "SalesDailyStatTask"; // 销售分析把期任务
	public static final String TASK_NAME_MAC_OPEN_CLOSE_TIME_STAT = "MacOpenCloseTimeStatTask"; // 机器开关机时间统计把期任务
	public static final String TASK_NAME_DAILY_MECHINE_USE_STAT = "DailyMechineUseStatTask"; // 每日机器使用统计把期任务
	public static final String TASK_NAME_PAGE_ACCESS_STAT = "PageAccessStatTask";
	public static final String TASK_NAME_FIRST_BUY_STAT = "FirstBuyStatTask";
	public static final String TASK_NAME_PUBLIC_NUM_CONCERN_STAT = "PublicNumConcernStatTask"; // 奖励状态
	public static final String REWARD_STATUS_0 = "0";// 未发放
	public static final String REWARD_STATUS_1 = "1";// 已发放
	public static final String REWARD_STATUS_2 = "2";// 已驳回
	public static final String REWARD_STATUS_3 = "3";// 已消费

	// 红包是否被使用
	public static final String RED_PACKET_TYPE_0 = "0";// 未使用
	public static final String RED_PACKET_TYPE_1 = "1";// 已使用

	// 退货订单状态
	public static final String RETURN_STATUS_0 = "0";// 0：退货申请中，
	public static final String RETURN_STATUS_1 = "1";// 1:退款一审审核中,
	public static final String RETURN_STATUS_2 = "2";// 2:退货审核驳回,
	public static final String RETURN_STATUS_3 = "3";// 3：退货审核通过拆卸下单，
	public static final String RETURN_STATUS_4 = "4";// 4：已拆卸，
	public static final String RETURN_STATUS_5 = "5";// 5：退回物流中，
	public static final String RETURN_STATUS_6 = "6";// 6：退货已入库，
	public static final String RETURN_STATUS_7 = "7";// 7：退货完成，
	public static final String RETURN_STATUS_8 = "8";// 8:待二审
	public static final String RETURN_STATUS_9 = "9";// 9:二审审核中，
	public static final String RETURN_STATUS_10 = "10";// 10：二审审核通过，
	public static final String RETURN_STATUS_11 = "11";// 11：二审审核拒绝，
	public static final String RETURN_STATUS_12 = "12";// 12：等待退款，
	public static final String RETURN_STATUS_13 = "13";// 13：拒绝退款，
	public static final String RETURN_STATUS_14 = "14";// 14：退款完成

	// 退货锁定状态
	public static final String LOCK_STATUS_0 = "0";// 0：解锁
	public static final String LOCK_STATUS_1 = "1";// 0：锁定
	// 退货流水类型
	public static final String FLOW_TYPE_0 = "0";// 0：一审流水
	public static final String FLOW_TYPE_1 = "1";// 1：二审流水
	public static final String FLOW_TYPE_2 = "2";// 1：退款流水
	// 二维码扫码跳转
	public static final String QRCODE_RETURN_1 = "1";// 推广页面
	public static final String QRCODE_RETURN_2 = "2";// 续费页面

	// 二维码类型
	public static final String QRCODE_TYPE_1 = "1";// 运营二维码
	public static final String QRCODE_TYPE_2 = "2";// 产品二维码
	public static final String QRCODE_TYPE_3 = "3";// 分享二维码

	// 顾客渠道区分
	public static final String COME_TYPE_1 = "1";// 官网
	public static final String COME_TYPE_2 = "2";// 营销二维码
	public static final String COME_TYPE_3 = "3";// 产品二维码
	public static final String COME_TYPE_4 = "4";// 用户分享二维码
	public static final String COME_TYPE_5 = "5"; // 公众号关注

	// 移机状态
	public static final String MOVE_STATUS_0 = "0";// 0:移机申请中，
	public static final String MOVE_STATUS_1 = "1";// 1：拆卸已下单，
	public static final String MOVE_STATUS_2 = "2";// 2:已拆卸，
	public static final String MOVE_STATUS_3 = "3";// 3：安装已下单，
	public static final String MOVE_STATUS_4 = "4";// 4：已安装,
	public static final String MOVE_STATUS_5 = "5";// 5：移机取消

	// 退换状态
	public static final String EXCHANGE_STATUS_0 = "0";// 0：未退换，
	public static final String EXCHANGE_STATUS_1 = "1";// 1:退换拆下已下单，
	public static final String EXCHANGE_STATUS_2 = "2";// 2：已拆卸，
	public static final String EXCHANGE_STATUS_3 = "3";// 3：退回物流中，
	public static final String EXCHANGE_STATUS_4 = "4";// 4：退货已入库，
	public static final String EXCHANGE_STATUS_5 = "5";// 5：新货出库物流中，
	public static final String EXCHANGE_STATUS_6 = "6";// 6：新货已到未安装，
	public static final String EXCHANGE_STATUS_7 = "7";// 7：新货已安装，
	public static final String EXCHANGE_STATUS_8 = "8";// 8:未拆卸取消

	// 4G模块通讯命令
	public static final String COMMAND_D12_OPEN = "ON";// 开机
	public static final String COMMAND_D12_CLOSE = "OFF";// 关机
	public static final String COMMAND_D13_D1 = "D1";// 一档
	public static final String COMMAND_D13_D2 = "D2";// 二档
	public static final String COMMAND_D13_D3 = "D3";// 三档
	public static final String COMMAND_D13_D4 = "D4";// 四档
	public static final String COMMAND_D14_RELIEVE = "R";// 滤网提示解除
	public static final String COMMAND_D14_EXPIRED = "E";// 滤网过期提示
	public static final String COMMAND_D15_LOCK = "L";// 锁死
	public static final String COMMAND_D15_UNLOCK = "U";// 解锁
	// 收支方式
	public static final String TRADE_PAY_TYPE_0 = "0";// 收入
	public static final String TRADE_PAY_TYPE_1 = "1";// 支出

	// 是否对账
	public static final String RECONCILIATION_1 = "1";// 未对帐
	public static final String RECONCILIATION_2 = "2";// 已对账

	// 流水状态
	public static final String TRADE_STATE_0 = "0";// 有效
	public static final String TRADE_STATE_1 = "1";// 无效

	// 流水类型 0：订单，1：退款，2：运费险，3：配送,4:佣金,5:特殊退款
	public static final String TRADE_TYPE_0 = "0";
	public static final String TRADE_TYPE_1 = "1";
	public static final String TRADE_TYPE_2 = "2";
	public static final String TRADE_TYPE_3 = "3";
	public static final String TRADE_TYPE_4 = "4";
	public static final String TRADE_TYPE_5 = "5";

	// 收款人账户类型
	public static final String RETURN_ACCOUNT_TYPE_0 = "0";// 支付宝
	public static final String RETURN_ACCOUNT_TYPE_1 = "1";// 微信
	public static final String RETURN_ACCOUNT_TYPE_2 = "2";// 银联卡
	public static final String RETURN_ACCOUNT_TYPE_3 = "3";// 信用卡
	public static final String RETURN_ACCOUNT_TYPE_4 = "4";// 其他

	// 商品
	public static final Long COMPLETE_MACHINE_TYPE_0 = 1L;// 整机
	public static final Long FILTER_ELEMENT_TYPE_1 = 2L;// 滤芯

	// 系统配置
	public static final Long SYSTEM_MANAGE_PAY_ORDER_TIME = 1L; // 订单支付时限
	public static final Long SYSTEM_MANAGE_NEXT_BASE_DATA = 11L; // 下个基准日

	// 上传图片来源
	public static final String KEY_TYPE_0 = "0";// 订单
	public static final String KEY_TYPE_1 = "1";// 图片
	public static final String KEY_TYPE_2 = "2";// 公众号模板

	/*************************************
	 * 微信公众号用 start TODO
	 *************************************************/
	public static final String ACCESS_TOKEN = "";// 纽塔克微信公众号端token
	// public static final String APPID = "wx66c4e2c76a15ae56";//纽塔克微信公众号端appid
	// test
	public static final String APPID = "wx326173030da9ae8b";// 纽塔克微信公众号端appid

	// public static final String APP_SECRET =
	// "1dd6c07c712c56eb24562da82d6ea5b2";//纽塔克微信公众号端secret test
	public static final String APP_SECRET = "ae56ff5b88effc182193c8a786777d47";// 纽塔克微信公众号端secret

	// 校务端推送详情URL
	public static final String URL_DETAIL_BASE_PRE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
			+ APPID + "&redirect_uri=";
	public static final String URL_DETAIL_BASE_END = "&response_type=code&scope=snsapi_base";

	// 微信公众号模板消息推送
	public static final String GET_WECHAT_TOKEN_URL_PARENT = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ APPID + "&secret=" + APP_SECRET;
	public static final String PUSH_URL_REQUEST = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	public static final String TOUSER = "touser";
	public static final String TEMPLATE_ID = "template_id";
	public static final String LINK_URL = "url";

	public static final String VALUE = "value";
	public static final String COLOR = "color";

	// public static final String SERVER_IP = "www.51anxuebao.com.cn";//域名或IP
	public static final String SERVER_IP = "www.51anxuebao.com.cn";// 域名或IP test
	/*************************************
	 * 微信公众号用 end TODO
	 *************************************************/

	// 提现处理状态
	public static final String SPREAD_WITHDRAW_STATUS_0 = "0";// 0：返现申请中
	public static final String SPREAD_WITHDRAW_STATUS_1 = "1";// 1:返现一审审核中
	public static final String SPREAD_WITHDRAW_STATUS_2 = "2";// 2:返现审核驳回
	public static final String SPREAD_WITHDRAW_STATUS_3 = "3";// 3:待二审
	public static final String SPREAD_WITHDRAW_STATUS_4 = "4";// 4:二审审核中
	public static final String SPREAD_WITHDRAW_STATUS_5 = "5";// 5：二审审核通过
	public static final String SPREAD_WITHDRAW_STATUS_6 = "6";// 6：二审审核拒绝
	public static final String SPREAD_WITHDRAW_STATUS_7 = "7";// 7：等待返现
	public static final String SPREAD_WITHDRAW_STATUS_8 = "8";// 8：拒绝返现
	public static final String SPREAD_WITHDRAW_STATUS_9 = "9";// 9：返现完成

	// 红包使用类型
	public static final String RED_PACKET_LOG_TYPE_1 = "1";// 入账
	public static final String RED_PACKET_LOG_TYPE_2 = "2";// 提现
	public static final String RED_PACKET_LOG_TYPE_3 = "3";// 支付

	// 发票状态 P: 申请开票； D: 已开票；S: 纸质发票已邮寄
	public static final String INVOICE_STATUS_PENDING = "P";
	public static final String INVOICE_STATUS_DONE = "D";
	public static final String INVOICE_STATUS_SENT = "S";

	// 性别 1：男 2：女
	public static final String SEX_MALE = "1";
	public static final String SEX_FEMALE = "2";
	public static final String SEX_UNKNOWN = "0";

	// 设置时间间隔，当Date_interval_1查询按日间隔
	public static final String Date_interval_1 = "1";
	// 设置时间间隔，当Date_interval_2查询按月间隔
	public static final String Date_interval_2 = "2";
	// 设置时间间隔，当Date_interval_3查询按年间隔
	public static final String Date_interval_3 = "3";

	// 模块名称
	public static final String FUNCTION_NAME_1 = "退货";
	public static final String FUNCTION_NAME_2 = "退换";
	public static final String FUNCTION_NAME_3 = "移机";
	public static final String FUNCTION_NAME_4 = "安装";
	public static final String FUNCTION_NAME_5 = "推广";

	// count次数标识
	public static final String COUNT_00 = "00";
	public static final String COUNT_01 = "01";
	public static final String COUNT_02 = "02";
	public static final String COUNT_03 = "03";
	public static final String COUNT_04 = "04";
	public static final String COUNT_05 = "05";
	public static final String COUNT_06 = "06";
	public static final String COUNT_07 = "07";
	public static final String COUNT_08 = "08";
	public static final String COUNT_09 = "09";

	// insertOrUpdateFlg
	public static final String INSERT_FLG = "insert";
	public static final String UPDATE_FLG = "update";

	// 文件夹名称已存在
	public static final String FOLDER_NAME_ALREADY_EXIST = "文件夹名称已存在！";

	// 删除标识String类型
	public static final String String_DEL_FLG = "0";
	public static final String String_IS_DELETE = "1";
}