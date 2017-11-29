package sample.data.jpa.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
	@Column (name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column (name = "fullname")
	private String fullName;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "deviceid")
	private String deviceId;
	@Column(name = "password")
	private String password;
	@Column(name = "userstatus")
	private String userStatus;



	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return fullName;
	}

	public void setName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public String getDeviceId(){
		return deviceId;
	}

	public void setDeviceid(String deviceId){
		this.deviceId = deviceId;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getUserStatus() {
		if(this.userStatus == null ){
			return "Good";
		}
		else
			return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
    
}

