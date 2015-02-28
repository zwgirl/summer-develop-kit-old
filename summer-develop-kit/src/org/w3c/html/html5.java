@Module
package org.w3c.html;

import org.w3c.dom.DOMStringList;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.event.Event;
import org.w3c.event.EventListener;
import org.w3c.event.EventTarget;
import org.w3c.event.MouseEvent;
import org.w3c.file.File;
import org.w3c.range.Range;
import org.w3c.views.AbstractView;
import org.w3c.webstorage.Storage;

/*
 * Copyright 2004-2009 Apple Computer, Inc., Mozilla Foundation, and Opera Software ASA.
 * You are granted a license to use, reproduce and create derivative works of this document.
 *
 * See HTML 5 Draft Recommendation 鈥� 30 March 2009 for more details:
 * http://www.whatwg.org/specs/web-apps/current-work/
 */

//#ifndef _HTML5_IDL_
//#define _HTML5_IDL_
//
//#include "w3c/dom.idl"
//#include "w3c/events.idl"
//#include "w3c/css.idl"
//#include "w3c/ranges.idl"
//
//module webstorage {
//  public native interface Database;
//  public native interface Storage;
//};
//
//module html5 {
//
//  typedef dom::Node Node;
//  typedef dom::Document Document;
//  typedef dom::NodeList NodeList;
//  typedef dom::Element Element;
//  typedef dom::DOMStringList DOMStringList;
//  typedef views::AbstractView AbstractView;
//  typedef events::Event Event;
//  typedef events::EventTarget EventTarget;
//  typedef events::MouseEvent MouseEvent;
//  typedef css::CSSStyleDeclaration CSSStyleDeclaration;
//  typedef ranges::Range Range;
//  typedef webstorage::Database Database;
//  typedef webstorage::Storage Storage;
//
//  typedef sequence<MessagePort> MessagePortArray;
//
//  // XXX
//  typedef any Date;

public native interface html /*HTMLHtmlElement*/ extends HTMLElement {}

  public native interface HTMLCollection {
//    readonly attribute unsigned 
	  long length{}
//    getter Element item(final unsigned long index);
//    caller getter Element namedItem(in String name);
	  Element this[long index];
	  Element this[String name];
  }	

  public native interface HTMLFormControlsCollection {
//    readonly attribute unsigned 
	  long length{}
//    getter HTMLElement item(in unsigned long index);
//    caller getter object namedItem(in String name);
	  native Element this[long index];
	  native Object this[String name];
  }

  public native interface HTMLOptionsCollection {
//             attribute unsigned 
	  native long length{}
//    getter HTMLOptionElement item(in unsigned long index);
//    caller getter object namedItem(in String name);
	  /*HTMLOptionElement*/
	  option this[long index];
	  Object this[String name];
	  void add(final HTMLElement element);
	  void add(final HTMLElement element, final HTMLElement before);
	  void add(final HTMLElement element, final long before);
	  void remove(final long index);
  }

  public native interface DOMTokenList {
//    stringifier;
//    readonly attribute unsigned long length;
//    getter String item(in unsigned long index);
	  native String this[long index];
	  boolean has(final String token);
	  void add(final String token);
	  void remove(final String token);
	  boolean toggle(final String token);
  }

//  [NameCreator, NameDeleter, NameGetter, NameSetter]
  public native interface DOMStringMap {}

