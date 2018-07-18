package com.cf.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dao.ImageDao;
import com.cf.dao.ProjectDao;
import com.cf.entity.Comment;
import com.cf.entity.Project;
import com.cf.entity.ProjectDetail;
import com.cf.entity.ReturnLevel;
import com.cf.exception.GlobalException;
import com.cf.result.CodeMsg;
import com.cf.utils.Page;

import com.cf.vo.ImageVo;
import com.cf.vo.ProAndUsers;
import com.cf.vo.ProjectInfoVo;
import com.cf.vo.ProjectVo;
import com.cf.vo.RewardVo;
import com.cf.vo.UserAndSups;

@Service
public class ProjectService {

	@Autowired
	ProjectDao projectDao;

	@Autowired
	ImageDao imageDao;

	@Autowired
	MessageService messageService;

	public List<ProjectVo> getProjectByType(Integer type) {
		return projectDao.getProjectByType(type);
	}

	public void insertProject(Project project) {
		projectDao.insertProject(project);
	}

	public Project getById(int id) {
		return projectDao.getProjectById(id);
	}

	public List<Project> getByUserId(int userId) {
		return projectDao.getProjectByUserId(userId);
	}

	public int total() {
		return projectDao.total();
	}

	public List<Project> listAllProjects(Page page) {
		return projectDao.listAllProjects(page);
	}

	public List<Project> getProsByState(Integer state) {
		// TODO Auto-generated method stub
		return projectDao.getProsByState(state);
	}

	public void updateState(Integer id, Integer state) {
		projectDao.updateState(id, state);
	}

	public void deleteProject(int id) {
		projectDao.deleteById(id);
	}

	// PROJECT_DETAIL
	/////////////////////////
	public void insertProjectDetail(ProjectDetail projectDetail) {
		projectDao.insertProjectDetail(projectDetail);
	}

	public ProjectVo getProjectVoById(Integer id) {
		return projectDao.getProjectVoById(id);
	}

	// 回报分级
	public RewardVo getProjectRewords(Integer id) {
		return projectDao.getProjectRewords(id);
	}

	// launch project
	public int launchProject(Integer uid, ProjectInfoVo projectInfoVo) {
		if (projectInfoVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		org.slf4j.Logger log = LoggerFactory.getLogger(ProjectService.class);

		// PROJECT
		/////////////////////////
		Project newProject = new Project();
		newProject.setName(projectInfoVo.getProTitle());
		newProject.setUserId(uid);// 测试用
		newProject.setState(1);
		newProject.setType(1);
		newProject.setTargetMoney(projectInfoVo.getProTargetMoney());
		Date nowtime = new Date();
		java.sql.Date sqlTime = new java.sql.Date(nowtime.getTime());
		newProject.setCreateTime(sqlTime);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, projectInfoVo.getProLastTime());
		sqlTime = new java.sql.Date(calendar.getTime().getTime());
		newProject.setEndTime(sqlTime);
		insertProject(newProject);
		log.info(newProject.getId().toString());

		// PROJECT_DETAIL
		/////////////////////////
		ProjectDetail newProjectDetail = new ProjectDetail();
		newProjectDetail.setId(newProject.getId());
		newProjectDetail.setIdNumber(projectInfoVo.getProIdNumber());
		newProjectDetail.setName(projectInfoVo.getProName());
		newProjectDetail.setPhone(projectInfoVo.getProPhoneNumber());

		newProjectDetail.setTitle(projectInfoVo.getProTitle());
		newProjectDetail.setPurpose(projectInfoVo.getProPurpose());
		newProjectDetail.setLocation(projectInfoVo.getProLocation());
		newProjectDetail.setLabels(projectInfoVo.getProLabels());
		newProjectDetail.setCoverStory(projectInfoVo.getProCoverStory());

		insertProjectDetail(newProjectDetail);

		// RETURN_LEVEL
		/////////////////////////
		ReturnLevel newReturnLevel = new ReturnLevel();
		newReturnLevel.setProjectId(newProject.getId());
		newReturnLevel.setReturnType(projectInfoVo.getProTypeOfReward());
		newReturnLevel.setMoney(projectInfoVo.getProAmountForReward());
		newReturnLevel.setReturnDetail(projectInfoVo.getProReward());
		projectDao.insertReturnLevel(newReturnLevel);

		return newProject.getId();

	}

	// 新增
	public List<ProjectVo> searchProject(String keyword, int type, int state, String order) {
		// 1.keyword不需要处理
		keyword = '%' + keyword + '%';
		return projectDao.searchProject(keyword, type, state, order);
	}

	public List<ProAndUsers> getProAndUsers(Integer id) {
		return projectDao.getProAndUsers(id);
	}

	public List<UserAndSups> getUserAndSups(Integer id) {
		return projectDao.getUserAndSups(id);
	}

	// 新增
	public void submitComment(Comment comment) {
		projectDao.insertComment(comment.getProjectId(), comment.getUserId(), comment.getContent());
	}

	public List<Comment> getProjectComment(int projectId) {
		return projectDao.selectComment(projectId);
	}

	public List<ProAndUsers> getProjectSupport(int projectId) {
		return projectDao.getProAndUsers(projectId);
	}

	public List<ImageVo> getProjectImage(int id) {
		return imageDao.getProjectImage(id);
	}

	public List<ProAndUsers> getProAndUsersByProId(Integer id) {
		return projectDao.getProAndUsersByProId(id);
	}
}
