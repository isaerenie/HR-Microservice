package net.eren.departmentservice.utils;

public class Main {
    public static String decode(String input) {
        int step = 25; // adım sayısı
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                // karakter bir harfse, adım sayısı kadar geriye kaydır
                char decoded = (char) (ch - step);
                if (decoded < 'a') {
                    decoded += 26;
                }
                result.append(decoded);
            } else {
                // karakter bir harf değilse, aynı şekilde bırak
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        
    }
}
