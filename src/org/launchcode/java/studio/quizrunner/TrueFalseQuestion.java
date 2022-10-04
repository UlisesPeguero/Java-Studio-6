package org.launchcode.java.studio.quizrunner;

import java.util.HashMap;

public class TrueFalseQuestion extends MultipleOptionsQuestion<String>{
    public TrueFalseQuestion(String questionText, String correctAnswer) {
        super(questionText, correctAnswer);
        addAnswerChoice("T", "True");
        addAnswerChoice("F", "False");
        setOptionMarker("#");
    }

    @Override
    public boolean validateAnswer() {
        return getCorrectAnswer().toLowerCase().equals(getAnswerGiven().toLowerCase());
    }
}
