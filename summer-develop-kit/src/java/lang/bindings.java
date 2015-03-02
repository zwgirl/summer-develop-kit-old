@java.lang.Module 
package java.lang;

import java.util.ItemsControl;

import org.w3c.dom.Node;
import org.w3c.event.Event;
import org.w3c.event.EventListener;
import org.w3c.html.HTMLElement; 
 
public interface MarkupExtension {
	public Object provideValue (Node target, String property, String targetProperty1);
}

public enum UpdateSourceTrigger {
    /**
     * Update whenever the target property changes 
     */
    PropertyChanged,   
    /**
     * Update only when target element loses focus, or when Binding deactivates
     */
    LostFocus,
    /**
     * Update only by explicit call to BindingExpression.UpdateSource() 
     */
    Explicit
} 

public enum BindingMode
{
    /**
     * Data flows from source to target and vice-versa
     */
    TwoWay, 
    /**
     * Data flows from source to target, source changes cause data flow
     */
    OneWay,
    /**
     * Data flows from source to target once, source changes are ignored 
     */
    OneTime;
}

public final class Binding implements MarkupExtension{
	private BindingMode _mode;
	private UpdateSourceTrigger _updateSourceTrigger;
	private String	_property; 

	public Binding(Object options) {
		if(options["property"] != undefined){
			this._property = (String) options["property"];
		}
		
		if(options["mode"] != undefined){
			this._mode = (BindingMode) options["mode"];
		}
		
		if(options["updateSourceTrigger"] != undefined){
			this._updateSourceTrigger = (UpdateSourceTrigger) options["updateSourceTrigger"];
		}
	} 

	public String property {
		& { 
			return _property; 
		} 
		+ {
			_property = value;
		} 
	} 
	
	public boolean isDirectBinding{
		&{
			return String.isNullOrEmpty(this.property);
		}
	}

	public BindingMode mode {
		& {
			return _mode; 
		} 
		+ { 
			this._mode = value; 
		}
	} 

	  public UpdateSourceTrigger updateSourceTrigger {
	      & { 
	          return _updateSourceTrigger; 
	      }
	      + {
	    	  this._updateSourceTrigger = value;
	      } 
	  }
	  
	  public native Object provideValue (Node target, String targetProperty, String targetProperty1)/*-{
		  var bindingExp = new (__lc('java.lang.BindingExpression'))(target, targetProperty, targetProperty1, this);
		  return bindingExp.value;
	  }-*/;
	  
}

public final class BindingExpression { 
	private Binding _binding;
	private Node _target;
	private String _targetProperty;
	private String _targetProperty1;
	
	public BindingExpression(Node target, String targetProperty, String targetProperty1, Binding binding) { 
  		this._binding = binding;
  		this._targetProperty = targetProperty;
  		this._targetProperty1 = targetProperty1;
  		this._target = target;
  		
  		switch(_binding.mode){
	  		case TwoWay:
	  			if(target instanceof HTMLElement){
		  			attachTarget((HTMLElement)_target, _targetProperty);
	  			}
	  		case OneWay:
	  			_target.dataContext.addBinding(this);
	  		case OneTime:
	  			updateTarget();
  		}
	}
	
//	public BindingExpression(Node target, String targetProperty, String targetProperty1, Binding binding) { 
//  		this._binding = binding;
//  		this._targetProperty = targetProperty;
//  		this._targetProperty = targetProperty1;
//  		this._target = target;
//  		
//  		switch(_binding.mode){
//	  		case TwoWay:
//	  			if(target instanceof HTMLElement){
//		  			attachTarget((HTMLElement)_target, _targetProperty);
//	  			}
//	  		case OneWay:
//	  			_target.dataContext.addBinding(this);
//	  		case OneTime:
//	  			updateTarget();
//  		}
//	}

	public void updateSource() {
		if(_binding.isDirectBinding){
			_target.dataContext.dataItem = _target[this._targetProperty];
		} else {
			_target.dataContext.dataItem[_binding.property] = _target[this._targetProperty];
		}
	}
	
	public Binding binding{
		&{
			return this._binding;
		}
	}

	public void updateTarget() { 
		if(_binding.isDirectBinding){
			_target[_targetProperty] = _target.dataContext.dataItem;
		} else {
			if(_target.dataContext.dataItem != null){
				if(_targetProperty1 == null){
					_target[_targetProperty] = _target.dataContext.dataItem[_binding.property];
				} else {
					_target[_targetProperty][_targetProperty1] = _target.dataContext.dataItem[_binding.property];
				}
			} else {
				if(_targetProperty1 == null){
					_target[_targetProperty] = null;
				} else {
					_target[_targetProperty][_targetProperty1] = null;
				}
			}
		}
	}
	
	public Object value{
		&{
			if(_target.dataContext.dataItem == null){
				return null;
			} else {
				if(_binding.isDirectBinding){
					return _target.dataContext.dataItem;
				} else {
					return _target.dataContext.dataItem[_binding.property];
				}
			}
		}
	}

	public void attachTarget(HTMLElement target, String property){
		// listen for lost focus and input 
		switch(_binding.updateSourceTrigger) { 
			case LostFocus:
				target.addEventListener("blur", this.handle, false);
				break; 
			case PropertyChanged: 
				target.addEventListener("input", this.handle, false);
				break;
			default:
		}  
	}
	
	public EventListener handle = (Event e)->{updateSource();};
	
	public PropertyChange propertyChange = (PropertyChangeEvent e)->{updateTarget();};
	
	public void invalidate(Object data){
		updateTarget();
	}
}

public final class DataContext { 
	private PathMode _mode;
	private String _property;
	private BindingExpression[] _bindings;
	private DataContext[] _dependents;
	private ItemsControl[] _itemControls;
	private Object _dataItem;
	
