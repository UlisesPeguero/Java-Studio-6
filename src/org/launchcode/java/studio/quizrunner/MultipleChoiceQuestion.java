package org.launchcode.java.studio.quizrunner;

import java.util.HashMap;

public class MultipleChoiceQuestion extends MultipleOptionsQuestion<String>{

    public MultipleChoiceQuestion(String questionText, String correctAnswer) {
        this(questionText, new HashMap<>(), correctAnswer);
    }

    public MultipleChoiceQuestion(String questionText, HashMap<String, String> choices, String correctAnswer) {
        super(questionText, choices, correctAnswer);
        setOptionMarker("(#)");
        setInputPrompt("Select one answer");
    }
}
