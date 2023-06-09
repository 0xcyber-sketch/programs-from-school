package opgave3MutipelChoice;

import java.util.Arrays;

public class MultipleChoice {
    private char[] correctAnswer = { 'B', 'C', 'A', 'A', 'B', 'A', 'C', 'D', 'A', 'C' };

    private char[][] studentAnswers;

    public MultipleChoice(int numberOfStudents) {
        studentAnswers = new char[numberOfStudents][10];
        for (int i = 0; i < studentAnswers.length; i++) {
            for (int j = 0; j < studentAnswers[i].length; j++) {
                int tal = (int) (Math.random() * 4); // tal mellem 0-3
                char c = (char) (tal + 'A');
                studentAnswers[i][j] = c;
            }
        }
    }

    public void printStudentAnswers() {
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print("Student " + (i + 1) + " resultat: ");
            for (int j = 0; j < studentAnswers[i].length; j++) {
                if (j != 0) {
                    System.out.print(", ");
                }
                System.out.print(studentAnswers[i][j]);
            }
            System.out.println();
        }
    }

    public void printCorrectAnswers() {
        System.out.println("De korrekte svar:  " + Arrays.toString(correctAnswer));
    }

    /**
     * Udskriver for hver studerende antallet af rigtige svar
     */
    public void printCorrectAnswersPrStudent() {
        // TODO
    	int[] totalCorrect = new int[3];
    	
    	for (int i = 0; i < studentAnswers.length; i++) {
    		for ( int j = 0 ; j < studentAnswers[0].length; j++){
    			if ( studentAnswers[i][j] == correctAnswer[j]) {
    				totalCorrect[i] += 1;
    			}
    			
    		}
    	}
    	System.out.println("Student 1 has " + totalCorrect[0] + " correct answers");
    	System.out.println("Student 2 has " + totalCorrect[1] + " correct answers");
    	System.out.println("Student 3 has " + totalCorrect[2] + " correct answers");
//    	System.out.println(Arrays.toString(totalCorrect));
    }

    /**
     * Udskriver for hver spørgsmål antallet af rigtige svar
     */
    public void printCorrectAnswerPrQuestion() {
    	int[] totalCorrect = new int[correctAnswer.length];
    	
    	
    	for (int i = 0; i < studentAnswers.length; i++) {
    		for ( int j = 0 ; j < studentAnswers[0].length; j++){
    			if ( studentAnswers[i][j] == correctAnswer[j]) {
    				totalCorrect[j] += 1;
    			}
    			
    		}
    	}
    	System.out.println(Arrays.toString(totalCorrect));
    }

}
