<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@ include file="/back-end/back-template/backIndex.file"%>
<html>
<head>
<title>act comment selectPage</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/back-end/actorder.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	
</script>
<head>
<title>活動訂單管理</title>
</head>
<body>


<div id="container">
		<div id="error">
			<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
		
		</div>



		<input class="title" id="tab-1" type="radio" name="tab-group" checked="true"/> 
		<label for="tab-1">查看所有活動訂單</label> 
		<input class="title" id="tab-2" type="radio" name="tab-group" /> 
		<label for="tab-2">查看當前活動訂單</label> 
		<input class="title" id="tab-3"	type="radio" name="tab-group" /> 
		<label for="tab-3">查看過往活動訂單</label> 
		<input class="title" id="tab-4"	type="radio" name="tab-group" /> 
		<label for="tab-4">以條件查詢訂單</label> 
		<input class="title" id="tab-5"	type="radio" name="tab-group" />
		<label for="tab-5">新增活動訂單</label> 
		

		

		<div id="content">
			<jsp:include page="/back-end/actOrder/listAllActOrder.jsp" />
			<jsp:include page="/back-end/actOrder/listNowActOrder.jsp" />
			<jsp:include page="/back-end/actOrder/listBeforeActOrder.jsp" />
			<jsp:include page="/back-end/actOrder/selectQuery.jsp" />
			<jsp:include page="/back-end/actOrder/addActOrder.jsp" />
		</div>
</div>


		<%@ include file="/back-end/back-template/backIndex2.file"%>

</body>
</html>