//  Document implements HTMLDocument
//  [NameGetter=OverrideBuiltins]
  public native interface HTMLDocument {
    // resource metadata management
//    [PutForwards=href] readonly attribute 
	  native Location location{}
//    readonly attribute 
	  native String URL{}
//             attribute 
	  native String domain{}
//    readonly attribute 
	  native String referrer{}
//             attribute 
	  native String cookie{}
//    readonly attribute 
	  native String lastModified{}
//    readonly attribute 
	  native String compatMode{}
//             attribute 
	  native String charset{}
//    readonly attribute 
	  native String characterSet{}
//    readonly attribute 
	  native String defaultCharset{}
//    readonly attribute 
	  native String readyState{}

    // DOM tree accessors
//             attribute 
	  native String title{}
//             attribute 
	  native String dir{}
//             attribute 
	  native HTMLElement body{}
//    readonly attribute 
	  native HTMLCollection images{}
//    readonly attribute 
	  native HTMLCollection embeds{}
//    readonly attribute 
	  native HTMLCollection plugins{}
//    readonly attribute
	  native HTMLCollection links{}
//    readonly attribute 
	  native HTMLCollection forms{}
//    readonly attribute 
	  native HTMLCollection anchors{}
//    readonly attribute 
	  native HTMLCollection scripts{}
	  NodeList getElementsByName(final String elementName);
	  NodeList getElementsByClassName(final String classNames);

	  // dynamic markup insertion
//             attribute 
	  native String innerHTML{}
	  HTMLDocument open();
	  HTMLDocument open(final String type);
	  HTMLDocument open(final String type, final String replace);
	  /*WindowProxy*/Window  open(final String url, final String name, final String features);
	  /*WindowProxy*/Window  open(final String url, final String name, final String features, final boolean replace);
	  void close();
	  void write(final String... text);
	  void writeln(final String... text);

	  // user interaction
	  native Selection getSelection();
//	  readonly attribute 
	  native Element activeElement{}
	  boolean hasFocus();
//      attribute 
	  String designMode{}
      boolean execCommand(final String commandId);
      boolean execCommand(final String commandId, final boolean showUI);
      boolean execCommand(final String commandId, final boolean showUI, final String value);
      boolean queryCommandEnabled(final String commandId);
      boolean queryCommandIndeterm(final String commandId);
      boolean queryCommandState(final String commandId);
      boolean queryCommandSupported(final String commandId);
      String queryCommandValue(final String commandId);
//      readonly attribute 
      native HTMLCollection commands{}
  }

  public native interface HTMLElement extends Element, EventTarget {
    // DOM tree accessors
    NodeList getElementsByClassName(final String classNames);

    // dynamic markup insertion
//             attribute 
    native String innerHTML{}
//             attribute 
    String outerHTML{}
    void insertAdjacentHTML(final String position, final String text);

    // metadata attributes
//             attribute 
    native String id{}
//             attribute 
    native String title{}
//             attribute 
    native String lang{}
//             attribute 
    native String dir{}
//             attribute 
    native String className{}
//    readonly attribute 
    native DOMTokenList classList{}
//    readonly attribute 
    native DOMStringMap dataset{}

    // user interaction
//             attribute
    native boolean hidden{}
    void click(); 
    void scrollIntoView();
    void scrollIntoView(final boolean top);
//             attribute 
    native long tabIndex{}
    void focus();
    void blur();
//             attribute 
    native boolean draggable{}
//             attribute 
    native String contentEditable{}
//    readonly attribute 
    native boolean isContentEditable{}
//             attribute 
    native HTMLMenuElement contextMenu{}
//             attribute 
    native boolean spellcheck{}

    // styling
//    readonly attribute 
    native CSSStyleDeclaration style{}

    // event handler DOM attributes
//             attribute 
    native EventListener onabort{}
//             attribute 
    native EventListener onblur{}
//             attribute 
    native EventListener onchange{}
//             attribute 
    native EventListener onclick{}
//             attribute 
    native EventListener oncontextmenu{}
//             attribute 
    native EventListener ondblclick{}
//             attribute 
    native EventListener ondrag{}
//             attribute 
    native EventListener ondragend{}
//             attribute 
    native EventListener ondragenter{}
//             attribute 
    native EventListener ondragleave{}
//             attribute 
    native EventListener ondragover{}
//             attribute
    native EventListener ondragstart{}
//             attribute 
    native EventListener ondrop{}
//             attribute
    native EventListener onerror{}
//             attribute 
    native EventListener onfocus{}
//             attribute 
    native EventListener onkeydown{}
//             attribute
    native EventListener onkeypress{}
//             attribute 
    native EventListener onkeyup{}
//             attribute 
    native EventListener onload{}
//             attribute 
    native EventListener onmousedown{}
//             attribute 
    native EventListener onmousemove{}
//             attribute 
    native EventListener onmouseout{}
//             attribute 
    native EventListener onmouseover{}
//             attribute 
    native EventListener onmouseup{}
//             attribute 
    native EventListener onmousewheel{}
//             attribute 
    native EventListener onscroll{}
//             attribute 
    native EventListener onselect{} 
//             attribute 
    native EventListener onsubmit{}
     
    public Template template{ 
    	&{ 
    		return this["__template"] == undefined ? null : (Template)this["__template"];
    	} 
    	+{
    		this["__template"] = value;
    	}
    }
    
    public Template itemTemplate{
    	&{
    		return this["__itemTemplate"] == undefined ? null : (Template)this["__itemTemplate"];
    	}
    	+{
    		this["__itemTemplate"] = value; 
    	}
    }
    
    public DataContext dataContext{
    	&{
    		if(this["__dataContext"] === undefined){
    			return ((HTMLElement)parentNode).dataContext;
    		} else {
    			return (DataContext)this["__dataContext"];
    		}
    	}
    	+{
    		if(this["__dataContext"] == value){ 
    			return;
    		}
    		this["__dataContext"] = value;
    	}
    }
  }

  public native interface base /*HTMLBaseElement*/ extends HTMLElement {
//             attribute 
	  native String href{}
//             attribute 
	  native String target{}
  }

  
  public native interface link/*HTMLLinkElement*/ extends HTMLElement {
//             attribute 
	  native boolean disabled{}
//             attribute 
	  native String href{}
//             attribute 
	  native String rel{}
//    readonly attribute 
	  native DOMTokenList relList{}
//             attribute 
	  native String media{}
//             attribute 
	  native String hreflang{}
//             attribute 
	  native String type{}
//             attribute 
	  native String sizes{}
  }

  public native interface meta/*HTMLMetaElement*/ extends HTMLElement {
//             attribute 
	  native String content{}
//             attribute 
	  native String name{}
//             attribute 
	  native String httpEquiv{}
  }

  public native interface style /*HTMLStyleElement*/ extends HTMLElement {
//             attribute 
	  native boolean disabled{}
//             attribute 
	  native String media{}
//             attribute 
	  native String type{}
//             attribute 
	  native boolean scoped{}
  }

  public native interface script/*HTMLScriptElement*/ extends HTMLElement {
//             attribute
	  native String src{}
//             attribute 
	  native boolean async{}
//             attribute 
	  native boolean defer{}
//             attribute 
	  native String type{}
//             attribute 
	  native String charset{}
//             attribute 
	  native String text{}
  }

  public native interface body/*HTMLBodyElement*/ extends HTMLElement {
//    attribute 
	  native EventListener onbeforeunload{}
//      attribute 
	  native EventListener onerror{}     // XXX defined in HTMLDocument
//     attribute 
	  native EventListener onhashchange{}
//    attribute 
	  native EventListener onload{}      // XXX defined in HTMLDocument
//             attribute 
	  native EventListener onmessage{}
//             attribute
	  native EventListener onoffline{}
//     attribute 
	  native EventListener ononline{}
//     attribute 
	  native EventListener onpopstate{}
//      attribute 
	  native EventListener onresize{}
//      attribute 
	  native EventListener onstorage{}
//      attribute 
	  native EventListener onunload{}
  }
  
  public native interface head /*HTMLHeadElement*/ extends HTMLElement {}

  public native interface title /*HTMLTitleElement*/ extends HTMLElement {
//      attribute 
	  native String text{}
  }

  public native interface blockquote /*HTMLQuoteElement*/ extends HTMLElement {
//       attribute 
	  native String cite{}
  }
  
  public native interface ul /*HTMLOListElement*/ extends HTMLElement {
//    attribute 
	  native boolean reversed{}
//  attribute 
	  native long start{}
}

  public native interface ol /*HTMLOListElement*/ extends HTMLElement {
//      attribute 
	  native boolean reversed{}
//    attribute 
	  native long start{}
  }

  public native interface li /*HTMLLIElement*/ extends HTMLElement {
//  	attribute 
	  native long value{}
  }

  public native interface a /*HTMLAnchorElement*/ extends HTMLElement {
//	  stringifier attribute 
	  native String href{}
//  attribute 
	  native String target{}
//             attribute 
	  native String ping{}
//             attribute 
	  native String rel{}
//    readonly attribute 
	  native DOMTokenList relList{}
//             attribute 
	  native String media{}
//             attribute 
	  native String hreflang{}
//             attribute 
	  native String type{}
  }

  public native interface time /*HTMLTimeElement*/ extends HTMLElement {
//    attribute 
	  native String dateTime{}
//    readonly attribute 
	  /*Date*/
	  native long date{}
//    readonly attribute 
	  /*Date*/
	  native long time{}
//    readonly attribute 
	  /*Date*/
	  native long timezone{}
  }

  public native interface progress /*HTMLProgressElement*/ extends HTMLElement {
//   	attribute
	  native float value{}
//    	attribute 
	  native float max{}
//    readonly attribute 
	  native float position{}
	  
//	  readonly attribute 
	  native NodeList labels{}
  }

  public native interface meter/*HTMLMeterElement*/ extends HTMLElement {
//  	attribute
	  native float value{}
//	attribute
	  native float min{}
//    attribute 
	  native float max{}
//    attribute 
	  native float low{}
//    attribute 
	  native float high{}
//    attribute 
	  native float optimum{}
//	  readonly attribute
	  native NodeList labels{}
  }

  public native interface HTMLModElement extends HTMLElement {
//             attribute 
	  native String cite{}
//             attribute 
	  native String dateTime{}
  }

