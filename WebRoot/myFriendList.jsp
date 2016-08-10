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
    <h6>我的好友列表</h6>
    <s:if test="#session.friendList.size()!=0">
    <table>
    	<tr>
	    	<th>好友名称</th>
	    	<th>浏览相册</th>
	    	<th>查看</th>
	    	<th>操作</th>
    	</tr>
    	<s:iterator value="#session.friendList" var="friend">
    	<tr>
	    	<td><s:property value="#friend.username"/></td>
	    	<td>
	    		<s:a action="scanFriendFolder" namespace="/">浏览相册
	    			<s:param name="friendid"><s:property value="#friend.id"/></s:param>
	    		</s:a>
	    	</td>
	    	<td>
	    		<s:a>查看詳情</s:a>
	    	</td>
	    	<td>
	    		<s:a>刪除好友</s:a>
	    	</td>
    	</tr>
    	</s:iterator>
    </table>
    </s:if>
    <s:else>
    	暂无好友
    </s:else>
  </body>
</html>
