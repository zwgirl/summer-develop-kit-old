
interface T{
	default void test(int i){
		
	}
}

interface T1{
	default void test1(int i){
		
	}
}

class SS{
	public void test1(int i){
//		super.test1();	
	}
	
	public void test(int i){
		
	}
}

class TT extends SS implements T, T1{
//	public void test1(int i){
//	}
//	
//	public void test(int i){
//		
//	}
}

class Test111{
	void dd(){
		TT t = new TT();
		t.test1(10);
	}
}
