package com.cf.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cf.dao.ImageDao;
import com.cf.entity.Image;
import com.cf.result.Result;
import com.cf.service.ProjectService;
import com.cf.utils.AuthorizationUtils;
import com.cf.vo.ProjectInfoVo;;

@Controller
@RequestMapping("/launch")
public class LaunchProjectController {
	private static Logger log = LoggerFactory.getLogger(LaunchProjectController.class);

	@Autowired
	private ProjectService projectService;
	
	@Autowired 
	AuthorizationUtils auth;

	@Autowired
	ImageDao newImageDao;

	@RequestMapping("/toLaunch")
	public String toLaunch(HttpSession session) {
		if (!auth.check(session))
			return "redirect:/login/toLogin";
		return "/fore/launch/launchproject";
	}

	@RequestMapping(value = "/launchOpen", method = RequestMethod.POST)
	public String launchOpen(HttpSession session, HttpServletRequest request, ProjectInfoVo projectInfoVo)
			throws IllegalStateException, IOException {

		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
		log.info(projectInfoVo.toString());
		log.info(params.getParameter("name"));
		
		if (!auth.check(session))
			return "redirect:/login/toLogin";

		 int uid = (int) session.getAttribute("myId");

		// 为projectInfoVo赋值
		projectInfoVo.setProName(params.getParameter("name"));
		projectInfoVo.setProIdNumber(params.getParameter("idNumber"));
		projectInfoVo.setProPhoneNumber(params.getParameter("phoneNumber"));
		projectInfoVo.setProTitle(params.getParameter("title"));
		projectInfoVo.setProPurpose(params.getParameter("purpose"));
		projectInfoVo.setProCoverStory(params.getParameter("coverStory"));
		projectInfoVo.setProTargetMoney(Integer.valueOf(params.getParameter("targetMoney")));
		projectInfoVo.setProLastTime(Integer.valueOf(params.getParameter("lastTime")));
		projectInfoVo.setProLocation(params.getParameter("province") + params.getParameter("city"));
		projectInfoVo.setProLabels(params.getParameter("labels"));
		projectInfoVo.setProTypeOfReward(Integer.valueOf(params.getParameter("rewardType")));
		projectInfoVo.setProAmountForReward(Integer.valueOf(params.getParameter("amount4Reward")));
		projectInfoVo.setProReward(params.getParameter("reward"));
		log.info(projectInfoVo.toString());
		int newPid = projectService.launchProject(uid, projectInfoVo);
		String myPid = Integer.toString(newPid);

		// 图片表
		// 封面图片——1
		// 描述图片——2
		// 身份证图片——3
		Image newImage = new Image();
		// 描述图片
		log.info("描述图片：");
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		String prePath = "E:/springUpload/springUpload/";
		String decPath = prePath + "describePhoto/pid_" + myPid + "/";// 根据pid检索项目描述图片
 		File decDir = new File(decPath);
		if (!decDir.exists())
			decDir.mkdirs();
		MultipartFile file = null;
		log.info(Integer.toString(files.size()));
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				log.info(file.getOriginalFilename());
				String path = decPath + file.getOriginalFilename();
				log.info(path);
				file.transferTo(new File(path));
				// 插入数据库图片表
				newImage.setName(file.getOriginalFilename());
				newImage.setType(2);
				newImage.setProjectId(Integer.valueOf(myPid));
				newImageDao.insertImage(newImage);
			}
		}

		// 身份证图片
		log.info("身份证正反面照片:");
		List<MultipartFile> idPhotos = ((MultipartHttpServletRequest) request).getFiles("idPhoto");
		MultipartFile idPhoto = null;
		log.info(Integer.toString(idPhotos.size()));

		String idPath = prePath + "idPhoto/pid_" + myPid + "/";// 根据pid检索身份证图片
		File idDir = new File(idPath);
		if (!idDir.exists())
			idDir.mkdirs();
		for (int i = 0; i < idPhotos.size(); ++i) {
			idPhoto = idPhotos.get(i);
			if (!idPhoto.isEmpty()) {
				log.info(idPhoto.getOriginalFilename());
				String path = idPath + idPhoto.getOriginalFilename();
				log.info(path);
				idPhoto.transferTo(new File(path));
				// 插入数据库图片表
				newImage.setName(idPhoto.getOriginalFilename());
				newImage.setType(3);
				newImage.setProjectId(Integer.valueOf(myPid));
				newImageDao.insertImage(newImage);
			}
		}

		// 封面图片
		log.info("封面图片:");
		
		List<MultipartFile> coverPhotos = ((MultipartHttpServletRequest) request).getFiles("coverPhoto");
		MultipartFile coverPhoto = coverPhotos.get(0);
		if (!coverPhoto.isEmpty()) {
			String coverPath = prePath + "coverPhoto/pid_" + myPid + "/";// 根据pid检索项目封面图片
			File coverDir = new File(coverPath);
			if (!coverDir.exists())
				coverDir.mkdirs();
			File coverFile = new File(coverPath + coverPhoto.getOriginalFilename());
			coverPhoto.transferTo(coverFile);
			// 插入数据库图片表
			newImage.setName(coverPhoto.getOriginalFilename());
			newImage.setType(1);
			newImage.setProjectId(Integer.valueOf(myPid));
			newImageDao.insertImage(newImage);
		}

		return "redirect:/fore/index";
	}

}
