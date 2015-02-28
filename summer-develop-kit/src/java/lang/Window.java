@Module
package java.lang;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.event.Event;
import org.w3c.event.EventException;
import org.w3c.event.EventListener;
import org.w3c.event.EventTarget;
import org.w3c.file.Blob;

/**
 * from javascript
 * @author cym
 *	user cann't implements this public native interface
 */
public native interface Global {  
	public native Number NaN{}
	
	public native Number Infinity{} 
	
	public native Object undefined{} 
	
	public native String decodeURI(String URIString); 
	
	public native String decodeURIComponent(String encodedURIString);
	
	public native String encodeURI(String URIString);
	
	public native String encodeURIComponent(String encodedURIString);
	
	public native String escape(String charString);
	
	public native void eval(String codeString);
	
	public native boolean isFinite(Number number);
	
	public native boolean isNaN(Number number);
	
	public native Number parseFloat(Number numString);
	
	public native Number parseInt(Number numString);

	public native String unescape(String charString);
	
}

/*sealed*/ public native interface Window extends EventTarget {
	  // the current browsing context
//	  [Unforgeable] readonly attribute 
	  public native Window window{}
//	  [Replaceable] readonly attribute 
	  public native Window self{}
//	  [Unforgeable] readonly attribute 
	  public native Document document{}
//	           attribute String 
	  public native String name{}
//	  [PutForwards=href, Unforgeable] readonly attribute 
	  public native Location location{}
//	  readonly attribute 
	  public native History history{}
//	  [Replaceable] readonly attribute 
	  public native BarProp locationbar{}
//	  [Replaceable] readonly attribute
	  public native BarProp menubar{}
//	  [Replaceable] readonly attribute 
	  public native BarProp personalbar{}
//	  [Replaceable] readonly attribute 
	  public native BarProp scrollbars{}
//	  [Replaceable] readonly attribute 
	  public native BarProp statusbar{}
//	  [Replaceable] readonly attribute 
	  public native BarProp toolbar{}
//	           attribute String 
	  public native String status{}
	  public native void close();
//	  readonly attribute 
	  public native boolean closed{}
	  public native void stop();
	  public native void focus();
	  public native void blur();

	  // other browsing contexts
//	  [Replaceable] readonly attribute
	  public native Window frames{}
//	  [Replaceable] readonly attribute unsigned 
	  public native long length{}
//	  [Unforgeable] readonly attribute 
	  public native Window top{}
//	           attribute 
	  public native Window/*?*/ opener{}
//	  readonly attribute 
	  public native Window parent{}
//	  readonly attribute 
	  public native Element/*?*/ frameElement{}
	  public native Window open();
	  public native Window open(String url);
	  public native Window open(String url, String target);
	  public native Window open(String url, String target, String features);
	  public native Window open(String url, String target, String features, boolean replace);
//	  getter WindowProxy (unsigned long index);
	  public native Window this[int index];
//	  getter object (String name);

	  // the user agent
//	  readonly attribute 
	  public native Navigator navigator{}
//	  readonly attribute 
	  public native External external{}
//	  readonly attribute 
	  public native ApplicationCache applicationCache{}

	  // user prompts
	  public native void alert();
	  public native void alert(String message);
	  public native boolean confirm();
	  public native boolean confirm(String message);
	  public native String prompt();
	  public native String prompt(String message);
	  public native String prompt(String message, String default1);
	  public native void print();

	  //GlobalEventHandlers
	  public native EventHandler onabort{}
	  public native EventHandler onblur{}
	  public native EventHandler oncancel{}
	  public native EventHandler oncanplay{}
	  public native EventHandler oncanplaythrough{}
	  public native EventHandler onchange{}
	  public native EventHandler onclick{}
	  public native EventHandler oncuechange{}
	  public native EventHandler ondblclick{}
	  public native EventHandler ondurationchange{}
	  public native EventHandler onemptied{}
	  public native EventHandler onended{}
	  public native OnErrorEventHandler onerror{}
	  public native EventHandler onfocus{}
	  public native EventHandler oninput{}
	  public native EventHandler oninvalid{}
	  public native EventHandler onkeydown{}
	  public native EventHandler onkeypress{}
	  public native EventHandler onkeyup{}
	  public native EventHandler onload{}
	  public native EventHandler onloadeddata{}
	  public native EventHandler onloadedmetadata{}
	  public native EventHandler onloadstart{}
	  public native EventHandler onmousedown{}
	  //[LenientThis] 
	  public native EventHandler onmouseenter{}
	  //[LenientThis] 
	  public native EventHandler onmouseleave{}
	  public native EventHandler onmousemove{}
	  public native EventHandler onmouseout{}
	  public native EventHandler onmouseover{}
	  public native EventHandler onmouseup{}
	  public native EventHandler onmousewheel{}
	  public native EventHandler onpause{}
	  public native EventHandler onplay{}
	  public native EventHandler onplaying{}
	  public native EventHandler onprogress{}
	  public native EventHandler onratechange{}
	  public native EventHandler onreset{}
	  public native EventHandler onresize{}
	  public native EventHandler onscroll{}
	  public native EventHandler onseeked{}
	  public native EventHandler onseeking{}
	  public native EventHandler onselect{}
	  public native EventHandler onshow{}
	  public native EventHandler onstalled{}
	  public native EventHandler onsubmit{}
	  public native EventHandler onsuspend{}
	  public native EventHandler ontimeupdate{}
	  public native EventHandler ontoggle{}
	  public native EventHandler onvolumechange{}
	  public native EventHandler onwaiting{}
	
	  //WindowEventHandlers
	  public native EventHandler onafterprint{}
	  public native EventHandler onbeforeprint{}
	  public native OnBeforeUnloadEventHandler onbeforeunload{}
	  public native EventHandler onhashchange{}
	  public native EventHandler onmessage{}
	  public native EventHandler onoffline{}
	  public native EventHandler ononline{}
	  public native EventHandler onpagehide{}
	  public native EventHandler onpageshow{}
	  public native EventHandler onpopstate{}
	  public native EventHandler onstorage{}
	  public native EventHandler onunload{}

	  public native Console console{}
  
	  public native String btoa(String btoa);
	  public native String atob(String atob);
	  
	  public native long setTimeout(Function handler);
	  public native long setTimeout(Function handler, long timeout);
	  public native long setTimeout(Function handler, long timeout, Object... arguments);
	  public native long setTimeout(String handler);
	  public native long setTimeout(String handler, long timeout);
	  public native long setTimeout(String handler, long timeout, Object... arguments);

	  public native void clearTimeout(long handle);

	  public native long setInterval(Function handler);
	  public native long setInterval(Function handler, long timeout);
	  public native long setInterval(Function handler, long timeout, Object... arguments);

	  public native long setInterval(String handler);
	  public native long setInterval(String handler, long timeout);
	  public native long setInterval(String handler, long timeout, Object... arguments);

	  public native void clearInterval(long handle);
}

