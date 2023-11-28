package Main;

import java.util.ArrayList;

public class DistribGen {
	
	public static int[] ids = {1,2,3,4,5};
	public static int[] costs = {30, 50, 70, 50, 50};
	public static int[] GSN = {1, 2, 4, 2, 2};
	public static int[] Floor = {1, 1, 1, 2, 2};
	
	public static ArrayList<ArrayList<Integer>> PSs = new ArrayList<>();
	public static ArrayList<Integer[]> PSst = new ArrayList<>();
	public static int students = 150;
	
	public static void add(ArrayList<Integer> Sol) {
		PSs.add(Sol);
	}
	public static void addt(int[] Sol) {
		Integer[] newS = new Integer[5];
		for(int i = 0; i < 5; i++) {
			newS[i] = Sol[i];
		}
		PSst.add(newS);
	}
	public static boolean found(int a , ArrayList<Integer> S) {
		for(int i = 0; i < S.size(); i++) {
			if(S.get(i) == a) {
				return true;
			}
		}
		return false;
	}
	
	public static void generatPSs() {
		PSs = new ArrayList<>();
		PSst = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j == i) {
					continue;
				}
				for(int k = 0; k < 5; k++) {
					if(k == j || k == i) {
						continue;
					}
					for(int l = 0; l < 5; l++) {
						if(l == k || l == j || l == i) {
							continue;
						}
						for(int m = 0; m < 5; m++) {
							if(m == l || m == k || m == j || m == i) {
								continue;
							}
							int[] s = {i, j, k, l, m};				        
							addt(s);
						}
					}
				}
			}
		}
		
		int SC;
		for(int i = 0; i < PSst.size(); i++) {
			ArrayList<Integer> S = new ArrayList<>();
			SC = students;
			for(int j = 0; j < PSst.get(i).length; j++) {
				if(SC - costs[PSst.get(i)[j]] > 0) {
				SC -= costs[PSst.get(i)[j]];
				S.add(ids[PSst.get(i)[j]]);
				}else {
					S.add(ids[PSst.get(i)[j]]);
					add(S);
					break;
				}
			}
		}
		
	}
	
	public static void print() {
		int y = 0;
		for(ArrayList<Integer> i : PSs) {
			System.out.println("Sol : " + y++);
			for(Integer j : i) {
				System.out.println(j);
			}
		}
	}
	
	public static void printT() {
		for(int i = 0; i < PSst.size(); i++) {
			System.out.println("Sol : ");
			for(int j = 0; j < PSst.get(i).length; j++) {
				System.out.println(PSst.get(i)[j]);
				
			}
			System.out.println("CN " + (i+1));
		}
	}
	
	public static ArrayList<Integer> Minimize() {
	
		ArrayList<Integer> Rptions = new ArrayList<>();
		for(int i = 0; i < PSs.size() ; i++) {
			for(int j = i+1; j < PSs.size() ; j++) {
				if(PSs.get(i).size() == PSs.get(j).size()) {
					boolean T = true;
					for(int k = 0; k < PSs.get(j).size(); k++) {
						if(!found(PSs.get(j).get(k),PSs.get(i))) {
							T = false;
							break;
						}
						
					}
					if(T == true) {
						if(!found(j, Rptions)) {
							Rptions.add(j);
						}
					}
				}
			}
		}
		return Rptions;
	}
	
    public static ArrayList<ArrayList<Integer>> generateSort(int stu){
    	students = stu;
    	generatPSs();
		ArrayList<Integer> r = Minimize();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	
		for(int i = 0; i < PSs.size(); i++) {
		if(!found(i,r)) { 
			
			   ArrayList<Integer> s = new ArrayList<>();
			   for(Integer j : PSs.get(i)) {
				s.add(j);
				
			   }
			   res.add(s);
		       }
		}
		
	
		return res;
    }
	
		
	
}

