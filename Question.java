package assignment1;
import java.util.Arrays;

/*
 * Configure the question types and candidate answers. It should support 2 types of
 * questions: 1) multiple-choice question (more than one choice can be chosen including
 * one choice); 2) single choice question (only one choice can be chosen). For each type,
 * you can configure the candidate answers, such as “A”, “B”, “C”, “D”, or “1.
 * Right”, “2. Wrong”, etc.
 * Uses inheritance and polymorphism
 */

class Question {
	protected String[] answerArr;
	protected String answer;
}

class MutipleChoice extends Question{
	/*
	 * Allows multiple letters to be inserted
	 * @param char  an array of chars from letters
	 * return void 
	*/
	public void mcQues(String letterArr[]) {
		this.answerArr = letterArr;
	};
	
}

class SingleChoice extends Question{
	/*
	 * Allows a single letter to be inserted
	 * @param char  a single char from letters
	 * return void 
	*/
	public void scQues(String letter) {
		this.answer = letter;
	};
}