package assignment1;
import java.util.Random;
import java.util.*;

/*
 * The Voting Service can be first configured with a given question type and candidate
 * answers. Then, it can start accepting submissions from students. The important thing to
 * keep in mind about accepting submissions is that each student can only submit one
 * answer. If multiple submissions are received from the same student, only the last
 * submission will be counted.
 * 
 * The Voting Service can also output the statistics of the submission results. You don’t
 * have to use the graphical interface. Simply use the standard output (System.out) to
 * print out the count for each answer. For example, “A : 5, B : 12”, or “1. Right :
 * 15, 2. Wrong : 20”. Feel free to customize the format for your output.
 *
 * Uses polymorphism
 */

class VotingService {
	private String[] mcOptions = {"A", "B", "C", "D"};	
	private String[] scOptions= {"True", "False"};
	private HashMap<Integer, String> mcStudentAns;
	private HashMap<Integer, String> scStudentAns;
	private int questionNum;
	
	VotingService() { //Must have a student id for every service call
		RandStudent student = new RandStudent();
		student.setRandStudentId();	
		questionNum = 1;
	}
	
	/*
	 * Randomly picks 5 multiple choice answers (A, B, C, or D)
	 * The question is mc, so the student submits an array of strings
	 * return HashMap<Integer, String>
	 */
	HashMap<Integer, String> questionMultipleChoice() {
		mcStudentAns = new HashMap<Integer, String>();
		SubmitAnswer mcSubmit = new SubmitAnswer();
		Random randAns1 = new Random();
		int size;	//random multiple choice size from 0-5
		int min = 1;
		int max = 5;
		size = (int)Math.floor(Math.random()*(max - min +1)+ min); //0-5
		int randIndex1;
		
		for(int i = 0; i < size; i++) {
			randIndex1 = randAns1.nextInt(4);	//0-3
			mcStudentAns.put(questionNum, mcOptions[randIndex1]);
			questionNum+= 1;
		}
		mcSubmit.submitAns(this.mcStudentAns.toString());
	
		return mcStudentAns;
	}
	
	/*
	 * Randomly picks 5 single choice answers (True or False)
	 * The question is sc, so the student submits a string
	 * return HashMap<Integer, String>
	 */
	HashMap<Integer, String> questionSingleChoice() {
		scStudentAns = new HashMap<Integer, String>();
		SubmitAnswer scSubmit = new SubmitAnswer();
		Random randAns2 = new Random();
		int randIndex2;
		
		randIndex2 = randAns2.nextInt(2); //0-1
		scStudentAns.put(questionNum,scOptions[randIndex2]);
		scSubmit.submitAns(scStudentAns.toString());
		questionNum+= 1;
		
		return scStudentAns;
	}
	
	void submissionStats() {
		
	}
	
	
}
