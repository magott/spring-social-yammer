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
}
