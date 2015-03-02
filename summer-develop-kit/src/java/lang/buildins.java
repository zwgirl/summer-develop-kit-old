@Module 
package java.lang; 

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

import org.w3c.dom.Node;
import org.w3c.html.HTMLElement;
 
public final class Class<T> /*implements java.io.Serializable*/ {
	private static final long serialVersionUID = 1L;
  
	public static final int CLASS = 0x1;
	public static final int INTERFACE = 0x2;
	public static final int ENUM = 0x4;
	 
	public static final int ARRAY = 0x10;
	public static final int PRIMITIVE = 0x20; 
	 
	private static int __index; 
	private final String _name; 
	private final int _id;   
	private final Class<?>[] _interfaces; 
	private final Class<? super T> _baseType; 
	private final int _type;
	private final Object _constructor;   
	
	/*
	 * Constructor. Only the Java Virtual Machine creates Class
	 * objects.
	 */
	public Class(String name, Object ctor, Class<? super T> baseType, Class<?>[] interfaces, int type) {
		this._name = name; 
		this._constructor = ctor; 
		this._id = __index++;
		this._type = type; 
		this._interfaces = interfaces;
		this._baseType = baseType;
	}
	public String toString() { 
		return (isInterface ? "interface " : (isPrimitive ? "" : "class ")) + name;
	}
	public boolean isInstance(Object obj){
		if (obj == null)
			return false; 

		return this.isAssignableFrom(obj.getClass());
	}
	public boolean isAssignableFrom(Class<?> cls){
		if (cls == null)
			return false;

		if (this == cls)
			return true; 

		if (cls.isSubclassOf(this)) 
			return true; 

		if (this.isInterface) 
		{
			return cls.implementInterface(this);
		}

		return false;
 	}
  
	public Class<?> baseType{
		&{
			return this._baseType;
		}
	}
	
	public boolean isSubclassOf(Class<?> c)
	{
		Class<?> p = this;
	    if (p == c) 
	      return false;
	    while (p != null) { 
	      if (p == c)
	        return true;
	      p = p.baseType;
	    } 
	    return false;
	}
  
	public boolean implementInterface(Class<?> ifaceType) 
	{ 
	  	Class<?> t = this;
	    while (t != null)
	    { 
	    	Class<?>[] interfaces = t.interfaces;
	    	if (interfaces != null) 
	    	{ 
	    		for (int i = 0; i < interfaces.length; i++)
	    		{ 
	    			// Interfaces don't derive from other interfaces, they implement them.
	    			// So instead of IsSubclassOf, we should use ImplementInterface instead.
	    			if (interfaces[i] == ifaceType || (interfaces[i] != null && interfaces[i].implementInterface(ifaceType))) 
	    				return true;
	    		} 
	    	} 
	
	    	t = t.baseType; 
    	}

    	return false;
 	}
	
	public Object factory {
		&{
			return this._constructor;
		}
	}
  
	// This property will return all of the interfaces implemented by a class 
	public Class<?>[] interfaces{
		&{
			return this._interfaces;
		}
	}
  
	public String name{
		&{
			return this._name;
		}
	}
  
	public int id{
		&{
			return this._id;
		}
	}

	public boolean isInterface{
		&{
			return (this._type & INTERFACE) != 0;
		}
	}
	
	public boolean isArray{
		&{
			return (this._type & ARRAY) != 0;
		}
	}

	public boolean isPrimitive{
		&{
			return (this._type & PRIMITIVE) != 0;
		}
	}
  
	public int hashCode(){
		return this._id;
	}
  
	public native Object newInstance()/*-{
	  	return new (this.ctor)();
  	}-*/;
}


