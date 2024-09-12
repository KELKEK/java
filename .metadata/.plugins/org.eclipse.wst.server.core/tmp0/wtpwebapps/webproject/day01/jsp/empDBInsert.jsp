<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="java.sql.Date"%>
<%@page import="com.shinhan.util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8"); //post방식일 때는 필수이다.
int employee_id = Integer.parseInt(request.getParameter("employee_id"));
String first_name = request.getParameter("first_name");    
String last_name = request.getParameter("last_name");    
String email = request.getParameter("email");    
String phone_number = request.getParameter("phone_number");    
Date hire_date = DateUtil.getSQLDate(request.getParameter("hire_date"));    
String job_id = request.getParameter("job_id");    
int salary = Integer.parseInt(request.getParameter("salary"));   
Double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
int manager_id = Integer.parseInt(request.getParameter("manager_id"));    
int department_id = Integer.parseInt(request.getParameter("department_id"));    

EmpService eservice = new EmpService();
EmpDTO emp = new EmpDTO();
emp.setCommission_pct(commission_pct);
emp.setDepartment_id(department_id);
emp.setEmployee_id(employee_id);
emp.setFirst_name(first_name);
emp.setLast_name(last_name);
emp.setPhone_number(phone_number);
emp.setHire_date(hire_date);
emp.setJob_id(job_id);
emp.setSalary(salary);
emp.setManager_id(manager_id);
emp.setDepartment_id(department_id);
emp.setEmail(email);
eservice.empInsert(emp);
System.out.println(emp);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>