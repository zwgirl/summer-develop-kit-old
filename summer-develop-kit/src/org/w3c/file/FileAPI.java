@Module
package org.w3c.file;

import org.w3c.event.Event;
import org.w3c.event.EventException;
import org.w3c.event.EventListener;
import org.w3c.event.EventTarget;

public native class File extends Blob {

//  readonly attribute 
	public native String name{}
//  readonly attribute 
	/*Date*/public native long lastModifiedDate{}

}
	
public native interface FileList {
//    getter File? item(unsigned long index);
	public native File this[long index];
//    readonly attribute unsigned 
	public native long length{}
 }


//[Constructor, 
// Constructor(sequence<(ArrayBuffer or ArrayBufferView or Blob or DOMString)> blobParts, optional BlobPropertyBag options), Exposed=Window,Worker] 
public native class Blob {
	public native Blob();
	public native Blob(ArrayBuffer[] blobParts); 
	public native Blob(ArrayBuffer[] blobParts, /*optional*/ Object options); 
	
	public native Blob(ArrayBufferView[] blobParts);
	public native Blob(ArrayBufferView[] blobParts, Object options);
	
	public native Blob(Blob[] blobParts); 	
	public native Blob(Blob[] blobParts, Object options); 
	
	public native Blob(String[] blobParts);
	public native Blob(String[] blobParts, Object options);
					
//	 readonly attribute unsigned 
	public native long size{}
//	readonly attribute 
	public native String type{}
//  readonly attribute 
	public native boolean isClosed{}
  
  //slice Blob into byte-ranged chunks
  
	public native Blob slice();
	public native Blob slice(/*[Clamp] optional */long start);
	public native Blob slice(/*[Clamp] optional */long start, /*[Clamp] optional */ long end);
	public native Blob slice(/*[Clamp] optional */long start, /*[Clamp] optional */ long end, /*optional DOM*/String contentType);
	public native void close(); 

}

//dictionary BlobPropertyBag {
//	
//  DOMString type = "";
//
//};

//[Constructor]
public native class FileReader implements EventTarget {

	public native FileReader();
	// async read methods
	public native void readAsArrayBuffer(Blob blob);
	public native void readAsText(Blob blob);
	public native void readAsText(Blob blob, /*optional*/ String label);
	public native void readAsDataURL(Blob blob);

	public native void abort();

  // states
  	//  const unsigned 
  	public static final short EMPTY = 0;
  	//  const unsigned 
  	public static final short LOADING = 1;
  	//  const unsigned 
  	public static final short DONE = 2;


  	//  readonly attribute unsigned 
  	public native short readyState{}

  	// File or Blob data
  	//  readonly attribute 
//  	(String or ArrayBuffer)? result;
  	public native Object result{}

  	//  readonly attribute 
  	public native DOMError/*?*/ error{}

  // event handler attributes
  	//  attribute 
  	public native EventHandler onloadstart{} 
  	//  attribute 
  	public native EventHandler onprogress{}
  	//  attribute 
  	public native EventHandler onload{}
  	//  attribute 
  	public native EventHandler onabort{}
  	//  attribute 
  	public native EventHandler onerror{}
  	//  attribute 
  	public native EventHandler onloadend{}
  	
	public native void addEventListener(String type, EventListener listener, boolean useCapture);
	public native void removeEventListener(String type, EventListener listener, boolean useCapture);
	public native boolean dispatchEvent(Event evt) throws EventException;

}
