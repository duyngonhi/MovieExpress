<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="col-lg-9 main-chart">
<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <h4> Choose File: <span class="badge bg-info"></span></h4>
   	  	  <hr>
   	  	  <form:form id="formsubmit" action="uploadMultiFile" method="post" enctype="multipart/form-data">
          <table class="table table-striped table-advance table-hover">
              <tbody>
              <tr>
				  <td><input type="file" id="myFile" multiple size="50" name="file" ></td>	
                  <td><p id="countFile"><spring:message code="view.upload.select_file"/></p></td>
				  <td><a id="btnupload" class="btn btn-success btn-sm pull-left"><spring:message code="view.upload.submit"/></a></td>	
              </tr>
              <tr style="color: red;">
              	<c:if test="${!empty message_save}">
              		<td><c:out value="${message_save}"/></td>
              	</c:if>
              	<c:if test="${!empty message}">
              		<td><c:out value="${message}"/></td>
              	</c:if>
              </tr>
              </tbody>
          </table>	
          </form:form>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->

<div class="row mt">
   <div class="col-md-12">
       <div class="content-panel">
   	  	  <form:form action="payment" method="post">
          <table class="table table-striped table-advance table-hover">
              <tbody>
              <tr>
                  <td><strong><spring:message code="view.upload.file_name"/></strong></td>
                  <td><strong><spring:message code="view.upload.bucket_name"/></strong></td>
                  <td><strong><spring:message code="view.upload.description"/></strong></td>
                  <td><strong><spring:message code="view.upload.status"/></strong></td>
                  <td></td>
                  <td></td>
              </tr>
              <c:if test="${!empty lstFile}">
              		<c:forEach items="${lstFile}" var="file">
              			<tr>
		                  <td><c:out value="${file.nameFile}"/></td>
		                  <td><spring:message code="bucketname"/></td>
		                  <td><c:out value="${file.description}"/></td>
		                  <c:if test="${file.status == 'S3'}">
		                  	<td><span class="badge bg-success"><i class="fa fa-check"></i></span></td>
						  	<td><a href="download/${file.id}" class="btn btn-success btn-sm pull-left"><spring:message code="view.upload.load_file"/></a></td>	
		                  </c:if>
		                  <c:if test="${file.status != 'S3'}">
		                  	<td><span class="badge bg-important">No</span></td>
		                  	<td><a id="btnloadfile" class="btn btn-success btn-sm pull-left"><spring:message code="view.upload.up_file"/></a></td>
		                  </c:if>
		              	</tr>
              		</c:forEach>
              </c:if>
              </tbody>
          </table>
          </form:form>
       </div><!-- /content-panel -->
	</div><!-- /col-md-12 -->
</div><!-- /row -->

</div>

<script>
$('#myFile').bind('change', function () {
	var txt = "";
    if (typeof($("#myFile")[0].files) != "undefined") {
        if ($("#myFile")[0].files.length == 0) {
        	txt = '<spring:message code="view.upload.select_file"/>';
        } else {
            for (var i = 0; i < $("#myFile")[0].files.length; i++) {
                txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                var file = $("#myFile")[0].files[i];
                if ('name' in file) {
                    txt += "name: " + file.name + "<br>";
                }
                if ('size' in file) {
                    txt += "size: " + file.size + " bytes <br>";
                }
            }
        }
    	$("#countFile").html(txt);
    } 
});

$("#btnupload").on("click",function(){
	$("#formsubmit").submit();
});
</script>
