package model;

import java.util.Date;

public class notify {
	private int id;
	private String content;
	private Date date;
	private String author;
	private String title;
	private String file;

	public notify(int idtin, String content, Date date, String author, String title) {
		this.id = idtin;
		this.content = content;
		this.date = date;
		this.author = author;
		this.title = title;
	}

	public notify(int id2, String ct, Date day, String au, String title2, String file) {
		this.id = id2;
		this.content = ct;
		this.date = day;
		this.author = au;
		this.title = title2;
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
