
Reference  - http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

**Dynamic Programming | Set 4 (Longest Common Subsequence)**


LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

**Examples:**
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “ABCDAF” and “ACBCF” is “ABCF” of length 4.


**Table for LCS for input Sequences “ABCDAF” and “ACBCF” is “ABCF” of length 4.**

| | | A | B| C| D| A| F|
|---|---|---|---|---|---|---|---|
|   |0|0|0|0|0|0|0|
|A| 0 |1|1|1|1|1|1|
|C| 0 |1|1|2|2|2|2|
|B| 0 |1|2|2|2|2|2|
|C| 0 |1|2|3|3|3|3|
|F| 0 |1|2|3|3|3|4|
