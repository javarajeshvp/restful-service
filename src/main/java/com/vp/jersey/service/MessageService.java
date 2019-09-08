package com.vp.jersey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vp.jersey.msg.Message;
import com.vp.jersey.msg.MessageStorage;

public class MessageService {
	static List<Message> messageList = null;

	public static void init() {
		if (messageList == null) {
			Message m1 = new Message(101, "Message no 1", "A1");
			Message m2 = new Message(102, "Message no 2", "A2");
			Message m3 = new Message(103, "Message no 3", "A3");
			messageList = new ArrayList<Message>();
			messageList.add(m1);
			messageList.add(m2);
			messageList.add(m3);
		}
	}

	public static List<Message> getAllMessages() {
		Map<Long, Message> msgMap = MessageStorage.getInstance().getAllMessages();
		List<Message> messages = msgMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		return messages;
	}

	public static Message getMessage(long messageId) {
		return MessageStorage.getInstance().getMsgById(messageId);
	}
	public static Long getMessage(String message) {
		return MessageStorage.getInstance().getMsgIdByMsg(message);
	}
	public static Message addMessage(Message m) {
		System.out.println("addMessage called ");
		return MessageStorage.getInstance().storeMsg(m);
	}
	public static Message updateMessage(Message m) {
		System.out.println("updateMessage called ");
		return MessageStorage.getInstance().storeMsg(m); 
	}
	public static Message deleteMessage(Message m) {
		System.out.println("deleteMessage called ");
		return MessageStorage.getInstance().deleteMsg(m); 
	}
}
