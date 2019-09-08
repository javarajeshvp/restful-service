package com.vp.jersey.msg;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Singleton;

@Singleton
public class MessageStorage {

	private MessageStorage() {
	}

	private static MessageStorage singleInstance = null;

	public static MessageStorage getInstance() {
		if (singleInstance == null) {
			singleInstance = new MessageStorage();

		}
		return singleInstance;
	}

	private Map<Long, Message> messages = new HashMap<>();

	public Map<Long, Message> getAllMessages() {
		return messages;
	}

	public Message storeMsg(Message msg) {
		messages.put(msg.getId(), msg);
		return msg;
	}
	public Message deleteMsg(Message msg) {
		messages.remove(msg.getId());
		return msg;
	}
	public Message getMsgById(Long id) {
		Message msg = null;
		msg = messages.get(id);
		return msg;
	}

	public Long getMsgIdByMsg(String msg) {
		Long msgId = null;
		Optional<Long> optional = messages.entrySet().stream().filter(e -> msg.equals(e.getValue()))
				.map(Map.Entry::getKey).findFirst();
		msgId = optional.get();
		return msgId;
	}
}
