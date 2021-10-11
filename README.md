# Sabre
[![license](https://img.shields.io/github/license/Project-Cepi/Sabre?style=for-the-badge&color=b2204c)](../LICENSE)
[![discord-banner](https://img.shields.io/discord/706185253441634317?label=discord&style=for-the-badge&color=7289da)](https://discord.cepi.world/8K8WMGV)

Sabre is a server JAR wrapper using the Minestom API as a community-maintained groundwork library.

## Features

* Fully featured configuration
* Stop, update, and operator commands.
* Colored terminal
* Built-in flat generator for testing
* [Import map](https://github.com/Project-Cepi/import-map) for easy setup

## Installation

Download the JAR from [Sabre releases](https://github.com/Project-Cepi/Sabre/releases)
or compile it yourself. Instructions to do so are in Compile header.

Create a run script or run it from the terminal using 

`java -Xms2000m -Xmx2000m -jar Sabre.jar`

With `-Xms` being the minimum amount of RAM you want to use,

and `-Xmx` being the max amount of RAM you want to use.

## Compile

Create a folder, then
Clone the repository using:

`git clone https://github.com/Project-Cepi/Sabre.git`

Once it is cloned, make sure you have gradle installed, and run

`./gradlew shadowJar` on Mac or Linux, and

`gradlew shadowJar` on Windows.

This will output the jar to `build/libs` in the project directory.
