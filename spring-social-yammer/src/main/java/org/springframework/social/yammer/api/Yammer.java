package org.springframework.social.yammer.api;

public interface Yammer{

	/**
	 * Returns the portion of the API containing the Thread operations
	 */
	ThreadOperations threadOperations();

	/**
	 * Returns the portion of the API containing the Subscription (follow) operations
	 */
	SubscriptionOperations subscriptionOperations();

	/**
	 * Returns the portion of the API containing the Topic (tags) operations
	 */
	TopicOperations topicOperations();

	/**
	 * Returns the portion of the API containing the Search operations
	 */
	SearchOperations searchOperations();

	/**
	 * Returns the portion of the API containing the Group operations
	 */
	GroupOperations groupOperations();

	/**
	 * Returns the portion of the API containing the Message operations
	 */
	MessageOperations messageOperations();

	/**
	 * Returns the portion of the API containing the User operations
	 */
	UserOperations userOperations();

}
