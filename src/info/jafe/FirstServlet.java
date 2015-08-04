package info.jafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		System.out.println("a new servlet");//TODO
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		System.out.println("doGet!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		System.out.println("doPost");
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String parameters1[] = request.getParameterValues("name");
		String parameters2 = request.getParameter("doRedirect");
		Enumeration headerNames = request.getHeaderNames();
		try {
			out.print("<html>\n<head>\n<title>Servlet FirstServlet</title>\n</head>\n");
			out.println("<body>");
			out.println("<h1>Servlet FirstServlet at"
					+ request.getContextPath() + "</h1>");
			out.println("<hr>");
			if (parameters1 != null ){
				for(String nameStr:parameters1){
					out.println(nameStr);
				}
			}
			
			out.print("<table>");
			while(headerNames.hasMoreElements()){
				String headerName = (String) headerNames.nextElement();
				String headerValue = request.getHeader(headerName);
				out.print("<tr>");
				out.print("<td>"+headerName+"</td>");
				out.print("<td>"+headerValue+"</td>");
				out.print("</tr>");
			}
			out.print("<tr>");
			
			if(parameters2!=null&&parameters2.equals("yes")){
				response.sendRedirect("dest.html");
			}
			out.println("</body>\n</html>");
		} finally {
			out.close();
		}

	}
	public void destroy(){
		super.destroy();
		System.out.println("destroy");
	}

}
