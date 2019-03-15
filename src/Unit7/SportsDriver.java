package Unit7;

public class SportsDriver {
    public static void main(String[] args) {
        Sport soccer = new Soccer();
        Sport basketball = new Basketball();
        System.out.println("Number of soccer players: " + soccer.getPlayers());
        System.out.println("Number of basketball players: " + basketball.getPlayers());
    }
}
