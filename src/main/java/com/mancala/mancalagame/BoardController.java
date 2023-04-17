package com.mancala.mancalagame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Collections;

public class BoardController {
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Label currentPlayer;
    @FXML
    private Label notification;

    @FXML
    private ArrayList<String> holeLabels = new ArrayList<>();
    @FXML
    private ArrayList<String> mancalaLabels = new ArrayList<>();
    @FXML
    private Label holeLabel0;
    @FXML
    private Label holeLabel1;
    @FXML
    private Label holeLabel2;
    @FXML
    private Label holeLabel3;
    @FXML
    private Label holeLabel4;
    @FXML
    private Label holeLabel5;
    @FXML
    private Label holeLabel6;
    @FXML
    private Label holeLabel7;
    @FXML
    private Label holeLabel8;
    @FXML
    private Label holeLabel9;
    @FXML
    private Label holeLabel10;
    @FXML
    private Label holeLabel11;
    @FXML
    private Label mancalaLabel_P1;
    @FXML
    private Label mancalaLabel_P2;
    @FXML
    private Button traditional;
    @FXML
    private Button arcade;
    @FXML
    private final ArrayList<Hole> holes = new ArrayList<>();
    private final ArrayList<Hole> holesPlayer1 = new ArrayList<>();
    private final ArrayList<Hole> holesPlayer2 = new ArrayList<>();
    @FXML
    private final ArrayList<Mancala> mancalas = new ArrayList<>();
    private int holeNumber;
    private Board board = new Board(holes, mancalas);
    @FXML
    private void setBoard() {
        button0.setDisable(false);
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
        button10.setDisable(true);
        button11.setDisable(true);
        for (int i = 0; i < 12; i++) {
            holes.add(new Hole(4));
            holeLabels.add("4");
        }
        for (int i = 0; i <= 2; i++) {
            mancalas.add(new Mancala(0));
            mancalaLabels.add("0");
        }
        for (int i = 0; i < 6; i++) {
            holesPlayer1.add(holes.get(i));
            holesPlayer2.add(holes.get(i+6));
        }
    }
    private void setCurrentPlayer() {
        if (currentPlayer.getText().equals("1")) {
            currentPlayer.setText("2");
            button0.setDisable(true);
            button1.setDisable(true);
            button2.setDisable(true);
            button3.setDisable(true);
            button4.setDisable(true);
            button5.setDisable(true);
            button6.setDisable(false);
            button7.setDisable(false);
            button8.setDisable(false);
            button9.setDisable(false);
            button10.setDisable(false);
            button11.setDisable(false);

        } else {
            currentPlayer.setText("1");
            button0.setDisable(false);
            button1.setDisable(false);
            button2.setDisable(false);
            button3.setDisable(false);
            button4.setDisable(false);
            button5.setDisable(false);
            button6.setDisable(true);
            button7.setDisable(true);
            button8.setDisable(true);
            button9.setDisable(true);
            button10.setDisable(true);
            button11.setDisable(true);
        }
    }

