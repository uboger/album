<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-dojo-tags"  prefix="sx"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<sx:head/>
<title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h5>详细信息</h5>
    <s:form action="modifyUser" method="post" namespace="/">
    	<s:hidden name="userInfor.id" value="%{#session.user.id}"></s:hidden>
    	<s:hidden name="userInfor.userpwd"></s:hidden>
    	<s:textfield name="userInfor.username" label="用户名"></s:textfield>
    	<s:radio list="#{'女':'女','男':'男' }" label="性  别" name="userInfor.sex" listKey="key" listValue="value"> </s:radio>
    	<sx:datetimepicker name="userInfor.birthday" label="生日" adjustWeeks="true" displayFormat="yyyy-MM-dd" toggleType="explode" value="dfgds"/>
    	<s:textfield name="userInfor.telephone" label="电话"> </s:textfield>
    	<s:textfield name="userInfor.email" label="邮箱"></s:textfield>
    	<s:textfield name="userInfor.address" label="联系地址"></s:textfield>
    	<s:textarea name="userInfor.remark" label="简介" cols="30" rows="5"></s:textarea>
    	<s:submit value="提交" style="text-align:left;"></s:submit>
    </s:form>
  </body>
</html>
