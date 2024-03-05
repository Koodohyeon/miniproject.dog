package dog.service;

import java.util.List;

import dog.entity.Reply;

public interface ReplyService {
	 public static final int COUNT_PER_PAGE = 10;
	
	 List<Reply> getReplyList(int boardId);		//글 목록 얻어오기
	 
	 Reply getReply(int replyId);
		
	 void insertReply(Reply reply);				//댓글 추가
		
	 void updateReply(Reply reply);				//댓글 수정
		
	 void increaseReplyCount(int boardId);		// 댓글 증가	
	 
	 void deleteReply(int replyId);						//댓글 삭제

	
	
}
