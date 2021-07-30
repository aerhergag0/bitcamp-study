package org.zerock.quiz;

public class QuizService {

    public QuizDTO makeQuiz(){

//        int n1 = getNum();
//        int n2 = getNum();
//
//        QuizDTO quizDTO = new QuizDTO(n1, n2);
//
//        return quizDTO;

        return new QuizDTO(getNum(),getNum());

    }

    private int getNum() {
        return (int)(Math.random() * 100) + 1;
    }
}
