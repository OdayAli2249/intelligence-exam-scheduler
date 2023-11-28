package Employees;

public abstract class Employee {

	protected boolean[] Avails;
	protected boolean[] Prefs;
	
	protected String Name;
	protected int ID;
	
	public Employee(String Name, int ID) {
		
		this.Name = Name;
		this.ID = ID;
		
		Avails = new boolean[6];
		Prefs = new boolean[6];
		
	}
	
	public String getName() {
		return Name;
	}
	
	public void setAvails(boolean d1p1,boolean d1p2,boolean d1p3
			             ,boolean d2p1,boolean d2p2,boolean d2p3) {
		
		Avails[0] = d1p1; 
		Avails[1] = d1p2;
		Avails[2] = d1p3;
		Avails[3] = d2p1;
		Avails[4] = d2p2;
		Avails[5] = d2p3;
		
	}
	
	
	public void setprefs(boolean d1p1,boolean d1p2,boolean d1p3
            ,boolean d2p1,boolean d2p2,boolean d2p3) {

		Prefs[0] = d1p1; 
		Prefs[1] = d1p2;
		Prefs[2] = d1p3;
		Prefs[3] = d2p1;
		Prefs[4] = d2p2;
		Prefs[5] = d2p3;

    }
	
}