    private void setLabels() {
        holeLabel0.setText(holeLabels.get(0));
        holeLabel1.setText(holeLabels.get(1));
        holeLabel2.setText(holeLabels.get(2));
        holeLabel3.setText(holeLabels.get(3));
        holeLabel4.setText(holeLabels.get(4));
        holeLabel5.setText(holeLabels.get(5));
        holeLabel6.setText(holeLabels.get(6));
        holeLabel7.setText(holeLabels.get(7));
        holeLabel8.setText(holeLabels.get(8));
        holeLabel9.setText(holeLabels.get(9));
        holeLabel10.setText(holeLabels.get(10));
        holeLabel11.setText(holeLabels.get(11));
        mancalaLabel_P1.setText(mancalaLabels.get(0));
        mancalaLabel_P2.setText(mancalaLabels.get(1));
    }
    @FXML
    private void moveStones(int holeNumber) {
        int chosenHoleCount = holes.get(holeNumber).getCount();
        holes.get(holeNumber).setCount(0);
        holeLabels.set(holeNumber, "0");
        int i = 1;
        int index = i + holeNumber;
        int rightMancalaFlag = 0;
        boolean normalLastFilled = false;
        boolean rightLastFilled = false;
        boolean leftLastFilled = false;
        int curr = 0;
        int newHoleNumber = 0;
        for (i = 1; i <= chosenHoleCount; i++) {
            if (index == 12 && currentPlayer.getText().equals("2")) {
                mancalas.get(1).setCount(mancalas.get(1).getCount() + 1);
                mancalaLabels.set(1, String.valueOf(mancalas.get(1).getCount()));
                index = 0;
                leftLastFilled = true;
                rightLastFilled = false;
                normalLastFilled = false;
            } else if (index == 6 && currentPlayer.getText().equals("1")) {
                mancalas.get(0).setCount(mancalas.get(0).getCount() + 1);
                mancalaLabels.set(0, String.valueOf(mancalas.get(0).getCount()));
                index++;
                rightMancalaFlag++;
                leftLastFilled = false;
                rightLastFilled = true;
                normalLastFilled = false;
            } else if (index == 12) {
                index = 0;
                i--;
            } else if (rightMancalaFlag <= index) {
                curr = holes.get(index - rightMancalaFlag).getCount();
                holes.get(index - rightMancalaFlag).setCount(curr + 1);
                holeLabels.set(index - rightMancalaFlag, String.valueOf(curr + 1));
                newHoleNumber = index - rightMancalaFlag;
                index++;
                leftLastFilled = false;
                rightLastFilled = false;
                normalLastFilled = true;
            } else {
                curr = holes.get(11).getCount();
                holes.get(11).setCount(curr + 1);
                holeLabels.set(11, String.valueOf(curr + 1));
                newHoleNumber = 11;
                index++;
                leftLastFilled = false;
                rightLastFilled = false;
                normalLastFilled = true;
            }
        }

        setLabels();

        if (rightLastFilled || leftLastFilled) {
            notification.setText("Take another turn!");
        } else if (normalLastFilled && curr != 0) {
            notification.setText("Ended in a non-empty hole - turn continues");
            moveStones(newHoleNumber);
        } else {
            setCurrentPlayer();
            notification.setText("");
        }
        gameEnd();
    }

    private void gameEnd() {
        if (totalContents(holesPlayer1) == 0) {
            mancalas.get(1).setCount(mancalas.get(1).getCount() + totalContents(holesPlayer2));
            mancalaLabels.set(1, String.valueOf(mancalas.get(1).getCount()));
            for (Hole h : holes) {
                h.setCount(0);
            }
            Collections.fill(holeLabels, "0");
            setLabels();
            getWinner();
        } else if (totalContents(holesPlayer2) == 0) {
            mancalas.get(0).setCount(mancalas.get(0).getCount() + totalContents(holesPlayer1));
            mancalaLabels.set(0, String.valueOf(mancalas.get(0).getCount()));
            for (Hole h : holes) {
                h.setCount(0);
            }
            Collections.fill(holeLabels, "0");
            setLabels();
            getWinner();
        }
    }

    private int getWinner() {
        int score1 = mancalas.get(0).getCount();
        int score2 = mancalas.get(1).getCount();
        int winner;
        if (score1 < score2) {
            notification.setText("Player 2 wins!");
            winner = 2;
        } else if (score1 > score2) {
            notification.setText("Player 1 wins!");
            winner = 1;
        } else {
            notification.setText("It's a draw!");
            winner = -1;
        }
        button0.setDisable(true);
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
        button10.setDisable(true);
        button11.setDisable(true);

        return winner;
    }

    private int totalContents(ArrayList<Hole> holes) {
        int total = 0;
        for (Hole h : holes) {
            total += h.getCount();
        }
        return total;
    }
    private boolean checkEmpty(int holeNumber) {
        return holes.get(holeNumber).getCount() != 0;
    }
    @FXML
    private void onHole0Click() {
        holeNumber = 0;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole1Click() {
        holeNumber = 1;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole2Click() {
        holeNumber = 2;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole3Click() {
        holeNumber = 3;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole4Click() {
        holeNumber = 4;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole5Click() {
        holeNumber = 5;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole6Click() {
        holeNumber = 6;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole7Click() {
        holeNumber = 7;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole8Click() {
        holeNumber = 8;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole9Click() {
        holeNumber = 9;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole10Click() {
        holeNumber = 10;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }
    @FXML
    private void onHole11Click() {
        holeNumber = 11;
        if (checkEmpty(holeNumber)) {
            moveStones(holeNumber);
        } else {
            notification.setText("Choose a non-empty hole");
        }
    }

}