	@Overload("0")
	public native DataContext() /*-{
		this._mode = __lc("java.lang.PathMode", "java.lang.bindings").Absolute;
//		this._property = null;
		this._bindings = [];
		this._dependents = [];
		this._itemControls = [];
		this._dataItem = __this; 
	}-*/;
	
	@Overload("11")
	public native DataContext(String property) /*-{
		this._mode = __lc("java.lang.PathMode", "java.lang.bindings").Relative;
		this._property = property;
		this._bindings = [];
		this._dependents = [];
		this._itemControls = [];
//		this._dataItem = __this; 
	}-*/;
	
	@Overload("12")
	public native DataContext(Object dataItem) /*-{
		this._mode = __lc("java.lang.PathMode", "java.lang.bindings").Relative;
		this._property = null;
		this._bindings = [];
		this._dependents = [];
		this._itemControls = [];
//		this._dataItem = dataItem; 
	}-*/;
	
	@Overload("2")
	public DataContext(String property, PathMode mode){
//		if(mode == undefined){
//			this._mode = PathMode.Relative;
//		} else {
			this._mode = mode;
//		}
		this._property = property;
		_bindings = new Array<BindingExpression>();
		_dependents = new Array<DataContext>();
		_itemControls = new Array<ItemsControl>();
	}
	
	public String property{
		&{
			return this._property;
		}
		+{
			this._property = value;
		}
	}
	
	public boolean isRelative{
		&{
			return this._mode === PathMode.Relative;
		}
	}
	
	public void addBinding(BindingExpression be){ 
		_bindings.push(be);
		if(this._dataItem instanceof INotifyPropertyChanged){
			if(!be.binding.isDirectBinding){
				((INotifyPropertyChanged) this._dataItem).addListener(be.binding.property, be.propertyChange);
			}
		}
	}
	
	public void removeBinding(BindingExpression dependent){
		_bindings.forEach((BindingExpression be, int index, Array<BindingExpression> array)->{
			if(be == dependent){
				_bindings.splice(index, 1);
				return;
			}
		});
		
		//TODO remove from INotifyPropertyLiistener
	}
	
	public void addItemsControl(ItemsControl ic){ 
		_itemControls.push(ic);
		if(this._dataItem instanceof INotifyPropertyChanged){
			if(!ic.isDirectBinding){
				((INotifyPropertyChanged) this._dataItem).addListener(ic.property, ic.propertyChange);
			}
		}
	}
	
	public void removeItemsControl(ItemsControl dependent){
		_itemControls.forEach((ItemsControl ic, int index, Array<ItemsControl> array)->{
			if(ic == dependent){
				_itemControls.splice(index, 1);
				return;
			}
		});
		
		//TODO remove from INotifyPropertyLiistener
	}
	
	public void addDependent(DataContext dependent){ 
		_dependents.push(dependent);
	}
	
	public void removeDependent(DataContext dependent){
		_dependents.forEach((DataContext dc, int index, Array<DataContext> array)->{
			if(dc === dependent){
				_dependents.splice(index, 1); 
				return;
			}
		});
		
		//TODO remove from INotifyPropertyLiistener
	}
	
	public Object dataItem{
		&{
			return this._dataItem;
		}
		+{
			if(value === this._dataItem)
				return;

			replaceDataItem(value); 
			this._dataItem = value;
			dirty(value);
		}
	}
	
	private void dirty(Object data){
		_bindings.forEach((BindingExpression be, int index, Array<BindingExpression> array)->{
			be.invalidate(data);
		});
		
		_dependents.forEach((DataContext dc, int index, Array<DataContext> array)->{
			dc.invalidate(data);
		});
	}
	 
	private void replaceDataItem(Object newDataItem){
		if(this._dataItem != null && this._dataItem instanceof INotifyPropertyChanged){  
			INotifyPropertyChanged oldPc = (INotifyPropertyChanged) this._dataItem;
			for(int i=0, length = _dependents.length; i<length; i++){
				oldPc.removeListener(_dependents[i].property, _dependents[i]::propertyChange);
			}
			
			for(int i=0, length = _bindings.length; i<length; i++){
				oldPc.removeListener(_bindings[i].binding.property, _bindings[i].propertyChange);
			}
		}
		
		if(newDataItem != null && newDataItem instanceof INotifyPropertyChanged){
			INotifyPropertyChanged newPc = (INotifyPropertyChanged) newDataItem;
			for(int i=0, length = _dependents.length; i<length; i++){
				newPc.addListener(_dependents[i].property, _dependents[i]::propertyChange);
			}
			
			for(int i=0, length = _bindings.length; i<length; i++){
				newPc.addListener(_bindings[i].binding.property, _bindings[i].propertyChange);
			}
		}
	}

	public void propertyChange(PropertyChangeEvent e) {
		this.dataItem = e.newValue;
	}
	
	public void invalidate(Object data){
		if(data == null){
			this.dataItem = null;
		} else {
			this.dataItem = data[this.property];
		}
	}
}

public enum PathMode{
	Relative,
	Absolute;
}

public class DataPath implements MarkupExtension {
	private PathMode _mode;
	private String _property;

	public DataPath(Object options) {
		if(options["property"] != undefined){
			this._property = (String) options["property"];
		}
		
		if(options["mode"] != undefined){
			this._mode = (PathMode) options["mode"];
		}
	}
	
	public PathMode mode {
		&{
			return this._mode;
		}
		+{
			this._mode = value;
		}
	}
	
	public String property {
		&{
			return this._property;
		}
		+{
			this._property = value;
		}
	}
	
	public native DataContext provideValue(Node target, String property, String targetProperty) /*-{
		return new (__lc("java.lang.DataContext"))(this._property, this._mode, '2');
	} -*/;
}


