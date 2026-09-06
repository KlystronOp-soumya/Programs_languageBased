package com.demo.threading;

import java.time.LocalDateTime;

class RequestContext {
	// Each thread gets its own copy
	private static final ThreadLocal<String> requestId = new ThreadLocal<>();

	public static void setRequestId(String id) {
		requestId.set(id);
	}

	public static String getRequestId() {
		return requestId.get();
	}

	public static void clear() {
		requestId.remove(); // important to avoid memory leaks in thread pools
	}
}

class RequestHandler implements Runnable {

	private final String id;

	public RequestHandler(String id) {
		this.id = id;
	}

	@Override
	public void run() {
		RequestContext.setRequestId(id);

		try {
			// Business logic
			System.out.println("Thread " + Thread.currentThread().getName() + " handling request "
					+ RequestContext.getRequestId() + "at: " + LocalDateTime.now());
		} finally {
			RequestContext.clear(); // cleanup
		}
	}
}

public class ThreadLocalDemo {

	public static void main(String[] args) throws InterruptedException {

		Thread reqT1 = new Thread(new RequestHandler("REQ-1"), "REQT1");
		Thread reqT2 = new Thread(new RequestHandler("REQ-2"), "REQT2");

		reqT1.start();
		reqT2.start();

		reqT1.join();
		reqT2.join();

	}
}
