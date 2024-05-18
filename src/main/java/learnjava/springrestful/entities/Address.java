package learnjava.springrestful.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String lane;
	private String state;
	private int pincode;
	public Address(String lane, String state, int pincode) {
		super();
		this.lane = lane;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [lane=" + lane + ", state=" + state + ", pincode=" + pincode + "]";
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
