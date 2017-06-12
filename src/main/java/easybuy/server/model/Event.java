package easybuy.server.model;

/**
 * @author zhaokx3
 *
 */
public class Event {
	private Integer eventId;
	private Integer userId;
	private String eventName;
	private String content;
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Event(Integer eventId, Integer userId, String eventName, String content) {
		super();
		this.eventId = eventId;
		this.userId = userId;
		this.eventName = eventName;
		this.content = content;
	}

	public Integer getEventId() {
		return eventId;
	}
	
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
