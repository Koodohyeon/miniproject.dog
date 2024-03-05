<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				<h3><strong>사진 수정</strong></h3>
				<hr>
				<div class="row">
					<div class="col-1"></div>
					<div class="col-8">
						<form action="/jw/dog/gallery/update?galleryId=${gallery.galleryId}&fName=${fNmae}" method="post" enctype="multipart/form-data">
							<input type="hidden" name="uId" value=${user.uId}>
							<input type="hidden" name="hashedPwd" value=${user.pwd}>
							<table class="table table-borderless">
								<tr>
									<td><label class="col-form-label me-5">강아지 사진</label></td>
									<td><input type="file" name="fName" placeholder="이미지 파일"></td>
								</tr>	
								<tr>
									<td><label class="col-form-label me-5">사진 제목</label></td>
									<td><input type="text" name="title" placeholder="${gallery.title}" style="width: 300px" disabled></td>
								</tr>					
							</table>
                            <div style="text-align: center;">
                                <button class="btn btn-primary" type="submit">등록</button>
                            </div>
						</form>
					</div>
					<div class="col-3"></div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>