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
    <h6>用户列表</h6>
    <s:if test="page.results.size()!=0">
    	<table>
    		<tr>
    			<th>用户名称</th>
    			<th>查看相册</th>
    			<th>详情</th>
    			<th>添加</th>
    		</tr>
    		<!-- 获取分页的用户列表 -->
    		<s:iterator value="page.results" var="user">
    			<tr>
    				<td><s:property value="#user.username"/></td>
    				<td>
						<s:a action="scanFriendFolder" namespace="/">浏览相册
			    			<s:param name="friendid"><s:property value="#user.id"/></s:param>
			    		</s:a>
					</td>
    				<td>
    					<s:a>查看详情</s:a>
    				</td>
    				<td>
    					<s:a action="addFriend" namespace="/" onclick="return confirm('你确定要加为好友吗?');">添加好友
    						<s:param name="friendid"><s:property value="#user.id"/></s:param>
    						<s:param name="user.id"><s:property value="#session.user.id"/></s:param>
    					</s:a>
    				</td>
    			</tr>
    		</s:iterator>
    	</table>
    	<br/><br/>
    		第<s:property value="page.no"/>页/共<s:property value="page.count"/>页&nbsp;&nbsp;
    		<br/>
    	<s:a action="findAllUser" namespace="/">第一页
    		<s:param name="page.no">1</s:param>
    	</s:a>
    	<s:a action="findAllUser" namespace="/">上一页
    		<s:param name="page.no"><s:property value="page.no-1"/></s:param>
    	</s:a>
    	<s:a action="findAllUser" namespace="/">下一页
    		<s:param name="page.no"><s:property value="page.no+1"/></s:param>
    	</s:a>
    	<s:a action="findAllUser" namespace="/">最后一页
    		<s:param name="page.no"><s:property value="page.count"/></s:param>
    	</s:a>
    </s:if>
    <s:else>
    	暂无数据
    </s:else>
  </body>
</html>
