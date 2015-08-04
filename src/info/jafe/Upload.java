package info.jafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException, ServletException {
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out = response.getWriter();
//		String fileName = request.getParameter("filename");
		Part part = request.getPart("file");
		out.print("the uploaded file type: " + part.getContentType()
				+ ", size: " + part.getSize() + "<br/>");
		Collection<String> headerNames=part.getHeaderNames();
		for(String headerName:headerNames){
			out.println(headerName+": "+part.getHeader(headerName)+"<br/>");
		}
//		part.write(getServletContext().getRealPath("/uploadFiles")+"/"+Math.random());
		System.out.println(getServletContext().getRealPath("/uploadFiles"));

	}

}
