/**
 * 파일명 : PopularTime.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.Analyzer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 임승한(lim_designer@naver.com) 가장 많이 대화하는 시간대를 구한다
 */
public class AnalyzerTime {

	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

	private List<String> line = new ArrayList<String>();
	// private ArrayList resultList = new ArrayList();
	private String morning;
	private String afternoon;
	private int timeCounter = 1;

	// PopularTime Class 생성자
	public AnalyzerTime(List<String> line) {
		this.line = line;
	}

	public String start() {

		// 오전 시간 때
		morning = "오전" + " " + "\\d{1,2}";
		// 오후 시간 때
		afternoon = "오후" + " " + "\\d{1,2}";

		Iterator iterator = line.iterator();

		// 대화 시간대 분석
		while (iterator.hasNext()) {
			// 오전 대화 시간대 분석
			String morningInfo = String.format(morning);
			Pattern patternMorning = Pattern.compile(morningInfo);
			Matcher PatternMatchesMorning = patternMorning.matcher(iterator
					.next().toString());

			// 오후 대화 시간대 분석
			String afternoonInfo = String.format(afternoon);
			Pattern patternAfternoon = Pattern.compile(afternoonInfo);
			Matcher PatternMatchesAfternoon = patternAfternoon.matcher(iterator
					.next().toString());

			// 오전
			if (PatternMatchesMorning.find()) {
				String matchResult = PatternMatchesMorning.group(0).trim();
				hashMap.put(matchResult, timeCounter);

				Set set = hashMap.entrySet();
				Iterator it = set.iterator();

				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					if (entry.getKey().equals(matchResult)) {
						this.timeCounter++;
					}
				}
			}

			// 오후
			if (PatternMatchesAfternoon.find()) {
				String matchResult = PatternMatchesAfternoon.group(0).trim();
				hashMap.put(matchResult, timeCounter);

				Set set = hashMap.entrySet();
				Iterator it = set.iterator();

				while (it.hasNext()) {
					Map.Entry entry = (Map.Entry) it.next();
					if (entry.getKey().equals(matchResult)) {
						this.timeCounter++;
					}
				}
			}
		}

		// 가장 많이 대화한 시간대 순서 정렬
		String key = "";
		Set set = hashMap.keySet();
		Collection<Integer> values = hashMap.values();
		
		Iterator it = set.iterator();
		while(it.hasNext()){
			key = (String)it.next();
			int value = hashMap.get(key);
			if(value == Collections.max(values) ) {
				break;
			}
		}

		return key;
	}
}
