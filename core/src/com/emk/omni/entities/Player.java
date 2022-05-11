package com.emk.omni.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
    private boolean movingLeft;
    private boolean movingRight;

    private final double speed = 400.0;

    public Player(Vector2 position) {
        super(position);
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    @Override
    public void update() {
        float delta = Gdx.graphics.getDeltaTime();

        System.out.println(delta);

        if (movingLeft) {
            this.move((int) (-speed * delta), 0);
        }
        if (movingRight) {
            this.move((int) (speed * delta), 0);
        }
    }
}
