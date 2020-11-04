# Sabre
Sabre is a reimplementation of the Gameplay plugin using the Minestom API

## Installation

Download the jar from [Sabre releases](https://github.com/Project-Cepi/Sabre/releases)
OR compile it yourself. Instructions to do so are in Compile header

Create a run script OR run it from the terminal using 

`java -Xms2000m -Xmx2000m -jar Sabre.jar`

With `-Xms` being the minimum amount of ram you want to use,

`-Xmx` being the max amount of ram you want to use.

## Compile

Create a folder, then
Clone the repository using:

`git clone https://github.com/Project-Cepi/Sabre.git`

Once it is cloned, make sure you have gradle installed, and run

`./gradlew build` on Mac or Linux, and

`gradlew build` on Windows.

This will output the jar to `build/libs` in the project directory.