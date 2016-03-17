# blackjack

First prototype. Can edit code to have as many humans and as many computers playing as desired.

TODO allow user to set up human and computer players.

Gameplay TODO - players need to be aware of other player's hands so they can play more efficiently, and adjust strategy based on what other players have. Currently, players will take more cards even if other player is bust. And computer always stops at 17, even if oponent has 18 or more and it would be worth taking another card just in case.  How should this be implemented?

OOP issues: Player objects have a Hand object, and the Hand object is given a reference to the deck of cards. Is this OK? Should another object be in charge of giving cards to players? 
