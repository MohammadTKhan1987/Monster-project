
public class MyPlayer extends MyCreature implements Player {
	
	 int healAmount;
	  
	   // gets parameters from creature
	   public MyPlayer(String name, String description, int hitPoints, int damage, int healAmount) {
	       super(name, description, hitPoints, damage);
	       this.healAmount = healAmount;
	   }
	   //increases player health by healAmount
	   public void heal() {
	       this.hitPoints+=this.healAmount;
	       System.out.println(this.name + "is healed by" + this.healAmount);
	   }
	   
	   

}
