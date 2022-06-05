package com.emk.omni;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.emk.omni.entities.player.Aim;
import com.emk.omni.entities.player.Player;
import com.emk.omni.entities.enemies.EnemyExample;
import com.emk.omni.input.PlayerInputProcessor;
import com.emk.omni.constants.RenderConstants;

public class OmniGame extends ApplicationAdapter {
    public SpriteBatch batch;
    public Player player;
    public Aim aim;
    public EnemyExample enemyExample;
    public World world;

    public BodyDef bodyDef;
    public Body groundBody;
    public Shape groundBox;

    public FitViewport fitViewport;
    public Stage stage;

    public OrthographicCamera cam;

    @Override
    public void create() {

        Box2D.init();
        world = new World(new Vector2(0, 0), true);

        fitViewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam = (OrthographicCamera) fitViewport.getCamera();
        cam.viewportWidth = Gdx.graphics.getWidth() / RenderConstants.PIXEL_PER_UNIT;
        cam.viewportHeight = Gdx.graphics.getHeight() / RenderConstants.PIXEL_PER_UNIT;
        cam.update();
        cam.zoom = 0.5f;

        aim = new Aim(cam);

        batch = new SpriteBatch();

        stage = new Stage(fitViewport);
        player = new Player(world, new Vector2(0, 0), aim);
        enemyExample = new EnemyExample(world, new Vector2(0, 0));
        stage.addActor(player);
        stage.addActor(enemyExample);
        stage.addActor(aim);

        bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(30, 30));

        groundBody = world.createBody(bodyDef);

        groundBox = new PolygonShape();
        ((PolygonShape) groundBox).setAsBox(0.5f, 0.5f);
        groundBody.createFixture(groundBox, 0.0f);

        Gdx.input.setInputProcessor(new PlayerInputProcessor(player));
    }

    @Override
    public void render() {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        world.step(1/60f, 6, 2);

        stage.act();
        cam.position.set(player.getX() * RenderConstants.PIXEL_PER_UNIT + 16, player.getY() * RenderConstants.PIXEL_PER_UNIT + 16, 0f);
        cam.update();
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
