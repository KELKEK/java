<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

form {
  border: 3px solid #f1f1f1;
  display: flex;
  flex-wrap: wrap; /* 요소들을 여러 줄에 걸쳐 표시할 수 있도록 설정 */
}

img.avatar {
  width: 40%;
  border-radius: 50%;
  margin-right: 5%;
}

.container {
  width: 50%;
  padding: 16px;
}

.container1 {
  width: 100%; /* 수정된 부분: 너비를 100%로 설정하여 한 줄을 차지하도록 함 */
  padding: 16px;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn, .joinbtn {
  width: auto;
  padding: 10px 18px;
}

.cancelbtn {
  background-color: #f44336;
}

.joinbtn {
  background-color: #04AA6D;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn, .joinbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<h2 style="text-align: center;">CRS Login Form</h2>

<form action="/action_page.php" method="post">
    <img src="logincoffee.jpg" alt="Avatar" class="avatar">

  <div class="container">
    <h1>CRS에 방문하신 것을 환영합니다!</h1>
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container1" style="background-color: #f1f1f1;">
    <button type="button" class="cancelbtn">Cancel</button>
    <button type="button" class="joinbtn">Join</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>

</body>
</html>
