# MVI-Clean-Architecture
This is a sample app & basic code that demonstrate how to build an Android application using the Uncle Bob's Clean Architecture approach.

The trick of the project is to demonstrate best practices, provide a set of guidelines, and present modern Android Application Architecture that is modular, scalable, maintainable and testable, suitable for bigger teams and long application lifecycle management.

<img src="https://miro.medium.com/max/4800/1*D1EvAeK74Gry46JMZM4oOQ.png" width="500">

### Flow 
This app uses [_**MVI (Model View Intent)**_](https://proandroiddev.com/mvi-architecture-with-kotlin-flows-and-channels-d36820b2028d) architecture.
 
<img src="https://miro.medium.com/max/1400/1*3u5JnmqONR4UnwRE6tEV3Q.png" width="500">

### What this app do ? 
- If first app first launch / refresh clicked:
start -> get data from api -> save to local database (room) -> show data from local (end) -> end
- If app is not first launch:
start -> show data from local (room) -> end
