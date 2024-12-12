## Retrospective

### what went well
i did a good job variable and function nameing. for example i had lines like activePlayer.takeCard(deck.dealCard)
lines like that make sense and create highly readable code.
i had a very deep understanding of my code and one example of this is in the findPairs function.
i know that this function would run everytime a card is given to a player so logically i decided to only check for pairs at cards[-1].
another example is in removePlayer() this is not a static function so when called it removes the player that called the function from the players array.
to create the new players list i used enhanced for loop as well as an idx. however the index only increimented when (player != this) only possibel when called  nonstaticly


### what didnt go well 
i had some functions like findPair() that would return the int pair found
however when there where no pairs it returned a 0. this feels off somehow and i wonder if i should have made a check for pairs() and then find pairs()


### what i learned for next time
i didnt learn until the end of the project all the helpful methods of the java Arrays class
i learned the importance of good function names. it made debugging much easier and created way more readble code.
