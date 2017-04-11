package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;






import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.sql.DATE;

import org.hibernate.Hibernate;
import org.apache.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Auction;
import antlr.build.Tool;
import biz.Impl.AuctionbizImpl;

public class addAuction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addAuction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		doPost(request, response);

		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();

		AuctionbizImpl abi = new AuctionbizImpl();

		Auction auc = new Auction();
		
	//	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		
		
		try {

		String uploadFileName = ""; // 上传的文件名

		String filedName = ""; // 表单字段元素的name属性值
		
		File fullfile=null;
		
		String name=null;

		// 请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		// 上传文件的存储路径(服务器文件系统上的绝对文件路径)
		String path = request.getSession().getServletContext()
				.getRealPath("upload/");

		if (isMultipart) {

			FileItemFactory factory = new DiskFileItemFactory();

			ServletFileUpload upload = new ServletFileUpload(factory);

			

				// 解析form表单中所有文件

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> iterator = items.iterator();

				while (iterator.hasNext()) {

					FileItem item = (FileItem) iterator.next();

					if (item.isFormField()) {

						filedName = item.getFieldName();

						String value=item.getString("UTF-8");
						
						if (filedName.equals("auctionName")) {

							auc.setAuctionname(value);
						}
						if (filedName.equals("startPrice")) {

							auc.setAuctionstartprice(Double.parseDouble(value));
						}
						if (filedName.equals("upset")) {
							auc.setAuctionupset(Double.parseDouble(value));
						}

						if (filedName.equals("startTime")) {

							auc.setAuctionstarttime(value);
						}

						if (filedName.equals("endTime")) {

							auc.setAuctionendtime(value);
						}

						if (filedName.equals("desc")) {

							auc.setAuctiondesc(value);
						}
					}else{
						
						String fileName=item.getName();
						
						if(fileName!=null&&!fileName.equals("")){
							
							fullfile=new File(item.getName());
							
							File saveFile=new File(path, fullfile.getName());
							
							item.write(saveFile);
							
							uploadFileName=fullfile.getName();
							
							name=uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
							
							System.out.println(uploadFileName);
						}
						
						
					}

				}

			
		}
		
		FileInputStream fis=new FileInputStream(fullfile);
		
		auc.setAuctionpic(Hibernate.createBlob(fis));
		
		auc.setAuctionpictype(name);
		
		auc.setPriname(uploadFileName);
		
		if(abi.addauction(auc)==1){
			
			response.sendRedirect("auctionList");
		}else{
			
			response.sendRedirect("addAuction.jsp");
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	

		


		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
