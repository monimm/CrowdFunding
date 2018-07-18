package com.cf.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.cf.controller.PayController;
import com.cf.entity.Order;
import com.cf.entity.Project;
import com.cf.entity.Trade;
import com.cf.entity.User;
import com.cf.exception.GlobalException;
import com.cf.result.CodeMsg;
import com.cf.utils.MyAlipayUtils;
import com.cf.utils.RandomUtils;
import com.cf.vo.OrderDetailsVO;

@Service
public class AlipayService {

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@Autowired
	ProjectService projectService;
	
	@Autowired
	MessageService messageService;

	// 向支付宝平台发送请求
	public String Request(OrderDetailsVO orderDetailsVO) {
		// 首先验证接收参数的合法性
		if (orderDetailsVO == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		System.out.println(orderDetailsVO.toString());
		User user = userService.getById(orderDetailsVO.getUserId());
		if (user == null) {
			throw new GlobalException(CodeMsg.USER_NOT_EXIST);
		}
		Project project = projectService.getById(orderDetailsVO.getProjectId());
		if (project == null) {
			throw new GlobalException(CodeMsg.PROJECT_NOT_EXIST);
		}

		// 生成订单 设置属性
		Order order = new Order();
		order.setName("琦琦众筹-" + project.getName());
		order.setUserId(user.getId());
		order.setProjectId(project.getId());
		//order.setPhone("18000000000");
		order.setMoney(orderDetailsVO.getMoney());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
		String orderId = df.format(new java.util.Date());
		orderId += RandomUtils.getRandomLetterAndNum(7);
		order.setOrderId(orderId);

		// 时间默认当前
		 order.setDate(new java.sql.Date(new java.util.Date().getTime()));

		// 插入订单
		//orderService.insertOrder(order);

		// 调用工具类发送请求 返回请求结果
		String result = null;
		try {
			result = MyAlipayUtils.pay(order);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if (result == null) {
			throw new GlobalException(CodeMsg.ORDER_REQUEST_ERROR);
		}
		// 返回的result是 html代码
		return result;
	}
	
	
	//order pay
	public String OrderRequest(Integer id) {
		// 首先验证接收参数的合法性
		if (id == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		Order order = orderService.getById(id);

		// 调用工具类发送请求 返回请求结果
		String result = null;
		try {
			result = MyAlipayUtils.pay(order);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if (result == null) {
			throw new GlobalException(CodeMsg.ORDER_REQUEST_ERROR);
		}
		// 返回的result是 html代码
		return result;
	}
	

	// 余额支付
	public boolean moneyPay(OrderDetailsVO orderDetailsVO, Integer idInteger) {
		// 首先验证接收参数的合法性
		if (orderDetailsVO == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		User user = userService.getById(orderDetailsVO.getUserId());
		if (user == null) {
			throw new GlobalException(CodeMsg.USER_NOT_EXIST);
		}
		Project project = projectService.getById(orderDetailsVO.getProjectId());
		if (project == null) {
			throw new GlobalException(CodeMsg.PROJECT_NOT_EXIST);
		}
		String orderId  = orderService.getById(idInteger).getOrderId();
		if(user.getMoney() < orderDetailsVO.getMoney())
				return false;
		
		Trade trade = new Trade();
		trade.setMoney(orderDetailsVO.getMoney());
		trade.setInfo("余额支付");
		trade.setUserId(user.getId());
		messageService.insertTrade(trade);
		
		if(project.getCurrentMoney() >project.getTargetMoney()) {
			projectService.updateState(orderDetailsVO.getProjectId(), 31);
		}
		
		orderService.updateState(orderId);
		return true;
	}
	
	//new pay  by alipay
	public String newOrderByAlipay(Integer userId,Integer money, Integer projectId) {
 

		// 生成订单 设置属性
		Order order = new Order();
		order.setName("琦琦众筹-" + projectService.getById(projectId).getName());
		order.setUserId(userId);
		order.setProjectId(projectId);
		order.setPhone("18000000000");
		order.setMoney(money);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
		String orderId = df.format(new java.util.Date());
		orderId += RandomUtils.getRandomLetterAndNum(7);
		order.setOrderId(orderId);

		// 时间默认当前
		 order.setDate(new java.sql.Date(new java.util.Date().getTime()));

		// 插入订单
		orderService.insertOrder(order);

		// 调用工具类发送请求 返回请求结果
		String result = null;
		try {
			result = MyAlipayUtils.pay(order);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if (result == null) {
			throw new GlobalException(CodeMsg.ORDER_REQUEST_ERROR);
		}
		// 返回的result是 html代码
		return result;

		
	}
	
	public boolean newMoneyPay(Integer userId,Integer money, Integer projectId) {
	 
		
		if(userService.getById(userId).getMoney() < money)
			return false;
		// 生成订单 设置属性
		Order order = new Order();
		order.setName("琦琦众筹-" + projectService.getById(projectId).getName());
		order.setUserId(userId);
		order.setProjectId(projectId);
		order.setPhone("18000000000");
		order.setMoney(money);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
		String orderId = df.format(new java.util.Date());
		orderId += RandomUtils.getRandomLetterAndNum(7);
		order.setOrderId(orderId);

		// 时间默认当前
		 order.setDate(new java.sql.Date(new java.util.Date().getTime()));

		// 插入订单
		orderService.insertOrder(order);
		orderService.updateState(orderId);
		
		Trade trade = new Trade();
		trade.setMoney(money);
		trade.setInfo("余额支付");
		trade.setUserId(userId);
		messageService.insertTrade(trade);
		
		String info = "【余额支付】关于项目【" + projectService.getById(projectId).getName() + "】，" + money + "元";
		messageService.sendMessageToSponstor(userId,info);
		

		if(projectService.getById(projectId).getCurrentMoney() >projectService.getById(projectId).getTargetMoney()) {
			projectService.updateState(projectId, 31);
		}
		
		
		return true;
	}

}
