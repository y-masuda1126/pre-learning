package org.example;

public class Account {

	private String id;
	private String pass;

	public Account() {
	}

	public Account(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
