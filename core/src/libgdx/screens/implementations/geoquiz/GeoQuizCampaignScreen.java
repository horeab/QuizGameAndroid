package libgdx.screens.implementations.geoquiz;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;

import libgdx.campaign.*;
import libgdx.controls.animations.ActorAnimation;
import libgdx.controls.button.MyButton;
import libgdx.controls.button.builders.BackButtonBuilder;
import libgdx.controls.button.builders.ButtonWithIconBuilder;
import libgdx.controls.label.MyWrappedLabel;
import libgdx.controls.label.MyWrappedLabelConfigBuilder;
import libgdx.game.Game;
import libgdx.graphics.GraphicUtils;
import libgdx.implementations.geoquiz.*;
import libgdx.implementations.skelgame.*;
import libgdx.implementations.skelgame.gameservice.GameContextService;
import libgdx.implementations.skelgame.gameservice.QuizStarsService;
import libgdx.resources.FontManager;
import libgdx.resources.MainResource;
import libgdx.resources.Res;
import libgdx.resources.dimen.MainDimen;
import libgdx.screen.AbstractScreen;
import libgdx.utils.ScreenDimensionsManager;
import libgdx.utils.Utils;
import libgdx.utils.model.FontColor;

import java.util.List;

public class GeoQuizCampaignScreen extends AbstractScreen<QuizScreenManager> {

    private CampaignService campaignService = new CampaignService();
    private List<CampaignStoreLevel> allCampaignLevelStores;
    private int TOTAL_STARS = 5;
    public static int TOTAL_QUESTIONS = 5;
    private float ICON_DIMEN = MainDimen.horizontal_general_margin.getDimen() * 7.5f;

    public GeoQuizCampaignScreen() {
        if (Game.getInstance().isFirstTimeMainMenuDisplayed()) {
            new SkelGameRatingService(this).appLaunched();
        }
        allCampaignLevelStores = campaignService.processAndGetAllLevels();
    }

    @Override
    public void buildStage() {
        Table table = new Table();
        table.setFillParent(true);
        table.add(createAllTable());
        addActor(table);
        new BackButtonBuilder().addHoverBackButton(this);
        Game.getInstance().setFirstTimeMainMenuDisplayed(false);
    }

    private Table createAllTable() {
        Table table = new Table();
        float verticalGeneralMarginDimen = MainDimen.vertical_general_margin.getDimen();
        MyWrappedLabel titleLabel = new MyWrappedLabel(new MyWrappedLabelConfigBuilder()
                .setTextColor(FontColor.BLACK)
                .setFontScale(FontManager.calculateMultiplierStandardFontSize(1.7f))
                .setText(Game.getInstance().getAppInfoService().getAppName()).build());
        titleLabel.setBackground(GraphicUtils.getNinePatch(QuizGameSpecificResource.title_backgr));
        float titlePadTop = Gdx.app.getType() == Application.ApplicationType.iOS ? verticalGeneralMarginDimen * 4 : verticalGeneralMarginDimen * 2;
        table.add(titleLabel)
                .width(ScreenDimensionsManager.getScreenWidthValue(90))
                .height(ScreenDimensionsManager.getScreenHeightValue(15))
                .padTop(titlePadTop)
                .padBottom(verticalGeneralMarginDimen * 4).row();
        for (QuizQuestionDifficultyLevel difficultyLevel : QuizQuestionDifficultyLevel.values()) {
            table.add(createCategoriesTable(difficultyLevel)).padBottom(verticalGeneralMarginDimen * 2);
            table.row();
        }
        return table;
    }

    private Table createCategoriesTable(QuizQuestionDifficultyLevel difficultyLevel) {
        Table table = new Table();
        table.setBackground(GraphicUtils.getNinePatch(MainResource.popup_background));

        float horizontalGeneralMarginDimen = MainDimen.horizontal_general_margin.getDimen();
        for (QuizQuestionCategoryEnum categoryEnum : QuizQuestionCategoryEnum.values()) {
            Table categoryTable = createCategoryTable(difficultyLevel, categoryEnum);
            table.add(categoryTable).pad(horizontalGeneralMarginDimen).height(categoryTable.getHeight()).width(categoryTable.getWidth());
        }
        return table;
    }

