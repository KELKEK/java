package com.shinhan.controller2;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
//----------여러페이지로 이동시 특정정보를 유지하기 위함이다.-------
//쿠키를 만들어서 응답문에 실어서 보낸다.
//브라우저에 저장된다.
//재요청시 request에 담아서 간다.
//쿠키를 확인할 수 있다.
@WebServlet("/jsp/cookieSet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		//index.html과 name이 같은지 잘 확인해봐야 한다.
		
		Cookie c1 = new Cookie("myid", id);
		Cookie c2 = new Cookie("mypass", pass);
		Cookie c3 = new Cookie("myinfo", URLEncoder.encode("신한금융sw아카데미", "utf-8"));
		c1.setMaxAge(24*60*60);//하루동안 유효
		c2.setMaxAge(60);//1분동안 유효
		//c3는 유효시간을 설정하지 않아서 브라우저 종료시 지워진다.
		//은행사이트에서 접속중 이렇게 뜨다가 일정시간동안 아무런 반응도 안하고 있을 시에 로그인 정보가 사라지는 것이 쿠키,세션과 같은 원리이다.
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		request.getRequestDispatcher("cookie.jsp").forward(request, response);
		//제대로 쿠키가 생성이 되었는지 확인하기 위해 cookie.jsp에 위임한 것
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
