package com.cf.result;
//消息的返回封装类
public class Result <T>{
	private int code;    //状态吗
	private String msg;  //消息内容
	private T data;      //返回的数据
	private  Result(T data) {
		this.code = 0;
		this.msg = "success";
		this.data = data;
	}
	private  Result(CodeMsg codeMsg) {
		if(codeMsg == null)return;
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
	}
	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}
	public static <T> Result<T> error(CodeMsg codeMsg) {
		return new Result<T>(codeMsg);
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
