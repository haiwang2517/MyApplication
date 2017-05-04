package org.gradle.comm;

import java.io.Serializable;

public class ResultDTO<T> implements Serializable {
	
	private static final long serialVersionUID = -7966010812223817803L;

	private String code;
	
	private String message;
	
	private T content;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public ResultDTO(String code, String message, T content) {
		
		this.code = code;
		this.message = message;
		this.content = content;
	}

	public ResultDTO() {
		
	}
	
	public void success( T content){
		this.content = content;
		this.code="100";
		this.message="操作成功";
	}
	
	
}
