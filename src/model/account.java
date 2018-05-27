package model;

import java.util.HashSet;
import java.util.Set;

public class account {
	private String username;
	private String password;
	private String hoten;
	private Set<content> contents;
	private String role;
	public account(String username, String hoten, String role) {
		this.username = username;
		this.hoten = hoten;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Set<content> getContents() {
		return contents;
	}

	public void setContents(Set<content> contents) {
		this.contents = contents;
	}

	public void addMenu(content ct) {
		if (this.contents == null) {
			this.contents = new HashSet<content>();
		}
		this.contents.add(ct);
	}
}
