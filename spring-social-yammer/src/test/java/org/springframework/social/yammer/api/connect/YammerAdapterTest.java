package org.springframework.social.yammer.api.connect;

import org.junit.Test;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.yammer.api.MessageOperations;
import org.springframework.social.yammer.api.UserOperations;
import org.springframework.social.yammer.api.YammerProfile;
import org.springframework.social.yammer.api.impl.YammerTemplate;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class YammerAdapterTest {

    private YammerAdapter apiAdapter = new YammerAdapter();

    private YammerTemplate yammer = mock(YammerTemplate.class);

    private YammerProfile createYammerProfile(YammerProfile.Contact contact) {
        return new YammerProfile(4022983L, "https://assets0.yammer.com/user_uploaded/photos/p1/0080/1548/DSCF2811_2_small.JPG",
                null, "user", "https://www.yammer.com/yammerdeveloperstestcommunity/users/ilya", "Ilya Yakubovich", "ilya", false, "Socializing", "A summary", "Social animal", "network-id","network-name","network-domain",contact, null, null);
    }

    @Test
    public void shouldFetchProfile() {
    	
    	YammerProfile.Contact contact = new YammerProfile.Contact(new ArrayList<YammerProfile.EMail>(), new ArrayList<String>(), null);
    	YammerProfile yammerProfile = createYammerProfile(contact);
    	
    	UserOperations userOperations = mock(UserOperations.class);
    	when(yammer.userOperations()).thenReturn(userOperations);
    	when(userOperations.getUserProfile()).thenReturn(yammerProfile);
    	
    	UserProfile profile = apiAdapter.fetchUserProfile(yammer);
    	
    	assertEquals("Ilya Yakubovich", profile.getName());
    	assertEquals("ilya", profile.getUsername());
    	assertNull(profile.getEmail());
    	
    }
    @Test
    public void shouldUpdateStatus() {
    	
    	MessageOperations messageOperations = mock(MessageOperations.class);
    	when(yammer.messageOperations()).thenReturn(messageOperations);
    	
    	final String statusUpdate = "Hello yammer";
		apiAdapter.updateStatus(yammer, statusUpdate);
    	
    	verify(messageOperations).postUpdate(statusUpdate);
    }

    @Test
    public void whenFetchingProfileShouldSelectPrimaryMail() {

        List<YammerProfile.EMail> emails = new ArrayList<YammerProfile.EMail>();
        emails.add(new YammerProfile.EMail("primary", "yammer@springsocial.com"));
        emails.add(new YammerProfile.EMail("other", "yammer2@other.com"));
        YammerProfile.Contact contact = new YammerProfile.Contact(emails, null, null);

        YammerProfile yammerProfile = createYammerProfile(contact);

        UserOperations userOperations = mock(UserOperations.class);
        when(yammer.userOperations()).thenReturn(userOperations);
        when(userOperations.getUserProfile()).thenReturn(yammerProfile);

        UserProfile profile = apiAdapter.fetchUserProfile(yammer);

        assertEquals("yammer@springsocial.com", profile.getEmail());

    }

    @Test
    public void whenFetchingProfileShouldSelectFirstEMailWhenNoPrimaryMailExists() {

        List<YammerProfile.EMail> emails = new ArrayList<YammerProfile.EMail>();
        emails.add(new YammerProfile.EMail("other", "yammer2@other.com"));
        YammerProfile.Contact contact = new YammerProfile.Contact(emails, null, null);

        YammerProfile yammerProfile = createYammerProfile(contact);

        UserOperations userOperations = mock(UserOperations.class);
        when(yammer.userOperations()).thenReturn(userOperations);
        when(userOperations.getUserProfile()).thenReturn(yammerProfile);

        UserProfile profile = apiAdapter.fetchUserProfile(yammer);

        assertEquals("yammer2@other.com", profile.getEmail());

    }

    @Test
    public void shouldSetConnectionValues() throws Exception {

        YammerProfile yammerProfile = createYammerProfile(null);

        ConnectionValues values = mock(ConnectionValues.class);
        UserOperations userOperations = mock(UserOperations.class);
        when(yammer.userOperations()).thenReturn(userOperations);
        when(userOperations.getUserProfile()).thenReturn(yammerProfile);

        apiAdapter.setConnectionValues(yammer, values);

        verify(values).setDisplayName("Ilya Yakubovich");
        verify(values).setImageUrl("https://assets0.yammer.com/user_uploaded/photos/p1/0080/1548/DSCF2811_2_small.JPG");
        verify(values).setProfileUrl("https://www.yammer.com/yammerdeveloperstestcommunity/users/ilya");
        verify(values).setProviderUserId("4022983");
    }

    @Test
    public void testShouldSucceedWhenApiCanRetrieveUserProfile() {

        UserOperations userOperations = mock(UserOperations.class);
        when(yammer.userOperations()).thenReturn(userOperations);
        YammerProfile yammerProfile = mock(YammerProfile.class);
        when(userOperations.getUserProfile()).thenReturn(yammerProfile);

        boolean isApiOK = apiAdapter.test(yammer);

        assertTrue(isApiOK);
    }

    @Test
    public void testShouldFailWhenApiIsUnableToRetrieveUserProfile() {
        UserOperations userOperations = mock(UserOperations.class);
        when(yammer.userOperations()).thenReturn(userOperations);
        when(userOperations.getUserProfile()).thenThrow(new RestClientException("unable to retrieve user profile"));

        boolean isApiOK = apiAdapter.test(yammer);

        assertFalse(isApiOK);
    }
}
