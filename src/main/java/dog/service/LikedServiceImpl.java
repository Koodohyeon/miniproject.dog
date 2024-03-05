package dog.service;

import dog.dao.BoardDao;
import dog.dao.LikeDao;

public class LikedServiceImpl implements LikedService{
    private LikeDao lDao = new LikeDao();

    @Override
    public int updateLiked(int galleryId, String uId) {
        return lDao.updateLiked(galleryId, uId);
    }
}
