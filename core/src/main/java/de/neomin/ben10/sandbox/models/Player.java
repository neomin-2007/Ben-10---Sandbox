package de.neomin.ben10.sandbox.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import de.neomin.ben10.sandbox.enums.AlienType;
import de.neomin.ben10.sandbox.enums.Direction;
import de.neomin.ben10.sandbox.utils.GifDecoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
@NoArgsConstructor
public class Player {

    private float x = 20.0f;
    private float y = 20.0f;
    private boolean moving = false;

    private AlienType selectedAlien;

    private String state;
    private Direction direction;
    private HashMap<String, Animation<TextureRegion>> animation;

    public void load() {

        selectedAlien = AlienType.XLR8;

        state = selectedAlien.getPath() + "_idle_right";
        direction = Direction.RIGHT;

        animation = new HashMap<>();

        for (AlienType alien : AlienType.values()) {
            animation.put(alien.getPath() + "_idle_right", GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
                Gdx.files.internal(alien.getPath() + "/idle_right.gif")
                    .read()));

            animation.put(alien.getPath() + "_idle_left", GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
                Gdx.files.internal(alien.getPath() + "/idle_left.gif")
                    .read()));

            animation.put(alien.getPath() + "_run_right", GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
                Gdx.files.internal(alien.getPath() + "/run_right.gif")
                    .read()));

            animation.put(alien.getPath() + "_run_left", GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP,
                Gdx.files.internal(alien.getPath() + "/run_left.gif")
                    .read()));
        }
    }

    public void update() {
        if (isMoving()) {
            if (direction == Direction.RIGHT) {
                changeState(selectedAlien.getPath() + "_run_right");
            } else if (direction == Direction.LEFT) {
                changeState(selectedAlien.getPath() + "_run_left");
            }
        } else {
            if (direction == Direction.RIGHT) {
                changeState(selectedAlien.getPath() + "_idle_right");
            } else if (direction == Direction.LEFT) {
                changeState(selectedAlien.getPath() + "_idle_left");
            }
        }
    }

    public void changeState(String state) {
        this.state = state;
    }

    public void translate(float amount) {
        amount += selectedAlien.getSpeed();

        switch (direction) {
            case RIGHT:
                x += amount;
                break;
            case LEFT:
                amount = (amount - (amount * 2));
                x += amount;
                break;
        }
    }
}
