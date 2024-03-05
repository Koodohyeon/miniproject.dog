<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newline", "\n"); %>

<!DOCTYPE html>
<html>
<head>
   <%@ include file="../common/_head.jspf" %>
   <style>
      td, th { text-align: center; }
   </style>
   <script>
       function deleteFunc(boardId) {
          //console.log(boardId);
         $('#deleteBoardId').val(boardId);
         $('#deleteModal').modal('show');
      }
   </script>
   

</head>
<body>
   <%@ include file="../common/_top.jspf" %>
   
   <div class="container" style="margin-top:80px">
      <div class="row">
         
         <!-- ====================== 본문 영역 =========================== -->
      <div class="col-9">
         <h3><strong class="me-5">게시글 보기</strong>
            <span style="font-size: 16px">
                  <a href="/jw/dog/board/list?p=${currentBoardPage}&f=${field}&q=${query}"><i class="fa-solid fa-table-list"></i>목록</a>
            <c:if test="${sessUid eq board.uId}">   <!-- 본인만 수정 가능 -->
                  <a href="/jw/dog/board/update?boardId=${board.boardId}"><i class="fa-solid fa-file-pen ms-3"></i>수정</a>
                  <a href="javascript:deleteFunc('${board.boardId}')"><i class="fa-solid fa-trash ms-3"></i>삭제</a> <!--  onclick="del()" -->
            
            </c:if>
            <c:if test="${sessUid ne board.uId}">   
                  <a href="#" class="disabled-link"><i class="fa-solid fa-file-pen ms-3"></i>수정</a>
                  <a href="#" class="disabled-link"><i class="fa-solid fa-trash ms-3"></i>삭제</a>
            </c:if>
            </span>
         </h3>
         <hr>
         <div class="row">
            <div class="col-8">
               <h5>${board.title}</h5>
               <h6>글 번호: ${board.boardId} | ${fn:replace(board.modTime, "T", " ")}</h6>
            </div>
            <div class="col-4 text-end"></div>
               <h5>${board.uId}</h5>
               <h6>조회 ${board.viewCount} &nbsp;&nbsp; 댓글 ${board.replyCount}</h6>
            </div>
            <hr>
            <div class="col-12">
               ${fn:replace(board.content, newline, '<br>')}
            </div>
         </div>
                  <!-- ====================== 본문 영역 =========================== -->
      </div>
   </div>
   
   <%@ include file="../common/_bottom.jspf" %>
   
   <div class="modal" id="deleteModal">
      <div class="modal-dialog">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">게시글 삭제</h4>
               <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
         
            <!-- Modal body -->
            <div class="modal-body">
               <strong>정말로 삭제하시겠습니까?</strong>
               <div class="text-center mt-5">
                  <form action="/jw/dog/board/delete" method="post">
                     <input type="hidden" id="deleteBoardId" name="boardId">
                     <button class="btn btn-danger" type="submit">삭제</button>
                  </form>
               </div>
            </div>
         </div>
      </div>
   </div>

   <form class="form-inline" action="/jw/dog/board/detail?boardId=${board.boardId}&replyId=${reply.replyId}" method="post">
        <table class="table table-borderless mt-2">
          <tr class="d-flex align-middle">
            <td class="col-lg-2 text-end"><label class="col-form-label">댓글</label></td>
            <td class="col-lg-8"><textarea class="form-control" name="content" rows="3"></textarea></td>
            <td class="col-lg-2"><button type="submit" class="btn btn-primary">등록</button></td>
          </tr>
        </table>
    </form>
</body>
</html>