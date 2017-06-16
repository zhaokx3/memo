package easybuy.server.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import easybuy.server.model.Event;
import easybuy.server.model.User;
import easybuy.server.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class UserDaoTest {

	@Autowired
	private UserService userService;
	
//	@Test
	public void logInTest() {
		String userName = "zhaokx3";
		String password = "123456";
		
		User user = userService.logIn(userName, password);
		System.out.println("\nlog in test:");
		if (user == null) {
			System.out.println("user does not exist or incorrect password\n");
		} else {
			System.out.println("id:" + user.getUserId());
			System.out.println("userName:" + user.getUserName());
			System.out.println("description:" + user.getDescription());
			System.out.println("avatar:" + user.getAvatar() + "\n");
		}
	}
	
//	@Test
	public void registerTest() {
		String userName = "zhaokx3";
		String password = "123456";
		String description = "someone";
		String avatar = "...";
		
		String message = userService.register(userName, password, description, avatar);
		if (message == null) {
			User user = userService.logIn(userName, password);
			if (user != null) {
				message = "success";
			}
		}
		System.out.println("\nregister test:" + message + "\n");
	}
	
//	@Test
	public void changePasswordTest() {
		String userName = "zhaokx3";
		String oldPassword = "123456";
		String newPassword = "111111";
		
		String message = userService.changePassword(userName, oldPassword, newPassword);
		if (message == null) {
			User user = userService.logIn(userName, newPassword);
			if (user != null) {
				message = "success";
			} else {
				message = "fail";
			}
		}
		System.out.println("\nchange password test:" + message + "\n");
	}
	
//	@Test
	public void addEventTest() {
		Integer userId = 6;
		Integer icon = 1;
		Integer category = 2;
		String eventName = "数据挖掘实验报告";
		String content = "实验报告包括代码、对比分析、理论知识等";
		String startTime = "2017-06-16";
		String endTime = "2017-06-23";
		String timestamps = "no...";
		
		String message = userService.addEvent(userId, icon, category, eventName, content, startTime, endTime, timestamps);
		if (message == null) {
			message = "success";
		} else {
			message = "fail";
		}
		System.out.println("\nadd Event test:" + message + "\n");
	}
	
	@Test
	public void changeEventTest() {
		Integer userId = 6;
		Integer icon = 2;
		Integer category = 3;
		String eventName = "数据挖掘实验报告";
		String content = "两次kaggle结果提交，实验报告包括代码、对比分析、理论知识等";
		String startTime = "2017-06-17";
		String endTime = "2017-06-23";
		String timestamps = "no... add one";
		
		String message = userService.changeEvent(userId, icon, category, eventName, content, startTime, endTime, timestamps);
		if (message == null) {
			message = "success";
		} else {
			message = "fail";
		}
		System.out.println("\nchange Event test:" + message + "\n");
	}
	
//	@Test
	public void deleteEventByUserId_EventNameTest() {
		Integer userId = 6;
		String eventName = "数据挖掘实验报告";
		
		String message = userService.deleteEventByUserId_EventName(userId, eventName);
		
		if (message == null) {
			message = "delete the event success";
		} else {
			message = "delete the event fail";
		}
		System.out.println("\ndelete Event test:" + message + "\n");
	}
//	@Test
	public void getEventByUserIdTest() {
		Integer userId = 10;
		List<Event> events =  userService.getEventByUserId(userId);
		
		if (events.size() > 0) {
			System.out.println("the num of events: " + events.size());
			System.out.println("the first event's id: " + events.get(0).getEventId());
		}
	}
}
