# longest-compounded-word-DP Approach
Overview->

This program reads word list file (Input_01.txt) and finds compound words .In order to pass any other file for input the name of file inside the code shall be changed or inputs be pasted in initial file(Input_01.txt).

How It Works->

I load all the words into an ArrayList and a HashSet — the list is for looping through in order, the set is for fast lookups. Then I sort the list by word length (longest first) so the first compound word I find is automatically the longest, no extra work needed.
For each word I check, I temporarily remove it from the set so it can't use itself to form itself,which is wrong. Then I run a simple DP check: I keep a boolean array where dp[i] means the first i characters of the word can be formed using other words in the set. If dp[n] comes out true, it's a compound word. After the check I add the word back into the set so future checks aren't affected.

How To Run->

Load the program in any IDE with name solve.java.

Make sure the inputs are provided through a file with name "Input_01.txt" or change the name in the code itself.

Output format is the same provided in the pdf .
