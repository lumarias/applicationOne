package one.AppOne.Funciones;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;

public class Bucket {

    //creacion de Bucket
    Region region = Region.US_WEST_2;
    S3Client s3 = S3Client.builder().region(region).build();
    String bucket = "newbucketlarias";

    public void crearBucket(){
    CreateBucketRequest createBucketRequest = CreateBucketRequest
            .builder()
            .bucket(bucket)
            .createBucketConfiguration(CreateBucketConfiguration.builder()
                    .locationConstraint(region.id())
                    .build())
            .build();

		s3.createBucket (createBucketRequest);}
}
