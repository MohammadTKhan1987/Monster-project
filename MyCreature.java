
public class MyCreature implements Creature {
	
 String name;
 String description; 
int hitPoints; 
 int damage; 
 int[] room = null;

public MyCreature(String name, String description, int hitPoints, int damage) {
	this.name=name;
	this.description=description;
	this.hitPoints=hitPoints;
	this.damage=damage;
}
 
public void setHitPoints(int hitPoints) {
	this.hitPoints = hitPoints;
}

public void setDamage(int damage) {
	this.damage = damage;
}

public void setRoom(int[] room) {
	this.room = room;
}

public String getName() {
	return name;
}

public String getDescription() {
	return description;
}

public int getHitPoints() {
	return hitPoints;
}

public int getDamage() {
	return damage;
}

public int[] getRoom() {
	return room;
}

@Override
public String toString() {
	String a = String.format("name %15s, description %20s, hitPoints %03d, damage %02d", name, description, hitPoints, damage);
	return a;
}

@Override
public void attack(Creature creature) {
	// TODO Auto-generated method stub
	System.out.println(this.name + "attacks" + creature + "dealing" + damage + "damage");
}

@Override
public void takeDamage(int damage) {
	// TODO Auto-generated method stub
	this.hitPoints-=this.damage;
	if(hitPoints < 0) {
		System.out.println("Hit points can't be below 0");
	}
}

@Override
public boolean isAlive() {
	// TODO Auto-generated method stub
	  if   (this.hitPoints > 0 ) {
			
			return true; 
}
			return false;
	}


}
