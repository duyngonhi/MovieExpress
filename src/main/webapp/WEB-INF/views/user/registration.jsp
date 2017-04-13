<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   

<div id="registrationForm" style=" margin-top: 5%;">
<table class="container" border="0" cellspacing="10" cellpadding="3">
	<tr><td></td><td><div id="result" style="color: #ff0000"></div></td></tr>
	<tr>
		<th><spring:message code="view.user.user_id"/></th>
		<td><input class="form-control" type="text" id="userId" name="userId"
			placeholder="UserId" /></td>
	</tr>
	<tr>
		<th><spring:message code="view.user.email"/></th>
		<td><input class="form-control" type="text" id="email" name="email"
			placeholder="EmailId" /></td>
	</tr>
	<tr>
		<th><spring:message code="view.user.firstname"/></th>
		<td><input class="form-control" type="text" id="fullName" name="fullName"
			placeholder="Full Name" /></td>
	</tr>
	<tr>
		<th><spring:message code="view.user.pass"/></th>
		<td><input class="form-control" type="password" id="password" name="password"
			placeholder="Password" /></td>
	</tr>
	<tr>
		<th><spring:message code="view.user.confirmpass"/></th>
		<td><input class="form-control" type="password" id="confirmpassword"
			name="confirmpassword" placeholder="Confirm Password" /></td>
	</tr>
	<tr>
		<th><input class="form-control" type="hidden" id="socialProvider" name="socialProvider" value="NONE" /></th>
	</tr>
</table>
	<button id="btnRegisterUser" type="button" id="doRegister" onclick="proceed()"><spring:message code="view.user.sbmit"/></button>
</div>


<script>
function proceed() {

	var userIdVar = $("#registrationForm #userId").val();
	var emailVar = $("#registrationForm #email").val();
	var fullNameVar = $("#registrationForm #fullName").val();
	var phonenoVar = $("#registrationForm #phoneno").val();
	var passwordVar = $("#registrationForm #password").val();
	var conformPasswordVar = $("#registrationForm #confirmpassword").val();
	if (!userIdVar) {
		$('#result').html('<spring:message code="view.register.emptyUserId"/>');
	} else if (!emailVar) {
		$('#result').html('<spring:message code="view.register.emptyEmail"/>');
	} else if (!fullNameVar) {
		$('#result').html('<spring:message code="view.register.emptyFullName"/>');
	} else if (!passwordVar || !conformPasswordVar) {
		$('#result').html('<spring:message code="view.register.emptyPass"/>');
	} else if (passwordVar !== conformPasswordVar) {
		$('#result').html('<spring:message code="view.register.emptyConfirmPass"/>');
	} else {
		var person = {
			userId : userIdVar,
			email : emailVar,
			fullName : fullNameVar,
			password : passwordVar,
			socialProvider : $("#registrationForm #socialProvider").val()
		}
		console.log('--------ttt-------')
		$.ajax({
			type : "post",
			url : '../services/user/register',
			dataType:'json',
			data : JSON.stringify(person),
			contentType : "application/json",
			error: function(data){
				console.log(data);
				if (data.responseText == "success") {
					$('#result').html('<spring:message code="view.register.successRegister"/>');
				} else {
					$('#result').html('<spring:message code="view.register.failedRegister"/>');
				}
			}

		});

	}
}
</script>
