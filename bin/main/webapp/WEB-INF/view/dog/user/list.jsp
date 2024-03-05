<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/dog/common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
	</style>
	<script>
		function deleteFunc(uId) {
			$('#deleteuId').val(uId);
			$('#deleteModal').modal('show');
		}
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/view/dog/common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<div class="col-9">
				<h3><strong class="me-5">사용자 목록</strong>
					<span style="font-size:16px"><a href="/jw/dog/user/register"><i class="fa-solid fa-user-plus"></i> 사용자 가입</a></span>
				</h3>
				<hr>
				<div class="row">
					<div class="col-1"></div>
					<div class="col-10">
						<table class="table">
							<tr><th>아이디</th><th>이름</th><th>이메일</th><th>등록일</th><th>액션</th></tr>
							<c:forEach var="user" items="${userList}">
							<tr>
								<td>${user.uId}</td>
								<td>${user.uname}</td>
								<td>${user.email}</td>
								<td>${user.regDate}</td>
								<td>
									<!-- 본인만 수정 가능 -->
									<c:if test="${user.uId eq sessUid}">	
										<a href="/jw/dog/user/update?uId=${user.uId}"><i class="fa-solid fa-user-pen"></i></a>
									</c:if>
									<c:if test="${user.uId ne sessUid}">
										<a href="#" class="disabled-link"><i class="fa-solid fa-user-pen"></i></a>
									</c:if>
									<!-- 본인 또는 관리자만 삭제 가능 -->
									<c:if test="${(user.uId eq sessUid) or (sessUid eq 'admin')}">
										<a class="ms-2" href="javascript:deleteFunc('${user.uId}')"><i class="fa-solid fa-user-minus"></i></a>
									</c:if>
									<c:if test="${(user.uId ne sessUid) and (sessUid ne 'admin')}">
										<a class="ms-2 disabled-link" href="#"><i class="fa-solid fa-user-minus"></i></a>
									</c:if>
								</td>
							</tr>
							</c:forEach>
						</table>
						<%-- pagination --%>
						<ul class="pagination justify-content-center mt-4">
							  <li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-less-than"></i></a></li>
							  <c:forEach var="page" items="${pageList}">
							  	<li class="page-item ${currentUserPage eq page ? 'active' : '' }">
							  		<a class="page-link" href="/jw/dog/user/list?page=${page}">${page}</a></li>	
							  </c:forEach>
								  <li class="page-item"><a class="page-link" href="#"><i class="fa-solid fa-greater-than"></i></a></li>
						</ul>
					</div>
					<div class="col-1"></div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/view/dog/common/_bottom.jspf" %>
	
	<div class="modal" id="deleteModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">사용자 탈퇴</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
			
				<!-- Modal body -->
				<div class="modal-body">
					<strong>정말로 탈퇴하시겠습니까?</strong>
					<div class="text-center mt-5">
						<form action="/jw/dog/user/delete" method="post">
							<input type="hidden" id="deleteuId" name="uId">
							<button class="btn btn-danger" type="submit">탈퇴</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>