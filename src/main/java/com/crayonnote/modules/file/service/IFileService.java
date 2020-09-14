package com.crayonnote.modules.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    /**
     * 将前端上传文件保存到服务器中，返回 url
     *
     * @param uploadFile 上传文件对象
     * @return 文件 url
     */
    String upload(MultipartFile uploadFile);
}
