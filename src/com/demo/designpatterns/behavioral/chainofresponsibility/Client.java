package com.demo.designpatterns.behavioral.chainofresponsibility;

public class Client {

	public static void main(String[] args) {

		AuthenticationHandler authHandler = new AuthenticationHandler("qw12345");
		ContentTypeHandler contentTypeHandler = new ContentTypeHandler("application/json");

		PayloadHandler payloadHandler = new PayloadHandler("Body: {\"userName\" = \"John\"}");

		authHandler.next = contentTypeHandler;
		contentTypeHandler.next = payloadHandler;

		String withAuth = authHandler.addHandler("Headers with authentication");

		System.out.println(withAuth);
	}
}
