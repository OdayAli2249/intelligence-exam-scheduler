package State;

import Main.Informations;
import Main.Tools;

public class state {
	
	public int[][] Halls;
	public int[][][] CurrentDist;
	
	public int[][]  EMAva;
	public int[][]  GradStuAva;
	public int[][]  HSecAva;
	
	public int[] EMUsed;          // array ( index : is id of EM / element : is current number of usage )
	public int[] GradStuUsed;     // array ( index : is id of GS / element : is current number of usage )
	public int[] HSecUsed;        // array ( index : is id of HS / element : is current number of usage )
	
	public int CurrentHall = 0;
	public int CurrentPerido = 0;
	
	public double cost = 0;
	
	public double EMAVG;
	public double GradStuAVG;
	public double HSecAVG;
	

	
	
	public state(int[][] Halls) {
		
		this.Halls = Halls;
		
		this.EMAva = Tools.CopyMatrix(Tools.Convert(Informations.getAvailableEduMangs()));
		this.GradStuAva = Tools.CopyMatrix(Tools.Convert(Informations.getAvailableGradStus()));
		this.HSecAva = Tools.CopyMatrix(Tools.Convert(Informations.getAvialHallSecrs()));
		
		this.EMUsed = new int[Informations.EduMangIDs.length];
		this.GradStuUsed = new int[Informations.GradStuIDs.length];
		this.HSecUsed = new int[Informations.HallSecrIDs.length];
		
		for(int i = 0; i < EMUsed.length; i++) {
			this.EMUsed[i] = 0;
		}
		
        for(int i = 0; i < GradStuUsed.length; i++) {
        	this.GradStuUsed[i] = 0;
		}
        
        for(int i = 0; i < HSecUsed.length; i++) {
        	this.HSecUsed[i] = 0;
		}
		
		this.CurrentDist = new int[this.Halls.length][][];
		
		for(int i = 0; i < this.CurrentDist.length; i++) {
			this.CurrentDist[i] = new int[this.Halls[i].length][];	
		}
		
		for(int i = 0; i < this.CurrentDist.length; i++) {
			for(int j = 0; j < this.CurrentDist[i].length; j++) {
				if(this.Halls[i][j] == 1) {
					this.CurrentDist[i][j] = new int[3];	
					
					this.CurrentDist[i][j][0] = -1;
					this.CurrentDist[i][j][1] = -1;
					this.CurrentDist[i][j][2] = -1;
				}else if(this.Halls[i][j] == 3) {
					this.CurrentDist[i][j] = new int[6];
					
					this.CurrentDist[i][j][0] = -1;
					this.CurrentDist[i][j][1] = -1;
					this.CurrentDist[i][j][2] = -1;
					this.CurrentDist[i][j][3] = -1;
					this.CurrentDist[i][j][4] = -1;
					this.CurrentDist[i][j][5] = -1;
				}else if(this.Halls[i][j] == 2 || this.Halls[i][j] == 4 || this.Halls[i][j] == 5) {
					this.CurrentDist[i][j] = new int[4];
					
					this.CurrentDist[i][j][0] = -1;
					this.CurrentDist[i][j][1] = -1;
					this.CurrentDist[i][j][2] = -1;
					this.CurrentDist[i][j][3] = -1;
				}
			}
		}
		
		ComputeAvg();
		
	}
	
	public state(int[][] Halls, int[][][] CurrDist, int[][] EMAva, int[][] GradStuAva, int[][] HSecAva, int[] EMUsed, int[] 
			GradStuUsed, int[] HSecUsed , int CurrentHall,int CurrentPerido,double cost,double EMAVG,double GradStuAVG,double HSecAVG)
	{
		
		this.Halls = Halls;
		this.CurrentDist = CurrDist;
		
		
		this.EMAva = EMAva;
		this.GradStuAva = GradStuAva;
		this.HSecAva = HSecAva;
		
		
		this.EMUsed = EMUsed;
		this.GradStuUsed = GradStuUsed;
		this.HSecUsed = HSecUsed;
		
		
		this.CurrentHall = CurrentHall;
		this.CurrentPerido = CurrentPerido;
		
		this.cost = cost;
		
		this.EMAVG = EMAVG;
		this.GradStuAVG = GradStuAVG;
		this.HSecAVG = HSecAVG;
		
	}
	
