package bai1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = "FirstName")
	@NotNull(message = "First name must be not null")
	@NotEmpty(message = "First name must be not empty")	
	protected String firstName;

	@Column(name = "LastName")
	@NotNull(message = "Last name must be not null")
	@NotEmpty(message = "Last name must be not empty")
	protected String lastName;

	@Column(name = "Email")
	@NotEmpty(message = "Email must be not empty")
    @Email(message = "Email should be valid")
	protected String email;

	@Column(name = "Password")
	@NotNull(message = "Password must be not null")
	@NotEmpty(message = "Password must be not empty")
	protected String password;

	@Column(name = "Birthday")
	@NotNull(message = "Birthday must be not null")
	@NotEmpty(message = "Birthday must be not empty")
	protected String birthday;

	@Column(name = "Gender")
	@NotNull(message = "Gender must be not null")
	@NotEmpty(message = "Gender must be not empty")
	protected String gender;

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String email, String password, String birthday,
			String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", birthday=" + birthday + ", gender=" + gender + "]";
	}

}
