package dog.entity;

public class Liked {
	private int likedId;
	private int galleryId;
	private String userId;
	public Liked() { }

	public Liked(int galleryId, String userId) {
		this.galleryId = galleryId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "liked [likedId=" + likedId + ", galleryId=" + galleryId + ", userId=" + userId + "]";
	}
	public int getLikedId() {
		return likedId;
	}
	public void setLikedId(int likedId) {
		this.likedId = likedId;
	}
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
