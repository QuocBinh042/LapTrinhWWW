package bai1.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Student {
	public enum Hobby {
		DRAWING, SINGING, DANCING, SKETCHING, OTHERS
	}

	private String firstName;
	private String lastName;
	private String birthday;
	private String email;
	private String mobileNumber;
	private String gender;
	private String address;
	private String city;
	private int pinCode;
	private String state;
	private String country;
	private Set<Hobby> hobbies;
	private List<Qualification> qualifications;
	private String courseApplies;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String birthday, String email, String mobileNumber, String gender,
			String address, String city, int pinCode, String state, String country, Set<Hobby> hobbies,
			List<Qualification> qualifications, String courseApplies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.hobbies = hobbies;
		this.qualifications = qualifications;
		this.courseApplies = courseApplies;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public String getCourseApplies() {
		return courseApplies;
	}

	public void setCourseApplies(String courseApplies) {
		this.courseApplies = courseApplies;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", email="
				+ email + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", address=" + address + ", city="
				+ city + ", pinCode=" + pinCode + ", state=" + state + ", country=" + country + ", hobbies=" + hobbies
				+ ", qualifications=" + qualifications + ", courseApplies=" + courseApplies + "]";
	}

}
