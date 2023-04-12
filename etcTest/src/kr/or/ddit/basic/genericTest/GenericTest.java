package kr.or.ddit.basic.genericTest;


class Generic <T>{
	
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
	
}

class NonGeneric{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
}



public class GenericTest {
	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setValue("가나다라");
		NonGeneric ng2 = new NonGeneric();
		ng2.setValue(100);
		System.out.println(ng1.getValue());
		System.out.println(ng2.getValue());
		
		Generic<String> g1= new Generic<>();
		g1.setValue("asd");
		System.out.println(g1.getValue());
	}
}
