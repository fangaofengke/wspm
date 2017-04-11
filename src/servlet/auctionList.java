package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.fenye;
import biz.Impl.AuctionbizImpl;
import entity.Auction;

public class auctionList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public auctionList() {
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

			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			
			HttpSession session = request.getSession();

			Auction auc = new Auction();

			AuctionbizImpl abi = new AuctionbizImpl();

			fenye fen = new fenye();

			String index = request.getParameter("pageindex");

			if (index != null) {

				fen.setPageindex(Integer.parseInt(index));

			} else {
				fen.setPageindex(1);
			}

			String auctionname = request.getParameter("auctionName");
			String auctiondesc = request.getParameter("auctionDesc");
			String auctionstarttime = request.getParameter("auctionStartTime");
			String auctionendtime = request.getParameter("auctionEndTime");
			String auctionstartprice = request.getParameter("auctionStartPrice");

			if (auctionname != null && !auctionname.equals("")) {

				auc.setAuctionname(auctionname);

			} else {
				auc.setAuctionname(null);
			}

			if (auctiondesc != null && !auctiondesc.equals("")) {

				auc.setAuctiondesc(auctiondesc);

			} else {

				auc.setAuctiondesc(null);

			}

			if (auctionstarttime != null && !auctionstarttime.equals("")) {

				auc.setAuctionstarttime(auctionstarttime);

			} else {

				auc.setAuctionstarttime(null);

			}

			if (auctionendtime != null && !auctionendtime.equals("")) {

				auc.setAuctionendtime(auctionendtime);

			} else {

				auc.setAuctionendtime(null);

			}

			if (auctionstartprice != null && !auctionstartprice.equals("")) {

				auc.setAuctionstartprice(Double.parseDouble(auctionstartprice));

			} else {

				auc.setAuctionstartprice(null);

			}

			List<Auction> list = abi.listauction(fen, auc);

			session.setAttribute("pageList", list);

			session.setAttribute("pageindex", fen.getPageindex());

			session.setAttribute("totalpage", fen.getTotalpage());

			response.sendRedirect("auctionList.jsp");
		}catch(Exception e){
			
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
