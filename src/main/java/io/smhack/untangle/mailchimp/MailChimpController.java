package io.smhack.untangle.mailchimp;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecwid.mailchimp.MailChimpException;

import io.smhack.untangle.mailchimp.service.MailChimpService;

@RestController
public class MailChimpController {

	@Autowired
	private MailChimpService mailChimpService ;
	
    @RequestMapping("/mailchimp")
    public String sendEmailToMailChimp(@RequestParam(name="email") String email ) throws IOException, MailChimpException {
    	mailChimpService.addToList(email); ;
    	return "Mail Added to list ";
    }
}
   