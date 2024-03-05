<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
			<div class="col-10">
			<div>	<h3 style="display: inline-block"><strong>사용자 수정</strong></h3><h3 style="display: inline-block; margin-left:400px"><strong>사용자 정보</strong></h3>  </div>
				<hr>
				<div class="row">
					<div class="col-1"></div>
					<div class="col-4">
						<form action="/jw/dog/user/update?uId=${user.uId}" method="post">
							<input type="hidden" name="uId" value=${user.uId}>
							<input type="hidden" name="hashedPwd" value=${user.pwd}>
							<table class="table table-borderless">
								<tr>
									<td style="width: 40%;"><label class="col-form-label">사용자 ID</label></td>
									<td style="width: 60%;"><input type="text" class="form-control" value="${user.uId}" disabled></td>
								</tr>
								<tr>
									<td><label class="col-form-label">패스워드</label></td>
									<td><input type="password" name="pwd" class="form-control"></td>
								</tr>
								<tr>
									<td><label class="col-form-label">패스워드 확인</label></td>
									<td><input type="password" name="pwd2" class="form-control"></td>
								</tr>
								<tr>
									<td><label class="col-form-label">사용자 이름</label></td>
									<td><input type="text" name="uname" class="form-control" value=${user.uname}></td>
								</tr>
								<tr>
									<td><label class="col-form-label">이메일</label></td>
									<td><input type="text" name="email" class="form-control" value=${user.email}></td>
								</tr>
								<tr>
									<td colspan="2">
										<button class="btn btn-primary" type="submit">확인</button>
										<button class="btn btn-secondary" type="reset">취소</button>
									</td>
								</tr>							
							</table>
						</form>
					</div>
					<div class="col-1"></div>
					<div class="col-4">
						<form action="/jw/dog/user/update" method="post">
							<input type="hidden" name="uId" value=${user.uId}>
							<input type="hidden" name="hashedPwd" value=${user.pwd}>
							<table class="table table-borderless">
								<tr>
									<td style="width: 40%;"><label class="col-form-label">사용자 ID</label></td>
									<td style="width: 60%;"><p style=" height: 35px; width: 200px; border: 1px solid gray; border-radius: 20px" >${sessUid}</p></td>
								</tr>
								
								<tr>
									<td><label class="col-form-label">사용자 이름</label></td>
									<td><p style=" height: 35px; width: 200px; border: 1px solid gray; border-radius: 20px" >${sessUname}</p> </td>
								</tr>
								<tr>
									<td><label class="col-form-label">이메일</label></td>
									<td><p style=" height: 35px; width: 200px; border: 1px solid gray; border-radius: 20px" >${sessEmail}</p> </td>
								</tr>	
								<tr>
									<td><label class="col-form-label">회원가입 날짜 </label></td>
									<td><p style=" height: 35px; width: 200px; border: 1px solid gray; border-radius: 20px" >${sessRegDate}</p> </td>
								</tr>						
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>