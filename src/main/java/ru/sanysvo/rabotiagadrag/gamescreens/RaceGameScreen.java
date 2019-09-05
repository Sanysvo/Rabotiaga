package ru.sanysvo.rabotiagadrag.gamescreens;

import ru.sanysvo.rabotiagadrag.NoxPlayer;
import ru.sanysvo.rabotiagadrag.PatternLoader;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RaceGameScreen extends GameScreen {
    boolean isRace = true;
    Robot robot;
    @Override
    public void detected(NoxPlayer noxPlayer, Thread thread) {
        try {
            robot = new Robot();
            Thread.sleep(500);
        }catch (Exception e){
            System.exit(0);
        }
        int ticks = 0;

        System.out.println("Нажимаем газ");
        robot.keyPress(KeyEvent.VK_W);
        while (isRace && !thread.isInterrupted()){
            ticks++;
            robot.keyPress(KeyEvent.VK_W);
            System.out.println("Цикл гонки");
            if(noxPlayer.getScreen().has(PatternLoader.PEREGIM.similar(0.95), 0)){
                System.out.println("Найден пережим");
                robot.keyRelease(KeyEvent.VK_W);
                robot.keyPress(KeyEvent.VK_W);
                ticks = -9999999;

            }



            if(noxPlayer.getScreen().has(PatternLoader.OK_AFTER_RACE)){

                if(noxPlayer.getScreen().has(PatternLoader.NEXT_RACE)){
                    try {
                        noxPlayer.getScreen().click(PatternLoader.NEXT_RACE);
                        ChoosePlayerGameScreen.countRace = ChoosePlayerGameScreen.countRace - 1;
                        isRace = false;
                    }catch (Exception e){

                    }
                } else {
                    try {
                        noxPlayer.getScreen().click(PatternLoader.OK_AFTER_RACE);
                        isRace = false;
                    } catch (Exception e) {

                    }
                }
            }

            if(ChoosePlayerGameScreen.countRace < 2){
                robot.keyRelease(KeyEvent.VK_W);
                try {

                    Thread.sleep(500);
                }catch (Exception e){
                    System.exit(0);
                }
            }

            if(ticks > 10){
                ticks = 0;
                robot.keyRelease(KeyEvent.VK_W);
            }


        }

    }
}
