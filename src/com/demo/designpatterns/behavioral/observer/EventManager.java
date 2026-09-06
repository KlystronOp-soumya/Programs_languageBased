package com.demo.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

	Map<String, List<EventListener>> listeners = new HashMap();

	@SafeVarargs
	public EventManager(String... operations) {

		Arrays.stream(operations).forEach(eachOperation -> listeners.put(eachOperation, new ArrayList<>()));
	}

	public void subscribe(String event, EventListener listener) {

		List<EventListener> subscribersToEvent = this.listeners.get(event);

		if (!subscribersToEvent.contains(listener)) {
			subscribersToEvent.add(listener);
		}
	}

	public void unsubscribe(String event, EventListener listener) {
		List<EventListener> subscribersToEvent = this.listeners.get(event);

		if (subscribersToEvent.contains(listener)) {
			subscribersToEvent.remove(listener);
		}

	}

	public void notify(String event, String file) {
		List<EventListener> subscribersToEvent = this.listeners.get(event);

		subscribersToEvent.forEach(e -> e.notify(event, file));
	}
}
