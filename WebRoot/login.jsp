<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h6>登陆</h6>
  	<s:form action="login" namespace="/" method="post">
  		<s:textfield name="user.username" label="用户名"></s:textfield>
  		<s:password name="user.userpwd" label="密码"></s:password>
  		<s:submit value="登陆"></s:submit>
  	</s:form>
  </body>
</html>
