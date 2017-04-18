<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:if test="${!empty listFilmBeans}">
    <h4 style="color:midnightblue;">${message}</h4>
    <c:forEach var="film" items="${listFilmBeans}">
        <div class="row mt">
            <div class="col-md-12">
                <div class="content-panel" style="height: 300px">
                    <h3><i class="fa fa-angle-right"></i>
                        <span class="badge bg-info">${film.filmName}</span>
                    </h3>
                    <hr>
                    <div>
                        <div style="width: 20%; float: left">
                            <img src="${film.image}" style="padding-left: 20px" width="120px" height="140">
                        </div>
                        <div style="width: 80%; height: auto; float: right">
                            <div>
                                <h4 style="color:goldenrod">
                                    <spring:message code="view.films.lblRattingStar"></spring:message>
                                        ${film.cinemaName}
                                </h4>
                                <h4><spring:message code="view.films.lblRatting"></spring:message>${film.ratting}
                                    <span style="color: red">
                                        <spring:message code="view.films.lblRattingStar"></spring:message>
                                    </span>
                                </h4>
                                </br>
                                <ul class="top-menu">
                                    <c:forEach var="time" items="${film.schedules}" varStatus="i">
                                        <li style="padding-bottom: 10px"><a>${time}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>