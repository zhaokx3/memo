package easybuy.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import easybuy.server.model.User;
import easybuy.server.model.Event;

@Component
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	// 用户登录
	public User logIn(String userName, String password) {
		List<User> users = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			String hql = "from User where userName = :userName and password = :password";
			Query<User> query = sess.createQuery(hql, User.class);
			users = query.setParameter("userName", userName).setParameter("password", password).setCacheable(true).getResultList();
			
			tx.commit();
		} catch (Exception e) {
			logger.error("UserDao::logIn函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		
		return (users == null || users.isEmpty()) ? null : users.get(0);
	}
	
	// 用户注册
	public String register(String userName, String password, String description, String avatar) {
		String message = null;	
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			User user = new User(userName, password, description, avatar);
			sess.save(user);
			
			tx.commit();
		} catch (Exception e) {
			message = "用户名已被注册";
			logger.error("UserDao::register函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		
		return message;
	}
	
	// 查询用户 - 通过用户名
	public User getUserByUserName(String userName) {
		List<User> users = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			String hql = "from User where userName = :userName";
			Query<User> query = sess.createQuery(hql, User.class);
			users = query.setParameter("userName", userName).setCacheable(true).getResultList();
			
			tx.commit();
		} catch (Exception e) {
			logger.error("UserDao::getUserByUserName函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		
		return (users == null || users.isEmpty()) ? null : users.get(0);
	}
	
	// 查询用户 - 通过用户名和密码
		public User getUserByName_Password(String userName, String password) {
			List<User> users = null;
			
			Session sess = null;
			Transaction tx = null;
			try {
				sess = sessionFactory.openSession();
				tx = sess.beginTransaction();
				
				String hql = "from User where userName = :userName and password = :password";
				Query<User> query = sess.createQuery(hql, User.class);
				users = query.setParameter("userName", userName).setParameter("password", password).setCacheable(true).getResultList();
				
				tx.commit();
			} catch (Exception e) {
				logger.error("UserDao::getUserByName_Password函数出错:" + e.getMessage());
			} finally {
				if (sess != null) {
					sess.close();
				}
			}
			
			return (users == null || users.isEmpty()) ? null : users.get(0);
		}
	
	// 查询用户 - 通过用户Id
	public User getUserByUserId(Integer userId) {
		List<User> users = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			String hql = "from User where userId = :userId";
			Query<User> query = sess.createQuery(hql, User.class);
			users = query.setParameter("userId", userId).setCacheable(true).getResultList();
			
			tx.commit();
		} catch (Exception e) {
			logger.error("UserDao::getUserByUserId函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		
		return (users == null || users.isEmpty()) ? null : users.get(0);
	}
	
	// 修改密码
	public String changePassword(String userName, String oldPassword, String newPassword) {
		String message = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			String hql = "update User set password = :newPassword where userName = :userName and password = :oldPassword";
			Query<?> query = sess.createQuery(hql);
			query.setParameter("newPassword", newPassword).setParameter("userName", userName).setParameter("oldPassword", oldPassword).setCacheable(true);
			int flag = query.executeUpdate();
			if (flag == 0) {
				message = "原密码错误";
			}
			tx.commit();
		} catch (Exception e) {
			message = "数据库访问错误";
			logger.error("UserDao::changePassword函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		
		return message;
	}
	
	//根据用户id添加事项
	public String addEvent(Integer userId, Integer icon, Integer category, String eventName, String content, String startTime,
			String endTime, String timestamps) {
		String message = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			Event event  = new Event(userId, icon, category, eventName, content, startTime, endTime, timestamps);
			sess.save(event);
			
			tx.commit();
		} catch (Exception e) {
			message = "数据库访问错误";
			logger.error("UserDao::addEvent函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		return message;
	}
	
	// 通过用户id和事件名删除事项
	public String deleteEventByUserId_EventName(Integer userId, String eventName) {
		String message = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			String hql = "delete from Event where userId = :userId and eventName = :eventName";
			Query<Event> query = sess.createQuery(hql);
			query.setParameter("userId", userId).setParameter("eventName", eventName);
			query.executeUpdate();
			
			tx.commit();
		} catch (Exception e) {
			message = "数据库访问错误";
			logger.error("UserDao::deleteEventByUserId_EventName函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		return message;
	}
	
	// 根据用户id获取全部事项
	public List<Event> getEventByUserId(Integer userId) {
		List<Event> result = null;
		
		Session sess = null;
		Transaction tx = null;
		try {
			sess = sessionFactory.openSession();
			tx = sess.beginTransaction();
			
			String hql = "from Event where userId = :userId";
			Query<Event> query = sess.createQuery(hql, Event.class);
			result = query.setParameter("userId", userId).setCacheable(true).getResultList();
			
			tx.commit();
		} catch (Exception e) {
			logger.error("UserDao::getEventByUserId函数出错:" + e.getMessage());
		} finally {
			if (sess != null) {
				sess.close();
			}
		}
		
		return result;
	}
}
