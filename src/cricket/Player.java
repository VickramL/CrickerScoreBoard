package cricket;

public class Player {
    private String name;
    private int runs, balls, wickets, four, six, over;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalls() {
        return balls;
    }

    public int getRuns() {
        return runs;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void setWickets() {
        this.wickets++;
    }

    public void setBalls() {
        this.balls++;
    }

    public void setFour() {
        this.four++;
    }

    public void setSix() {
        this.six++;
    }

    public int getFour() {
        return four;
    }

    public int getSix() {
        return six;
    }

    public void setOver() {
        this.over++;
    }

    public int getOver() {
        return over;
    }
}
