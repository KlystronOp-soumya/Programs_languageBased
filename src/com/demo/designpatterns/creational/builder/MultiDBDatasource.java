package com.demo.designpatterns.creational.builder;

import java.time.Duration;

public final class MultiDBDatasource {

	private String connectionString;
	private String databaseUrl;
	private String username;
	private String password;

	private Duration maxTimeOut;
	private Duration minTimeOut;
	private Integer maxPoolSize = 20;
	private Integer minPoolSize = 5;

	private MultiDBDatasource(MultiDBDataSourceBuilder builder) {
		this.connectionString = builder.connectionString;
		this.databaseUrl = builder.databaseUrl;
		this.username = builder.username;
		this.password = builder.password;
		this.maxTimeOut = builder.maxTimeOut;
		this.minTimeOut = builder.minTimeOut;
		this.maxPoolSize = builder.maxPoolSize;
		this.minPoolSize = builder.minPoolSize;
	}

	public void afterPropertiesSet() {

		if (databaseUrl == null || databaseUrl.isBlank()) {
			throw new IllegalStateException("databaseUrl must not be null");
		}

		if (username == null || username.isBlank()) {
			throw new IllegalStateException("username must not be null");
		}

		if (password == null || password.isBlank()) {
			throw new IllegalStateException("password must not be blank");
		}

		if (maxPoolSize < minPoolSize) {
			throw new IllegalStateException("maxPoolSize must be >= minPoolSize");
		}

		if (maxTimeOut != null && minTimeOut != null && maxTimeOut.compareTo(minTimeOut) < 0) {
			throw new IllegalStateException("maxTimeOut must be greater than minTimeOut");
		}
	}

	public static MultiDBDataSourceBuilder builder() {
		return new MultiDBDataSourceBuilder();
	}

	public static class MultiDBDataSourceBuilder {

		private String connectionString;
		private String databaseUrl;
		private String username;
		private String password;

		private Duration maxTimeOut;
		private Duration minTimeOut;
		private Integer maxPoolSize = 20;
		private Integer minPoolSize = 5;

		private MultiDBDataSourceBuilder() {
		}

		public MultiDBDataSourceBuilder connectionString(String connectionString) {
			this.connectionString = connectionString;
			return this;
		}

		public MultiDBDataSourceBuilder databaseUrl(String databaseUrl) {
			this.databaseUrl = databaseUrl;
			return this;
		}

		public MultiDBDataSourceBuilder username(String username) {
			this.username = username;
			return this;
		}

		public MultiDBDataSourceBuilder password(String password) {
			this.password = password;
			return this;
		}

		public MultiDBDataSourceBuilder maxTimeOut(Duration maxTimeOut) {
			this.maxTimeOut = maxTimeOut;
			return this;
		}

		public MultiDBDataSourceBuilder minTimeOut(Duration minTimeOut) {
			this.minTimeOut = minTimeOut;
			return this;
		}

		public MultiDBDataSourceBuilder maxPoolSize(Integer maxPoolSize) {
			this.maxPoolSize = maxPoolSize;
			return this;
		}

		public MultiDBDataSourceBuilder minPoolSize(Integer minPoolSize) {
			this.minPoolSize = minPoolSize;
			return this;
		}

		public MultiDBDatasource build() {

			MultiDBDatasource ds = new MultiDBDatasource(this);// use this to pass the calling object, similar 'self'

			// lifecycle validation
			ds.afterPropertiesSet();

			return ds;
		}
	}
}
