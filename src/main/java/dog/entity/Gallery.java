package dog.entity;

public class Gallery {
    private int galleryId;
    private int isDeleted;
    private int likeCount;
    private String fName;
    private String uId;
    private String title;


    @Override
    public String toString() {
        return "Gallery{" +
                "galleryId=" + galleryId +
                ", isDeleted=" + isDeleted +
                ", likeCount=" + likeCount +
                ", fName='" + fName + '\'' +
                ", uId='" + uId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Gallery(String fName, String title) {
        this.fName = fName;
        this.title = title;
    }


    public Gallery(int galleryId, String fName, String title) {
        this.galleryId = galleryId;
        this.fName = fName;
        this.title = title;
    }

    public Gallery(String fName, String uId, String title) {
        this.fName = fName;
        this.uId = uId;
        this.title = title;
    }

    public Gallery() {
    }

    public Gallery(int galleryId, int isDeleted, int likeCount, String fName, String uId, String title) {
        this.galleryId = galleryId;
        this.isDeleted = isDeleted;
        this.likeCount = likeCount;
        this.fName = fName;
        this.uId = uId;
        this.title = title;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

}