public native class Object { 
	public native Object();
	public native Object(Object value);
	
	public native Object this[String name];
	
	public static native Object create(Object prototype, Object descriptors);
	
	public static native Object defineProperties(Object obj, Object descriptors);
	
	public static native Object defineProperty(Object obj, String name, Object descriptor);
	public native static void freeze(Object object); 
	public static native Object getOwnPropertyDescriptor(Object object, String propertyname);
	public static native String[] getOwnPropertyNames();  

	public static native boolean isExtensible(Object object);  
	public static native boolean isFrozen(Object object); 
	public static native boolean isSealed(Object object);   
	 
	public static native String[] keys(Object object);  
	
	public static native void preventExtensions(Object object); 
	
	public static native void seal(Object object); 
	public static native Object getPrototypeOf(); 
	
	public native boolean hasOwnProperty(String propName);

	public native String toString();
	public native String toLocaleString();
	
	public native boolean isPrototypeOf(Object object);
	public native boolean propertyIsEnumerable(String proName);
	
	public native Object valueOf();
	
	public native Object prototype{}
	
	public native Function constructor{}
	
	public native Object __proto__{}

	
	public int hashCode(){
		return 0;
	}
	
	public native Class<? extends Object> getClass()/*-
	{
		return this.__class; 
	}
	-*/;
	
	public boolean equals(Object that) {
		if(this == that){
			return true;
		}
		
		return false;
	}
	
  /**
   * Creates and returns a copy of this object. The precise meaning
   * of "copy" may depend on the class of the object. The general
   * intent is that, for any object {@code x}, the expression:
   * <blockquote>
   * <pre>
   * x.clone() != x</pre></blockquote>
   * will be true, and that the expression:
   * <blockquote>
   * <pre>
   * x.clone().getClass() == x.getClass()</pre></blockquote>
   * will be {@code true}, but these are not absolute requirements.
   * While it is typically the case that:
   * <blockquote>
   * <pre>
   * x.clone().equals(x)</pre></blockquote>
   * will be {@code true}, this is not an absolute requirement.
   * <p>
   * By convention, the returned object should be obtained by calling
   * {@code super.clone}. If a class and all of its superclasses (except
   * {@code Object}) obey this convention, it will be the case that
   * {@code x.clone().getClass() == x.getClass()}.
   * <p>
   * By convention, the object returned by this method should be independent
   * of this object (which is being cloned). To achieve this independence,
   * it may be necessary to modify one or more fields of the object returned
   * by {@code super.clone} before returning it. Typically, this means
   * copying any mutable objects that comprise the internal "deep structure"
   * of the object being cloned and replacing the references to these
   * objects with references to the copies. If a class contains only
   * primitive fields or references to immutable objects, then it is usually
   * the case that no fields in the object returned by {@code super.clone}
   * need to be modified.
   * <p>
   * The method {@code clone} for class {@code Object} performs a
   * specific cloning operation. First, if the class of this object does
   * not implement the interface {@code Cloneable}, then a
   * {@code CloneNotSupportedException} is thrown. Note that all arrays
   * are considered to implement the interface {@code Cloneable} and that
   * the return type of the {@code clone} method of an array type {@code T[]}
   * is {@code T[]} where T is any reference or primitive type.
   * Otherwise, this method creates a new instance of the class of this
   * object and initializes all its fields with exactly the contents of
   * the corresponding fields of this object, as if by assignment; the
   * contents of the fields are not themselves cloned. Thus, this method
   * performs a "shallow copy" of this object, not a "deep copy" operation.
   * <p>
   * The class {@code Object} does not itself implement the interface
   * {@code Cloneable}, so calling the {@code clone} method on an object
   * whose class is {@code Object} will result in throwing an
   * exception at run time.
   *
   * @return   a clone of this instance.
   * @throws CloneNotSupportedException if the object's class does not
   *        support the {@code Cloneable} interface. Subclasses
   *        that override the {@code clone} method can also
   *        throw this exception to indicate that an instance cannot
   *        be cloned.
   * @see java.lang.Cloneable
   */
  protected Object clone() throws CloneNotSupportedException{
		return __proto__;
  	
  }
  public static boolean equals(Object left, Object right) {
	  return false;
  }
}

public abstract class Throwable implements Serializable {
	private static final long serialVersionUID = 1L;
    public String message{}
    public String description{};

}

public native class Error extends Throwable{
	private static final long serialVersionUID = 1L;

	public native Error();
	
	public native Error(int number);
	
	public native Error(int number, String message);
	public native String description{}
	public native String message {}
	public native String name{}
	public native Number number{}
	public native Object prototype{}

	public native Object stack{}
	public native Object stackTraceLimit{}
	
	public native String valueOf();
}

