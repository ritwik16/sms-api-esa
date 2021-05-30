package sms.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msg")
public class Msg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	@Column(name="sender")
	private  String from;
	@Column(name="receiver")
	private String to;
	private String message;
	@Column(name="created_at")
	private Date createdAt;
	@Column(name="stop_untill")
	private Long stopUtill;
	

	public Long getStopUtill() {
		return stopUtill;
	}


	public void setStopUtill(Long date) {
		this.stopUtill =  date;
	}


	public java.util.Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(java.util.Date localDate) {
		this.createdAt = localDate;
	}


	public Msg() {}
	
	
	public Msg(String from, String to, String message) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
