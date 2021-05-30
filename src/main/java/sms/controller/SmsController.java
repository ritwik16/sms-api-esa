package sms.controller;

import org.springframework.web.bind.annotation.RestController;

import sms.entity.Msg;
import sms.reporistory.MsgReporistory;
import sms.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class SmsController {
	@Autowired
	private MsgReporistory msgRepor;
	@Autowired
	private SmsService smsService;
	
	@RequestMapping(method=RequestMethod.POST,value ="/outbound")
	public ResponseEntity addMsg(@RequestBody Msg sms) {
		return smsService.addMsg(sms);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value ="/inbound")
	public ResponseEntity getMSG(@RequestBody Msg sms) {
		
		return smsService.getMSG(sms);
	}

}
