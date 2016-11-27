package com.ifreedom.beauty.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @atuhor:eavawu
 * @date:5/3/16
 * @todo:追随的人
 */
@Entity
@Table(name = "follow")
public class FollowEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public FollowEntity(){};
    public FollowEntity(Long followerId, Long beFollowerId) {
        this.followerId = followerId;
        this.beFollowerId = beFollowerId;
    }

    public Long getId() {
        return id;
    }
//    @DefaultNamingStrategy
    @Column(name = "followerId")
    private Long followerId; //我的follower
    @Column(name = "beFollowerId")
    private Long beFollowerId;//被我follower
    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "followerId")
    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }
    @Column(name = "beFollowerId")
    public Long getBeFollowerId() {
        return beFollowerId;
    }

    public void setBeFollowerId(Long beFollowerId) {
        this.beFollowerId = beFollowerId;
    }



}
