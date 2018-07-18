package com.cf.result;

public class CodeMsg {

	// 通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
	public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
	public static CodeMsg ACCESS_LIMIT_REACHED = new CodeMsg(500103, "访问过于频繁");

	// 登录模块 5002xx
	public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
	public static CodeMsg PHONE_EMPTY = new CodeMsg(500212, "用户名不能为空");
	public static CodeMsg PHONE_ERROR = new CodeMsg(500213, "用户名格式错误");
	public static CodeMsg PHONE_NOT_EXIST = new CodeMsg(500214, "用户名不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");

	// *********新增**********//
	// 注册模块 5003xx
	public static CodeMsg USERNAME_EXIST = new CodeMsg(500310, "用户名已存在");
	public static CodeMsg USERPHONE_EXIST = new CodeMsg(500311, "手机号已绑定");
	public static CodeMsg USERMAIL_EXIST = new CodeMsg(500312, "邮箱已绑定");
	public static CodeMsg USERPHONE_FORMAT_ERROR = new CodeMsg(500313, "手机号格式错误");

	// 订单模块 5004xx
	public static CodeMsg ORDER_NOT_EXIST = new CodeMsg(500400, "订单不存在");
	public static CodeMsg USER_NOT_EXIST = new CodeMsg(500401, "用户名不存在");
	public static CodeMsg PROJECT_NOT_EXIST = new CodeMsg(500402, "项目不存在");
	public static CodeMsg ORDER_REQUEST_ERROR = new CodeMsg(500402, "订单请求失败");

	// 项目状态码
	public static CodeMsg TO_SUBMIT = new CodeMsg(0, "待提交");
	public static CodeMsg TO_REVIEW = new CodeMsg(1, "待审核");
	public static CodeMsg REVIEW_FAIL = new CodeMsg(20, "审核失败");
	public static CodeMsg IN_CROWDFUNDING = new CodeMsg(21, "筹款中");
	public static CodeMsg CROWDFUNDING_SUCCESS = new CodeMsg(31, "筹款成功");
	public static CodeMsg CROWDFUNDING_FAIL = new CodeMsg(30, "筹款失败");
	public static CodeMsg IN_WITHDRAW = new CodeMsg(41, "申请提款中");
	public static CodeMsg WITHDRAW_FAIL = new CodeMsg(40, "申请提款失败");
	public static CodeMsg TO_RETURN = new CodeMsg(5, "待回报");
	public static CodeMsg OVER = new CodeMsg(6, "结束");

	private int code;
	private String msg;

	public CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
