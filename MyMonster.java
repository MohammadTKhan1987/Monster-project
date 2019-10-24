
public class MyMonster extends MyCreature implements Monster{
	private boolean isEnraged;
	  private int enrageThreshold;
	  
	   public MyMonster(String name, String description, int hitPoints, int damage, 
			   int enrageThreshold, boolean isEnraged) {
	      super(name, description, hitPoints, damage);
	       this.enrageThreshold = enrageThreshold;
	       this.isEnraged = isEnraged;
	      }
	   
	   
	  
	   public boolean canEnrage() {
	   if(hitPoints < this.enrageThreshold) {
	      return true;
	   }
	  return false;
	      }
	   
	  public void enrage() {
	       if(!isEnraged) {
	    	   this.damage = this.damage*2;
	           isEnraged = true;
	           System.out.println(this.name + "has been enraged");
	       }
	  }
	   }
