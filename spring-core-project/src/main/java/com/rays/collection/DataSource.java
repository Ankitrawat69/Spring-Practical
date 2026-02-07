
package com.rays.collection;

public class DataSource {

	private String url;
	private String username;
	private String password;

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "MyDataSource{ " + "url='" + url + "', " + " username='" + username + ", password='" + password + "'}";
	}

}
