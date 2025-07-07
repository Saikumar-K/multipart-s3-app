package com.practice.bservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "COURSE_MASTER")
public class CourseMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long course_id;
	
	String course_name;
	String course_duration;
	Integer course_price;
	String course_image_path;
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
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
	public String getCourse_image_path() {
		return course_image_path;
	}
	public void setCourse_image_path(String course_image_path) {
		this.course_image_path = course_image_path;
	}
	@Override
	public String toString() {
		return "CourseMaster [course_id=" + course_id + ", course_name=" + course_name + ", course_duration="
				+ course_duration + ", course_price=" + course_price + ", course_image=" + course_image_path + "]";
	}

}
