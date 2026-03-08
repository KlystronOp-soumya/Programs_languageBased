package com.demo.designpatterns.abstractfactory;

//The abstraction layer to separate the concerns
//for usual factory we dont need this layer 
public interface DataSourceAbstractFactory {

	Service createService();

	Response createResponse();

}
