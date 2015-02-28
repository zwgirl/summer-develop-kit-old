@Module
package org.w3c.webstorage;
 
import org.w3c.event.Event;

public native interface Storage {
//	readonly attribute unsigned 
	long length{}
	String key(/*unsigned*/ long index);
//	getter 
	String getItem(String key);
//	setter creator 
	void setItem(String key, String value);
//	deleter 
	void removeItem(String key);
	
	void clear();
}


//[Constructor(String type, optional StorageEventInit eventInitDict)]
interface StorageEvent extends Event {
//  readonly attribute 
	String key{}
//  readonly attribute 
	String oldValue{}
//  readonly attribute 
	String newValue{}
//  readonly attribute 
	String url{}
//  readonly attribute 
	Storage storageArea{}
}

//dictionary StorageEventInit : EventInit {
//  String key;
//  String? oldValue;
//  String? newValue;
//  String url;
//  Storage? storageArea;
//}