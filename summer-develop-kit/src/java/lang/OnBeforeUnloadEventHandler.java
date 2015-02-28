package java.lang;

import org.w3c.event.Event;


@FunctionalInterface
public interface OnBeforeUnloadEventHandler {
	String handle(Event event1);
	
}
