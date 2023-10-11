package com.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.internal.expression.function.TrimFunction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 int noteid=Integer.parseInt(request.getParameter("note_id").trim());
			 
			 Session s=FactoryProvider.getfactory().openSession();
			 Transaction tx=s.beginTransaction();
			 Note note=(Note)s.get(Note.class, noteid);
			 s.delete(note);
			 tx.commit();
			 s.close();
			 response.sendRedirect("allnotes.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
}
