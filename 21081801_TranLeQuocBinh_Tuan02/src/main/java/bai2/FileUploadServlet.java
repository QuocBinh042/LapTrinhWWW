package bai2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Servlet implementation class FileUploadServlet
 */
@MultipartConfig(location = "C:\\Users\\Binh\\Desktop\\workspaceWWW\\ServletUploadFileDemo", fileSizeThreshold = 1024
		* 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String uploadPath = null;
	private static final String UPLOAD_DIRECTORY = "D:/FolderUpload";

	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		File uploadDir = new File(UPLOAD_DIRECTORY);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Part> fileParts = (List<Part>) request.getParts();
			fileParts.forEach(part -> {
	            System.out.println("Part Name: " + part.getName());
	            System.out.println("File Name: " + extractFileName(part));
	            System.out.println("Size: " + part.getSize());
	        });
			for (Part part : fileParts) {
				String fileName = extractFileName(part);
				if (fileName != null && !fileName.isEmpty()) {
					part.write(UPLOAD_DIRECTORY + File.separator + fileName);
					response.getWriter().println(fileName);
				}
			}
			response.getWriter().println("Uploaded successfully!");
		} catch (IOException | ServletException e) {
			response.getWriter().println("File upload failed due to: " + e.getMessage());
			e.printStackTrace(); 
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return null;
	}
}
