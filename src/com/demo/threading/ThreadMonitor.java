package com.demo.threading;

class DownloadThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Downloading  ");
		for (int i = 0; i < 5; i++) {
			System.out.print("> ");

		}
	}

}

class InstallationThread implements Runnable {

	@Override
	public void run() {
		System.out.println("\nInstalling");

		for (int i = 0; i < 5; i++) {
			System.out.print("=");

		}

	}

}

class MonitorPhase implements Runnable {

	private Thread thread;

	public MonitorPhase(final Thread ranThread) {
		this.thread = ranThread;
	}

	@Override
	public void run() {

		System.out.print("Thread Details->");
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		System.out.println("Thread monitored: " + this.thread.getName() + " State: " + this.thread.getState().name());

	}

}

public class ThreadMonitor {

	public static void main(String[] args) {

		try {

			System.out.println("Main thread is being executed...");

			Thread.sleep(3000);

			System.out.println("Current thread: " + Thread.currentThread().getName());
			System.out.println("Current state: " + Thread.currentThread().getState().name());

			Thread download = new Thread(new DownloadThread());
			download.setName("Thread_Download");
			download.setPriority(Thread.MAX_PRIORITY);

			Thread install = new Thread(new InstallationThread(), "Thread_Install");

			// start the thread download , upon completion start the install thread
			Thread monitorDownload = new Thread(new MonitorPhase(download), "Monitor_Download");
			Thread monitorInstall = new Thread(new MonitorPhase(install), "Monitor_Install");
			monitorDownload.start();
			// monitorInstall.start();
			download.start();

			download.join();
			if (!download.isAlive()) {
				System.out.println("Started installation");
				monitorDownload.join();
				monitorInstall.start();
				install.start();
				install.join();
			}
			monitorInstall.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
