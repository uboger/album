<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
    <h1>这是主页</h1>
    <s:a action="scanUser" namespace="/">
    	我的信息
    	<s:param name="id"><s:property value="#session.user.id"/></s:param>
    </s:a>
     <s:a action="#" namespace="/">
    	我的相册
    	<s:param name="id"><s:property value="#session.user.id"/></s:param>
    </s:a>
     <s:a action="findAllUser" namespace="/">
    	添加好友
    	<s:param name="user.id"><s:property value="#session.user.id"/></s:param>
    </s:a>
     <a href="myFriendList.jsp">查询好友</a>
    	
    <hr>
    <a href="createFolder.jsp">创建相册</a>
    <s:a action="hasUpload" namespace="/">
    	上传照片
    </s:a>
    <table bgcolor="#AADDEE" border="1">
    		<tr bgcolor="#EEDDAA"><td colspan="4">我的相册</td></tr>
    		<tr>
    			<th>相册名称</th>
    			<th>相册说明</th>
    			<th>所有权限</th>
    			<th>创建时间</th>
    			<th>查看相册</th>
    			<th>相册管理</th>
    		</tr>
    		<s:iterator value="#session.folders" var="folder">
    			<tr>
	    			<td><s:property value="#folder.foldername"/></td>
	    			<td><s:property value="#folder.folderinfor"/></td>
	    			<td>
						<s:if test="#folder.limitid==1">允许所有人查看</s:if>
						<s:if test="#folder.limitid==2">只允许好友查看</s:if>
						<s:if test="#folder.limitid==3">只允许自己查看</s:if>
					</td>
	    			<td><s:date name="#folder.createtime" format="yyyy-MM-dd   HH:mm"/></td>
	    			<td>
	    				<s:a action="scanFoler" namespace="/">查看相册
	    					<s:param name="folder.id"><s:property value="#folder.id"/></s:param>
	    					<s:param name="page.no">1</s:param>
	    				</s:a>
	    			</td>
	    			<td>相册管理</td>
    			</tr>
    		</s:iterator>
    </table>
  </body>
</html>
