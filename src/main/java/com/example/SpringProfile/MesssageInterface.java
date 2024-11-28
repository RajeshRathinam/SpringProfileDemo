package com.example.SpringProfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public interface MesssageInterface {
	public void showMsg();
}

@Service
@Profile("dev")
class DevProfile implements MesssageInterface {

	@Override
	public void showMsg() {
		System.out.println("Welcome to Dev profile.");
	}
}

@Service
@Profile("test")
class TestProfile implements MesssageInterface {
	@Value("${my.website.name}")
	private String myWebsiteName;

	@Override
	public void showMsg() {
		System.out.println("Welcome to Test profile." + myWebsiteName);
	}
}