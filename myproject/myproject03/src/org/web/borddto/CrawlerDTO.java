package org.web.borddto;

public class CrawlerDTO {
	private String src;
	private String href;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CrawlerDTO(String src, String href, String title) {
		super();
		this.src = src;
		this.href = href;
		this.title = title;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public CrawlerDTO() {
		super();
	}
	
}
