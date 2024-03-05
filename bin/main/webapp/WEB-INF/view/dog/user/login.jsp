<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
  	<style>
    	td { text-align: center; }
	</style>
</head>
<body >
  <nav class="navbar navbar-expand-sm navbar-dark fixed-top" style="background-color: #1c3761">
    <div class="container-fluid">
      <a class="navbar-brand mx-5" href="/jw/dog/home"><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdakLyX%2FbtsFkVSo075%2FSLRDuGwH5lucF8kv9Z3z4K%2Fimg.png" height="36" width="80px"></a>
    </div>
  </nav>
  
  <div class="container" style="margin-top: 130px;">
    <div class="row">
      <div class="col-4"></div>
      <div class="col-4">
        <div class="card">
          <div class="card-body">
            <div class="card-title"><h3><strong>로그인</strong></h3></div>
            <hr>
            <form action="/jw/dog/user/login" method="post">
              <table class="table table-borderless">
                <tr>
                  <td style="width: 45%;"><label class="col-form-label">사용자 ID</label></td>
                  <td style="width: 55%;"><input type="text" name="uid" class="form-control"></td>
                </tr>
                <tr>
                  <td><label class="col-form-label">패스워드</label></td>
                  <td><input type="password" name="pwd" class="form-control"></td>
                </tr>
                <tr>
                  <td colspan="2">
                    <button class="btn btn-primary" type="submit">확인</button>
                    <button class="btn btn-secondary" type="reset">취소</button>
                  </td>
                </tr>
              </table>
            </form>
            <p class="mt-3">
              <span class="me-3">사용자 계정이 없으신가요?</span>
              <a href="/jw/dog/user/register">사용자 가입</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-4"></div>
    </div>
  </div>
  
  <%@ include file="../common/_bottom.jspf" %>
</body>
</html>