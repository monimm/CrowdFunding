package com.cf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dao.MessageDao;
import com.cf.entity.Message;
import com.cf.entity.Project;
import com.cf.entity.Trade;
import com.cf.vo.ProAndUsers;
import com.cf.vo.UserAndSups;

@Service
public class MessageService {
	@Autowired
	MessageDao messageDao;
	@Autowired
	ProjectService projectService;
 
	
	public String sendMessage(Integer id,Integer state) {
		String infoToSpon = null;
		String infoToSup = null;
		String url = null;
		Project project = projectService.getById(id);
		int currentMoney = project.getCurrentMoney();
		int userId = project.getUserId();
		switch (state) {
		case 20: 
			infoToSpon = "【审核失败】您发起的项目 " + project.getName() + " 因违法、违规或其他原因未能通过审核，请修改后重新提交";
 			url =  "redirect:/pro/newApply";
			break;
		case 21:
			infoToSpon = "【审核通过】您发起的项目 " + project.getName() + " 已通过审核! 要想上首页please ***";
			url = "redirect:/pro/newApply";
			break;
		case 31:
			infoToSpon = "【审核通过】您发起的项目 " + project.getName() + " 已被解锁! 要想上首页please ****";
			url = "redirect:/pro/newApply";
			break;
 
		case 5:
			infoToSpon = "【申请通过】您的提款申请通过审核，金额为 " + currentMoney;
			infoToSup = "您支持的项目 " + project.getName() + " 已提款，将进入回报阶段,敬请期待 ";
			url = "redirect:/pro/drawApply";
			break;
		case 40:
			infoToSpon = "【申请失败】您的提款申请未能通过审核，如有问题请联系XXXXXXXX ";
			url = "redirect:/pro/drawApply";
			break;	
		case 99:
			infoToSpon = "【项目锁定】您发起的项目 " + project.getName() + " 因违法、违规或其他原因被锁定，如有问题请联系XXXXXXXX";
			infoToSup = "【项目锁定】您支持的项目 " + project.getName() + " 因违法、违规或其他原因被锁定，如有问题请联系XXXXXXXX";
			url = "redirect:/pro/listAllPros";
		case 100:
			infoToSpon = "【项目撤销】您发起的项目 " + project.getName() + " 因违法、违规或其他原因被撤销，如有问题请联系XXXXXXXX";
			infoToSup = "【项目撤销】您支持的项目 " + project.getName() + " 因违法、违规或其他原因被撤销，如有问题请联系XXXXXXXX";
			url = "redirect:/pro/listAllPros";
			break;
		//以上均为后台操作
			
		//以下为前台操作
		case 6:
			infoToSup = "【项目回报】您支持的项目 " + project.getName() + " 已回报，请及时确认回报，如有问题请联系XXXXXXXX ";
			url = "redirect:/pro/fore/listMyPros";
			break;
		case 1:
 			url = "redirect:/pro/fore/listMyPros";
			break;
		case 41:
 			url = "redirect:/pro/fore/listMyPros";
			break;
		default:
			break;
		}
		//不为空就发消息
		if(infoToSpon != null) {
			sendMessageToSponstor(userId,infoToSpon);
		}
		if(infoToSup != null) {
			sendMessageToSupporter(id,infoToSup);
		}
		return url;
	}
	public void sendMessageToSupporter(Integer projectId,String info) {
		List<ProAndUsers> lists =  projectService.getProAndUsersByProId(projectId);	 
		for (ProAndUsers tmp : lists) {
			messageDao.insertMessage(tmp.getUserId(), info);
		}
	}
	public void sendMessageToSponstor(Integer userId,String info) {
		messageDao.insertMessage(userId, info);
	}
	public List<Message> getMessagesByUserId(Integer userId) {
		return messageDao.getMessageByUserId(userId);
 	}
	public void setState(Integer id) {
		messageDao.setState(id);
	}
	public void deleteMsg(Integer id) {
		messageDao.deleteMsg(id);
	}
	
	public void insertTrade(Trade trade) {
		messageDao.insertTrade(trade.getUserId(),trade.getInfo(),trade.getMoney());
	}
	public List<Trade> getTrade(Integer id ) {
		return messageDao.getTrade(id);
	}
	
	public Integer totalMessage(int id){
		return messageDao.totalMessage(id);
	}

}
