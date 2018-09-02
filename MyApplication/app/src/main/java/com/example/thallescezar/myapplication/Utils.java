package com.example.thallescezar.myapplication;

import com.example.thallescezar.myapplication.EmailNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Utils {

	public static List<String> possibleWords = Arrays.asList("Black", "Green", "Red", "White", "Blue");

	public static char[] replaceSpaces(char[] input, int size) {

		int header = size - 1;
		int spacesReplaced = 0;
		for(int i = size - 1; i >= 0; i--) {

			if(input[i] == ' ') {
				input[i] = '&';
				header = i;
				shiftPositions(input, header, size + spacesReplaced);				
				input[i + 1] = '3';
				input[i + 2] = '2';
				spacesReplaced += 2;
			}
		}

		
		return input;
	}
	
	public static boolean checkJumbledLetters(char[] word, char[] jumbledWord) {

        if(word.length == jumbledWord.length) {
            if(word[0] != jumbledWord[0]) {
                return false;
            } else {
                int maxNumberOfLetters = (word.length * 2) / 3;
                int count = 0;

                for (int i = 1; i < word.length; i++) {
                    if(word[i] != jumbledWord[i]) {
                        count++;
                    }
                }

                if(count <= maxNumberOfLetters) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
	}

	public static boolean checkTypos(String word, String typo) {

		if(word.length() == typo.length()) {
			return checkLettersForTypo(word, typo);
		} else if (word.length() == typo.length() + 1){
			return contains(word, typo);
		} else if (word.length() + 1 == typo.length()){
			return contains(typo, word);
		} else {
			return false;
		}
	}

	private static void shiftPositions(char[] input, int header, int size) {

		for(int i = size - 1; i > header; i--) {
			input[i+2] = input[i];
			System.out.println(input);
		}
	}

	private static boolean contains(String word, String typo) {
		
		for (int i = 0; i < typo.length(); i++) {
			
			if(!word.contains((typo.charAt(i)+""))) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkLettersForTypo(String word, String typo) {
		
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			
			if(word.charAt(i) != typo.charAt(i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}
	
	public static void removeDuplicate(EmailNode head) {
        
		HashSet<String> hs = new HashSet<>();
        EmailNode current = head;
        EmailNode previous = null;
        
        while (current != null) 
        {
            String currentMessage = current.getMessage();
             
            if (hs.contains(currentMessage)) {
                previous.setNext(current.getNext());
            } else {
                hs.add(currentMessage);
                previous = current;
            }
            current = current.getNext();
        }
    }
	
	public static void printList(EmailNode head) {
        
		while (head != null) 
        {
            System.out.print(head.getMessage() + "->");
            head = head.getNext();
        }
        System.out.println();
    }
	
	public static EmailNode findIntersection(EmailNode headThreadOne, EmailNode headThreadTwo) {
		
		EmailNode nodeOne = headThreadOne;
		EmailNode nodeTwo = headThreadTwo;
		
		while(nodeOne != null) {
			
			while(nodeTwo != null) {
				if(nodeOne == nodeTwo) {
					return nodeOne;
				} else {
					nodeTwo = nodeTwo.getNext();
				}
			}
			
			nodeTwo = headThreadTwo;
			nodeOne = nodeOne.getNext();
		}
		return null;
	}
}
    