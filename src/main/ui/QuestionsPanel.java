package ui;

import model.GadQuestions;

import javax.swing.*;
import java.awt.*;

public class QuestionsPanel {

    private final GadQuestions gadQuestions = new GadQuestions();
    private final JPanel questionsPanel = new JPanel();

    JTextField answerOne = new JTextField();
    JTextField answerTwo = new JTextField();
    JTextField answerThree = new JTextField();
    JTextField answerFour = new JTextField();
    JTextField answerFive = new JTextField();
    JTextField answerSix = new JTextField();
    JTextField answerSeven = new JTextField();

    // MODIFIES: this
    // EFFECTS: adds questions to the JPanel
    public JPanel addQuestionsPanel() {
        questionsPanel.setBounds(20, 200, 1500, 1000);
        questionsPanel.setVisible(true);
        addQuestionsHeading();
        addQuestion1();
        addQuestion2();
        addQuestion3();
        addQuestion4();
        addQuestion5();
        addQuestion6();
        addQuestion7();
        return questionsPanel;
    }

    // MODIFIES: this
    // EFFECTS: adds question heading to the JPanel
    private void addQuestionsHeading() {
        JPanel questionHeadingPanel = new JPanel();
        questionHeadingPanel.setVisible(true);
        questionHeadingPanel.setBounds(50, 200, 1000, 100);
        JLabel headingLabel = new JLabel();
        headingLabel.setText(gadQuestions.getQuestionHeading());
        questionHeadingPanel.add(headingLabel);
        questionsPanel.add(questionHeadingPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion1() {
        JPanel queOnePanel = new JPanel();
        queOnePanel.setVisible(true);
        queOnePanel.setBounds(20, 200, 500, 100);
        JLabel queOneLabel = new JLabel();
        queOneLabel.setText(gadQuestions.getQuestion1());
        queOnePanel.add(queOneLabel);
        answerOne.setPreferredSize(new Dimension(50, 50));
        queOnePanel.add(answerOne);
        questionsPanel.add(queOnePanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion2() {
        JPanel queTwoPanel = new JPanel();
        queTwoPanel.setVisible(true);
        queTwoPanel.setBounds(20, 200, 500, 100);
        JLabel queTwoLabel = new JLabel();
        queTwoLabel.setText(gadQuestions.getQuestion2());
        queTwoPanel.add(queTwoLabel);
        answerTwo.setPreferredSize(new Dimension(50, 50));
        queTwoPanel.add(answerTwo);
        questionsPanel.add(queTwoPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion3() {
        JPanel queThreePanel = new JPanel();
        queThreePanel.setVisible(true);
        queThreePanel.setBounds(20, 200, 500, 100);
        JLabel queThreeLable = new JLabel();
        queThreeLable.setText(gadQuestions.getQuestion3());
        queThreePanel.add(queThreeLable);
        answerThree.setPreferredSize(new Dimension(50, 50));
        queThreePanel.add(answerThree);
        questionsPanel.add(queThreePanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion4() {
        JPanel queFourPanel = new JPanel();
        queFourPanel.setVisible(true);
        queFourPanel.setBounds(20, 200, 500, 100);
        JLabel queFourLabel = new JLabel();
        queFourLabel.setText(gadQuestions.getQuestion4());
        queFourPanel.add(queFourLabel);
        answerFour.setPreferredSize(new Dimension(50, 50));
        queFourPanel.add(answerFour);
        questionsPanel.add(queFourPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion5() {
        JPanel queFivePanel = new JPanel();
        queFivePanel.setVisible(true);
        queFivePanel.setBounds(20, 200, 500, 100);
        JLabel queFiveLabel = new JLabel();
        queFiveLabel.setText(gadQuestions.getQuestion5());
        queFivePanel.add(queFiveLabel);
        answerFive.setPreferredSize(new Dimension(50, 50));
        queFivePanel.add(answerFive);
        questionsPanel.add(queFivePanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion6() {
        JPanel queSixPanel = new JPanel();
        queSixPanel.setVisible(true);
        queSixPanel.setBounds(20, 200, 500, 100);
        JLabel queSixLabel = new JLabel();
        queSixLabel.setText(gadQuestions.getQuestion6());
        queSixPanel.add(queSixLabel);
        answerSix.setPreferredSize(new Dimension(50, 50));
        queSixPanel.add(answerSix);
        questionsPanel.add(queSixPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds question to the JPanel
    private void addQuestion7() {
        JPanel queSevenPanel = new JPanel();
        queSevenPanel.setVisible(true);
        queSevenPanel.setBounds(20, 200, 500, 100);
        JLabel queSevenLabel = new JLabel();
        queSevenLabel.setText(gadQuestions.getQuestion7());
        queSevenPanel.add(queSevenLabel);
        answerSeven.setPreferredSize(new Dimension(50, 50));
        queSevenPanel.add(answerSeven);
        questionsPanel.add(queSevenPanel);
    }

    public int getAnswer1() {
        return Integer.parseInt(answerOne.getText());
    }

    public int getAnswer2() {
        return Integer.parseInt(answerTwo.getText());
    }

    public int getAnswer3() {
        return Integer.parseInt(answerThree.getText());
    }

    public int getAnswer4() {
        return Integer.parseInt(answerFour.getText());
    }

    public int getAnswer5() {
        return Integer.parseInt(answerFive.getText());
    }

    public int getAnswer6() {
        return Integer.parseInt(answerSix.getText());
    }

    public int getAnswer7() {
        return Integer.parseInt(answerSeven.getText());
    }

    // EFFECTS: hides the panel
    public void hidePanel() {
        questionsPanel.setVisible(false);
    }
}
