package com.ifreedom.beauty.constants;

import java.util.Map;

/**
 * @atuhor:eavawu
 * @date:4/28/16
 * @todo:
 */
public class HttpConstants {
    //参数的key
    public static final String NAME = "name";
    public static final int SUCCESS = 1;
    public static final String USER = "user";
    public static final int FAILED = 0;
    public static final String PHONE = "phone";
    public static final String SEX = "sex";
    public static final String AVATAR = "avatar";
    public static final String PASSWORD = "password";
    public static final String TOKEN = "token";
    public static final String COURSELIST = "courseList";
    public static final String USERID = "userId";
    public static final Object SOCIAL_DETAILS = "socialDetails";

    //path的参数key
    public static final String USERID_PATH = "/{userId}";


    //path
    public static final String SIGN_IN = "/signIn";
    public static final String AUTO_SIGN_IN = "/autoSignIn";
    public static final String SIGN_UP = "/signUp";
    public static final String COURSE_CONTROL_PATH = "/course";
    public static final String SIGN_CONTROL_PATH = "/sign";
    public static final String FOLLOW_CONTROL_PATH = "/follow";
    public static final String FOLLOW_STATUS_KEY = "followStatus";
    public static final String COURSE_ID = "courseId";
    public static final Object COURSE_ITEMLIST = "courseItemList";
    public static final String COURSE_ITEMLIST_PATH = "/getCourseItems";
    public static final String SOCIAL_CONTROL_PATH = "/social";
    public static final String GET_SOCIALS = "/getSocials";

    public static final String STATUS = "status";
    public static final String SOCIAL_ID = "socialId";
    public static final String LIKE_PATH = "/like";
    public static final String USER_CONTROL_PATH = "/user";
    public static final String UPDATE_USER = "/updateUser";
    public static final String FOLLOW_LIST = "followEntities";
    public static final String BEFOLLOW_LIST = "beFollowEntities";
    public static final String LIKE_COURSE_PATH = "getLikeCourse";
    public static final String ARTICLE_CONTROL_PATH = "/article";
    public static final String ARTICLE_LIST = "articleList";
    public static final String MINE_SOCIAL = "mineSocial";
    public static final String ADD_COURSE = "/addCourse";
    public static final String SOCIAL = "social";
    public static final Object GOODSLIST = "goodsList";
    public static final int AUTO_SIGN_FAILED_CODE = 2000;
}
