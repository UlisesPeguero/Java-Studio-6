package org.launchcode.java.studio.quizrunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleOptionsQuestion<T> extends Question<T>{
    private HashMap<String, String> choices;
    private String optionMarker = "#";
    private String inputPrompt = "Answer";

    public MultipleOptionsQuestion(String questionText, T correctAnswer) {
        this(questionText, new HashMap<>(), correctAnswer);
    }

    public MultipleOptionsQuestion(String questionText, HashMap<String, String> choices, T correctAnswer) {
        super(questionText);
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    protected void setInputPrompt(String prompt) {
        this.inputPrompt = prompt;
    }

    protected String getInputPrompt() {
        return this.inputPrompt;
    }
    protected void setOptionMarker(String marker) {
        this.optionMarker = marker;
    }

    protected String getOptionMarker() {
        return this.optionMarker;
    }

    protected void setCorrectAnswer(T correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    protected T getCorrectAnswer() {
        return this.correctAnswer;
    }

    public boolean addAnswerChoice(String identifier, String text) {
        if(getAnswerChoice(identifier) != null) {
            return false;
        }
        choices.put(identifier, text);
        return true;
    }

    public String removeAnswerChoice(String identifier) {
        return this.choices.remove(identifier);
    }

    public boolean updateAnswerChoice(String identifier, String text) {
        return this.choices.put(identifier, text) != null;
    }

    String getAnswerChoice(String identifier) {
        return this.choices.get(identifier);
    }


    @Override
    public boolean validateAnswer() {
        return correctAnswer.equals(getAnswerGiven());
    }

    @Override
    public void displayAnswerFormat() {
        for(Map.Entry<String, String> choice: this.choices.entrySet()) {
            System.out.println(optionMarker.replace("#", choice.getKey()) + " : " + choice.getValue());
        }
    }

    @Override
    public void getAnswerInput() {
        input = new Scanner(System.in);
        String answer = null;
        do {
            System.out.print(inputPrompt + ": > ");
            answer = input.nextLine();
            answer = answer.trim().toLowerCase();
        } while(!isAValidAnswer(answer));
        setAnswerGiven((T)answer);
    }

    @Override
    protected boolean isAValidAnswer(String answer) {
        for(String key: this.choices.keySet()) {
            if(key.toLowerCase().equals(answer.trim().toLowerCase())) return true;
        }
        return false;
    }
}
