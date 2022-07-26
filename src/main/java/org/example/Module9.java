package org.example;

import java.util.*;
import java.util.function.Predicate;

/* Create a String intToRoman(int number) method of the MyUtils class to convert integer to Roman numerals.
The "number" must be positive and do not exceed 3999. Otherwise, throw an IllegalArgumentException.
For example, for a given sequence of integer numbers
5 9 19 91 3999
you should get
V IX XIX XCI MMMCMXCIX */

class M9Task1 {
    public String intToRoman(int number) {
        if (number < 1 || number > 3999)
            throw new IllegalArgumentException();
        int myNumber = number;
        StringBuilder myString = new StringBuilder();
        while (myNumber != 0) {
            if(myNumber >= 1000) {
                myString.append("M");
                myNumber -= 1000;
            } else if (myNumber >= 900) {
                myString.append("CM");
                myNumber -= 900;
            } else if (myNumber >= 500) {
                myString.append("D");
                myNumber -= 500;
            } else if (myNumber >= 400) {
                myString.append("CD");
                myNumber -= 400;
            } else if (myNumber >= 100) {
                myString.append("C");
                myNumber -= 100;
            } else if (myNumber >= 90) {
                myString.append("XC");
                myNumber -= 90;
            } else if (myNumber >= 50) {
                myString.append("L");
                myNumber -= 50;
            } else if (myNumber >= 40) {
                myString.append("XL");
                myNumber -= 40;
            } else if (myNumber >= 10) {
                myString.append("X");
                myNumber -= 10;
            } else if (myNumber >= 9) {
                myString.append("IX");
                myNumber -= 9;
            } else if (myNumber >= 5) {
                myString.append("V");
                myNumber -= 5;
            } else if (myNumber >= 4) {
                myString.append("IV");
                myNumber -= 4;
            } else if (myNumber >= 1) {
                myString.append("I");
                myNumber -= 1;
            }
        }
        return myString.toString();
    }
}

/* Given a text containing brackets  '(', ')', '{', '}', '[' and ']'.
Sequences "\\(", "\\)", "\\[", "\\]", "\\{" and "\\}" are not brackets.
Write a boolean verifyBrackets(String text) method of the MyUtils class to check a input text.
The brackets must close in the correct order, for example "()", "()[]{}", "{(())}" and "(\\()" are all valid but
"(]", ")(" and "([)]" are not. */

class M9Task2 {
    public boolean verifyBrackets(String text) {
        String myString = text.replace("\\{", "").replace("\\}", "")
                .replace("\\(", "").replace("\\)", "")
                .replace("\\[", "").replace("\\]", "");
        char[] chars = myString.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char character : chars) {
            switch (character) {
                case '{':
                case '[':
                case '(':
                    stack.push(character);
                    break;
                case '}':
                    if(stack.size() != 0) {
                        if (stack.peek() == '{')
                            stack.pop();
                    }
                    else
                        stack.push(character);
                    break;
                case ']':
                    if(stack.size() != 0) {
                        if (stack.peek() == '[')
                            stack.pop();
                    }
                    else
                        stack.push(character);
                    break;
                case ')':
                    if(stack.size() != 0) {
                        if (stack.peek() == '(')
                            stack.pop();
                    }
                    else
                        stack.push(character);
                    break;
            }
        }
        return stack.size() == 0;
    }
}

/* Pig Latin is a spoken "secret code" that many English-speaking children learn.
The rules for written Pig Latin are:
If a word begins with a consonant cluster, move it to the end and add "ay";
If a word begins with a vowel, add "hay" to the end;
Write a String pigLatinConverter(String text) method of the MyUtils class to convert input text.
For example, for a given text
Pig Latin is simply a form of jargon unrelated to Latin.
you should get
igPay atinLay ishay implysay ahay ormfay ofhay argonjay unrelatedhay otay atinLay.
*/

