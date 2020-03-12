package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    private static final String SAVE_PATH = System.getProperty("user.dir") + File.separator + "upload";

    @RequestMapping("/fileupload")
    public void fileUpload(HttpServletResponse request, @RequestParam("filename") MultipartFile file) throws IOException {

        System.out.println("@@@@@@");
        System.out.println(file.getOriginalFilename());

        byte[] data = file.getBytes();
        System.out.println(SAVE_PATH);
        File f = new File(SAVE_PATH);
        if(!f.exists()) {
            f.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(SAVE_PATH + File.separator + file.getOriginalFilename() + ".jpg");
        fos.write(data);
        fos.close();

    }

}
