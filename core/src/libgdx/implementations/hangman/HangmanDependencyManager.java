package libgdx.implementations.hangman;

import libgdx.campaign.*;
import libgdx.game.Game;
import libgdx.implementations.geoquiz.QuizGame;
import libgdx.implementations.skelgame.gameservice.QuizStarsService;
import libgdx.resources.IncrementingRes;
import libgdx.utils.EnumUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanDependencyManager extends CampaignGameDependencyManager {

    @Override
    public List<? extends IncrementingRes> getIncrementResList() {
        List<ImageCategIncrementRes> list = new ArrayList<>();
        return list;
    }

    @Override
    protected String allQuestionText() {
        QuestionConfigFileHandler questionConfigFileHandler = new QuestionConfigFileHandler();
        StringBuilder text = new StringBuilder();
        for (QuestionCategory category : (QuestionCategory[]) EnumUtils.getValues(CampaignGame.getInstance().getSubGameDependencyManager().getQuestionCategoryTypeEnum())) {
            for (QuestionDifficulty difficultyLevel : (QuestionDifficulty[]) EnumUtils.getValues(CampaignGame.getInstance().getSubGameDependencyManager().getQuestionDifficultyTypeEnum())) {
                Scanner scanner = new Scanner(questionConfigFileHandler.getFileText(difficultyLevel, category));
                while (scanner.hasNextLine()) {
                    text.append(scanner.nextLine());
                }
                scanner.close();
            }
        }
        return text.toString();
    }

    @Override
    public Class<HangmanSpecificResource> getSpecificResourceTypeEnum() {
        return HangmanSpecificResource.class;
    }

    @Override
    public Class<HangmanCampaignLevelEnum> getCampaignLevelTypeEnum() {
        return HangmanCampaignLevelEnum.class;
    }

    @Override
    public Class<HangmanQuestionCategoryEnum> getQuestionCategoryTypeEnum() {
        return HangmanQuestionCategoryEnum.class;
    }

    @Override
    public Class<HangmanQuestionDifficultyLevel> getQuestionDifficultyTypeEnum() {
        return HangmanQuestionDifficultyLevel.class;
    }

    public QuizStarsService getStarsService() {
        return new QuizStarsService();
    }
}