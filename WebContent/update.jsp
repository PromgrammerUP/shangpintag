<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新资源页面</title>
</head>
<body>
	<font color="blue" size="8" face="黑体">更新资源</font>
	<hr color="red" size="5">
	<html:form action="/updatedo">
		<table>
			<tr><td>ID</td><td><html:text property="id" readonly="true" value="${dto.id }"></html:text></td></tr>
			<tr><td>书名</td><td><html:text property="name" value="${dto.name }"></html:text></td></tr>
			<tr><td>价格</td><td><html:text property="price" value="${dto.price }"></html:text></td></tr>
			<tr><td>上架时间</td><td><html:text property="inputDate" value="${dto.inputDate }"></html:text></td></tr>
			<tr>
			 	<td>类型</td>
			 	<td>
			 	<html:select property="leixingId" value="${dto.leixingId }">
			 		<logic:iterate id="leixingItem" name="allLx" scope="request">
			 		<html:option value="${leixingItem.leixingId }"><bean:write name="leixingItem" property="leixingName"/></html:option>
			 		</logic:iterate>
			 	</html:select>
			 	</td>
			 </tr>
			 <tr><td colspan="2" align="right"><html:submit>提交</html:submit></td></tr>
		</table>
	</html:form>
	
	
</body>
</html>