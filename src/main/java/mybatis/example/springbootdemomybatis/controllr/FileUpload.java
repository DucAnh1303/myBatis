package mybatis.example.springbootdemomybatis.controllr;

import mybatis.example.springbootdemomybatis.FileUploadService;
import mybatis.example.springbootdemomybatis.model.File;
import mybatis.example.springbootdemomybatis.model.Response;
import mybatis.example.springbootdemomybatis.model.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;





@RestController
@RequestMapping("/file")
public class FileUpload {
    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/upload/local")
    public void uploadFileLocal(@RequestParam("fileLocal") MultipartFile file) {
        fileUploadService.uploadToLocal(file);
    }

    @PostMapping("/upload/db")
    public ResponseMessage uploadFile(@RequestParam("file") MultipartFile file)  {
        File fileUpload=fileUploadService.upload(file);
        Response response=new Response();
        if (fileUpload !=null){
            String downloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/file/download")
                    .path(String.valueOf(fileUpload.getId()))
                    .toUriString();
            response.setUrl(downloadUrl);
            response.setType(fileUpload.getType());
            response.setName(fileUpload.getName());
            return new ResponseMessage("SUCCESS");

        }
        return new ResponseMessage("not SUCCESS");
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") int id)
    {
        File uploadedFileToRet =  fileUploadService.downloadFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploadedFileToRet.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= "+uploadedFileToRet.getName())
                .body(new ByteArrayResource(uploadedFileToRet.getData()));
    }


}
