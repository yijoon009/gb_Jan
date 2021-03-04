package com.koreait.action;

public class ActionForward {
	//어디로 전송할지 어떻게 전송할지
	
	private boolean isRedirect;
	private String path;
	
	public ActionForward() {;}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
