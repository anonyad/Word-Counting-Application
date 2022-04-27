package techtest;

import java.util.Scanner;

/**
 * Main Class for the Application
 * @author Adam Bromby
 * @version 1.0
 */
public final class App {

    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Please enter the filename path including the '.txt'");
            //Take the users input and remove any white space after
            String input = in.nextLine().replaceAll("\\s+","");
            if(!input.endsWith(".txt")) {
                input = (input + ".txt");
            }

            WordCounting wordcount = new WordCounting();
            String a = wordcount.wordCounting(input);

            System.out.println(a);

        }
    }
}
