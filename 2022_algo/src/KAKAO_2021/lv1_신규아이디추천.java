package KAKAO_2021;

/*
 * @date	22.01.04
 * @풀이시간	30m
 * 어렵진 않았지만 문자열 다루는게 좀 더 능숙하면 좋을 것 같음
 * 특히 알파벳인지, 숫자인지 확인하는 부분 한 번 짚고 가자
 */

import java.io.*;

public class lv1_신규아이디추천 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String new_id = br.readLine();
		new_id = step1(new_id);
//		System.out.println("step1 : " + new_id);
		new_id = step2(new_id);
//		System.out.println("step2 : " + new_id);
		new_id = step3(new_id);
//		System.out.println("step3 : " + new_id);
		new_id = step4(new_id);
//		System.out.println("step4 : " + new_id);
		new_id = step5(new_id);
//		System.out.println("step5 : " + new_id);
		new_id = step6(new_id);
//		System.out.println("step6 : " + new_id);
		new_id = step7(new_id);
//		System.out.println("step7 : " + new_id);
		
		System.out.println(new_id);
	}

	// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	private static String step1(String new_id) {
		return new_id.toLowerCase();
	}

	// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	private static String step2(String new_id) {
		String id = "";
		
		for (int i = 0; i < new_id.length(); i++) {
			char s = new_id.charAt(i);
			if (Character.isDigit(s) || Character.isAlphabetic(s) || s == '-' || s == '_' || s == '.')
				id = id + s;
		}
		
		return id;
	}

	// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	private static String step3(String new_id) {
		String id = "";
		boolean flag = false;
		
		for (int i = 0; i < new_id.length(); i++) {
			char s = new_id.charAt(i);
			if (s == '.') {
				if (!flag) {
					id = id + s;
					flag = true;
				}
				continue;
			}
			id = id + s;
			flag = false;
		}
		
		return id;
	}

	// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	private static String step4(String new_id) {
		int start = 0;
		int end = new_id.length();
		
		if (new_id.charAt(start) == '.')
			start++;
		if (new_id.charAt(end - 1) == '.')
			end--;
		
		if (start > end)
			end = start;
		
		return new_id.substring(start, end);
	}

	// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	private static String step5(String new_id) {
		if (new_id.length() == 0)
			new_id = "a";
		
		return new_id;
	}

	// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	//	    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	private static String step6(String new_id) {
		if (new_id.length() > 15)
			new_id = new_id.substring(0, 15);
		
		return step4(new_id);
	}

	// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	private static String step7(String new_id) {
		while (new_id.length() < 3) {
			new_id = new_id + new_id.charAt(new_id.length() - 1);
		}
		
		return new_id;
	}
}


// 아이디 길이는 3 이상 15 이하
// 알파벳 소문자 - _ . 사용가능
// 단, . 는 처음과 끝에는 사용 불가능, 연속 사용 불가능
