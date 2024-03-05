package dog.dao;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dog.entity.Board;

public class BoardDao {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/dog");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Board getBoard(int boardId) {
		Connection conn = getConnection();
		String sql = "SELECT b.*, u.uId FROM board b"
					+ "	JOIN user u ON b.uId=u.uId"
					+ "	WHERE b.boardId=?";
		Board board = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3),  
						LocalDateTime.parse(rs.getString(4).replace(" ", "T")), rs.getInt(5),
						rs.getInt(6), rs.getInt(7),  rs.getString(8));
			}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	// field 값은 title, content, uId 등 attribute name
	// query 값은 검색어
	public List<Board> getBoardList(String field, String query, int num, int offset) {
		Connection conn = getConnection();
		String sql = "SELECT b.*, u.uId FROM board b"
					+ "	JOIN user u ON b.uId=u.uId"
					+ "	WHERE b.isDeleted=0 AND " + field + " LIKE ?"
					+ "	ORDER BY boardId DESC "
					+ "	LIMIT ? OFFSET ?";
		List<Board> list = new ArrayList<Board>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, query);
			pstmt.setInt(2, num);
			pstmt.setInt(3, offset);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2), rs.getString(3),  
						LocalDateTime.parse(rs.getString(4).replace(" ", "T")), rs.getInt(5),
						rs.getInt(6), rs.getInt(7),  rs.getString(8));
				list.add(board);
			}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertBoard(Board board) {
		Connection conn = getConnection();
		String sql = "insert into board values (default, ?, ?, default, default, default, default, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getuId());

			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard(Board board) {
		Connection conn = getConnection();
		String sql = "update board set title=?, content=?, modTime=now() where boardId=? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardId());
			
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBoard(int boardId) {
		Connection conn = getConnection();
		String sql = "update board set isDeleted=1 where boardId=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		public void increaseCount(String field, int boardId) {
			Connection conn = getConnection();
			String sql = "UPDATE board SET " + field + "Count=" + field + "Count+1 WHERE boardId=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardId);
				
				pstmt.executeUpdate();
				pstmt.close(); conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public int getBoardCount(String field, String query) {
			Connection conn = getConnection();
			query = "%" + query + "%";
			String sql = "SELECT COUNT(boardId) FROM board"
					+ "  JOIN user ON board.uId=user.uId"
					+ "  WHERE board.isDeleted=0 and " + field + " LIKE ?";
			int count = 0;
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, query);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					count = rs.getInt(1);
				}
				rs.close(); pstmt.close(); conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count;
		}
}
