package com.net.chl.okhttplibrary.net;

import android.support.annotation.NonNull;

public interface HttpApi {

	String BASE_URL="https://www.sojson.com";

//	String ROOT_URL = SLYSH.debugModel ? "http://gxzb.kospital.com" : "http://firstaid.skyhospital.net";
//	String COMMON_BASE_URL = ROOT_URL + "/index.php/api/gxzb/";
//	String IMAGE_BASE_URL = SLYSH.debugModel ? "http://210.14.72.52" : "http://210.14.72.61";


	/**登录*/
	String LOGIN= UrlJoint.getUrl("auth/login");
	/**注册发送验证码*/
	String SEND_AUTH_CODE_REGISTER= UrlJoint.getUrl("auth/register/send/sms");
	/**验证码登录获取验证码*/
	String SEND_AUTH_CODE_LOGIN= UrlJoint.getUrl("auth/login/send/sms");
	/**修改密码获取验证码*/
	String SEND_AUTH_CODE_RESET_PWD= UrlJoint.getUrl("auth/reset/password/send/sms");
	/**验证码登录*/
	String AUTH_CODE_LOGIN= UrlJoint.getUrl("auth/mobile/login");
	/**注册*/
	String REGISTER= UrlJoint.getUrl("auth/register");
	/**重置密码*/
	String RESET_PWD= UrlJoint.getUrl("auth/reset/password");
	/**上传头像，身份证照片*/
	String UPLOAD_PHOTO= UrlJoint.getUrl("baseuser/file_img");
	/**修改个人信息*/
	String UPLOAD_INFO= UrlJoint.getUrl("baseuser/alter_my_information");
	/**请求所有珠宝列表*/
	String JEWELRY_LIST= UrlJoint.getUrl("baseuser/show_home");
	/**珠宝详情*/
	String JEWELRY_DETAILS= UrlJoint.getUrl("baseuser/jewelry_info");
	/**共藏珠宝详情*/
	String SHARE_JEWELRY_INFO= UrlJoint.getUrl("baseuser/shared_jewelry");
	/**会员首页*/
	String VIP_PRIVILEGE_JEWELRY= UrlJoint.getUrl("baseuser/vip_privilege");
	/**会员介绍*/
	String VIP_INTRO= UrlJoint.getUrl("baseuser/vip_info");
	/**会员购买*/
	String BUY_VIP= UrlJoint.getUrl("baseuser/vip_purchase");
	/**搜索用户*/
	String SEARCH_FIREND= UrlJoint.getUrl("baseuser/search_member");
	/**添加好友*/
	String ADD_FIREND= UrlJoint.getUrl("baseuser/add_friend");
	/**好友列表*/
	String FIREND_LIST= UrlJoint.getUrl("baseuser/friends_list");
	/**删除好友*/
	String DEL_FRIEND= UrlJoint.getUrl("baseuser/del_friend");
	/**活动列表*/
	String ACTIVITY_LIST= UrlJoint.getUrl("baseuser/activity_list");
	/**我的活动列表*/
	String MY_PARTY_LIST= UrlJoint.getUrl("baseuser/my_activity");
	/**收货地址列表*/
	String ADDRESS_LIST= UrlJoint.getUrl("baseuser/delivery_address_list");
	/**添加收货地址*/
	String ADD_ADDRESS= UrlJoint.getUrl("baseuser/add_delivery_address");
	/**编辑收货地址*/
	String EDIT_ADDRESS= UrlJoint.getUrl("baseuser/delivery_address_edit");
	/**删除收货地址*/
	String DEL_ADDRESS= UrlJoint.getUrl("baseuser/delivery_address_del");
	/**下单*/
	String ORDER= UrlJoint.getUrl("baseuser/shared_jewelry_subscribe");
	/**订单列表*/
	String ORDER_LIST= UrlJoint.getUrl("baseuser/shared_jewelry_subscribe_list");
	/**报名参加活动*/
	String JOIN_PARTY= UrlJoint.getUrl("baseuser/activity_join");
	/**发起者详情*/
	String SPONSOR_INTRO= UrlJoint.getUrl("baseuser/sponsor");
	/**订单详情*/
	String ORDER_INTRO= UrlJoint.getUrl("baseuser/shared_jewelry_subscribe_info");
	/**修改订单状态*/
	String CHANGE_ORDER_STATE= UrlJoint.getUrl("baseuser/change_shared_subscribe_state");
	/**发布圈子*/
	String PUBLISH_CIRCLE= UrlJoint.getUrl("baseuser/release_circle");
	/**圈子列表*/
	String CIRCLE_LIST= UrlJoint.getUrl("baseuser/circle_list");
	/**取消点赞*/
	String CANCEL_APPROVE= UrlJoint.getUrl("baseuser/circle_cancel_like");
	/**点赞*/
	String APPROVE= UrlJoint.getUrl("baseuser/circle_like");
	/**圈子详情*/
	String CIRCLE_DETAILS= UrlJoint.getUrl("baseuser/circle_info");
	/**圈子评论*/
	String COMMENT= UrlJoint.getUrl("baseuser/circle_comment");
	/**修改圈子背景*/
	String UPDATE_CIRCLE_BG= UrlJoint.getUrl("baseuser/circle_background");
	/**聊天文件下载*/
	String DOWN_MMS = "get_mms";

	class UrlJoint{
		static String getUrl(@NonNull String url){
//			return url+"?"+"os_type="+"android"+"&"+"version="+ SystemInfo.getClientVersion();
            return "";
		}
	}
}
