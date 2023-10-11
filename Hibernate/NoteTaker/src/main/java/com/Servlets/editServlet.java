package com.Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteid=Integer.parseInt(request.getParameter("noteid").trim());
			Session s=FactoryProvider.getfactory().openSession();
			Transaction tx=s.beginTransaction();
			
			Note note=(Note)s.get(Note.class, noteid);
			note.setTitle(title);
			note.setContent(content);
			note.setAddeddate(new Date());
			
			
			tx.commit();
			s.close();
			response.sendRedirect("allnotes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
	}

}
