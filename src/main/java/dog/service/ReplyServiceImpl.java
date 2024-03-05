package dog.service;

import java.util.List;

import dog.dao.ReplyDao;

import dog.entity.Reply;

public class ReplyServiceImpl implements ReplyService {

    private ReplyDao replyDao = new ReplyDao();

    @Override
    public List<Reply> getReplyList(int boardId) {
        return replyDao.getReplyList(boardId);
    }

    @Override
    public Reply getReply(int replyId) {
        return replyDao.getReply(replyId);
    }

    @Override
    public void insertReply(Reply reply) {
        replyDao.insertReply(reply);
    }

    @Override
    public void updateReply(Reply reply) {
        replyDao.updateReply(reply);
    }

    @Override
    public void increaseReplyCount(int boardId) {
        replyDao.increaseReplyCount(boardId);
    }

    @Override
    public void deleteReply(int replyId) {
        replyDao.deleteReply(replyId);
    }
}
