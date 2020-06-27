import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NiHonGo {
    String[] input;
    String[] sound;
    String[] hiragana;
    String[] katakana;
    int[] playerScore = new int[2];

    public NiHonGo(In in) {
        this.hiragana = new String[46];
        this.katakana = new String[46];
        this.sound = new String[46];
        int i = 0;

        input = in.readAllStrings();
        for (int j = 0; j < input.length; j++) {
            input[i] = input[i].replaceAll("\\s", "");
        }
        System.out.println(input.length);


        for (int k = 0; k < 46; k++) {

            this.hiragana[k] = input[i];
            this.katakana[k] = input[i+1];
            this.sound[k] = input[i+2];
            i = i + 3;

        }

    }

    public void printValue() {
        for (int i = 0; i < 46; i++) {
            System.out.println(sound[i] + " " + hiragana[i] + " " + katakana[i]);
        }
    }

    public void correspondingValues(String in, boolean player, int mode){

        int i = 0; Scanner scan = new Scanner(System.in);
        while (true) {
            if (this.hiragana[i].equals(in)) {
                if (mode == 0) {
                    System.out.println("Please enter your answer for katakana: ");
                    if (scan.nextLine().equals(katakana[i])) score(player);
                    else System.out.println("Incorrect");
                }
                System.out.println(" Katakana is: " + this.katakana[i]);
                break;
            }
            if (this.katakana[i].equals(in)) {
                if (mode == 0) {
                    System.out.println("Please enter your answer for hiragana: ");
                    if (scan.nextLine().equals(hiragana[i])) score(player);
                    else System.out.println("Incorrect");
                }
                System.out.println(" Hiragana is: " + this.hiragana[i]);
                break;
            }
            if (this.sound[i].contains(in)) {
                if (mode==0) {
                    System.out.println("Please enter your answer for hiragana: ");
                    if (scan.nextLine().equals(hiragana[i])) score(player);
                    else System.out.println("Incorrect");
                    System.out.println("answer for katakana: ");
                    if (scan.nextLine().equals(katakana[i])) score(player);
                    else System.out.println("Incorrect");
                }
                System.out.println(" Hiragana is: " + hiragana[i] + " Katakana is: " + katakana[i]);
                break;
            }
            i++;
            if (i>45) {
                System.out.println("wrong value");
                break;
            }
        }
    }
    public void lookUp(){
        Scanner scan = new Scanner(System.in);
        while (true){
        System.out.println("Enter a value or type 'exit' to exit : ");
        String in = scan.nextLine();
        if (in.equals("exit")) break;
        correspondingValues(in, true, 1);
        }
    }

    public void dictation(){
        Random rand = new Random();
        int type, value;
        Scanner scan = new Scanner(System.in);
        boolean player = true;
        do {
            type = rand.nextInt(3);
            value = rand.nextInt(46);
            switch (type) {
                case 0:
                    System.out.println(sound[value]);
                        correspondingValues(sound[value], player, 0);
                    break;
                case 1:
                    System.out.println(hiragana[value]);
                    correspondingValues(hiragana[value], player, 0);
                    break;
                case 2:
                    System.out.println(katakana[value]);
                    correspondingValues(katakana[value], player, 0);
                    break;
            }
            while(true) {
                System.out.println("enter 'exit' to exit, 'score' to check score or any other key to continue.");
                String in = scan.nextLine();
                if (in.equals("score")) {
                    System.out.println("Player 1: " + playerScore[0]);
                    System.out.println("Player 2: " + playerScore[1]);
                }
                else if (in.equals("exit")) return;
                else break;
            }
            player = !player;
        } while (true);
    }

    public void score(boolean player){
        System.out.println("correct!");
        if (player) playerScore[0] = playerScore[0] + 1;
        else playerScore[1] = playerScore[1] + 1;
    }

    public void interact(){
        Scanner scan = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("type 0 to enter dictation mode, 1 revision mode, 2 to exit");
            String in = scan.nextLine();
            switch (in) {
                case "0":
                    dictation();
                    break;
                case "1":
                    lookUp();
                    break;
                case "2":
                    break label;
                default:
                    System.out.println("wrong value, please enter again");
                    break;
            }
        }
    }
}