package com.emk.omni.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Align;
import com.emk.omni.constants.RenderConstants;
import com.emk.omni.entities.Entity;

public class Player extends Entity {
    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    private Texture texture;

    private final float SPEED = 8;

    private boolean holdingLeftButton;

    public final Aim aim;

    public Player(World world, Vector2 position, Aim aim) {
        super(world, position);
        setWidth(1);
        setHeight(1);
        texture = new Texture(Gdx.files.internal("duck.png"));

        this.aim = aim;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public void move() {
        if (movingLeft) {
            body.setLinearVelocity(new Vector2(-SPEED, body.getLinearVelocity().y));
        }
        else if (movingRight) {
            body.setLinearVelocity(new Vector2(SPEED, body.getLinearVelocity().y));
        }
        else {
            body.setLinearVelocity(new Vector2(0, body.getLinearVelocity().y));
        }

        if (movingUp) {
            body.setLinearVelocity(new Vector2(body.getLinearVelocity().x, SPEED));
        }
        else if (movingDown) {
            body.setLinearVelocity(new Vector2(body.getLinearVelocity().x, -SPEED));
        }
        else {
            body.setLinearVelocity(new Vector2(body.getLinearVelocity().x, 0));
        }
        setPosition(body.getPosition().x, body.getPosition().y);

        aim.processMouseMove();
    }

    public void setHoldingLeftButton(boolean holdingLeftButton) {
        this.holdingLeftButton = holdingLeftButton;
    }

    @Override
    public void act(float delta) {
        move();

        if (holdingLeftButton) aim.speedUp(true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(this.texture, this.getX() * RenderConstants.PIXEL_PER_UNIT, this.getY() * RenderConstants.PIXEL_PER_UNIT);
    }
}
