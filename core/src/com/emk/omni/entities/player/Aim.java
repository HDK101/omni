package com.emk.omni.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.emk.omni.constants.RenderConstants;

public class Aim extends Actor {
    private Texture texture;
    private Vector2 playerPosition;
    private Camera cam;

    private final float SPEED = (float)Math.PI * 4;
    private float speedMultiplier = 1;
    private float rotation = 0;

    public Aim(Camera cam) {
        texture = new Texture(Gdx.files.internal("aimbig.png"));
        playerPosition = new Vector2(0, 0);
        this.cam = cam;
    }

    public void act(float delta) {
        speedMultiplier = speedMultiplier >= 0.01f ? speedMultiplier * 0.9f : 0.01f;
        rotation += speedMultiplier;
    }

    public void processMouseMove() {
        Vector3 pos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(pos);
        setPosition(pos.x, pos.y);
    }

    public void speedUp(boolean higher) {
        float localMultipler = higher ? 2f : 1f;
        speedMultiplier = speedMultiplier >= localMultipler ? localMultipler : speedMultiplier * 1.5f;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX() - 16, getY() - 16, 16, 16, 32, 32, 1, 1, rotation * SPEED, 0, 0, 32, 32, false, false);
        batch.draw(texture, getX() - 16, getY() - 16, 16, 16, 32, 32, 1, 1, rotation * SPEED * 0.7f, 0, 0, 32, 32, false, false);
    }
}
