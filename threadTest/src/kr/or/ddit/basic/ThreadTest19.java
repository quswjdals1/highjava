package kr.or.ddit.basic;

public class ThreadTest19 {

}

class DataBox{
	private String value;
	
	/*
		데이터를 꺼내는 메서드
		==> value변수값이 null이면 value변수에 문자열이 채워질때까지 기다리고,
		value에 값이 있으면 해당 문자열을 반환한다.
		문자열반환 후에는 value 변수를 null로 만든다.
	*/
	
	
	public synchronized String getValue() {
		if(value==null) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		String temp=value;
		System.out.println("쓰레드가 읽은 데이터:" + temp);
		value=null;
		notify();
		return temp;
	}
	
	public synchronized void setValue(String value) {
		if(this.value!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.value=value;
		System.out.println("새로 저장된 데이터: "+this.value);
		notify();

	}
}

class thread extends Thread{
	private DataBox dataBox;
	
	public thread(DataBox dataBox) {
		super();
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.dataBox.setValue(getName());
	}
}
