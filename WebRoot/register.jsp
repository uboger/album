<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h5>欢迎注册</h5>
  
    <s:form action="register" method="post" namespace="/">
    	<s:textfield name="user.username" label="用户名"></s:textfield>
    	<s:password name="user.userpwd" label="密码"></s:password>
    	<s:radio list="#{'女':'女','男':'男' }" label="性  别" name="user.sex" listKey="key" listValue="value" value="'女'"> </s:radio>
    	<sx:datetimepicker name="user.birthday" label="生日" type="date" />
    	<s:textfield name="user.telephone" label="电话"> </s:textfield>
    	<s:textfield name="user.email" label="邮箱"></s:textfield>
    	<s:textfield name="user.address" label="联系地址"></s:textfield>
    	<s:textarea name="user.remark" label="简介" cols="30" rows="5"></s:textarea>
    	<s:submit value="提交" style="text-align:left;"></s:submit>
    </s:form>
  </body>
</html>
