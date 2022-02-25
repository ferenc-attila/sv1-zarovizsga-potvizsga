package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        char[] characters = s.toCharArray();
        int digitCounter = countDigits(characters);
        return (digitCounter > s.length() - digitCounter);
    }

    private int countDigits(char[] characters) {
        int digitCounter = 0;
        for (char actual : characters) {
            if (Character.isDigit(actual)) {
                digitCounter++;
            }
        }
        return digitCounter;
    }
}
