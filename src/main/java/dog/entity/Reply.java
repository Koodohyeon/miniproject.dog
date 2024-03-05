package dog.entity;

import java.time.LocalDateTime;

public class Reply {
	private int replyId;					// 글번호
	private String comment;					// 댓글 내용
	private LocalDateTime regTime;			// 작성시간
	private int boardId;					// 부모글 번호
	private String uId;						// 댓글 작성자 아이디
	private int isDeleted;
	
	public Reply() { }
	
	public Reply(int replyId, String comment, int boardId) {
		this.replyId = replyId;
		this.comment = comment;
		this.boardId = boardId;
	}

	

	public Reply(int replyId, String comment, String uId) {
		this.replyId = replyId;
		this.comment = comment;
		this.uId = uId;
	}



	public Reply(String comment, String uId) {
		this.comment = comment;
		this.uId = uId;
	}

	public Reply(String comment, int boardId, String uId) {
		this.comment = comment;
		this.boardId = boardId;
		this.uId = uId;
	}

	public Reply(int replyId, String comment) {
		this.replyId = replyId;
		this.comment = comment;
	}

	public Reply(int replyId, String comment, LocalDateTime regTime, int boardId, String uId, int isDeleted) {
		this.replyId = replyId;
		this.comment = comment;
		this.regTime = regTime;
		this.boardId = boardId;
		this.uId = uId;
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", comment=" + comment + ", regTime=" + regTime + ", boardId=" + boardId
				+ ", uId=" + uId + ", isDeleted=" + isDeleted + "]";
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getRegTime() {
		return regTime;
	}

	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
