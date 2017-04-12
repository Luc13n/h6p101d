package demo;

import java.io.IOException;
import java.io.PrintWriter;
import lombok.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LombokPoc
 */
public class LombokPoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LombokPoc() {
        super();

    }

    //Note to run this, you need to install lombok in eclipse! 
    // Double click the jar from nexus and point it to your eclipse installation.
    // Afterwards restart eclipe + clean project

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String clientTaint = request.getParameter("info");
		PrintWriter out = response.getWriter();
		
		//directly -> should see reflected XSS in Fortify
		out.println(clientTaint);
		
		//indirectly
		DemoObject a = new DemoObject();
		a.setName(clientTaint);
		out.println(a.getName());
		
	}



}
