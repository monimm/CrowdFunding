package com.cf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cf.entity.Image;
import com.cf.vo.ImageVo;

@Mapper
public interface ImageDao {

	// 类型 编码
	// ******************
	// 项目封面 1
	// 项目描述 2
	// 身份证 3
	// 头像 4

	@Insert("insert into image(type,name,user_id,project_id) values(#{image.type},#{image.name},#{image.userId},#{image.projectId})")
	void insertImage(@Param("image") Image image);
	
	

	// 查找项目的描述图片
	@Select("select project_id,type,user_id,name from image where project_id=#{id} and type=2")
	List<ImageVo> getProjectImage(@Param("id") int id);

	// 查找用户头像
	@Select("selectproject_id,type,user_id,name from image where user_id=#{id} and type=4")
	ImageVo getHeadImage(@Param("id") int id);

}
