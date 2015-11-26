<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page session="true"%>
<html>
<head><title>${title}</title></head>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/main.css">
<body>
   <h2>Message : ${message}</h2>
 
   <c:if test="${pageContext.request.userPrincipal.name != null}">
      <h3>Welcome : ${pageContext.request.userPrincipal.name}
          | <a href="<c:url value="/logout" />" >Logout</a></h3>  
   </c:if>  
<c:url var="addAction" value="/admin/user/add" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>
	<c:if test="${!empty user.fullname}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	
	<tr>
		<td>
			<form:label path="role">
				<spring:message text="role"/>
			</form:label>
		</td>
		<td>
			<form:select path="role" cssClass="form-control" required="true">
		        <form:option value="">--Select--</form:option>
		        <form:options items="${userRoles}" itemLabel="code" itemValue="id" />
		    </form:select>
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="fullname">
				<spring:message text="Full Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="fullname" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="specialty">
				<spring:message text="specialty"/>
			</form:label>
		</td>
		<td>
			<form:input path="specialty" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="age">
				<spring:message text="age"/>
			</form:label>
		</td>
		<td>
			<form:input path="age" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="expirence">
				<spring:message text="expirence"/>
			</form:label>
		</td>
		<td>
			<form:input path="expirence" />
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="contact">
				<spring:message text="contact"/>
			</form:label>
		</td>
		<td>
			<form:input path="contact" />
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="username">
				<spring:message text="username"/>
			</form:label>
		</td>
		<td>
			<form:input path="username" />
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="enabled">
				<spring:message text="enabled"/>
			</form:label>
		</td>
		<td>
			<form:select path="enabled" cssClass="form-control" required="true">
		        <form:option value="">--Select--</form:option>
		        <form:options items="${status}" itemLabel="label" itemValue="code" />
		    </form:select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.fullname}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty user.fullname}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>User List</h3>
<c:if test="${!empty list}">
	<table class="tg">
	<tr>
		<th width="7">User ID</th>
		<th width="7">User Full Name</th>
		<th width="7">Specialty</th>
		<th width="7">Age</th> 
		<th width="7">Expirence</th> 
		<th width="7">Email</th> 
		<th width="7">Contact </th> 
		<th width="7">Username</th> 
		<th width="7">Password</th> 
		<th width="7">Role </th> 
		<th width="7">Enabled</th>
		<th width="7">Edit</th>
		<th width="7">Delete</th>
	</tr>
	<c:forEach items="${list}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.fullname}</td>
			<td>${user.specialty}</td>
			<td>${user.age}</td>
			<td>${user.expirence}</td>
			<td>${user.email}</td>
			<td>${user.contact}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.role}</td>
			<td>${user.enabled}</td>
			<td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
   