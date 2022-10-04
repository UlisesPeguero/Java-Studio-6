package org.launchcode.java.studio.quizrunner;

public class CharacterLimitedQuestion extends Question<String>{
    private int maxLengthAllowed;

    public CharacterLimitedQuestion(String questionText, int maxLengthAllowed) {
        super(questionText);
        this.maxLengthAllowed = maxLengthAllowed;
    }

    public void setMaxLengthAllowed(int maxLengthAllowed) {
        this.maxLengthAllowed = maxLengthAllowed;
    }

    public int getMaxLengthAllowed() {
        return maxLengthAllowed;
    }

    @Override
    public boolean validateAnswer() {
        return false;
    }

    @Override
    public void displayAnswerFormat() {

    }

    @Override
    public void getAnswerInput() {

    }

}
