package dog.dao;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dog.entity.Board;
import dog.entity.Reply;

public class ReplyDao {
    
    public Connection getConnection() {
        Connection conn = null;
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/dog");
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Reply getReply(int replyId) {
        Connection conn = getConnection();
        String sql = "SELECT r.*, u.uId FROM reply r" 
                   + " JOIN user u ON r.uId=u.uId" 
                   + " WHERE r.replyId=?";
        Reply reply = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, replyId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                reply = new Reply(rs.getInt("replyId"), 
                                  rs.getString("comment"), 
                                  rs.getTimestamp("regTime").toLocalDateTime(), 
                                  rs.getInt("boardId"), 
                                  rs.getString("uId"), 
                                  rs.getInt("isDeleted"));
            }
            rs.close();
            pstmt.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reply;
    }

    public List<Reply> getReplyList(int boardId) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM reply WHERE isDeleted=0 AND boardId=? ORDER BY replyId DESC";

        List<Reply> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Reply reply = new Reply(rs.getInt("replyId"), 
                                        rs.getString("comment"), 
                                        rs.getTimestamp("regTime").toLocalDateTime(), 
                                        rs.getInt("boardId"), 
                                        rs.getString("uId"), 
                                        rs.getInt("isDeleted"));
                list.add(reply);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void insertReply(Reply reply) {
        Connection conn = getConnection();
        String sql = "insert into reply values (default, ?, default, ?, ?, default)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reply.getComment());
            pstmt.setInt(2, reply.getBoardId());
            pstmt.setString(3, reply.getuId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteReply(int replyId) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE reply SET isDeleted=1 WHERE replyId=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, replyId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateReply(Reply reply) {
        Connection conn = getConnection();
        String sql = "update reply set comment=?, modTime=now() where replyId=? ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reply.getComment());
            pstmt.setInt(2, reply.getReplyId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getReplyCount(String field, String query) {
        Connection conn = getConnection();
        query = "%" + query + "%";
        String sql = "SELECT COUNT(replyId) FROM reply" 
                   + " JOIN board b ON reply.boardId=b.boardId " 
                   + " WHERE reply.isDeleted=0 and " + field + " LIKE ?";

        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, query);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public void increaseReplyCount(int boardId) {
        Connection conn = getConnection();
        String sql = "UPDATE reply SET reply WHERE replyId=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardId);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
