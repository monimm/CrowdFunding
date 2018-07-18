package com.cf.utils;

public class StateUtils {

	public static String getStateName(Integer state) {
		String result = "未知";
		switch (state) {
		case 0:
			result = "待提交";
			break;
		case 1:
			result = "待审核";
			break;
		case 21:
			result = "筹款中";
			break;
		case 22:
			result = "延期申请中";
			break;
		//到期自动变更状态
		case 31:
			result = "筹款成功";
			break;
		case 30:
			result = "筹款失败";
			break;
		case 41:
			result = "提款中";
			break;
		case 5:
			result = "待回报";
			break;
		case 6:
			result = "已关闭";
			break;
		case 80:
			result = "锁定中";
			break;
		case 88:
			result = "撤销中";
			break;
		case 99:
			result = "锁定中";
			break;
		case 100:
			result = "未知";
			break;
		default:
			break;
		}
		return result;
	}
}
