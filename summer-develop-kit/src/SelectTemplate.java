import org.w3c.html.*;
import org.w3c.dom.*;
/**
 * 
 * @author cym
 *
 */
public class SelectTemplate extends ItemTemplate {
	  <option value ={Binding property = "name" mode = "OneWay" }>
	  	<Text data={Binding property = "age" mode = "OneWay"} />
	  </option>
}
 