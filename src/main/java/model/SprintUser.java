package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "SprintUser")
public class SprintUser {
	@Id
	private Long id;

	@Column(name = "SPRINT_ID")
	private Long sprintId;
	
	private int capacity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SPRINT_ID", insertable = false, updatable = false)
	private Sprint sprint;

	@Column(name = "USER_ID")
	private Long userId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private User user;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSprintId() {
		return sprintId;
	}

	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public User getUser() {
		return user;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
