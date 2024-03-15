package main.java.ru.sgu.TaskC;

import javax.swing.*;
import java.awt.*;

public class UI {
    private AutomaticTransmission automaticTransmission;
    private static JTextField textField = new JTextField();

    public UI(AutomaticTransmission automaticTransmission) {
        this.automaticTransmission = automaticTransmission;
    }

    public void init() {
        JFrame frame = new JFrame("Test АКПП");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        JButton parking = new JButton("P");
        parking.addActionListener(e -> textField.setText(automaticTransmission.getState().onP()));
        JButton reverse = new JButton("R");
        reverse.addActionListener(e -> textField.setText(automaticTransmission.getState().onR()));
        JButton neutral = new JButton("N");
        neutral.addActionListener(e -> textField.setText(automaticTransmission.getState().onN()));
        JButton drive = new JButton("D");
        drive.addActionListener(e -> textField.setText(automaticTransmission.getState().onD()));
        JButton breakdown = new JButton("Breakdown");
        breakdown.addActionListener(e -> automaticTransmission.setWorkingIndicator(!automaticTransmission.isWorking()));
        JButton speed50 = new JButton("Speed 50");
        speed50.addActionListener(e -> automaticTransmission.setSpeed(50));
        JButton speed0 = new JButton("Speed 0");
        speed0.addActionListener(e -> automaticTransmission.setSpeed(0));
        frame.setVisible(true);
        frame.setSize(500, 100);
        buttons.add(parking);
        buttons.add(reverse);
        buttons.add(neutral);
        buttons.add(drive);
        buttons.add(breakdown);
        buttons.add(speed50);
        buttons.add(speed0);
    }
}