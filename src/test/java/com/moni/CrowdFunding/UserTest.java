package com.moni.CrowdFunding;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cf.MainApplication;
import com.cf.entity.Comment;
import com.cf.entity.Order;
import com.cf.entity.Project;
import com.cf.entity.ProjectDetail;
import com.cf.entity.User;
import com.cf.service.OrderService;
import com.cf.service.ProjectService;
import com.cf.service.UserService;
import com.cf.utils.RandomUtils;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = MainApplication.class)

public class UserTest extends TestCase {
	@Autowired
	UserService userService;

	@Autowired
	ProjectService projectService;

	@Autowired
	OrderService orderService;

 
	
	 //@Test
	public void ProjectInsert() {
		User user = null;
		for (int i = 2; i < 100; i++) {
			user = new User();
			user.setMail("6666" + String.format("%05d", i) + "@qq.com");
			user.setMoney(10000);
			user.setPassword("password" + i);
			user.setUsername("username" + i);
			user.setPhone("180023" + String.format("%05d", i));
			userService.insertUser(user);
			;
		}
 
	}

	 //@Test
	public void InsertOrder() {
		Order order = null;
		for (int i = 1; i < 10; i++) {
			Random random = new Random();
			order = new Order();
			order.setName("琦琦众筹-" + "项目支付" + i);
			order.setUserId(random.nextInt(9) + 1);
			order.setProjectId(random.nextInt(1) + 2);
			order.setMoney(random.nextInt(99) + 1);
			order.setPhone("180023" + String.format("%05d", i));
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
			String orderId = df.format(new java.util.Date());
			orderId += RandomUtils.getRandomLetterAndNum(7);
			order.setOrderId(orderId);
			orderService.insertOrder(order);
		}
		for (int i = 1; i < 15; i++) {
			Random random = new Random();
			order = new Order();
			order.setName("琦琦众筹-" + "项目支付" + i);
			order.setUserId(random.nextInt(9) + 1);
			order.setProjectId(random.nextInt(3) + 7);
			order.setMoney(random.nextInt(99) + 1);
			order.setPhone("180023" + String.format("%05d", i));
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
			String orderId = df.format(new java.util.Date());
			orderId += RandomUtils.getRandomLetterAndNum(7);
			order.setOrderId(orderId);
			orderService.insertOrder(order);
		}
	}
	 
	 //@Test
		public void InsertComment() {
			Comment comment = new Comment();
			String [] msg = {
				"大爱无疆，支持一波！",	
				"加油哦，我看好你。",
				"坚持下去，会有更好的明天。",
				"Keep Fighting!",
				"666",
				"待定",
				"待定",
					
			};
			for (int i = 1; i < 10; i++) {
				Random random = new Random();
				comment.setProjectId(random.nextInt(1) + 2);
				comment.setUserId(random.nextInt(9) + 1);
				comment.setContent(msg[random.nextInt(5)]);
				Date nowtime = new Date();
				java.sql.Date sqlTime = new java.sql.Date(nowtime.getTime());
				comment.setTime(sqlTime);
				projectService.submitComment(comment);
			}
			for (int i = 1; i < 15; i++) {
				Random random = new Random();
				comment.setProjectId(random.nextInt(3) + 7);
				comment.setUserId(random.nextInt(9) + 1);
				comment.setContent(msg[random.nextInt(5)]);
				Date nowtime = new Date();
				java.sql.Date sqlTime = new java.sql.Date(nowtime.getTime());
				comment.setTime(sqlTime);
				projectService.submitComment(comment);
			}
		}

 

}
