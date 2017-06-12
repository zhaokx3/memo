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
		userService.changePassword(userName, newPassword, oldPassword);
	}
	
//	@Test
	public void addEventTest() {
		String userId = "10";
		String eventName = "跑步";
		String content = "假草10圈跑起来";
		
		String message = userService.addEvent(userId, eventName, content);
		if (message == null) {
			message = "success";
		} else {
			message = "fail";
		}
		System.out.println("\nadd Event test:" + message + "\n");
	}
	
	@Test
	public void getEventByUserIdTest() {
		Integer userId = 10;
		List<Event> events =  userService.getEventByUserId(userId);
		
		if (events.size() > 0) {
			System.out.println("the num of events: " + events.size());
			System.out.println("the first event's id: " + events.get(0).getEventId());
		}
	}
}
