package Main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import State.state;

public class Tools {
	
	public static ArrayList<Integer> deleteItem(ArrayList<Integer> a, int item){
		ArrayList<Integer> res = new ArrayList<>();
		for(int i  = 0; i < a.size(); i++) {
			if(a.get(i) != item) {
				res.add(a.get(i));
			}
		}
		return res;
	}
	
	public static ArrayList<Integer> deleteIndex(ArrayList<Integer> a, int Index){
		ArrayList<Integer> res = new ArrayList<>();
		for(int i  = 0; i < a.size(); i++) {
			if(i != Index) {
				res.add(a.get(i));
			}
		}
		return res;
	}
	
	public static ArrayList<Integer> CopyArray(ArrayList<Integer> a){
		ArrayList<Integer> res = new ArrayList<>();
		for(int i  = 0; i < a.size(); i++) {
			res.add(a.get(i));
		}
		
		return res;
	
	}
	
	public static ArrayList<ArrayList<Integer>> CopyMatrix(ArrayList<ArrayList<Integer>> a){
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> subres = new ArrayList<>();
		for(int i = 0; i < a.size(); i++) {
			subres = new ArrayList<>();
			for(int j = 0; j < a.get(i).size(); j++) {
				subres.add(a.get(i).get(j));
			}
			res.add(subres);
		}
		return res;
		
	}
	
	public static int[][] Convert(ArrayList<ArrayList<Integer>> a){
		
		int[][] res = new int[a.size()][];
		int[] subres;
		
		for(int i = 0; i < a.size(); i++) {
			subres = new int[a.get(i).size()];
			for(int j = 0; j < a.get(i).size(); j++) {
				subres[j] = a.get(i).get(j);
			}
			res[i] = subres;
		}
		
		return res;
	}
	
	public static ArrayList<ArrayList<Integer>> Convert(int[][] a){
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> subres;
		
		for(int i = 0 ; i < a.length; i++) {
			subres = new ArrayList<>();
			for(int j = 0; j < a[i].length; j ++) {
				subres.add(a[i][j]);
			}
			res.add(subres);
		}
		
		
		return res;
	}
	
	
	// delete list if indices in row of matrix 
	
	public static int[] delete(int[][] a /*   matrix   */, int[] d /* list of indices */, int index  /* row number */) {
		
		ArrayList<Integer> NA1 = new ArrayList<>();
		ArrayList<Integer> deleted1 = new ArrayList<>();
		
		int[] dis_arr = a[index];
		boolean fou;
		for(int i = 0; i < dis_arr.length; i++) {
			fou = false;
			for(int j = 0; j < d.length; j++) {
			    if(i == d[j]) {
			    fou = true;
			    }
			}
			if(!fou) {
			NA1.add(dis_arr[i]);	
			}else {
			deleted1.add(dis_arr[i]);	
			}
		}
		
		int[] NA2 = new int[NA1.size()];
		for(int i = 0; i < NA1.size(); i++) {
			NA2[i] = NA1.get(i);
		}
		
		int[] deleted2 = new int[deleted1.size()];
		for(int i = 0; i < deleted1.size(); i++) {
			deleted2[i] = deleted1.get(i);
		}
		
		a[index] = NA2;
		
		return deleted2;
	}
	
	
	public static int[][][] CopyMatrix(int[][][] m) {
		
		int[][][] res = new int[m.length][][];
		
		
		for(int i = 0; i < res.length; i++) {
			res[i] = new int[m[i].length][];
		}
		
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[i].length; j++) {
				res[i][j] = new int[m[i][j].length];
			}
		}
		
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[i].length; j++) {
				for(int k = 0; k < res[i][j].length; k++) {
					res[i][j][k] = m[i][j][k];
				}
			}
		}
		return res;	
	}
	
	
	public static int[][] CopyMatrix(int[][] m){
		
		int[][] res = new int[m.length][];
		int[] subres;
		
		for(int i = 0; i < m.length; i++) {
			subres = new int[m[i].length];
			for(int j = 0; j < m[i].length; j++) {
				subres[j] = m[i][j];
			}
			res[i] = subres;
		}
		
		
		return res;
	}
	
	public static int[] CopyMatrix(int[] m){
		
		int[] res = new int[m.length];
		
		for(int i = 0; i < m.length; i++) {
			res[i] = m[i];
		}
		
		return res;
		
	}
	
	public static void Print(String label, ArrayList<ArrayList<Integer>> res){
		for(int i = 0; i < res.size(); i++) {
			System.out.println(label + " : " + i);
			for(int j = 0; j < res.get(i).size(); j++) {
				System.out.println(res.get(i).get(j));
			}
			
		}
	}
	
	public static void Print(String label, int[][] res){
		System.out.println();
		
		for(int i = 0; i < res.length; i++) {
			System.out.print(label);
			for(int j = 0; j < res[i].length; j++) {
				System.out.print(" " + res[i][j] + " ");
			}
			
		}
		
		
	}
	
	
	public static boolean found(int a , ArrayList<Integer> S) {
		for(int i = 0; i < S.size(); i++) {
			if(S.get(i) == a) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean found(int a , int[] S) {
		for(int i = 0; i < S.length; i++) {
			if(S[i] == a) {
				return true;
			}
		}
		return false;
	}
	
	public static int[] Minimize(int[] a) {
		
		int[] res;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		res = new int[set.size()];
		int i = 0 ;
		for(Integer ss : set) {
			res[i] = ss;
			i++;
		}
		
		return res;
	}	
	


public static void addStates(ArrayList<state> states, ArrayList<state> a) {
	for(state s : a) {
		states.add(s);
	}
}

/*
public static state getMinCost() {
	
	double MinCost = 100000000;
	int index = 0;
	int MinIndex = 0;
	ArrayList<state> openUpdate = new ArrayList<>();
	for(state s : Generator.Open) {
		
		if(s.cost < MinCost) {
			
			MinCost = s.cost;
			MinIndex = index;
		
		}
		index++;
	}
	index = 0;
	state res = Generator.Open.get(MinIndex); 
	for(state s : Generator.Open) {
		if(index != MinIndex) {
		openUpdate.add(s);
		}
		index++;
	}
	
	Generator.Open = openUpdate;
	//System.out.println(res.cost);
	return res;
	
}

*/


public static state Minimize(ArrayList<state> states) {
	
	double HN = 0;
	double FN = 0;
	int[][] Hs;
	
	for(int i = 0; i < states.size(); i++) {
		state s = states.get(i);
		Hs = states.get(i).Halls;
		HN = 0;
		for(int j = 0; j < Hs.length; j++) {
			for(int k = 0; k < Hs[j].length; k++) {
				HN +=1;
			}
			
			
		}
		
		s.cost = HN;
		
	}
	
	double MinCost = 100000000;
	int index = 0;
	int MinIndex = 0;

	for(state s : states) {
		
		if(s.cost < MinCost) {
			
			MinCost = s.cost;
			MinIndex = index;
		
		}
		index++;
	}
	
	state res = states.get(MinIndex); 
	
	return res;
}
	
}


