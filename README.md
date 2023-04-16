# UnoSwiggy

==================================>Problem Statement<================================
Design a multiplayer card game that supports multiple players (up to 4) and different types of cards (e.g. number cards, action cards, etc.). The game should follow the following rules:

Each player starts with a hand of 5 cards.

The game starts with a deck of 52 cards ( a standard deck of playing cards).

Players take turns playing cards from their hand, following a set of rules that define what cards can be played when.

A player can only play a card if it matches either the suit or the rank of the top card on the discard pile.

If a player cannot play a card, they must draw a card from the draw pile. If the draw pile is empty, the game ends in a draw and no player is declared a winner..

The game ends when one player runs out of cardswho is declared the winner.

BONUS: Aces, Kings, Queens and Jack are action cards. When one of these is played the following actions occur:

Ace(A): Skip the next player in turn

Kings(K): Reverse the sequence of who plays next

Queens(Q): +2

Jacks(J): +4

===========================>Steps to run the project<=================================

1.Clone this repository in your local system:https://github.com/hemanshi03/UnoSwiggy
ex:$ git clone https://github.com/yourusername/your-java-project.git

2.Navigate to the project directory using the command line or terminal.
ex:$ cd your-java-project

3.Compile the Java source code using the "javac" command, specifying the name of the main Java file in this case:CustomUno.java
ex:$ javac CustomUno.java

4.Run the compiled Java code using the java command, specifying the name of the main class that contains the main method
ex:$ java CustomUno

===========================>AutoMated<=================================
Copy Below lines after editing path where you clone repository

cd path
javac CustomUno.java
java CustomUno

Save above as auto.sh
chmod +x auto.sh
./auto.sh
