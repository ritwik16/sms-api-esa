package sms.service;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import sms.entity.Msg;
import sms.reporistory.MsgReporistory;

@Service
public class SmsService {

	@Autowired
	private MsgReporistory msgRepor;

	public SmsService(MsgReporistory msgReporistory) {
	}


	public ResponseEntity addMsg(Msg sms) {
		if(sms.getMessage() == null) {
			return new ResponseEntity<Object>(" error : FORM is missing parameter", new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
		}
		else if(sms.getMessage().length()<1||sms.getMessage().length()>120) {
			return new ResponseEntity<Object>("FOrmat error", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);

		}

		if(sms.getFrom()==null) {
			return new ResponseEntity<Object>(" error : FORM is missing parameter", new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

		}
		else if(sms.getFrom().length()<=6 || sms.getFrom().length()>16) {
			return new ResponseEntity<Object>("form length should be greater than 6 and less than 16 ", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
		}

		if(sms.getTo()==null) {
			return new ResponseEntity<Object>(" error : MESSAGE is missing parameter", new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

		}
		else if(sms.getTo().length()<=6||sms.getTo().length()>16) {
			return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);

		}

		if(sms.getMessage().equals("STOP")) {
			sms.setStopUtill(addHoursToJavaUtilDate(4));
		}

		sms.setCreatedAt(Calendar.getInstance().getTime());

		msgRepor.save(sms);
		return ResponseEntity.ok("inbound msg is ok");

	}


	public ResponseEntity  getMSG(Msg sms) {
		if(sms.getMessage() == null) {
			return new ResponseEntity<Object>(" error : FORM is missing parameter", new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
		}
		else if(sms.getMessage().length()<1||sms.getMessage().length()>120) {
			return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);

		}

		if(sms.getFrom()==null) {
			return new ResponseEntity<Object>(" error : FORM is missing parameter", new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

		}
		else if(sms.getFrom().length()<=6 || sms.getFrom().length()>16) {
			return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
		}

		if(sms.getTo()==null) {
			return new ResponseEntity<Object>(" error : MESSAGE is missing parameter", new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

		}
		else if(sms.getTo().length()<=6||sms.getTo().length()>16) {
			return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);

		}

		return ResponseEntity.ok("outbound msg is ok");

	}


	public long addHoursToJavaUtilDate( int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTimeInMillis();
	}

}