////[NoInterfaceObject]
//public interface WindowBase64 {
//	public native String btoa(String btoa);
//	public native String atob(String atob);
//}


////[NoInterfaceObject]
//public native interface WindowTimers {
//	public native long setTimeout(Function handler);
//	public native long setTimeout(Function handler, long timeout);
//	public native long setTimeout(Function handler, long timeout, Object... arguments);
//	public native long setTimeout(String handler);
//	public native long setTimeout(String handler, long timeout);
//	public native long setTimeout(String handler, long timeout, Object... arguments);
//
//	public native void clearTimeout(long handle);
//
//	public native long setInterval(Function handler);
//	public native long setInterval(Function handler, long timeout);
//	public native long setInterval(Function handler, long timeout, Object... arguments);
//
//	public native long setInterval(String handler);
//	public native long setInterval(String handler, long timeout);
//	public native long setInterval(String handler, long timeout, Object... arguments);
//
//	public native void clearInterval(long handle);
//}
//Window implements WindowTimers;

public function void EventHandler(Event event);


public native interface ApplicationCache extends EventTarget {

	  // update status
//	  const unsigned 
	  public native short UNCACHED{} // = 0;
//	  const unsigned 
	  public native short IDLE{} // = 1;
//	  const unsigned 
	  public native short CHECKING{} // = 2;
//	  const unsigned 
	  public native short DOWNLOADING{} // = 3;
//	  const unsigned 
	  public native short UPDATEREADY{} // = 4;
//	  const unsigned 
	  public native short OBSOLETE{} // = 5;
//	  readonly attribute unsigned 
	  public native short status{};

	  // updates
	  public native void update();
	  public native void abort();
	  public native void swapCache();

	  // events
      public native EventHandler onchecking{}
      public native EventHandler onerror{}
      public native EventHandler onnoupdate{}
      public native EventHandler ondownloading{}
      public native EventHandler onprogress{}
      public native EventHandler onupdateready{}
      public native EventHandler oncached{}
      public native EventHandler onobsolete{}
      
      //WindowBase64
      public native String btoa(String btoa);
      public native String atob(String atob);
      
      //WindowTimers
      public native long setTimeout(Function handler);
      public native long setTimeout(Function handler, long timeout);
      public native long setTimeout(Function handler, long timeout, Object... arguments);
      public native long setTimeout(String handler);
      public native long setTimeout(String handler, long timeout);
      public native long setTimeout(String handler, long timeout, Object... arguments);
      
      public native void clearTimeout(long handle);
      
      public native long setInterval(Function handler);
      public native long setInterval(Function handler, long timeout);
      public native long setInterval(Function handler, long timeout, Object... arguments);
      
      public native long setInterval(String handler);
      public native long setInterval(String handler, long timeout);
      public native long setInterval(String handler, long timeout, Object... arguments);
      
      public native void clearInterval(long handle);
}

