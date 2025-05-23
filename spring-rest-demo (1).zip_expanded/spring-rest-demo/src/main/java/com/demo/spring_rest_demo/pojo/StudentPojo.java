package com.demo.spring_rest_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentPojo {
	private int studId;
	private String studName;
	private int studMark;
	
}
