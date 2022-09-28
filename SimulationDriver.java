package assignment1;
import java.util.HashMap;

/*
 * You need a SimulationDriver to automatically simulate the whole process. Basically,
 * the driver will 1) create a question type and configure the answers; 2) configure the
 * question for iVote Service; 3) randomly generate a number students and the answers; 4)
 * submit all the students’ answers to iVote Service; 5) call the Voting Service output
 * function to display the result.
 */

public class SimulationDriver {
	private VotingService v;
	private HashMap<Integer, String> studentAns;
	private HashMap<Integer, String> mcAns;
	private HashMap<Integer, String> scAns;
	private int countA;
	private int countB;
	private int countC;
	private int countD;
	private int countTrue;
	private int countFalse;
	
	void createRandStudent() {
		v = new VotingService();
		studentAns = new HashMap();	//create a new hash map when class SimulationDriver is instantiated 
	}
	
	void generateMCAns() {
		this.mcAns = v.questionMultipleChoice();
		for (HashMap.Entry<Integer, String> entry : this.mcAns.entrySet()) {	//put mc answers in a single hash map
			this.studentAns.put(entry.getKey(), entry.getValue());
		}
	}
	void generateSCAns() {
		scAns = v.questionSingleChoice();
		for (HashMap.Entry<Integer, String> entry : scAns.entrySet()) {	//put sc answers in a single hash map
			studentAns.put(entry.getKey(), entry.getValue());
		}
	}
	void submissionStats() {
		for(String value: studentAns.values()) {
			if (value.equals("A")) {
				countA++;
			}
			if(value.equals("B")) {
				countB++;
			}
			if(value.equals("C")) {
				countC++;
			}
			if(value.equals("D")) {
				countD++;
			}
			if (value.equals("True")) {
				countTrue++;
			}
			if(value.equals("False")) {
				countFalse++;
			}
		}
		
		System.out.println("= Statistics of the submission results =");
		System.out.println("\tA : " + countA);
		System.out.println("\tB : " + countB);
		System.out.println("\tC : " + countC);
		System.out.println("\tD : " + countD);
		System.out.println("\tTrue : " + countTrue);
		System.out.println("\tFalse : " + countFalse);
		//v.submissionStats();
	}
	void displayAns() {
		System.out.println("= Student Answers =");
		for (HashMap.Entry<Integer, String> entry : studentAns.entrySet()) {	//put sc answers in a single hash map
			System.out.println("\t" + entry.getKey() + " " + entry.getValue());
		}
	}
	
	
	public static void main(String[] args) {	
		SimulationDriver student1 = new SimulationDriver();
		student1.createRandStudent();
		student1.generateMCAns();
		student1.generateMCAns();
		student1.generateSCAns();
		student1.generateSCAns();
		student1.displayAns();
		student1.submissionStats();
		System.out.print("\n");
		
		SimulationDriver student2 = new SimulationDriver();
		student2.createRandStudent();
		student2.generateMCAns();
		student2.generateSCAns();
		student2.generateMCAns();
		student2.generateSCAns();
		student2.displayAns();
		student2.submissionStats();
		
		

	}

}
