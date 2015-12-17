package io.smhack.untangle.mailchimp.service;

import java.io.IOException;

import com.ecwid.mailchimp.MailChimpException;

public interface MailChimpService {

	void addToList(String email)  throws IOException, MailChimpException ; 
}
