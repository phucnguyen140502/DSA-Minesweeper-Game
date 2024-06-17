<div align="center">
  <img src="https://github.com/phucnguyen140502/DSA-Minesweeper-Game/assets/125187213/a30ae529-73c6-41c1-b632-bae53dfff339" alt="Example Image" style="width:50%;">
</div>

<p align="center">
  <a href="https://github.com/phucnguyen140502/DSA-Minesweeper-Game/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/phucnguyen140502/DSA-Minesweeper-Game?style=for-the-badge" alt="Contributors">
  </a>
  <a href="https://github.com/phucnguyen140502/DSA-Minesweeper-Game/forks">
    <img src="https://img.shields.io/github/forks/phucnguyen140502/DSA-Minesweeper-Game?style=for-the-badge" alt="Forks">
  </a>
  <a href="https://github.com/phucnguyen140502/DSA-Minesweeper-Game/issues">
    <img src="https://img.shields.io/github/issues/phucnguyen140502/DSA-Minesweeper-Game?style=for-the-badge" alt="Issues">
  </a>
</p>

<p align="center">
  <a href="https://github.com/search?q=Object+Oriented+Programming+language%3AJava&type=repositories&l=Java&p=1">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  </a>
  <a href="https://www.jetbrains.com/idea/">
    <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" alt="IntelliJ_IDEA">
  </a>
  <a href="https://github.com/">
    <img src="https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white" alt="GIT">
  </a>
</p>

<p align="center">
  <a href="https://github.com/search?q=game%20logic&type=repositories">
    <img src="https://img.shields.io/badge/Data Stucture & Algorithm Game Logic-blue.svg" alt="Game Logic Data Stucture & Algorithm">
  </a>
  <a href="https://openjdk.org/projects/jdk/21/">
    <img src="https://img.shields.io/badge/JDK21-8A2BE2" alt="JDK21">
  </a>
</p>

<!-- PROJECT LOGO -->
<div align="center">
<h1 align="center">MineSweeper</h1>
  <h3 align="center">
    A Java game developed for the DSA Course at International University - VNU
    <br />
    <br />
    <a href="https://github.com/phucnguyen140502/DSA-Minesweeper-Game/issues">Report Bug</a>
    ·
    <a href="https://github.com/phucnguyen140502/DSA-Minesweeper-Game/issues">Request Feature</a>
  </h3>
</div>

## Introduction

Minesweeper is a classic puzzle game that challenges players to uncover a grid of hidden mines without detonating any of them. The objective is to reveal all the cells that do not contain mines while avoiding the mines themselves. Each cell that does not contain a mine displays a number indicating how many mines are adjacent to that cell.

This implementation of Minesweeper leverages modern software design principles and patterns to enhance maintainability and scalability. 

## Design Patterns Applied

  ### Observer Pattern
  
  In the Minesweeper game, the Observer pattern is used to manage the communication between the game model and the user interface. The game model acts as the subject, and the various UI components (such as the grid display, status bar, and control buttons) act as observers. This pattern allows the game state to be updated dynamically, and all observers to reflect changes in real-time, ensuring a responsive and interactive user experience.
  
  ### Strategy Pattern
  
  The Strategy pattern is employed to define a family of algorithms for the game’s logic, such as the mine placement strategy and cell reveal strategy. This pattern allows the selection of different algorithms at runtime, making the game logic modular and easily extendable. By encapsulating the algorithm's logic into separate strategy classes, the game becomes more flexible and easier to maintain.

  ### Use of Generics
  
  Generics are used extensively to create a flexible and type-safe codebase. This approach ensures that the code is not only robust but also adaptable to different types of game configurations and strategies.

## Algorithms Used

### Breadth-First Search (BFS)

Breadth-First Search (BFS) is used in the algorithm to explore the cells of the Minesweeper grid. BFS is ideal for finding all reachable cells starting from a given cell, which is essential for efficiently revealing cells that are not adjacent to mines.

### Recursion

Recursion is utilized to simplify the implementation of the game’s logic, particularly in the recursive reveal of cells. This technique helps to elegantly handle the complex logic of revealing connected cells without mines.

### Hashtable for Image and Audio Storage

A Hashtable is employed to store and manage images and audio files associated with the game. This data structure provides efficient key-value mapping, allowing quick access to media assets required for the game’s interface and sound effects.

- **Images**: Each image (such as cell states, flags, and mine icons) is stored in the Hashtable with a unique key, enabling quick retrieval and display.
- **Audio**: Audio clips for game events (like clicking a cell, detonating a mine, or winning the game) are also stored in the Hashtable, ensuring fast access and playback.

## Features

- **Interactive UI**: Real-time updates using the Observer pattern.
- **Flexible Game Logic**: Easily switch between different strategies and configurations.
- **Efficient Cell Exploration**: Implemented BFS and recursive algorithms for optimal performance.
- **Media Management**: Uses a Hashtable to store and quickly access images and audio files.


## Getting Started

To get started with the Minesweeper game, clone the repository and follow the setup instructions. You can then run the game and start enjoying the challenge!

### Installation & How To Run
> $\color{red}{\textrm{🆘 MUST INSTALL JDK21 TO RUN THE GAME 🆘}}$

1. Open the terminal on your IDE
2. Clone the repository
```
git clone https://github.com/phucnguyen140502/DSA-Minesweeper-Game.git
```
3. Open in a Java IDE
4. Choose game.java in package main and click RUN to play the game
