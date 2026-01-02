package de.neomin.ben10.sandbox;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import de.neomin.ben10.sandbox.enums.Direction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputListen
implements InputProcessor {

    private final Main main;

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.D:
                main.getPlayer().setDirection(Direction.RIGHT);
                main.getPlayer().setMoving(true);
                main.getPlayer().translate(0.0f);
                main.getPlayer().update();
                return true;
            case Input.Keys.A:
                main.getPlayer().setDirection(Direction.LEFT);
                main.getPlayer().setMoving(true);
                main.getPlayer().translate(0.0f);
                main.getPlayer().update();
                return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        main.getPlayer().setMoving(false);
        main.getPlayer().update();
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
