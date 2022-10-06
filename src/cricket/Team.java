package cricket;

import java.util.ArrayList;

public class Team {
    ArrayList<Player> playerList;
    private String teamName;
    private int score;
    private int wickets;

    Team(String teamName) {
        this.playerList = new ArrayList<>();
        this.teamName = teamName;
    }

    public String getTeamName() {
        
        return teamName;
    }

    public int getScore() {

        return score;
    }

    public int getWickets() {

        return wickets;
    }

    public void setWickets(Player bowler) {
        bowler.setWickets();
        this.wickets++;
    }

    public void setTeamScore(int score) {

        this.score += score;
    }

    public void setScore(Player batsman, int score) {
        batsman.addRuns(score);
        this.score += score;
    }

    public ArrayList<Player> getPlayerList() {

        return playerList;
    }

    public void addPlayers(Player player) {

        this.playerList.add(player);
    }

    public void addPlayers(ArrayList<Player> player) {

        this.playerList = player;
    }

    public void addPlayers(String[] player) {
        for (String playerName : player) {
            Player playerObj = new Player(playerName);
            this.playerList.add(playerObj);
        }

    }
}
