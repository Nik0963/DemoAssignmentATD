package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	@NonNull
	private Long id;


	@NotBlank
	@Size(max = 25)
	private String name;
	

	@NotBlank
	@Size(min = 10,max = 10)
	private String mobileNumber;
	

	@Email
	@Size(max = 30)
	private String email;


	@NotBlank
	@Size(max = 25)
	private String city;
}
