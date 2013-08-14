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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerDateDeserializer extends JsonDeserializer<Date> {

	//Example format: 2011/03/03 21:12:57 +0000
	public static final String DATE_FORMAT_MASK = "yyy/MM/dd HH:mm:ss Z";
	public static final Locale LOCALE = Locale.ENGLISH;
	

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return createDateFormatter().parse(jp.getText());
        } catch (ParseException e) {
            return null;
        }
	}
	
	SimpleDateFormat createDateFormatter(){
		return new SimpleDateFormat(DATE_FORMAT_MASK, LOCALE);		
	}

}
