package ru.sanysvo.rabotiagadrag.settings;


import ru.sanysvo.rabotiagadrag.finders.ScreenFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SettingScreen extends JFrame implements KeyListener, ActionListener {

    ScreenFinder finder = new ScreenFinder();
    Container c;

    public SettingScreen() {

       c = getContentPane(); // клиентская область окна
        c.setLayout(new FlowLayout()); // выбираем компоновщик
        // добавляем какие-нибудь дочерние элементы
        // -------------------------------------------
        JButton button = new JButton("Старт");
        button.addActionListener(this);
        button.setActionCommand("start");
        c.add(button);

        JButton stop = new JButton("Стоп");
        stop.addActionListener(this);
        stop.setActionCommand("stop");
        c.add(stop);

        setTitle("Бот Работяга"); // заголовок окна
        // желательные размеры окна
        setPreferredSize(new Dimension(300, 200));
        // завершить приложение при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setFocusable(true);
        addKeyListener(this);
        pack();




    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("Остановка");
            //finder.interrupt();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "start" :
                finder = new ScreenFinder();
                finder.start();
                break;
            case "stop" :
                finder.setRuns(false);
                break;
        }
    }
}
