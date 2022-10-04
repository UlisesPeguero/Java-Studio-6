package org.launchcode.java.studio.quizrunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CheckboxQuestion extends MultipleOptionsQuestion<ArrayList<String>> {

    public CheckboxQuestion(String questionText, ArrayList<String> correctAnswer) {
        this(questionText, new HashMap<>(), correctAnswer);
    }

    public CheckboxQuestion(String questionText, HashMap<String, String> choices, ArrayList<String> correctAnswer) {
        super(questionText, choices, correctAnswer);
        setOptionMarker("[#]");
        answerGiven = new ArrayList<>();
    }

    private void addAnswer(String answer) {
        if(!answerGiven.contains(answer)) {
            answerGiven.add(answer);
        }
    }

    @Override
    public boolean validateAnswer() {
        ArrayList<String> answers = (ArrayList<String>) answerGiven.clone();

        if(answers.size() != getCorrectAnswer().size()) {
            return false;
        }
        for(String correctAnswer: getCorrectAnswer()) {
            answers.remove(correctAnswer);
        }
        return answers.size() == 0;
    }

    @Override
    public void getAnswerInput() {
        input = new Scanner(System.in);
        String answer = null;
        System.out.println("You can enter !q to finalize your selection.");
        while(true) {
            do {
                System.out.print("Select your answers " + getSelectedAnswersString() + " : > ");
                answer = input.nextLine();
                answer = answer.trim().toLowerCase();
                if("!q".equals(answer)) { // <--
                    return;
                }
            } while (!isAValidAnswer(answer));
            addAnswer(answer);
        }
    }

    private String getSelectedAnswersString() {
        return this.answerGiven.toString();
    }
}
