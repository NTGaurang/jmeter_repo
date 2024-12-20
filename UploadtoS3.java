import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
 
import java.io.File;
 
public class S3UploadExample {
 
    public static void main(String[] args) {
        // Replace with your AWS credentials
        String accessKey = "YOUR_ACCESS_KEY";
        String secretKey = "YOUR_SECRET_KEY";
        // Replace with your bucket name
        String bucketName = "your-bucket-name";
        // Replace with your file paths
        String filePath1 = "path/to/your/first/file.txt";
        String filePath2 = "path/to/your/second/file.txt";
        // Create AWS credentials
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        // Create an S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion("us-west-2") // Replace with your region
                .build();
        // Upload the first file
        File file1 = new File(filePath1);
        s3Client.putObject(new PutObjectRequest(bucketName, "file1.txt", file1));
        System.out.println("Uploaded file1.txt");
        // Upload the second file
        File file2 = new File(filePath2);
        s3Client.putObject(new PutObjectRequest(bucketName, "file2.txt", file2));
        System.out.println("Uploaded file2.txt");
    }
}
