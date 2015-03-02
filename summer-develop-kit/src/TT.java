import java.util.List;


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
		int m = (int) Math.max(10,10,10);
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
	
    public void rebox(List<?> box) {
        reboxHelper(box);
    }

    private void reboxHelper<V>(List<V> box) {
//        box[0] = box[0];
    	box.add(box.get(0));
    }
}
