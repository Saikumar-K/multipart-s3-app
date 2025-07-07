package com.practice.bservice.service;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practice.bservice.entity.CourseMaster;
import com.practice.bservice.formbean.Course;
import com.practice.bservice.repo.CourseRepo;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.EncryptionTypeMismatchException;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.InvalidRequestException;
import software.amazon.awssdk.services.s3.model.InvalidWriteOffsetException;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.TooManyPartsException;

@Service
public class CourseS3Service {

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	S3Client s3client;
	
	@Value("${aws.bucket.name}")
	String bucketName;
	
	public CourseMaster save(Course course) throws IOException {
		
		CourseMaster coursMaster = new CourseMaster();
		coursMaster.setCourse_name(course.getCourse_name());
		coursMaster.setCourse_price(course.getCourse_price());
		coursMaster.setCourse_duration(course.getCourse_duration());
		
		System.out.println("s3client ::"+s3client);		
		String fileName= UUID.randomUUID()+"-"+course.getCourse_image().getOriginalFilename();
		PutObjectRequest putObjectRequest = PutObjectRequest.builder()
				.bucket(bucketName)
				.key(fileName)
				.acl(ObjectCannedACL.PUBLIC_READ)
				.build();
		s3client.putObject(putObjectRequest, RequestBody.fromBytes(course.getCourse_image().getBytes()));
		
		String course_image_path = s3client.utilities().getUrl(GetUrlRequest.builder().bucket(bucketName).key(fileName).build()).toExternalForm();
		System.out.println("course_image_path :: "+course_image_path);
		coursMaster.setCourse_image_path(course_image_path);
		System.out.println(" manual building url :: "+ "https://"+bucketName+".s3.amazonaws.com/"+fileName);
		return courseRepo.save(coursMaster);
	}
	
	
}
