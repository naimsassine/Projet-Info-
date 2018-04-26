package Model;

public class AttackWeaponsRange extends AttackWeapons {
	
	private int remainingAmmo;
	
	public AttackWeaponsRange(int attackForce, int attackRange, int remainingAmmo) {
		super(attackForce, attackRange);
		
		if (remainingAmmo > 0) {
			this.remainingAmmo = remainingAmmo;
		}
		
	}
	
	
	public int getRemainingAmmo() {
		return remainingAmmo;
	}
	
	public int setRemainingAmmo(int ammo) {
		//int remainingAmmo = getRemainingAmmo();
		if (ammo > 0) {
			return (this.remainingAmmo += ammo);
		}
		else {return this.remainingAmmo;}
	}

}