public native interface BarProp {
	 public native boolean visible{};
}

public native interface External {
	public native void AddSearchProvider(String engineURL);
	public native long IsSearchProviderInstalled(String engineURL);
}

//Window implements WindowBase64;

////	Window implements GlobalEventHandlers;
////	Window implements WindowEventHandlers;
//public native interface GlobalEventHandlers {
//    public native EventHandler onabort{}
//    public native EventHandler onblur{}
//    public native EventHandler oncancel{}
//    public native EventHandler oncanplay{}
//    public native EventHandler oncanplaythrough{}
//    public native EventHandler onchange{}
//    public native EventHandler onclick{}
//    public native EventHandler oncuechange{}
//    public native EventHandler ondblclick{}
//    public native EventHandler ondurationchange{}
//    public native EventHandler onemptied{}
//    public native EventHandler onended{}
//    public native OnErrorEventHandler onerror{}
//    public native EventHandler onfocus{}
//    public native EventHandler oninput{}
//    public native EventHandler oninvalid{}
//    public native EventHandler onkeydown{}
//    public native EventHandler onkeypress{}
//    public native EventHandler onkeyup{}
//    public native EventHandler onload{}
//    public native EventHandler onloadeddata{}
//    public native EventHandler onloadedmetadata{}
//    public native EventHandler onloadstart{}
//    public native EventHandler onmousedown{}
////[LenientThis] 
//	public native EventHandler onmouseenter{}
////[LenientThis] 
//	public native EventHandler onmouseleave{}
//    public native EventHandler onmousemove{}
//    public native EventHandler onmouseout{}
//    public native EventHandler onmouseover{}
//    public native EventHandler onmouseup{}
//    public native EventHandler onmousewheel{}
//    public native EventHandler onpause{}
//    public native EventHandler onplay{}
//    public native EventHandler onplaying{}
//    public native EventHandler onprogress{}
//    public native EventHandler onratechange{}
//    public native EventHandler onreset{}
//    public native EventHandler onresize{}
//    public native EventHandler onscroll{}
//    public native EventHandler onseeked{}
//    public native EventHandler onseeking{}
//    public native EventHandler onselect{}
//    public native EventHandler onshow{}
//    public native EventHandler onstalled{}
//    public native EventHandler onsubmit{}
//    public native EventHandler onsuspend{}
//    public native EventHandler ontimeupdate{}
//    public native EventHandler ontoggle{}
//    public native EventHandler onvolumechange{}
//    public native EventHandler onwaiting{}
//}
//
//public native interface WindowEventHandlers {
//    public native EventHandler onafterprint{}
//    public native EventHandler onbeforeprint{}
//    public native OnBeforeUnloadEventHandler onbeforeunload{}
//    public native EventHandler onhashchange{}
//    public native EventHandler onmessage{}
//    public native EventHandler onoffline{}
//    public native EventHandler ononline{}
//    public native EventHandler onpagehide{}
//    public native EventHandler onpageshow{}
//    public native EventHandler onpopstate{}
//    public native EventHandler onstorage{}
//    public native EventHandler onunload{}
//}

