package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String choosengroup;
	public String address2;
	public String homephone2;

	public ContactData() {
		
	}



	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", homephone=" + homephone
				+ ", mobilephone=" + mobilephone + ", workphone=" + workphone
				+ ", email=" + email + ", email2=" + email2 + ", bday=" + bday
				+ ", bmonth=" + bmonth + ", byear=" + byear + ", choosengroup="
				+ choosengroup + ", address2=" + address2 + ", homephone2="
				+ homephone2 + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result
			//	+ ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}



	@Override
	public int compareTo(ContactData other) {
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}
	
	
	
}