class M9Task3 {
    public String oneWordConverter(String text) {
        List<Character> vowels = new ArrayList<>
                (List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        Predicate<Character> isConsonant = character -> !vowels.contains(character);
        StringBuilder endString = new StringBuilder();
        StringBuilder startString = new StringBuilder();
        text.chars()
                .mapToObj(i -> (char)i)
                .takeWhile(isConsonant)
                .forEach(endString::append);
        text.chars()
                .mapToObj(i -> (char)i)
                .dropWhile(isConsonant)
                .forEach(startString::append);
        if (!isConsonant.test(text.toCharArray()[0]))
            endString.append("hay");
        else
            endString.append("ay");
        return startString.append(endString).toString();
    }

    public String pigLatinConverter(String str) {
        if (Objects.equals(str, ""))
            return "";
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(str, "[ ;:-!.,]", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (Character.isLetter(token.toCharArray()[0]))
                sb.append(oneWordConverter(token));
            else
                sb.append(token);
        }
        return sb.toString();
    }
}

/* Write a String differentWords(String originalText, String modifyText) method of the MyUtils class to compare
originalText and modifyText.
The differentWords() method return the modified text with uppercase of additional words.

For example, for a given originalText
Java is a programming language that is class-based and designed to have as few implementation dependencies as possible.
and modifyText
Java is a   general-purpose programming   language that is class-based object-oriented and designed to have as few
implementation dependencies as possible.
you should get
Java is a   GENERAL-PURPOSE programming   language that is class-based OBJECT-ORIENTED and designed to have as few
implementation dependencies as possible. */

class M9Task4 {
    public String differentWords(String originalText, String modifyText) {
        StringTokenizer stOrig =  new StringTokenizer(originalText, "[ ;:-!.,]", true);
        StringTokenizer stMod = new StringTokenizer(modifyText, "[ ;:-!.,]", true);
        List<String> tokenizedOrig = new ArrayList<>();
        List<String> tokenizedMod = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (stMod.hasMoreElements())
            tokenizedMod.add(stMod.nextToken());
        while (stOrig.hasMoreElements())
            tokenizedOrig.add(stOrig.nextToken());
        if(tokenizedOrig.size() == 0)
            return modifyText.toUpperCase();
        int index = 0;
        while (tokenizedOrig.size() > 0 && tokenizedMod.size() > 0) {
            if (Objects.equals(tokenizedMod.get(index), tokenizedOrig.get(index))) {
                sb.append(tokenizedMod.get(index));
                tokenizedMod.remove(index);
                tokenizedOrig.remove(index);
            } else if (Objects.equals(tokenizedOrig.get(index), " ")) {
                    tokenizedOrig.remove(index);
            } else {
                sb.append(tokenizedMod.get(index).toUpperCase());
                tokenizedMod.remove(index);
            }
        }
        while(tokenizedMod.size() > 0) {
            sb.append(tokenizedMod.get(0).toUpperCase());
            tokenizedMod.remove(0);
        }
        return sb.toString();
    }
}

/* Write a String reformatLines(String text) method of the MyUtils class to replacing all spaces with one and
reformat lines of input text.
Length of every lines should not exceed 60 characters.
For example, for a given text
Java    was      originally developed
   by    James   Gosling at Sun Microsystems (which
 has since been
acquired by Oracle) and released in 1995
 as a core component of Sun Microsystems' Java platform.

you should get
Java was originally developed by James Gosling at Sun
Microsystems (which has since been acquired by Oracle) and
released in 1995 as a core component of Sun Microsystems'
Java platform. */

class M9Task5 {
    public String reformatLines(String text) {
        System.out.println(text);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(text, "[ \n;:-!.,]", true);
        List<String> tokenized = new ArrayList<>();
        while (st.hasMoreElements())
            tokenized.add(st.nextToken());
        if (tokenized.size() == 0)
            return "";
        while (Objects.equals(tokenized.get(tokenized.size() - 1), " "))
            tokenized.remove(tokenized.size() - 1);
        while (Objects.equals(tokenized.get(0), " "))
            tokenized.remove(0);
        int index = 0;
        while (index < tokenized.size()) {
            if (Objects.equals(tokenized.get(index), " ") && Objects.equals(tokenized.get(index - 1), " "))
                tokenized.remove(index);
            else if (Objects.equals(tokenized.get(index), "\n"))
                tokenized.remove(index);
            else
                index++;
        }
        int stringLength = 0;
        for (String token : tokenized) {
            if (stringLength + token.length() <= 60) {
                sb.append(token);
                stringLength += token.length();
            } else {
                while (("" + sb.charAt(sb.length() - 1)).equals(" "))
                    sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
                sb.append(token);
                stringLength = token.length();
            }
        }
        return sb.toString();
    }
}