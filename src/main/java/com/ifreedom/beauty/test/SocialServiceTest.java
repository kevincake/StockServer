package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.entity.CommentEntity;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.SocialEntity;
import com.ifreedom.beauty.service.CommentService;
import com.ifreedom.beauty.service.LikeService;
import com.ifreedom.beauty.service.SocialService;
import com.ifreedom.beauty.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @atuhor:eavawu
 * @date:5/14/16
 * @todo:
 */
@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = BeautyApplication.class)
public class SocialServiceTest {
    @Autowired
    SocialService socialService;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeService likeService;
    @Autowired
    UserService userService;


    @Test
    public void addSocialDetail(){

        for(int i=0;i<10;i++){
            SocialEntity socialEntity = new SocialEntity();
//            socialEntity.setPic(new String[]{"http://beautybucket.oss-cn-shenzhen.aliyuncs.com/1462709283670.jpeg"});
            socialEntity.setType(DataBaseConstants.TEXT_TYPE);
            socialEntity.setDeployTime(System.currentTimeMillis());
            socialEntity.setContent("hello world");
            socialEntity.setUserId(i<5?1L:10L);
            SocialEntity socialEntityResult = socialService.addSocial(socialEntity);
            for (int j=0;j<10;j++){
                //like
                LikeEntity likeEntity = new LikeEntity();
                likeEntity.setUserId(j<5?1L:10L);
                likeEntity.setSocialId(socialEntityResult.getId());
                 likeService.addLike(likeEntity);

                //comment
                CommentEntity commentEntity = new CommentEntity();
                commentEntity.setSocialId(socialEntityResult.getId());
                commentEntity.setContent("这是"+j+"品论");
                commentEntity.setFromUserId(j<10?1L:10L);
                commentEntity.setToUserId(j<10?1L:10L);
                commentService.addComment(commentEntity);
            }
        }


    }

}
