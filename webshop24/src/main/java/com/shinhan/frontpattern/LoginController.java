package com.shinhan.frontpattern;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
public class LoginController implements CommonControllerInterface{
	@Override
	public String execute(Map<String, Object> dataMap) {
		String page = "login.jsp";
		String method = (String) dataMap.get("method");
		if(method.equals("get")) {return page;}
		
		EmpService service = new EmpService();
		String email = (String) dataMap.get("email");
		String phone = (String) dataMap.get("pswd");
		EmpDTO emp = service.loginChk(email, phone);
		if(emp==null || emp.getEmployee_id()==-1) {
			//존재하지않는 직원
			dataMap.put("message", "존재하지않는 직원");
		}else if(emp.getEmployee_id()==-2) {
			//비밀번호오류
			dataMap.put("message", "비밀번호오류");
		}else {
			//로그인성공... 요청한 페이지로 가기
			dataMap.put("loginEmp", emp);
			HttpSession session = (HttpSession) dataMap.get("session");
			String lastRequest = (String)session.getAttribute("lastRequest");
			if(lastRequest==null || lastRequest.equals("")) {
				return "redirect:";				
			}
			return "redirect:" + lastRequest;
		}
		//로그인에 실패하면 결과페이지보여주기
		
		return "result.jsp";
	}
}