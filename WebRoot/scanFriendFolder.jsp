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
    <h5>好友的相冊</h5>
    <s:if test="friendFolders.size()!=0">
   <table bgcolor="#AADDEE" border="1">
    		<tr bgcolor="#EEDDAA"><td colspan="4"><s:property value="friend.username"/>的相册</td></tr>
    		<tr>
    			<th>相册名称</th>
    			<th>相册说明</th>
    			<th>创建时间</th>
    			<th>查看相册</th>
    			<th>相册管理</th>
    		</tr>
    		<s:iterator value="friendFolders" var="folder">
			<s:if test="#folder.limitid==1"><tr>
	    			<td><s:property value="#folder.foldername"/></td>
	    			<td><s:property value="#folder.folderinfor"/></td>
	    			
	    			<td><s:date name="#folder.createtime" format="yyyy-MM-dd   HH:mm"/></td>
	    			<td>
	    				<s:a action="scanFriendPhotos" namespace="/">查看相册
	    					<s:param name="folder.id"><s:property value="#folder.id"/></s:param>
	    					<s:param name="page.no">1</s:param>
	    				</s:a>
	    			</td>
	    			<td>相册管理</td>
    			</tr></s:if>
			<s:if test="#folder.limitid==2">
				<s:if test="%{ifIsMyFriend||#folder.uid==#session.user.id}">
				<tr>
	    			<td><s:property value="#folder.foldername"/></td>
	    			<td><s:property value="#folder.folderinfor"/></td>
	    			
	    			<td><s:date name="#folder.createtime" format="yyyy-MM-dd   HH:mm"/></td>
	    			<td>
	    				<s:a action="scanFriendPhotos" namespace="/">查看相册
	    					<s:param name="folder.id"><s:property value="#folder.id"/></s:param>
	    					<s:param name="page.no">1</s:param>
	    				</s:a>
	    			</td>
	    			<td>相册管理</td>
    			</tr>
    			</s:if>
    			<s:else>
    			</s:else>
    		</s:if>
			<s:if test="%{#folder.limitid==3}"><tr>
	    		<s:if test="%{#folder.uid==#session.user.id}">
	    			<tr>
	    			<td><s:property value="#folder.foldername"/></td>
	    			<td><s:property value="#folder.folderinfor"/></td>
	    			
	    			<td><s:date name="#folder.createtime" format="yyyy-MM-dd   HH:mm"/></td>
	    			<td>
	    				<s:a action="scanFoler" namespace="/">查看相册
	    					<s:param name="folder.id"><s:property value="#folder.id"/></s:param>
	    					<s:param name="page.no">1</s:param>
	    				</s:a>
	    			</td>
	    			<td>相册管理</td>
    			</tr>
	    		</s:if>
    			<s:else>
    			</s:else>
    		</s:if>
    			
    		</s:iterator>
    </table>
    </s:if>
    <s:else>
    	暫無相冊
    </s:else>
  </body>
</html>
