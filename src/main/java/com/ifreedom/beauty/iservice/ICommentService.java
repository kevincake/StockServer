package com.ifreedom.beauty.iservice;

import com.ifreedom.beauty.entity.CommentEntity;

import java.util.List;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
public interface ICommentService {
    CommentEntity addComment(CommentEntity commentEntity);
    CommentEntity deleteComment(CommentEntity commentEntity);
    CommentEntity updateComment(CommentEntity commentEntity);
    CommentEntity getComment(Long commentId);

    List<CommentEntity> getComments(Long socialEntityId);
}
