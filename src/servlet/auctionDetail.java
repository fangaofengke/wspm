package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Auction;
import biz.Impl.AuctionbizImpl;

public class auctionDetail extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public auctionDetail() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		AuctionbizImpl abi=new AuctionbizImpl();
		
		Integer auctionid=Integer.parseInt(request.getParameter("auctionId"));
		
		Auction auc = abi.acutionbyid(auctionid);
		
		if(auc!=null){
			
			session.setAttribute("auction",auc);
			
			response.sendRedirect("auctionDetail.jsp");
			
		}else{
			
			
			request.setAttribute("message","此商品竞拍已结束或未开始");
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
		
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
