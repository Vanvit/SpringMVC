package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.java.swing.plaf.windows.resources.windows;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// đọc dữ liệu từ client lên
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
			//SESSION
			HttpSession httpSession = request.getSession();
			System.out.println(httpSession.getId());
			
			httpSession.setAttribute("loginUser", username); // Sesion is used lưu lại username mà client nhập 
			
			// redirect - yeu cầu client gọi URL trả về
			response.sendRedirect("/ServletHelloWorld/admin/welcome"); // directional Servlet 
			
//			request.getRequestDispatcher("/views/loginSuccessfully.jsp").forward(request, response); // direction -> jsp file
			
		}else {
			// redirect - yeu cầu client gọi URL trả về
			response.sendRedirect("/ServletHelloWorld/login");
		}
		
		


	}

}
