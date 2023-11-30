package MINI_EPIC;

import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

import EPIC.TextWriter;
import EPICsaved.UIHelper;


public class MyFrame implements ActionListener{
	
	
	
	
	int score = 0;
	StatsForMaths getStats = new StatsForMaths();
	LoginToQuiz username = new LoginToQuiz();
	String username1 = username.LoginToQuiz();
	TextReader reader = new TextReader();
	UIHelper UIHelper = new UIHelper();
	NoviceQuestionBank novice = new NoviceQuestionBank();
	IntermediateQuestionBank inter = new IntermediateQuestionBank();
	ExpertQuestionBank expert = new ExpertQuestionBank();
	
	TextWriter scoreWriter = new TextWriter(username1, score);
	

	int seconds = 20;
	char guess; 
	char answer;
	
	private int noviceIndex = 0;
    private int interIndex = 0;
    private int expertIndex = 0;
	
	int index;
	int correctGuesses =0 ;
	int result;	
	
	JFrame button;
	

JFrame frame = new JFrame();

JTextArea textfield = new JTextArea();
JTextArea textarea = new JTextArea();
JTextField resultsText = new JTextField();

JButton buttonA = new JButton();
JButton buttonB = new JButton();
JButton buttonC = new JButton();
JButton buttonD = new JButton();

JLabel answerLabelA = new JLabel();
JLabel answerLabelB = new JLabel();
JLabel answerLabelC = new JLabel();
JLabel answerLabelD = new JLabel();
JLabel TimeLabel = new JLabel();
JLabel SecondsLeft = new JLabel();
JTextField numberRight = new JTextField();
JTextField percentage = new JTextField();

Timer timer = new Timer(1000, new ActionListener() { //1 second pause
	
	@Override
	public void actionPerformed(ActionEvent e) {
		seconds--;
		SecondsLeft.setText(String.valueOf(seconds));
		if(seconds <= 0) {
			displayAnswer();
			}
		}
	});


public MyFrame(){
	
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
frame.setSize(850,650);
frame.getContentPane().setBackground(new Color(0, 100, 50));
frame.setLayout(null);
frame.setResizable(false);

textfield.setBounds(0,0,850,100);
textfield.setBackground(new Color(30,30,30));
textfield.setForeground(new Color(255,255,255)); //rgb values
textfield.setFont(new Font("Ink Free", Font.BOLD, 15)); // change font
textfield.setBorder(BorderFactory.createBevelBorder(1)); //border 
textfield.setEditable(false);


buttonA.setBounds(0,100,100,100);
buttonA.setFont(new Font("arial", Font.BOLD, 35));
buttonA.setFocusable(false);
buttonA.addActionListener(this);
buttonA.setText("A");

buttonB.setBounds(0,200,100,100);
buttonB.setFont(new Font("arial", Font.BOLD, 35));
buttonB.setFocusable(false);
buttonB.addActionListener(this);
buttonB.setText("B");


buttonC.setBounds(0,300,100,100);
buttonC.setFont(new Font("arial", Font.BOLD, 35));
buttonC.setFocusable(false);
buttonC.addActionListener(this);
buttonC.setText("C");


buttonD.setBounds(0,400,100,100);
buttonD.setFont(new Font("arial", Font.BOLD, 35));
buttonD.setFocusable(false);
buttonD.addActionListener(this);
buttonD.setText("D");

answerLabelA.setBounds(125,100,800,100);
answerLabelA.setBackground(new Color(50, 50, 50));
answerLabelA.setForeground(new Color(25, 255, 0));
answerLabelA.setFont(new Font("arial", Font.PLAIN,15));

answerLabelB.setBounds(125,200,800,100);
answerLabelB.setBackground(new Color(50, 50, 50));
answerLabelB.setForeground(new Color(25, 255, 0));
answerLabelB.setFont(new Font("arial", Font.PLAIN,15));

answerLabelC.setBounds(125,300,800,100);
answerLabelC.setBackground(new Color(50, 50, 50));
answerLabelC.setForeground(new Color(25, 255, 0));
answerLabelC.setFont(new Font("arial", Font.PLAIN,15));

answerLabelD.setBounds(125,400,800,100);
answerLabelD.setBackground(new Color(50, 50, 50));
answerLabelD.setForeground(new Color(25, 255, 0));
answerLabelD.setFont(new Font("arial", Font.PLAIN,15));

SecondsLeft.setBounds(545,510,100,100);
SecondsLeft.setBackground(new Color(25, 25, 25));
SecondsLeft.setForeground(new Color(255,160,255));
SecondsLeft.setFont(new Font("arial" , Font.BOLD, 60));
SecondsLeft.setBorder(BorderFactory.createBevelBorder(1));
SecondsLeft.setOpaque(true);
SecondsLeft.setHorizontalAlignment(JTextField.CENTER);
SecondsLeft.setText(String.valueOf(seconds));

TimeLabel.setBounds(535, 475, 100, 25);
TimeLabel.setBackground(new Color(50,50,50));
TimeLabel.setForeground(new Color(255, 0, 0));
TimeLabel.setFont(new Font("arial", Font.PLAIN,20));
TimeLabel.setHorizontalAlignment(JTextField.CENTER);
TimeLabel.setText("timer");

numberRight.setBounds(225,225,200,100);
numberRight.setBackground(new Color(30,35,60));
numberRight.setForeground(new Color(25,135,0));
numberRight.setFont(new Font("arial" , Font.BOLD, 50));
numberRight.setBorder(BorderFactory.createBevelBorder(1));
numberRight.setHorizontalAlignment(JTextField.CENTER);
numberRight.setEditable(false);

percentage.setBounds(225, 325, 200, 100);
percentage.setBackground(new Color(30,35,25));
percentage.setForeground(new Color(25,135,0));
percentage.setFont(new Font("arial" , Font.BOLD, 50));
percentage.setBorder(BorderFactory.createBevelBorder(1));
percentage.setHorizontalAlignment(JTextField.CENTER);
percentage.setEditable(false);



frame.add(TimeLabel);
frame.add(SecondsLeft);
frame.add(answerLabelA);
frame.add(answerLabelB);
frame.add(answerLabelC);
frame.add(answerLabelD);

frame.add(buttonA);
frame.add(buttonB);
frame.add(buttonC);
frame.add(buttonD);


frame.add(textfield);
frame.add(textarea);

frame.setVisible(true);

displayNoviceQuestions();


}
		private void displayNoviceQuestions() {
			if (noviceIndex < 2) {
				index = new Random().nextInt(novice.NoviceQuestions.length);
				
				nextNoviceQuestion();
				noviceIndex++;
			
			} else {
				displayInterQuestions();
			}
		}
		
		
		
