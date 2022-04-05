package one.AppOne.Funciones;


import org.springframework.stereotype.Service;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.IOException;
import java.io.InputStream;

@Service

public class Upload {



    private static final String BUCKET = "newbucketlarias";
    public static void uploadFile(String fileName, InputStream inputStream)
            throws S3Exception, AwsServiceException, SdkClientException, IOException {
        Region region = Region.US_WEST_2;
        S3Client s3 = S3Client.builder().region(region).build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        s3.putObject(request,
                RequestBody.fromInputStream(inputStream, inputStream.available()));
    }



    /* Region region = Region.US_WEST_2;
    S3Client s3 = S3Client.builder().region(region).build();

    String key = "key";




   public String uploadFile(MultipartFile file){
        String bucket = "newbucketlarias";
        File filedef = convertFile(file);
        String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
        s3.putObject(PutObjectRequest.builder().bucket(fileName).key(fileName).build(), RequestBody.fromByteBuffer(getRandomByteBuffer(1000)));
        filedef.delete();
        return "File Cargado";





}

  private static ByteBuffer getRandomByteBuffer(int size)  {
       byte[] b = new byte[size];
       new Random().nextBytes(b);
        return ByteBuffer.wrap(b);
   }

    private File convertFile(MultipartFile file){
        File fileConvert = new File(file.getOriginalFilename());

        try(FileOutputStream fos= new FileOutputStream(fileConvert)){
            fos.write(file.getBytes());
        }catch(IOException e){
            System.out.println("Error");

        }

    return fileConvert;
    }
*/

}
