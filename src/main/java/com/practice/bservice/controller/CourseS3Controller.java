package com.practice.bservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.bservice.entity.CourseMaster;
import com.practice.bservice.formbean.Course;
import com.practice.bservice.service.CourseS3Service;

@RestController
public class CourseS3Controller {

	@Autowired
	CourseS3Service courseS3Service;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello-World";
	}
	
	
	@PostMapping("/uploadtos3")
	public String uploadtos3(@ModelAttribute Course course) throws IOException {
		if(course != null) {
			CourseMaster savedCourseMaster = courseS3Service.save(course);
			System.out.println("savedCourseMaster ="+savedCourseMaster);
			return "Success";
		}
		return "Failed";
	}
}




//File Details
//course.getCourse_image().getName() = course_image
//course.getCourse_image().getOriginalFilename() = Screenshot (2).png
//course.getCourse_image().getSize() = 375766
//course.getCourse_image().getContentType() = image/png
//course.getCourse_image().getBytes() = [B@41cb7d41
//course.getCourse_image().getResource() = MultipartFile resource [course_image]
//course.getCourse_image().getInputStream() = sun.nio.ch.ChannelInputStream@2f945ea9
//course.getCourse_image().getClass() = class org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile

//System.out.println("received request for Course  "+course);
//try {
//	System.out.println("File Details"
//			+ "\ncourse.getCourse_image().getName() = "+ course.getCourse_image().getName()
//			+ "\ncourse.getCourse_image().getOriginalFilename() = "+ course.getCourse_image().getOriginalFilename()
//			+ "\ncourse.getCourse_image().getSize() = "+ course.getCourse_image().getSize()
//			+ "\ncourse.getCourse_image().getContentType() = "+ course.getCourse_image().getContentType()
//			+ "\ncourse.getCourse_image().getBytes() = "+ course.getCourse_image().getBytes()
//			+ "\ncourse.getCourse_image().getResource() = "+ course.getCourse_image().getResource()
//			+ "\ncourse.getCourse_image().getInputStream() = "+ course.getCourse_image().getInputStream()
//			+ "\ncourse.getCourse_image().getClass() = "+ course.getCourse_image().getClass()
//			);
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}