	public void ComputeAvg() {
	
		int sumEM = 0;
		int sumGS = 0;
		int sumHS = 0;
		
		for(int i = 0; i < Halls.length; i++) {
			for(int j = 0; j < Halls[i].length ; j++) {
				
				sumEM += 1;
				
				if(Halls[i][j] == 1) {
					sumGS += 1;	
				}else if(Halls[i][j] == 3) {
					sumGS += 4;	
				}else if(Halls[i][j] == 2 || Halls[i][j] == 4 || Halls[i][j] == 5) {
					sumGS += 2;
				}
	
				sumHS += 1;
				
			}
		}
		
		this.EMAVG = sumEM / (double) Informations.EduMangIDs.length;
		this.GradStuAVG = sumGS / (double) Informations.GradStuIDs.length;
		this.HSecAVG = sumHS / (double) Informations.HallSecrIDs.length;
		
    }
	public static int n = 0;
	public void Print() {
		// halls dist
		System.out.println("Halls Distridution : ");
		Tools.Print("|", this.Halls);
		System.out.println();
	    
		
		System.out.println();
		System.out.println("Current employees : ");
		
	    Tools.Print(" EMAva : ", this.EMAva);
	      for(int i = 0; i < this.EMAva.length; i++)
		System.out.println("pers " + i + " : " + this.EMAva[i].length);
	    
		Tools.Print(" GradStuAva : ", this.GradStuAva);
		  for(int i = 0; i < this.EMAva.length; i++)
		System.out.println("pers " + i + " : " + this.GradStuAva[i].length);
		  
		Tools.Print(" GradStuAva : ", this.HSecAva);
		  for(int i = 0; i < this.EMAva.length; i++)
		System.out.println("pers "  + i + " : " + this.HSecAva[i].length);
		  
		  
		  System.out.println("Current Distribution of employees");
		  for(int i = 0; i < this.CurrentDist.length; i++) {
			  System.out.println("------------------------------ Period");
			  for(int j = 0; j < this.CurrentDist[i].length; j++) {
				  System.out.println("------------------ employees for a hall");
				  for(int k = 0; k < this.CurrentDist[i][j].length; k++) {
					  System.out.println(this.CurrentDist[i][j][k]);
				  }  
			  }  
		  }
		  
		  System.out.println("Avgs :");
		  System.out.println("EMs :" + this.EMAVG);
		  System.out.println("GradSs :" + this.GradStuAVG);
		  System.out.println("HSs :" + this.HSecAVG);
		  
		  System.out.println("Period :" + this.CurrentPerido);
		  System.out.println("Hall :" + this.CurrentHall);
		  
		  System.out.println("Usage record : ");
		  for(int i = 0; i < this.EMUsed.length; i++) {
			  System.out.println("EMused :" + this.EMUsed[i]); 
		  }
		  System.out.println();
		  for(int i = 0; i < this.GradStuUsed.length; i++) {
			  System.out.println("GradStuUsed :" + this.GradStuUsed[i]); 
		  }
		  System.out.println();
		  for(int i = 0; i < this.HSecUsed.length; i++) {
			  System.out.println("HSecUsed :" + this.HSecUsed[i]); 
		  }
		  
	}
	
	public void UpdateCounter() {

		if(this.Halls[this.CurrentPerido].length - 1 == this.CurrentHall) {
			this.CurrentPerido++;
			this.CurrentHall = 0;
		}else {
			this.CurrentHall++;
		}
	}
	
	public boolean isEndState() {
		
		System.out.println("Per :::" + this.CurrentPerido);
		System.out.println("Hall :::" + this.CurrentHall);
		
		return this.CurrentPerido == this.Halls.length;
	}
	
}





