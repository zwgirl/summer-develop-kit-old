
public class Person {
	private String _name;
	private int _age;
	
	public Person(String name, int age){
		this._name =name;
		this._age = age;
	}
	public String name{
		&{
			return this._name;
		}
		+{
			this._name = value;
		}
	}
	

	public int age{
		&{
			return this._age;
		}
		+{
			this._age = value;
		}
	}
}
