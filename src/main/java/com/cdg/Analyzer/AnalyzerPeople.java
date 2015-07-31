/**
 * 파일명 : AnalyzerPeople.java
 * 작성일 : 2015. 7. 23.
 * 파일설명 : 
 */
package com.cdg.Analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.cdg.Analyzer.People.ValueComparator;

/**
 * @author 임승한(lim_designer@naver.com)
 */

/*
 * AAA님이 자주 사용하는 단어 1. ㅁㅁㅁ 2. ㅇㅇ 3. ㅎㅎㅎ 4. ㄹㄹㄹㄹ 5. ㅇㅇㅇㅇㅇ
 */
public class AnalyzerPeople {

	private String people;
	private List<String> line = new ArrayList<String>();
	private AnalyzerWord analyzerWord = new AnalyzerWord();
	ArrayList<People> peopleList = new ArrayList<People>();
	ArrayList<String> nameList = new ArrayList<String>();

	public AnalyzerPeople(List<String> line) {
		this.line = line;
	}

	public void start() {

		ListIterator<String> iterator = line.listIterator();
		// System.out.println(line);

		// next()를 호출하기 전에 hasNext()를 호출해서 읽어올 요소가 있는지 먼저 확인한다.
		while (iterator.hasNext()) {
			String string = (String) iterator.next();

			if (string.length() == 0 || string.charAt(0) != '[') {
				continue;
			}

			String[] split = string.split("] ", 3);

			String name = split[0].substring(1);

			createPeople(name);

			// addMessage(대화내용, 사용자이름)
			addMessage(split[2], name);
		}
		
		People people = new People(null);
		people.printPeople(peopleList);
	}


	private void createPeople(String name) {
		// System.out.println(name);
		// nameList에 name(사용자 이름)이 포함되어 있지 않다면 nameList에 추가하고
		// Class People을 생성하면서 인자값으로 name(사용자 이름)을 넘겨준다.
		if (!nameList.contains(name)) {
			nameList.add(name);
			peopleList.add(new People(name));
		}
	}

	private void addMessage(String sp2, String name) {
		for (People people : peopleList) {
			if (people.getName().equals(name)) {
				people.analyze(sp2);
			}
		}
	}
}

class People {

	private String name;
	private AnalyzerWord analyzerWord = new AnalyzerWord();

	private Map<String, Integer> map = new HashMap<String, Integer>();

	public People(String name) {
		// System.out.println(name);
		this.name = name;
	}

	// String contents <-- 채팅내용만 들어있음
	public void analyze(String contents) {
		// System.out.println(contents);

		// 채팅내용을 매서드 addContents에 입력하여 split으로 단어 구분
		analyzerWord.addContents(contents);

		// split으로 구분된 단어(String)와 사용된 단어의 횟수(Integer)를 받아 변수 map에 대입
		map = analyzerWord.getMap();
		// System.out.println(map);
	}

	public String getName() {
		// System.out.println(name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getMap() {
		//System.out.println(map);
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public void printPeople(ArrayList<People> peopleList) {

		for (People people : peopleList) {
			printPerson(people.getName(), people.getMap());
		}
	}

	private void printPerson(String name, Map<String, Integer> map) {

		StringBuffer buffer = new StringBuffer();
		List list = sortMap(map);

		buffer.append(name + "\n");

		Iterator it = list.iterator();
		
		// 3순위까지 출력.
		for (int i = 0; i < 3; i++) { 

			if (it.hasNext()) {
				String str = it.next().toString();
				buffer.append((i + 1) + ". ");
				buffer.append(str.substring(0, str.indexOf("=")) + "\n");
			}

		}

		System.out.println(buffer);
	}

	private List sortMap(Map<String, Integer> map) {
		Set set = map.entrySet();
		List list = new ArrayList(set);
		Collections.sort(list, new ValueComparator());
		return list;
	}

	class ValueComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;

				int v1 = ((Integer) e1.getValue()).intValue();
				int v2 = ((Integer) e2.getValue()).intValue();

				return v2 - v1;
			}
			return -1;
		}
	}
}
