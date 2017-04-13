<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-lg-9 main-chart">
    <div class="bootstrap-iso">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-10 col-sm-10 col-xs-12">
                    <ul style="background: red; height: 30px; width: 100%">
                        <li style=" float: left; margin-left: 20px; color: whitesmoke; width: auto">
                            <input id="filmHanoi" type="hidden" value="ha-noi">
                            <a id="film_tpHanoi" style="color: whitesmoke">
                                <spring:message code="view.films.tpHanoi"></spring:message></a>
                        </li>
                        <li style=" float: left; margin-left: 20px; color: whitesmoke; width: auto">
                            <a id="film_tpHochiminh" style="color: whitesmoke">
                                <spring:message code="view.films.tpHochiminh"></spring:message>
                            </a>
                            <input id="filmHochiminh" type="hidden" value="ho-chi-minh">
                        </li>
                        <li style=" float: left; margin-left: 20px; color: whitesmoke; width: auto">
                            <a id="film_tpHaiphong" style="color: whitesmoke">
                                <spring:message code="view.films.tpHaiphong"></spring:message>
                            </a>
                            <input id="filmHaiphong" type="hidden" value="hai-phong">
                        </li>
                        <li style=" float: left; margin-left: 20px; color: whitesmoke; width: auto">
                            <a id="film_tpDanang" style="color: whitesmoke">
                                <spring:message code="view.films.tpDanang"></spring:message>
                            </a>
                            <input id="filmDanang" type="hidden" value="da-nang">
                        </li>
                        <li style=" float: left; margin-left: 20px; color: whitesmoke; width: auto">
                            <a id="film_tpNhatrang" style="color: whitesmoke">
                                <spring:message code="view.films.tpNhatrang"></spring:message>
                            </a>
                            <input id="filmNhatrang" type="hidden" value="nha-trang">
                        </li>
                        <li style=" float: left; margin-left: 20px; color: whitesmoke; width: auto">
                            <a id="film_tpDongnai" style="color: whitesmoke">
                                <spring:message code="view.films.tpDongnai"></spring:message>
                            </a>
                            <input id="filmDongnai" type="hidden" value="dong-nai">
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div id="listFilms">
        <c:if test="${!empty listFilmBeans}">
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
                                                <li style="margin-bottom: 10px"><a>${time}</a></li>
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
    </div>
</div>
