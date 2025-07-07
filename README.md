# multipart-s3-app
uploading a file into s3 bucket

# To undo the commits in local before push
git reset --hard origin/main

# properties removed due to secrets issues
aws.access.key.id=add your own
aws.secret.access.key=add your own

# H2 Console:: http://localhost:8080/h2-console
select * from course_master;

# AWS S3
=> S3 stands for simple storage service
=> S3 is used for unlimited storage
=> S3 works based on Object storage (object = file)
=> S3 is a paid service (for storing & for retriving)
=> S3 maintains objects by using buckets concept
=> Buckets are used to seperate objects logically.
=> In one Bucket we can store group of objects (no limitation).
=> When we upload object in the bucket then object url will be generated.

Ex:
Netflix is using AWS S3 buckets to store movies mp3 files.

# Lab Task
1) Create General purpose bucket
2) Give Unique Name for bucket
3) Select ACLs enable
4) Grant public access (uncheck check box)
5) Create Bucket
6) Go inside bucket and upload objects with public read access
7) Take Object URL and access that url in your browser.

# Assignment
1) Develop one web application to store course details
		- Course Name
		- Course Duration
		- Course Price
		- Course Image
Note: Course image should be stored into AWS s3 bucket and course info should be stored into db table.
Note: In database table we will store course image url which is uploaded in aws s3 bucket.
Note: To implement this task we need IAM user with S3FullAccess & Security Credentials of IAM user.
Note: We need to use AWS SDK to perform this operation.
