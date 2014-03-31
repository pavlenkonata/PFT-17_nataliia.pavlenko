package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String firstname;
	private String lastname;
	private String address;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String choosengroup;
	private String address2;
	private String homephone2;

	public ContactData() {
		
	}



	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname
				+ ", firstname=" + firstname + " ]";
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
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}



	@Override
	public int compareTo(ContactData other) {
		return this.lastname.compareTo(other.lastname);
	}



	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}
	
	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}
	
	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}
	
	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	
	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}
	
	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}
	
	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}
	
	public ContactData withChoosengroup(String choosengroup) {
		this.choosengroup = choosengroup;
		return this;
	}
	
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withHomephone2(String homephone2) {
		this.homephone2 = homephone2;
		return this;
	}



	public String getFirstname() {
		return firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public String getAddress() {
		return address;
	}



	public String getHomephone() {
		return homephone;
	}



	public String getMobilephone() {
		return mobilephone;
	}



	public String getWorkphone() {
		return workphone;
	}



	public String getEmail() {
		return email;
	}



	public String getEmail2() {
		return email2;
	}



	public String getBday() {
		return bday;
	}



	public String getBmonth() {
		return bmonth;
	}



	public String getByear() {
		return byear;
	}



	public String getChoosengroup() {
		return choosengroup;
	}



	public String getAddress2() {
		return address2;
	}



	public String getHomephone2() {
		return homephone2;
	}
	
	
	
}