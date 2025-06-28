package java1;

import java.util.Arrays;

public class JavaTest {
	public static void main(String[] args) {
		int[] pwArr = new int[4];
		
		for(int i = 0; i < pwArr.length; i++) {
			pwArr[i] = (int)(Math.random()*9);
		}
		System.out.println(Arrays.toString(pwArr)); // z커밋테스트
	}

}
