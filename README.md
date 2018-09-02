# cesar-application
Code developed to an Android Dev job interview.

Question #1, #2, #3, #5 and #7 were solved with methods find in the class Utils.java. These are the methods:

- replaceSpaces: Method used to remove whitespaces from strings and replace them by the code "&32";
- checkJumbledLetters: Method that, given a string representing the correct word, verifies if another word is a partial-permutation;
- checkTypos: Works in a similar way as the checkJumbledLetters method, but verifies if the word is a typo from the correct form;
- removeDuplicates: This method gets a node representing the head of an e-mail thread and remove duplicates nodes;
- findIntersection: Given two singly linked lists return the intersection node from both;

Question #4 it's about creating and Android Application that can execute a search and show a list as a result of the search. For those actions were used one single Activity (MainActivity.java), one Adapter (MyAdapter), to update the list of results, and one ViewHolder (ItemHolder) to determine how the results must be showned.
The values available to be searched are: "Black", "Black-Blue", "Blue", "Blue-White", "White", "White-Red", "Red", "Red-Green", "Green", "Green-Black".
