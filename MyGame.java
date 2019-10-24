import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyGame implements Game {

	private boolean active = true;
	public MyPlayer player;
	private MyBattle fight1;
	private MyBattle fight2;
	private MyBattle fight3;
	public MyRoom[] dungeon;
	private MyMonster monster1;
	private MyMonster monster2;
	private MyMonster monster3;
	private MyRoom room1;
	private MyRoom room2;
	private MyTreasureRoom treasureRoom;



	//checks if file exists
	public MyGame() {


		File playerInfo = new File("C:\\Users\\Mohammad T. Khan\\Desktop\\PlayerInfo.txt");

		if(playerInfo.exists()) {

			System.out.println("File exists");
		} else {
			System.out.println("File doesn't exist");
		}

		playerInfo.canRead();


		try {
			BufferedReader br = new BufferedReader( new FileReader(playerInfo));

			//String line;
			try {


				String name = br.readLine();
				String description = br.readLine();
				int hitPoints = Integer.parseInt(br.readLine());
				int damage = Integer.parseInt(br.readLine());
				int healAmount = Integer.parseInt(br.readLine());

				player = new MyPlayer("Mohamed","...",56,89,78);



			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//player = new Player("Angeline", "Scary", 100, 15, 25);
		monster1 = new MyMonster("Orc","covered with green blood", 20,5,0, active );
		fight1 = new MyBattle(player, monster1);
		room1 = new MyRoom(0,"a room with an unbearable smell",monster1);
		monster2 = new MyMonster("Skeleton","funny how it moves", 40,10,10, active );
		fight2 = new MyBattle(player, monster2);
		room2 = new MyRoom(1,"dark and cold",monster2);
		monster3 = new MyMonster("Fire dragon","spout fire with each breath", 100,20,40, active );
		fight3 = new MyBattle(player, monster3);
		treasureRoom = new MyTreasureRoom(2,"a giant hall with something shiny on the other "
				+ "end",monster3,"a large pile of gold");

		dungeon = new MyRoom[] {room1,room2,treasureRoom};



	}
	
	
	public void createNewFile(String fileName) {
		PrintWriter outStream = null;
		
		try {
			outStream = new PrintWriter(fileName);
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not create the file "+fileName);
		}
		finally{
			if(outStream !=null){
				outStream.close();
			}
		}
		
	}



	public void play() {

		while(active) {
			if(monster1.isAlive()) {
				room1.enter(player);
				fight1.run();

			}
			if(monster2.isAlive()) {
				room2.enter(player);
				fight2.run();
			}
			if(monster3.isAlive()) {
				treasureRoom.enter(player);
				fight3.run();
			}

			if(!(monster1.isAlive() && monster2.isAlive() && monster3.isAlive()) || !player.isAlive() ) {
				this.active = false;
			}
		}
	}
	public void writeToNewFile(String fileName, String fileContent){
		PrintWriter outStream =null;//use the PrintWriter to create our output stream
		try {
			outStream = new PrintWriter(fileName);//create & connect the output stream to the file using the String fileName
			outStream.println(fileContent);//write the String to the file
			System.out.println("Successfully wrote to the file "+fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			System.out.println("Inside writeToNewFile method problem creating/write the file "+fileName);
		}
		finally{
			if(outStream != null){//if not closed
				outStream.close(); //close it
			}
			System.out.println("All done with writeToNewFile method");
		}
	}

	public static void main(String[] args) {

		Game game = new MyGame();


		game.play();
	}


}