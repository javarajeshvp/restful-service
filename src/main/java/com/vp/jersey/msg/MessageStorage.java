package com.vp.jersey.msg;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Singleton;

@Singleton
public class MessageStorage {

	private Map<Long,Message> messages = new HashMap<>();;
			
	public boolean storeMsg(Message msg){ 
		boolean stored=false;
		messages.put(msg.getId(), msg);
		stored = true;
		return stored;
	}

	public Message getMsg(Long id)
	{
		Message msg = null;
		msg=messages.get(id);
		return msg;
	}
	public Long getMsgId(String msg)
	{
		Long  msgId = null;
		Optional<Long> optional = messages.entrySet().stream()
				  .filter(e -> msg.equals(e.getValue()))
				  .map(Map.Entry::getKey)
				  .findFirst();
		msgId=optional.get(); 
		return msgId;
	}
}
