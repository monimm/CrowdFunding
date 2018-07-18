package com.cf.controller;

 
 //****************支付的控制器************//
//用于处理支付相关的一些请求

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cf.entity.Trade;
import com.cf.result.Result;
import com.cf.service.AlipayService;
import com.cf.service.MessageService;
import com.cf.service.OrderService;
import com.cf.service.ProjectService;
import com.cf.service.UserService;
import com.cf.utils.AuthorizationUtils;
import com.cf.vo.OrderDetailsVO;

 
@Controller
@RequestMapping("/pay")
public class PayController {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(PayController.class);
 
	
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
	@Autowired
	AlipayService alipayService;
	@Autowired 
	AuthorizationUtils auth;
	@Autowired
	MessageService messageService;
	
	//去支付页面
	@RequestMapping("/toPay")
	public String toPay() {
		return "/fore/pay/pay";
	}
	
	//支付成功返回处理
	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String return_get(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
 
		//商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");	
	 
		//更新订单状态 进行资金交易
		orderService.updateState(out_trade_no);
		
 
		
		Trade trade = new Trade();
		trade.setMoney(orderService.getOrderByOrderId(out_trade_no).getMoney());
		trade.setInfo("支付宝支付");
		
		int userId =(int) session.getAttribute("myId");
		trade.setUserId(userId);
		messageService.insertTrade(trade);
		
		int money = orderService.getOrderByOrderId(out_trade_no).getMoney();
		int projectId = orderService.getOrderByOrderId(out_trade_no).getProjectId();
		String info = "【支付宝付】关于项目【" + projectService.getById(projectId).getName() + "】，" + money + "元";

		messageService.sendMessageToSponstor(userId, info );
		
		
		if(projectService.getById(projectId).getCurrentMoney() > projectService.getById(projectId).getTargetMoney()) {
			projectService.updateState(projectId, 31);
		}

		//new 2018 7 11
		return "redirect:/detail/showDetail";

	}
	
	
	//支付请求处理
	@RequestMapping(value = "/alipay", method = RequestMethod.POST)
	public String aliPay(Model model,OrderDetailsVO orderDetailsVO,String uc_payChoice,Integer idInteger){	 
		if(idInteger == null) {
			System.out.println("idInteger null");
			return "redirect:/fore/home";
		}
 		if(uc_payChoice.equals("1")) {
			String result = alipayService.OrderRequest(idInteger);
			model.addAttribute("result", result);
			return "/fore/pay/alipay";
		}
		if(uc_payChoice.equals("2")) {
 
			return "redirect:/fore/home";
		}
		if(uc_payChoice.equals("3")) {
			if(alipayService.moneyPay(orderDetailsVO, idInteger)) {
				return "redirect:/fore/home";
			}else {
				return "redirect:/fore/home";
			}
			
		}
		return null;
	}
	
	
	//新订单
	@RequestMapping("/newAalipay")
	public String newAalipay(HttpSession session,Model model,int money, Integer orderType,Integer projectId){
		
		if (!auth.check(session))
		return "redirect:/login/toLogin";
			int userId =(int) session.getAttribute("myId");
 
 			if(orderType == 1) {		
				String result = alipayService.newOrderByAlipay(userId, money, projectId);
				model.addAttribute("result", result);
				return "/fore/pay/alipay";
			}
	 		if(orderType == 2) {
	 			return "redirect:/detail/showDetail?"+ projectId;
			}
	 		if(orderType == 3) {
	 			if(alipayService.newMoneyPay(userId, money, projectId)) {
	 				return "redirect:/detail/showDetail?projID="+ projectId;
	 			}
	 			else {
					return "forward:/pay/poor";
				}
				
			}
			return null;
		}
	
	@RequestMapping("/poor")
	@ResponseBody
	public String poor() {
		
		
		return "余额不足";
	}
  
}
