package com.thomas.pulltorefreshstaggeredgridview;

import com.google.gson.Gson;

public class PhotoBean {
	private String imagePath; 
	private String userName;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PhotoBean(String imagePath,String userName) {
		this.imagePath = imagePath; 
		this.userName = userName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this);
	}
}
