package com.shinhan.controller4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/jsp/order.go")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String menuName = request.getParameter("lunch");
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println(menuName + "==>" + count);
		
		//request에 저장? <- 요청 시마다 값이 누적되는게 아니고 바뀌기만 하므로 비추천
		//session? <- 브라우저 당 하나! <- 이 방식이 제일 좋음(계속 유효함)
		//application? <- 다른사람과 공유되므로 쓰면 안됨
		//따라서 session에 저장
		
		HttpSession session = request.getSession();
		Map<String, Integer> cart = (Map<String, Integer>)session.getAttribute("cart");
		if(cart == null) {
			//한 번도 주문한 적이 없는 경우
			cart = new HashMap<String, Integer>();
			cart.put(menuName, count);
			session.setAttribute("cart", cart);
		}else {
			if(cart.containsKey(menuName)) {
				cart.put(menuName, cart.get(menuName) + count);
			}else {
				cart.put(menuName,count);
			}
		}

		
		request.getRequestDispatcher("orderResult.jsp").forward(request, response);
	}

}
