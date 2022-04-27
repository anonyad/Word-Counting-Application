package techtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Assertions;

/**
 * Unit test for App.
 */
class AppTest {

    WordCounting wordcount = new WordCounting();

    String exampleText = "src\\main\\resources\\helloWorld.txt";
    String exampleText2 = "src\\main\\resources\\bible_daily.txt";

    //Test is = ***asdasD sfjhwer!?:: salhs, sdlkjh ***
    String exampleTest3 = "src\\main\\resources\\Test.txt";
    /**
     * Rigorous Test.
     * @throws Exception
     */
    @Test
    @DisplayName("Uses the txt file from the example given")
    void testExampleText() throws Exception {

        String result = wordcount.wordCounting(exampleText);

        Assertions.assertEquals("Number of words = 9\n" +
                "Average word length = 4.556\n"+
                "Number of words of length 1 is 1\n" +
                "Number of words of length 2 is 1\n" +
                "Number of words of length 3 is 1\n" +
                "Number of words of length 4 is 2\n" +
                "Number of words of length 5 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "Number of words of length 10 is 1\n" +
                "The most frequently occuring word length is 2, for word lengths of 5 & 4",
                result);
    }

    @Test
    @DisplayName("Using the bible txt")
    void testExampleBibleText() throws Exception {

        String result = wordcount.wordCounting(exampleText2);

        Assertions.assertEquals("Number of words = 793094\n" +
                "Average word length = 4.082\n" +
                "Number of words of length 1 is 18647\n" +
                "Number of words of length 2 is 131867\n" +
                "Number of words of length 3 is 221382\n" +
                "Number of words of length 4 is 175572\n" +
                "Number of words of length 5 is 95929\n" +
                "Number of words of length 6 is 52577\n" +
                "Number of words of length 7 is 40968\n" +
                "Number of words of length 8 is 25026\n" +
                "Number of words of length 9 is 16695\n" +
                "Number of words of length 10 is 7539\n" +
                "Number of words of length 11 is 3845\n" +
                "Number of words of length 12 is 1707\n" +
                "Number of words of length 13 is 876\n" +
                "Number of words of length 14 is 353\n" +
                "Number of words of length 15 is 89\n" +
                "Number of words of length 16 is 16\n" +
                "Number of words of length 17 is 4\n" +
                "Number of words of length 18 is 2\n" +
                "The most frequently occuring word length is 221382, for word lengths of 3",
                result);
    }

    @Test
    @DisplayName("Using a test text with a lot of random symbols")
    void testText() throws Exception {

        String result = wordcount.wordCounting(exampleTest3);

        Assertions.assertEquals("Number of words = 4\n" +
                "Average word length = 6.000\n" +
                "Number of words of length 5 is 1\n" +
                "Number of words of length 6 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "The most frequently occuring word length is 2, for word lengths of 6",
                result);
    }


}
