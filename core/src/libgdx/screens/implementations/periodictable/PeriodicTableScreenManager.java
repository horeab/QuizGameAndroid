package libgdx.screens.implementations.periodictable;

import libgdx.campaign.CampaignLevel;
import libgdx.implementations.periodictable.PeriodicTableCategoryEnum;
import libgdx.implementations.periodictable.PeriodicTableCreatorDependencies;
import libgdx.implementations.periodictable.PeriodicTableDifficultyLevel;
import libgdx.implementations.skelgame.CampaignScreenManager;
import libgdx.implementations.skelgame.gameservice.CreatorDependenciesContainer;
import libgdx.implementations.skelgame.gameservice.GameContext;
import libgdx.implementations.skelgame.gameservice.GameContextService;
import libgdx.implementations.skelgame.question.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PeriodicTableScreenManager extends CampaignScreenManager {

    @Override
    public void showMainScreen() {
//        List<Question> questions = new ArrayList<>();
//        questions.addAll(CreatorDependenciesContainer.getCreator(PeriodicTableCreatorDependencies.class).getQuestionCreator(PeriodicTableDifficultyLevel._0,
//                PeriodicTableCategoryEnum.cat0).getAllQuestions());
//        Collections.shuffle(questions);
//        questions = questions.subList(0, 15);
//        GameContext gameContext = new GameContextService().createGameContext
//                (0, questions.toArray(new Question[questions.size()]));
//        showCampaignGameScreen(gameContext, null);
//        showPeriodicTableScreen();
        showCampaignScreen();
    }

    public void showPeriodicTableScreen() {
        showScreen(PeriodicTableScreenTypeEnum.PERIODICTABLE_SCREEN);
    }

    @Override
    public void showCampaignScreen() {
        showScreen(PeriodicTableScreenTypeEnum.CAMPAIGN_SCREEN);
    }

    @Override
    public void showCampaignGameScreen(GameContext gameContext, CampaignLevel campaignLevel) {
        showScreen(PeriodicTableScreenTypeEnum.CAMPAIGN_GAME_SCREEN, gameContext, campaignLevel);
    }
}
