package libgdx.implementations.skelgame.gameservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import libgdx.campaign.QuestionConfig;
import libgdx.campaign.RandomCategoryAndDifficulty;
import libgdx.implementations.skelgame.question.Question;

public class RandomQuestionCreatorService {

    public Question[] createRandomQuestions(QuestionConfig questionConfig) {
        int questionAmount = questionConfig.getAmountOfQuestions();
        List<String> categsToUse = new ArrayList<>(questionConfig.getQuestionCategoryStringList());
        List<String> alreadyUsedCategs = new ArrayList<>();
        Question[] randomQuestions = new Question[questionAmount];
        for (int i = 0; i < questionAmount; i++) {
            RandomCategoryAndDifficulty randomCategoryAndDifficulty = questionConfig.getRandomCategoryAndDifficulty();
            QuizQuestionCategory randomQuestionCategory = (QuizQuestionCategory) randomCategoryAndDifficulty.getQuestionCategory();
            QuestionCreator questionCreator = CreatorDependenciesContainer.getCreator(randomQuestionCategory.getCreatorDependencies()).getQuestionCreator(randomCategoryAndDifficulty.getQuestionDifficulty(), randomQuestionCategory);
            int repeats = 0;
            Question randomQuestion = questionCreator.createRandomQuestion();
            while (Arrays.asList(randomQuestions).contains(randomQuestion)
                    || !questionCreator.isQuestionValid(randomQuestion)
                    //try to use all question categories
                    || (alreadyUsedCategs.contains(randomQuestion.getQuestionCategory().name()) && !categsToUse.isEmpty())) {
                if (repeats > 100) {
                    break;
                }
                randomQuestion = questionCreator.createRandomQuestion();
                repeats++;
            }
            randomQuestions[i] = randomQuestion;
            String qCategName = randomQuestion.getQuestionCategory().name();
            alreadyUsedCategs.add(qCategName);
            categsToUse.remove(qCategName);
        }
        return randomQuestions;
    }
}
