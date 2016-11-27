package com.ifreedom.beauty.service;

import com.ifreedom.beauty.entity.CommentEntity;
import com.ifreedom.beauty.iservice.ICommentService;
import com.ifreedom.beauty.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public CommentEntity addComment(CommentEntity commentEntity) {
        return commentRepository.addComment(commentEntity);
    }

    @Override
    public CommentEntity deleteComment(CommentEntity commentEntity) {
        return null;
    }

    @Override
    public CommentEntity updateComment(CommentEntity commentEntity) {
        return null;
    }

    @Override
    public CommentEntity getComment(Long commentId) {
        return null;
    }

    @Override
    public List<CommentEntity> getComments(Long socialEntityId) {
     return commentRepository.getComments(socialEntityId);

    }
}
