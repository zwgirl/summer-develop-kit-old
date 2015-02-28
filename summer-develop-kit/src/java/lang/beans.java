@Module
package java.lang;  
  
/**  
 * 
 * @author cym
 *
 */
public function void PropertyChange(PropertyChangeEvent evt);
 
public interface PropertyChangeListener{ 
	void propertyChange(PropertyChangeEvent evt);
}

public interface INotifyPropertyChanged {
	void addListener(String propName, PropertyChange handler);
	void removeListener(String propName, PropertyChange handler);
}

public class PropertyChangeEvent {
    private final String _propertyName;
    private final Object _newValue;
    private final Object _oldValue;
    private final Object _source;
    
    public PropertyChangeEvent(Object source, String propertyName,
                               Object oldValue, Object newValue) {
        this._source = source;
        this._propertyName = propertyName;
        this._newValue = newValue;
        this._oldValue = oldValue;
    }

    public String propertyName{
    	&{ 
    		return this._propertyName; 
    	}
    }


    public Object newValue{ 
    	&{
    		return this._newValue;
    	}
    }


    public Object oldValue{
    	&{
    		return this._oldValue;
    	}
    }
    

    public Object source{
    	&{
    		return this._source;
    	}
    }
}
