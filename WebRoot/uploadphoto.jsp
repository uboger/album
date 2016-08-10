<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
    <h6>上传照片</h6>
    <s:form action="upload" method="post" namespace="/" enctype="multipart/form-data">
    	<s:select list="folders" label="上传到" listKey="key" listValue="value" value="%{folder.id}"  name="photo.fid"></s:select>
    	<s:textfield name="photo.photoname" label="照片名称"></s:textfield>
    	<s:file name="image" label="选择照片" ></s:file>
    	<s:textarea name="photo.photoinfor" label="照片说明"></s:textarea>
    	<s:submit value="上传"></s:submit>
    </s:form>
  </body>
</html>
