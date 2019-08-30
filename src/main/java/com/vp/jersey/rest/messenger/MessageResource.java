package com.vp.jersey.rest.messenger;
import com.vp.jersey.msg.Message;
import com.vp.jersey.service.MessageService;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messages")
public class MessageResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return MessageService.getAllMessages(); 
    }
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId) {
        return MessageService.getMessage(messageId); 
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(String message) {
       // return MessageService.addMessage(message);
    	
    	return null;
    }
    
}
