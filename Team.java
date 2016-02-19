import java.util.ArrayList;
public class Team
{
    private String teamName;
    private ArrayList<Player> teamPlayers= new ArrayList<Player>();

    public Team(String teamName, Player p1, Player p2, Player p3, Player p4, Player p5)
    {
        this.teamName = teamName;
        teamPlayers.add(p1);
        teamPlayers.add(p2);
        teamPlayers.add(p3);
        teamPlayers.add(p4);
        teamPlayers.add(p5);
    }

    public String getTeamName()
    {
        return teamName;
    }

    public Player getPlayerOne()
    {
        return teamPlayers.get(0);
    }
    public Player getPlayerTwo()
    {
        return teamPlayers.get(1);
    }
    public Player getPlayerThree()
    {
        return teamPlayers.get(2);
    }
    public Player getPlayerFour()
    {
        return teamPlayers.get(3);
    }
    public Player getPlayerFive()
    {
        return teamPlayers.get(4);
    }
}
