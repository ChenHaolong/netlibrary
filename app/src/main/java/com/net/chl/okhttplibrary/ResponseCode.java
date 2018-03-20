package com.net.chl.okhttplibrary;

/**
 * 返回的请求状态码
 * @author 陈浩龙
 *
 */
public class ResponseCode {
	/**请求成功*/
	public static final int SUCCESS=1;
	/**请求进度*/
	public static final int PROGRESS = 2;
	// 无网络
	public static final int NO_NETWORK = 10;
	// 客户端http解析错误
	public static final int CLIENT_HTTP_RESOLVING_ERROR = 11;
	// 客户端协议错误
	public static final int CLIENT_PROTOCOL_ERROR = 12;
	// 服务器返回的json格式异常
	public static final int RESULT_DATA_ERROR = 13;
	// 未知错误
	public static final int UNKNOWN_ERR = 14;
	// 客户端取消请求
	public static final int CLIENT_INTERRUPTED = 15;


	// 如果系统返回一下的code，说明业务方面可能需要进行进一步的处理
	public static final int BASE_CODE = 1000; // 系统定义的错误code的基
	public static final int INVALID_SESSION = 1011;// 非法session
	public static final int BANNED_USER = 1999;
}
