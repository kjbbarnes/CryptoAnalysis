package com.kyleb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FrequencyAnalysis {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String filename, ciphertext = null;
		char character;
		int count = 0, atLetter = 0;
		int [] letterCounts = new int[26]; 
		float [] letterPercent = new float[26];
		
		try {
			filename = args[0];
		} catch (Exception e) {
			System.out.print("Filename: ");
			filename = scanner.nextLine();
		}
		
		try {
			ciphertext = getCiphertext(filename);
		} catch (IOException e) {
			System.exit(1);
		}
		
		for(char i = 'a'; i <= 'z'; i++) {
			count = 0;
			for(int j = 0; j < ciphertext.length(); j++) {
				character = ciphertext.charAt(j);
				if(character == i) count++;
			}
			letterCounts[atLetter] = count;
			atLetter++;
		}
		
		for(int k = 0; k < 26; k++) {
			letterPercent[k] = (float) letterCounts[k]/(float) ciphertext.length() * 100;
		}
		
		printVerticalHistogram(largestPercentInArray(letterPercent), letterPercent);
		
		scanner.close();

	}
	
	public static String getCiphertext(String filename) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line = reader.readLine();
		line = line.toLowerCase();
		reader.close();
		return line;
		
	}
	
	public static void printVerticalHistogram(float rows, float asterisks[]) {
		
		while (rows > 0) {
			for(int i = 0; i < asterisks.length; i++) {
				if(i == 0) {
					if(asterisks[i] < rows) System.out.printf(" %s   ", " ");
					else System.out.printf(" %s   ", "*");
				} else {
					if(asterisks[i] < rows) System.out.printf("%s   ", " ");
					else System.out.printf("%s   ", "*");
				}
			}
			System.out.println();
			rows--;
		}
		System.out.printf(" %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s   %s", "a", "b",
				"c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
		System.out.println();
		System.out.printf("%.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f %.1f", asterisks[0],
				asterisks[1],asterisks[2],asterisks[3],asterisks[4],asterisks[5],asterisks[6],asterisks[7],asterisks[8],asterisks[9],asterisks[10],
				asterisks[11],asterisks[12],asterisks[13],asterisks[14],asterisks[15],asterisks[16],asterisks[17],asterisks[18],asterisks[19],asterisks[20],
				asterisks[21],asterisks[22],asterisks[23],asterisks[24],asterisks[25]);
		
	}
	
	public static float largestPercentInArray(float letterPercent[]) {
		
		float largestPercent = 0;
		for(int i = 0; i < 26; i++) {
			if(letterPercent[i] > largestPercent) largestPercent = letterPercent[i];
		}
		return largestPercent;
		
	}
	
}
