package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 3);
		Set set =map.entrySet();
		
		for (Entry<Integer,Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
