package com.cf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cf.entity.Message;
import com.cf.entity.Trade;

@Mapper
public interface MessageDao {

	// 插入一条消息。内容包括用户id和评论内容
	@Insert("insert into message(user_id,info) values(#{userId},#{info})")
	void insertMessage(@Param("userId") Integer userId, @Param("info") String info);

	// 通过用户id查询消息
	@Select("select * from message where user_id = #{userId} order by state")
	List<Message> getMessageByUserId(@Param("userId") Integer userId);

	// 通过用户id查询未读消息总数
	@Select("select count(*) from message where user_id = #{userId} and state = 0")
	Integer totalMessage(@Param("userId") Integer userId);

	// 删除一条消息
	@Delete("delete  from message where id = #{id}")
	void deleteMsg(@Param("id") Integer id);

	// 更新消息的状态（未读->已读）
	@Update("update message set state = 1 where id = #{id}")
	void setState(@Param("id") Integer id);

	// 获取交易信息
	@Select("select * from trade where user_id = #{id}")
	List<Trade> getTrade(Integer id);

	// 插入交易信息
	@Insert("insert into trade(user_id,info,money) values(#{userId},#{info},#{money})")
	void insertTrade(@Param("userId") Integer userId, @Param("info") String info, @Param("money") Integer money);

}
