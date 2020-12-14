package com.vr.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_TBL")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message="name is mandatory")
	@Size(min=2, max=40)
	private String name;
	@NotBlank(message="username is mandatory")
	@Size(min=2, max=20)
	private String username;
	@NotBlank(message="password is mandatory")
	@Size(min=2, max=10)
	private String password;
	
	public User() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
}
