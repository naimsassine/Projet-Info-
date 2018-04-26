package Model;

public class AttackWeapons {
	
	protected int attackForce;
	protected int attackRange;
	
	public AttackWeapons(int attackForce, int attackRange) {
		if ((attackForce > 0) && (attackRange > 0) && (attackRange < 5)) {
			this.attackForce = attackForce;
			this.attackRange = attackRange;
		}
	}
	
	
	public int getAttackForce() {
		return attackForce;		
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
}
