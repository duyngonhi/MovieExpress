<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="col-lg-9 ">
	<div class="col-md-12">
		<div class="col-md-3 col-sm-6 col-xs-12"></div>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<p id="msg_success" style="color: green"></p>
			<p id="msg_error" style="color: red"></p>
		</div>
		<div class="col-md-3 col-sm-6 col-xs-12"></div>
	</div>

	<div class="col-md-12">
		<div class="bootstrap-iso">
			<div class="container-fluid">
				<div class="row">
					<form:form class="form-horizontal" id="formSearch"
							   action="${pageContext.request.contextPath}/" method="POST">
						<div class="col-md-6 col-sm-6 col-xs-12">
							<br/>
							<div class="form-group ">
								<label class="control-label col-sm-4 requiredField">
									City
									<span class="asteriskField">*</span>
								</label>
								<div class="col-sm-8">
									<select class="form-control" path="cityName" name="cityName" id="cityName">
										<c:forEach items="${listCities}" var="city">
											<option value="${city.nameCity}">${city.nameCity}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-4"></div>
							</div>
						</div>

						<div class="col-md-6 col-sm-6 col-xs-12">
							<br/>
							<div class="form-group">
								<label class="control-label col-sm-4 requiredField">
								</label>
								<div class="col-sm-8">
									<div class="col-sm-6 col-xs-6 ">
										<a class="btn btn-success " style="color: #efeaee" id="btnCloneData">
											<spring:message code="view.index.label.btnCloneData"></spring:message>
										</a>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
