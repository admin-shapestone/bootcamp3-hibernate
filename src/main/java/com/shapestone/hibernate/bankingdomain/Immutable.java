package com.shapestone.hibernate.bankingdomain;

public class Immutable {
	public static void main(String[] args) {
		
		
	Address homeAddress=new Address("nandigama","andrapradesh","india");
	System.out.println("reference of object 1:"+homeAddress.hashCode());
	CustomeImmutableClassAccounts account=new CustomeImmutableClassAccounts("anitha",1111111,homeAddress);
	
	System.out.println(account);	
	Address address=account.getAddress();
	System.out.println("reference of object 2 :"+address.hashCode());
	address.setCity("challapalli");
	address.setState("andrapradesh");
	System.out.println(account);
}
}
