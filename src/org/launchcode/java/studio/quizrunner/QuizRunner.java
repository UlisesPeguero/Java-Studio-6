package org.launchcode.java.studio.quizrunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuizRunner {

    public static void main(String []args) {

        Quiz quiz = new Quiz();

        MultipleChoiceQuestion mcQuestion = new MultipleChoiceQuestion("This is a multiple choice question with one correct answer (b)", "b");
        mcQuestion.addAnswerChoice("a", "Multiple choice a");
        mcQuestion.addAnswerChoice("b", "Multiple choice b");
        mcQuestion.addAnswerChoice("c", "Multiple choice c");

        TrueFalseQuestion tfQuestion = new TrueFalseQuestion("This ia true or false question the answer is T", "T");

        CheckboxQuestion cbQuestion = new CheckboxQuestion("This is a checkbox question with correct answers of [a,c]", new ArrayList<String>(Arrays.asList("a", "c")));
        cbQuestion.addAnswerChoice("a", "Nonsense answer a");
        cbQuestion.addAnswerChoice("b", "Nonsense answer b");
        cbQuestion.addAnswerChoice("c", "Nonsense answer c");

        quiz.addQuestion(mcQuestion);
        quiz.addQuestion(tfQuestion);
        quiz.addQuestion(cbQuestion);

        quiz.run();
        quiz.printScore();

    }
}
