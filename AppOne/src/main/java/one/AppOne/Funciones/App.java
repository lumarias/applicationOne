package one.AppOne.Funciones;

import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

public class App {

            Region region = Region.US_WEST_2;
            S3Client s3 = S3Client.builder().region(region).build();
public void file () {
    String bucket = "newbucketlarias";
    String key = "C:\\ejercicio\\applicationOne\\AppOne\\downloads\\ejm.csv";
     // Put Object
    s3.putObject(PutObjectRequest.builder().bucket(bucket).key(key)
            .build(), RequestBody.fromByteBuffer(getRandomByteBuffer(10000)));
}

    private static ByteBuffer getRandomByteBuffer(int size) {
        byte[] b = new byte[size];
        new Random().nextBytes(b);
        return ByteBuffer.wrap(b);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}



