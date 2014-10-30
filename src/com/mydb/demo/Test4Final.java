package com.mydb.demo;

public class Test4Final {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDaoImpl();
//		Customer c = new Customer();
		
		Customer c1 = dao.getCustomerById(13);
		System.out.println(c1.getName());
//		List<Customer> list = dao.query();
//		System.out.println(list);
		
//		c.setName("Ham");
//		c.setTel("18305180000");
//		c.setId(11);
		
//		dao.delete(12);
	}

}
