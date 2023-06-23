package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class PersonCreateController
 */
@WebServlet("/person/create")
public class PersonCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/person-create.jsp"); // dieu huong
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// đọc data gửi lên từ phía client
		String id = request.getParameter("idName");
		String name = request.getParameter("nameName");
		
		System.out.println(id);
		System.out.println(name);
		
		Person p = new Person();
		p.setId(Integer.parseInt(id)); // convert sang int
		p.setName(name);
		//save to db - chceck code jdbc in group
		//..
		// push person -> views
		request.setAttribute("person", p);
		request.getRequestDispatcher("/views/person-details.jsp").forward(request, response);
	}

}
