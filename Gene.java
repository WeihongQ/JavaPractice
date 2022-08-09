
public class Gene {
	
	public static int findStopCodon(String dna, int StartIndex, String StopCondo) {
		int StopIndex = dna.indexOf(StopCondo, StartIndex +3);
		if (StopIndex == -1) {
			return -1;
		}
		else {
		String gene = dna.substring(StartIndex, StopIndex);
		if (gene.length() % 3 ==0) {
			return StopIndex+3;
		}
		
		return -1;
		}
	}
	
	
	public static int testFindStopCondo(){
		String dna = "AATGCTAACTAGCTGACTAAT";
		int StopCondo = findStopCodon(dna, 0, "TAG");
		return StopCondo;
	}
	
	
	public static String findGene(String dna, int start) {
		int StartIndex = dna.indexOf("ATG", start);
		if (StartIndex == -1) {
			return "";
		}
		
		int taaGene = findStopCodon(dna, StartIndex, "TAA");
		int tagGene = findStopCodon(dna, StartIndex, "TAG");
		int tgaGene = findStopCodon(dna, StartIndex, "TGA");
		
		int temp=dna.length();
		
		if(taaGene != -1 || tagGene != -1 || tgaGene != -1) {
			if (taaGene < temp && taaGene != -1 ) {temp = taaGene;}
			if (tagGene < temp && tagGene != -1) {temp = tagGene;}
			if (tgaGene < temp && tgaGene != -1) {temp = tgaGene;}
			
		}
		else {
			temp = -1;
			
		}
		
		int minIndex = temp;
		
		if(minIndex == -1) {
			return "";			
		}
		
		return dna.substring(StartIndex, minIndex);
		
	}
	
	public static void printAllGenes (String dna) {
		int StartIndex = 0;
		while(true) {
			String CurrGene = findGene(dna, StartIndex);
			
			if (CurrGene.isEmpty()) {
				break;
			}
			System.out.println(CurrGene);
			StartIndex = CurrGene.indexOf(CurrGene, StartIndex) + CurrGene.length();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int SC = testFindStopCondo();
		// System.out.println("The stop condo is: " + SC);
		
		String dna = "AATGCTAACTAGCTGACTAAT";
		printAllGenes(dna);

	}

}
