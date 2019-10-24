import java.util.Scanner;

//import java.util.Scanner;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;

public class MyBattle implements Battle {


	private MyPlayer player;
	private MyMonster monster;
	Scanner scnr = new Scanner(System.in);
	private String input;

	//constructor
	public MyBattle (MyPlayer player, MyMonster monster) {
		this.player = player;
		this.monster = monster;
	}


	// gets players and monsters info
	public void run() {
		System.out.println("A battle begins: " + player.getName() + " vs " + monster.getName());
		while(monster.isAlive() == true && player.isAlive() == true) {
			System.out.println();
			System.out.println(player.getName() + ": " + player.getHitPoints() + " vs " 
			+ monster.getName() + 
					": " + monster.getHitPoints());
			System.out.println(player.getName() + "'s turn");
			System.out.println("Do you want to Attack(a) or Heal(h)? ");
			System.out.println();

			//uses keyboard to check what the user inputs
			input = scnr.next();
			if(input.equals("a") || input.equals("A")) {
				monster.takeDamage(player.getDamage());

				System.out.println();
				System.out.println(monster.getName() + "'s turn");
				System.out.println();

				if(monster.canEnrage()) {
					monster.enrage();
					player.takeDamage(monster.getDamage());
				}
				else {
					player.takeDamage(monster.getDamage());
				}


			}

			else if (input.equals("h") || input.equals("H")) {
				player.heal();
			}


			//makes sure the user inputs the right letters
			else {

				System.out.println("***");
				System.out.println("Invalid input, try again");
				System.out.println("***");

			}

			//checks if monster is alive

			if(monster.isAlive() == false) {
				System.out.println();
				System.out.println("You have defeated the creature!");
				System.out.println();

			}
			else if (player.isAlive() == false) {
				// if the player loses then print game over
				System.out.println("*****");
				System.out.println("Game Over!");
				System.out.println("*****");

			}

		}

	}
}
