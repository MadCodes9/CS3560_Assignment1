package assignment1;
import java.util.Random;

/*
 * 	Allow students to submit answers. Every student has a unique ID (String), and can
 *  submit an answer to the iVote service.
 *  Uses abstraction, polymorphism and instaniate from Question class
 */

abstract class Student{
	protected String id;
	public void setStudentId(String id) {	//must have a student-id
		this.id = id;
	}
	String getStudentId() {
		return this.id;
	}
}

class RandStudent extends Student{
	/*
	 * Randomly generate student id
	 * return void
	 */
	public void setRandStudentId() {
		Random rand = new Random();
		String[] randIdArr = new String[10];
		int randId;
		StringBuffer sb = new StringBuffer();
		
		//generate a array of 10 random integers
		for(int i = 0; i < 10; i++) {
			randId = rand.nextInt(10);	//0-9
			randIdArr[i] = String.valueOf(randId); //convert int to String
		}
		
		for(int i = 0; i < 10; i++) {	//Covert an array of strings into a single string
		    sb.append(randIdArr[i]);
		 }

		this.id = sb.toString();	//covert String Buffer to string
		System.out.println("Student ID: " + this.id);
	}
}

class SubmitAnswer extends Student {
	private String[] mcAns;
	private String scAns;
	
	/*
	 * Allows a student to submit multiple choice answer 
	 * @param MutipleChoice  Submit multiple choice answer 
	 * return void
	 */
	public void submitAns(String[] mcAns) {
		this.mcAns = mcAns;
		MutipleChoice mc = new MutipleChoice();
		mc.mcQues(this.mcAns);
	}
	
	/*
	 * Allows a student to submit single choice answer 
	 * @param SingleChoice  Submit single choice answer
	 * return void
	 */
	public void submitAns(String scAns) {
		this.scAns = scAns;
		SingleChoice sc = new SingleChoice();
		sc.scQues(this.scAns);
	}
}

