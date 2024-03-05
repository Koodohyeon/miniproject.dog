<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% int a = 83000;
	%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		td { text-align: center; }
	</style>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-8">
				<h3><strong>결제 화면</strong></h3>
				<hr>
						<form action="/jw/dog/items/foodlist" >
							<input type="hidden" name="uId" value=${user.uId}>
							<input type="hidden" name="hashedPwd" value=${user.pwd}>
							<table class="table table-borderless">
								<tr>
									<td style="width: 40%;"><label class="col-form-label">상품사진 </label></td>
									<td style="width: 60%;">
										<img style=" width:200px; height:100px"src="/jw/dog/img/foodlist/001.jpg">
									</td>
								</tr>
								<tr>
									<td><label class="col-form-label">상품명 </label></td>
									<td> 강아지캔 순살치킨새우맛 24EA 반려견 영양간식식품 </td>
								</tr>
								<tr>
									<td><label class="col-form-label">상품 가격</label></td>
									<td><%=  a  %></td>
								</tr>
								<tr>
									<td><label class="col-form-label">내 잔여 포인트</label></td>
									<td>${sessBalance}</td>
								</tr>
								<tr>
									<td><label class="col-form-label">결제 금액</label></td>
									<td><%
										    int result = a - (int)session.getAttribute("sessBalance");
										    out.println(result);
										%> </td>
								</tr>
								<tr>
									<td colspan="2">
										<a href="/jw/dog/items/foodlist"><button class="btn btn-primary me-3" type="submit">결제하기</button></a>
										<button class="btn btn-secondary ms-3 type="reset">취소하기</button>
									</td>
								</tr>							
							</table>
						</form>
					</div>
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>