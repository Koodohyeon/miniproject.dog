package dog.dao;

import javax.naming.Context;	
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LikeDao {
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
    public int updateLiked(int galleryId, String uId) {
        Connection conn = getConnection();
        String updateSql = "UPDATE liked SET isDeleted = CASE WHEN isDeleted = 0 THEN 1 ELSE 0 END WHERE galleryId = ? AND uId = ?";
        String insertSql = "INSERT INTO liked (galleryId, uId, isDeleted) VALUES (?, ?, 1)";
        String selectSql = "SELECT isDeleted FROM liked WHERE galleryId = ? AND uId = ?";

        try (PreparedStatement pstmtUpdate = conn.prepareStatement(updateSql);
             PreparedStatement pstmtInsert = conn.prepareStatement(insertSql);
             PreparedStatement pstmtSelect = conn.prepareStatement(selectSql)) {

            // UPDATE 쿼리 실행
            pstmtUpdate.setInt(1, galleryId);
            pstmtUpdate.setString(2, uId);
            int rowsAffected = pstmtUpdate.executeUpdate();

            // UPDATE가 아무 영향을 주지 않는 경우 INSERT 쿼리 실행
            if (rowsAffected == 0) {
                pstmtInsert.setInt(1, galleryId);
                pstmtInsert.setString(2, uId);
                pstmtInsert.executeUpdate();
            }

            // SELECT 쿼리 실행하여 최종 isDeleted 값 얻기
            pstmtSelect.setInt(1, galleryId);
            pstmtSelect.setString(2, uId);
            ResultSet rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                int finalIsDeleted = rs.getInt("isDeleted");
                return finalIsDeleted;
            }

            rs.close(); pstmtUpdate.close(); pstmtInsert.close(); pstmtSelect.close(); conn.close();
        } catch (SQLException e) {
            System.out.println("에러 발생");
            e.printStackTrace();
        }

        return -1; // 에러가 발생하거나 쿼리 실행 결과를 얻을 수 없는 경우
    }

}
