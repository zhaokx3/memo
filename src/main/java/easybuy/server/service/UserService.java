package easybuy.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easybuy.server.comm.Util;
import easybuy.server.dao.UserDao;
import easybuy.server.model.Event;
import easybuy.server.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User logIn(String userName, String password) {
		if (Util.isBlank(userName) || Util.isBlank(password)) {
			return null;
		}
		
		return userDao.logIn(userName, password);
	}
	
	public String register(String userName, String password, String description, String avatar) {
		String message = null;
		
		if (Util.isBlank(userName) || Util.isBlank(password)) {
			message = "用户名或密码为空";
		}
		
		if (message == null) {
			if (getUserByUserName(userName) != null) {
				message = "用户名已被注册";
			}
		}
		
		if (message == null) {
			return userDao.register(userName, password, description, avatar);
		}
		
		return message;
	}
	
	public User getUserByUserName(String userName) {
		if (Util.isBlank(userName)) {
			return null;
		}
		
		return userDao.getUserByUserName(userName);
	}
	
	public User getUserByUserId(Integer userId) {
		if (userId == null) {
			return null;
		}
		
		return userDao.getUserByUserId(userId);
	}
	
	public String changePassword(String userName, String oldPassword, String newPassword) {
		String message = null;
		
		if (Util.isBlank(userName) || Util.isBlank(oldPassword) || Util.isBlank(newPassword)) {
			message = "用户名或密码为空";
		}
		
		if (message == null) {
			if (getUserByUserName(userName) == null) {
				message = "用户不存在";
			}
		}
		
		if (message == null) {
			return userDao.changePassword(userName, oldPassword, newPassword);
		}
		
		return message;
	}
	
	//根据用户id添加事项
	public String addEvent(Integer userId, Integer icon, Integer category, String eventName, String content, String startTime,
			String endTime, String timestamps) {
		String message = null;
		
		if (Util.isBlank(eventName)) {
			message = "eventName为空";
		}
		
		if (message == null) {
			if (getUserByUserId(userId) == null) {
				message = "用户不存在";
			}
		}
		
		if (message == null) {
			return userDao.addEvent(userId, icon, category, eventName, content, startTime, endTime, timestamps);
		}
		return message;
	}
	
	// 通过用户id和事件名修改事项
		public String changeEvent(Integer userId, Integer icon, Integer category, String eventName, String content, String startTime,
				String endTime, String timestamps) {
			String message = null;
			
			message = deleteEventByUserId_EventName(userId, eventName);
			
			if (message == null) {
				return userDao.addEvent(userId, icon, category, eventName, content, startTime, endTime, timestamps);
			}
					
			return message;
		}
		
	// 通过用户id和事件名删除事项
		public String deleteEventByUserId_EventName(Integer userId, String eventName) {
			String message = null;
			if (Util.isBlank(eventName)) {
				message = "eventName为空";
			}
			
			if (message == null) {
				if (getUserByUserId(userId) == null) {
					message = "用户不存在";
				}
			}
			if (message == null) {
				return userDao.deleteEventByUserId_EventName(userId, eventName);
			}
			return message;
		}
	
	// 根据用户id获取全部事项
	public List<Event> getEventByUserId(Integer userId) {
		if (userId == null) {
			return new ArrayList<Event>();
		}
		return userDao.getEventByUserId(userId);
	}
}
