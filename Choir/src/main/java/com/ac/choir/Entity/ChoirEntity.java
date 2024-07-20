package com.ac.choir.Entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Entity-Details")
public class ChoirEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String Name;
	private String Role;
	private long Mobile;
	private String EmailId;
	private String Adress;
	@Lob
	@Column(name="image", columnDefinition ="LONGBLOB")
	private byte[] image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public long getMobile() {
		return Mobile;
	}
	public void setMobile(long mobile) {
		Mobile = mobile;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public ChoirEntity(long id, String name, String role, long mobile, String emailId, String adress, byte[] image) {
		super();
		this.id = id;
		Name = name;
		Role = role;
		Mobile = mobile;
		EmailId = emailId;
		Adress = adress;
		this.image = image;
	}
	public ChoirEntity() {
		super();
	}
	@Override
	public String toString() {
		return "ChoirEntity [id=" + id + ", Name=" + Name + ", Role=" + Role + ", Mobile=" + Mobile + ", EmailId="
				+ EmailId + ", Adress=" + Adress + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	

}
