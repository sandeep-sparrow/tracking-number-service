package com.engineeringwithsandeep.learning.youtube.functional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FunctionAsArg {

    public static void main(String[] args) {
        String str = "hello";
        String upper = str.chars()
                .mapToObj(ch -> (char) ch)
                .map(Character::toUpperCase)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.printf("result: %s\n", upper);

        String numPattern  = "[0-9]+";
        String address = "A-1805, Neelyog Virat, Dhanjiwadi, Malad East, 400097";

        Pattern pattern = Pattern.compile(numPattern);
        Matcher matcher = pattern.matcher(address);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static int toLower(int ch) {
        return (ch + 32);
    }
}
