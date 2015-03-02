@Module
package java.util;

import java.util.List;

import org.w3c.dom.Node;

// Implementation of a dynamic data collection based on generic Collection&lt;T&gt;, 
/// implementing INotifyCollectionChanged to notify listeners
// when items get added, removed or the whole list is refreshed.
public class ObservableCollection<T> implements Collection<T> ,INotifyCollectionChanged, INotifyPropertyChanged 
{ 
    // <summary> 
    // Initializes a new instance of ObservableCollection that is empty and has default initial capacity. 
    // </summary>
    public ObservableCollection()  { super(); } 

    // Initializes a new instance of the ObservableCollection class
    // that contains elements copied from the specified list 
    // <param name="list">The list whose elements are copied to the new list.</param> 
    // The elements are copied onto the ObservableCollection in the
    // same order they are read by the enumerator of the list. 
    // <exception cref="ArgumentNullException"> list is a null reference </exception>
    public ObservableCollection(List<T> list)        
    {
//    	super((list != null) ? new List<T>(list.Count) : list);
        // Workaround for VSWhidbey bug 562681 (tracked by Windows bug 1369339). 
        // We should be able to simply call the base(list) ctor.  But Collection<T> 
        // doesn't copy the list (contrary to the documentation) - it uses the
        // list directly as its storage.  So we do the copying here. 
        //
        CopyFrom(list);
    }

    // Initializes a new instance of the ObservableCollection class that contains 
    // elements copied from the specified collection and has sufficient capacity 
    // to accommodate the number of elements copied.
    // <param name="collection">The collection whose elements are copied to the new list.</param>
    // The elements are copied onto the ObservableCollection in the
    // same order they are read by the enumerator of the collection. 
    // <exception cref="ArgumentNullException"> collection is a null reference </exception> 
    public ObservableCollection(Iterable<T> collection) 
    {
        if (collection == null) 
            throw new Error(0, "collection may not be null!");

        CopyFrom(collection);
    } 

    private void CopyFrom(Iterable<T> collection) 
    { 
        List<T> items = Items;
        if (collection != null && items != null) 
        {
            Iterator<T> enumerator = collection.iterator();
            {
                while (enumerator.hasNext()) 
                {
                    items.add(enumerator.next()); 
                } 
            }
        } 
    }

    // Move item at oldIndex to newIndex. 
    public void Move(int oldIndex, int newIndex)
    { 
        MoveItem(oldIndex, newIndex);
    }

    /// PropertyChanged event (per <see cref="INotifyPropertyChanged" />).
    Object PropertyChangedEventHandler; // INotifyPropertyChanged.PropertyChanged
//    { 
//        add
//        { 
//            PropertyChanged += value; 
//        }
//        remove 
//        {
//            PropertyChanged -= value;
//        }
//    } 
//    #endregion INotifyPropertyChanged implementation


    // Occurs when the collection changes, either by adding or removing an item.
    // see <seealso cref="INotifyCollectionChanged"/> 
    public Object NotifyCollectionChangedEventHandler; // CollectionChanged; 


    // Called by base class Collection&lt;T&gt; when the list is being cleared;
    // raises a CollectionChanged event to any listeners. 
    protected void clearItems() 
    { 
        super.ClearItems(); 
        OnPropertyChanged(CountString);
        OnPropertyChanged(IndexerName);
        OnCollectionReset();
    } 

    // Called by base class Collection&lt;T&gt; when an item is removed from list; 
    // raises a CollectionChanged event to any listeners.
    protected void removeItem(int index)
    {
        T removedItem  = this[index]; 

        super.RemoveItem(index); 

        OnPropertyChanged(CountString);
        OnPropertyChanged(IndexerName); 
        OnCollectionChanged(NotifyCollectionChangedAction.Remove, removedItem, index);
    }

    // Called by base class Collection&lt;T&gt; when an item is added to list;
    // raises a CollectionChanged event to any listeners. 
    protected void insertItem(int index, T item)
    { 
        super.InsertItem(index, item);

        OnPropertyChanged(CountString); 
        OnPropertyChanged(IndexerName);
        OnCollectionChanged(NotifyCollectionChangedAction.Add, item, index); 
    } 

