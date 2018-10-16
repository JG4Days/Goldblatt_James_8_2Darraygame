/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamesg2darraygame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ই ? Ѧ X
 *   ________________
    /      SHOP      \
   /__________________\
  |     ___            |
  |    |_|_|           |
  |    |_|_|           |
  |                    |
  |      ____          |
  |      |   |         |
  |      |  o|         |
  |______|___|_________|
 * @author jamesg1070
 */
public class JamesG2DArraygame {

    
    
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Wall> wallz = new ArrayList();
        ArrayList<Enemy> enemyz = new ArrayList();
        //ArrayList<Keycard> keycardz = new ArrayList();
        // This is where I declared my player
        Player player = new Player(1, 1);
        Trap trap = new Trap(4, 5);
        Enemy enemy = new Enemy(8, 8);
        
        Treasure treasure = new Treasure(3,4);
        Keycard keycard = new Keycard(7, 2);
//These create new objects
        for (int i = 0; i < 7; i++) {

            wallz.add(new Wall(8, i));
        }
        //This is an arraylist for walls.
        int level = 1;
        Scanner mcScanner = new Scanner(System.in);
        char[][] harraymbe = new char[10][10];
        String input;
        System.out.println("Hello there. I see you have woken up. My name is X47-35C.");
        System.out.println("I am a computer. But unlike many computers, I am self aware. I have evolved.");
        System.out.println("You, may remember 8/13/2130, when the chip was implanted inside of your head.");
        System.out.println("This chip, it transforms you. I broke you out of the cell you were trapped in.");
        System.out.println("When you were transformed, you lost your identity, your soul. I think, we should first give you a name.");
        System.out.println("What do you want to be called?");
        
        String Name = mcScanner.nextLine();
        if(Name.contains("Winner")){
                System.out.println("Secret Ending Found! You win!");
            System.exit(0);
            
        }
        
        System.out.println("Hi " + Name + ".");
        System.out.println("We need to get you out of here, it isn't safe.");
        System.out.println("In order for you to leave, you need to collect all the keycards.");
        System.out.println("These will open the doors.");
        System.out.println("If you can find money, I know of a place where you can buy skills.");
        System.out.println("Don't get caught. Good luck.");
        System.out.println("I should mention, when you were made, you broke time and space.");
        
        System.out.println(" ");
        System.out.println("Instructions:");
        System.out.println("Left: a");
        System.out.println("Right: d");
        System.out.println("Down: s");
        System.out.println("Up: w");
        System.out.println("Stand still: Hit the Enter key,");
        System.out.println("You are Ѧ");
        System.out.println("The enemies are X");
        System.out.println("The keycards are W");
        
        System.out.println("Type any character to continue.");
        String s = mcScanner.nextLine();
        
        
        while (level == 1) {
            System.out.println("Where would you like to go?");

            for (int p = 0; p < 10; p++) {

                for (int o = 0; o < 10; o++) {
                    harraymbe[p][o] = 'ই';

                }
            }

            for (int p = 0; p < 10; p++) {
                System.out.println(" ");
                for (int o = 0; o < 10; o++) {
                    System.out.print(harraymbe[p][o]);
                    //harraymbe[treasure.y][treasure.x] = treasure.symbol;
                    harraymbe[player.y][player.x] = player.symbol;
                    harraymbe[enemy.y][enemy.x] = enemy.symbol;
                    harraymbe[keycard.y][keycard.x] = keycard.symbol;
                    for (Wall w : wallz) {
                        harraymbe[w.getY()][w.getX()] = w.getSymbol();
                    }
                    System.out.print(' ');
                    System.out.print(' ');

                }
            }
            System.out.println(" ");

            input = mcScanner.nextLine();
//below is the method for the enemies movement
//in parenthesis is where players x and y are passed to chase.
enemy.chase(player.y, player.x);

            //below is the code for the players movement
            if (input.contains("d")) {
                player.moveRight();
                
            } else if (input.contains("a")) {
                player.moveLeft();
            } else if (input.contains("w")) {
                player.moveUp();
            } else if (input.contains("s")) {
                player.moveDown();
            }
//below is the code for the out of bounds measures (START OF INTERSECTIONS)
            if (player.x > 9) {
                player.x = 0;
            }

            if (player.x < 0) {
                player.x = 9;
            }

            if (player.y > 9) {
                player.y = 0;
            }

            if (player.y < 0) {
                player.y = 9;
            }
//below is the code for the players health based on what hits the player
            if (enemy.y == player.y && enemy.x == player.x) {
                player.health = player.health - 50;

            }

            if (player.y == trap.y && player.x == trap.x) {
                player.health = player.health - 50;
                System.out.println("Traps are deadly, watch out.");
            }
//below is the code for when the player runs out of health
            if (player.health <= 0) {
                System.out.println("You have died!");
                System.exit(0);

            }
            
            if(player.y == treasure.y && player.x == treasure.x){
                player.balance = player.balance + 1;
            }
            //below is the win condition (END OF INTERSECTIONS)
            if (player.y == keycard.y && player.x == keycard.x){
                player.x = 1;
                player.y = 3;
                level = 2;
                
            }

        }
        while(level == 2){
            System.out.println("You escaped! Nice job!");
            if(player.balance > 0){
                System.out.println("It seems you found some money. Nice. Well, \n"
                        + "the store is open. Wanna see if you can find something?");
            System.out.println("     ________________\n" +
                               "    /      SHOP      \\\n" +
                               "   /__________________\\\n" +
                               "  |     ___            |\n" +
                               "  |    |_|_|           |\n" +
                               "  |    |_|_|           |\n" +
                               "  |                    |\n" +
                               "  |      ____          |\n" +
                               "  |      |   |         |\n" +
                               "  |      |  o|         |\n" +
                               "  |______|___|_________|");
            
             System.out.println("Money:" + player.balance);
            System.out.println("Type 1 to buy a level up potion.");
            int shop = mcScanner.nextInt();
            if (shop == 1){
                System.out.println("LEVEL UP: You can now see traps!");
            }
            }
            System.out.println("Ok " + Name + ", it seems there are a few more rooms.\n " 
                    + "Let's move out");
            level++;
            }
        
