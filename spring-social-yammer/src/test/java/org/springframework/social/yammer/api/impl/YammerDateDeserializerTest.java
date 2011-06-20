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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

import org.junit.Test;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerDateDeserializerTest {

	private YammerDateDeserializer deserializer = new YammerDateDeserializer();
	
	@Test
	public void testSimpleDateFormatter() throws Exception{
		String dateToParse = "2011/03/31 21:12:57 +0000";
		Date date = deserializer.createDateFormatter().parse(dateToParse);
		assertThat(date, notNullValue());
		System.out.println(date);
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(0,"GMT"));
		cal.setTimeInMillis(date.getTime());
		assertThat(cal.get(Calendar.DAY_OF_MONTH), equalTo(31));
		assertThat(cal.get(Calendar.MONTH), equalTo(Calendar.MARCH));
		assertThat(cal.get(Calendar.HOUR_OF_DAY), equalTo(21));
		assertThat(cal.get(Calendar.ZONE_OFFSET), equalTo(0));
	}
	
}