    // Called by base class Collection&lt;T&gt; when an item is set in list;
    // raises a CollectionChanged event to any listeners.
    protected void setItem(int index, T item) 
    {
        T originalItem = this[index]; 
        super.SetItem(index, item);

        OnPropertyChanged(IndexerName);
        OnCollectionChanged(NotifyCollectionChangedAction.Replace, originalItem, item, index);
    }

    // Called by base class ObservableCollection&lt;T&gt; when an item is to be moved within the list; 
    // raises a CollectionChanged event to any listeners. 
    protected void moveItem(int oldIndex, int newIndex) 
    {
        T removedItem = this[oldIndex]; 

        super.RemoveItem(oldIndex); 
        super.InsertItem(newIndex, removedItem); 

        OnPropertyChanged(IndexerName); 
        OnCollectionChanged(NotifyCollectionChangedAction.Move, removedItem, newIndex, oldIndex);
    }


    // Raises a PropertyChanged event (per <see cref="INotifyPropertyChanged" />). 
    protected void onPropertyChanged(PropertyChangeEvent e)
    { 
        if (PropertyChanged != null)
        {
            PropertyChanged(this, e);
        } 
    }

    // Raise CollectionChanged event to any listeners.
    // Properties/methods modifying this ObservableCollection will raise 
    // a collection changed event through this method. 
    // When overriding this method, either call its base implementation
    // or call <see cref="BlockReentrancy"/> to guard against reentrant collection changes.
    protected void OnCollectionChanged(NotifyCollectionChangedEvent e) 
    {
        if (CollectionChanged != null) 
        { 
                CollectionChanged(this, e);
        }
    } 

    // Helper to raise a PropertyChanged event  />). 
    private void OnPropertyChanged(String propertyName) 
    {
        OnPropertyChanged(new PropertyChangeEvent(propertyName));
    }

    // Helper to raise CollectionChanged event to any listeners 
    private void OnCollectionChanged(NotifyCollectionChangedAction action, Object item, int index)
    { 
        OnCollectionChanged(new NotifyCollectionChangedEvent(action, item, index));
    }

    // Helper to raise CollectionChanged event to any listeners
    private void OnCollectionChanged(NotifyCollectionChangedAction action, Object item, int index, int oldIndex) 
    {
        OnCollectionChanged(new NotifyCollectionChangedEvent(action, item, index, oldIndex)); 
    }

    // Helper to raise CollectionChanged event to any listeners 
    private void OnCollectionChanged(NotifyCollectionChangedAction action, Object oldItem, Object newItem, int index) 
    { 
        OnCollectionChanged(new NotifyCollectionChangedEvent(action, newItem, oldItem, index));
    } 

    // Helper to raise CollectionChanged event with action == Reset to any listeners
    private void OnCollectionReset()
    { 
        OnCollectionChanged(new NotifyCollectionChangedEvent(NotifyCollectionChangedAction.Reset)); 
    }

    private final String CountString = "Count"; 

    // This must agree with Binding.IndexerName.  It is declared separately 
    // here so as to avoid a dependency on PresentationFramework.dll. 
    private final String IndexerName = "Item[]";
}

/// Arguments for the CollectionChanged event.
/// A collection that supports INotifyCollectionChangedThis raises this event
/// whenever an item is added or removed, or when the contents of the collection 
/// changes dramatically.
public class NotifyCollectionChangedEvent // extends EventArgs
{ 

    private NotifyCollectionChangedAction _action; 
    private List _newItems, _oldItems;
    private int _newStartingIndex = -1;
    private int _oldStartingIndex = -1;
    
    /// Construct a NotifyCollectionChangedEventArgs that describes a reset change.
    /// <param name="action">The action that caused the event (must be Reset).</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action)
    {
        if (action != NotifyCollectionChangedAction.Reset) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Reset");

        InitializeAdd(action, null, -1); 
    }

    /// Construct a NotifyCollectionChangedEventArgs that describes a one-item change.
    /// <param name="action">The action that caused the event; can only be Reset, Add or Remove action.</param> 
    /// <param name="changedItem">The item affected by the change.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, Object changedItem) 
    { 
        if ((action != NotifyCollectionChangedAction.Add) && (action != NotifyCollectionChangedAction.Remove)
                && (action != NotifyCollectionChangedAction.Reset)) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Reset or NotifyCollectionChangedAction.Remove");

        if (action == NotifyCollectionChangedAction.Reset)
        { 
            if (changedItem != null)
                throw new Error(0, "ResetAction requires null changedItems"); 

            InitializeAdd(action, null, -1);
        } 
        else
        {
            InitializeAddOrRemove(action, new Object[]{changedItem}, -1);
        } 
    }

