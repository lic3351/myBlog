package cn.lic.model;

import java.util.Date;
import java.util.List;

public class Article {
	private int id;
	private String title;
	private String body;
	private Date time;
	private User user;
	private int clike;
	private int cunlike;
	private List<Comment> comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getClike() {
		return clike;
	}
	public void setClike(int clike) {
		this.clike = clike;
	}
	public int getCunlike() {
		return cunlike;
	}
	public void setCunlike(int cunlike) {
		this.cunlike = cunlike;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
