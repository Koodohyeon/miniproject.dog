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
              <img class="card-img-top" src="/jw/dog/img/foodlist/010.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
              <div class="card-body">
                <h4 class="card-title">상품 명: 강아지 사료 애견 반려견 그레인프리 전연령 7.5kg</h4>
                <p class="card-text">가격: 58,900원</p>
                <div>
                
                <a href="" class="btn btn-primary">구매하기</a>
                </div>
              </div>
            </div>

            <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/foodlist/011.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 강아지 진수성찬 어덜트 2kg 1P 반려견 건식 사료</h4>
                  <p class="card-text">가격: 13,900원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>

              <div class="card col ms-3" style="width:300px">
                <img class="card-img-top" src="/jw/dog/img/foodlist/012.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">상품 명: 강아지 슈퍼푸드 퍼피 1.5kg 1P 자견용 건식 사료</h4>
                  <p class="card-text">가격: 11,100원</p>
                  <div>
                  
                  <a href="#" class="btn btn-primary">구매하기</a>
                  </div>
                </div>
              </div>
            </div>

            <div class="mt-3 row">
                <div class="card col" style="width:300px">
                  <img class="card-img-top" src="/jw/dog/img/foodlist/013.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                  <div class="card-body">
                    <h4 class="card-title">상품 명: 강아지 슈퍼푸드 어덜트 1.5kg 1P 성견용 건식 사료</h4>
                    <p class="card-text">가격: 10,700원</p>
                    <div>
                    
                    <a href="#" class="btn btn-primary">구매하기</a>
                    </div>
                  </div>
                </div>
    
                <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/foodlist/014.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 풀무원 아미오 건강담은식단 체중케어 1kg</h4>
                      <p class="card-text">가격: 13,200원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
    
                  <div class="card col ms-3" style="width:300px">
                    <img class="card-img-top" src="/jw/dog/img/foodlist/015.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">상품 명: 뉴트리나 울트라 오리지널 전연령용 강아지 사료 15kg</h4>
                      <p class="card-text">가격: 67,000원</p>
                      <div>
                      
                      <a href="#" class="btn btn-primary">구매하기</a>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="mt-3 row">
                    <div class="card col" style="width:300px">
                      <img class="card-img-top" src="/jw/dog/img/foodlist/016.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                      <div class="card-body">
                        <h4 class="card-title">상품 명: 뉴트리나 울트라 액티브 전연령용 강아지 사료 15kg</h4>
                        <p class="card-text">가격: 51,300원</p>
                        <div>
                        
                        <a href="#" class="btn btn-primary">구매하기</a>
                        </div>
                      </div>
                    </div>
        
                    <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/foodlist/017.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 대형견사료 프로플랜 어덜트 큰알갱이 15.4kg 애견</h4>
                          <p class="card-text">가격: 223,400원</p>
                          <div>
                          
                          <a href="#" class="btn btn-primary">구매하기</a>
                          </div>
                        </div>
                      </div>
        
                      <div class="card col ms-3" style="width:300px">
                        <img class="card-img-top" src="/jw/dog/img/foodlist/018.jpg" class="rounded" alt="Cinque Terre" width="280" height="236" alt="Card image" style="width:100%">
                        <div class="card-body">
                          <h4 class="card-title">상품 명: 로얄캐닌 미니 인도어 어덜트 8.7kg 강아지 애견 사료</h4>
                          <p class="card-text">가격: 182,200원</p>
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
            <li class="page-item"><a class="page-link" href="/jw/dog/items/foodlist">1</a></li>
            <li class="page-item"><a class="page-link active" href="/jw/dog/items/foodlist2">2</a></li>
            <li class="page-item"><a class="page-link" href="/jw/dog/items/foodlist2">></a></li>
          </ul>
    </div>
	
	
	<%@ include file="../common/_bottom.jspf" %>
		</div>
	</div>
</body>
</html>