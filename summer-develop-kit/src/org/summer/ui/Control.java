package org.summer.ui;

import org.w3c.html.HTMLElement;

/**
 * 
 * @author cym
 *
 */
public abstract class Control {
	private HTMLElement _root;
	public HTMLElement Root{
			&{
				return this._root;
			}
		}

	public void create(HTMLElement container){
		
	}
	
	protected void preCreate(){
		
	}
	
	protected void postCreate(){
		
	}
}
