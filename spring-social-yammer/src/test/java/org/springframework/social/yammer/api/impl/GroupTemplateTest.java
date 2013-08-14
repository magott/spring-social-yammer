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

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.yammer.api.Group;
import org.springframework.social.yammer.api.GroupOperations;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Morten Andersen-Gott
 *
 */
public class GroupTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetGroup(){
		Long id = 4022983L;
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups/"+id+".json"))
				.andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("testdata/yammer-group"), APPLICATION_JSON));
		Group group = yammerTemplate.groupOperations().getGroup(id);
		assertThat(group.getFullName(), equalTo("yammer-test-group"));
        assertThat(group.getLastMessageAt(), notNullValue());
	}
	
	@Test
	public void testGetGroups_withNullParams(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups.json?page=1&reverse=false"))
		.andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-groups"), APPLICATION_JSON));
		List<Group> groups = yammerTemplate.groupOperations().getGroups(1,null,null,false);
		assertThat(groups.get(0).getFullName(), equalTo("yammer-test-group"));
        assertThat(groups.get(0).getLastMessageAt(), notNullValue());

    }
	
	@Test
	public void testGetGroups_withAllParams(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups.json?page=1&sort_by=privacy&reverse=true&letter=A"))
		.andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-groups"), APPLICATION_JSON));
		List<Group> groups = yammerTemplate.groupOperations().getGroups(1, 'A', GroupOperations.SORT_BY_PRIVACY, true);
		assertThat(groups.get(0).getFullName(), equalTo("yammer-test-group"));
	}
	
	@Test
	public void testCreateGroup(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/groups"))
		.andExpect(method(POST))
		.andRespond(withSuccess("", MediaType.TEXT_PLAIN));
		yammerTemplate.groupOperations().createGroup("foo", false);
	}
	@Test
	public void testJoinGroup(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/group_memberships.json?group_id=1234"))
		.andExpect(method(POST))
		.andRespond(withSuccess("", MediaType.TEXT_PLAIN));
		yammerTemplate.groupOperations().joinGroup(1234L);
	}
	@Test
	public void testLeaveGroup(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/group_memberships.json?group_id=1234"))
		.andExpect(method(DELETE))
        .andRespond(withSuccess("", MediaType.TEXT_PLAIN));
		yammerTemplate.groupOperations().leaveGroup(1234L);
	}
	
}
