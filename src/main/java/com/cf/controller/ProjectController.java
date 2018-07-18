package com.cf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cf.entity.Project;
import com.cf.entity.ProjectDetail;
import com.cf.entity.Trade;
import com.cf.entity.User;
import com.cf.service.MessageService;
import com.cf.service.OrderService;
import com.cf.service.ProjectService;
import com.cf.service.UserService;
import com.cf.utils.AuthorizationUtils;
import com.cf.utils.Page;
import com.cf.vo.ProAndUsers;
import com.cf.vo.UserAndSups;

@Controller
@RequestMapping("/pro")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;
	@Autowired
	AuthorizationUtils auth;
	@Autowired
	MessageService messageService;

	// 前台管理操作开始
 
	@RequestMapping("/fore/updateState")
	public String updateForeState(Model model, Integer id, Integer state, HttpSession session,
			HttpServletRequest request) {
		if (!auth.check(session))
			return "redirect:/login/toLogin";
		projectService.updateState(id, state);
		messageService.sendMessage(id, state);

		Integer type = Integer.parseInt(request.getParameter("type"));
		int uid = (int) session.getAttribute("myId");
		List<Project> list = projectService.getByUserId(uid);
		model.addAttribute("projects", list);
		return "/fore/pro/pro_frg::frg" + type;

	}

 
	// 前台管理操作结束

	// 后台管理操作开始
	@RequestMapping("/listAllPros")
	public String listAllProjects(Model model, Page page) {
		List<Project> projects = projectService.listAllProjects(page);
		page.setTotal(projectService.total());
		model.addAttribute("projects", projects);
		model.addAttribute("page", page);
		return "/back/pro/allPros";
	}

	@RequestMapping("/fundingPros")
	public String fundingPros(Model model) {
		List<Project> list = projectService.getProsByState(21);
		model.addAttribute("projects", list);
		return "/back/pro/fundingPros";
	}

	@RequestMapping("/newApply")
	public String newApply(Model model) {
		List<Project> list = projectService.getProsByState(1);
		model.addAttribute("projects", list);
		return "/back/pro/newApply";
	}

	@RequestMapping("/drawApply")
	public String drawApply(Model model) {
		List<Project> list = projectService.getProsByState(41);
		model.addAttribute("projects", list);
		return "/back/pro/drawApply";
	}

	@RequestMapping("/delayApply")
	public String delayApply(Model model) {
		List<Project> list = projectService.getProsByState(22);
		model.addAttribute("projects", list);
		return "/back/pro/delayApply";
	}


	// 新增放款
	@RequestMapping("/back/updateState")
	public String updateState(Model model, Integer id, Integer state) {

		if (state == 5) {		
			int userId = projectService.getById(id).getUserId();
			int money = projectService.getById(id).getCurrentMoney();
			User user = userService.getById(userId);
			user.setMoney(user.getMoney() + money);
			userService.updateUser(user);
 			Trade trade = new Trade();
			trade.setMoney(money);
			trade.setInfo("提款到账");
			trade.setUserId(userId);
			messageService.insertTrade(trade);
		}

		projectService.updateState(id, state);
		return messageService.sendMessage(id, state);
	}

	// 2018 7 8 new
	@RequestMapping("/lock")
	public String lockApply(Model model) {
		List<Project> list = projectService.getProsByState(99);
		List<Project> list2 = projectService.getProsByState(80);
		list.addAll(list2);
		model.addAttribute("projects", list);
		return "/back/pro/lock";
	}

	// 2018 7 8 new
	@RequestMapping("/returnAll")
	public String returnAll() {
		List<Project> list = projectService.getProsByState(21);
		for (Project project : list) {
			returnMoney(project.getId());
		}
		return "/back/pro/home";
	}

	@RequestMapping("/back/deletePro")
	public String deletePro(Model model, Integer id) {
		// returnMoney(id);
		// projectService.deleteProject(id);
		List<ProAndUsers> list = projectService.getProAndUsersByProId(id);
		User user = null;
		for (ProAndUsers tmp : list) {
			int userId = tmp.getUserId();
			user = userService.getById(userId);
			int money = user.getMoney();
			user.setMoney(money + tmp.getMoney());
			userService.updateUser(user);
			Trade trade = new Trade();
			trade.setMoney(money);
			trade.setInfo("撤销返款到账");
			trade.setUserId(userId);
			messageService.insertTrade(trade);
		}
		messageService.sendMessage(id, 100);
 
	 
		projectService.updateState(id, 100);
		return "/back/home";
	}

	public void returnMoney(Integer id) {

		List<ProAndUsers> list = projectService.getProAndUsersByProId(id);
		User user = null;

		for (ProAndUsers tmp : list) {
			int userId = tmp.getUserId();
			user = userService.getById(userId);
			int money = user.getMoney();
			user.setMoney(money + tmp.getMoney());
			userService.updateUser(user);

		}
		projectService.updateState(id, 30);

	}

	// 后台管理操作结束
}
