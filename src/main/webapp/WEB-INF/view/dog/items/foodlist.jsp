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
                 <a href="/jw/dog/items/foodlist" class="text-white" style="text-decoration: none; border: 1px solid white; width: 50px; border-radius: 20px" >식품</a>
                 <a href="/jw/dog/items/itemlist" class="text-white" style="text-decoration: none;">애견 용품</a>
                 <a href="/jw/dog/items/otherlist" class="text-white" style="text-decoration: none;">기타</a>
             </li>
        </ul>
        </div>
    </div>
        <div class="container" style="margin-left: auto; ">
        <div class="mt-3 row ">
            <div class="card col" style="width:300px">
        	  <img class="card-img-top" src="/jw/dog/img/foodlist/001.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
              <div class="card-body">
                <h4 class="card-title">상품 명: 강아지캔 순살치킨새우맛 24EA 반려견 영양간식식품</h4>
                <p class="card-text">가격: 83,000원</p>
                <div>
                
                <a href="/jw/dog/items/payments" class="btn btn-primary">구매하기</a>
                </div>
              </div>
            </div>

            <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/foodlist/002.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 전영령 강아지전용 간식 양고기 치즈버거 100g 80EA</h4>
                  <p class="card-text">가격: 101,000원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>

              <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/foodlist/003.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: D17 뉴트리오 순살 닭고기캔 100g 24개</h4>
                  <p class="card-text">가격: 59,000원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>
            </div>

            <div class="mt-3 row">
                <div class="card col" style="width:300px">
                  <img class="card-img-top" src="/jw/dog/img/foodlist/004.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                  <div class="card-body">
                    <h4 class="card-title">상품 명: D17 굿프렌드 강아지캔 5종 24개</h4>
                    <p class="card-text">가격: 54,000원</p>
                    <div>
                    
                    <a href="#" class="btn btn-primary">구매하기</a>
                    </div>
                  </div>
                </div>
    
                <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/foodlist/005.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 반려동물 강아지 캔사료 간식 칠면조 오리 85g 15EA</h4>
                      <p class="card-text">가격: 44,000원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
    
                  <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/foodlist/006.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 애완견전용 캔간식 반려사료 오리 시금치 85g 15EA</h4>
                      <p class="card-text">가격: 44,000원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="mt-3 row">
                    <div class="card col" style="width:300px">
                      <img class="card-img-top" src="/jw/dog/img/foodlist/007.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                      <div class="card-body">
                        <h4 class="card-title">상품 명: 챱챱 짜먹는 강아지 츄르 닭고기연어 10개 추르</h4>
                        <p class="card-text">가격: 46,000원</p>
                        <div>
                        
                        <a href="#" class="btn btn-primary">구매하기</a>
                        </div>
                      </div>
                    </div>
        
                    <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/foodlist/008.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: D17 강아지캔 시저 쇠고기와닭고기 x24개</h4>
                          <p class="card-text">가격: 99,000원</p>
                          <div>
                          
                          <a href="#" class="btn btn-primary">구매하기</a>
                          </div>
                        </div>
                      </div>
        
                      <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/foodlist/009.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: D17 강아지캔 시저 쇠고기와참치 x24개</h4>
                          <p class="card-text">가격: 99,000원</p>
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
            <li class="page-item"><a class="page-link" href="/jw/dog/items/foodlist"><</a></li>
            <li class="page-item"><a class="page-link active" href="/jw/dog/items/foodlist">1</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/foodlist2">2</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/foodlist2">></a></li>
          </ul>
    </div>
	
	
	<%@ include file="../common/_bottom.jspf" %>
		</div>
	</div>
</body>
</html>