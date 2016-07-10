<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源列表页面</title>
</head>
<body>
	<font color="blue" size="8" face="黑体">资源列表</font>
	<hr color="red" size="5">
	<logic:notEmpty name="isSuccess">
		<logic:equal value="true" name="isSuccess">
			<font color="green" size="6" face="华文行楷">添加成功</font>
		</logic:equal>
		<logic:equal value="false" name="isSuccess">
			<font color="green" size="6" face="华文行楷">添加失败</font>
		</logic:equal>
	</logic:notEmpty>
	<logic:present name="msg">
		<bean:write name="msg"/>
	</logic:present>
	<bean:define id="all" name="list" type="java.util.ArrayList" scope="request"></bean:define>
	<table width="80%" cellpadding="5" cellspacing="0" border="1" bordercolor="blue">
		<tr>
			<th>ID</th><th>NAME</th><th>PRICE</th><th>INPUTDATE</th><th>LEIXINGID</th><th>LXNAME</th><th>OPTION</th>
		</tr>
		<%
		//<logic:iterate id="sp"collection="<%=request.getAttribute("list") type="org.javachina.shangpin.dto.ShangpinDto">
		%>
		<logic:iterate id="sp" name="all" type="org.javachina.shangpin.dto.ShangpinDto">
			<tr>
				<td><bean:write name="sp" property="id" format="#"/></td>
				<td><bean:write name="sp" property="name"/></td>
				<td><bean:write name="sp" property="price" format="#.00"/></td>
				<td><bean:write name="sp" property="inputDate" format="yyyy-MM-dd"/></td>
				<td><bean:write name="sp" property="leixingId" format="#"/></td>
				<td><bean:write name="sp" property="leixingName"/></td>
				<td><html:link action="update.do?id=${sp.id}">更新</html:link></td>
			</tr>
		</logic:iterate>
	</table>
	
	<html:link action="/add">增加资源</html:link>
</body>
</html>