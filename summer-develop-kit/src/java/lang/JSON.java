package java.lang;

public class JSON {
	public native static Object parse(String text);

	public native static Object parse(String text, Function reviver);

	public native static String stringify(Object value);

	public native static String stringify(Object value, Function replacer);

	public native static String stringify(Object value, Function replacer,
			String space);

	public native static String stringify(Object value, Array<String> replacer);

	public native static String stringify(Object value, Array<String> replacer,
			String space);

}
