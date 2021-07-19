package ui;

import model.GadData;
import model.GadQuestions;
import model.GadRecord;
import model.ScoreTooHighException;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;


// Represents a GAD Application
public class GadApp extends JFrame implements ActionListener {
    private GadData gadData;
    private GadRecord gadScore;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/gadData.json";
    JButton startGAD;
    GadFrame gadFrame = new GadFrame();
    JPanel topPanel = new JPanel();
    JLabel appLabel = new JLabel("Welcome to Anxiety Monitor");
    JLabel dataLabel = new JLabel();
    JLabel savedData = new JLabel();
    private QuestionsPanel questionsPanel = new QuestionsPanel();

    // EFFECTS: initializes Json Writer and Reader; calls the runGadApp method
    public GadApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        gadFrame.setLayout(null);

        // first panel that holds menu and title
        appLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        topPanel.setBounds(10, 10, 250, 30);
        topPanel.add(appLabel);
        gadFrame.add(topPanel);

        startGAD = new JButton("Start GAD Assessment");
        startGAD.setBounds(20, 100, 200, 50);
        gadFrame.add(startGAD);
        startGAD.addActionListener(this);
        saveData();
    }

    // EFFECTS: processes the initial start assessment button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGAD) {
            gadFrame.add(questionsPanel.addQuestionsPanel());
            initGadScoring();
            JButton submit = new JButton("Submit");
            submit.setBounds(300, 100, 200, 50);
            gadFrame.add(submit);
            submit.addActionListener(a -> processAnswers());
        }
    }

    // MODIFIES: GadData, gd
    // EFFECTS: process the the user inputs from the given answers
    public void processAnswers() {
        int ans1 = questionsPanel.getAnswer1();
        int ans2 = questionsPanel.getAnswer2();
        int ans3 = questionsPanel.getAnswer3();
        int ans4 = questionsPanel.getAnswer4();
        int ans5 = questionsPanel.getAnswer5();
        int ans6 = questionsPanel.getAnswer6();
        int ans7 = questionsPanel.getAnswer7();
        gadScore.setTotalScore(ans1, ans2, ans3, ans4, ans5, ans6, ans7);
        try {
            gadScore.setSeverity();
        } catch (ScoreTooHighException e) {
            System.out.println("score Too High; cannot calculate");
        }
        gadData.addRecord(gadScore);
        questionsPanel.hidePanel();
        showScore();
    }

    // MODIFIES: this
    // EFFECTS: shows the most recent score
    public void showScore() {
        JPanel showScore = new JPanel();
        showScore.setVisible(true);
        showScore.setBounds(50, 200, 600, 500);
        showScore.setLayout(new GridLayout(2,2));
        gadFrame.add(showScore);
        dataLabel.setText(String.valueOf(gadData.getGadScoreList().getFirst().getSeverity()));
        BufferedImage img = null;
        try {
            img = ImageIO.read(new URL(
                    "https://blog.filestage.io/wp-content/uploads/2019/04/checked.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon completedImg = new ImageIcon(img);
        JLabel imageLabel = new JLabel(completedImg);
        gadFrame.add(imageLabel);
        showScore.add(dataLabel);
        showScore.add(imageLabel);
    }

    // EFFECTS: saves the data to JSON File
    public void saveData() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        gadFrame.setJMenuBar(menuBar);
        saveItem.addActionListener(e -> saveGadData());
        loadItem.addActionListener(e -> loadGadData());
    }


    // MODIFIES: this
    // EFFECTS: initializes new GadQuestions, GadRecord, GadData, and input
    private void initGadScoring() {
        GadQuestions gadQuestions = new GadQuestions();
        gadScore = new GadRecord();
        gadData = new GadData();
    }

    // EFFECTS: saves GadData to a JSON file
    private void saveGadData() {
        LocalTime currentTime = LocalTime.now();
        try {
            jsonWriter.open();
            jsonWriter.write(gadData);
            jsonWriter.close();

            dataLabel.setVisible(false);
            JPanel showSavedData = new JPanel();
            showSavedData.setVisible(true);
            showSavedData.setBounds(50, 300, 600, 1000);
            gadFrame.add(showSavedData);
            savedData.setText("Previous saved data " + JSON_STORE);
            showSavedData.add(savedData);

            System.out.println("Saved " + currentTime + " to" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: loads GadData from a JSON file
    private void loadGadData() {
        try {
            gadData = jsonReader.read();
            savedData.setVisible(false);
            dataLabel.setVisible(false);
            JPanel loadData = new JPanel();
            loadData.setVisible(true);
            loadData.setBounds(50, 300, 600, 1000);
            gadFrame.add(loadData);
            JLabel loadedData = new JLabel("Loading data " + JSON_STORE);
            loadData.add(loadedData);

            System.out.println("Loaded file from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}