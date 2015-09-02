package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Sprint")
public class Sprint {
	@Id
	private Long id;

	@Column
	private String name;
	
	private String status; 
	
	@Temporal(TemporalType.DATE)
	private Calendar startDate;

	@Temporal(TemporalType.DATE)
	private Calendar endDate;

	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private List<Task> tasks = new ArrayList<Task>();
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<User> users = new ArrayList<User>();

	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private List<SprintUser> sprintUsers = new ArrayList<SprintUser>();

	public List<SprintUser> getSprintUsers() {
		return sprintUsers;
	}

	public void setSprintUsers(List<SprintUser> sprintUsers) {
		this.sprintUsers = sprintUsers;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

//	public List<User> getUsers() {
//		return users;
//	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
}