    /// Construct a NotifyCollectionChangedEventArgs that describes a one-item change.
    /// <param name="action">The action that caused the event.</param>
    /// <param name="changedItem">The item affected by the change.</param>
    /// <param name="index">The index where the change occurred.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, Object changedItem, int index) 
    {
        if ((action != NotifyCollectionChangedAction.Add) && (action != NotifyCollectionChangedAction.Remove) 
                && (action != NotifyCollectionChangedAction.Reset)) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Add or NotifyCollectionChangedAction.Remove or NotifyCollectionChangedAction.Reset");

        if (action == NotifyCollectionChangedAction.Reset)
        {
            if (changedItem != null)
                throw new Error(0, "ResetAction requires null changedItems"); 
            if (index != -1)
                throw new Error(0, "ResetAction requires index minus 1"); 

            InitializeAdd(action, null, -1);
        } 
        else
        {
            InitializeAddOrRemove(action, new Object[]{changedItem}, index);
        } 
    }

    /// <summary> 
    /// Construct a NotifyCollectionChangedEventArgs that describes a multi-item change.
    /// </summary> 
    /// <param name="action">The action that caused the event.</param>
    /// <param name="changedItems">The items affected by the change.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, List changedItems)
    { 
        if ((action != NotifyCollectionChangedAction.Add) && (action != NotifyCollectionChangedAction.Remove)
                && (action != NotifyCollectionChangedAction.Reset)) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Add or NotifyCollectionChangedAction.Remove or NotifyCollectionChangedAction.Reset"); 

        if (action == NotifyCollectionChangedAction.Reset) 
        {
            if (changedItems != null)
                throw new Error(0, "ResetAction requires null changedItems"); 

            InitializeAdd(action, null, -1);
        } 
        else 
        {
            if (changedItems == null) 
                throw new Error(0, "ResetAction requires null changedItems"); 

            InitializeAddOrRemove(action, changedItems, -1);
        } 
    }

    /// <summary> 
    /// Construct a NotifyCollectionChangedEventArgs that describes a multi-item change (or a reset).
    /// </summary> 
    /// <param name="action">The action that caused the event.</param>
    /// <param name="changedItems">The items affected by the change.</param>
    /// <param name="startingIndex">The index where the change occurred.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, List changedItems, int startingIndex) 
    {
        if ((action != NotifyCollectionChangedAction.Add) && (action != NotifyCollectionChangedAction.Remove) 
                && (action != NotifyCollectionChangedAction.Reset)) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Add or NotifyCollectionChangedAction.Remove or NotifyCollectionChangedAction.Reset");

        if (action == NotifyCollectionChangedAction.Reset)
        {
            if (changedItems != null)
                throw new Error(0, "ResetAction requires null changedItems"); 
            if (startingIndex != -1)
                throw new Error(0, "ResetAction requires index minus 1"); 

            InitializeAdd(action, null, -1);
        } 
        else
        {
            if (changedItems == null)
                throw new Error(0, "changedItems may not be null!"); 
            if (startingIndex < -1)
                throw new Error(0, "Index cannot be negative"); 

            InitializeAddOrRemove(action, changedItems, startingIndex);
        } 
    }

    /// Construct a NotifyCollectionChangedEventArgs that describes a one-item Replace event. 
    /// <param name="action">Can only be a Replace action.</param> 
    /// <param name="newItem">The new item replacing the original item.</param> 
    /// <param name="oldItem">The original item that is replaced.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, Object newItem, Object oldItem) 
    {
        if (action != NotifyCollectionChangedAction.Replace)
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Replace");

        InitializeMoveOrReplace(action, new Object[]{newItem}, new Object[]{oldItem}, -1, -1);
    } 

    /// Construct a NotifyCollectionChangedEventArgs that describes a one-item Replace event. 
    /// <param name="action">Can only be a Replace action.</param>
    /// <param name="newItem">The new item replacing the original item.</param>
    /// <param name="oldItem">The original item that is replaced.</param> 
    /// <param name="index">The index of the item being replaced.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, Object newItem, Object oldItem, int index) 
    { 
        if (action != NotifyCollectionChangedAction.Replace)
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Replace"); 

        InitializeMoveOrReplace(action, new Object[]{newItem}, new Object[]{oldItem}, index, index);
    }

