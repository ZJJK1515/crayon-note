package com.crayonnote.modules.file.controller;

import com.crayonnote.common.utils.CrayonResult;
import com.crayonnote.modules.file.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/fileUpload")
public class FileController {


    @Autowired
    private IFileService fileService;

    /**
     * 文件上传接口，暂存到服务器上
     *
     * @param uploadFile 图片对象
     * @return url文件路径
     */
    @RequestMapping("/upload")
    public CrayonResult upload(MultipartFile uploadFile) {

        return CrayonResult.ok(fileService.upload(uploadFile));
    }

}