//  [NamedConstructor=Image(),
//   NamedConstructor=Image(final unsigned long width),
//   NamedConstructor=Image(final unsigned long width, final unsigned long height)]
  public native interface img /*HTMLImageElement*/ extends HTMLElement {
//             attribute 
	  native String alt{}
//             attribute 
	  native String src{}
//             attribute 
	  native String useMap{}
//             attribute 
	  native boolean isMap{}
//             attribute unsigned 
	  native long width{}
//             attribute unsigned 
	  native long height{}
//    readonly attribute
	  native boolean complete{}
	  
//      attribute 
	  native String crossOrigin{}
//readonly attribute unsigned 
	  native long naturalWidth{}
//readonly attribute unsigned 
	  native long naturalHeight{}
  }

  public native interface iframe /*HTMLIFrameElement*/ extends HTMLElement {
//             attribute 
	  native String src{}
//             attribute 
	  native String name{}
//             attribute 
	  native String sandbox{}
//             attribute 
	  native boolean seamless{}
//             attribute 
	  native String width{}
//             attribute
	  native String height{}
	  
//      attribute 
	  native String srcdoc{}
//      [PutForwards=value] readonly attribute 
//      DOMSettableTokenList sandbox{}
//readonly attribute 
	  native Document contentDocument{}
//readonly attribute 
	  native Window contentWindow{}
  }

  public native interface embed /*HTMLEmbedElement*/ extends HTMLElement {
//             attribute 
	  native String src{}
//             attribute 
	  native String type{}
//             attribute 
	  native String width{}
//             attribute
	  native String height{}
  }

  public native interface object /*HTMLObjectElement*/ extends HTMLElement {
//             attribute 
	  native String data{}
//             attribute 
	  native String type{}
//             attribute
	  native String name{}
//             attribute 
	  native String useMap{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native String width{}
//             attribute
	  native String height{}
	  
//      attribute 
	  native boolean typeMustMatch{}
//readonly attribute 
	  native Document/*?*/ contentDocument{}
//	  readonly attribute 
	  native Window/*?*/ contentWindow{}

//	  readonly attribute 
	  native boolean willValidate{}
//	  readonly attribute 
	  native ValidityState validity{}
//	  readonly attribute 
	  String validationMessage{}
	  boolean checkValidity();
	  void setCustomValidity(String error);
  }

  public native interface param /*HTMLParamElement*/ extends HTMLElement {
//             attribute 
	  native String name{}
//             attribute 
	  native String value{}
  }

  public native interface source /*HTMLSourceElement*/ extends HTMLElement {
//             attribute
	  native String src{}
//             attribute 
	  native String type{}
//             attribute
	  native String media{}
  }

  public native interface HTMLMediaElement extends HTMLElement {

    // error state
//    readonly attribute 
	  native MediaError error{}

    // network state
//             attribute 
	  native String src{}
//    readonly attribute 
	  native String currentSrc{}
//    const unsigned 
	  static final short NETWORK_EMPTY = 0;
//    const unsigned 
	  static final short NETWORK_IDLE = 1;
//    const unsigned 
	  static final short NETWORK_LOADING = 2;
//    const unsigned
	  static final short NETWORK_LOADED = 3;
//    const unsigned 
	  static final short NETWORK_NO_SOURCE = 4;
//    readonly attribute unsigned 
	  native short networkState{}
//             attribute
	  native boolean autobuffer{}

//    readonly attribute 
	  native TimeRanges buffered{}
	  void load();
	  String canPlayType(final String type);

    // ready state
//    const unsigned 
	  static final short HAVE_NOTHING = 0;
//    const unsigned 
	  static final short HAVE_METADATA = 1;
//    const unsigned 
	  static final short HAVE_CURRENT_DATA = 2;
//    const unsigned 
	  static final short HAVE_FUTURE_DATA = 3;
//    const unsigned 
	  static final short HAVE_ENOUGH_DATA = 4;
//    readonly attribute unsigned 
	  native short readyState{}
//    readonly attribute 
	  native boolean seeking{}

    // playback state
//             attribute 
	  native float currentTime{}
//    readonly attribute
	  native float duration{}
//    readonly attribute 
	  native boolean paused{}
//             attribute
	  native float defaultPlaybackRate{}
//             attribute 
	  native float playbackRate{}
//    readonly attribute 
	  native TimeRanges played{}
//    readonly attribute 
	  native TimeRanges seekable{}
//    readonly attribute
	  native boolean ended{}
//             attribute 
	  native boolean autoplay{}
//             attribute 
	  native boolean loop{}
	  void play();
	  void pause();

	  // cue ranges
	  void addCueRange(final String className, final String id, final float start, final float end, final boolean pauseOnExit, final CueRangeCallback enterCallback, final CueRangeCallback exitCallback);
	  void removeCueRanges(final String className);

	  // controls
//             attribute 
	  native boolean controls{}
//             attribute 
	  native float volume{}
//             attribute 
	  native boolean muted{}
  }

  public native interface video /*HTMLVideoElement*/ extends HTMLMediaElement {
//             attribute 
	  native String width{}
//             attribute 
	  native String height{}
//    readonly attribute unsigned
	  native long videoWidth{}
//    readonly attribute unsigned
	  native long videoHeight{}
//             attribute 
	  native String poster{}
  }

//  [NamedConstructor=Audio(),
//   NamedConstructor=Audio(final String src)]
  public native interface audio /*HTMLAudioElement*/ extends HTMLMediaElement {
    // no members
  }

//  [Callback=FunctionOnly, NoInterfaceObject]
  public native interface CueRangeCallback {
	  void handleEvent(final String id);
  }

  public native interface MediaError {
//    const unsigned 
	  static final short MEDIA_ERR_ABORTED = 1;
//    const unsigned 
	  static final short MEDIA_ERR_NETWORK = 2;
//    const unsigned 
	  static final short MEDIA_ERR_DECODE = 3;
//    const unsigned 
	  static final short MEDIA_ERR_NONE_SUPPORTED = 4;
//    readonly attribute  unsigned 
	  short code{}
  }

  public native interface TimeRanges {
//    readonly attribute unsigned 
	  native long length{}
	  float start(final /*unsigned*/ long index);
	  float end(final /*unsigned*/ long index);
  }

  public native interface canvas /*HTMLCanvasElement*/ extends HTMLElement {
//             attribute unsigned 
	  native long width{}
//             attribute unsigned 
	  native long height{}

	  String toDataURL(final Object... args);
	  String toDataURL(final String type, final Object... args);
	  
	  void toBlob(FileCallback/*?*/ _callback, Object... arguments);
	  void toBlob(FileCallback/*?*/ _callback, String type, Object... arguments);

	  CanvasRenderingContext2D /*?*/ getContext(final String contextId);
  }
  
  interface FileCallback {
	  	void callback(File file);
  }

  public native interface CanvasRenderingContext2D {

    // back-reference to the canvas
//    readonly attribute 
	  /*HTMLCanvasElement*/ canvas canvas{}

    // state
    void save(); // push state on state stack
    void restore(); // pop state stack and restore state

    // transformations (default transform is the identity matrix)
    void scale(final float x, final float y);
    void rotate(final float angle);
    void translate(final float x, final float y);
    void transform(final float m11, final float m12, final float m21, final float m22, final float dx, final float dy);
    void setTransform(final float m11, final float m12, final float m21, final float m22, final float dx, final float dy);

    // compositing
//             attribute 
    native float globalAlpha{} // (default 1.0)
//             attribute 
    native String globalCompositeOperation{} // (default source-over)

    // colors and styles
//             attribute 
    native Object strokeStyle{} // (default black)
//             attribute 
    native Object fillStyle{} // (default black)
    CanvasGradient createLinearGradient(final float x0, final float y0, final float x1, final float y1);
    CanvasGradient createRadialGradient(final float x0, final float y0, final float r0, final float x1, final float y1, final float r1);
    CanvasPattern createPattern(final img /*HTMLImageElement*/ image, final String repetition);
    CanvasPattern createPattern(final canvas /*HTMLCanvasElement*/ image, final String repetition);

    // line caps/joins
//             attribute 
    native float lineWidth{} // (default 1)
//             attribute 
    native String lineCap{} // "butt", "round", "square" (default "butt")
//             attribute 
    native String lineJoin{} // "round", "bevel", "miter" (default "miter")
//             attribute 
    native float miterLimit{} // (default 10)

    // shadows
//             attribute 
    native float shadowOffsetX{} // (default 0)
//             attribute
    native float shadowOffsetY{} // (default 0)
//             attribute 
    native float shadowBlur{} // (default 0)
//             attribute 
    native String shadowColor{} // (default transparent black)

    // rects
    void clearRect(final float x, final float y, final float w, final float h);
    void fillRect(final float x, final float y, final float w, final float h);
    void strokeRect(final float x, final float y, final float w, final float h);

    // path API
    void beginPath();
    void closePath();
    void moveTo(final float x, final float y);
    void lineTo(final float x, final float y);
    void quadraticCurveTo(final float cpx, final float cpy, final float x, final float y);
    void bezierCurveTo(final float cp1x, final float cp1y, final float cp2x, final float cp2y, final float x, final float y);
    void arcTo(final float x1, final float y1, final float x2, final float y2, final float radius);
    void rect(final float x, final float y, final float w, final float h);
    void arc(final float x, final float y, final float radius, final float startAngle, final float endAngle, final boolean anticlockwise);
    void fill();
    void stroke();
    void clip();
    boolean isPointInPath(final float x, final float y);

    // text
//             attribute 
    native String font{} // (default 10px sans-serif)
//             attribute 
    native String textAlign{} // "start", "end", "left", "right", "center" (default: "start")
//             attribute 
    native String textBaseline{} // "top", "hanging", "middle", "alphabetic", "ideographic", "bottom" (default: "alphabetic")
    void fillText(final String text, final float x, final float y);
    void fillText(final String text, final float x, final float y, final float maxWidth);
    void strokeText(final String text, final float x, final float y);
    void strokeText(final String text, final float x, final float y, final float maxWidth);
    TextMetrics measureText(final String text);

    // drawing images
    void drawImage(final img /*HTMLImageElement*/ image, final float dx, final float dy, final float dh);
    void drawImage(final img /*HTMLImageElement*/ image, final float dx, final float dy, final float dw, final float dh);
    void drawImage(final img /*HTMLImageElement*/ image, final float sx, final float sy, final float sw, final float sh, final float dx, final float dy, final float dw, final float dh);
    void drawImage(final canvas /*HTMLCanvasElement*/ image, final float dx, final float dy, final float dh);
    void drawImage(final canvas /*HTMLCanvasElement*/ image, final float dx, final float dy, final float dw, final float dh);
    void drawImage(final canvas /*HTMLCanvasElement*/ image, final float sx, final float sy, final float sw, final float sh, final float dx, final float dy, final float dw, final float dh);
    void drawImage(final video /*HTMLVideoElement*/ image, final float dx, final float dy, final float dh);
    void drawImage(final video /*HTMLVideoElement*/ image, final float dx, final float dy, final float dw, final float dh);
    void drawImage(final video /*HTMLVideoElement*/ image, final float sx, final float sy, final float sw, final float sh, final float dx, final float dy, final float dw, final float dh);

    // pixel manipulation
    ImageData createImageData(final float sw, final float sh);
    ImageData getImageData(final float sx, final float sy, final float sw, final float sh);
    void putImageData(final ImageData imagedata, final float dx, final float dy, final float dirtyY, final float dirtyWidth, final float dirtyHeight);
    void putImageData(final ImageData imagedata, final float dx, final float dy, final float dirtyX, final float dirtyY, final float dirtyWidth, final float dirtyHeight);
  }

  public native interface CanvasGradient {
    // opaque object
    void addColorStop(final float offset, final String color);
  }

  public native interface CanvasPattern {
    // opaque object
  }

  public native interface TextMetrics {
//    readonly attribute 
	  float width{}
  }

  public native interface ImageData {
//    readonly attribute unsigned 
	  native long width{}
//    readonly attribute unsigned 
	  native long height{}
//    readonly attribute 
	  native CanvasPixelArray data{}
  }

//  [IndexGetter, IndexSetter]
  public native interface CanvasPixelArray {
//    readonly attribute unsigned 
	  native long length{}
  }

  public native interface map /*HTMLMapElement*/ extends HTMLElement {
//             attribute 
	  native String name{}
//    readonly attribute 
	  native HTMLCollection areas{}
//    readonly attribute 
	  native HTMLCollection images{}
  }

  public native interface area /*HTMLAreaElement*/ extends HTMLElement {
//    attribute 
	  native String alt{}
//     attribute 
	  native String coords{}
//     attribute 
	  native String shape{}
//     attribute 
	  native String href{}
//     attribute 
	  native String target{}
//     attribute 
	  native String ping{}
//     attribute 
//	  
	  native String rel{}
//    readonly attribute 
	  DOMTokenList relList{}
//             attribute 
	  native String media{}
//             attribute 
	  native String hreflang{}
//             attribute 
	  native String type{}
  }

  public native interface table /*HTMLTableElement*/ extends HTMLElement {
//             attribute 
	  /*HTMLTableCaptionElement*/
	  native caption caption{}
	  HTMLElement createCaption();
	  void deleteCaption();
//             attribute 
	  HTMLTableSectionElement tHead{}
	  HTMLElement createTHead();
	  void deleteTHead();
//             attribute 
	  HTMLTableSectionElement tFoot{}
	  HTMLElement createTFoot();
	  void deleteTFoot();
//    readonly attribute 
	  native HTMLCollection tBodies{}
	  HTMLElement createTBody();
//    readonly attribute 
	  native HTMLCollection rows{}
	  HTMLElement insertRow();
	  HTMLElement insertRow(final /*optional*/ long index);
	  void deleteRow(final long index);
	  
	  native String border{}
	  native boolean sortable{} // - Enables a sorting interface for the table
  }

  public native interface caption /*HTMLTableCaptionElement*/ extends HTMLElement {
//             attribute
	  native String align{}
  }

  public native interface HTMLTableColElement extends HTMLElement {
//             attribute unsigned
	  native long span{}
  }

  public native interface HTMLTableSectionElement extends HTMLElement {
//    readonly attribute 
	  native HTMLCollection rows{}
	  HTMLElement insertRow();
	  HTMLElement insertRow(final /*optional*/ long index);
	  void deleteRow(final long index);
  }

  public native interface tr /*HTMLTableRowElement*/ extends HTMLElement {
//    readonly attribute 
	  native long rowIndex{}
//    readonly attribute 
	  native long sectionRowIndex{}
//    readonly attribute 
	  native HTMLCollection cells{}
	  HTMLElement insertCell();
	  HTMLElement insertCell(final long index);
	  void deleteCell(final long index);
  }

  public native interface HTMLTableCellElement extends HTMLElement {
//             attribute 
	  native long colSpan{}
//             attribute 
	  native long rowSpan{}
//             attribute 
	  native String headers{}
//    readonly attribute 
	  native long cellIndex{}
  }

  public native interface td /*HTMLTableDataCellElement*/ extends HTMLTableCellElement {};

  public native interface th /*HTMLTableHeaderCellElement*/ extends HTMLTableCellElement {
//             attribute 
	  native String scope{}
  }

  public native interface form /*HTMLFormElement*/ extends HTMLElement {
//             attribute 
	  native String acceptCharset{}
//             attribute
	  native String action{}
//             attribute
	  native boolean autocomplete{}
//             attribute 
	  native String enctype{}
//             attribute 
	  native String method{}
//             attribute
	  native String name{}
//             attribute 
	  native boolean novalidate{}
//             attribute 
	  native String target{}

//    readonly attribute 
	  native HTMLFormControlsCollection elements{}
//    readonly attribute 
	  native long length{}
//	  getter any item(final unsigned long index);
//	  [OverrideBuiltins] caller getter any namedItem(final String name);
	  Object this[long index];
	  Object this[String name];
	  void submit();
	  void reset();
	  boolean checkValidity();

    void dispatchFormInput();
    void dispatchFormChange();
  }

  public native interface fieldset /*HTMLFieldSetElement*/ extends HTMLElement {
//             attribute 
	  native boolean disabled{}
//    readonly attribute 
	  /*HTMLFormElement*/form form{}
//             attribute 
	  native String name{}

//    readonly attribute 
	  native String type{}

//    readonly attribute 
	  native HTMLFormControlsCollection elements{}

//    readonly attribute 
	  native boolean willValidate{}
//    readonly attribute 
	  native ValidityState validity{}
//    readonly attribute 
	  native String validationMessage{}
	  boolean checkValidity();
	  void setCustomValidity(final String error);
  }

  public native interface label /*HTMLLabelElement*/ extends HTMLElement {
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native String htmlFor{}
//    readonly attribute
	  native HTMLElement control{}
  }

  public native interface input /*HTMLInputElement*/ extends HTMLElement {
//             attribute
	  native String accept{}
//             attribute 
	  native String alt{}
//             attribute 
	  native boolean autocomplete{}
//             attribute 
	  native boolean autofocus{}
//             attribute 
	  native boolean defaultChecked{}
//             attribute 
	  native boolean checked{}
//             attribute 
	  native boolean disabled{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native String formAction{}
//             attribute 
	  native String formEnctype{}
//             attribute 
	  native String formMethod{}
//             attribute 
	  native boolean formNoValidate{}
//             attribute 
	  native String formTarget{}
//             attribute 
	  native String height{}
//             attribute 
	  native boolean indeterminate{}
//    readonly attribute 
	  native HTMLElement list{}
//             attribute 
	  native String max{}
//             attribute 
	  native long maxLength{}
//             attribute 
	  native String min{}
//             attribute 
	  native boolean multiple{}
//             attribute 
	  native String name{}
//             attribute 
	  native String pattern{}
//             attribute 
	  native String placeholder{}
//             attribute 
	  native boolean readOnly{}
//             attribute 
	  native boolean required{}
//             attribute unsigned 
	  native long size{}
//             attribute 
	  native String src{}
//             attribute 
	  native String step{}
//             attribute 
	  native String type{}
//             attribute 
	  native String defaultValue{}
//             attribute 
	  native String value{}
//             attribute 
      /*Date*/
	  native long valueAsDate{}
//             attribute
	  native float valueAsNumber{}
//    readonly attribute 
      /*HTMLOptionElement*/
	  native option selectedOption{}
//             attribute 
      native String width{}

      void stepUp(final long n);
      void stepDown(final long n);

//    readonly attribute 
      native boolean willValidate{}
//    readonly attribute 
      native ValidityState validity{}
//    readonly attribute 
      native String validationMessage{}
      boolean checkValidity();
      void setCustomValidity(final String error);

//      readonly attribute
      native NodeList labels{}

      void select();
//             attribute unsigned 
      native long selectionStart{}
//             attribute unsigned 
      native long selectionEnd{}
      void setSelectionRange(final /*unsigned*/ long start, final /*unsigned*/ long end);
      
      native EventListener oninput{}
  }

  public native interface button /*HTMLButtonElement*/ extends HTMLElement {
//             attribute 
	  native boolean autofocus{}
//             attribute 
	  native boolean disabled{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native String formaction{}
//             attribute 
	  native String formenctype{}
//             attribute 
	  native String formmethod{}
//             attribute 
	  native String formnoValidate{}
//             attribute 
	  native String formtarget{}
//             attribute 
	  native String name{}
//             attribute 
	  native String type{}
//             attribute 
	  native String value{}

//    readonly attribute 
	  native boolean willValidate{}
//    readonly attribute 
	  native ValidityState validity{}
//    readonly attribute 
	  native String validationMessage{}
	  boolean checkValidity();
	  void setCustomValidity(final String error);

//	  readonly attribute 
	  native NodeList labels{}
  }

  public native interface select /*HTMLSelectElement*/ extends HTMLElement {
//             attribute 
	  native boolean autofocus{}
//             attribute 
	  native boolean disabled{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native boolean multiple{}
//             attribute 
	  native String name{}
//             attribute 
	  native boolean size{}

//    readonly attribute 
	  native String type{}

//    readonly attribute 
	  native HTMLOptionsCollection options{}
//             attribute unsigned 
	  native long length{}
//	  getter any item(final unsigned long index);
//	  caller getter any namedItem(final String name);
	  Object this[long index];
	  Object this[String name];
	  void add(final HTMLElement element);
	  void add(final HTMLElement element, final HTMLElement before);
	  void add(final HTMLElement element, final long before);
	  void remove(final long index);

//	  readonly attribute 
	  native HTMLCollection selectedOptions{}
//             attribute 
	  native long selectedIndex{}
//             attribute 
	  native String value{}

//             readonly attribute 
	  native boolean willValidate{}
//    readonly attribute 
	  native ValidityState validity{}
//    readonly attribute 
	  native String validationMessage{}
      boolean checkValidity();
      void setCustomValidity(final String error);

//      readonly attribute 
      native NodeList labels{}
  }

  public native interface datalist /*HTMLDataListElement*/ extends HTMLElement {
//    readonly attribute 
	  native HTMLCollection options{}
  }

  public native interface optgroup /*HTMLOptGroupElement*/ extends HTMLElement {
//             attribute
	  native boolean disabled{}
//             attribute 
	  native String label{}
  }

//  [NamedConstructor=Option(),
//   NamedConstructor=Option(final String text),
//   NamedConstructor=Option(final String text, final String value),
//   NamedConstructor=Option(final String text, final String value, final boolean defaultSelected),
//   NamedConstructor=Option(final String text, final String value, final boolean defaultSelected, final boolean selected)]
  public native interface option /*HTMLOptionElement*/ extends HTMLElement {
//             attribute 
	  native boolean disabled{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native String label{}
//             attribute 
	  native boolean defaultSelected{}
//             attribute 
	  native boolean selected{}
//             attribute 
	  native String value{}

//    readonly attribute 
	  native String text{}
//    readonly attribute 
	  native long index{}
  }

  public native interface textarea /*HTMLTextAreaElement*/ extends HTMLElement {
//             attribute 
	  native boolean autofocus{}
//             attribute unsigned 
	  native long cols{}
//             attribute 
	  native boolean disabled{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute
	  native long maxLength{}
//             attribute 
	  native String name{}
//             attribute 
	  native String placeholder{}
//             attribute 
	  native boolean readOnly{}
//             attribute 
	  native boolean required{}
//             attribute unsigned 
	  native long rows{}
//             attribute 
	  native String wrap{}

//    readonly attribute 
	  native String type{}
//             attribute 
	  native String defaultValue{}
//             attribute 
	  native String value{}

//    readonly attribute 
	  native boolean willValidate{}
//    readonly attribute 
	  native ValidityState validity{}
//    readonly attribute 
	  native String validationMessage{}
	  boolean checkValidity();
	  void setCustomValidity(final String error);

//	  readonly attribute 
	  native NodeList labels{}

	  void select();
//             attribute unsigned 
	  native long selectionStart{}
//             attribute unsigned 
	  native long selectionEnd{}
	  void setSelectionRange(final /*unsigned*/ long start, final /*unsigned*/ long end);
  }

  public native interface output /*HTMLOutputElement*/ extends HTMLElement {
//             attribute 
	  native String htmlFor{}
//    readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
//             attribute 
	  native String name{}

//    readonly attribute
	  native String type{}
//             attribute 
	  native String defaultValue{}
//             attribute 
	  native String value{}

//    readonly attribute 
	  native boolean willValidate{}
//    readonly attribute 
	  native ValidityState validity{}
//    readonly attribute 
	  native String validationMessage{}
	  boolean checkValidity();
	  void setCustomValidity(final String error);
  }

  public native interface ValidityState {
//    readonly attribute 
	  native boolean valueMissing{}
//    readonly attribute 
	  native boolean typeMismatch{}
//    readonly attribute 
	  native boolean patternMismatch{}
//    readonly attribute 
	  native boolean tooLong{}
//    readonly attribute 
	  native boolean rangeUnderflow{}
//    readonly attribute 
	  native boolean rangeOverflow{}
//    readonly attribute 
	  native boolean stepMismatch{}
//    readonly attribute 
	  native boolean customError{}
//    readonly attribute 
	  native boolean valid{}
  }

  public native interface HTMLDetailsElement extends HTMLElement {
//             attribute 
	  native boolean open{}
  }

  public native interface HTMLCommandElement extends HTMLElement {
//             attribute 
	  native String type{}
//             attribute 
	  native String label{}
//             attribute 
	  native String icon{}
//             attribute
	  native boolean disabled{}
//             attribute 
	  native boolean checked{}
//             attribute 
	  native String radiogroup{}
//             attribute 
	  native boolean defaultValue{}  // XXX default
    // XXX void click(); // shadows HTMLElement.click()
  }

  public native interface HTMLBrowserButtonElement extends HTMLElement {
//             attribute 
	  native String type{}
//    readonly attribute 
	  native boolean supported{}
//    readonly attribute 
	  native boolean disabled{}
  }

  public native interface HTMLMenuElement extends HTMLElement {
//             attribute 
	  native String type{}
//             attribute 
	  native String label{}
  }

//  [NoInterfaceObject] 
  public native interface Command {
//	  readonly attribute 
	  native String commandType{}
//	  readonly attribute 
	  native String id{}
//	  readonly attribute 
	  native String label{}
//	  readonly attribute 
	  native String title{}
//	  readonly attribute 
	  native String icon{}
//	  readonly attribute 
	  native boolean hidden{}
//	  readonly attribute 
	  native boolean disabled{}
//	  readonly attribute
	  native boolean checked{}
	  void click();
  }

  public native interface legend /*HTMLLegendElement*/ extends HTMLElement {
//	  readonly attribute 
	  /*HTMLFormElement*/
	  native form form{}
  }

//  typedef Window /*WindowProxy*/Window ;
//  [IndexGetter, NameGetter=OverrideBuiltins]
  public native interface Window {
    // the current browsing context
//    readonly attribute
	  /*WindowProxy*/
	  native Window  window{}
//    readonly attribute 
	  /*WindowProxy*/
	  native Window  self{}
//             attribute 
	  native String name{}
//    [PutForwards=href] readonly attribute 
	  native Location location{}
//    readonly attribute 
	  native History history{}
//    readonly attribute 
	  native UndoManager undoManager{}
	  native Selection getSelection();
//    [Replaceable] readonly attribute 
	  native BarProp locationbar{}
//    [Replaceable] readonly attribute 
	  native BarProp menubar{}
//    [Replaceable] readonly attribute 
	  native BarProp personalbar{}
//    [Replaceable] readonly attribute 
	  native BarProp scrollbars{}
//    [Replaceable] readonly attribute
	  BarProp statusbar{}
//    [Replaceable] readonly attribute 
	  native BarProp toolbar{}
	  void close();
	  void focus();
	  void blur();

    // other browsing contexts
//    readonly attribute 
	  /*WindowProxy*/
	  native Window  frames{}
//    readonly attribute unsigned 
	  native long length{}
//    readonly attribute 
	  /*WindowProxy*/
	  native Window  top{}
//    [Replaceable] readonly attribute 
	  /*WindowProxy*/
	  native Window  opener{}
//    readonly attribute 
	  /*WindowProxy*/
	  native Window  parent{}
//    readonly attribute 
	  native Element frameElement{}
	  /*WindowProxy*/Window  open();
	  /*WindowProxy*/Window  open(final String url);
	  /*WindowProxy*/Window  open(final String url, final String target);
	  /*WindowProxy*/Window  open(final String url, final String target, final String features);
	  /*WindowProxy*/Window  open(final String url, final String target, final String features, final String replace);

    // the user agent
//    readonly attribute 
	  native Navigator navigator{}
//    readonly attribute 
	  native Storage localStorage{}
//    readonly attribute 
	  native Storage sessionStorage{}
//	  Database openDatabase(final String name, final String version, final String displayName, final /*unsigned*/ long estimatedSize);
//	  readonly attribute 
	  native ApplicationCache applicationCache{}

	  // user prompts
	  void alert(final String message);
	  boolean confirm(final String message);
	  String prompt(final String message);
	  String prompt(final String message, final /*optional*/ String defaultValue);
	  void print();
	  Object showModalDialog(final String url);
	  Object showModalDialog(final String url, final /*optional*/ Object argument);

    // cross-document messaging
	  void postMessage(final Object message, final String targetOrigin);
	  void postMessage(final Object message, final /*MessagePortArray*/MessagePort[] ports, final String targetOrigin);

    // event handler DOM attributes
//	  attribute 
	  native EventListener onabort{}
//	  attribute
	  native EventListener onbeforeunload{}
//	     attribute 
	  native EventListener onblur{}
//	     attribute 
	  native EventListener onchange{}
//	     attribute 
	  native EventListener onclick{}
//	     attribute 
	  native EventListener oncontextmenu{}
//	     attribute 
	  native EventListener ondblclick{}
//	     attribute 
	  native EventListener ondrag{}
//	     attribute 
	  native EventListener ondragend{}
//	     attribute 
	  native EventListener ondragenter{}
//	     attribute 
	  native EventListener ondragleave{}
//	     attribute 
	  native EventListener ondragover{}
//	     attribute
	  native EventListener ondragstart{}
//	     attribute
	  native EventListener ondrop{}
//	     attribute 
	  native EventListener onerror{}
//	     attribute 
	  native EventListener onfocus{}
//	     attribute 
	  native EventListener onhashchange{}
//	     attribute 
	  native EventListener onkeydown{}
//	     attribute 
	  native EventListener onkeypress{}
//	     attribute 
	  native EventListener onkeyup{}
//	     attribute
	  native EventListener onload{}
//	     attribute 
	  native EventListener onmessage{}
//	     attribute 
	  native EventListener onmousedown{}
//	     attribute 
	  native EventListener onmousemove{}
//	     attribute 
	  native EventListener onmouseout{}
//	     attribute 
	  native EventListener onmouseover{}
//	     attribute
	  native EventListener onmouseup{}
//	     attribute 
	  native EventListener onmousewheel{}
//	     attribute 
	  native EventListener ononline{}
//	     attribute 
	  native EventListener onoffline{}
//	     attribute 
	  native EventListener onpopstate{}
//	     attribute 
	  native EventListener onresize{}
//	     attribute 
	  native EventListener onscroll{}
//	     attribute 
	  native EventListener onselect{}
//	     attribute 
	  native EventListener onstorage{}
//	     attribute
	  native EventListener onsubmit{}
//	     attribute 
	  native EventListener onunload{}
  }

  public native interface BarProp {
//             attribute 
	  boolean visible{}
  }

//  [Callback=FunctionOnly, NoInterfaceObject]
  @FunctionalInterface
  public native interface EventHandler {
	  void handle(final Event event);
  }

//  Window implements WindowModal;
//  [NoInterfaceObject,  XXX] 
  public interface WindowModal {
//    readonly attribute 
	  native Object dialogArguments{}
//             attribute 
	  native String returnValue{}
  }

  public native interface Navigator {
    // objects implementing this public native interface also implement the interfaces given below
  }

//  Navigator implements NavigatorID;
//  [NoInterfaceObject] 
  public native interface NavigatorID {
//    readonly attribute 
	  native String appName{}
//    readonly attribute 
	  native String appVersion{}
//    readonly attribute 
	  native String platform{}
//    readonly attribute 
	  native String userAgent{}
  }

//  Navigator implements NavigatorOnLine;
//  [NoInterfaceObject] 
public native interface NavigatorOnLine {
//    readonly attribute 
	native boolean onLine{}
}

//  Navigator implements NavigatorAbilities;
//  [NoInterfaceObject] 
public native interface NavigatorAbilities {
    // content handler registration
    void registerProtocolHandler(final String protocol, final String url, final String title);
    void registerContentHandler(final String mimeType, final String url, final String title);
    void getStorageUpdates();
  }

  public native interface ApplicationCache {

    // update status
//    const unsigned 
	  static final short UNCACHED = 0;
//    const unsigned 
	  static final short IDLE = 1;
//    const unsigned 
	  static final short CHECKING = 2;
//    const unsigned 
	  static final short DOWNLOADING = 3;
//    const unsigned 
	  static final short UPDATEREADY = 4;
//    const unsigned 
	  static final short OBSOLETE = 5;
//    readonly attribute unsigned 
	  native short status{}

	  // updates
	  void update();
	  void swapCache();

    // events
//             attribute 
	  native EventListener onchecking{}
//             attribute 
	  native EventListener onerror{}
//             attribute 
	  native EventListener onnoupdate{}
//             attribute
	  native EventListener ondownloading{}
//             attribute 
	  native EventListener onprogress{}
//             attribute 
	  native EventListener onupdateready{}
//             attribute 
	  native EventListener oncached{}
//             attribute 
	  native EventListener onobsolete{}

  }

  public native interface History {
//    readonly attribute
	  native long length{}
	  void go();
	  void go(final /*optional*/ long delta);
	  void back();
	  void forward();
	  void pushState(final Object data, final String title);
	  void pushState(final Object data, final String title, final /*optional*/ String url);
	  void clearState();
  }

  public native interface PopStateEvent extends Event {
//    readonly attribute 
	  native Object state{}
	  void initPopStateEvent(final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final Object stateArg);
	  void initPopStateEventNS(final String namespaceURIArg, final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final Object stateArg);
  }

  public native interface Location {
//    readonly attribute 
	  native String href{}
	  void assign(final String url);
	  void replace(final String url);
	  void reload();

    // URL decomposition attributes
//             attribute 
	  native String protocol{}
//             attribute 
	  native String host{}
//             attribute
	  native String hostname{}
//             attribute 
	  native String port{}
//             attribute
	  native String pathname{}
//             attribute 
	  native String search{}
//             attribute 
	  native String hash{}

	  // resolving relative URLs
	  String resolveURL(final String url);
  }

  public native interface BeforeUnloadEvent extends Event {
//             attribute 
	  native String returnValue{}
  }

  public native interface Selection {
//    stringifier;
//    readonly attribute 
	  native Node anchorNode{}
//    readonly attribute
	  native long anchorOffset{}
//    readonly attribute 
	  Node focusNode{}
//    readonly attribute 
	  native long focusOffset{}
//    readonly attribute 
	  native boolean isCollapsed{}
	  void collapse(final Node parentNode, final long offset);
	  void collapseToStart();
	  void collapseToEnd();
	  void selectAllChildren(final Node parentNode);
	  void deleteFromDocument();
//	  readonly attribute 
	  long rangeCount{}
	  Range getRangeAt(final long index);
	  void addRange(final Range range);
	  void removeRange(final Range range);
	  void removeAllRanges();
  }

  public native interface DragEvent extends MouseEvent {
//    readonly attribute 
	  native DataTransfer dataTransfer{}

    void initDragEvent(final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final AbstractView viewArg, final long detailArg, final long screenXArg, final long screenYArg, final long clientXArg, final long clientYArg, final boolean ctrlKeyArg, final boolean altKeyArg, final boolean shiftKeyArg, final boolean metaKeyArg, final /*unsigned*/ short buttonArg, final EventTarget relatedTargetArg, final DataTransfer dataTransferArg);
    void initDragEventNS(final String namespaceURIArg, final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final AbstractView viewArg, final long detailArg, final long screenXArg, final long screenYArg, final long clientXArg, final long clientYArg, final /*unsigned*/ short buttonArg, final EventTarget relatedTargetArg, final String modifiersListArg, final DataTransfer dataTransferArg);
  }

  public native interface DataTransfer {
//             attribute 
	  native String dropEffect{}
//             attribute 
	  native String effectAllowed{}
//    readonly attribute 
	  native DOMStringList types{}
	  void clearData();
	  void clearData(final /*optional*/ String format);
	  void setData(final String format, final String data);
	  String getData(final String format);
	  void setDragImage(final Element image, final long x, final long y);
	  void addElement(final Element element);
  }

  public native interface UndoManager {
//    readonly attribute unsigned 
	  long length{}
//	  getter any item(final unsigned long index);
	  Object this[final /*unsigned*/ long index];
//	  readonly attribute unsigned
	  long position{}
	  /*unsigned*/ long add(final Object data, final String title);
	  void remove(final /*unsigned*/ long index);
	  void clearUndo();
	  void clearRedo();
  }

  public native interface UndoManagerEvent extends Event {
//    readonly attribute 
	  native Object data{}
	  void initUndoManagerEvent(final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final Object dataArg);
	  void initUndoManagerEventNS(final String namespaceURIArg, final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final Object dataArg);
  }

  public native interface MessageEvent extends Event {
//    readonly attribute
	  native Object data{}
//    readonly attribute 
	  native String origin{}
//    readonly attribute 
	  native String lastEventId{}
//    readonly attribute 
	  /*WindowProxy*/
	  native Window  source{}
//    readonly attribute 
	  /*MessagePortArray*/
	  native MessagePort[] ports{}
	  void initMessageEvent(final String typeArg, final boolean canBubbleArg, final boolean cancelableArg, final Object dataArg, final String originArg, 
			  final String lastEventIdArg, final /*WindowProxy*/Window  sourceArg, final /*MessagePortArray*/MessagePort[] portsArg);
	  void initMessageEventNS(final String namespaceURI, final String typeArg, final boolean canBubbleArg, 
			  final boolean cancelableArg, final Object dataArg, final String originArg, final String lastEventIdArg,
			  final /*WindowProxy*/Window  sourceArg, final /*MessagePortArray*/MessagePort[] portsArg);
  }

//  [Constructor]
  public native interface MessageChannel {
//    readonly attribute 
	  native MessagePort port1{}
//    readonly attribute 
	  native MessagePort port2{}
  }

  public native interface MessagePort {
//    readonly attribute 
	  native boolean active{}
	  void postMessage(final Object message);
	  void postMessage(final Object message, final /*optional*/ /*MessagePortArray*/MessagePort[] ports);
	  void start();
	  void close();

    // event handler attributes
//             attribute 
	  EventListener onmessage{}
  }

//  Window implements WindowTimers;
//  [NoInterfaceObject] 
public native interface WindowTimers {
    // timers
    long setTimeout(final TimeoutHandler handler, final long timeout, final Object... arguments);
    long setTimeout(final String code, final long timeout);
    long setTimeout(final String code, final long timeout, final String language);
    void clearTimeout(final long handle);
    long setInterval(final TimeoutHandler handler, final long timeout, final Object... arguments);
    long setInterval(final String code, final long timeout);
    long setInterval(final String code, final long timeout, final String language);
    void clearInterval(final long handle);
  }

//  [Callback=FunctionOnly, NoInterfaceObject]
  public native interface TimeoutHandler {
    void handleEvent(final any... args);
  }

//  AbstractView implements MediaModeAbstractView;
//  [NoInterfaceObject] 
public native interface MediaModeAbstractView {
//    readonly attribute 
	native String mediaMode{}
}

public native interface div /*HTMLDivElement*/ extends HTMLElement {
	
}

public native interface span /*HTMLSpanElement*/  extends HTMLElement {}
public native interface pre /*HTMLPreElement*/ extends HTMLElement {}
public native interface hr /*HTMLHRElement*/ extends HTMLElement {}
public native interface p /*HTMLParagraphElement*/ extends HTMLElement {}
public native interface HTMLDListElement extends HTMLElement {}
public native interface HTMLHeadingElement extends HTMLElement {}
public native interface HTMLDataElement extends HTMLElement {
//    attribute 
	native String value{}
}

public native interface HTMLTrackElement extends HTMLElement {
//    attribute 
	native String kind{}
//    attribute 
	native String src{}
//    attribute 
	native String srclang{}
//    attribute 
	native String label{}
//    attribute
//	boolean default{}

//    const unsigned 
	short NONE = 0;
//    const unsigned 
	short LOADING = 1;
//    const unsigned 
	short LOADED = 2;
//    const unsigned 
	short ERROR = 3;
//    readonly attribute unsigned 
	native short readyState{}

//    readonly attribute 
	native TextTrack track{}
}

//enum 
public final class TextTrackMode { 
	public static final String disabled = "disabled";
	public static final String hidden = "hidden";
	public static final String showing = "showing";
}
//enum 
public final class TextTrackKind { 
	public static final String subtitles = "subtitles";
	public static final String captions = "captions";
	public static final String descriptions = "descriptions";
	public static final String chapters = "chapters";
	public static final String metadata = "metadata" ;
}
interface TextTrack extends EventTarget {
//  readonly attribute 
	native TextTrackKind kind{}
//  readonly attribute 
	native String label{}
//  readonly attribute 
	native String language{}

//  readonly attribute 
	native String id{}
//  readonly attribute 
	native String inBandMetadataTrackDispatchType{}

//           attribute 
	native TextTrackMode mode{}

//  readonly attribute 
	native TextTrackCueList/*?*/ cues{}
//  readonly attribute 
	native TextTrackCueList/*?*/ activeCues{}

	void addCue(TextTrackCue cue);
	void removeCue(TextTrackCue cue);

	//           attribute 
	native EventListener oncuechange{}
}

interface TextTrackCueList {
//	  readonly attribute unsigned 
	native long length{}
//	  getter TextTrackCue (unsigned long index);
	TextTrackCue this[long index];
	TextTrackCue/*?*/ getCueById(String id);
}

interface TextTrackCue extends EventTarget {
//	  readonly attribute 
	native TextTrack/*?*/ track{}

//	           attribute 
	native String id{}
//	           attribute 
	native double startTime{}
//	           attribute 
	native double endTime{}
//	           attribute 
	native boolean pauseOnExit{}

//	           attribute 
	native EventListener onenter{}
//	           attribute 
	native EventListener onexit{}
}

public native interface keygen /*HTMLKeygenElement*/ extends HTMLElement {
//    attribute 
	native boolean autofocus{}
//    attribute 
	native String challenge{}
//    attribute 
	native boolean disabled{}
//    readonly attribute 
	/*HTMLFormElement*/form/*?*/ form{}
//    attribute 
	native String keytype{}
//    attribute 
	native String name{}

//    readonly attribute 
	native String type{}

//    readonly attribute 
	native boolean willValidate{}
//    readonly attribute 
	native ValidityState validity{}
//    readonly attribute 
	native String validationMessage{}
    boolean checkValidity();
    void setCustomValidity(String error);

//    readonly attribute 
    native NodeList labels{}
}

public native interface template /*HTMLTemplateElement*/ extends HTMLElement {
//	  readonly attribute 
	native DocumentFragment content{}
}

public interface br /*HTMLBRElement*/ extends HTMLElement {}
public interface wbr /*HTMLBRElement*/ extends HTMLElement {}

public interface dd extends HTMLElement {} 
public interface dl extends HTMLElement {} 
public interface dt extends HTMLElement {} 

public interface figure extends HTMLElement {} 
public interface figcaption extends HTMLElement {}
public interface main extends HTMLElement {}
public interface article extends HTMLElement {}
public interface section extends HTMLElement {} 
public interface nav extends HTMLElement {}
public interface aside extends HTMLElement {} 
public interface header extends HTMLElement {} 
public interface footer extends HTMLElement {} 
public interface address extends HTMLElement {} 

public interface em extends HTMLElement {} 
public interface strong extends HTMLElement {} 
public interface small extends HTMLElement {} 
public interface s extends HTMLElement {}
public interface cite extends HTMLElement {}
public interface q extends HTMLElement {}
public interface dfn extends HTMLElement {} 
public interface abbr extends HTMLElement {}

public interface code extends HTMLElement {}

public interface var extends HTMLElement {} 
public interface samp extends HTMLElement {} 
public interface kbd extends HTMLElement {} 
public interface sub extends HTMLElement {} 
public interface sup extends HTMLElement {}
public interface i extends HTMLElement {}
public interface b extends HTMLElement {}
public interface u extends HTMLElement {}
public interface mark extends HTMLElement {} 
public interface ruby extends HTMLElement {} 
public interface rb extends HTMLElement {} 
public interface rt extends HTMLElement {}
public interface rtc extends HTMLElement {}
public interface rp extends HTMLElement {}
public interface bdi extends HTMLElement {}
public interface bdo extends HTMLElement {}
public interface ins extends HTMLModElement{}
public interface del extends HTMLModElement{}

public interface tbody extends HTMLTableSectionElement {}
public interface thead extends HTMLTableSectionElement {}
public interface tfoot extends HTMLTableSectionElement {}

public interface colgroup extends HTMLTableColElement{}
public interface col extends HTMLTableColElement{}

public interface h1 extends HTMLHeadingElement{}
public interface h2 extends HTMLHeadingElement{}
public interface h3 extends HTMLHeadingElement{}
public interface h4 extends HTMLHeadingElement{}
public interface h5 extends HTMLHeadingElement{}
public interface h6 extends HTMLHeadingElement{}




