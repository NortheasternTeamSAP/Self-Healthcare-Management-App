/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ankur Bywar
 */

/*
    Exanple of how upload/download file from S3

    S3Helper s3Helper = new S3Helper();
    s3Helper.putObject(key, absoluteFilePathOnDiskToBeUploadedToS3);
    s3Helper.getObject(key, absoluteFilePathOnDiskWhereFileFromS3ShouldBeSaved);

    For S3 APIs to work, you need to setup AWS S3 credentials (as environment variables)

*/
public class AwsS3Helper {
    
    AmazonS3 s3Client;
    String s3BucketName = "ankur-info5100-s3bucket";
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    public AwsS3Helper() {
        s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
    }
    
    public boolean putObject(String key_s3Path, String value_filePath) {
        try {
            s3Client.putObject(s3BucketName, key_s3Path, new File(value_filePath));
        } catch (Exception e) {
            log.error("Error while putting object in S3. S3bucketName: " + s3BucketName + " S3path: " 
                    + key_s3Path + " File path: " + value_filePath + " Exception: " + e.getMessage());
            return false;
        } 
        
        return true;
    }
    
    public boolean getObject(String key_s3Path, String value_filePathToWriteResponse) {
        S3Object s3Object = null;
        try {
            s3Object = s3Client.getObject(s3BucketName, key_s3Path);
        } catch (Exception e) {
            log.error("Error writing getting object from s3. Bucket name: " 
                    + s3BucketName + " S3path: " + key_s3Path + " Exception: " + e.getMessage());
            return false;
        }

        
        try {
            S3ObjectInputStream objectContent = s3Object.getObjectContent();
            IOUtils.copy(objectContent, new FileOutputStream(value_filePathToWriteResponse));
        } catch(Exception e) {
            log.error("Error writing S3 response to a file " + 
                    value_filePathToWriteResponse + " Exception: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
//    public boolean getObject(String key_s3Path, String value_filePathToWriteResponse) {
//        
//        String s3Object = null;
//        try {
//            s3Object = s3Client.getObjectAsString(s3BucketName, key_s3Path);
//        } catch (Exception e) {
//            log.error("Error writing getting object from s3. Bucket name: " 
//                    + s3BucketName + " S3path: " + key_s3Path + " Exception: " + e.getMessage());
//            return false;
//        }
//
//        
//        try {
//            try (FileWriter myWriter = new FileWriter(value_filePathToWriteResponse)) {
//                myWriter.write(s3Object);
//            }
//        } catch(Exception e) {
//            log.error("Error writing S3 response to a file " + 
//                    value_filePathToWriteResponse + " Exception: " + e.getMessage());
//            return false;
//        }
//        
//        return true;
//    }
}
