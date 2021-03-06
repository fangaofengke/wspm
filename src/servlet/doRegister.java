package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Auctionuser;
import biz.Impl.AuctionuserbizImpl;

public class doRegister extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public doRegister() {
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

		Auctionuser auc = new Auctionuser();

		auc.setUsername(request.getParameter("username"));
		auc.setUserpassword(request.getParameter("userpassword"));
		auc.setUsercardno(request.getParameter("usercardno"));
		auc.setUsertel(request.getParameter("usertel"));
		auc.setUseraddress(request.getParameter("useraddress"));
		auc.setUserpostnumber(request.getParameter("userpostnumber"));
		auc.setUserisadmin(0);

		String inputCode = request.getParameter("inputCode");

		if (!inputCode.equals(session.getAttribute("numrand"))) {

			/*
			 * session.setAttribute("msg", "validateCodeError");
			 * 
			 * session.setAttribute("registerUser", auc);
			 * 
			 * response.sendRedirect("register.jsp");
			 */

			request.setAttribute("message", "��֤���������");

			request.getRequestDispatcher("error.jsp")
					.forward(request, response);

		} else {
			if (abi.adduser(auc) == 1) {

				session.setAttribute("msg", "registerSuccess");

				response.sendRedirect("login.jsp");
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
