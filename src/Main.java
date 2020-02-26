import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        createWorld();

    }



    public static void createWorld() {
        Scanner keyboardInput = new Scanner(System.in);
        Scanner keyboardInput2 = new Scanner(System.in);
        DiceCup diceCup = new DiceCup();

        System.out.println("How many player are going to play?");

        /*
        while (String input = keyboardInput.hasNextInt()) {
            System.out.println("hello");
            }
        if(keyboardInput.hasNextInt()) {
            System.out.println("ok you want to play" + keyboardInput. + "players");
           // int numberOfPlayers2 = keyboardInput.nextInt();
        }*/
        boolean correctInput = false;
        if (keyboardInput.hasNextInt()) {
            System.out.println("hello");
        }else {
            while(!keyboardInput.hasNextInt()) {
                System.out.println("not an int");
                System.out.println("How many player are going to play?");
              keyboardInput2.nextInt();
            }

        }
            if(!keyboardInput.hasNextInt()) {
                System.out.println("jgjhjgh");
                int numberOfPlayers = keyboardInput.nextInt();
                boolean error = true;
                while(error) {
                    System.out.println("thats not an int dude");
                    int numberOfPlayers2 = keyboardInput.nextInt();
                    if(keyboardInput.hasNextInt()) {
                        break;
                    }
                }


                }else {
                System.out.println("very cool thanks");

            }
        }
       /*
        if(keyboardInput.hasNextInt()) {
            System.out.println("ok you want to play" + keyboardInput. + "players");
            // int numberOfPlayers2 = keyboardInput.nextInt();
        }
        System.out.println("we are not out of loop");
        /*for (int i = 0; i < ; i++) {

        }

        Player player1 = new Player(scanned);

        System.out.println(terning1.getTerning());
        System.out.println(terning2.getTerning());*/

    }

