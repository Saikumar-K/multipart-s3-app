package com.practice.bservice.formbean;

import org.springframework.web.multipart.MultipartFile;

public class Course {
	
	String course_name;
	String course_duration;
	Integer course_price;
	MultipartFile course_image;
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_duration() {
		return course_duration;
	}
	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}
	public Integer getCourse_price() {
		return course_price;
	}
	public void setCourse_price(Integer course_price) {
		this.course_price = course_price;
	}
	public MultipartFile getCourse_image() {
		return course_image;
	}
	public void setCourse_image(MultipartFile course_image) {
		this.course_image = course_image;
	}
	@Override
	public String toString() {
		return "Course [course_name=" + course_name + ", course_duration=" + course_duration + ", course_price="
				+ course_price + ", course_image=" + course_image + "]";
	}
	

}
