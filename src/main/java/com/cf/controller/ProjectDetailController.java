package com.cf.controller;
 
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cf.entity.Comment;
 
import com.cf.result.Result;
import com.cf.service.MessageService;
import com.cf.service.ProjectService;
 
import com.cf.vo.ImageVo;
import com.cf.vo.LoginVo;
import com.cf.vo.ProAndUsers;
import com.cf.vo.ProjectVo;
import com.cf.vo.RewardVo;
 

@Controller
@RequestMapping("/detail")
public class ProjectDetailController {
	private static Logger log = LoggerFactory.getLogger(ProjectDetailController.class);

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MessageService messageService;

	@RequestMapping("/showDetail")
	public String showDetail(Integer projID, Model model,HttpSession session) {
		
 
		if(projID == null) {
			
			projID = (Integer) session.getAttribute("preProject");
		}
		session.setAttribute("preProject", projID);
		
		LoginVo loginVo = (LoginVo) session.getAttribute("loginVo");
		Integer id = (Integer) session.getAttribute("myId");
		if(loginVo!= null) {
			model.addAttribute("flag", loginVo.getUsername());
			model.addAttribute("userId", id.intValue());
			model.addAttribute("messageNum", messageService.totalMessage(id));
		}
		else 
			model.addAttribute("flag", "unlogin");
		//1.获取项目信息
		ProjectVo proj = projectService.getProjectVoById(projID);
		System.out.println(proj.toString());
		//2.获取回报信息
		RewardVo rewords = projectService.getProjectRewords(projID);
		//3.获取评论信息
		List<Comment> comments = projectService.getProjectComment(projID);
		//4.获取支持信息
		List<ProAndUsers> supports = projectService.getProAndUsers(projID);
		//5.获取图片信息
		List<ImageVo> images = projectService.getProjectImage(projID);
		model.addAttribute("project", proj);
		model.addAttribute("rewords", rewords);
		model.addAttribute("comment", comments);
		model.addAttribute("support", supports);
		model.addAttribute("image", images);
	
		return "/fore/detail_info";
	}
	
	@RequestMapping("/submitComment")
	@ResponseBody
	public Result<String> submitComment(HttpServletResponse response, Comment comment) {
		log.info(comment.toString());
		projectService.submitComment(comment);
		return Result.success("success");
	}
}
