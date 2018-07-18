package com.cf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cf.entity.Order;
import com.cf.utils.Page;
import com.cf.vo.UserAndSups;

@Mapper
public interface OrderDao {
	//插入订单
	@Insert("insert into order_(name,user_id,project_id,money,phone,order_id) values(#{order.name},#{order.userId},"
			+ "#{order.projectId},#{order.money},#{order.phone},#{order.orderId})")
	void insertOrder(@Param("order") Order order);
	
	//通过id获取订单
	@Select("select * from order_ where id = #{id}")
	Order getById(@Param("id") Integer id);
	
	//通过id获取用户和支持者信息
	@Select("select * from user_and_sups where user_id = #{userId}")
	List<UserAndSups> getOrdersByUserId(@Param("userId") Integer userId);
	
	//获取已经支付完成的订单
	@Select("select * from order_ where user_id = #{userId} and state = 1")
	List<Order> getOrdersPayed(@Param("userId") Integer userId);
	//获取未支付完成的信息
	@Select("select * from order_ where user_id = #{userId} and state = 0")
	List<Order> getOrdersNoPayed(@Param("userId") Integer userId);

	//通过项目id获取订单
	@Select("select * from order_ where project_id = #{proId}")
	List<Order> getOrdersByProId(@Param("proId") Integer proId);

	@Select("select count(*) from order_ ")
	int total();
	
	//列出所有的订单
	@Select("select * from order_ " + "<if test = 'page.start!=null and page.count!=null'> "
			+ "limit #{page.start},#{page.count}" + "</if>" + "</script>")
	List<Order> listOrders(@Param("page") Page page);
	
	//更新状态
	@Update("update order_ set state = 1 where order_id = #{orderId}")
	void updateState(@Param("orderId") String orderId);
	
	//2018 7 8 new
	@Delete("delete from order_  where id = #{id}")
	void deleteOrder(@Param("id") Integer id);
	
	@Select("select * from order_ where order_id = #{orderId}")
	Order getOrdersByOrderId(String orderId);
}
