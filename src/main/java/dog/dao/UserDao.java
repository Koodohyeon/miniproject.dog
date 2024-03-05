package dog.dao;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dog.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static Connection getConnection() {
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

    public User getUserByUid(String uId) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM user WHERE uId=?";
        User user = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);
           
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LocalDate regDate = rs.getDate("regDate") != null ? rs.getDate("regDate").toLocalDate() : null;
                user = new User(rs.getString("uId"), rs.getString("pwd"), rs.getString("uname"),
                        rs.getString("email"), regDate, rs.getInt("isDeleted"), rs.getInt("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    


    public List<User> getUserList(int num, int offset) {
        Connection conn = getConnection();
        String sql = "SELECT * FROM user WHERE isDeleted=0 ORDER BY regDate DESC, uId LIMIT ? OFFSET ?";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setInt(2, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // java.sql.Date를 java.time.LocalDate로 변환
                LocalDate regDate = rs.getDate("regDate").toLocalDate();

                User user = new User(
                        rs.getString("uId"),
                        rs.getString("pwd"),
                        rs.getString("uname"),
                        rs.getString("email"),
                        regDate,
                        rs.getInt("isDeleted"),
                        rs.getInt("balance")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void insertUser(User user) {
        Connection conn = getConnection();
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getuId());
            pstmt.setString(2, user.getPwd());
            pstmt.setString(3, user.getUname());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(User user) {
        Connection conn = getConnection();
        String sql = "update user set pwd=?, uname=?, email=?, balance=? where uId=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getPwd());
            pstmt.setString(2, user.getUname());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getBalance());
            pstmt.setString(5, user.getuId());

            pstmt.executeUpdate();
            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String uId) {
        Connection conn = getConnection();
        String sql = "update user set isDeleted=1 where uId=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uId);

            pstmt.executeUpdate();
            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getUserCount() {
        Connection conn = getConnection();
        String sql= "select count(uId) from user where isDeleted=0";
        int count = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close(); stmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


}