		private void displayInterQuestions() {
			if (interIndex < 2) {
	            index = new Random().nextInt(inter.InterQuestions.length);
	            nextInterQuestion();
	            interIndex++;
	     } else {
	            displayExpertQuestions();
	     }
	   
			}
		
		
	private void displayExpertQuestions() {
			
		 if (expertIndex < 2) {
	            index = new Random().nextInt(expert.ExpertQuestions.length);
	            nextExpertQuestion();
	            expertIndex++;
		 }else {
			 
		 results();
	 			}
		 	}
	    
		
		
		
		public void nextNoviceQuestion() {
		//for (int index=0; index<1; index++) {
			//if (noviceIndex < NoviceQuestions.length) {
			textfield.setText("Question " +(noviceIndex + 1));
			textfield.setText(novice.NoviceQuestions[noviceIndex]);
			answerLabelA.setText(novice.NoviceOptions[noviceIndex][0]);
			answerLabelB.setText(novice.NoviceOptions[noviceIndex][1]);
			answerLabelC.setText(novice.NoviceOptions[noviceIndex][2]);
			answerLabelD.setText(novice.NoviceOptions[noviceIndex][3]);
			timer.start();
	
}		
		public void nextInterQuestion() {
			//if (interIndex < InterQuestions.length) {
				textfield.setText("Question " +(interIndex + 1));
				textfield.setText(inter.InterQuestions[interIndex]);
				answerLabelA.setText(inter.InterOptions[interIndex][0]);
				answerLabelB.setText(inter.InterOptions[interIndex][1]);
				answerLabelC.setText(inter.InterOptions[interIndex][2]);
				answerLabelD.setText(inter.InterOptions[interIndex][3]);
				timer.start();	

}	
		public void nextExpertQuestion() {

				textfield.setText("Question " +(expertIndex + 1));
				textfield.setText(expert.ExpertQuestions[expertIndex]);
				answerLabelA.setText(expert.ExpertOptions[expertIndex][0]);
				answerLabelB.setText(expert.ExpertOptions[expertIndex][1]);
				answerLabelC.setText(expert.ExpertOptions[expertIndex][2]);
				answerLabelD.setText(expert.ExpertOptions[expertIndex][3]);
	
	 }
		
		
		@Override

