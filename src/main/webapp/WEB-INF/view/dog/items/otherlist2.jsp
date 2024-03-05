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
                 <a href="/jw/dog/items/itemlist" class="text-white" style="text-decoration: none; ">애견 용품</a>
                 <a href="/jw/dog/items/otherlist" class="text-white" style="text-decoration: none; border: 1px solid white; width: 50px; border-radius: 20px">기타</a>
             </li>
        </ul>
        </div>
    </div>
        <div class="container" style="margin-left: auto; ">
        <div class="mt-3 row ">
            <div class="card col" style="width:300px">
              <img class="card-img-top" src="/jw/dog/img/otherlist/049.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
              <div class="card-body">
                <h4 class="card-title">상품 명: 브라더캣도그 대형견 비옷 반려견 우비 레인코트</h4>
                <p class="card-text">가격: 116,000원</p>
                <div>
                
                <a href="" class="btn btn-primary">구매하기</a>
                </div>
              </div>
            </div>

            <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/otherlist/050.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: D17 패리스독 베어 하네스 패딩세트 모자포함 2XL</h4>
                  <p class="card-text">가격: 42,000원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>

              <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/otherlist/051.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 강아지 굿스 롱패딩 차콜 2XL 1P 반려견 겨울 점퍼</h4>
                  <p class="card-text">가격: 40,000원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>
            </div>

            <div class="mt-3 row">
                <div class="card col" style="width:300px">
                  <img class="card-img-top" src="/jw/dog/img/otherlist/052.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                  <div class="card-body">
                    <h4 class="card-title">상품 명: 올인원 애견옷 S 에메랄드 별나라</h4>
                    <p class="card-text">가격: 12,900원</p>
                    <div>
                    
                    <a href="#" class="btn btn-primary">구매하기</a>
                    </div>
                  </div>
                </div>
    
                <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/otherlist/053.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 강아지 일회용 부직포 신발 산책 애견 붕대 슈즈 8P</h4>
                      <p class="card-text">가격: 4,800원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
    
                  <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/otherlist/054.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: (도그차일드) 캔버스 슈즈_블루 (사이즈 선택)</h4>
                      <p class="card-text">가격: 30,800원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="mt-3 row">
                    <div class="card col" style="width:300px">
                      <img class="card-img-top" src="/jw/dog/img/otherlist/055.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                      <div class="card-body">
                        <h4 class="card-title">상품 명: 푸르미 강아지 귀저기 애견 배변 패드 중형 10매</h4>
                        <p class="card-text">가격: 6,300원</p>
                        <div>
                        
                        <a href="#" class="btn btn-primary">구매하기</a>
                        </div>
                      </div>
                    </div>
        
                    <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/otherlist/056.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 아몬스 강아지 귀저기 애견패드 수컷기저귀 중형 10매</h4>
                          <p class="card-text">가격: 5,900원</p>
                          <div>
                          
                          <a href="#" class="btn btn-primary">구매하기</a>
                          </div>
                        </div>
                      </div>
        
                      <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/otherlist/057.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 테비 강아지 귀저기 팬티 애견 배변 패드 라이트400매</h4>
                          <p class="card-text">가격: 50,700원</p>
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
            <li class="page-item"><a class="page-link" href="/jw/dog/items/otherlist"><</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/otherlist">1</a></li>
            <li class="page-item"><a class="page-link active" href="/jw/dog/items/otherlist2">2</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/otherlist2">></a></li>
          </ul>
    </div>
	
	
	<%@ include file="../common/_bottom.jspf" %>
		</div>
	</div>
</body>
</html>