public native class Array<T> {  

	public native Array();
	public native Array(int size);
	public native Array(Object ... elements);
	
	public T this[int index];   
	public native int length{}
	
	public native Array<T> slice();  
	
	public static native boolean isArray(Object object);
	
	public native Array<T> concat(T ... item); 
	
	public native boolean every(ArrayCallback<T> callback);
	
	public native boolean every(ArrayCallback<T> callback, Object context);
	
	public native Array<T> filter(ArrayCallback<T> callback);
	
	public native Array<T> filter(ArrayCallback<T> callback, Object context);
	
	public native void forEach(ArrayCallback<T> callback);
	 
	public native void forEach(ArrayCallback<T> callback, Object context);
	
	public native int indexOf(T searchElement);
	
	public native int indexOf(T searchElement, int fromIndex); 
	 
	public native String join();
	 
	public native String join(String separator); 
	
	public native int lastIndexOf(T searchElement);
	
	public native int lastIndexOf(T searchElement, int fromIndex);
	
	public native Array<T> map(ArrayCallback callbackfn);
	
	public native T pop();
	
	public native int push(T ... item);
	
	public native int reduce(ReduceCallback<T> callbackfn);
	
	public native int reduce(ReduceCallback<T> callbackfn, int initialValue);
	
	public native Object reduceRight(ReduceCallback<T> callbackfn);
	
	public native Object reduceRight(ReduceCallback<T> callbackfn, int initialValue);
	
	public native Array<T> reverse();
	
	public native T shift();
	
	public native Array<T> slice(int start);
	
	public native Array<T> slice(int start, int end);
	
	public native boolean some(ArrayCallback<T> callbackfn);
	
	public native boolean some(ArrayCallback<T> callbackfn, Object thisContext);
	
	public native Array<T> sort(Comparator<T> sortFunction);
	
	public native Array<T> splice(int start, int deleteCount);
	
	public native Array<T> splice(int start, int deleteCount, T ... items);
	
	public native void unshift(T ... item);
	
	public native Array<T> valueOf();
}

public function void ArrayCallback<T>(T value, int index, Array<T> array);

public function void ReduceCallback<T>(T previousValue, T currentValue, int currentIndex, Array<T> array);

/**
 * Compares this object with the specified object for order.  Returns a
 * negative integer, zero, or a positive integer as this object is less
 * than, equal to, or greater than the specified object.
 *
 * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
 * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
 * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
 * <tt>y.compareTo(x)</tt> throws an exception.)
 *
 * <p>The implementor must also ensure that the relation is transitive:
 * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
 * <tt>x.compareTo(z)&gt;0</tt>.
 *
 * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
 * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
 * all <tt>z</tt>.
 *
 * <p>It is strongly recommended, but <i>not</i> strictly required that
 * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
 * class that implements the <tt>Comparable</tt> interface and violates
 * this condition should clearly indicate this fact.  The recommended
 * language is "Note: this class has a natural ordering that is
 * inconsistent with equals."
 *
 * <p>In the foregoing description, the notation
 * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
 * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
 * <tt>0</tt>, or <tt>1</tt> according to whether the value of
 * <i>expression</i> is negative, zero or positive.
 *
 * @param   o the object to be compared.
 * @return  a negative integer, zero, or a positive integer as this object
 *          is less than, equal to, or greater than the specified object.
 *
 * @throws NullPointerException if the specified object is null
 * @throws ClassCastException if the specified object's type prevents it
 *         from being compared to this object.
 */
public function int Comparator<T>(T o1, T o2);
  
public native class Boolean { 
	public native Boolean valueOf();
}

public class Byte extends Number{ 
	public native Byte(Object value)/*- 
	{ 
		return new Number(value);
	} -*/; 
	public native Byte valueOf();
}

public class Double extends Number{
	public native Double(Object value)/*- 
	{
		return new Number(value);
	} -*/; 
	
	public native Double valueOf();
}

public class Float extends Number{
	public native Float(Object value)/*- 
	{
		return new Number(value);
	} -*/;
	
	public native Float valueOf();
}

public native final class Function {

	public native arguments arguments{};

	public native void apply(Object context);

	public native void apply(Object context, arguments argument);

	public native void call(Object context, Object... pars);

	public native Function bind(Object thisArg);

	public native Function bind(Object thisArg, Object... args);

}

