@Module
package org.w3c.event;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.views.AbstractView;
//http://www.w3.org/TR/2009/WD-DOM-Level-3-Events-20090908/#events-keyboardevents
//Introduced in DOM Level 2:
public native interface EventTarget {
	public native void addEventListener(final String type, final EventListener listener, final boolean useCapture);
	public native void removeEventListener(final String type, final EventListener listener, final boolean useCapture);
	public native boolean dispatchEvent(final Event evt) throws EventException;
	// Introduced in DOM Level 3:
	public native void addEventListenerNS(final String namespaceURI, 
	                                     final String type, 
	                                     final EventListener listener, 
	                                     final boolean useCapture);
	// Introduced final DOM Level 3:
	public native void removeEventListenerNS(final String namespaceURI, 
	                                        final String type, 
	                                        final EventListener listener, 
	                                        final boolean useCapture);
}

//Introduced final DOM Level 2:
public function void EventListener(final Event evt);

//Introduced final DOM Level 2:
public native interface Event {

	// PhaseType
//	const /*unsigned*/ 
	public native static final short CAPTURING_PHASE = 1;
//	const /*unsigned*/ 
	public static native final short AT_TARGET = 2;
//	const /*unsigned*/ 
	public static native final short BUBBLING_PHASE = 3;
	
//	readonly attribute 
	public native String type{}
//	readonly attribute 
	public native EventTarget target{}
//	readonly attribute 
	public native EventTarget currentTarget{}
//	readonly attribute /*unsigned*/ 
	public native short eventPhase{}
//	readonly attribute 
	public native boolean bubbles{}
//	readonly attribute 
	public native boolean cancelable{}
//	readonly attribute 
	public native /*DOMTimeStamp*/long timeStamp{}
	public native void stopPropagation();
	public native void preventDefault();
	public native void initEvent(final String eventTypeArg, final boolean canBubbleArg, final boolean cancelableArg);
	
	// Introduced in DOM Level 3:
//	readonly attribute 
	public native String namespaceURI{}
	// Introduced in DOM Level 3:
	void stopImmediatePropagation();
	// Introduced in DOM Level 3:
//	readonly attribute 
	public native boolean defaultPrevented{}
	// Introduced in DOM Level 3:
	public native void initEventNS(final String namespaceURIArg, 
                          final String eventTypeArg, 
                          final boolean canBubbleArg, 
                          final boolean cancelableArg);
}

//Introduced final DOM Level 2:
public class EventException extends Exception{
	/*unsigned*/ short code{}

	//EventExceptionCode
//	const /*unsigned*/ 
	public static final short UNSPECIFIED_EVENT_TYPE_ERR = 0;
}

//Introduced in DOM Level 3:
interface CustomEvent extends Event {
//readonly attribute 
	public native String detail{}
	public native void initCustomEvent(final String typeArg, 
                                  final boolean canBubbleArg, 
                                  final boolean cancelableArg, 
                                  final String detailArg);
	public native void initCustomEventNS(final String namespaceURIArg, 
                                    final String typeArg, 
                                    final boolean canBubbleArg, 
                                    final boolean cancelableArg, 
                                    final String detailArg);
}

//Introduced final DOM Level 2:
public native interface DocumentEvent {
	public native Event createEvent(final String eventType) throws DOMException;
	
	// Introduced in DOM Level 3:
	public native boolean canDispatch(final String namespaceURI, 
			final String type);
}

//Introduced final DOM Level 2:
public native interface UIEvent extends Event {
//	readonly attribute 
	public native AbstractView view{}
//	readonly attribute 
	public native long detail{}
	public native void initUIEvent(final String typeArg, 
          final boolean canBubbleArg, 
          final boolean cancelableArg, 
          final AbstractView viewArg, 
          final long detailArg);
	// Introduced final DOM Level 3:
	public native void initUIEventNS(final String namespaceURIArg, 
	        final String typeArg, 
	        final boolean canBubbleArg, 
	        final boolean cancelableArg, 
	        final AbstractView viewArg, 
	        final long detailArg);
}

//Introduced final DOM Level 2:
public native interface MouseEvent extends UIEvent {
//	readonly attribute 
	public native long screenX{}
//	readonly attribute 
	public native long screenY{}
//	readonly attribute 
	public native long clientX{}
//	readonly attribute 
	public native long clientY{}
//	readonly attribute 
	public native boolean ctrlKey{}
//	readonly attribute 
	public native boolean shiftKey{}
//	readonly attribute 
	public native boolean altKey{}
//	readonly attribute 
	public native boolean metaKey{}
//	readonly attribute /*unsigned*/ 
	public native short button{}
//	readonly attribute 
	public native EventTarget relatedTarget{}
	public native void initMouseEvent(final String typeArg, 
			 final boolean canBubbleArg, 
			 final boolean cancelableArg, 
			 final AbstractView viewArg, 
			 final long detailArg, 
			 final long screenXArg, 
			 final long screenYArg, 
			 final long clientXArg, 
			 final long clientYArg, 
			 final boolean ctrlKeyArg, 
			 final boolean altKeyArg, 
			 final boolean shiftKeyArg, 
			 final boolean metaKeyArg, 
			 final /*unsigned*/ short buttonArg, 
			 final EventTarget relatedTargetArg);
	
	// Introduced in DOM Level 3:
	public native boolean getModifierState(final String keyIdentifierArg);
	// Introduced final DOM Level 3:
	public native void initMouseEventNS(final String namespaceURIArg, 
	                                final String typeArg, 
	                                final boolean canBubbleArg, 
	                                final boolean cancelableArg, 
	                                final AbstractView viewArg, 
	                                final long detailArg, 
	                                final long screenXArg, 
	                                final long screenYArg, 
	                                final long clientXArg, 
	                                final long clientYArg, 
	                                final short buttonArg, 
	                                final EventTarget relatedTargetArg, 
	                                final String modifiersListArg);
}

