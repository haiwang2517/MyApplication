package org.gradle.modle;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Books {
	
	private long id ;
	private String code;
	private String name;
	@JsonFormat(pattern="yyyyMMdd HH:mm:ss")
	private Timestamp create;
	private int status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreate() {
		return create;
	}
	public void setCreate(Timestamp create) {
		this.create = create;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
