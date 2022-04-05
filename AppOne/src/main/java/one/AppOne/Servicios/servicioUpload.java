package one.AppOne.Servicios;

import one.AppOne.Funciones.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/file")
public class servicioUpload {

    @Autowired
    private Upload service;


    @PostMapping(value="/upload")
   public String handleUploadForm(@RequestParam("file") MultipartFile multipart) {
       String fileName = multipart.getOriginalFilename();

       System.out.println("filename: " + fileName);

       String message = "";

       try {
           service.uploadFile(fileName, multipart.getInputStream());
           message = "Your file has been uploaded successfully!";
       } catch (Exception ex) {
           message = "Error uploading file: " + ex.getMessage();
       }

       return "message";
   }

   @GetMapping("/test")
   public String prueba(){
       return "message";

   }


}
