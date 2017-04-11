package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Auctionrecord;
import entity.Auctionuser;
import biz.Impl.AuctionrecordbizImpl;
import biz.Impl.AuctionuserbizImpl;

public class auctionBid extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public auctionBid() {
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

			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

			AuctionrecordbizImpl abi = new AuctionrecordbizImpl();

			Auctionrecord auc = new Auctionrecord();

			auc.setAuctiontime(df.format(System.currentTimeMillis()));
			
			auc.setAuctionprice(Double.parseDouble(request.getParameter("auctionPrice")));
			
			auc.setAuction(abi.getauction(Integer.parseInt(request.getParameter("auctionId"))));
			
			auc.setAuctionuser(abi.getauctionuser(Integer.parseInt(request.getParameter("auctionuserid"))));
			
			if(abi.getmaxprice(Integer.parseInt(request.getParameter("auctionId")))==0.0){
				
				if(abi.getstartprice(Integer.parseInt(request.getParameter("auctionId")))<Double.parseDouble(request.getParameter("auctionPrice"))){
					
					
					abi.addrecord(auc);
					
					response.sendRedirect("auctionList.jsp");
					
				}else{
					
					request.setAttribute("message","竞价金额不能低于起拍价");
					
					request.getRequestDispatcher("error.jsp").forward(request, response);
					
				}
				
			}else if(abi.getmaxprice(Integer.parseInt(request.getParameter("auctionId")))<Double.parseDouble(request.getParameter("auctionPrice"))){
				
				
				abi.addrecord(auc);
				
				response.sendRedirect("auctionList.jsp");
				
			}else{
				
				request.setAttribute("message","竞价金额不能低于最高竞价金额");
				
				request.getRequestDispatcher("error.jsp").forward(request, response);
				
			}

		} catch (Exception e) {
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
