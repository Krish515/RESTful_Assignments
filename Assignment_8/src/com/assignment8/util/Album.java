package com.assignment8.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "album")
@XmlAccessorType(XmlAccessType.FIELD)
public class Album {
	private String title;
	private String singer;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	@Override
	public String toString() {
		return "Album [\nTitle=" + title + " \nSinger=" + singer + "]";
	}
}
