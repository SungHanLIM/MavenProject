/**
 * 파일명 : ReadFile.java
 * 작성일 : 2015. 7. 21.
 * 파일설명 : 
 */
package com.cdg.ReadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 임승한(lim_designer@naver.com)
 */

public class ReadFile {
	
	public List<String> readFile(File file) {
		List<String> result = new ArrayList<String>();
		// 버퍼 생성
		BufferedReader bufferReader = null;
		// Input 스트림 생성
		InputStreamReader inputStreamReader = null;
		// File Input 스트림 생성
		FileInputStream fileInputStream = null;
		
		// 한줄 씩 읽은 내용을 저장하는 변수
		String line = "";

		try {
			// 파일을 읽어들여 File Input 스트림 객체 생성
			fileInputStream = new FileInputStream(file);
			// File Input 스트림 객체를 이용해 Input 스트림 객체를 생서하는데 인코딩을 UTF-8로 지정
			inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			// Input 스트림 객체를 이용하여 버퍼를 생성
			bufferReader = new BufferedReader(inputStreamReader);
			// 버퍼를 한줄한줄 읽어들여 내용 list에 저장
			while ((line = bufferReader.readLine()) != null) {
				result.add(line);
			}
			//System.out.println(result.get(2));

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}



/*public class ReadFile {
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
*/