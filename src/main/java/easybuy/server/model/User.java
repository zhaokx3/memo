package easybuy.server.model;

/**
 * @author zhaokx3
 *
 */
public class User {
	private Integer userId;
    private String userName;
    private String password;
    private String description;
    private String avatar;
	
	public User() {
		super();
	}

	public User(String userName, String password, String description, String avatar) {
		super();
		this.userName = userName;
		this.password = password;
		this.description = description;
		this.avatar = avatar;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public UserInfo toUserInfo() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setUserName(userName);
		userInfo.setDescription(description);
		userInfo.setAvatar(avatar);
		return userInfo;
	}
}
