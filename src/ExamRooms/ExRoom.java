package ExamRooms;

import Employees.MS;
import Employees.SR;
import Employees.SS;

public abstract class ExRoom {

	protected final int size;
	protected final int MSMax;
	protected int floor;
	
	protected int student_number = 0;
	protected boolean isActive = false;
	
	
	protected MS[] ms;
	protected SR sr;
	protected SS ss;
	
	
    public ExRoom(int size, int MSMax) {
	this.size = size;
	this.MSMax = MSMax;
	this.ms = new MS[MSMax];
    }
    
    public int getSize() {
    	return this.size;
    }
    
    public int getFloor() {
    	return floor;
    }
    
    public void setSR(SR sr) {
    	this.sr = sr;
    }
    
    public void setSS(SS ss) {
    	this.ss = ss;
    }
    
    public void setMS(MS m, int index) {
    	ms[index] = m;
    }
    
    public void setStudentNumber(int Number) {
    	this.student_number = Number;
    }
    
    
	
}
