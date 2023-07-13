import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorBMI extends JFrame {
    private JTextField textFieldWaga;
    private JTextField textFieldWzrost;
    private JLabel labelWynik;

    public KalkulatorBMI() {
        setTitle("Kalkulator BMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel labelWaga = new JLabel("Waga (kg):");
        textFieldWaga = new JTextField();
        JLabel labelWzrost = new JLabel("Wzrost (cm):");
        textFieldWzrost = new JTextField();

        JLabel labelEmpty = new JLabel();
        JButton buttonOblicz = new JButton("Oblicz");
        labelWynik = new JLabel();

        buttonOblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obliczBMI();
            }
        });

        panel.add(labelWaga);
        panel.add(textFieldWaga);
        panel.add(labelWzrost);
        panel.add(textFieldWzrost);
        panel.add(labelEmpty);
        panel.add(buttonOblicz);
        panel.add(labelWynik);

        add(panel);
        setVisible(true);
    }

    private void obliczBMI() {
        try {
            double waga = Double.parseDouble(textFieldWaga.getText());
            double wzrost = Double.parseDouble(textFieldWzrost.getText()) / 100.0; // zamiana wzrostu z cm na metry

            double bmi = waga / (wzrost * wzrost);
            String kategoria;

            if (bmi < 18.5) {
                kategoria = "Niedowaga";
            } else if (bmi < 25) {
                kategoria = "Normalna waga";
            } else if (bmi < 30) {
                kategoria = "Nadwaga";
            } else {
                kategoria = "Otyłość";
            }

            labelWynik.setText("BMI: " + String.format("%.2f", bmi) + " - " + kategoria);
        } catch (NumberFormatException e) {
            labelWynik.setText("Błąd! Wprowadź poprawne wartości.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new KalkulatorBMI();
            }
        });
    }
}
