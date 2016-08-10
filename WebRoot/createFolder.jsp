<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
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
    <h6>新建相册</h6>
    <s:form action="createFolder" method="post" namespace="/"> 
    	<s:textfield name="folder.foldername" label="相册名称"></s:textfield>
    	<s:textfield name="folder.folderinfor" label="相册说明"></s:textfield>
    	<s:select name="folder.limitid" list="#{'1':'允许所有人访问','2':'只允许好友访问','3':'不允许任何人访问'}" label="访问权限" listKey="key" listValue="value" value="'2'"></s:select>
    	<s:hidden name="folder.uid" value="%{#session.user.id}"></s:hidden>
    	<s:submit value="创建"></s:submit>
    </s:form>
  </body>
</html>
