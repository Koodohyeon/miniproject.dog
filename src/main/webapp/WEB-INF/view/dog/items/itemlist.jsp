<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		.page-link.active {
			font-weight: bold;
		}
	</style>
</head>
<body style="height:1800px">
	<%@ include file="../common/_top.jspf" %>
	
	    <div style="margin-top: 100px; align-items: center;">
        <div style="background-color: #1c3761; height: 100px; padding: 10px; width: 800px; display: block; text-align: center; margin: 0 auto;" class="text-white">
		<h3> < 상품 페이지 ></h3>
        <ul style="list-style: none; padding: 0; margin: 0%;">
             <li class="justify-content-around d-flex " style="display: inline-block; font-size: large; ">
                 <a href="/jw/dog/items/foodlist" class="text-white" style="text-decoration: none;" >식품</a>
                 <a href="/jw/dog/items/itemlist" class="text-white" style="text-decoration: none; border: 1px solid white; width: 100px; border-radius: 20px">애견 용품</a>
                 <a href="/jw/dog/items/otherlist" class="text-white" style="text-decoration: none;">기타</a>
             </li>
        </ul>
        </div>
    </div>
        <div class="container" style="margin-left: auto; ">
        <div class="mt-3 row ">
            <div class="card col" style="width:300px">
              <img class="card-img-top" src="/jw/dog/img/itemlist/021.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
              <div class="card-body">
                <h4 class="card-title">상품 명: 버츠비 이치수딩 강아지 대형견 샴푸 16oz 애완용</h4>
                <p class="card-text">가격: 31000원</p>
                <div>
                
                <a href="" class="btn btn-primary">구매하기</a>
                </div>
              </div>
            </div>

            <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/itemlist/022.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 버츠비 퍼피 어린강아지 샴푸n컨디셔너 16oz 멍멍이</h4>
                  <p class="card-text">가격: 31,000원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>

              <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/itemlist/023.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: D17 뉴 브리더 화이트 샴푸 1000ml (구.말티즈샴푸)</h4>
                  <p class="card-text">가격: 24,000원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>
            </div>

            <div class="mt-3 row">
                <div class="card col" style="width:300px">
                  <img class="card-img-top" src="/jw/dog/img/itemlist/024.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                  <div class="card-body">
                    <h4 class="card-title">상품 명: 애완견 손톱 깎기 커터 손질 가위 동물가위 발톱 미용</h4>
                    <p class="card-text">가격: 934,000원</p>
                    <div>
                    
                    <a href="#" class="btn btn-primary">구매하기</a>
                    </div>
                  </div>
                </div>
    
                <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/itemlist/025.jpg"class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 애견 발톱깎이(고급형)레드 반려동물 미용 발톱발관리</h4>
                      <p class="card-text">가격: 16,100원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
    
                  <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/itemlist/026.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: (펫코코)애견발 세척기</h4>
                      <p class="card-text">가격: 66,000원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="mt-3 row">
                    <div class="card col" style="width:300px">
                      <img class="card-img-top" src="/jw/dog/img/itemlist/027.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                      <div class="card-body">
                        <h4 class="card-title">상품 명: 하성 사각빗 독일제 브러쉬 애견 강아지 반려견</h4>
                        <p class="card-text">가격: 24,900원</p>
                        <div>
                        
                        <a href="#" class="btn btn-primary">구매하기</a>
                        </div>
                      </div>
                    </div>
        
                    <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/itemlist/028.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 리케이 볼 슬리커 L</h4>
                          <p class="card-text">가격: 20,800원</p>
                          <div>
                          
                          <a href="#" class="btn btn-primary">구매하기</a>
                          </div>
                        </div>
                      </div>
        
                      <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/itemlist/029.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 리케이 페이셜콤</h4>
                          <p class="card-text">가격: 26,000원</p>
                          <div>
                          
                          <a href="#" class="btn btn-primary">구매하기</a>
                          </div>
                        </div>
                      </div>
                    </div>
                </div>
    </div>

    <div class="container mt-5">
        <ul class="pagination justify-content-center">
            <li class="page-item"><a class="page-link" href="/jw/dog/items/itemlist"> < </a></li>
            <li class="page-item"><a class="page-link active" href="/jw/dog/items/itemlist">1</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/itemlist2">2</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/itemlist2">></a></li>
          </ul>
    </div>
	
	
	<%@ include file="../common/_bottom.jspf" %>
		</div>
	</div>
</body>
</html>