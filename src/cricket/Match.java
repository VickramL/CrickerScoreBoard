package cricket;

import java.util.Random;
import java.util.Scanner;

public class Match {
    Team team1, team2, bowlingTeam, battingTeam;

    public Match(String team1Name, String[] team1playerNames, String team2Name, String[] Team2PlayerNames) {
        this.team1 = new Team(team1Name);
        team1.addPlayers(team1playerNames);
        this.team2 = new Team(team2Name);
        team2.addPlayers(Team2PlayerNames);
    }

    public Team[] game() {

        // return a result
        Team[] result = new Team[2];
        // user input scanner class
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t~~ Toss~~\n (0)-Head or (1)-Tails");
        int toss = input.nextInt();

        // random toss generator
        Random random = new Random();
        int finalToss = random.nextInt(2);

        System.out.println("------------------------------------------------------------------");

        if (finalToss == toss) {
            System.out.println("!!! India won toss and choose to bat first !!!");
            battingTeam = team1;
            bowlingTeam = team2;
        } else {
            System.out.println("!!! Pakistan won toss and choose to bat first !!!");
            battingTeam = team2;
            bowlingTeam = team1;
        }
        System.out.println("Batting - " + battingTeam.getTeamName());
        System.out.println("Bowling - " + bowlingTeam.getTeamName());
        System.out.println("------------------------------------------------------------------");


        // over fix
        int fixOver = 0;

        // Match start loop
        while (true) {

            System.out.println("\n------------------------------------------------------------------");
            // match over fixing
            System.out.println("Choose over 2 or 5");
            int over =0;
            try {
                over = input.nextInt();
            }catch (Exception e){
                System.out.println("Overs must be numeric");
                input.nextLine();
            }
            // over check
            if (over == 5 || over == 2) {
                fixOver = over;
                break;
            }
        }

        System.out.println("------------------------------------------------------------------");



        // nextBowler, nextBatsman
        int nextBatsman = 2, nextBowler = 10;

        // innings 1st and 2nd batting
        for (int i = 0; i < 2; i++) {

            // Displaying Player List:
            System.out.println("\n\t"+battingTeam.getTeamName()+"'s Playing 11\n");

            for(Player player: battingTeam.playerList){
                System.out.println(" \t"+player.getName());
            }

            System.out.println();
            System.out.println("------------------------------------------------------------------\n");

            // over count and overTrace
            int overCount = 0, overTrace = 0;


            // choose batting team openers
            System.out.println(battingTeam.getTeamName() + " Openers !!!");
            Player striker = battingTeam.getPlayerList().get(0);
            System.out.println("Striker - " + striker.getName());
            Player nonStriker = battingTeam.getPlayerList().get(1);
            System.out.println("Non~Striker - " + nonStriker.getName());

            // choose bowler
            Player bowler = bowlingTeam.getPlayerList().get(10);
            System.out.println("bowler - " + bowler.getName());

            System.out.println("------------------------------------------------------------------");

            // ball count
            int ballCount = 0;

            while (true) {
                ballCount++;// ball count
                System.out.println("Enter run 0 to 6 --> out --> No ball --> Wide  ");
                char checkBall = input.next().charAt(0);
                if(!((checkBall >= '0' && checkBall <= '6') || checkBall =='o' || checkBall == 'n' ||
                        checkBall == 'w')){
                    System.out.println("Invalid input!...");

                }


                // check batsman out change the batsman
                if (checkBall == 'o') {

                    // setWickets
                    bowler.setWickets();
                    striker.setBalls();
                    System.out.println(
                            striker.getName() + " " + striker.getRuns() + "(" + striker.getBalls() + ")" + " - out ");
                    bowlingTeam.setWickets(bowler);


                    // only 10 batsman allow to batting
                    if (nextBatsman < 11) {
                        striker = battingTeam.getPlayerList().get(nextBatsman++);
                        System.out.println("Next batsman -" + striker.getName());
                        System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                bowlingTeam.getWickets());
                        System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                        System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+"("+
                                nonStriker.getBalls()+")\n");
                    } else {
                        System.out.println(battingTeam.getTeamName() + " All out");
                        break;
                    }

                }

                // check ball wide or no ball
                else if (checkBall == 'w' || checkBall == 'n') {

                    battingTeam.setTeamScore(1);
                    ballCount--;
                    if(checkBall == 'w') {
                        System.out.println("Wide !!!");
                        System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                bowlingTeam.getWickets());
                        System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                        System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+"("+
                                nonStriker.getBalls()+")\n");
                    }
                    else {
                        System.out.println("No Ball !!!");
                        System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                bowlingTeam.getWickets());
                        System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                        System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+"("+
                                nonStriker.getBalls()+")\n");
                    }

                }

                else {
                    // check input outOfrange
                    if (checkBall - 48 <= 6) {

                        if (checkBall % 2 == 0) {

                            battingTeam.setScore(striker, checkBall - 48);
                            striker.setBalls();// striker ballsCount
                            System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                    bowlingTeam.getWickets());
                            System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                            System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+"("+
                                    nonStriker.getBalls()+")\n");


                            if (checkBall - 48 == 4) {
                                System.out.println("Nice Shot!!!\nOne Bounce Over the Rope");
                                striker.setFour();
                                System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                        bowlingTeam.getWickets());
                                System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                                System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+"("+
                                        nonStriker.getBalls()+")\n");
                            } else if (checkBall - 48 == 6) {
                                striker.setSix();
                                System.out.println("There is biggieeeee !!!\nit's " + striker.getName() + " Special !!!");
                                System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                        bowlingTeam.getWickets());
                                System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                                System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+"("+
                                        nonStriker.getBalls()+")\n");
                            }

                        } else {
                            // System.out.println("odd run swap batsman");
                            battingTeam.setScore(striker, checkBall - 48);
                            striker.setBalls();
                            // change Player
                            Player temPlayer = striker;
                            striker = nonStriker;
                            nonStriker = temPlayer;
                            if (ballCount % 6 != 0)
                                System.out.print(battingTeam.getTeamName()+" - "+ battingTeam.getScore()+"/"+
                                        bowlingTeam.getWickets());
                                System.out.print("\t"+striker.getName()+" "+striker.getRuns()+"("+striker.getBalls()+")*");
                                System.out.println("\t"+nonStriker.getName()+" "+nonStriker.getRuns()+
                                        "("+nonStriker.getBalls()+")\n");
                        }

                    } else {
                        System.out.println("Run out Of range (0 - 6)");
                        ballCount--;
                    }

                }

                // overTrace
                if (ballCount % 6 == 0) {
                    overTrace++;
                    System.out.println("------------------------------------------------------------------");
                    System.out.println(overTrace + " ~ over");
                    // change bowler
                    if (fixOver != overTrace) {
                        bowler = bowlingTeam.getPlayerList().get(--nextBowler);
                        System.out.println("Next bowler - " + bowler.getName());
                        // after change over swap batsman
                        Player temPlayer = striker;
                        striker = nonStriker;
                        nonStriker = temPlayer;
                        System.out.println("Striker - " + striker.getName() + "\nNon-Striker - " + nonStriker.getName());
                    }

                }

                // over count to bowler
                if (ballCount % 6 == 0) {
                    bowler.setOver();
                }
                // check team or not
                if (i == 1)
                    if (battingTeam.getScore() > bowlingTeam.getScore()) {
                        result[0] = battingTeam;
                        result[1] = bowlingTeam;
                        break;
                    }

                // check over is end
                if (ballCount == fixOver * 6) {
                    result[0] = bowlingTeam;
                    result[1] = battingTeam;
                    break;
                }

            } // while loop end

            // 2nd innings start
            if (i == 0) {
                System.out.println("------------------------------------------------------------------");
                System.out.println(bowlingTeam.getTeamName() + "  target is :" + (battingTeam.getScore() + 1));
                System.out.println("2nd innings start ");
                // swap teams
                Team tempTeam = battingTeam;
                battingTeam = bowlingTeam;
                bowlingTeam = tempTeam;

            }

        } // for loop end

        // return result
        return result;
    }

}
