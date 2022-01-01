package com.example.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
	private String id;
	private String password;
	private String userName;
	private Date birthday;
	private Integer sex;
	private String phoneNumber;
	private String postCode;
	private String address;
}