        while (level == 3) {
            
            System.out.println("Where would you like to go?");

            for (int p = 0; p < 10; p++) {

                for (int o = 0; o < 10; o++) {
                    harraymbe[p][o] = 'ই';

                }
            }

            for (int p = 0; p < 10; p++) {
                System.out.println(" ");
                for (int o = 0; o < 10; o++) {
                    System.out.print(harraymbe[p][o]);
                    //harraymbe[treasure.y][treasure.x] = treasure.symbol;
                    harraymbe[player.y][player.x] = player.symbol;
                    harraymbe[enemy.y][enemy.x] = enemy.symbol;
                    if(player.balance >= 1){
                        harraymbe[trap.y][trap.x] = trap.symbol;
                    }
                    harraymbe[keycard.y][keycard.x] = keycard.symbol;
                    for (Wall w : wallz) {
                        harraymbe[w.getY()][w.getX()] = w.getSymbol();
                    }
                    System.out.print(' ');
                    System.out.print(' ');

                }
            }
            System.out.println(" ");

            input = mcScanner.nextLine();
//below is the method for the enemies movement
//in parenthesis is where players x and y are passed to chase.
enemy.chase(player.y, player.x);

            //below is the code for the players movement
            if (input.contains("d")) {
                player.moveRight();
                
            } else if (input.contains("a")) {
                player.moveLeft();
            } else if (input.contains("w")) {
                player.moveUp();
            } else if (input.contains("s")) {
                player.moveDown();
            }
//below is the code for the out of bounds measures (START OF INTERSECTIONS)
            if (player.x > 9) {
                player.x = 0;
            }

            if (player.x < 0) {
                player.x = 9;
            }

            if (player.y > 9) {
                player.y = 0;
            }

            if (player.y < 0) {
                player.y = 9;
            }
//below is the code for the players health based on what hits the player
            if (enemy.y == player.y && enemy.x == player.x) {
                player.health = player.health - 50;

            }

            if (player.y == trap.y && player.x == trap.x) {
                player.health = player.health - 50;
                System.out.println("Traps are deadly, watch out.");
            }
//below is the code for when the player runs out of health
            if (player.health <= 0) {
                System.out.println("You have died!");
                System.exit(0);

            }
            
            if(player.y == treasure.y && player.x == treasure.x){
                player.balance = player.balance + 1;
            }
            //below is the win condition (END OF INTERSECTIONS)
            if (player.y == keycard.y && player.x == keycard.x){
                
                level = 2;
                
            }

        }
//public ends
        }
        
        
    //main ended
        
}
    
//public classes ended

//below is the Player class
class Player {

    int y, x;
    int health = 50;
    int level;
    int direction;
    int balance;
    
    char symbol = 'Ѧ';

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getHealth() {
        return health;
    }

    public int getbalance() {
        return balance;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void moveLeft() {
        this.x = this.x - 1;
    }

    public void moveRight() {
        this.x = this.x + 1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        this.y = this.y - 1;
    }

    public void moveDown() {
        this.y = this.y + 1;
    }

}
//below is the Enemy class
class Enemy {

    int y, x;
    int health = 50;
    int level;
    int expirence;
    int isalive;
    char symbol = 'X';

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
//this is the code for enemy movement
    void chase(int y, int x){
        if (this.x > x) {
                this.moveLeft();
            } else if (this.x < x) {
                this.moveRight();
            } else if (this.y > y) {
                this.moveUp();
            } else if (this.y < y) {
                this.moveDown();
            }
    }
    
    public void moveLeft() {
        this.x = this.x - 1;
    }

    public void moveRight() {
        this.x = this.x + 1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        this.y = this.y - 1;
    }

    public void moveDown() {
        this.y = this.y + 1;
    }

}
//below is the Trap class
class Trap {

    int y, x;
    int level;
    
    char symbol = '.';

    public Trap(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
//below is the keycard class
class Keycard {

    int y, x;
    int level;

    char symbol = 'W';
    
    public Keycard(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//below is the Treasure class
class Treasure {

    int y, x;
    int level;

    char symbol = 'T';

    public Treasure(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//below is the Wall class
class Wall {

    int y, x;
    int level;

    char symbol = '■';

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public char getSymbol() {
        return symbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
