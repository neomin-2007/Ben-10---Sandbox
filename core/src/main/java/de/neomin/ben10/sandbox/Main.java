package de.neomin.ben10.sandbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.github.tommyettinger.anim8.AnimatedGif;
import de.neomin.ben10.sandbox.enums.Direction;
import de.neomin.ben10.sandbox.models.Player;
import de.neomin.ben10.sandbox.utils.GifDecoder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;
    private InputListen inputListen;

    private Player player;
    private float elapsed;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");

        inputListen = new InputListen(this);
        Gdx.input.setInputProcessor(inputListen);

        player = new Player();
        player.load();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        elapsed += Gdx.graphics.getDeltaTime();
        batch.begin();

        if (player.isMoving()) {
            player.translate(0);
        }

        batch.draw(image, 140, 210);

        batch.draw(player.getAnimation().get(player.getState())
                .getKeyFrame(elapsed), player.getX(), player.getY(), 102, 102);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
