
package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


import State.state;

public class Generator{
	
	public static Queue<Integer> pQueue;
	public static ArrayList<state> InitialStates = new ArrayList<>();
	
	public static ArrayList<state> generateInitialStates() {
		
		ArrayList<state> res = new ArrayList<>();
		
		
		int[][] p1 = Tools.Convert(DistribGen.generateSort(Informations.StudentPerPeriod[0]));
		int[][] p2 = Tools.Convert(DistribGen.generateSort(Informations.StudentPerPeriod[1]));
		int[][] p3 = Tools.Convert(DistribGen.generateSort(Informations.StudentPerPeriod[2]));
		int[][] p4 = Tools.Convert(DistribGen.generateSort(Informations.StudentPerPeriod[3]));
		
		
		
		for(int i = 0; i < p1.length; i++) {
			for(int j = 0; j < p2.length; j++) {
				for(int k = 0; k < p3.length; k++) {
					for(int l = 0; l < p4.length; l++) {
						
						int[] ic = Tools.CopyMatrix(p1[i]);
						int[] jc = Tools.CopyMatrix(p2[j]);
						int[] kc = Tools.CopyMatrix(p3[k]);
						int[] lc = Tools.CopyMatrix(p4[l]);
						
						int[][] s = new int[4][];
						
						s[0] = ic;
						s[1] = jc;
						s[2] = kc;
						s[3] = lc;
						
						res.add(new state(s));
						
					}
				}
			}
		}
		
		//res = Tools.Mi
		
		return res;
		
	}
	
