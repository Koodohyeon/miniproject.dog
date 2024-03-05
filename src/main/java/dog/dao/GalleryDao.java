package dog.dao;

import dog.entity.Gallery;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GalleryDao {
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

    public Gallery getGallery(int galleryId) {
        Connection conn = getConnection();
        String sql = "SELECT g.*, u.uname FROM gallery g"
                + "	JOIN user u ON g.uId=u.uId"
                + "	WHERE g.galleryId=?";
        Gallery gallery = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, galleryId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                gallery = new Gallery(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3),rs.getString(4), rs.getString(5), rs.getString(6));
            }
            rs.close(); pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gallery;
    }

    public List<Gallery> getGalleryList(String field, int num, int offset) {
        Connection conn = getConnection();
        String sql = "SELECT g.*, u.uname FROM gallery g"
                + "	JOIN user u ON g.uId=u.uId"
                + "	WHERE g.isDeleted=0"
                + "	ORDER BY galleryId DESC "
                + "	LIMIT ? OFFSET ?";
        List<Gallery> list = new ArrayList<Gallery>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setInt(2, offset);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3),rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(gallery);
            }
            rs.close(); pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertGallery(Gallery gallery) {
        Connection conn = getConnection();
        String sql = "insert into gallery values (default, default, default, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gallery.getfName());
            pstmt.setString(2, gallery.getuId());
            pstmt.setString(3, gallery.getTitle());


            pstmt.executeUpdate();
            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGallery(Gallery gallery) {
        Connection conn = getConnection();
        String sql = "update gallery set fName=? where galleryId=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, gallery.getfName());
            pstmt.setInt(2, gallery.getGalleryId());

            pstmt.executeUpdate();
            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGallery(int galleryId) {
        Connection conn = getConnection();
        String sql = "update gallery set isDeleted=1 where galleryId=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, galleryId);

            pstmt.executeUpdate();
            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeLiked(int galleryId, String uId) {
        Connection conn = getConnection();
        String sql = "INSERT INTO liked (galleryId, uId) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE isDeleted = CASE WHEN isDeleted = 0 THEN 1 ELSE 0 END";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, galleryId);
            pstmt.setString(2, uId);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getGalleryCount(String field) {
        Connection conn = getConnection();
        String sql = "SELECT COUNT(galleryId) FROM gallery"
                + "  JOIN user ON gallery.uId=user.uId"
                + "  WHERE gallery.isDeleted=0";
        int count = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
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

    public void updateLikeCount(int galleryId) {
        Connection conn = getConnection();
        String sql = "UPDATE gallery g JOIN (SELECT galleryId, COUNT(*) AS likeCount FROM liked WHERE isDeleted = 0 GROUP BY galleryId) l ON g.galleryId = l.galleryId SET g.likeCount = l.likeCount";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
