
public class MyTreasureRoom extends MyRoom implements TreasureRoom{
	private String treasure;
	  
	   //constructor
	   public MyTreasureRoom (int roomIndex, String description, Monster monster, String treasure) {
	       super(roomIndex, description, monster);
	       this.treasure = treasure;
	   }
	  
	  
	   @Override
	   public void enter(Player player) {
		   System.out.println( "This room is " + this.description + 
	    		   " and has" + this.monster);
	       if (monster.isAlive() == true) {
	    	   System.out.println("Player has entered the room");
	    	   player.attack(monster);
	       }
	       if (player.isAlive() &&  !monster.isAlive()){
	    	   System.out.println("You explored the room and found the hidden treasure!");
	    	  }
	   
	   
	   }
	   
	   
	   

}