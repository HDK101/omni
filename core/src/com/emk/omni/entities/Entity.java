package com.emk.omni.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    private float life;

    protected Vector2 position;
    protected Texture texture;

    public Entity(Vector2 position) {
        this.position = position;
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    public void damage(float value) {
        this.life -= value;
        this.life = Math.min(this.life, 0);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void move(int x, int y) {
        this.position.add(x, y);
    }

    public abstract void update();

    public void render(SpriteBatch batch) {
        batch.draw(this.texture, this.position.x, this.position.y);
    }
}
