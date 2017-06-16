package easybuy.server.model;

/**
 * @author zhaokx3
 *
 */
public class Event {
	private Integer eventId;
	private Integer userId;
	private Integer process;
	private Integer icon;
	private Integer category;
	private String eventName;
	private String content;
	private String startTime;
	private String endTime;
	private String timestamps;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Integer userId, Integer process, Integer icon, Integer category, String eventName, String content,
			String startTime, String endTime, String timestamps) {
		super();
		this.userId = userId;
		this.process = process;
		this.icon = icon;
		this.category = category;
		this.eventName = eventName;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.timestamps = timestamps;
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

	public Integer getProcess() {
		return process;
	}

	public void setProcess(Integer process) {
		this.process = process;
	}
	
	public Integer getIcon() {
		return icon;
	}

	public void setIcon(Integer icon) {
		this.icon = icon;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
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

	public String getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(String timestamps) {
		this.timestamps = timestamps;
	}
	
}
