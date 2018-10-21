package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/*
 * Character class
 */
public class Character {
	//variables for textures and music
	private Texture Blizzard;
	private Texture stage;
	private Music stageMusic;


	private float x;

	void create() {
		//TODO: Load character, map, and sound files.
		//I've been using this as a reference: https://github.com/libgdx/libgdx/wiki/A-simple-game
		

		Rectangle Blizzard;
		Blizzard = new Rectangle();
		Blizzard.width = 64;
		Blizzard.height = 64;
		Blizzard.x = 400;
		Blizzard.y = 20;

	}



	void Movement() {
		Character Blizzard = new Character();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			Blizzard.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			Blizzard.x += 200* Gdx.graphics.getDeltaTime();
	}

}
