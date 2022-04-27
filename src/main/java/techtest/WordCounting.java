package techtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * API to return the counting of words in a text file
 * @author Adam Bromby
 * @version 1.0
 */

public class WordCounting {
    //initialise variables including an array list to hold the text of the file input
    private ArrayList<String> arrayList = new ArrayList<>();

    /**
     *  Method that takes the input filename and formats the text
     * @param Filepath the input file from the user
     * @return A formatted string to be output as per the specification
     * @throws Exception
     */
    public String wordCounting(String Filepath) throws Exception {

        try (BufferedReader reader = new BufferedReader(new FileReader(Filepath))) {
            while (reader.ready()) {
                arrayList.add(reader.readLine());
            }
        }
        catch (IOException e) {
            // Handle a potential exception
        }
        //take the array of the input file and convert to string
        String str = Arrays.toString(arrayList.toArray());
        //convert the string into a list of string reaplcing the unwanted symbolic characters and spliting by whitepace
        List<String> wordList = Arrays.asList(str.replaceAll("[^a-zA-Z&/0-9^ ]", "")
                                .toLowerCase().split("\\s+"));

        //concatenate a string for all of the outputs required from the methods
        String strOut = wordCount(wordList) + "\n"
                    + averageCount(wordList) + "\n"
                    + lengthOfWords(wordList)
                    + mostFrequent(wordList);

        return strOut;
    }

    /**
     * Method to return the total number of words in the file
     * @param wordList the formatted list of words from the input file
     * @return A string representing the total number of words in the input file
     */
    public String wordCount(List<String> wordList) {
        //get the number of words in the file
        int numberOfWords = wordList.size();
        String str = "Number of words = " + numberOfWords;

        return str;
    }

    /**
     * Average count method to get the average number of words
     * @param wordList the formatted list of words from the input file
     * @return A string representing the average word length of the input file
     */

    public String averageCount(List<String> wordList) {

        //List of interages used to sotre the length of all the strings
        List<Integer> counts = wordList.stream().map(String::length).collect(Collectors.toList());

        //iterate through the list of integers to calculate the average
        Double average = counts.stream().mapToInt(val -> val).average().orElse(0.0);
        String str = String.format("Average word length = %.3f", average);
        return str;
    }

    /**
     * Method for the lengths of words in the input file
     * @param wordList the formatted list of words from the input file
     * @return A string representing the number of words of different lengths in the input file
     */
    public String lengthOfWords(List<String> wordList) {
        String str = "";
        //
        int longestLength = 1;
            for (String strNext : wordList) { // Go through each word in the list, the next one is called strnext
                // If the strNext is a word longer than longestLength.
                if (longestLength < strNext.length())
                {
                    // Set new value for longest length.
                    longestLength = strNext.length();
                }
            }
            // initalise counts array
            int[] counts = new int[longestLength + 1];
            for (String string : wordList) {
                // Add one to the number of words that length has
                counts[string.length()] += 1;

            }
            for (int i = 1; i < counts.length; i++)
            {
                //if statemtent to ensure if there are 0 words of that length it is not printed
                if (counts[i] > 0)
                {
                    //System.out.println("Number of words of length " + i + " is " + counts[i]);
                    str = str + "Number of words of length " + i + " is " + counts[i] + "\n";
                }
            }
            return str;
    }

    /**
     * Method for the most frequent word length in the input file
     * @param wordList the formatted list of words from the input file
     * @return A string representing the most frequent word lengths in the file
     */
    public String mostFrequent(List<String> wordList) {

        //List to store the most frequent
        List<String> mostFrequent = new ArrayList<>();
        //initialise the count to be the most frequent
        double count = 0;
        //Has map is used to get the most frequently occuring word length
        HashMap<Integer, Integer> wordLength = new HashMap<>();

        for (String word: wordList) {
            int key = word.length();

            Integer value = wordLength.get(key);
            if (value == null)
            {
                wordLength.put(key, 1);
            }
            else {
                if (value > count)
                {
                    count = value;
                    mostFrequent.clear();
                    mostFrequent.add(String.valueOf(key));
                }
                else if (value == count)
                {
                    mostFrequent.add(String.valueOf(key));
                }
                wordLength.put(key, value + 1);
            }
        }

        if (mostFrequent.isEmpty())
        {
            mostFrequent.add(wordList.get(0).length() + "");
        }

        // integer to store the most frequent word length
        int freqWord = wordLength.get(Integer.valueOf(mostFrequent.get(0)));
        String wordFreq = String.join(" & ", mostFrequent);

        String str = String.format("The most frequently occuring word length is %d, for word lengths of %s", freqWord, wordFreq);

        return str;
    }
}

