package com.cf.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cf.entity.Message;
import com.cf.entity.Project;
import com.cf.entity.Trade;
import com.cf.entity.User;
import com.cf.service.MessageService;
import com.cf.service.OrderService;
import com.cf.service.ProjectService;
import com.cf.service.UserService;
import com.cf.utils.AuthorizationUtils;
import com.cf.vo.LoginVo;
import com.cf.vo.ProjectVo;
import com.cf.vo.UserAndSups;

@Controller
@RequestMapping("/fore")
public class ForeHomeController {

	@Autowired
	AuthorizationUtils auth;
	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
	@Autowired
	OrderService orderService;
	@Autowired
	MessageService messageService;

	@RequestMapping("/home")
	public String home(Model model, HttpSession session) {

		if (!auth.check(session))
			return "redirect:/login/toLogin";

		int id = (int) session.getAttribute("myId");
		User user = userService.getById(id);
		model.addAttribute("user", user);

		List<UserAndSups> orders = orderService.getOrdersByUserId(id);
		model.addAttribute("orders", orders);

		List<Project> projects = projectService.getByUserId(id);
		model.addAttribute("projects", projects);

		List<Message> messages = messageService.getMessagesByUserId(id);
		model.addAttribute("messages", messages);

		List<Trade> trades = messageService.getTrade(id);
		model.addAttribute("trades", trades);

		return "/fore/usercenter";
	}

	// 映射到主页
	@RequestMapping("/index")
	public String toIndex(HttpSession session, Model model) {
		LoginVo loginVo = (LoginVo) session.getAttribute("loginVo"); // 验证是否登录
		if (loginVo != null) {
			model.addAttribute("flag", loginVo.getUsername());
		} else
			model.addAttribute("flag", "unlogin");

		// SearchVo
		List<ProjectVo> listCommonWeal = projectService.getProjectByType(1); // 查询出公益类型的项目
		model.addAttribute("commonWeal", listCommonWeal);

		List<ProjectVo> listArt = projectService.getProjectByType(2); // 查询出艺术类型的项目
		model.addAttribute("art", listArt);

		List<ProjectVo> listAgriculture = projectService.getProjectByType(3); // 查询出农业类型的项目
		model.addAttribute("agriculture", listAgriculture);

		List<ProjectVo> listPublish = projectService.getProjectByType(4); // 查询出出版类型的项目
		model.addAttribute("publish", listPublish);

		List<ProjectVo> listAmusement = projectService.getProjectByType(5); // 查询出娱乐类型的项目
		model.addAttribute("amusement", listAmusement);

		List<ProjectVo> listOther = projectService.getProjectByType(6); // 查询出其他类型的项目
		model.addAttribute("other", listOther);


		Integer userID = (Integer) session.getAttribute("myId");
		model.addAttribute("messageNum", messageService.totalMessage(userID));

		return "/index";
	}
	
	//删除订单（通过id）
		@RequestMapping("/deleteOrder")
		public String deleteOrders(HttpServletRequest  request,Model model,  HttpSession session,Integer id) {
			Integer type = Integer.parseInt(request.getParameter("type"));
			System.out.println(type);
			orderService.deleteOrder(id);
			int uid = (int) session.getAttribute("myId");
			List<UserAndSups> orders = orderService.getOrdersByUserId(uid);
			model.addAttribute("orders",orders);		
			return "/fore/order/order_frg::frg" + type;
	 	}

}