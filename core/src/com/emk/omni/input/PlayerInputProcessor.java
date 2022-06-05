package com.emk.omni.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.emk.omni.entities.player.Aim;
import com.emk.omni.entities.player.Player;

public class PlayerInputProcessor extends InputAdapter {
    private Player player;

    public PlayerInputProcessor(Player player) {
        this.player = player;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        player.setHoldingLeftButton(true);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        player.setHoldingLeftButton(false);
        return true;
    }


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            this.player.setMovingLeft(true);
        }
        else if (keycode == Input.Keys.D) {
            this.player.setMovingRight(true);
        }
        if (keycode == Input.Keys.W) {
            this.player.setMovingUp(true);
        }
        else if (keycode == Input.Keys.S) {
            this.player.setMovingDown(true);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            this.player.setMovingLeft(false);
        }
        else if (keycode == Input.Keys.D) {
            this.player.setMovingRight(false);
        }
        if (keycode == Input.Keys.W) {
            this.player.setMovingUp(false);
        }
        else if (keycode == Input.Keys.S) {
            this.player.setMovingDown(false);
        }
        return true;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        player.aim.processMouseMove();
        player.aim.speedUp(false);
        return true;
    }
}