    private Table createCategoryTable(QuizQuestionDifficultyLevel difficultyLevel, QuizQuestionCategoryEnum categoryEnum) {
        CampaignLevel campaignLevel = CampaignLevelEnumService.getCampaignLevelForDiffAndCat(difficultyLevel, categoryEnum);
        Table allTable = new Table();
        Res levelIcon = new CampaignLevelEnumService(campaignLevel).getIcon();
        CampaignStoreLevel maxFinishedLevel = campaignService.getMaxFinishedLevel(allCampaignLevelStores);
        int maxOpenedLevel = maxFinishedLevel != null ? maxFinishedLevel.getLevel() : -1;
        boolean levelLocked = (maxOpenedLevel + 1) < campaignLevel.getIndex();
        if (levelLocked) {
            levelIcon = MainResource.lock;
        } else if (campaignLevel.getIndex() <= maxOpenedLevel) {
            int starsWon = campaignService.getCampaignLevel(campaignLevel.getIndex(), allCampaignLevelStores).getStarsWon();
            if (starsWon == QuizStarsService.NR_OF_STARS_TO_DISPLAY) {
                allTable.setBackground(GraphicUtils.getNinePatch(QuizGameSpecificResource.green_backr));
            } else {
                allTable.setBackground(GraphicUtils.getNinePatch(QuizGameSpecificResource.red_backr));
            }
        }
        MyButton myButton = new ButtonWithIconBuilder("", levelIcon).build();
        if (!levelLocked) {
            ChangeListener listener = getStartLevelListener(this, campaignLevel);
            myButton.addListener(listener);
        } else {
            myButton.setTouchable(Touchable.disabled);
        }
        if ((maxOpenedLevel + 1) == campaignLevel.getIndex()) {
            myButton.setTransform(true);
            new ActorAnimation(myButton, this).animateZoomInZoomOut(0.5f);
        }
        myButton.setHeight(ICON_DIMEN);
        myButton.setWidth(ICON_DIMEN);
        myButton.setOrigin(Align.center);
        allTable.add(myButton).padRight(-MainDimen.horizontal_general_margin.getDimen()).height(myButton.getHeight()).width(myButton.getWidth());
        allTable.setHeight(myButton.getHeight());
        allTable.setWidth(myButton.getWidth());
        return allTable;
    }

    public static ChangeListener getStartLevelListener(final AbstractScreen screen, final CampaignLevel campaignLevel) {
        ChangeListener listener = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                QuizGame.getInstance().getScreenManager().showCampaignGameScreen(new GameContextService().createGameContext(new CampaignLevelEnumService(campaignLevel).getQuestionConfig(GeoQuizCampaignScreen.TOTAL_QUESTIONS)), campaignLevel);
            }
        };
        if (!Game.getInstance().getAppInfoService().isProVersion() && campaignLevel.getIndex() >= QuizCampaignLevelEnum.values().length / 2) {
            listener = new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    new QuizProVersionPopup(screen).addToPopupManager();
                }
            };
        }
        return listener;
    }

    private Table createTotalStarsTable() {
        Table table = new Table();
        float imgSideDim = MainDimen.vertical_general_margin.getDimen() * 4f;
        MyWrappedLabel myLabel = new MyWrappedLabel(campaignService.getTotalWonStars(allCampaignLevelStores) + "/" + TOTAL_STARS);
        myLabel.setFontScale(FontManager.getBigFontDim());
        myLabel.padTop(MainDimen.vertical_general_margin.getDimen() / 2);
        myLabel.padRight(MainDimen.vertical_general_margin.getDimen());
        table.add(myLabel);
        return table;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Utils.createChangeLangPopup();
    }

    @Override
    public void onBackKeyPress() {
        Gdx.app.exit();
    }

}