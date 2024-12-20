import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
 
import java.io.File;
 
public class S3UploadExample {
 
    public static void main(String[] args) {
        // Replace with your AWS credentials
        String accessKey = "";
        String secretKey = "";
        // Replace with your bucket name
        String bucketName = "test.artifacts";
        // Replace with your file paths
        String filePath1 = "/home/gaurang/Result.jtl";
        String filePath1 = "/home/gaurang/Report/Index.html";
        // Create AWS credentials
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        // Create an S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion("us-west-2") // Replace with your region
                .build();
        // Upload the first file
        File file1 = new File(filePath1);
        s3Client.putObject(new PutObjectRequest(bucketName, "Result.jtl", file1));
        System.out.println("Uploaded Results.jtl");
        // Upload the second file
        File file2 = new File(filePath2);
        s3Client.putObject(new PutObjectRequest(bucketName, "Index.html", file2));
        System.out.println("Uploaded Index.html");
    }
}
