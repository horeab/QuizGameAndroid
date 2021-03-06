package libgdx.implementations.kennstde;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.I18NBundle;
import libgdx.game.Game;
import libgdx.resources.SpecificResource;

public enum KennstDeSpecificResource implements SpecificResource {

    // @formatter:off

    specific_labels("labels/labels", I18NBundle.class),

    campaign_background_texture("campaign_background_texture.png", Texture.class),

    title_background("title_background.png", Texture.class),
    star("star.png", Texture.class),
    success("success.png", Texture.class),
    ;
    // @formatter:on

    private String path;
    private Class<?> classType;

    KennstDeSpecificResource(String path, Class<?> classType) {
        this.path = path;
        this.classType = classType;
    }

    @Override
    public Class<?> getClassType() {
        return classType;
    }

    @Override
    public String getPath() {
        return Game.getInstance().getAppInfoService().getImplementationGameResourcesFolder() + path;
    }

}
