package com.emk.omni;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.emk.omni.entities.Player;
import com.emk.omni.input.PlayerInputProcessor;


public class OmniGame extends ApplicationAdapter {
    public SpriteBatch batch;
    public OrthographicCamera cam;
    public Texture texture;
    public Player player;

    @Override
    public void create() {
        cam = new OrthographicCamera();
        cam.position.set(10f, 10f, 10f);
        cam.update();

        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        batch = new SpriteBatch();

        this.player = new Player(new Vector2(0, 0));

        Gdx.input.setInputProcessor(new PlayerInputProcessor(this.player));
    }

    @Override
    public void render() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin();
        this.player.render(batch);
        this.player.update();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }
}
