package com.example;

import java.util.HashMap;
import java.util.Map;

public class Head {
	

	public Map<String, Object> addHead(String uuid, String chcode) {
		Map<String, Object> head = new HashMap<String, Object>();
		head.put("aid", "lan66");
		head.put("ver", "2.0.6");
		head.put("ln", "cn");
		head.put("mod", "(LeEco)Le X620");
		head.put("mos", "6.0");
		head.put("de", "2017-08-17 16:58:08");
		head.put("sync", 1);
		head.put("uuid", uuid);
		head.put("chcode", chcode);
		head.put("cmd", 3902);
		// TODO Auto-generated method stub
		return head;
	}
	
}
