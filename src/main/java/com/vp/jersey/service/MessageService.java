package com.vp.jersey.service;

import java.util.ArrayList;
import java.util.List;

import com.vp.jersey.msg.Message;

public class MessageService {
	static List<Message> messageList = null;

	public static void init() {
		Message m1 = new Message(10, "Hello Basis 1", "Risto 1");
		Message m2 = new Message(11, "Hello World 2", "Rajesh 2");
		Message m3 = new Message(13, "Hello World 3", "Rajesh 3");
		messageList = new ArrayList<Message>();
		messageList.add(m1);
		messageList.add(m2);
	}

	public static List<Message> getAllMessages() {
		init();
		Message m1 = new Message(0, "Hello Basis 0", "Risto 0");

		messageList.add(m1);

		return messageList;
	}

	public static Message getMessage(long messageId) {
		Message correctMessage = null;
		for (Message m : messageList) {
			if (m.getId() == messageId) {
				correctMessage = m;
				break;
			}
		}
		return correctMessage;

	}

	public static Message addMessage(Message m) {
		messageList.add(m);
		return m;
	}
}