// Introduced in DOM Level 3:
public native interface MouseWheelEvent extends MouseEvent {
//readonly attribute 
	public native long wheelDelta{}
	public native void initMouseWheelEvent(final String typeArg, 
	                                     final boolean canBubbleArg, 
	                                     final boolean cancelableArg, 
	                                     final AbstractView viewArg, 
	                                     final long detailArg, 
	                                     final long screenXArg, 
	                                     final long screenYArg, 
	                                     final long clientXArg, 
	                                     final long clientYArg, 
	                                     final short buttonArg, 
	                                     final EventTarget relatedTargetArg, 
	                                     final String modifiersListArg, 
	                                     final long wheelDeltaArg);
	public native void initMouseWheelEventNS(final String namespaceURIArg, 
	                                     final String typeArg, 
	                                     final boolean canBubbleArg, 
	                                     final boolean cancelableArg, 
	                                     final AbstractView viewArg, 
	                                     final long detailArg, 
	                                     final long screenXArg, 
	                                     final long screenYArg, 
	                                     final long clientXArg, 
	                                     final long clientYArg, 
	                                     final short buttonArg, 
	                                     final EventTarget relatedTargetArg, 
	                                     final String modifiersListArg, 
	                                     final long wheelDeltaArg);
}

//Introduced in DOM Level 3:
public native interface  WheelEvent extends MouseEvent {

// DeltaModeCode
//const unsigned 
	public native static final long DOM_DELTA_PIXEL = 0x00;
//const unsigned 
	public native static final long DOM_DELTA_LINE = 0x01;
//const unsigned 
	public native static final long DOM_DELTA_PAGE = 0x02;

//readonly attribute 
	public native static final long deltaX{}
//readonly attribute 
	public native static final long deltaY{}
//readonly attribute 
	public native static final long deltaZ{}
//readonly attribute unsigned 
	public native static final long   deltaMode{}   
	public native void initWheelEvent(final String typeArg, 
                                          final boolean canBubbleArg, 
                                          final boolean cancelableArg, 
                                          final AbstractView viewArg, 
                                          final long detailArg, 
                                          final long screenXArg, 
                                          final long screenYArg, 
                                          final long clientXArg, 
                                          final long clientYArg, 
                                          final short buttonArg, 
                                          final EventTarget relatedTargetArg, 
                                          final String modifiersListArg, 
                                          final long deltaXArg, 
                                          final long deltaYArg, 
                                          final long deltaZArg, 
                                          final long deltaMode);
	public native void initWheelEventNS(final String namespaceURIArg, 
                                          final String typeArg, 
                                          final boolean canBubbleArg, 
                                          final boolean cancelableArg, 
                                          final AbstractView viewArg, 
                                          final long detailArg, 
                                          final long screenXArg, 
                                          final long screenYArg, 
                                          final long clientXArg, 
                                          final long clientYArg, 
                                          final short buttonArg, 
                                          final EventTarget relatedTargetArg, 
                                          final String modifiersListArg, 
                                          final long deltaXArg, 
                                          final long deltaYArg, 
                                          final long deltaZArg, 
                                          final long deltaMode);
}

//Introduced in DOM Level 3:
public native interface TextEvent extends UIEvent {

//InputModeCode
//const unsigned 
	public native static final long DOM_INPUT_METHOD_UNKNOWN       = 0x00;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_KEYBOARD      = 0x01;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_PASTE         = 0x02;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_DROP          = 0x03;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_IME           = 0x04;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_OPTION        = 0x05;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_HANDWRITING   = 0x06;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_VOICE         = 0x07;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_MULTIMODAL    = 0x08;
//const unsigned 
	public native static final long DOM_INPUT_METHOD_SCRIPT        = 0x09;

//readonly attribute 
	public native String data{}
//readonly attribute unsigned 
	public native long inputMode{}
	public native void initTextEvent(final String typeArg, 
                              final boolean canBubbleArg, 
                              final boolean cancelableArg, 
                              final AbstractView viewArg, 
                              final String dataArg, 
                              final long inputMode);
	public native void initTextEventNS(final String namespaceURIArg, 
                                final String typeArg, 
                                final boolean canBubbleArg, 
                                final boolean cancelableArg, 
                                final AbstractView viewArg, 
                                final String dataArg, 
                                final long inputMode);
}

