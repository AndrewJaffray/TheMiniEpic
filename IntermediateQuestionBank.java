package MINI_EPIC;

import java.util.Random;
import java.util.Scanner;

public class IntermediateQuestionBank {
	private int score;
	private String rightAnswer;
	
	public static void invalidInput() {
		System.out.printf("Invalid input please try again.\n"
				+ "Enter answer:\n");
	}
	
	
public static final String[] InterQuestions = {
		"CATEGORY: Discrete Mathmatics \n"
				+ "What are the domain and codomain of a function?\n"
				+ "\n" 
				+ "A. The domain is the set of all possible inputs, and the codomain is the set of all possible outputs\n" 
				+ "B. The domain is the set of all possible outputs, and the codomain is the set of all possible inputs\n" 
				+ "C. The domain is the set of all possible inputs, and the codomain is a single output value\n" 
				+ "D. The domain and codomain of a function are the same set\n"
				+ "Enter answer:\n", 
				
		"CATEGORY: Discrete Mathmatics\n"
				+ "In a Knights and Knaves scenario. A and B. A says,  \"We are the same kind.\"B says \"We are different kinds.\"\n"
				+ "Based on A and B's statements, What can you conclude about A and B?\n"
				+ "\n" 
				+ "A. A is a Knight, and B is a Knight.\n"
				+ "B. A is a Knight, and B is a Knave.\n" 
				+ "C. A is a Knave, and B is a Knave.\n" 
				+ "D. A is a Knave, and B is a Knight.\n"
				+ "Enter answer:\n",
				
		"CATEGORY: Computer Science\n"
				+ "What does the term \"object-oriented programming\" (OOP) refer to in computer science? \n"
				+ "\n" 
				+ "A. A coding style that focuses on optimizing program execution speed\n" 
				+ "B. A programming paradigm that uses objects to model real-world entities and their interactions\n" 
				+ "C. A method for designing computer hardware\n" 
				+ "D. A language used for low-level system programming\n"
				+ "Enter answer:\n",
				
		"CATEGORY: Computer Science\n"
				+ "Which one of these represents De Morgan's law:\n"
				+ "\n" 
				+ "A. ¬(X ∧ Y) ≡ (¬X ∨ ¬Y)\n" 
				+ "B. ¬(X ∧ Y) ≡ (¬X ≡ ¬Y)\n" 
				+ "C. (X ∧ Y) ∨ (X ∨ Y)\n" 
				+ "D. ¬(X ∧ Y) ≡ ¬(¬X ∨ ¬Y)\n"
				+ "Enter answer:\n",
				
		"CATEGORY: Computer Organisation \n"
				+ "What is the function of a level 0 in a multilevel machine?	\n"
				+ "\n" 
				+ "A. Implements interpreters and translators\n" 
				+ "B. Binary inputs used to create memory or execute instructions\n" 
				+ "C. Fetch, Decode, Execute cycle\n" 
				+ "D. Provides power to the computer\n"
				+ "Enter answer:\n",		
				
		"CATEGORY: Computer Organisation \n"
				+ "What is the purpose of the Arithmetic Logic Unit (ALU) in a CPU?\n"
				+ "\n" 
				+ "A. To perform arithmetic and logical operations\n" 
				+ "B. To store program instructions\n" 
				+ "C. To manage memory allocation\n" 
				+ "D. To control input/output devices\n"
				+ "Enter answer:\n"
				
};
				
public static final String[] InterAnswers = {						
	
"a", "d", "b", "a", "b", "a"              
};

public IntermediateQuestionBank(int score) {
	
	
Random random = new Random();
int[] usedQuestions = new int[InterQuestions.length];
int maximum = InterQuestions.length;


System.out.printf("|-----------------------------|\n" 
		+ "|ROUND TWO LEVEL: INTERMEDIATE|\n"
		+ "|-----------------------------|\n");

for (int i = 1; i <= 2; i++) {
	System.out.printf("Question %d\n", i);
	
	int questionNumber;
    do {
        questionNumber = random.nextInt(maximum);
    } while (usedQuestions[questionNumber] != 0); // Ensure question hasn't been asked before

    usedQuestions[questionNumber] = 1; // Mark question as asked
    score = askQuestion(score, InterQuestions[questionNumber], InterAnswers[questionNumber]);
    
			}	
this.score = score;
		}
public int RoundTwoScore() {
    return score;
	}


private static int askQuestion(int score, String question, String correctAnswer) {
    System.out.println(question);
    
    for (int i=0; i<1; i++) {
		Scanner answer = new Scanner(System.in);
		String input = answer.nextLine();
		input = input.toLowerCase();
		if (input.equals("a")||input.equals("b")||input.equals("c")||input.equals("d")) {
			if (input.equals(correctAnswer)) {
				score++;
			}
			}else { invalidInput();
					i--;}
		}
    return score;

	}
}

