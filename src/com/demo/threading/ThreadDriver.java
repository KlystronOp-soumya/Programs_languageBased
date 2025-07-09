package com.demo.threading;

class FetchResource {

	void fetch() {

		for (int i = 0; i <= 5; i++) {
			System.out.println("FETCHING............ [" + Thread.currentThread().getName() + " ]"
					+ ((double) (i / 5) * 100) + "%");
		}

	}
}

class T1 implements Runnable {

	private transient FetchResource fetch;

	public T1(final FetchResource fetch) {
		this.fetch = fetch;
	}

	@Override
	public void run() {
		System.out.println("Thread Here:: " + Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("fetchThread1")) {

			try {
				Thread.sleep(5000);
				this.fetch.fetch();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		} else {
			this.fetch.fetch();
		}

	}

}

public class ThreadDriver {

	public static void main(String[] args) {
		try {
			final FetchResource fetchResource = new FetchResource();
			Thread t1 = new Thread(new T1(fetchResource), "fetchThread1");
			Thread t2 = new Thread(new T1(fetchResource), "fetchThread2");
			t1.start();
			t2.start();
			System.out.println("Current thread: " + Thread.currentThread().getName());
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
