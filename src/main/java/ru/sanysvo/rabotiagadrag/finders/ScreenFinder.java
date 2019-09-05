package ru.sanysvo.rabotiagadrag.finders;

import ru.sanysvo.rabotiagadrag.GameScreenController;
import ru.sanysvo.rabotiagadrag.NoxPlayer;
import ru.sanysvo.rabotiagadrag.PatternLoader;
import ru.sanysvo.rabotiagadrag.gamescreens.ChoosePlayerGameScreen;
import ru.sanysvo.rabotiagadrag.gamescreens.GameScreen;
import ru.sanysvo.rabotiagadrag.gamescreens.GarageGameScreen;
import ru.sanysvo.rabotiagadrag.gamescreens.RaceGameScreen;

public class ScreenFinder extends Thread {
    NoxPlayer noxPlayer;
    private boolean runs = true;
    @Override
    public void interrupt() {
        super.interrupt();
    }

    @Override
    public synchronized void start() {
        noxPlayer = NoxPlayer.getInstance();
        noxPlayer.nox.focus();
        super.start();
    }

    public void setRuns(boolean runs) {
        this.runs = runs;
    }

    @Override
    public void run() {
        super.run();
        GameScreen game;
        while (runs){

            System.out.print("");
            if (noxPlayer.getScreen().has(PatternLoader.GARAGE, 0.1)) {
                System.out.println("Найден гараж");
                game = new GarageGameScreen();
                game.detected(noxPlayer, this);
            }

            if (noxPlayer.getScreen().has(PatternLoader.CHANGE_PLAYER, 0.1)) {
                System.out.println("Найден выбор игроков");
                game = new ChoosePlayerGameScreen();
                game.detected(noxPlayer, this);
            }

            if (noxPlayer.getScreen().has(PatternLoader.BRAKE, 0.1)) {
                System.out.println("Найден экран гонки");
                game = new RaceGameScreen();
                game.detected(noxPlayer, this);
            }

            if (noxPlayer.getScreen().has(PatternLoader.OK_ERROR)) {
                try {
                    noxPlayer.getScreen().click(PatternLoader.OK_ERROR);

                } catch (Exception e) {

                }

            }
        }
    }
}
