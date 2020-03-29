package com.crayonnote.modules.system.article;

import com.crayonnote.modules.common.utils.CrayonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/image")
public class ImageContoller {


    @RequestMapping("/upload")
    public CrayonResult upload(MultipartFile image) {
        File file = new File("c:/users/ZJJK/desktop/image/" + image.getOriginalFilename());
        try {
            image.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return CrayonResult.error("");
        }
        return CrayonResult.ok().put("url", "/crayon-note/image/" + image.getOriginalFilename());
    }

}
