package org.springframework.social.yammer.api.impl;

import org.junit.Test;
import org.springframework.social.yammer.api.*;

import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.RequestMatchers.*;
import static org.springframework.test.web.client.response.ResponseCreators.withSuccess;

public class ActivityTemplateTest extends AbstractYammerApiTest {


	@Test
	public void testPostActivity(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/activity.json"))
		.andExpect(content().string("{\"message\":null,\"activity\":null,\"users\":[],\"private\":\"false\"}"))
		.andExpect(method(POST))
		.andRespond(withSuccess(jsonResource("testdata/yammer-activity"), APPLICATION_JSON));
        YammerActivityDetails yammerActivityDetails = new YammerActivityDetails();
		yammerTemplate.activityOperations().postActivity(yammerActivityDetails);
	}

//	@Test
//	public void testPostActivitya(){
//        YammerTemplate yammerTemplate1 = new YammerTemplate("8hwBDXPmyLg36bDWmLOQ");
////		mockServer.expect(requestTo("https://www.yammer.com/api/v1/activity.json"))
////		.andExpect(content().string(""))
////		.andExpect(method(POST))
//        System.out.println("yammerTemplate1.userOperations().getUserProfile() = " + yammerTemplate1.userOperations().getUserProfile().getNetworkDomain());
//        System.out.println("yammerTemplate1.userOperations().getUserProfile() = " + yammerTemplate1.userOperations().getUserProfile().getNetworkId());
//        System.out.println("yammerTemplate1.userOperations().getUserProfile() = " + yammerTemplate1.userOperations().getUserProfile().getNetworkName());
//
////		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
//        YammerActivityDetails yammerActivityDetails = new YammerActivityDetails();
//
//        YammerActivityActor actor = new YammerActivityActor("yoni", "y@zao.com");
//        YammerActivity activity = new YammerActivity();
//        activity.setAction(YammerActivity.YammerAction.FOLLOW.getName());
//        activity.setActor(actor);
//        activity.setType("person");
//
//        yammerActivityDetails.setMessage("My Message");
//        yammerActivityDetails.setPrivate(false);
////        yammerActivityDetails.getUsers().add(new YammerActivityUser("zao.com@yammer.com","zao.com@yammer.com"));
//        YammerActivityObject openGraphObject = new YammerActivityObject();
//        openGraphObject.setImage("https://sites.yammer.com/developers/files/2012/10/copy-cropped-logo-developers1.png");
//        openGraphObject.setTitle("Mt Title");
//        openGraphObject.setType("website");
//        openGraphObject.setUrl("http://www.zao.com");
//        activity.setObject(openGraphObject);
//        yammerActivityDetails.setActivity(activity);
//
//        yammerTemplate1.activityOperations().postActivity(yammerActivityDetails);
////        yammerTemplate.activityOperations().postActivity(yammerActivityDetails);
//    }


}