public final native class Math {  
	private native Math();
	/**
	 * The mathematical constant e. This is Euler's number, the base of natural
	 * logarithms. 2.718
	 */
	public static native float E{} // = 2.718f;

	/**
	 * The natural logarithm of 2. 
	 */
	public static native float LN2{} // = 0.693f;
	/**
	 * 
	 */
	public static native float LN10{} // = 2.302f; 
	/**
	 * The base-2 logarithm of e.
	 */
	public static native float LOG2E{} // = 1.443f;
	/**
	 * The base-10 logarithm of e.
	 */
	public static native float LOG10E{} // = 0.434f;
	/**
	 * Pi. This is the ratio of the circumference of a circle to its diameter.
	 */
	public static native float PI{} // = 3.14159f;
	/**
	 * The square root of 0.5, or, equivalently, one divided by the square root
	 * of 2.
	 */
	public static native float SQRT1_2{} // = 0.707f;
	/**
	 * The square root of 2.
	 */
	public static final float SQRT2{} // = 1.414f;

	public static native int abs(int number);
	public static native long abs(long number);
	public static native float abs(float number);
	public static native double abs(double number);

	public static native double acos(double number);

	public static native double asin(double number);

	public static native double atan(double number);

	public static native double atan2(double x, Number y);

	public static native double ceil(double number);

	public static native double cos(double number);

	public static native double exp(double number);
 
	public static native double floor(double number);

	public static native double log(double number);

//	public static native double max(double... number);  
//	public static native float max(float... number);
//	public static native int max(int... number);
//	public static native long max(long... number); 
	public static native Number max(Number... number); 

//	public static native double min(double... number);
//	public static native float min(float... number); 
//	public static native int min(int... number);
//	public static native long min(long... number); 
	public static native long Number(long... number); 

	public static native double pow(double base, double exponent);

	public static native double random();

	public static native int round(float number);
	public static native long round(double number);

	public static native double sin(double radians);

	public static native double sqrt(double number);

	public static native double tan(double radians); 

}


public native class Number {
	public native Number(Object value);
	
	/**
	 * The largest number that can be represented in JavaScript. Equal to approximately 1.79E+308.
	 */
	public native static Number MAX_VALUE{}
	
	/**
	 * The closest number to zero that can be represented in JavaScript. Equal to approximately 5.00E-324.
	 */
	public native static Number MIN_VALUE{}
	
	/**
	 * 	A value that is not a number. In equality comparisons, NaN does not equal any value, including itself. To test whether a value is equivalent to NaN, use the isNaN function.
	 */
	public native static Number NaN{}

	/**
	 * 	A value that is less than the largest negative number that can be represented in JavaScript. JavaScript displays NEGATIVE_INFINITY values as -infinity.
	 */
	public native static Number NEGATIVE_INFINITY{}
	
	/**
	 * A value greater than the largest number that can be represented in JavaScript. 	JavaScript displays POSITIVE_INFINITY values as infinity.
	 */
	public native static Number POSITIVE_INFINITY{}

	
	public native String toString(int radix);
	
	public native String toExponential();
	
	public native String toExponential(int fractionDigits);
	
	public native String toFixed();
	
	public native String toFixed(int fractionDigits);
	
	public native String toLocaleString();
	
	public native String toLocaleString(String[] locales);
	
	public native String toLocaleString(String[] locales, Object options);
	
	public native Number toPrecision();
	
	public native Number toPrecision(int precision);
	
	public native Number valueOf();
}


