package com.emk.omni.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.emk.omni.constants.RenderConstants;

public abstract class Entity extends Actor {
    private float life;
    protected BodyDef bodyDef;
    protected Body body;

    protected FixtureDef fixtureDef;
    protected Fixture fixture;

    protected Shape shape;

    public Entity(World world, Vector2 position) {
        createBody(world, position);
        this.body.setTransform(position, 0);
    }

    private Shape createShape() {
        shape = new CircleShape();
        shape.setRadius(0.45f);
        return shape;
    }

    private void createBody(World world, Vector2 position) {
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position);

        body = world.createBody(bodyDef);

        shape = createShape();

        fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0f;
        fixtureDef.friction = 0f;
        fixtureDef.restitution = 0f;

        fixture = body.createFixture(fixtureDef);
    }

    public void damage(float value) {
        this.life -= value;
        this.life = Math.min(this.life, 0);
    }

    /*
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void move(int x, int y) {
        this.position.add(x, y);
    }
     */
}
