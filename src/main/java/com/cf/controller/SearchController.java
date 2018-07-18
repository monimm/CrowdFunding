//用户端搜索界面所对应的控制器
package com.cf.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cf.entity.Message;
import com.cf.service.MessageService;
import com.cf.service.ProjectService;
import com.cf.utils.Page;
import com.cf.vo.LoginVo;
import com.cf.vo.ProjectVo;
import com.cf.vo.SearchVo;

@Controller
@RequestMapping("/search")
public class SearchController {
	private static Logger log = LoggerFactory.getLogger(SearchController.class);
	//自动装载的服务层对象
	@Autowired
	private ProjectService projectService;
	@Autowired
	private MessageService messageService;

	//用于处理根据关键词来检索的请求
	//参数1：HttpSession，用于获取服务器session对象
	//参数2：String keyword,用于进行关键词检索
	//参数3：Model model，用于存储页面的模型
	@RequestMapping("/searchKeyword")
	public String searchPage(HttpSession session,String keyword,Model model) {
		LoginVo loginVo = (LoginVo) session.getAttribute("loginVo");//从session中获取到登录的账号
		if(loginVo!= null) {                                        //对该账号进行安全性验证
			model.addAttribute("flag", loginVo.getUsername());      //如果账号正确，则将用户名注入到model中
		}
		else 
			model.addAttribute("flag", "unlogin");                  //否则，注入未登录属性
		SearchVo searchVo = new SearchVo();                         //创建一个searchVo用于进行检索
		searchVo.setKeyWord(keyword);
		searchVo.setSearchOrder("0");
		searchVo.setSearchState("0");
		searchVo.setSearchType("0");
		//调用ProjectService进行处理。返回ProjectVo的列表
		List<ProjectVo> list = projectService.searchProject(searchVo.getKeyWord(),
				Integer.parseInt(searchVo.getSearchType()), Integer.parseInt(searchVo.getSearchState()),
				searchVo.getSearchOrder());
		model.addAttribute("projects", list);   //将检索出来的项目添加到model中去
		model.addAttribute("init", searchVo);
		Integer userID = (Integer) session.getAttribute("myId");
		model.addAttribute("messageNum", messageService.totalMessage(userID));
		return "/fore/search";  //返回到搜索页面
	}

		//该方法用于处理根据项目类型进行检索的请求
		//参数1：HttpSession，用于获取服务器session对象
		//参数2：String type,用于检索的项目类型
		//参数3：Model model，用于存储页面的模型
		@RequestMapping("/searchType")
		public String searchType(HttpSession session,String type,Model model) {
			
			LoginVo loginVo = (LoginVo) session.getAttribute("loginVo");     //从session中读取登录的用户信息
			if(loginVo!= null) {											 //验证用户的有效性
				model.addAttribute("flag", loginVo.getUsername());			 //有效则给model添加属性
			}
			else 
				model.addAttribute("flag", "unlogin");						 //否则标记为未登录
			
			SearchVo searchVo = new SearchVo();
			searchVo.setKeyWord("");
			searchVo.setSearchOrder("0");
			searchVo.setSearchState("0");
			searchVo.setSearchType(type);
			//调用ProjectService进行检索
			List<ProjectVo> list = projectService.searchProject(searchVo.getKeyWord(),
					Integer.parseInt(searchVo.getSearchType()), Integer.parseInt(searchVo.getSearchState()),
					searchVo.getSearchOrder());
			model.addAttribute("projects", list);
			model.addAttribute("init", searchVo);
			Integer userID = (Integer) session.getAttribute("myId");
			model.addAttribute("messageNum", messageService.totalMessage(userID));
			return "/fore/search";
		}
	
	//搜索页面的搜索请求的处理方法
		//参数1：HttpSession，用于获取服务器session对象
		//参数2：SearchVo searchVo.用于保存传递检索信息
		//参数3：Model model，用于存储页面的模型
	//已经修改
	@RequestMapping("/searchResult")
	public String searchResult(HttpSession session,SearchVo searchVo, Model model) {
		LoginVo loginVo = (LoginVo) session.getAttribute("loginVo");        //验证用户的有效性并确定登录状态
		if(loginVo!= null) {
			model.addAttribute("flag", loginVo.getUsername());  //如果有效，将用户名写入model中
		}
		else 
			model.addAttribute("flag", "unlogin");            //否则，写入未登录状态
		log.info(searchVo.toString());
		//调用ProjectService进行查找操作
		List<ProjectVo> list = projectService.searchProject(searchVo.getKeyWord(),
				Integer.parseInt(searchVo.getSearchType()), Integer.parseInt(searchVo.getSearchState()),
				searchVo.getSearchOrder());
 		model.addAttribute("projects", list);               		//将属性注入到model当中去
		model.addAttribute("init", searchVo);
		Integer userID = (Integer) session.getAttribute("myId");
		model.addAttribute("messageNum", messageService.totalMessage(userID));
		return "/fore/search";
	}
	//已经修改
	@RequestMapping("/toSearch")
	public String toSearch(HttpSession session,Model model) {
		
		LoginVo loginVo = (LoginVo) session.getAttribute("loginVo");
		if(loginVo!= null) {
			model.addAttribute("flag", loginVo.getUsername());
		}
		else 
			model.addAttribute("flag", "unlogin");
		
		SearchVo searchVo = new SearchVo();
		searchVo.setKeyWord("");
		searchVo.setSearchState("0");
		searchVo.setSearchOrder("0");
		searchVo.setSearchType("0");
		model.addAttribute("init", searchVo);
		Integer userID = (Integer) session.getAttribute("myId");
		model.addAttribute("messageNum", messageService.totalMessage(userID));
		return "/fore/search";
	}
 
}
