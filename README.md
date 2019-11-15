# TraitorAtMansionOnTheBluff
JavaFx edition of Parody for Betrayal at House on the hill.
All rights reserved to publisher; Avalon hill and distribution rights reserved to Wizards of the coast

11/08/2019
Current roles
-----------------------------
Adam; Server and chatbox

Mitch; items/ event cards

James; tiles

Sarah; characters

Nathan; game interface put together and github management, Spook class.

Schedule
------------------------------
Week ending 11/16; Have all names of classes declared and established so those working on parts that require another class know what Object type they are referencing.

Week ending 11/23; Have basic graphics implemented with characters that move


Short term End Goal (Final project Goal, these will be erased and stored in a history directory on completion of full game); 
----------------------------------

  *Have turns that take place between at least 2 people
  
  *on a turn a character can move as many spaces as they have speed.
  
  *after spook is in place a character has access to the attack button.
  
  *when a character moves through a door a room is discovered. A card is drawn and then the room effect takes place.
  
  *At the end of a turn a spook counter is checked and incremented if omen card was drawn.
  
  *if Horror counter is achieved. a Desciption will show up on each players screen respectivly describing the end game condition. turn is reset to be the person after the traitor.
  
  *display who wins when endgame is set.
  
  *there will be at least 2 horrors avalible on due date of final project.
  
  *there will be a chatbox in a designated part of the screen (this may also display game announcements so all players can see what is going on during each player's turn).



Example Runthrough of a Game
-----------------------------------

- Game starts up and connects to hosts etc. Chatbox is made avalible

- Player is shown a window that lets them click on a character. Once clicked window goes away.

- A game narrative box is opened describing the basic turns and end game which then can be closed and maybe opened via button.

- Action bar is closed to all players except the person whose turn it is (turn cycle decided by age of characters choosen oldest first)

- on a turn a character can do all the actions and if done and no tile is discovered a end turn button is pressed otherwise turn ended normally.

- goes to next turn. repeats

- Horror(haunt) is calculated 

- When horror starts a window pops up on everyones screens telling them what happens now until the end of the game.

- When end game condiditon is met game winner is displayed in a new window with description.
