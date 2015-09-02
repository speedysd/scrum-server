package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "User")
public class User {
	@Id
	private Long id;

	@Column
	private String name;
	
//	@ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
//	private List<Sprint> sprints = new ArrayList<Sprint>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<SprintUser> sprintUsers = new ArrayList<SprintUser>();

	public List<SprintUser> getSprintUsers() {
		return sprintUsers;
	}

	public void setSprintUsers(List<SprintUser> sprintUsers) {
		this.sprintUsers = sprintUsers;
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

//	public List<Sprint> getSprints() {
//		return sprints;
//	}

//	public void setSprints(List<Sprint> sprints) {
//		this.sprints = sprints;
//	}
}
