package com.emk.omni.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.emk.omni.entities.Player;

public class PlayerInputProcessor extends InputAdapter {
    private Player player;

    private boolean movingLeft;
    private boolean movingRight;

    public PlayerInputProcessor(Player player) {
        this.player = player;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(button);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A) {
            this.player.setMovingLeft(true);
        }
        else if (keycode == Input.Keys.D) {
            this.player.setMovingRight(true);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            this.player.setMovingLeft(false);
        }
        else if (keycode == Input.Keys.D) {
            this.player.setMovingRight(false);
        }
        return false;
    }
}
