package model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class content {
	private int idtin;
	private String ten;
	private String summary;
	private String noidung;
	private String author;
	private Date date;
	int countview;

	public content() {
	}

	public content(int idtin, String ten, String author, String summary) {
		this.idtin = idtin;
		this.ten = ten;
		this.author = author;
		this.summary = summary;
	}

	public content(int idtin, String ten, int countview) {
		this.idtin = idtin;
		this.ten = ten;
		this.countview = countview;
	}

	public content(int idtin,String summary, String ten) {
		
		this.idtin = idtin;
		this.summary = summary;
		this.ten = ten;
	}

	public int getIdtin() {
		return idtin;
	}

	public void setIdtin(int idtin) {
		this.idtin = idtin;
	}

	public int getCountview() {
		return countview;
	}

	public void setCountview(int countview) {
		this.countview = countview;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public content(String ten, String summary, String author, Date date) {
		this.ten = ten;
		this.summary = summary;
		this.author = author;
		this.date = date;

	}
	public content(String ten, String summary, String noidung) {
		this.ten = ten;
		this.summary = summary;
		this.noidung = noidung;

	}

}
