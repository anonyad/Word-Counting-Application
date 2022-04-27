Read me

A Java API to read the contents of a plain text file and enable the display of the total number of words, the average word length, the most frequently occurring word length, and a list of the number of words of each length.

Instillation Instructions: 

1. Install Java JDK and ensure that %JAVA_HOME% is set up in environemnt variables
2. Download code as zip (contents of src and target are to be used in preferred IDE to view the code) 
3. Extract zip to folder of choice (C:\Users\user_name\Documents\Word-Counting-Application-main for example)
4. Open Command Prompt
5. Navigate to dir that contains Application.jar
6. Execute the command "java -jar Application.jar"

Notes: 

At present full directory paths should be used to input file name as txt.
E.g "C:\dev\demo\src\main\resources\Test.txt"

Assumptions made: 

All characters that are not of the standard alphabet (a-z and A-Z), numerical (0-9) or the symbols "&" and "/" will not be counted as part of a word
i.e. "18/04/2022" will be counted as a word with 10 characters, the symbol & will also be counted as a word of length 1.
