package ExamRooms;

import java.util.ArrayList;

public class ExPer {

	private int Students;
	private ArrayList<ExRoom> ExamRooms;
    
	public ExPer() {
		this.Students = 0;
		this.ExamRooms = new ArrayList<>();
		
		this.ExamRooms.add(new ERI(1));
		this.ExamRooms.add(new ERII(1));
		this.ExamRooms.add(new ERIII(1));
		
		this.ExamRooms.add(new ERII(2));
		this.ExamRooms.add(new ERII(2));
	}
	
}