    /// Construct a NotifyCollectionChangedEventArgs that describes a multi-item Replace event. 
    /// <param name="action">Can only be a Replace action.</param>
    /// <param name="newItems">The new items replacing the original items.</param> 
    /// <param name="oldItems">The original items that are replaced.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, List newItems, List oldItems)
    {
        if (action != NotifyCollectionChangedAction.Replace) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Replace");
        if (newItems == null) 
            throw new Error(0, "changedItems may not be null!"); 
        if (oldItems == null)
            throw new Error(0, "oldItems may not be null!"); 

        InitializeMoveOrReplace(action, newItems, oldItems, -1, -1);
    }

    /// Construct a NotifyCollectionChangedEventArgs that describes a multi-item Replace event. 
    /// <param name="action">Can only be a Replace action.</param>
    /// <param name="newItems">The new items replacing the original items.</param> 
    /// <param name="oldItems">The original items that are replaced.</param>
    /// <param name="startingIndex">The starting index of the items being replaced.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, List newItems, List oldItems, int startingIndex)
    { 
        if (action != NotifyCollectionChangedAction.Replace)
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Replace"); 
        if (newItems == null) 
            throw new Error(0, "changedItems may not be null!"); 
        if (oldItems == null) 
            throw new Error(0, "oldItems may not be null!"); 

        InitializeMoveOrReplace(action, newItems, oldItems, startingIndex, startingIndex);
    } 

    /// Construct a NotifyCollectionChangedEventArgs that describes a one-item Move event. 
    /// <param name="action">Can only be a Move action.</param> 
    /// <param name="changedItem">The item affected by the change.</param>
    /// <param name="index">The new index for the changed item.</param>
    /// <param name="oldIndex">The old index for the changed item.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, Object changedItem, int index, int oldIndex) 
    {
        if (action != NotifyCollectionChangedAction.Move) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Move"); 
        if (index < 0)
        	throw new Error(0, "Index cannot be negative"); 

        Object[] changedItems= new Object[] {changedItem};
        InitializeMoveOrReplace(action, changedItems, changedItems, index, oldIndex);
    } 

    /// Construct a NotifyCollectionChangedEventArgs that describes a multi-item Move event. 
    /// <param name="action">The action that caused the event.</param> 
    /// <param name="changedItems">The items affected by the change.</param>
    /// <param name="index">The new index for the changed items.</param>
    /// <param name="oldIndex">The old index for the changed items.</param>
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, List changedItems, int index, int oldIndex) 
    {
        if (action != NotifyCollectionChangedAction.Move) 
            throw new Error(0, "Action must be NotifyCollectionChangedAction.Move"); 
        if (index < 0)
            throw new Error(0, "Index cannot be negative"); 

        InitializeMoveOrReplace(action, changedItems, changedItems, index, oldIndex);
    }

    /// Construct a NotifyCollectionChangedEventArgs with given fields (no validation). Used by WinRT marshaling. 
    public NotifyCollectionChangedEvent(NotifyCollectionChangedAction action, List newItems, List oldItems, int newIndex, int oldIndex)
    { 
        _action = action;
        _newItems = (newItems == null) ? null : ArrayList.ReadOnly(newItems);
        _oldItems = (oldItems == null) ? null : ArrayList.ReadOnly(oldItems);
        _newStartingIndex = newIndex; 
        _oldStartingIndex = oldIndex;
    } 

    private void InitializeAddOrRemove(NotifyCollectionChangedAction action, List changedItems, int startingIndex)
    { 
        if (action == NotifyCollectionChangedAction.Add)
            InitializeAdd(action, changedItems, startingIndex);
        else if (action == NotifyCollectionChangedAction.Remove)
            InitializeRemove(action, changedItems, startingIndex); 
    } 

    private void InitializeAdd(NotifyCollectionChangedAction action, List newItems, int newStartingIndex) 
    {
        _action = action;
        _newItems = (newItems == null) ? null : ArrayList.ReadOnly(newItems);
        _newStartingIndex = newStartingIndex; 
    }

    private void InitializeRemove(NotifyCollectionChangedAction action, List oldItems, int oldStartingIndex) 
    {
        _action = action; 
        _oldItems = (oldItems == null) ? null : ArrayList.ReadOnly(oldItems);
        _oldStartingIndex= oldStartingIndex;
    }

    private void InitializeMoveOrReplace(NotifyCollectionChangedAction action, List newItems, List oldItems, int startingIndex, int oldStartingIndex)
    { 
        InitializeAdd(action, newItems, startingIndex); 
        InitializeRemove(action, oldItems, oldStartingIndex);
    } 

    /// The action that caused the event. 
    public NotifyCollectionChangedAction Action
    {
        & { return _action; } 
    }

    /// The items affected by the change.
    public List NewItems
    {
        & { return _newItems; }
    } 

    /// The old items affected by the change (for Replace events). 
    public List OldItems 
    {
        & { return _oldItems; }
    }

    /// The index where the change occurred. 
    public int NewStartingIndex
    { 
        & { return _newStartingIndex; }
    }

    /// The old index where the change occurred (for Move events).
    public int OldStartingIndex 
    {
        & { return _oldStartingIndex; } 
    }

} 

