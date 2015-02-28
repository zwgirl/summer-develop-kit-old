package java.lang;

import org.w3c.event.Event;


//@FunctionalInterface
public interface OnErrorEventHandler {
	Object handle(String event1);
	Object handle(String event1, String source);
	Object handle(String event1, String source, long lineno);
	Object handle(String event1, String source, long lineno, long column);
	Object handle(String event1, String source, long lineno, long column, Object error);
	
	Object handle(Event event1);
	Object handle(Event event1, String source);
	Object handle(Event event1, String source, long lineno);
	Object handle(Event event1, String source, long lineno, long column);
	Object handle(Event event1, String source, long lineno, long column, Object error);
	
}
