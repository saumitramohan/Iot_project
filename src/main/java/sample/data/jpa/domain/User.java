package sample.data.jpa.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
	@Column (name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column (name = "fullname")
	@NotNull
	private String fullName;
	@Column(name = "emailid")
	@NotNull
	private String emailId;
	@Column(name = "deviceid")
	@NotNull
	private String deviceId;

	@Column(name = "password")
	@NotNull
	private String password;
	@Column(name = "userstatus")
	private String userStatus;
	@Column(name ="username")
	@NotNull
	private String username;

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();




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
		this.password = PASSWORD_ENCODER.encode(password);
	}

	public String getPassword(){
		return password ;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