public native final class String {
	public native String(String literal); 

	public native int length{&;}
	
	public native static String fromCharCode(int ... charCode);
	/**
	 * Places an HTML anchor that has a NAME attribute around the text. The name
	 * parameter is text to put in the NAME attribute of the HTML anchor.
	 */
	public native String anchor(String name);

	/**
	 * Places HTML <BIG> tags around the text. Discouraged
	 */
	public native String big();

	/**
	 * Places HTML <BLINK> tags around the text. The <BLINK> tag is not
	 * supported in Internet Explorer. Not in standard
	 */
	public native String blink();

	/**
	 * Places HTML <B> tags around the text. Discouraged
	 */
	public native String bold();

	/**
	 * Places HTML <TT> tags around the text.
	Discouraged
	 */
	public native String fixed();

	/**
	 * Places HTML <FONT> tags with a COLOR attribute around the text. The color
	 * parameter is a string value that contains the hexadecimal value or
	 * predefined name for a color. Valid predefined color names depend on the
	 * JavaScript host browser and its version. Deprecated
	 */
	public native String fontcolor(String color);

	/**
	 * Places HTML <FONT> tags with a SIZE attribute around the text. The size
	 * parameter is an integer value that specifies the size of the text. Valid
	 * integer values depend on the JavaScript host browser and its version.
	 * Deprecated
	 */
	public native String fontsize(int size);

	/**
	 * Places HTML <I> tags around the text. Discouraged
	 */
	public native String italics();

	/**
	 * Places an HTML anchor that has an HREF attribute around the text. The
	 * href parameter is text to put in the HREF attribute of the HTML anchor.
	 */
	public native String link(String href);

	/**
	 * Places HTML <SMALL> tags around the text. Discouraged
	 */
	public native String small();

	/**
	 * Places HTML <STRIKE> tags around the text. Deprecated
	 */
	public native String strike();

	/**
	 * Places HTML <SUB> tags around the text.
	 */
	public native String sub();

	/**
	 * Places HTML <SUP> tags around the text.
	 */
	public native String sup();

	public native int charCodeAt(int index);

	public native String concat(String... strs);

	public native int indexOf(String subString);

	public native int indexOf(String subString, int startIndex);

	public native int lastIndexOf(String subString);

	public native int lastIndexOf(String subString, int startIndex);

	public native int localeCompare(String stringExp);

	public native int localeCompare(String stringExp, String[] locales);

	public native int localeCompare(String stringExp, String[] locales,
			Object options);

	public native String[] match(RegExp regexp);

	public native String replace(RegExp rgExp, String replaceText);

	public native String search(RegExp rgExp);

	public native String slice(int start);

	public native String slice(int start, int end);

	public native String charAt(int index);

	public native String[] split();

	public native String[] split(String separator);

	public native String[] split(String separator, int limit);

	public native String substr(int start);

	public native String substr(int start, int length);

	public native String substring(int start);

	public native String substring(int start, int end);

	public native String toLocaleLowerCase();

	public native String toLocaleUpperCase();

	public native String toLowerCase();

	public native String toUpperCase();

	public native String trim();

	public native String valueOf();
	
	public native String this[int index];
	
	public boolean isWhiteSpace() {
		String whitespaceChars = " \t\n\r\f";
		return (whitespaceChars.indexOf(this) != -1);
	}
	
  public static String Empty = "";
  public static boolean isNullOrEmpty(String str){
  	if(str == null || str == String.Empty){
  		return true;
  	}
  	return false;
  }
  
  public native char this[int index];

}


public native final class RegExp {
	public native RegExp(String pattern, String flag);
	
	public native final String index{&;}
	
	public native final String input{&;}
	
	public native final String lastIndex{&;}
	
	public native final String lastMatch{&;}
	
	public native final String lastParen{&;}
	
	public native final String leftContext{&;}
	
	public native final String rightContext{&;}
	
	public native final String $1{&;}
	
	public native final String $2{&;}
	
	public native final String $3{&;}
	
	public native final String $4{&;}
	
	public native final String $5{&;}
	
	public native final String $6{&;}
	
	public native final String $7{&;}
	
	public native final String $8{&;}
	
	public native final String $9{&;}
	
	public native void compile(String regexp, String modifier);
	
	public native String[] exec(String string);
	
	public native boolean test(String string);
}

public class Short extends Number{
	public native Short(Object value)/*- 
	{
		return new Number(value);
	} -*/;
	
	public native Short valueOf();
}

public class Character extends Number{ 
	public native Character(Object value)/*- 
	{
		return new Number(value);
	} -*/;
	
	public native Short valueOf();
}

public class Long extends Number{
	public native Long(Object value)/*- 
	{
		return new Number(value);
	} -*/;
		
	public native Long valueOf(); 
}

public class Integer extends Number{
	public native Integer valueOf();
	
	public static final int MIN_VALUE = -2147483648;
	 
	// Field descriptor #96 I
    public static final int MAX_VALUE = 2147483647;
  
    public native Integer(Object value)/*- 
	{
		return new Number(value);
	} -*/;
}


