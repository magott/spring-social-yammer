package org.springframework.social.yammer.api;

public interface Yammer{

	ThreadOperations threadOperations();

	SubscriptionOperations subscriptionOperations();

	TopicOperations topicOperations();

	SearchOperations searchOperations();

	GroupOperations groupOperations();

	MessageOperations messageOperations();

	UserOperations userOperations();

}
