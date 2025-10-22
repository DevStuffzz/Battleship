# Battleship Game in Java

**Author:** Corey Beaver  

A simple console-based **Battleship** game implemented in **Java**. The game allows a single player to play against a basic AI on an 8×8 board.

---

## Table of Contents
- [Project Structure](#project-structure)  
- [Requirements](#requirements)  
- [How to Compile](#how-to-compile)  
- [How to Run](#how-to-run)  
- [Gameplay](#gameplay)  
- [Features](#features)  
- [Future Improvements](#future-improvements)  

---

## Project Structure
Battleship/
├── src/
│ ├── Tile.java
│ ├── Board.java
│ ├── Game.java
│ └── Util.java
├── README.md


- `Tile.java` – Represents a single cell on the board.  
- `Board.java` – Manages the 8×8 grid of tiles.  
- `Game.java` – Contains the main game loop, player input, and AI logic.  
- `Util.java` – Utility functions, including console clearing.  

---

## Requirements
- Java JDK 8 or higher  
- Terminal/console for input/output  
- No external libraries required  

---

## How to Compile
Open a terminal and navigate to the project root directory. Then run:

```bash
javac src/*.java
```

## Run

```bash
java -cp src Game
```

---

Gameplay
- Enter attack coordinates like A1, B5
- Enemy attacks randomly
- Game ends when all ships of one side are destroyed

---

Features
- 8x8 board with Tile class
- Player vs AI
- Win detection
- Clear console between turns

License
Open for personal and educational use. No commercial usage without permission.

---
