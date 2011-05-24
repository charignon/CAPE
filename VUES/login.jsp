<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jython JSP Test</title>
	<style>
	  body{
background : lightblue;}
	  #form{
	  width : 260px;
	  height : 170px;
	  margin : 150px auto ;
	  background : white;
	  text-align:center;
	  -moz-border-radius : 10px;
	  padding : 20px;
	  font-family: "Trebuchet MS", Verdana, Geneva, Arial;
	  line-height:30px;
	  }
	  .field {
-moz-border-radius : 10px;
background : #F2F2F2;
padding : 5px;
}


	  </style>
    </head>
    <body>
      <div id="form">
	<form method="POST" action="result.py">
          <label>Login</label><br/>
	  <input type="text" class="field" name="p"><br/>

          <label>Password</label><br/>
	  <input type="password" class="field" name="b"><br/><br/>

          <input type="submit">
        </form>
      </div>	
    </body>
</html>
