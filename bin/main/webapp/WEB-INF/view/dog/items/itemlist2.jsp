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
                 <a href="/jw/dog/items/itemlist" class="text-white" style="text-decoration: none; border: 1px solid white; width: 50px; border-radius: 20px">애견 용품</a>
                 <a href="/jw/dog/items/otherlist" class="text-white" style="text-decoration: none;">기타</a>
             </li>
        </ul>
        </div>
    </div>
        <div class="container" style="margin-left: auto; ">
        <div class="mt-3 row ">
            <div class="card col" style="width:300px">
              <img class="card-img-top" src="/jw/dog/img/itemlist/030.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
              <div class="card-body">
                <h4 class="card-title">상품 명: 리케이 파인콤 L</h4>
                <p class="card-text">가격: 65,000원</p>
                <div>
                
                <a href="" class="btn btn-primary">구매하기</a>
                </div>
              </div>
            </div>

            <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/itemlist/031.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 애견 원터치 슬리커 브러쉬(브러시)원터치 클리닝</h4>
                  <p class="card-text">가격: 22,700원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>

              <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/itemlist/032.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 강아지 LED 방울 팬던트 그린 1P 야간 산책 플래시</h4>
                  <p class="card-text">가격: 3,600원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>
            </div>

            <div class="mt-3 row">
                <div class="card col" style="width:300px">
                  <img class="card-img-top" src="/jw/dog/img/itemlist/033.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                  <div class="card-body">
                    <h4 class="card-title">상품 명: 애완견 손톱 깎기 커터 손질 가위 동물가위 발톱 미용고급 가죽 개목걸이 67 x 3.0cm 애견목줄 애완용품</h4>
                    <p class="card-text">가격: 29,000원</p>
                    <div>
                    
                    <a href="#" class="btn btn-primary">구매하기</a>
                    </div>
                  </div>
                </div>
    
                <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/itemlist/034.jpg"class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: PP 밸트 개목줄 50mm 70cm 빨강 강아지 목줄 대형견</h4>
                      <p class="card-text">가격: 18,800원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
    
                  <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/itemlist/035.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 강아지 안전벨트 헤드레스트형 차량용 목줄 DD-12599</h4>
                      <p class="card-text">가격: 4,400원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="mt-3 row">
                    <div class="card col" style="width:300px">
                      <img class="card-img-top" src="/jw/dog/img/itemlist/036.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                      <div class="card-body">
                        <h4 class="card-title">상품 명: 차량용 강아지 목줄 헤드레스트형 안전벨트 M12599</h4>
                        <p class="card-text">가격: 4,800원</p>
                        <div>
                        
                        <a href="#" class="btn btn-primary">구매하기</a>
                        </div>
                      </div>
                    </div>
        
                    <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/itemlist/037.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 애견용 앞섬방지 소형견 중소형견 가슴줄 하네스</h4>
                          <p class="card-text">가격: 28,000원</p>
                          <div>
                          
                          <a href="#" class="btn btn-primary">구매하기</a>
                          </div>
                        </div>
                      </div>
        
                      <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/itemlist/038.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 펫앤드림 대형견 (가슴줄) 세트 25mm (밀리터리)</h4>
                          <p class="card-text">가격: 19,600원</p>
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
            <li class="page-item"><a class="page-link" href="/jw/dog/items/itemlist"><</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/itemlist">1</a></li>
            <li class="page-item"><a class="page-link active" href="/jw/dog/items/itemlist2">2</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/itemlist2">></a></li>
          </ul>
    </div>
	
	
	<%@ include file="../common/_bottom.jspf" %>
		</div>
	</div>
</body>
</html>