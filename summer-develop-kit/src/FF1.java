import org.w3c.html.*;
import org.w3c.dom.*;
import org.summer.ui.*;
import org.w3c.event.Event;
import org.w3c.event.EventListener;
import org.w3c.event.KeyboardEvent;

import java.util.*;
public class FF1 implements INotifyPropertyChanged{ 
	<html>    
		<head>  
		<meta httpEquiv="Content-Type" content="text/html;charset=utf-8" />
			<script > 
				 
			</script> 
			
			<style type="text/css">   
			</style>
		</head>  
		<body onclick = "test"> 
			for dsddsd if do
				
		<p style.border = "5px solid red">
			asasasa
			<br />
			<Text data = {Binding property="style" mode = "OneWay"} />
		</p>
		<p style.border = {Binding property="style" mode = "OneWay"}>
			asasasa
			<br />
			<Text data = {Binding property="style" mode = "OneWay"} />
		</p>
		<table>
		 <caption>  </caption>
		 <thead x:name = "_tttt1">
		   
		 </thead>
		 
		 <tbody>
		 	<input value = "中华人民共和国1" id="1"/>
	 
		 	<tr template = "FirstTemplate">
		 	
		 	<td> <input id="2" value={Binding property="style" mode = "TwoWay" updateSourceTrigger="PropertyChanged"}  onkeydown = "returnNav" /> </td>  
		 	<td> 
			 	<select itemTemplate="SelectTemplate">
			 		Test
			 	</select>
		 	</td> 
		 	</tr>
		 	<tr dataContext = {DataPath mode="Relative" property = "person"} >
		 	<td> <input id="3" value={Binding property="name" mode = "TwoWay" updateSourceTrigger="PropertyChanged"}  /> </td> 
		 	<td> <input id="4" value={Binding property="age" mode = "TwoWay" updateSourceTrigger="PropertyChanged"}  /> </td> 
		 	</tr>
		 	<tr>
		 	</tr>
		 	<tr>
		 	</tr>
		 	<tr>
		 	<td> 
		 	
		 	<button value = "change" onclick = "click"> Test </button> 
		 	</td>  
		 	</tr> 
		 </tbody>
		</table> 
		</body> 
	</html>  
	
	private Object listeners= new Object();
	    
	public FF1(){ 
		String g = ("wqwqwq");  

	}
	   
	private int index = 0;
	
	private Person _person  = new Person("Smith", 98);
	public Person person{
		&{
			return this._person;
		}
	}
	
	private String _style = "5px solid red";
	public String style{
		&{
			return this._style;
		}
		+{ 
			String oldValue = this._style;
			this._style = value;
			if(oldValue != value){
				notify(new PropertyChangeEvent(this, "style", oldValue, value));
			}
		}  
	}
	 
	public EventListener click = (Event event) ->{
		this.name = "tom" + index ++ ;
		alert(event.target.toString());
	};
	
	private String _name1 = "tom"; 
	public String name{
		&{
			return this._name1; 
		}
		+{ 
			String oldValue = this._name1;
			this._name1 = value;
			if(oldValue != value){
				notify(new PropertyChangeEvent(this, "name", oldValue, value));
			}
		}  
	} 
	
	protected void notify(PropertyChangeEvent event){
		PropertyChange[] handlers = (PropertyChange[])listeners[event.propertyName];
		if(handlers != undefined){
			handlers.forEach((PropertyChange value, int index, Array<PropertyChange> array)->{
				value(event);
			});
		}
	}    
	
	EventListener test = (Event event)->{
		if(event.target != ((HTMLDocument)document).body){
			return;
		}
//		alert(event.type);
		this.name = this.name + this.name;
//		ArrayList<String> l = new ArrayList<String>(10);
//		l.add("212121");
//		alert("sasasa");
	};
	
	void f(){

	}
	
	public EventListener returnNav = (Event event)->{
		KeyboardEvent keyEvt = (KeyboardEvent) event;
		if(keyEvt != undefined && keyEvt.target != undefined){ 
			HTMLElement srcEle=(HTMLElement) keyEvt.target; 
			if(keyEvt.keyCode == 13) {
				keyEvt.keyCode=keyEvt.charCode= 9; 
			}
		} 
	};

	public void addListener(String propName, PropertyChange handler) {
		PropertyChange[] handlers = (PropertyChange[])listeners[propName];
		if(handlers == undefined){
			handlers = new Array<PropertyChange>();
			listeners[propName] = handlers;
		}
		handlers.push(handler);
	}

	public void removeListener(String propName, PropertyChange handler) {
		PropertyChange[] handlers = (PropertyChange[])listeners[propName];
		if(handlers != undefined){
			handlers.forEach((PropertyChange value, int index, Array<PropertyChange> array)->{
				if(value === handler){
					handlers.splice(index, 1);
				}
			});
		}
	}
}
 