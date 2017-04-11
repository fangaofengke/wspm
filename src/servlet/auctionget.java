package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Auction;
import biz.Impl.AuctionbizImpl;

public class auctionget extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public auctionget() {
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

		try {
			request.setCharacterEncoding("utf-8");

			HttpSession session = request.getSession();

			AuctionbizImpl abi = new AuctionbizImpl();

			Integer auctionid = Integer.parseInt(request
					.getParameter("auctionid"));

			Auction auction = abi.getauctionbyid(auctionid);

			if (auction != null) {

				

				InputStream binaryStream = auction.getAuctionpic()
						.getBinaryStream();

				FileOutputStream fos = new FileOutputStream("C:/Users/hp/Workspaces/MyEclipse Professional 2014/Y2_Chap12/WebRoot/images/"
						+ auction.getPriname());

				int len = 0;

				while((len = binaryStream.read()) != -1) {

					fos.write(len);

				}

				fos.close();

				session.setAttribute("auc", auction);
				
				response.sendRedirect("auctionupdate.jsp");

			} else {

				request.setAttribute("message", "此拍卖品正在拍卖或已结束,不能修改!");

				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
