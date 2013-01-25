Elevator
========

Somewhere inside of every elevator is a box which controls which direction it goes in and which floors it
stops at. What we’re asking you to do is to implement a software version of that box.

A quick review of how elevators work
------------------------------------
1. Elevators don’t change directions rapidly; instead they service all the requests they can while
moving in one direction before stopping and changing direction.

2. Elevators have to process two types of requests. Requests made from inside the elevator
indicate a desire to be dropped off at a specific floor regardless of the direction the elevator is
travelling in. Requests made from outside the elevator indicate a desire to be picked up at that
floor, but only if the elevator is travelling in the requested direction.

