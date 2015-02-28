package org.summer.ui;

import org.w3c.html.HTMLElement;
import org.w3c.html.div;
import org.w3c.html.input;
import org.w3c.x;

/**
 * 
 * @author cym
 *
 */
public class DatePicker extends Control{
	<input type = "text" x:name = "_input"> 
		<div x:name = "_popup" /> 
	</input>
	
	public void create(HTMLElement container) {
		
	}
	
	HTMLElement input{
		&{
			return this._input;
		}
	}
	
	HTMLElement popup{
		&{
			return this._popup;
		}
	}
	
	class SS{
		<input type = "text" x:name = "_input"> 
			<div x:name = "_popup" /> 
		</input>
	}
}
