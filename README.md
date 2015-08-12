# GoogleCodeJam
GoogleCodeJam practice in Java

This repository contains solutions for 3 google code Jam challenges. The details of each challenge are listed below. 

Problem A. Alien Language   
https://code.google.com/codejam/contest/90101/dashboard#s=p0

Problem

After years of study, scientists at Google Labs have discovered an alien language transmitted from a faraway planet. The alien language is very unique in that every word consists of exactly L lowercase letters. Also, there are exactly D words in this language.

Once the dictionary of all the words in the alien language was built, the next breakthrough was to discover that the aliens have been transmitting messages to Earth for the past decade. Unfortunately, these signals are weakened due to the distance between our two planets and some of the words may be misinterpreted. In order to help them decipher these messages, the scientists have asked you to devise an algorithm that will determine the number of possible interpretations for a given pattern.

A pattern consists of exactly L tokens. Each token is either a single lowercase letter (the scientists are very sure that this is the letter) or a group of unique lowercase letters surrounded by parenthesis ( and ). For example: (ab)d(dc) means the first letter is either a or b, the second letter is definitely d and the last letter is either d or c. Therefore, the pattern (ab)d(dc) can stand for either one of these 4 possibilities: add, adc, bdd, bdc.

Input

The first line of input contains 3 integers, L, D and N separated by a space. D lines follow, each containing one word of length L. These are the words that are known to exist in the alien language. N test cases then follow, each on its own line and each consisting of a pattern as described above. You may assume that all known words provided are unique.

Output

For each test case, output

Case #X: K
where X is the test case number, starting from 1, and K indicates how many words in the alien language match the pattern.

Problem C. T9 Spelling  
https://code.google.com/codejam/contest/351101/dashboard#s=p2

Problem

The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. We would like to make it easier to write a message to your friend using a sequence of keypresses to indicate the desired characters. The letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22. In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second time. The space character ' ' should be printed to indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B.


Input

The first line of input gives the number of cases, N. N test cases follow. Each case is a line of text formatted as

desired_message
Each message will consist of only lowercase characters a-z and space characters ' '. Pressing zero emits a space.

Output

For each test case, output one line containing "Case #x: " followed by the message translated into the sequence of keypresses.


Problem A. Rope Intranet 
https://code.google.com/codejam/contest/619102/dashboard#s=p0

Problem

A company is located in two very tall buildings. The company intranet connecting the buildings consists of many wires, each connecting a window on the first building to a window on the second building.

You are looking at those buildings from the side, so that one of the buildings is to the left and one is to the right. The windows on the left building are seen as points on its right wall, and the windows on the right building are seen as points on its left wall. Wires are straight segments connecting a window on the left building to a window on the right building.



You've noticed that no two wires share an endpoint (in other words, there's at most one wire going out of each window). However, from your viewpoint, some of the wires intersect midway. You've also noticed that exactly two wires meet at each intersection point.

On the above picture, the intersection points are the black circles, while the windows are the white circles.

How many intersection points do you see?

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each case begins with a line containing an integer N, denoting the number of wires you see.

The next N lines each describe one wire with two integers Ai and Bi. These describe the windows that this wire connects: Ai is the height of the window on the left building, and Bi is the height of the window on the right building.

Output

For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is the number of intersection points you see.
