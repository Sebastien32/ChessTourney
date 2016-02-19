public class Player
{
    private String username;
    private double rating;
    private double deviation;

    public Player(String username, double rating, double deviation)
    {
        this.username = username;
        this.rating = rating;
        this.deviation = deviation;
    }

    public String getName()
    {
        return username;
    }

    public double getRating()
    {
        return rating;
    }

    public double getDeviation()
    {
        return deviation;
    }
}
