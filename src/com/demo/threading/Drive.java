package com.demo.threading;

public class Drive implements Runnable {

	private Thread t;
	private transient Object obj;

	public Drive(Object obj) {
		// super();
		this.t = new Thread(this);
		this.obj = obj;
	}

	protected void execute() {
		t.start();
	}

	@Override
	public void run() {

		synchronized (obj) {
			Processor processor = (Processor) obj;
			processor.producer();
			processor.consumer();
		}
	}

}