/**
 * The class {@code Exception} and its subclasses are a form of
 * {@code Throwable} that indicates conditions that a reasonable
 * application might want to catch.
 *
 * <p>The class {@code Exception} and any subclasses that are not also
 * subclasses of {@link RuntimeException} are <em>checked
 * exceptions</em>.  Checked exceptions need to be declared in a
 * method or constructor's {@code throws} clause if they can be thrown
 * by the execution of the method or constructor and propagate outside
 * the method or constructor boundary.
 *
 * @author  Frank Yellin
 * @see     java.lang.Error
 * @jls 11.2 Compile-Time Checking of Exceptions
 * @since   JDK1.0
 */
public class Exception extends Throwable {
    static final long serialVersionUID = -3387516993124229948L;
    private String _message;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    @Overload("1")
    public Exception() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    @Overload("2")
    public Exception(String message) {
        this._message = message;
    }

	public String getMessage() {
		return _message;
	}

	public String getLocalizedMessage() {
		return _message;
	}
}

/**
 * {@code RuntimeException} is the superclass of those
 * exceptions that can be thrown during the normal operation of the
 * Java Virtual Machine.
 *
 * <p>{@code RuntimeException} and its subclasses are <em>unchecked
 * exceptions</em>.  Unchecked exceptions do <em>not</em> need to be
 * declared in a method or constructor's {@code throws} clause if they
 * can be thrown by the execution of the method or constructor and
 * propagate outside the method or constructor boundary.
 *
 * @author  Frank Yellin
 * @jls 11.2 Compile-Time Checking of Exceptions
 * @since   JDK1.0
 */
public class RuntimeException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    /** Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    @Overload("1")
    public RuntimeException() {
        super();
    }

    /** Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    @Overload("2")
    public RuntimeException(String message) {
        super(message);
    }
}

/**
 * Thrown when an application attempts to use {@code null} in a
 * case where an object is required. These include:
 * <ul>
 * <li>Calling the instance method of a {@code null} object.
 * <li>Accessing or modifying the field of a {@code null} object.
 * <li>Taking the length of {@code null} as if it were an array.
 * <li>Accessing or modifying the slots of {@code null} as if it
 *     were an array.
 * <li>Throwing {@code null} as if it were a {@code Throwable}
 *     value.
 * </ul>
 * <p>
 * Applications should throw instances of this class to indicate
 * other illegal uses of the {@code null} object.
 *
 * {@code NullPointerException} objects may be constructed by the 
 * virtual machine as if {@linkplain Throwable#Throwable(String,
 * Throwable, boolean, boolean) suppression were disabled and/or the
 * stack trace was not writable}.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public class NullPointerException extends RuntimeException {
    private static final long serialVersionUID = 5162710183389028792L;

    /**
     * Constructs a {@code NullPointerException} with no detail message.
     */
    public NullPointerException() {
        super();
    }

    /**
     * Constructs a {@code NullPointerException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public NullPointerException(String s) {
        super(s);
    }
}

/**
 * Thrown when an application tries to load in a class through its
 * string name using:
 * <ul>
 * <li>The <code>forName</code> method in class <code>Class</code>.
 * <li>The <code>findSystemClass</code> method in class
 *     <code>ClassLoader</code> .
 * <li>The <code>loadClass</code> method in class <code>ClassLoader</code>.
 * </ul>
 * <p>
 * but no definition for the class with the specified name could be found.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The "optional exception
 * that was raised while loading the class" that may be provided at
 * construction time and accessed via the {@link #getException()} method is
 * now known as the <i>cause</i>, and may be accessed via the {@link
 * Throwable#getCause()} method, as well as the aforementioned "legacy method."
 *
 * @author  unascribed
 * @see     java.lang.Class#forName(java.lang.String)
 * @see     java.lang.ClassLoader#findSystemClass(java.lang.String)
 * @see     java.lang.ClassLoader#loadClass(java.lang.String, boolean)
 * @since   JDK1.0
 */
public class ClassNotFoundException extends RuntimeException {
    /**
     * use serialVersionUID from JDK 1.1.X for interoperability
     */
     private static final long serialVersionUID = 9176873029745254542L;

    /**
     * Constructs a <code>ClassNotFoundException</code> with no detail message.
     */
    public ClassNotFoundException() {
        
    }

