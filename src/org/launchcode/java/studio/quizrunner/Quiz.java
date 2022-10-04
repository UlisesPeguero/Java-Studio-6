package org.launchcode.java.studio.quizrunner;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    /**
     *  Adds question to the list questions, if the question hasn't been added previously
     *
     * @param question  Question to be added
     */
    public void addQuestion(Question question) {
        if(questions.contains(question)) return;
        questions.add(question);
    }

    /**
     *  Runs the quiz to completion
     */
    public void run() {
        System.out.println("[ QUIZ ]\n");

        int index = 1;
        for(Question question: questions) {
            question.displayQuestion(index++);
            System.out.println("=============================================");
            if(question.validateAnswer()) score++;
        }
    }

    public void printScore() {
        System.out.println("\nScore: " + score + "/" + questions.size());
    }
}
