package com.emk.omni.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.emk.omni.constants.RenderConstants;
import com.emk.omni.entities.Entity;

public class EnemyExample extends Entity {
    private Texture texture;

    public EnemyExample(World world, Vector2 position) {
        super(world, position);
        texture = new Texture(Gdx.files.internal("duck.png"));
    }

    @Override
    public void act(float delta) {
        //System.out.println("Updating enemy!");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(this.texture, 0, 0);
    }
}
