<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<div id="login-page">
  	<div class="container">
  	
     <div class="form-login">
       <h2 class="form-login-heading"><spring:message code="view.login.sign_in"/></h2>
       <div class="login-wrap">
       	   
       	   <form class="login_form" name='loginForm' action="<c:url value='../j_spring_security_check' />" method='POST'>
	           <input type="text" class="form-control" id="username" name="j_username" placeholder="Username">
	           <br>
	           <input type="password" id="password" name="j_password" class="form-control" placeholder="Password">
	           <br>
	           <button class="btn btn-theme btn-block" type="submit"><spring:message code="view.login.sign_in"/></button>
           </form>
           <hr>
				<form name='GoogleSocialloginForm' action="<c:url value='../auth/google' />" method='POST'>
               		<button class="btn btn-theme btn-block" type="submit"><spring:message code="view.login.sign_with_google"/></button>
               		<input type="hidden" name="scope" value="https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me https://www.googleapis.com/auth/tasks https://www-opensocial.googleusercontent.com/api/people https://www.googleapis.com/auth/plus.login" />
	            </form>
           <hr>
           <div class="registration"><spring:message code="view.login.miss_account"/><br/>
               <c:url value="../services/signup" var="signupurl" />
               <h4><a href="${signupurl}"> <spring:message code="view.login.sign_up"/></a></h4>
           </div>
        </div>
   	 </div>	  	
	
	</div>
</div>
