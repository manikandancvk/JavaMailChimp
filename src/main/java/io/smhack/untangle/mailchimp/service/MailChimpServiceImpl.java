package io.smhack.untangle.mailchimp.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecwid.mailchimp.MailChimpClient;
import com.ecwid.mailchimp.MailChimpException;
import com.ecwid.mailchimp.method.v2_0.lists.Email;
import com.ecwid.mailchimp.method.v2_0.lists.SubscribeMethod;

@Service
public class MailChimpServiceImpl implements MailChimpService {
	@Value("${mailchimp.apiKey}")
	private String apiKey ;
	@Value("${mailchimp.listid}")
	private String listId ; 
	
	@Override
	public void addToList(String email) throws IOException, MailChimpException {
		MailChimpClient mailChimpClient = new MailChimpClient(); 
	    SubscribeMethod subscribeMethod = new SubscribeMethod();
	    subscribeMethod.apikey = apiKey;
	    subscribeMethod.id = listId;
	    subscribeMethod.email = new Email();
	    subscribeMethod.email.email = email;
	    subscribeMethod.double_optin = false;
	    subscribeMethod.update_existing = true;
	    Email emailAdded = mailChimpClient.execute(subscribeMethod);
	    mailChimpClient.close();
		
	}

}
