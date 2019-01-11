package org.web.borddto;

import java.sql.Timestamp;

public class BordDTO2 {
	
	private int no;
	public BordDTO2(int mGroup, String memo, String userName) {
		super();
		this.mGroup = mGroup;
		this.memo = memo;
		this.userName = userName;
	}
	public BordDTO2(String title, String memo, String type, String userName) {
		super();
		this.title = title;
		this.memo = memo;
		this.type = type;
		this.userName = userName;
	}
	private int mGroup;
	private String title;
	private String memo;
	private String type;
	private Timestamp time;
	private String userName;
	public int getNo() {
		return no;
	}
	public int getmGroup() {
		return mGroup;
	}
	public String getTitle() {
		return title;
	}
	public String getMemo() {
		return memo;
	}
	public String getType() {
		return type;
	}
	public Timestamp getTime() {
		return time;
	}
	public String getUserName() {
		return userName;
	}
	public BordDTO2(int no, int mGroup, String title, String memo, String type, Timestamp time, String userName) {
		super();
		this.no = no;
		this.mGroup = mGroup;
		this.title = title;
		this.memo = memo;
		this.type = type;
		this.time = time;
		this.userName = userName;
	}
	
}
