package com.demo.threading;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

class MyCallable<V> implements Callable<V> {

    private final V myVal;

    public MyCallable(V myVal) {
	this.myVal = myVal;
    }

    @Override
    public V call() throws Exception {

	Thread.sleep(Duration.ofSeconds(1));
	System.out.println(this.myVal);

	return myVal;
    }

}

public class CallableDemo {

    public static void main(String[] args) {

	ExecutorService executorService = Executors.newSingleThreadExecutor(); // instead of single thread threadpool
									       // can be used
	// Callable is a Functional interface so lambda can be used or method ref
	Future<String> future = executorService.submit(new MyCallable<String>("John Doe"));

	try {

	    String str = future.get();
	    callableTask();
	} catch (Exception ex) {

	    ex.printStackTrace();
	} finally {
	    executorService.shutdown();
	}

    }

    private static void callableTask() {

	Supplier<Integer> supp = () -> 10;
	// This just for the understanding, directly can be written
	Callable<Integer> callableTask = () -> {

	    int i = supp.get();
	    int sum = 0;
	    
	    while(i-- != 0) {
		sum += i;
	    }
	    
	    return sum;
	};
	
	try(ExecutorService executorService = Executors.newFixedThreadPool(2);) {
	    
	    Future<Integer> future = executorService.submit(callableTask);
	    System.out.println("Sum: " + future.get());
	} catch (Exception ex) {

	    ex.printStackTrace();
	}

    }

}
