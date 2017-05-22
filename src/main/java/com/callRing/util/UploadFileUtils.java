package com.callRing.util;

import org.apache.commons.lang3.StringUtils;
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
	public static String uploadFile(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
		return getFileString(multipartFile, request);

	}

	private static String getFileString(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
		String newFileName = null;
		try { // 文件的原始名称
			String originalFilename = multipartFile.getOriginalFilename();

			if (multipartFile != null && originalFilename != null && originalFilename.length() > 0) {

				newFileName = UUID.randomUUID() + originalFilename;
				// 存储图片的物理路径
				String pic_path = request.getSession().getServletContext().getRealPath("/upload/callRing");
				// 新图片路径
				File targetFile = new File(pic_path, newFileName);
				// 内存数据读入磁盘
				multipartFile.transferTo(targetFile);
			}

		} catch (Exception e) {
			logger.error("文件上传转化错误", e.getMessage());
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
	public static List<String> uploadFileList(MultipartFile multipartFiles[], HttpServletRequest request)
			throws Exception {
		List<String> newFileNameList = new ArrayList<>();

		for (MultipartFile multipartFile : multipartFiles) {
			String newFileNme = getFileString(multipartFile, request);
			if (! StringUtils.isBlank(newFileNme)){

				newFileNameList.add(newFileNme);
			}
		}

		return newFileNameList;
	}
}
