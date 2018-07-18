package com.cf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cf.entity.Comment;
import com.cf.entity.Project;
import com.cf.entity.ProjectDetail;
import com.cf.entity.ReturnLevel;
import com.cf.utils.Page;
 
 
import com.cf.vo.ProAndUsers;
 import com.cf.vo.ProjectVo;
import com.cf.vo.RewardVo;

import com.cf.vo.UserAndSups;

@Mapper
public interface ProjectDao {

 
	@Insert("insert into project(name,user_id,state,type,target_money,end_time) values(#{project.name},#{project.userId},"
			+ "#{project.state},#{project.type},#{project.targetMoney},#{project.endTime})")
	@Options(useGeneratedKeys = true, keyProperty = "project.id", keyColumn = "id")
	void insertProject(@Param("project") Project project);

	@Select("<script>" + "select * from project" + "<if test = 'page.start!=null and page.count!=null'> "
			+ "limit #{page.start},#{page.count}" + "</if>" + "</script>")
	List<Project> listAllProjects(@Param("page") Page page);

	// 按照id获取项目
	@Select("select * from project where id = #{id}")
	Project getProjectById(@Param("id") int id);

	// 按照状态筛选项目
	@Select("select * from project where state = #{state}")
	List<Project> getProsByState(Integer state);

	// 按照类型筛选项目 做首页
	@Select("select * from view_project where type = #{type} limit 3")
	List<ProjectVo> getProjectByType(@Param("type") int type);
 
	// 按照项目名筛选项目
	@Select("select * from project where name like '%#{name}%'")
	List<Project> getProjectByName(@Param("name") String name);

	// 按照用户id获取其发起的项目
	@Select("select * from project where user_id = #{userId}")
	List<Project> getProjectByUserId(@Param("userId") int userId);

	@Update("update project set days = #{days} where id = #{id}")
	void updateDays(@Param("id") int id, @Param("days") int days);

	//状态更新
	@Update("update project set state = #{state} where id = #{id}")
	void updateState(@Param("id") int id, @Param("state") int state);

	@Delete("delete  from project where id = #{id}")
	void deleteById(int id);

	//插入项目详情
	@Insert("insert into project_detail(id,id_number,name,phone,title,purpose,location,labels,cover_story,additional) values(#{projectDetail.id},#{projectDetail.idNumber},"
			+ "#{projectDetail.name},#{projectDetail.phone},#{projectDetail.title},#{projectDetail.purpose},#{projectDetail.location},#{projectDetail.labels},#{projectDetail.coverStory},#{projectDetail.additional})")
	void insertProjectDetail(@Param("projectDetail") ProjectDetail projectDetail);

	@Select("select * from view_project where id = #{id}")
	ProjectVo getProjectVoById(@Param("id") int id);
  
	//插入回报分级
	@Insert("insert into return_level(id, project_id, return_type, order_money, return_detail) values(#{returnLevel.id}, #{returnLevel.projectId},"
			+ "#{returnLevel.returnType}, #{returnLevel.orderMoney}, #{returnLevel.returnDetail})")
	void insertReturnLevel(@Param("returnLevel") ReturnLevel returnLevel);
	
	//获取回报 
	@Select("select * from return_level where project_id = #{id}")
	RewardVo getProjectRewords(@Param("id") int id);


	// 在检索项目时，执行的语句。type = 0，表示搜索的是全部
	@Select("<script>" + " select * from view_project where (state = 21 or state = 22) and (name like #{keyword} or purpose like #{keyword})"
			+ " <if test = 'type != 0'>" + " and type = #{type}" + " </if>" + " <if test = 'state != 0'>"
			+ " and state = #{state}" + " </if>" + " <if test = ' order == 1'>" + " order by create_time desc"
			+ " </if>" + " <if test = ' order == 2'>" + " order by target_money desc" + " </if>"
			+ " <if test = ' order == 3'>" + " order by current_money desc" + " </if>" + " </script>")
	List<ProjectVo> searchProject(@Param("keyword") String keyword, @Param("type") int type, @Param("state") int state,
			@Param("order") String order);

 
	@Select("select * from pro_and_users where project_id = #{id}")
	List<ProAndUsers> getProAndUsers(Integer id);

	@Select("select count(*) from project")
	int total();

	// 新增
	@Insert("insert into comment(project_id,user_id,content) values(#{pid},#{uid},#{content})")
	void insertComment(@Param("pid") int pid, @Param("uid") int uid, @Param("content") String comment);

	// 查找项目的评论
	@Select("select * from view_comment where project_id=#{projectId}")
	List<Comment> selectComment(@Param("projectId") int projectId);

	// 查找项目对应的支持者列表
	@Select("select * from user_and_sups where project_id = #{proId}")
	List<ProAndUsers> getProAndUsersByProId(Integer proId);

	// 通过用户id获取其支持项目
	@Select("select * from user_and_sups where user_id = #{userId}")
	List<UserAndSups> getUserAndSups(Integer userId);
 
}
