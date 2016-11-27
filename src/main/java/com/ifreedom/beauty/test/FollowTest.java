package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @atuhor:eavawu
 * @date:5/8/16
 * @todo:
 */
@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = BeautyApplication.class)

public class FollowTest {

    private RestTemplate template = new TestRestTemplate();
    @Test
    public void testUpdateStatus(){

//        String url = TestConstants.BASE_URL+ HttpConstants.FOLLOW_CONTROL_PATH+HttpConstants.FOLLOW_CONTROL_PATH+"/2";
//        HttpResult forObject = template.postForObject(url, request, HttpResult.class);
    }
}
