import org.w3c.dom.Text;
import org.w3c.html.*;
/**
 * 
 * @author cym
 *
 */
public class SelectTemplate1 extends ItemTemplate {
	  <p >
	  	<input value = {Binding property="name" mode = "TwoWay"} />
	  	<Text data = {Binding property="age" mode = "OneWay"} />
	  </p> 
}
 