//Introduced in DOM Level 3:
public native interface KeyboardEvent extends UIEvent {

//KeyLocationCode
//const unsigned long       
	public native static final long DOM_KEY_LOCATION_STANDARD      = 0x00;
//const unsigned long       
	public native static final long DOM_KEY_LOCATION_LEFT          = 0x01;
//const unsigned long      
	public native static final long DOM_KEY_LOCATION_RIGHT         = 0x02;
//const unsigned long       
	public native static final long DOM_KEY_LOCATION_NUMPAD        = 0x03;
//const unsigned long       
	public native static final long DOM_KEY_LOCATION_MOBILE        = 0x04;
//const unsigned long       
	public native static final long DOM_KEY_LOCATION_JOYSTICK      = 0x05;

//readonly attribute 
	public native String keyIdentifier{}               
//readonly attribute unsigned 
	public native long keyLocation{}
//readonly attribute 
	public native boolean ctrlKey{}
//readonly attribute 
	public native boolean shiftKey{}
//readonly attribute 
	public native boolean altKey{}
//readonly attribute 
	public native boolean metaKey{}
//readonly attribute 
	public native boolean repeat{}
	
	public native int keyCode{}
	public native int charCode{}
	public native boolean getModifierState(final String keyIdentifierArg);
	public native void initKeyboardEvent(final String typeArg, 
                                final boolean canBubbleArg, 
                                final boolean cancelableArg, 
                                final AbstractView viewArg, 
                                final String keyIdentifierArg, 
                                final long keyLocationArg, 
                                final String modifiersListArg,
                                final boolean repfinal );
	public native void initKeyboardEventNS(final String namespaceURIArg, 
                                  final String typeArg, 
                                  final boolean canBubbleArg, 
                                  final boolean cancelableArg, 
                                  final AbstractView viewArg, 
                                  final String keyIdentifierArg, 
                                  final long keyLocationArg, 
                                  final String modifiersListArg,
                                  final boolean repeat);
}

// Introduced in DOM Level 3:
public native interface CompositionEvent extends UIEvent {

//readonly attribute 
	public native String data{}
	public native void initCompositionEvent(final String typeArg, 
                           final boolean canBubbleArg, 
                           final boolean cancelableArg, 
                           final AbstractView viewArg, 
                           final String dataArg);
	public native void initCompositionEventNS(final String namespaceURIArg, 
                             final String typeArg, 
                             final boolean canBubbleArg, 
                             final boolean cancelableArg, 
                             final AbstractView viewArg, 
                             final String dataArg);
}

//Introduced final DOM Level 2:
public native interface MutationEvent extends Event {

	// attrChangeType
//	const /*unsigned*/ 
	native static final short MODIFICATION = 1;
//	const /*unsigned*/ 
	native static final short ADDITION = 2;
//	const /*unsigned*/ 
	native static final short REMOVAL = 3;
	
//	readonly attribute 
	public native Node relatedNode{}
//	readonly attribute 
	public native String prevValue{}
//	readonly attribute 
	public native String newValue{}
//	readonly attribute 
	public native String attrName{}
//	readonly attribute /*unsigned*/ 
	public native short attrChange{}
	public native void initMutationEvent(final String typeArg, 
			 final boolean canBubbleArg, 
			 final boolean cancelableArg, 
			 final Node relatedNodeArg, 
			 final String prevValueArg, 
			 final String newValueArg, 
			 final String attrNameArg, 
			 final /*unsigned*/ short attrChangeArg);
	
	  // Introduced in DOM Level 3:
	public native void initMutationEventNS(final String namespaceURIArg, 
	                                         final String typeArg, 
	                                         final boolean canBubbleArg, 
	                                         final boolean cancelableArg, 
	                                         final Node relatedNodeArg, 
	                                         final String prevValueArg, 
	                                         final String newValueArg, 
	                                         final String attrNameArg, 
	                                         final short attrChangeArg);
}

// Introduced in DOM Level 3:
public native interface MutationNameEvent extends MutationEvent {
//  readonly attribute 
	public native String prevNamespaceURI{}
//  readonly attribute 
	public native String prevNodeName{}
  // Introduced in DOM Level 3:
	public native void initMutationNameEvent(final String typeArg, 
		  final boolean canBubbleArg, 
		  final boolean cancelableArg, 
		  final Node relatedNodeArg, 
		  final String prevNamespaceURIArg, 
		  final String prevNodeNameArg);
  // Introduced in DOM Level 3:
	public native void initMutationNameEventNS(final String namespaceURIArg, 
		  final String typeArg, 
		  final boolean canBubbleArg, 
		  final boolean cancelableArg, 
		  final Node relatedNodeArg, 
		  final String prevNamespaceURIArg, 
		  final String prevNodeNameArg);
}


