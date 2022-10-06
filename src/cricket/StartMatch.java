package cricket;

public class StartMatch {

    public static void main(String[] args) {

        String[] india = { "Rohit(c)", "Rahul", "Kohli", "Surya", "Hooda", "Pant(wk)", "Hardik", "Jaddu", "Bhuvi",
                "Chahal", "Harshadeep" };
        String[] pakistan = { "Babar(c)", "Rizwan(wk)", "Fakhar", "Nawaz", "Kushdil", "Asif", "Ifthikir", "Shadap",
                "Haris", "Hasnain", "Naseem" };

        Match match = new Match("IND", india, "PAK", pakistan);
        Team[] result = match.game();
        if (result == null)
            System.out.println("Match Tie");
        else {

            System.out
                    .println(result[0].getTeamName() + " won  ");
            System.out.println("----------------------------------------------------------");

            System.out.printf("%-15s%s\t%s\t%s\t%s\n", "Name", "Run", "Ball", "Four", "Six");

            for (Player p : result[0].getPlayerList())
                System.out.printf("%-15s\t%d \t %d\t\t%d\t\t%d\n", p.getName(), p.getRuns(), p.getBalls(), p.getFour(),
                        p.getSix());

            System.out.println("----------------------------------------------------------");

//            System.out.println(
//                    result[1].getTeamName() + " loose by " + (result[0].getScore() - result[1].getScore()) + " runs");

            System.out.println("----------------------------------------------------------");

            System.out.printf("%-15s%s\t%s\t%s\t%s\n", "Name", "Run", "Ball", "Four", "Six");
            for (Player p : result[1].getPlayerList())
                System.out.printf("%-15s\t%d \t %d\t\t%d\t\t%d\n", p.getName(), p.getRuns(), p.getBalls(), p.getFour(),
                        p.getSix());
        }



    }
}
