package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Log Filter Admin Successfully!!");
		// Session
		HttpServletRequest req= (HttpServletRequest) request; // ép kiểu
		HttpSession session = req.getSession(); // co Jsessionid thì lấy ra, chua có thì tạo mới
//		System.out.println(session.getId());
		Object key = session.getAttribute("loginUser");

//		String key = request.getParameter("key");
		if(key != null && String.valueOf(key).equals("admin")) {
			chain.doFilter(request, response); // goi ham nay de cho di qua
		}else {
			PrintWriter printWriter = response.getWriter();
			printWriter.println("No permission Admin!");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
