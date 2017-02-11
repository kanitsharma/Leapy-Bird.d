package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.menustate;

public class MyGdxGame extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Leapy Bird";
	private GameStateManager gm;
	private SpriteBatch batch;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gm.push(new menustate(gm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gm.update(Gdx.graphics.getDeltaTime());
		gm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
