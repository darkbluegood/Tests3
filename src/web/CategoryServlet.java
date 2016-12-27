package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import entity.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		if(request.getParameter("type").equals("del_p") || request.getParameter("type").equals("del_s")){
			Category category = new Category();
			category.del(request.getParameter("id"),request.getParameter("type"));
			response.getWriter().println("<script>alert('删除成功');window.location.href='admin/category.jsp'</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		 response.setCharacterEncoding("utf-8");

		Category category = new Category();
		category.add(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"),request.getParameter("type"),request.getParameter("fid"));
		response.getWriter().println("<script>alert('添加成功');window.location.href='admin/category.jsp'</script>");
	}

}
