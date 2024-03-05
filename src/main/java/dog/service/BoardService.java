package dog.service;

import java.util.List;

import dog.entity.Board;
import dog.entity.Reply;

public interface BoardService {
	public static final int COUNT_PER_PAGE = 10;

	List<Board> getBoardList(int page, String field, String query);
	
	Board getBoard(int boardId);
	
	int getBoardCount(String field, String query);
	
	void insertBoard(Board board);
	
	void updateBoard(Board board);				// 보드 수정
	
	void deleteBoard(int boardId);
	
	void increaseViewCount(int boardId);		// 조회수 증가
	
	void increaseReplyCount(int boardId);		// 댓글 증가
	
	void update(Reply reply);					//댓글 수정
	
	void insert(Reply reply);					//댓글 추가
	
	List<Reply> getReplyList();						//댓글 목록 얻어오기
}