    /**
     * Constructs a <code>ClassNotFoundException</code> with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public ClassNotFoundException(String s) {
        super(s);  
    }
}

/**
 * Thrown to indicate that the <code>clone</code> method in class
 * <code>Object</code> has been called to clone an object, but that
 * the object's class does not implement the <code>Cloneable</code>
 * interface.
 * <p>
 * Applications that override the <code>clone</code> method can also
 * throw this exception to indicate that an object could not or
 * should not be cloned.
 *
 * @author  unascribed
 * @see     java.lang.Cloneable
 * @see     java.lang.Object#clone()
 * @since   JDK1.0
 */

public class CloneNotSupportedException extends Exception {
    private static final long serialVersionUID = 5195511250079656443L;

    /**
     * Constructs a <code>CloneNotSupportedException</code> with no
     * detail message.
     */
    public CloneNotSupportedException() {
        super();
    }

    /**
     * Constructs a <code>CloneNotSupportedException</code> with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public CloneNotSupportedException(String s) {
        super(s);
    }
}

public native class arguments {
	public native final int length{};
}

public native class Set<T> {
	public native int size{}
	/**
	 * 	Adds an element to a set.
	 */
	public native void add(T element);

	/**
	 * 	Removes all elements from a set.
	 */
	public native void clear();

	/**
	 * 	Removes a specified element from a set.
	 */
	public native boolean delete(T element);

	/**
	 * 	Performs the specified action for each element in a set.
	 */
	public native void forEach(SetCallback<T> callback);
	public native void forEach(SetCallback<T> callback, Object thisContext);

	/**
	 * 	Returns true if the set contains a specified element.
	 */
	public native boolean has(T element);

}

public native class Map<K, V> {
	public native int size{}
	/**
	 * 	Adds an element to a set.
	 */
	public native void set(K key, V element);

	/**
	 * 	Removes all elements from a set.
	 */
	public native void clear();

	/**
	 * 	Removes a specified element from a set.
	 */
	public native boolean delete(K key);

	/**
	 * 	Performs the specified action for each element in a set.
	 */
	public native void forEach(MapCallback<K, V> callback);
	public native void forEach(MapCallback<K, V> callback, Object thisContext);
	
	public native V get(K key);

	/**
	 * 	Returns true if the set contains a specified element.
	 */
	public native boolean has(K key);

}

public function void MapCallback<K, V>(V value, K key, Map<K, V> mapObj);

public function void SetCallback<T>(T value, int index, Array<T> array1); 

/**
 * 
 * @author cym
 * 
 */
public abstract class Template {
	public final Node create(Node parent){
		return doCreate(parent);
	}
	
	protected Node doCreate(Node parent){
		throw new Error(0, "illegal call!");
	}
}

public abstract class ItemTemplate {
	public final Node create(Node parent, Object item){
		Node root = createRoot(parent);
		root.dataContext = new DataContext(item);
		parent.appendChild(root);
		createChild(root);
		return root;
	}
	
	public Node createChild(Node parent){
		throw new Error(0, "illegal call!");
	}
	
	public Node createRoot(Node parent){
		throw new Error(0, "illegal call!");
	}
}

/**
 * 
 * @author cym
 *
 */
public abstract class Component {
	public void create(HTMLElement parent){
		doCreate(parent);
	}
	
	protected void doCreate(HTMLElement parent){
		throw new Error(0, "illegal call!");
	}
}

/**
 * Implementing this interface allows an object to be the target of
 * the "for-each loop" statement. See
 * <strong>
 * <a href="{@docRoot}/../technotes/guides/language/foreach.html">For-each Loop</a>
 * </strong>
 *
 * @param <T> the type of elements returned by the iterator
 *
 * @since 1.5
 * @jls 14.14.2 The enhanced for statement
 */
public interface Iterable<T> {
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    Iterator<T> iterator(); 

    /**
     * Performs the given action on the contents of the {@code Iterable}, in the
     * order elements occur when iterating, until all elements have been
     * processed or the action throws an exception.  Errors or runtime
     * exceptions thrown by the action are relayed to the caller.
     *
     * @implSpec
     * <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action(t);
        }
    }
}

public function R Operator<T, R> (T t);

public function T UnaryOperator<T> (T t);

public function void Consumer<T>(T t);
