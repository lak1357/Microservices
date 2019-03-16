package com.mitrai.kafkaex.dto;

public class Message {

	private String messageId;
	private String message;
	private String topic;

	public Message(String messageId, String message, String topic) {
		super();
		this.messageId = messageId;
		this.message = message;
		this.topic = topic;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", topic=" + topic + "]";
	}
	
	

}
