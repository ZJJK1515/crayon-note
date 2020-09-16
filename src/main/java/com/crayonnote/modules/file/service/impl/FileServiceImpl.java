package com.crayonnote.modules.file.service.impl;

import com.crayonnote.modules.file.service.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传 & 处理 Service
 *
 * @author wy
 */
@Service
public class FileServiceImpl implements IFileService {

    /**
     * 外部访问静态资源的路径前缀
     */
    @Value("${crayon-note.file-upload.file-url-path}")
    private String fileUrlPath;

    /**
     * 上传文件存储到服务器的路径
     */
    @Value("${crayon-note.file-upload.upload-path}")
    private String uploadPath;

    /**
     * 文件上传接口，暂存到服务器上
     *
     * @param uploadFile 图片对象
     * @return url文件路径
     */
    @Override
    public String upload(MultipartFile uploadFile) {
        File file = new File(uploadPath + "/" + uploadFile.getOriginalFilename());
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileUrlPath + uploadFile.getOriginalFilename();
    }
}
