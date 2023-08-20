package com.omer.trivia.dto;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import lombok.Data;

@Data
public class QuestionDto {
    private Category category;
    private final String type = "multiple";
    private Difficulty difficulty;
    private String question;
    private String correct_answer;
    private String[] incorrect_answers;
}

/*"category": "General Knowledge",
        "type": "multiple",
        "difficulty": "easy",
        "question": "Where is the train station &quot;Llanfair&shy;pwllgwyngyll&shy;gogery&shy;chwyrn&shy;drobwll&shy;llan&shy;tysilio&shy;gogo&shy;goch&quot;?",
        "correct_answer": "Wales",
        "incorrect_answers": [
        "Moldova",
        "Czech Republic",
        "Denmark"
        ]
        },*/
