import java.util.Scanner;

public class SnakeLadderGame {
    public static class Player {
        int position;
        int noOfDiceRoll;

        public Player() {
            this.position = 0;
            this.noOfDiceRoll = 0;
        }
    }

    static int checkSnakeLadder(int position) {

        if (position == 4) {
            return 25;
        } else if (position == 13)
            return 46;
        else if (position == 33)
            return 49;
        else if (position == 42)
            return 63;
        else if (position == 50)
            return 29;
        else if (position == 62)
            return 22;
        else if (position == 74)
            return 53;
        else if (position == 99)
            return 2;

        return position;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        boolean turn = true;
        while (player1.position != 100 || player2.position != 100) {
            int dice = (int) (Math.random() * 6) + 1;
            int newPos = 0;
            if (turn) {
                player1.noOfDiceRoll++;
                System.out.println("Player 1 roll : " + dice);
                if (player1.position + dice <= 100) {
                    player1.position += dice;
                    newPos = checkSnakeLadder(player1.position);
                    if (newPos > player1.position) {
                        System.out.println("You got ladder and roll dice again");
                        turn = false;
                    }
                    player1.position = newPos;
                } else {
                    System.out.println("No play");
                }

                System.out.println("Player 1 position: " + player1.position);

                if (player1.position == 100) {
                    System.out.println("Player 1 WINS!");
                    break;
                }
            } else {
                player2.noOfDiceRoll++;
                System.out.println("Player 2 roll : " + dice);
                if (player2.position + dice <= 100) {
                    player2.position += dice;
                    newPos = checkSnakeLadder(player2.position);
                    if (newPos > player2.position) {
                        System.out.println("You got ladder and roll dice again");
                        turn = true;
                    }
                    player2.position = newPos;
                } else {
                    System.out.println("No play");
                }
                System.out.println("Player 2 position: " + player2.position);

                if (player2.position == 100) {
                    System.out.println("Player 2 WINS!");
                    break;
                }
            }
            turn = !turn;
        }
        System.out.println("Game Over");
        System.out.println("Player 1 Dice Rolls: " + player1.noOfDiceRoll);
        System.out.println("Player 2 Dice Rolls: " + player2.noOfDiceRoll);
    }
}