	public static ArrayList<state> getPossibleStates(state s){
		
		ArrayList<state> states = new ArrayList<>();
		
		
		int ID = s.Halls[s.CurrentPerido][s.CurrentHall];
		int[][] M = new int[3][];
		ArrayList<ArrayList<ArrayList<Integer>>> Matrices = new ArrayList<>();
		
		if(ID == 1) {
			
			
			
			
			for(int i= 0; i < s.EMAva[s.CurrentPerido].length; i++) {
				
				if(s.EMUsed[s.EMAva[s.CurrentPerido][i]-1] < (int) Math.floor(s.EMAVG) + 1)
					
				for(int j= 0; j < s.HSecAva[s.CurrentPerido].length; j++) {
					
					if(s.HSecUsed[s.HSecAva[s.CurrentPerido][j]-1] < (int) Math.floor(s.HSecAVG) + 1)
						
					for(int k= 0; k < s.GradStuAva[s.CurrentPerido].length; k++) {
						
						if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][k]-1] < (int) Math.floor(s.GradStuAVG) + 1) {
							
						M[0] = new int[1];
						M[0][0] = i;
						
						M[1] = new int[1];
						M[1][0] = j;
						
						M[2] = new int[1];
						M[2][0] = k;
						Matrices.add(Tools.Convert(M));
						}
					}
					
				}
				
			}
			
		}else if(ID == 2 || ID == 4 || ID == 5) {
			for(int i= 0; i < s.EMAva[s.CurrentPerido].length; i++) {
				
				if(s.EMUsed[s.EMAva[s.CurrentPerido][i]-1] < (int) Math.floor(s.EMAVG) + 1)
				
				for(int j= 0; j < s.HSecAva[s.CurrentPerido].length; j++) {
					
					if(s.HSecUsed[s.HSecAva[s.CurrentPerido][j]-1] < (int) Math.floor(s.HSecAVG) + 1)
					
					for(int k= 0; k < s.GradStuAva[s.CurrentPerido].length - 1; k++) {
						
						if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][k]-1] < (int) Math.floor(s.GradStuAVG) + 1)
						
						for(int l= k+1;l < s.GradStuAva[s.CurrentPerido].length; l++) {
							
							if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][l]-1] < (int) Math.floor(s.GradStuAVG) + 1) {
							
							M[0] = new int[1];
							M[0][0] = i;
							
							M[1] = new int[1];
							M[1][0] = j;
							
							M[2] = new int[2];
							M[2][0] = k;
							M[2][1] = l;
							Matrices.add(Tools.Convert(M));
							}
						}
						
					}
					
				}
				
			}
			
		}else if(ID == 3) {
			for(int i= 0; i < s.EMAva[s.CurrentPerido].length; i++) {
				if(s.EMUsed[s.EMAva[s.CurrentPerido][i]-1] < (int) Math.floor(s.EMAVG) + 1)
				for(int j= 0; j < s.HSecAva[s.CurrentPerido].length; j++) {
					if(s.HSecUsed[s.HSecAva[s.CurrentPerido][j]-1] < (int) Math.floor(s.HSecAVG) + 1)
					for(int k= 0; k < s.GradStuAva[s.CurrentPerido].length - 3; k++) {
						if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][k]-1] < (int) Math.floor(s.GradStuAVG) + 1)
						for(int l= k+1;l < s.GradStuAva[s.CurrentPerido].length - 2; l++) {
							if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][l]-1] < (int) Math.floor(s.GradStuAVG) + 1)
		
							for(int m= l+1;m < s.GradStuAva[s.CurrentPerido].length - 1; m++) {
								if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][m]-1] < (int) Math.floor(s.GradStuAVG) + 1)
								for(int n= m+1;n < s.GradStuAva[s.CurrentPerido].length; n++) {
									if(s.GradStuUsed[s.GradStuAva[s.CurrentPerido][n]-1] < (int) Math.floor(s.GradStuAVG) + 1)
									{M[0] = new int[1];
									M[0][0] = i;
									
									M[1] = new int[1];
									M[1][0] = j;
									
									M[2] = new int[4];
									M[2][0] = k;
									M[2][1] = l;
									M[2][2] = m;
									M[2][3] = n;
									Matrices.add(Tools.Convert(M));
									}
								}
								
							}
							
						}
						
					}
					
				}
				
			}
		
		}
		/*
		int a = 0;
		for(ArrayList<ArrayList<Integer>> sss : Matrices) {
			a++;
			if(a > 4) {
				break;
			}
			Tools.Print("type ", sss);
		}
		*/
		int CurrentPerido = s.CurrentPerido;
		int CurrentHall = s.CurrentHall;
		
		s.UpdateCounter();
		
		if(Matrices.size() == 0) {
			return null;
		}
		
		int b = 0;
		for(int i = 0; i < Matrices.size(); i++) {
			b++;
			if(b > 4) {
				break;
			}
            // 3-1
			int [][] EMAva = Tools.CopyMatrix(s.EMAva);
			int [][] GradStuAva = Tools.CopyMatrix(s.GradStuAva);
			int [][] HSecAva = Tools.CopyMatrix(s.HSecAva);
			
			int[][] CurrMatrix = Tools.Convert(Matrices.get(i));
			
			// 3-2
			int[] deletedEM = Tools.delete(EMAva, CurrMatrix[0], CurrentPerido);
			int[] deletedHS = Tools.delete(HSecAva, CurrMatrix[1], CurrentPerido);
			int[] deletedGS = Tools.delete(GradStuAva, CurrMatrix[2], CurrentPerido);
			//System.out.println("deleted gs len : "+ deletedGS.length);
			
			//System.out.println("deleted grad : ");
			for(int j = 0; j < deletedGS.length; j++) {
				//System.out.println(deletedGS[j]);
			}
			
			// 3-3
			int[][][] CurrentDis = Tools.CopyMatrix(s.CurrentDist); 
			//System.out.println("dist for curr per and curr hall : "+ s.CurrentDist[CurrentPerido][CurrentHall].length);
			//System.out.println("dist for curr per and curr hall ( copy ): "+ CurrentDis[CurrentPerido][CurrentHall].length);
			
			
			CurrentDis[CurrentPerido][CurrentHall][0] = deletedEM[0];
			CurrentDis[CurrentPerido][CurrentHall][1] = deletedHS[0];
			for(int j = 0; j < deletedGS.length; j++) {
				CurrentDis[CurrentPerido][CurrentHall][2 + j] = deletedGS[j];	
			}
			
			// 3-4
			int [] EMUsed = Tools.CopyMatrix(s.EMUsed);
			int [] HSecUsed = Tools.CopyMatrix(s.HSecUsed);
			int [] GradStuUsed = Tools.CopyMatrix(s.GradStuUsed);
			
			
			
			EMUsed[deletedEM[0] - 1]++;
			HSecUsed[deletedHS[0] - 1]++;
			for(int j = 0; j < deletedGS.length; j++) {
				//System.out.println("deleted gs that will be index of grad used : "+ (deletedGS[j] - 1));
				//System.out.println("grad used size : "+ GradStuUsed.length);
				GradStuUsed[deletedGS[j] - 1]++;
			}
			double cost = computeAddationCost(deletedEM, deletedHS, deletedGS, CurrentPerido, CurrentHall, s); 
			state child = new state(s.Halls,CurrentDis,EMAva,GradStuAva,HSecAva,EMUsed,GradStuUsed,HSecUsed
					               ,s.CurrentHall,s.CurrentPerido,s.cost + cost,s.EMAVG,s.GradStuAVG,s.HSecAVG);
			states.add(child);
		}

		
		return states;
	}
	
	public static double computeAddationCost(int[] deletedEM, int[] deletedHS, int[] deletedGS, int CurrentPer, int CurrentHal, state father) {
		
		double cost = 1;
		
		if(CurrentHal == 0) {
		   if( (Tools.found(1, father.Halls[CurrentPer]) || Tools.found(2, father.Halls[CurrentPer]) || Tools.found(3, father.Halls[CurrentPer]))
				&& (Tools.found(4, father.Halls[CurrentPer]) || Tools.found(5, father.Halls[CurrentPer]))) {
			cost++;
	     	}
		}
		if(CurrentHal == father.Halls[CurrentPer].length - 1) {
			double Stu = Informations.StudentPerPeriod[CurrentPer] * 1.0;
			for(int i = 0; i < father.Halls[CurrentPer].length; i++) {
				Stu -= DistribGen.costs[i];
			}
			cost -= (double) Stu / 10;
		}
		
		for(int i = 0; i < deletedGS.length; i++) {
			//System.out.println("CurrentPer : " + (deletedGS[i] - 1));
			if(Informations.GradStuPrefs[deletedGS[i] - 1][CurrentPer] == false) {
				cost++;
			}
		}
		
		if(Informations.EMPrefs[deletedEM[0] - 1][CurrentPer] == false) {
			cost++;
		}
		
		if(Informations.HSecPrefs[deletedHS[0] - 1][CurrentPer] == false) {
			cost++;
		}
		
		if(CurrentHal == 0) {
			if(DistribGen.costs[father.Halls[CurrentPer][CurrentHal] - 1] == 70) {
				
			}else if(DistribGen.costs[father.Halls[CurrentPer][CurrentHal] - 1] == 50) {
				cost++;	
			}else {
				cost += 2;	
			}
		}else {
			if(DistribGen.costs[father.Halls[CurrentPer][CurrentHal - 1] - 1] < DistribGen.costs[father.Halls[CurrentPer][CurrentHal] - 1]) {
				cost++;
			}
		}
		
		return cost*cost*cost*cost;
	}
	
	
	
	
	

	public static ArrayList<state> Close = new ArrayList<>();
	public static PriorityQueue<state> Open = new PriorityQueue<>(new Comparator<state>() {

		@Override
		public int compare(state x, state y) {
			if (x.cost > y.cost) {
	            return -1;
	        }
	        if (x.cost < x.cost) {
	            return 1;
	        }
	        return 0;
		}
		
	});  
	
	public static void Initialize() {
		ArrayList<state> InitStates = generateInitialStates();
		state initstate = Tools.Minimize(InitStates);
	
		Open.add(initstate);
		
	}

	public static void main(String []args) {
		/*
		InitialStates = generateInitialStates();
		
		
		state s = InitialStates.get(700);
		s.Print();
		
		ArrayList<state> subSsl1 = getPossibleStates(s);	
		s = subSsl1.get(0);
		s.Print();
		
		ArrayList<state> subSsl2 = getPossibleStates(s);
		s = subSsl2.get(0);
		s.Print();
		
		ArrayList<state> subSsl3 = getPossibleStates(s);
		s = subSsl3.get(0);
		s.Print();
		
		ArrayList<state> subSsl4 = getPossibleStates(s);
		s = subSsl4.get(0);
		s.Print();
		*/
		
		
		
		
          state CurrentState;
          ArrayList<state> Children;
          
          Initialize();
          
          while(true) {
        	
        	  
        	CurrentState = Open.remove();
        	
        	if(CurrentState.isEndState())
        		break;
        	
        	Close.add(CurrentState);
        	
        	Children = getPossibleStates(CurrentState);
        	
        	if(Children != null) {
        	
        	for(state s : Children) {
        		Open.add(s);
        	}
        	
        	}
          }
          
          CurrentState.Print();
		
	}
		
    	
	
}






