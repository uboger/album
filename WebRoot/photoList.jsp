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
    <h6><s:property value="folder.foldername"/></h6>
    	<s:if test="page.results.size()!=0">
    		<s:iterator value="page.results" var="photo">
    			<table frame="border" style="display:inline-block;float:float">
    				<tr><td colspan="2"> 
    					<img alt=<s:property value="#photo.photoname"/> src=<s:property value="%{#photo.photopath}"/> width="150" height="150" />
    				</td></tr>
    				<tr>
    					<td>
    					<s:a action="scanPhoto" namespace="/">查看大图
    						<s:param name="photo.id"><s:property value="#photo.id"/></s:param>
    						<s:param name="type">0</s:param>
    					</s:a>
    					</td>
    					<td>
    					<s:a action="deletePhoto" namespace="/" onclick="return confirm('确定要删除吗?');">删除图片
    						<s:param name="photo.id"><s:property value="#photo.id"/></s:param>
    						<s:param name="folder.id"><s:property value="folder.id"/></s:param>
    						<s:param name="folder.foldername"><s:property value="folder.foldername"/></s:param>
    					</s:a>
    					</td>
    				</tr>
    			</table>
    		</s:iterator>
    	<br/><br/><br/>
    	第<s:property value="page.no"/>页/共<s:property value="page.count"/>页&nbsp;&nbsp;
    	<s:a action="scanFoler" namespace="/">第一页
    		<s:param name="folder.id"><s:property value="folder.id"/></s:param>
    		<s:param name="page.no">1</s:param>
    	</s:a>
    	<s:a action="scanFoler" namespace="/">上一页
    		<s:param name="folder.id"><s:property value="folder.id"/></s:param>
    		<s:param name="page.no"><s:property value="page.no-1"/></s:param>
    	</s:a>
    	<s:a action="scanFoler" namespace="/">下一页
    		<s:param name="folder.id"><s:property value="folder.id"/></s:param>
    		<s:param name="page.no"><s:property value="page.no+1"/></s:param>
    	</s:a>
    	<s:a action="scanFoler" namespace="/">最后一页
    		<s:param name="folder.id"><s:property value="folder.id"/></s:param>
    		<s:param name="page.no"><s:property value="page.count"/></s:param>
    	</s:a>
    	</s:if>
    	<s:else>
    			还没有照片
    	</s:else>
  </body>
</html>
