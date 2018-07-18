package com.cf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cf.entity.User;
import com.cf.utils.Page;
import com.cf.vo.ProAndUsers;

@Mapper
public interface UserDao {

	// 统计总共的用户数 分页用
	@Select("select count(*) from user")
	Integer total();

	// 通过id查找用户
	@Select("select * from user where id = #{id}")
	User getUserById(@Param("id") int id);

	// 通过用户名查找用户
	@Select("select * from user where username = #{username}")
	User getUserByName(@Param("username") String username);

	// 通过手机号查找用户
	@Select("select * from user where phone = #{phone}")
	User getUserByPhone(@Param("phone") String phone);

	// 通过邮箱查找用户
	@Select("select * from user where mail = #{mail}")
	User getUserByMail(@Param("mail") String mail);

	// 获取项目和对应的用户
	@Select("select * from pro_and_users where user_id = #{id}")
	List<ProAndUsers> getProAndUsers(Integer id);

	// 查询用户列表并进行分页处理
	@Select("<script>" + "select * from user" + "<if test = 'page.start!=null and page.count!=null'> "
			+ "limit #{page.start},#{page.count}" + "</if>" + "</script>")
	List<User> listUsers(@Param("page") Page page);

	// 插入 用户名 密码 手机 邮箱 余额默认0 id自增
	@Insert("insert into user(username,password,phone,mail) values(#{user.username},#{user.password},#{user.phone},#{user.mail})")
	void insertUser(@Param("user") User user);

	// 更新用户
	@Update("update user set money = #{user.money},phone = #{user.phone},mail = #{user.mail}, password = #{user.password} where id = #{user.id}")
	void updateUser(@Param("user") User user);

	// 删除用户
	@Delete("delete from user where id = #{id}")
	void deleteById(@Param("id") int id);

}
