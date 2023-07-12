package com.bitacademy.guestbook.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.guestbook.dao.GuestbookDao;
import com.bitacademy.guestbook.vo.GuestbookVo;

/**
 * Servlet implementation class GuestbookController
 */
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String actionName = request.getParameter("a");
		GuestbookDao dao = new GuestbookDao();
		
		if ("add".equals(actionName)) {
			Calendar cal = Calendar.getInstance();
			GuestbookVo vo = new GuestbookVo();

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			String regDate = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
			
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setRegDate(regDate);
			
			dao.insert(vo);
			
			response.sendRedirect("/guestbook02/gb");
		} else if ("deleteform".equals(actionName)) {
			String no = request.getParameter("no");

			request.setAttribute("no", no);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} else if ("delete".equals(actionName)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			boolean equal = dao.checkPassword(no, password);
			if (equal){
				dao.delete(no);
				response.sendRedirect("/guestbook02/gb");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/delete.jsp");
				rd.forward(request, response);
			}
		} else {
			List<GuestbookVo> list = dao.findAll();
			int count = list.size();

			request.setAttribute("list", list);
			request.setAttribute("count", count);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
