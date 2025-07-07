package com.practice.bservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

	@Value("${aws.access.key.id}")
	private String accessKeyId;
	
	@Value("${aws.secret.access.key}")
	private String secretAccessKey;

	@Bean
	public S3Client s3client() {
		System.out.println("accessKeyId,secretAccessKey :: "+accessKeyId +","+ secretAccessKey);
		AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKeyId,secretAccessKey);
		return S3Client.builder()
		.region(Region.AP_SOUTH_1)
		.credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
		.build();
	}

}
