<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<aside>
    <div id="sidebar" class="nav-collapse ">
        <ul class="sidebar-menu" id="nav-accordion">
            <p class="centered"><a href="#"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
            <h5 class="centered"><a href="#"><spring:message code="view.menu.lblWebpage"></spring:message></a></h5>
            <li class="sub-menu">
                <a class="active" href="/films">
                    <i class="fa fa-desktop"></i>
                    <span><spring:message code="view.menu.lblHome"></spring:message></span>
                </a>
            </li>

            <li class="sub-menu">
                <a class="active" href="/films">
                    <i class="fa fa-book"></i>
                    <span><spring:message code="view.menu.lblAllFilms"></spring:message></span>
                </a>
            </li>

        </ul>
    </div>
</aside>
