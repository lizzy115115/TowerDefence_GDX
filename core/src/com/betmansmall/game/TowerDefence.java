package com.betmansmall.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;


/**
 * Created by Vitaly on 13.10.2015.
 */
public class TowerDefence extends Game {
//    SpriteBatch batch;
//    BitmapFont font;

    private Screen mainMenu;

    private static TowerDefence instance;
    public static TowerDefence getInstance() {
        if(instance == null) {
            synchronized (TowerDefence.class) {
                if(instance == null) {
                    instance = new TowerDefence();
                }
            }
        }
        return instance;
    }

    @Override
    public void create() {
//        batch = new SpriteBatch();
//        font = new BitmapFont();
        //Gdx.graphics.setDisplayMode(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),true);
        mainMenu = new MainMenuScreen(this);
        setMainMenu(null);
    }

    public void setMainMenu(Screen toDel) {
        if (toDel != null) {
            toDel.dispose();
        }
        this.setScreen(mainMenu);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
//        batch.dispose();
//        font.dispose();
    }

    public void closeApplication(){
        Gdx.app.exit();
    }
}
