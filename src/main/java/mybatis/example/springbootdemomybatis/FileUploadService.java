package mybatis.example.springbootdemomybatis;

import mybatis.example.springbootdemomybatis.model.File;
import mybatis.example.springbootdemomybatis.model.ResponseMessage;
import mybatis.example.springbootdemomybatis.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {

    private String uploadFolderPath = "C:\\Users\\Admin\\OneDrive\\Desktop\\upload/uploaded_";

    @Autowired
    FileRepository fileDBRepository;



    public ResponseMessage uploadToLocal(MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path, data);
            return new ResponseMessage("SUCCESS!!");
        } catch (IOException e) {
            return new ResponseMessage("not found!!");
        }
    }

    public File upload(MultipartFile file)  {
        File fileInfo = new File();
        try {
            fileInfo.setName(file.getOriginalFilename());
            fileInfo.setType(file.getContentType());
            fileInfo.setData(file.getBytes());
            return fileDBRepository.save(fileInfo);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public File downloadFile(int id){
        File file=fileDBRepository.getOne(id);
        return file;
    }

}