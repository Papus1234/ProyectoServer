package org.rest.ProyectoServer.service;

import java.util.ArrayList;
import java.util.List;

import org.rest.ProyectoServer.models.Message;

public class MessageService {
	
	
	public List<Message> getAllMessages(){
			Message m=new Message(3030, "esta carajada",  "esta otra");
			Message m1=new Message(20201, "Cuando ya esto sirva", "yo lo hice");
			List<Message> lis=new ArrayList<>();
			lis.add(m);
			lis.add(m1);
			return lis;
		
	}
}
