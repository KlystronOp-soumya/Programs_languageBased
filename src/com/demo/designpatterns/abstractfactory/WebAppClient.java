package com.demo.designpatterns.abstractfactory;

import java.util.Optional;

public class WebAppClient {

	private Service service;
	private Response response;

	public WebAppClient(final DataSourceAbstractFactory dataSourceAbstractFactory) {

		this.service = dataSourceAbstractFactory.createService();
		this.response = dataSourceAbstractFactory.createResponse();

	}

	public void communicate() {

		Optional.ofNullable(this.service.createService()).ifPresent(System.out::println);
		Optional.ofNullable(this.response.getResponse()).ifPresent(System.out::println);
	}

	public static void main(String[] args) {
		WebAppClient webAppClient = new WebAppClient(new DatabaseFactory());
		webAppClient.communicate();
	}

}
