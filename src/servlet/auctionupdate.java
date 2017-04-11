package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Hibernate;

import entity.Auction;
import biz.Impl.AuctionbizImpl;
import biz.Impl.AuctionrecordbizImpl;

public class auctionupdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public auctionupdate() {
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

		AuctionbizImpl abi = new AuctionbizImpl();

		AuctionrecordbizImpl arbi = new AuctionrecordbizImpl();

		Auction auc = arbi.getauction(Integer.parseInt(request
				.getParameter("auctionid")));

		try {

			// 上传的文件名
			String uploadfilename = "";

			// 表单字段属性名
			String filedname = "";

			File fullfile = null;

			String name = null;

			// 请求信息中的内容是否是multipart类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			String path = request.getSession().getServletContext()
					.getRealPath("uploads/");

			if (isMultipart) {

				FileItemFactory factory = new DiskFileItemFactory();

				ServletFileUpload upload = new ServletFileUpload(factory);

				// 解析表单中的所有元素

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> iterator = items.iterator();

				while (iterator.hasNext()) {

					FileItem item = (FileItem) iterator.next();

					if (item.isFormField()) {

						filedname = item.getFieldName();

						String value = item.getString("utf-8");

						if (filedname.equals("auctionName")) {

							auc.setAuctionname(value);
						}
						if (filedname.equals("startPrice")) {

							auc.setAuctionstartprice(Double.parseDouble(value));
						}
						if (filedname.equals("upset")) {
							auc.setAuctionupset(Double.parseDouble(value));
						}

						if (filedname.equals("startTime")) {

							auc.setAuctionstarttime(value);
						}

						if (filedname.equals("endTime")) {

							auc.setAuctionendtime(value);
						}

					} else {

						String filename = item.getName();

						if (filename != null && !filename.equals("")) {

							fullfile = new File(item.getName());

							File saveFile = new File(path, fullfile.getName());

							item.write(saveFile);

							uploadfilename = fullfile.getName();

							name = uploadfilename.substring(uploadfilename
									.lastIndexOf(".") + 1);

							System.out.println(uploadfilename);
						}

					}

				}

			}

			FileInputStream fis = new FileInputStream(fullfile);

			auc.setAuctionpic(Hibernate.createBlob(fis));

			auc.setAuctionpictype(name);

			auc.setPriname(uploadfilename);

			if (abi.updateauction(auc) == 1) {

				response.sendRedirect("auctionList");

			} else {

				request.setAttribute("message", "修改失败");

				request.getRequestDispatcher("error.jsp").forward(request,
						response);
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
