package com.demo;

class DemoInterface implements MyInterface {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("This is method is overidden since abstract");
	}

}

public class InterfaceDemoDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DemoInterface objDemoInterface = new DemoInterface();
			objDemoInterface.display();
			objDemoInterface.message();
			MyInterface interfaceObj = new DemoInterface();
			interfaceObj.message();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
