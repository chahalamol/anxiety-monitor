package ui;

public class OldConsoleCode {
/*
    // OLD CONSOLE CODE [IGNORE THIS]
    // MODIFIES: this
    // EFFECTS: runs the gad app
    private void runGadApp() {
        initGadScoring();
        while (keepScoring) {
            getNextQuestion(queSequence);
            System.out.println("Enter close to close");
            if (queSequence == 7) {
                showUserOptions();
            }
            command = input.next();
            processUserCommand();
        }
    }

    // EFFECTS: processes the command inputted by the user
    private void processUserCommand() {
        if (command.equals("close")) {
            keepScoring = false;
        } else if (command.equals("show")) {
            showPreviousScores();
            queSequence = 0;
            init2();
        } else if (command.equals("save")) {
            saveGadData();
            init2();
        } else if (command.equals("load")) {
            loadGadData();
            init2();
        }  else if (queSequence < 7) {
            processInput(command, queSequence);
            queSequence += 1;
        } else {
            keepScoring = false;
        }
    }

    // EFFECTS: prints out the command options to choose from
    private void showUserOptions() {
        System.out.println("Enter show to show previous data");
        System.out.println("Enter save to save data to file");
        System.out.println("Enter load to load data from a file");
    }

    // EFFECTS: initializes everything, except GadData (to prevent app exit)
    private void init2() {
        gadQuestions = new GadQuestions();
        gadScore = new GadRecord();
        input = new Scanner(System.in);
    }

    // MODIFIES: this
    // EFFECTS: processes user input and sets the score accordingly
    private void processInput(String command, int queSeq) {
        if (command.equals("0")) {
            gadScore.setScore0();
            gadScore.setTotalScore();
            gadScore.setSeverity();
        } else if (command.equals("1")) {
            gadScore.setScore1();
            gadScore.setTotalScore();
            gadScore.setSeverity();
        } else if (command.equals("2")) {
            gadScore.setScore2();
            gadScore.setTotalScore();
            gadScore.setSeverity();
        } else if (command.equals("3")) {
            gadScore.setScore3();
            gadScore.setTotalScore();
            gadScore.setSeverity();
        } else {
            System.out.println("Please answer with 0, 1, 2, or 3");
        }
        if (queSeq == 6) {
            gadData.addRecord(gadScore);
        }
    }

    // EFFECTS: displays the answers to choose from


    // EFFECTS: shows the initial questionnaire heading
    public void displayHeading() {
        System.out.println(gadQuestions.getQuestionHeading());
    }

    // EFFECTS: gets the next question based on queSequence, as the user answers each que
    public void getNextQuestion(int queSequence) {
        if (queSequence == 0) {
            displayHeading();
            System.out.println(gadQuestions.getQuestion1());
            displayAnswers1();
        } else if (queSequence == 1) {
            System.out.println(gadQuestions.getQuestion2());
            displayAnswers1();
        } else if (queSequence == 2) {
            System.out.println(gadQuestions.getQuestion3());
            displayAnswers1();
        } else if (queSequence == 3) {
            System.out.println(gadQuestions.getQuestion4());
            displayAnswers1();
        } else if (queSequence == 4) {
            System.out.println(gadQuestions.getQuestion5());
            displayAnswers1();
        } else if (queSequence == 5) {
            System.out.println(gadQuestions.getQuestion6());
            displayAnswers1();
        }  else if (queSequence == 6) {
            System.out.println(gadQuestions.getQuestion7());
            displayAnswers1();
        }
    }

    // EFFECTS: shows previous scores that the user took
    public void showPreviousScores() {
        for (GadRecord gadRecord : gadData.getGadScoreList()) {
            System.out.println(gadRecord.getSeverity() + " " + gadRecord.getTotalScore());
        }
    } */
}
