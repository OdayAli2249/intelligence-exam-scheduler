package Main;

import java.util.ArrayList;

public class Informations {

	// Education management members
	public static int[] EduMangIDs = {1,2,3,4,5,6,7,8,9,10};
	public static String[] EduMangNames = {"ahmad", "medhat", "obay", "ammar","ghiath","asmahan","farah","mayad","basem","maher"};
	
	
	                                    // d1p1   d1p2  d2p1  d2p2
	
	public static boolean[][] EMAvails = {{false, true, false, true},      //ahmad
			                             {true, false, true,false},       //medhat
	                                     {false, true, false, true},        //oday
	                                     {true, false, true ,false},         //ammar
			                             {false, true, false, true},      //ghiath
	                                     {true, false, true, true},      //asmahan
	                                     {true, false, true, false},         //farah
			                             {false, true, false, true},       //mayad
			                             {true, false, true, false},        //basem
			                             {false, true, false, true}};      //maher
	

	public static boolean[][] EMPrefs = {{false, true, false, false},      //ahmad  
			                            {true, false, false,false},        //medhat
	                                    {false, true, false, false},        //oday
	                                    {true, false, false ,false},        //ammar
			                            {false, false, false, false},      //ghiath
	                                    {true, false, true, false},       //asmahan
	                                    {false, false, true, false},         //farah
			                            {false, false, false, true},       //mayad
			                            {true, false, false, false},        //basem
			                            {false, true, false, true}};       //maher
	
	


	

		//  graduated students
		public static int[] GradStuIDs = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		public static String[] GradStuNames = {"laith", "qusay", "oday", "hani","ramez","abd","riad","moaz","ibrahem","aghiad",
				                                "nawras","anas","tarek","omar","joad","walid","bilal","khaled","rami","hasan"};
		
	                                           	 // d1p1   d1p2  d2p1  d2p2
		
		public static boolean[][] GradStuAvails = {{false, true, false, true},      //ahmad
                {true, false, true,false},       //medhat
                {false, true, false, true},        //oday
                {true, false, true ,false},         //ammar
                {false, true, false, true},      //ghiath
                {true, false, true, true},      //asmahan
                {true, false, true, false},         //farah
                {false, true, false, true},       //mayad
                {true, false, true, false},        //basem
                {false, true, false, true},     //aghiad
                {false, true, false, true},      //ahmad
                {true, false, true,false},       //medhat
                {false, true, false, true},        //oday
                {true, false, true ,false},         //ammar
                {false, true, false, true},      //ghiath
                {true, false, true, true},      //asmahan
                {true, false, true, false},         //farah
                {false, true, false, true},       //mayad
                {true, false, true, false},        //basem
                {false, true, false, true}};      //hasan
		

		public static boolean[][] GradStuPrefs =  {{false, true, false, false},      //ahmad  
                {true, false, false,false},        //medhat
                {false, true, false, false},        //oday
                {true, false, false ,false},        //ammar
                {false, false, false, false},      //ghiath
                {true, false, true, false},       //asmahan
                {false, false, true, false},         //farah
                {false, false, false, true},       //mayad
                {true, false, false, false},        //basem
                {false, true, false, true},      //aghiad
                {false, true, false, false},      //ahmad  
                {true, false, false,false},        //medhat
                {false, true, false, false},        //oday
                {true, false, false ,false},        //ammar
                {false, false, false, false},      //ghiath
                {true, false, true, false},       //asmahan
                {false, false, true, false},         //farah
                {false, false, false, true},       //mayad
                {true, false, false, false},        //basem
                {false, true, false, true}};      //hasan
		
		
	
		// Hall secretary members
		public static int[] HallSecrIDs = {1,2,3,4,5,6,7,8,9,10};
		public static String[] HallSecrNames = {"mahmod", "ismail", "sawsan", "ammar","jack","morhaf","nada","karem","ali","nour"};
		
		                                      // d1p1   d1p2  d2p1  d2p2
		
		public static boolean[][] HSecAvails = {{false, true, false, true},      //ahmad
                {true, false, true,false},       //medhat
                {false, true, false, true},        //oday
                {true, false, true ,false},         //ammar
                {false, true, false, true},      //ghiath
                {true, false, true, true},      //asmahan
                {true, false, true, false},         //farah
                {false, true, false, true},       //mayad
                {true, false, true, false},        //basem
                {false, true, false, true}};      //nour
		

		public static boolean[][] HSecPrefs = {{false, true, false, false},      //ahmad  
                                                {true, false, false,false},        //medhat
                                                {false, true, false, false},        //oday
                                                {true, false, false ,false},        //ammar
                                                {false, false, false, false},      //ghiath
                                                {true, false, true, false},       //asmahan
                                                {false, false, true, false},         //farah
                                                {false, false, false, true},       //mayad
                                                {true, false, false, false},        //basem
                                                {false, true, false, true}};      //nour
		
		
		
	   // student number per period
	   public static int[] StudentPerPeriod = {150, 200, 120,230};
	
	   
	   
	   
	   public static ArrayList<ArrayList<Integer>> getAvailableEduMangs(){
			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			
			
			for(int i = 0; i < Informations.EMAvails[0].length; i++) {
				ArrayList<Integer> Per = new ArrayList<>();
				for(int j = 0; j < Informations.EMAvails.length; j++) {
				if(Informations.EMAvails[j][i] == true) {
					Per.add(Informations.EduMangIDs[j]);
				 }
				}
				res.add(Per);
			}
			
			return res;
		}

		public static ArrayList<ArrayList<Integer>> getAvailableGradStus(){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			
			
			for(int i = 0; i < Informations.GradStuAvails[0].length; i++) {
				ArrayList<Integer> Per = new ArrayList<>();
				for(int j = 0; j < Informations.GradStuAvails.length; j++) {
				if(Informations.GradStuAvails[j][i] == true) {
					Per.add(Informations.GradStuIDs[j]);
				 }
				}
				res.add(Per);
			}
			
			return res;
		}

		public static ArrayList<ArrayList<Integer>> getAvialHallSecrs(){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			
			
			for(int i = 0; i < Informations.HSecAvails[0].length; i++) {
				ArrayList<Integer> Per = new ArrayList<>();
				for(int j = 0; j < Informations.HSecAvails.length; j++) {
				if(Informations.HSecAvails[j][i] == true) {
					Per.add(Informations.HallSecrIDs[j]);
				 }
				}
				res.add(Per);
			}
			
			return res;
		}
			
}











