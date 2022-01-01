package com.example.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String id;
	
	@NotBlank(groups = ValidGroup1.class)
	private String userName;
	
	@Length(min = 4, max = 8, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
	@NotBlank(groups = ValidGroup1.class)
	private String password;
	
	@NotNull(groups = ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	@NotNull(groups = ValidGroup1.class)
	private Integer sex;
	
	@Length(min = 10, max = 11,	groups = ValidGroup2.class)
	@NotBlank(groups = ValidGroup1.class)
	private String phoneNumber;
	
	@NotBlank(groups = ValidGroup1.class)
	@Pattern(regexp = "^[0-9]{7}$", groups = ValidGroup2.class)
	private String postCode;
	
	@NotBlank(groups = ValidGroup1.class)
	private String address;
}
