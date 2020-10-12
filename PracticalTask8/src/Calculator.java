import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator {

    private JFrame mainFrame;

    public Calculator() {

        mainFrame = new JFrame();

        mainFrame.setTitle("Calculator");
        mainFrame.setBounds(100, 100, 300, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Рисуем области
        JPanel outFieldPnl = new JPanel();
        outFieldPnl.setLayout(new BorderLayout());
        mainFrame.add(outFieldPnl, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        JPanel digitPnl = new JPanel();
        digitPnl.setLayout(new GridLayout(4,3));
        mainPanel.add(digitPnl, BorderLayout.CENTER);

        JPanel commandPnl = new JPanel();
        commandPnl.setLayout(new GridLayout(3,2));
        mainPanel.add(commandPnl, BorderLayout.EAST);

        // Текстовое поле
        JTextField outField = new JTextField();
        outField.setEditable(false);
        outFieldPnl.add(outField);

        CalculatorButtonListener cbListener = new CalculatorButtonListener(outField);

        // Цифры и скобки
        for (int i = 1; i < 10; i++) {
            addButton(String.valueOf(i), digitPnl, cbListener);
        }

        addButton("(", digitPnl, cbListener);
        addButton("0", digitPnl, cbListener);
        addButton(")", digitPnl, cbListener);

        // Команды
        addButton("+", commandPnl, cbListener, Color.lightGray);
        addButton("-", commandPnl, cbListener, Color.lightGray);
        addButton("*", commandPnl, cbListener, Color.lightGray);
        addButton("/", commandPnl, cbListener, Color.lightGray);
        addButton("=", commandPnl, cbListener, Color.lightGray);
        addButton("C", commandPnl, cbListener, Color.lightGray);

        mainFrame.setVisible(true);

    }

    private void addButton(String title, JComponent parent, ActionListener actListener) {

        JButton Btn = new JButton(title);
        Btn.addActionListener(actListener);
        parent.add(Btn);

    }

    private void addButton(String title, JComponent parent, ActionListener actListener, Color col) {

        JButton Btn = new JButton(title);
        Btn.addActionListener(actListener);
        Btn.setBackground(Color.lightGray);
        parent.add(Btn);

    }
}
