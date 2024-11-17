package org.muberra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Translater");
        frame.setSize(800,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextField numberField = new JTextField(10);
        Language[] languages= Language.values();
        JComboBox<Language> languageCombo = new JComboBox<>(languages);
        JLabel resultLabel = new JLabel("Result:");
        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long number = Long.parseLong(numberField.getText());
                    String selectedLanguage = languageCombo.getSelectedItem().toString();
                    NumberConverter converter = NumberConverterFactory.getNumberConverter(Language.valueOf(selectedLanguage));
                    String result = converter.convert(number);
                    resultLabel.setText("Result: " + result);
                }catch (NumberFormatException ex){
                    resultLabel.setText("Invalidnumber!");
                }
            }

        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter number: "));
        panel.add(numberField);
        panel.add(new JLabel("Select language: "));
        panel.add(languageCombo);
        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);























        NumberConverter en = NumberConverterFactory.getNumberConverter(Language.ENGLISH);
        System.out.println(en.convert(1234)); // Output: "one thousand two hundred thirty four"
    }
}