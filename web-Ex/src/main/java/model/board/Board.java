package model.board;

import java.sql.Date;

public class Board {
	
	private int id;
	private int author;
	private String title;
	private String contnent;
	private Date reg_date;
	private Date mog_date;
	
	public Board(int id, int author, String title, String contnent, Date reg_date, Date mog_date) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.contnent = contnent;
		this.reg_date = reg_date;
		this.mog_date = mog_date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContnent() {
		return contnent;
	}
	public void setContnent(String contnent) {
		this.contnent = contnent;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getMog_date() {
		return mog_date;
	}
	public void setMog_date(Date mog_date) {
		this.mog_date = mog_date;
	}
	
}
