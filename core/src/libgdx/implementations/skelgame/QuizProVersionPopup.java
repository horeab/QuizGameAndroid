package libgdx.implementations.skelgame;

import libgdx.controls.popup.ProVersionPopup;
import libgdx.game.Game;
import libgdx.graphics.GraphicUtils;
import libgdx.resources.MainResource;
import libgdx.resources.dimen.MainDimen;
import libgdx.resources.gamelabel.MainGameLabel;
import libgdx.screen.AbstractScreen;

public class QuizProVersionPopup extends ProVersionPopup {

    public QuizProVersionPopup(AbstractScreen abstractScreen) {
        super(abstractScreen);
    }

    @Override
    protected String getLabelText() {
        return MainGameLabel.pro_version_info.getText(Game.getInstance().getAppInfoService().getAppName()) + "\n+" +
                MainGameLabel.pro_version_info_unlock.getText(Game.getInstance().getAppInfoService().getAppName());
    }

    @Override
    public void hide() {
        super.hide();
        Game.getInstance().getScreenManager().showMainScreen();
    }
}
