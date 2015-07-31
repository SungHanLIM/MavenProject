/**
 * 파일명 : PopularWord.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.Analyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 임승한(lim_designer@naver.com)
 */
public class AnalyzerWord {
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// default 생성자
	AnalyzerWord() {
	}

	// add 매서드
	public void addContents(String word) {
		String[] sp = word.split(" "); // sp = "사진 안녕 등등등"

		for (int i = 0; i < sp.length; i++) {

			if (map.containsKey(sp[i])) {
				int count = map.get(sp[i]);
				map.replace(sp[i], ++count);
			} else {
				map.put(sp[i], 1);
			}
		}
	}

	// getMap() 매서드
	/*
	 * return값 : {화이팅~!=1, 보는=1, 기사셤=1, 애기들=1} {화이팅~!=1, 붙어부려=1, 보는=1, 한방에=1,
	 * 기사셤=1, 애기들=1} ...
	 */
	public Map<String, Integer> getMap() {
		//System.out.println(map);
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
}
