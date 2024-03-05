package dog.service;

import java.util.List;

import dog.dao.BoardDao;
import dog.entity.Board;
import dog.entity.Reply;



public class BoardServiceImpl implements BoardService {
	private BoardDao bDao = new BoardDao();

	@Override
	public List<Board> getBoardList(int page, String field, String query) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		query = "%" + query + "%";
		List<Board> list = bDao.getBoardList(field, query, COUNT_PER_PAGE, offset);
		return list;
	}

	@Override
	public Board getBoard(int boardId) {
		return bDao.getBoard(boardId);
	}

	@Override
	public int getBoardCount(String field, String query) {
		return bDao.getBoardCount(field, query);
	}


	@Override
	public void deleteBoard(int boardId) {
		bDao.deleteBoard(boardId);
	}

	@Override
	public void increaseViewCount(int boardId) {
		bDao.increaseCount("view", boardId);
	}

	@Override
	public void increaseReplyCount(int boardId) {
		bDao.increaseCount("reply", boardId);
	}

	@Override
	public void insertBoard(Board board) {
		bDao.insertBoard(board);
		
	}

	@Override
	public void updateBoard(Board board) {
		bDao.updateBoard(board);
		
	}

	@Override
	public void update(Reply reply) {
	
	}

	@Override
	public void insert(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reply> getReplyList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}