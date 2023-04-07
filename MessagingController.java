package Controller;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessagingController {
    private ClassA classA;
    private ClassB classB;

    public MessagingController(ClassA classA, ClassB classB) {
        this.classA = classA;
        this.classB = classB;
    }

    public void sendMessageFromAtoB(String message) {
        classB.receiveMessageFromA(message);
    }

    public void sendMessageFromBtoA(String message) {
        classA.receiveMessageFromB(message);
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();
        MessagingController messagingController = new MessagingController(classA, classB);

        JFrame frame = new JFrame("Messaging Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 5, 5));
        JLabel labelA = new JLabel("Class A:");
        JTextField textFieldA = new JTextField();
        JLabel labelB = new JLabel("Class B:");
        JTextField textFieldB = new JTextField();
        panel.add(labelA);
        panel.add(textFieldA);
        panel.add(labelB);
        panel.add(textFieldB);
        panel.setBackground(Color.LIGHT_GRAY);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        JButton sendButtonA = new JButton("Send A to B");
        sendButtonA.addActionListener(e -> messagingController.sendMessageFromAtoB(textFieldA.getText()));
        JButton sendButtonB = new JButton("Send B to A");
        sendButtonB.addActionListener(e -> messagingController.sendMessageFromBtoA(textFieldB.getText()));
        buttonPanel.add(sendButtonA);
        buttonPanel.add(sendButtonB);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        frame.setVisible(true);
    }
}

class ClassA {
    public void receiveMessageFromB(String message) {
        System.out.println("Class A received message from B: " + message);
    }
}

class ClassB {
    public void receiveMessageFromA(String message) {
        System.out.println("Class B received message from A: " + message);
    }
}