public enum NotifyCollectionChangedAction{
	Add,
	Move,
	Remove,
	Replace,
	Reset;
}

public interface INotifyCollectionChanged {
	public void addCollectionChangedListener(CollectionChanged listener);
	public void removeCollectionChangedListener(CollectionChanged listener);
}

public function void CollectionChanged(NotifyCollectionChangedEvent event);

public class Config implements MarkupExtension{
	private Class<ItemsControl> _itemControlClazz;
	private ItemTemplate _template;
	private String _path;   //property
	
	public Config(ItemTemplate template){
		this(template, ItemsControl.class);
	}
	
	public Config(ItemTemplate template, Class<ItemsControl> itemsControlClazz){
		this._itemControlClazz = itemsControlClazz;
		this._template = template;
	}
	
	public native Object provideValue(Node target, String property, String targetProperty1) /*-{
		var r = new (itemControl.factory)(target, this._path, this._template);
		r.expand();
		return r;
	}-*/;
}

public class ItemsControl {
	private ItemTemplate itemTemplate;
	private Node container;
	private String path;
	
	private Object _dataItem;
	protected java.lang.Map<Object, Node> nodesMap = new java.lang.Map<Object, Node>();
	
	public ItemsControl(Node container, String path, ItemTemplate itemTemplate){
		this.itemTemplate = itemTemplate;
		this.container = container;
		this.path = path;
		
		container.dataContext.addItemsControl(this);
		if(container.dataContext.dataItem == null){
			this.dataItem = null;
		} else {
			this.dataItem = container.dataContext.dataItem[path];
		}
	}
	
	public Object dataItem{
		&{
			return this._dataItem;
		}
		+{
			if(this._dataItem === value){
				return;
			}
			if(this._dataItem != null){
				if(this._dataItem instanceof ObservableCollection){
					((ObservableCollection)this._dataItem).removeCollectionChangedListener(this.onCollectionChanged);
				}
			}

			this._dataItem = value;
			
			if(this._dataItem != null){
				if(this._dataItem instanceof ObservableCollection){
					((ObservableCollection)this._dataItem).addCollectionChangedListener(this.onCollectionChanged);
				}
				
				expand();
			}
		}
	}
	
	public void expand(){
		DataContext data = container.dataContext;
		if(data.dataItem instanceof Collection){
			for(Object obj : (Collection)data.dataItem){
				Node node = itemTemplate.create(container, obj);
				nodesMap.set(obj, node);
				container.appendChild(node);
			}
		}
	}
	
	public void invalidate(){
		if(container.dataContext.dataItem == null){
			this._dataItem = null;
		} else {
			this._dataItem = container.dataContext.dataItem[path];
		}
	}
	
	protected CollectionChanged onCollectionChanged = (NotifyCollectionChangedEvent event) ->{
		switch(event.Action){
		case Add:
			List items = event.NewItems;
			for(Object item : items){
				Node root = itemTemplate.createRoot(container);
				container.appendChild(root);
				itemTemplate.createChild(root);
			}
		case Remove:
			List items1 = event.NewItems;
			for(Object item : items1){
				Node child = nodesMap.get(item);
				container.removeChild(child);
			}

		case Replace:
		case Move:
		case Reset:
		}
	};
	
	public PropertyChange propertyChange = (PropertyChangeEvent event)->{
		this.dataItem = event.newValue;
	};
}