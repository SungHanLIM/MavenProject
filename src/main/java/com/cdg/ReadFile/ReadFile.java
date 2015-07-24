/**
 * 파일명 : ReadFile.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.ReadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 임승한(lim_designer@naver.com)
 */
public class ReadFile {
	private String fDir;
	private String fName;
	private List<String> list = new ArrayList<String>();

	// ReadFile Class 생성자
	public ReadFile(String fDir, String fName) {
		this.fDir = fDir;
		this.fName = fName;
	}

	// 파일 읽는 매서드
	public List<String> start() {
		File file = new File(fDir + fName);

		try {
			// File 객체 생성(존재하는 파일)
			// 파일 읽기
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String line;

			while ((line = reader.readLine()) != null) {
				list.add(line);
				// System.out.println(line);
			}
			reader.close();
			fileReader.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

}
