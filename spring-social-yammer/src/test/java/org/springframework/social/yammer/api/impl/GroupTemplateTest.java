/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.yammer.api.Group;
import org.springframework.social.yammer.api.GroupOperations;

/**
 * @author Morten Andersen-Gott
 *
 */
public class GroupTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetGroup(){
		Long id = 4022983L;
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups/"+id+".json"))
				.andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("yammer-group.json", getClass()), responseHeaders));
		Group group = yammerTemplate.groupOperations().getGroup(id);
		assertThat(group.getFullName(), equalTo("yammer-test-group"));
	}
	
	@Test
	public void testGetGroups_withNullParams(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups.json?page=1&reverse=false"))
		.andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-groups.json", getClass()), responseHeaders));
		List<Group> groups = yammerTemplate.groupOperations().getGroups(1,null,null,false);
		assertThat(groups.get(0).getFullName(), equalTo("yammer-test-group"));
	}
	
	@Test
	public void testGetGroups_withAllParams(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups.json?page=1&sort_by=privacy&reverse=true&letter=A"))
		.andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-groups.json", getClass()), responseHeaders));
		List<Group> groups = yammerTemplate.groupOperations().getGroups(1, 'A', GroupOperations.SORT_BY_PRIVACY, true);
		assertThat(groups.get(0).getFullName(), equalTo("yammer-test-group"));
	}
	
	@Test
	public void testCreateGroup(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups"))
		.andExpect(method(POST))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.groupOperations().createGroup("foo", false);
	}
	@Test
	public void testJoinGroup(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/group_memberships.json?group_id=1234"))
		.andExpect(method(POST))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.groupOperations().joinGroup(1234L);
	}
	@Test
	public void testLeaveGroup(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/group_memberships.json?group_id=1234"))
		.andExpect(method(DELETE))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.groupOperations().leaveGroup(1234L);
	}
	
}
