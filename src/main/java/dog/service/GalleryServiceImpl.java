package dog.service;

import dog.dao.GalleryDao;
import dog.entity.Gallery;


import java.util.List;

public class GalleryServiceImpl implements GalleryService{
    private GalleryDao gDao = new GalleryDao();
//    @Override
//    public List<Gallery> getGalleryList(int page, String field, String query) {
//        int offset = (page - 1) * COUNT_PER_PAGE;
//        query = "%" + query + "%";
//        List<Gallery> list = gDao.getGalleryList(field, query, COUNT_PER_PAGE, offset);
//        return list;
//    }
    public List<Gallery> getGalleryList(int page, String field) {
        int offset = (page - 1) * COUNT_PER_PAGE;
        List<Gallery> list = gDao.getGalleryList(field, COUNT_PER_PAGE, offset);
        return list;
    }

    @Override
    public Gallery getGallery(int galleryId) {
        return gDao.getGallery(galleryId);
    }

//    @Override
//    public int getGalleryCount(String field, String query) {
//        return gDao.getGalleryCount(field, query);
//    }
    public int getGalleryCount(String field) {
        return gDao.getGalleryCount(field);
    }

    @Override
    public void updateLikeCount(int galleryId) {
        gDao.updateLikeCount(galleryId);
    }


    @Override
    public void insertGallery(Gallery gallery) {
        gDao.insertGallery(gallery);
    }

    @Override
    public void updateGallery(Gallery gallery) {
        gDao.updateGallery(gallery);
    }

    @Override
    public void deleteGallery(int galleryId) {
        gDao.deleteGallery(galleryId);
    }

    @Override
    public void changeLiked(int galleryId, String uId) {
        gDao.changeLiked(galleryId, uId);
    }


}