//
//@FunctionalInterface
//public native interface FrameRequestCallback {
//	void sample(/*in DOMTimeStamp*/long time);
//}
//
//native class MessagePort implements EventTarget {
//	public native void postMessage(Object message);
//	public native void postMessage(Object message, /*optional*/ Array<Transferable> transfer);
//	public native void start();
//	public native void close();
//
//	// event handlers
//	/*attribute*/public EventHandler onmessage;
//}
//

public native interface Location {
	public native void assign(String url);
	public native void replace(String url);
	public native void reload();
}

public native interface History {
	/*readonly attribute*/
	public native long length{}
	/*readonly attribute*/
	public native Object state{}
	public native void go(/*optional long delta*/);
	public native void go(long delta);
	public native void back();
	public native void forward();
	public native void pushState(Object data, String title/*, optional String? url = null*/);
	public native void pushState(Object data, String title, String url);
  
	public native void replaceState(Object data, String title/*, optional String? url = null*/);
	public native void replaceState(Object data, String title, String url);
}

public native interface Navigator extends NavigatorID, NavigatorLanguage, NavigatorOnLine, NavigatorContentUtils, 
		NavigatorStorageUtils, NavigatorPlugins{
	  // objects implementing this public native interface also implement the interfaces given below
	}
//	Navigator implements NavigatorID;
//	Navigator implements NavigatorLanguage;
//	Navigator implements NavigatorOnLine;
//	Navigator implements NavigatorContentUtils;
//	Navigator implements NavigatorStorageUtils;
//	Navigator implements NavigatorPlugins;

	
//	[NoInterfaceObject]
	public interface NavigatorID {
//	  readonly attribute 
		public native String appCodeName{} // constant "Mozilla"
//	  readonly attribute 
		public native String appName{}
//	  readonly attribute 
		public native String appVersion{}
//	  readonly attribute 
		public native String platform{}
//	  readonly attribute 
		public native String product{} // constant "Gecko"
		boolean taintEnabled(); // constant false
//	  readonly attribute 
		public native String userAgent{}
	}
	
//	[NoInterfaceObject]
	public interface NavigatorLanguage {
//	  readonly attribute 
		public native String/*?*/ language{}
	}
	
//	[NoInterfaceObject]
	public interface NavigatorOnLine {
//	  readonly attribute 
		public native boolean onLine{}
	}
	
//	[NoInterfaceObject]
	public interface NavigatorContentUtils {
	  // content handler registration
		public native void registerProtocolHandler(String scheme, String url, String title);
		public native void registerContentHandler(String mimeType, String url, String title);
		public native void unregisterProtocolHandler(String scheme, String url);
		public native void unregisterContentHandler(String mimeType, String url);
	}
	
//	[NoInterfaceObject]
	public interface NavigatorStorageUtils {
//	  readonly attribute 
	  public native boolean cookieEnabled{}
	  public native void yieldForStorageUpdates();
	}
	
//	[NoInterfaceObject]
	public native interface NavigatorPlugins {
//	  readonly attribute 
		public native PluginArray plugins{}
//	  readonly attribute 
		public native MimeTypeArray mimeTypes{}
//	  readonly attribute 
		public native boolean javaEnabled{}
	}

	public native interface PluginArray {
		public native void refresh(/*optional boolean reload = false*/);
		public native void refresh(boolean reload);
//	  	readonly attribute unsigned 
		public native long length{}
//	  	getter Plugin? item(unsigned long index);
		public native Plugin this[long index]{}
//	  	getter Plugin? namedItem(String name);
		public native Plugin this[String nam]{}
	}

	public native interface MimeTypeArray {
//	  readonly attribute unsigned 
		public native long length{}
//	  getter MimeType? item(unsigned long index);
		public native MimeType this[long index]{}
//	  getter MimeType? namedItem(String name);
	    public native MimeType this[String nam]{}
	}

	public native interface Plugin {
//	  readonly attribute 
	  public native String name{}
//	  readonly attribute 
	  public native String description{}
//	  readonly attribute 
	  public native String filename{}
//	  readonly attribute unsigned 
	  public native long length{}
//	  getter 
	  public native MimeType this[long index]{}
//	  getter MimeType? namedItem(String name);
	  public native MimeType this[String name];
	}

	public native interface MimeType {
//	  readonly attribute 
		public native String type{}
//	  readonly attribute 
		public native String description{}
//	  readonly attribute 
		public native String suffixes{} // comma-separated
//	  readonly attribute 
		public native Plugin enabledPlugin{}
	}
	
	public native interface Console{
		public native void error(Object ... pars);
		public native void info(Object ... pars);
		public native void log(Object ... pars);
		public native void trace(Object ... pars);
		public native void warn(Object ... pars);
	}
	
	

