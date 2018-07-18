package com.cf.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cf.dao.UserDao;
import com.cf.entity.User;
import com.cf.exception.GlobalException;
import com.cf.result.CodeMsg;
import com.cf.utils.Page;
import com.cf.vo.LoginVo;
import com.cf.vo.RegisterVo;
import com.cf.vo.changePWDVO;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	@Autowired
	MessageService messageService;

	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public User getById(int id) {
		return userDao.getUserById(id);
	}

	public User getByName(String username) {
		return userDao.getUserByName(username);
	}

	public User getByPhone(String phone) {
		return userDao.getUserByPhone(phone);

	}

	public User getByMail(String mail) {
		return userDao.getUserByMail(mail);
	}

	public List<User> listUsers(Page page) {
		return userDao.listUsers(page);
	}

 
	public void updateUserPassword(int id, String password) {
		User user = userDao.getUserById(id);
		user.setPassword(password);
		userDao.updateUser(user);
 	}

	public void deleteById(int id) {
		userDao.deleteById(id);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

 
	public Integer login(HttpServletResponse response, LoginVo loginVo) {
		if (loginVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String username = loginVo.getUsername();
		User user = getByName(username);
		if (user == null) {
			user = getByPhone(username);
			if (user == null) {
				user = getByMail(username);
				if (user == null) {
					throw new GlobalException(CodeMsg.PHONE_NOT_EXIST);
				}
			}
		}
		String password = loginVo.getPassword();
		if (!password.equals(user.getPassword())) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		return user.getId();
	}

	public String register(HttpServletResponse response, RegisterVo registerVo) {
		if (registerVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String username = registerVo.getUsername();
		User user = getByName(username);
		if (user != null) {
			// TODO:
			throw new GlobalException(CodeMsg.USERNAME_EXIST);
		}
		if (registerVo.getType() == 1) {
			user = getByPhone(registerVo.getUsermailOrPhone());
			if (user != null)
				throw new GlobalException(CodeMsg.USERPHONE_EXIST);
		}
		if (registerVo.getType() == 2) {
			user = getByMail(registerVo.getUsermailOrPhone());
			if (user != null)
				throw new GlobalException(CodeMsg.USERMAIL_EXIST);
		}
		User record = new User();
		record.setUsername(username);
		record.setPassword(registerVo.getPassword());
		if (registerVo.getType() == 1)
			record.setPhone(registerVo.getUsermailOrPhone());
		if (registerVo.getType() == 2)
			record.setMail(registerVo.getUsermailOrPhone());
		insertUser(record);

		messageService.sendMessageToSponstor(userDao.getUserByName(username).getId(), "【欢迎注册】 恭喜您注册成功！！");
		return "success";
	}

	public String changePWD(HttpServletResponse response, changePWDVO changePWDVo) {
		if (changePWDVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String phone = null;
		String mail = null;
		if (changePWDVo.getType() == 1)
			phone = changePWDVo.getPhoneOmail();
		else
			mail = changePWDVo.getPhoneOmail();
		String newPWD = changePWDVo.getNewPWD();

		String IDcode = changePWDVo.getIDcode();
		// *******
		// 在这里对验证码进行验证
		// *******

		User user = getByPhone(phone);
		if (user == null) {
			user = getByMail(mail);
			if (user == null) {
				throw new GlobalException(CodeMsg.PHONE_NOT_EXIST);
			}
		}

		updateUserPassword(user.getId(), newPWD);
		return "success";
	}

	public Integer total() {
		return userDao.total();
	}

}
