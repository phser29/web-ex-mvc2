package model.board;

import java.sql.Timestamp;

public class Board {
	
	private int id;
	private int auther; //제거시 인자값으로 
	private String title;
	private String content;
	private Timestamp reg_date;
	private Timestamp mog_date;
	
	public Board() {}
	
	public Board(int auther, String title, String content) {
		this.auther = auther;
		this.title = title;
		this.content = content;
	}
	
	public Board(int id, int author, String title, String content, Timestamp reg_date, Timestamp mog_date) {
		this.id = id;
		this.auther = author;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.mog_date = mog_date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuther() {
		return auther;
	}
	public void setAuther(int auther) {
		this.auther = auther;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public Timestamp getMog_date() {
		return mog_date;
	}
	public void setMog_date(Timestamp mog_date) {
		this.mog_date = mog_date;
	}
	
}
