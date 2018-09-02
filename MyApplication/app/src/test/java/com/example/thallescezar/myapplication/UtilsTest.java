package com.example.thallescezar.myapplication;

import junit.framework.TestCase;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class UtilsTest {

    @Test
    public void replaceSpaces() {
        String text = "User is not allowed.";
        String textExpected = "User&32is&32not&32allowed";
        String textWithoutSpaces = new String(Utils.replaceSpaces(createCharArray(text), 19)).trim();

        assertEquals(textExpected, textWithoutSpaces);
    }

    @Test
    public void checkJumbledLetters() {
        String word = "probably";
        String jumbledWord = "porbalby";

        assertTrue(Utils.checkJumbledLetters(word.toCharArray(), jumbledWord.toCharArray()));
    }

    @Test
    public void checkTypos() {

        String word = "pale";
        String typo = "ple";

        assertTrue(Utils.checkTypos(word, typo));
    }

    @Test
    public void removeDuplicate() {

        EmailNode head = createEmailThread();
        EmailNode expectedNode = createEmailThreadExpected();

        Utils.removeDuplicate(head);

        assertEquals(expectedNode, head);
    }

    @Test
    public void findIntersection() {

        EmailNode a = new EmailNode("A");
        EmailNode a2 = new EmailNode("A");
        EmailNode b = new EmailNode("B");
        EmailNode c = new EmailNode("C");
        EmailNode d = new EmailNode("D");
        EmailNode e = new EmailNode("E");
        EmailNode f = new EmailNode("F");
        EmailNode h = new EmailNode("H");
        EmailNode j = new EmailNode("J");

        c.setNext(a);
        a.setNext(e);
        e.setNext(h);
        h.setNext(j);
        j.setNext(b);
        b.setNext(a2);
        d.setNext(f);
        f.setNext(j);

        assertTrue(j == Utils.findIntersection(c, d));
    }

    private char[] createCharArray(String text) {

        char[] charArray = new char[999];
		char[] textArray = text.toCharArray();

		for (int i = 0; i < textArray.length; i++) {
			charArray[i] = textArray[i];
		}

		return charArray;
    }
    private EmailNode createEmailThread(){
        EmailNode head = new EmailNode("10");
        head.setNext(new EmailNode("12"));
        head.getNext().setNext(new EmailNode("11"));
        head.getNext().getNext().setNext(new EmailNode("11"));
        head.getNext().getNext().getNext().setNext(new EmailNode("12"));

        return head;
    }

    private EmailNode createEmailThreadExpected() {
        EmailNode head = new EmailNode("10");
        head.setNext(new EmailNode("12"));
        head.getNext().setNext(new EmailNode("11"));

        return head;
    }
}