		public void actionPerformed	(ActionEvent e) {
	
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);		
			
			
		if(e.getSource() == buttonA) {
		checkAnswer('A');
		 } else if (e.getSource() == buttonB) {
		        checkAnswer('B');
		    } else if (e.getSource() == buttonC) {
		        checkAnswer('C');
		    } else if (e.getSource() == buttonD) {
		        checkAnswer('D');
		    }
		}
		
public void checkAnswer(char selectedAnswer ) {
	
	char correctAnswer;
	 if (index < novice.NoviceAnswers.length) {
	        correctAnswer = novice.NoviceAnswers[index];
	    } else if (index < novice.NoviceAnswers.length + inter.InterAnswers.length) {
	        correctAnswer = inter.InterAnswers[index - novice.NoviceAnswers.length];
	    } else {
	        correctAnswer = expert.ExpertAnswers[index - novice.NoviceAnswers.length - inter.InterAnswers.length];
	    }

	    if (selectedAnswer == correctAnswer) {
	        score++;
	    } else {
	    }

	    displayAnswer();
			
		}
	
public void displayAnswer() {
	
	timer.stop();

	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);	

if(novice.NoviceAnswers[index] != 'A' || inter.InterAnswers[index] != 'A' || expert.ExpertAnswers[index] != 'A')
	answerLabelA.setForeground(new Color(255,0,0));
else 
	answerLabelA.setForeground(new Color(55,255,0));

	
if(novice.NoviceAnswers[index] != 'B' || inter.InterAnswers[index] != 'B' || expert.ExpertAnswers[index] != 'B')
	answerLabelB.setForeground(new Color(255,0,0));
else
	answerLabelB.setForeground(new Color(55,255,0));

if(novice.NoviceAnswers[index] != 'C' || inter.InterAnswers[index] != 'C' || expert.ExpertAnswers[index] != 'C')
	answerLabelC.setForeground(new Color(255,0,0));
else
	answerLabelC.setForeground(new Color(55,255,0));

if(novice.NoviceAnswers[index] != 'D' || inter.InterAnswers[index] != 'D' || expert.ExpertAnswers[index] != 'D')
	answerLabelD.setForeground(new Color(255,0,0));
else
	answerLabelD.setForeground(new Color(55,255,0));

	

Timer pause = new Timer(2000, new ActionListener() { //2 second pause
	

@Override
public void actionPerformed	(ActionEvent e) {

	answerLabelA.setForeground(new Color(25,255,0));
	answerLabelB.setForeground(new Color(25,255,0));
	answerLabelC.setForeground(new Color(25,255,0));
	answerLabelD.setForeground(new Color(25,255,0));

	answer = ' ';
	seconds = 20;
	SecondsLeft.setText(String.valueOf(seconds));
	buttonA.setEnabled(true);
	buttonB.setEnabled(true);
	buttonC.setEnabled(true);
	buttonD.setEnabled(true);
	
	if (index < novice.NoviceAnswers.length) {
		displayNoviceQuestions();
		
	} else if (index < novice.NoviceAnswers.length + inter.InterAnswers.length) {
		displayInterQuestions();
	} else {
		displayExpertQuestions();
	}

}
});


pause.setRepeats(false);
pause.start();
}


public void results() {
	
	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	
	resultsText.setBounds(325,325,500,500);
	resultsText.setBackground(new Color(30,30,30));
	resultsText.setForeground(new Color(40,20,100)); //rgb values
	resultsText.setFont(new Font("Ink Free", Font.PLAIN, 30)); // change font
	resultsText.setBorder(BorderFactory.createBevelBorder(1)); //border 
	resultsText.setHorizontalAlignment(JTextField.CENTER);
	resultsText.setEditable(false);
	resultsText.setText(getStats.Statistics(username1));
	
	
	

	}
	

}
