<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/main.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
function displayField(){
	if(document.getElementById('role').value == 1){
		$('#specialty').show();
		$('#expirence').show();
	} else {
		$('#specialty').hide();
		$('#expirence').hide();
	}
}
</script>