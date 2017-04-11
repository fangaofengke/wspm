package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.fenye;
import entity.Auction;
import entity.Auctionuser;
import biz.Impl.AuctionbizImpl;
import biz.Impl.AuctionuserbizImpl;

public class doLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doLogin() {
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

		AuctionuserbizImpl abi = new AuctionuserbizImpl();

		String username = request.getParameter("username");

		String userpassword = request.getParameter("userpassword");

		String inputCode = request.getParameter("inputCode");

		if (!inputCode.equals(session.getAttribute("numrand"))) {

			/*
			 * session.setAttribute("msg", "validateCodeError");
			 * 
			 * session.setAttribute("username", username);
			 * 
			 * session.setAttribute("userpassword", userpassword);
			 * 
			 * response.sendRedirect("login.jsp");
			 */

			request.setAttribute("message", "验证码输入错误");

			request.getRequestDispatcher("error.jsp")
					.forward(request, response);

		} else {
			if (abi.loginuser(username, userpassword) == 1) {

				Auctionuser auctionuser = abi.loginbyuserid(username,
						userpassword);

				session.setAttribute("user", auctionuser);

				response.sendRedirect("auctionList");

			} else {
				/*
				 * session.setAttribute("msg", "loginError");
				 * 
				 * response.sendRedirect("login.jsp");
				 */

				request.setAttribute("message", "用户名或密码错误");

				request.getRequestDispatcher("error.jsp").forward(request,
						response);
			}
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
