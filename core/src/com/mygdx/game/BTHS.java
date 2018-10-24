package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class BTHS extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TiledMap level1;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	
	@Override
	public void create () {
		//helloworld
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight(); 
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		camera.update();
		level1 = new TmxMapLoader().load("Level1.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(level1);
		batch = new SpriteBatch();
		img = new Texture("blizzRight.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
