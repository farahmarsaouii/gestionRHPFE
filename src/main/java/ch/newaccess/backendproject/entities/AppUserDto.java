package ch.newaccess.backendproject.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDto {
private Long id;
private Long pid;
private String name;
private String title;
private String img;


public AppUserDto() {
	super();
}


public AppUserDto(Long id, Long pid, String name, String title, String img) {
	super();
	this.id = id;
	this.pid = pid;
	this.name = name;
	this.title = title;
	this.img = img;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public Long getPid() {
	return pid;
}


public void setPid(Long pid) {
	this.pid = pid;
}


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


public String getImg() {
	return img;
}


public void setImg(String img) {
	this.img = img;
}



}
