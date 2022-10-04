package org.launchcode.java.studio.quizrunner;

import java.util.Scanner;

abstract public class Question<T> {
    private String questionText;
    protected T answerGiven;
    protected T correctAnswer;
    protected Scanner input;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public T getAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(T answerGiven) {
        this.answerGiven = answerGiven;
    }

    /**
     *  Display de question text and calls for the display of the answer format and input expected
     *
     * @param questionIndex Number that was assigned to the question
     */
    public void displayQuestion(int questionIndex) {
        System.out.println(questionIndex + ") " + questionText + "?");
        displayAnswerFormat();
        getAnswerInput();
    }

    /**
     *  Validates if the answerGiven stored in the object is correct
     * @return  True is this.answerGiven is validated as correct
     */
    abstract public boolean validateAnswer();

    /**
     *  Display the answer format
     */
    abstract public void displayAnswerFormat();

    /**
     *  Displays and request input from the user
     */
     abstract public void getAnswerInput();

    /**
     *  Validates if the answer is allowed
     *
     * @param answer    String that we want to validate
     */
    protected boolean isAValidAnswer(String answer) {
        return true;
    }
}
