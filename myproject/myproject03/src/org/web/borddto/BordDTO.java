package org.web.borddto;


public class BordDTO { //Bord1029
	private String name;
	private String title;
	private String memo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public BordDTO(String name) {
		super();
		this.name = name;
	}
	public BordDTO(String name, String title, String memo) {
		super();
		this.name = name;
		this.title = title;
		this.memo = memo;
	}
}
