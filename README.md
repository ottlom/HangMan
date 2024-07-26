# HangMan game
Idea of creation the application was taken from
Sergey Zhukov's road map https://zhukovsd.github.io/java-backend-learning-course/

Implement my version of HangMan with a little features like storage players and OOP style

implementation features of this version of the game:

1. Storage players in memory while game on
2. All words are Russian nouns
3. display current state of hangman

Game cycle:

1. Application asks the player if he wants to play
2. Application asks the player to introduce himself by his nickname and save or get player from Storage
   if Application already know this Player then result of game will be written in his old statistic
3. Application randomly get of a word from a list of Russian noun words
4. Player try guess Russian letter if he guessed right application open all such letters in the word
   else if he doesn't guess application says to player about his number of mistakes and display current state of
   HangMan
5. If player guessed all letters and didn't exceed the limit of mistakes he wins, else he loses
6. Application write result this game in statistic of the player and offer player play again or stop game