////	[NoInterfaceObject]
//	public interface XMLHttpRequestEventTarget extends EventTarget {
//	  // event handlers
////	  attribute 
//		public EventHandler onloadstart{}
////	  attribute 
//		public EventHandler onprogress{}
////	  attribute 
//		public EventHandler onabort{}
////	  attribute 
//		public EventHandler onerror{}
////	  attribute 
//		public EventHandler onload{}
////	  attribute 
//		public EventHandler ontimeout{}
////	  attribute 
//		public EventHandler onloadend{}
//	}

	public interface XMLHttpRequestUpload extends EventTarget/*XMLHttpRequestEventTarget*/ {
		  // event handlers
//		  attribute 
			public EventHandler onloadstart{}
//		  attribute 
			public EventHandler onprogress{}
//		  attribute 
			public EventHandler onabort{}
//		  attribute 
			public EventHandler onerror{}
//		  attribute 
			public EventHandler onload{}
//		  attribute 
			public EventHandler ontimeout{}
//		  attribute 
			public EventHandler onloadend{}
	}
//
//	enum XMLHttpRequestResponseType {
//	  "",
//	  "arraybuffer",
//	  "blob",
//	  "document",
//	  "json",
//	  "text"
//	};

//	[Constructor]
	public native class XMLHttpRequest implements EventTarget/*XMLHttpRequestEventTarget*/ {
		// event handler
//		attribute 
		public EventHandler onreadystatechange{}

		// states
//		const unsigned 
		public static final short UNSENT = 0;
//		const unsigned 
		public static final short OPENED = 1;
//		const unsigned 
		public static final short HEADERS_RECEIVED = 2;
//		const unsigned 
		public static final short LOADING = 3;
//		const unsigned 
		public static final short DONE = 4;
//		readonly attribute unsigned 
		public short readyState{}

		// request
		public native void open(String method, String url);
		public native void open(String method, String url, boolean async);
		public native void open(String method, String url, boolean async, String username);
		public native void open(String method, String url, boolean async, String username, String password);
		public native void setRequestHeader(String header, String value);
//        attribute unsigned 
		public native long timeout{}
//        attribute 
		public native boolean withCredentials{}
//	    readonly attribute 
		public native XMLHttpRequestUpload upload{}
		public native void send();
	    public native void send(ArrayBufferView data); 
	    public native void send(Blob data);
	    public native void send(Document data);
	    public native void send(String data);
	    public native void send(FormData data);
	    public native void abort();

	    // response
//	    readonly attribute unsigned 
	    public native short status{}
//	    readonly attribute 
	    public native String statusText{}
	    public native String getResponseHeader(String header);
	    public native String getAllResponseHeaders();
	    public native void overrideMimeType(String mime);
//	    attribute 
	    public native /*XMLHttpRequestResponseType*/String responseType{}
//	    readonly attribute 
	    public native Object response{}
//	    readonly attribute 
	    public native String responseText{}
//	    readonly attribute 
	    public native Document responseXML{}

	    public native void addEventListener(String type, EventListener listener, boolean useCapture);
	    public native void removeEventListener(String type, EventListener listener, boolean useCapture);
	    public native boolean dispatchEvent(Event evt) throws EventException;
	    
		  // event handlers
//		  attribute 
			public EventHandler onloadstart{}
//		  attribute 
			public EventHandler onprogress{}
//		  attribute 
			public EventHandler onabort{}
//		  attribute 
			public EventHandler onerror{}
//		  attribute 
			public EventHandler onload{}
//		  attribute 
			public EventHandler ontimeout{}
//		  attribute 
			public EventHandler onloadend{}

			public native  void addEventListenerNS(String namespaceURI, String type,
					EventListener listener, boolean useCapture);
			public native void removeEventListenerNS(String namespaceURI, String type,
					EventListener listener, boolean useCapture);
	}
	
	public native class FormData {
		public native FormData();
		public native void append(String name, Blob value, String filename);
		public native void append(String name, String value);
	}
