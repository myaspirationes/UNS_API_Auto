package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListMap {

	static List<Map> lis = new ArrayList<Map>();
	static Map<Object, Object> map = new HashMap<Object, Object>();
	static Map<Object, Object> ma = new HashMap<Object, Object>();

	public static void add() {

		map.put("titleText", "aaa");
		map.put("fileId", "bbb");
		map.put("contentId", "ccc");
		map.put("containerId", "ccc");
		ma.put(1, 1);
		ma.put(2, 2);
		ma.put(3, 3);

		lis.add(map);
		lis.add(ma);

		
	}

}
