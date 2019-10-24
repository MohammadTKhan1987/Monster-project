
public class MyRoom implements Room {

	private int roomIndex;
	   protected String description;
	   protected Monster monster;
	  
	   // room constructor
	   public MyRoom(int roomIndex, String description, Monster monster) {
	       this.roomIndex = roomIndex;
	       this.description = description;
	       this.monster = monster;
	   }
	  
	  
	   //checks if room is completed
	   public boolean isComplete() {
	       if (monster.isAlive() == false) {
	       return true;
	       }
	       return false;
	       }
	  

	  
	   // room name, monster inside, battle start
	   public void enter(Player player) {
		   System.out.println( "This room is " + this.description + 
	    		   " and has" + this.monster);
	       if (monster.isAlive() == true) {
	    	   System.out.println("Player has entered the room");
	    	   player.attack(monster);
	       }
	   }
	  
	   
	  
	   @Override
	   public String toString() {
	       String b = String.format("Room index %2d, description %20s, monster name %20s", roomIndex, 
	    		   description, monster);
	       return b;
	   }

}
