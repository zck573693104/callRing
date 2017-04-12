package com.util;

import com.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UploadFileUtils {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

    /**
     * 上传文件 返回值为文件的新名字 UUID.randomUUID()+originalFilename
     *
     * @param multipartFile
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String uploadFile(MultipartFile multipartFile, HttpServletRequest request) throws IllegalStateException, IOException {
        //文件的原始名称
        String originalFilename = multipartFile.getOriginalFilename();
        String newFileName = null;
        if (multipartFile != null && originalFilename != null && originalFilename.length() > 0) {

            newFileName = UUID.randomUUID() + originalFilename;
            //存储图片的物理路径
            String pic_path = request.getSession().getServletContext().getRealPath("/upload/callRing");
            //新图片路径
            File targetFile = new File(pic_path, newFileName);
            //内存数据读入磁盘
            multipartFile.transferTo(targetFile);

        }
        return newFileName;
    }

    /**
     * 批量上传文件 返回值为文件的新名字 UUID.randomUUID()+originalFilename
     *
     * @param multipartFiles
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static List<String> uploadFileList(MultipartFile multipartFiles[], HttpServletRequest request) throws IllegalStateException, IOException, CustomException {
        List<String> newFileNames = new ArrayList<>();
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                //文件的原始名称
                String originalFilename = multipartFile.getOriginalFilename();
                String newFileName = null;
                if (multipartFile != null && originalFilename != null && originalFilename.length() > 0) {

                    newFileName = UUID.randomUUID() + originalFilename;
                    //存储图片的物理路径
                    String pic_path = request.getSession().getServletContext().getRealPath("/upload/callRing");
                    //新图片路径
                    File targetFile = new File(pic_path, newFileName);
                    //内存数据读入磁盘
                    multipartFile.transferTo(targetFile);
                    newFileNames.add(newFileName);
                }

            }

        } catch (IOException e) {
            logger.debug(e.getMessage());
            throw new CustomException(e.getMessage());
        }
        return newFileNames;
    }
}
