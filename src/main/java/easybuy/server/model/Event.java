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
	private String startTime;
	private String endTime;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Integer userId, String eventName, String content, String startTime, String endTime) {
		super();
		this.userId = userId;
		this.eventName = eventName;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
