import java.util.ArrayList;
import java.util.Scanner;
public class Main
{
    public static void main(String []args)
    {
        Scanner in = new Scanner(System.in);
        String input;
        ArrayList<String> team1Array = new ArrayList<String>();
        ArrayList<String> team2Array = new ArrayList<String>();
        System.out.println("Enter the name of team one");
        input = in.next();
        team1Array.add(input);
        for(int i = 1; i <= 5; i++)
        {
            System.out.println("Enter the name of the player on board " + i + " for " + team1Array.get(0));
            input = in.next();
            team1Array.add(input);
            System.out.println("Enter the rating of the player on board " + i + " for " + team1Array.get(0));
            input = in.next();
            team1Array.add(input);
            System.out.println("Enter the deviation of the player on board " + i + " for " + team1Array.get(0));
            input = in.next();
            team1Array.add(input);
        }
        System.out.println("Enter the name of team two");
        input = in.next();
        team2Array.add(input);
        for(int j = 1; j <= 5; j++)
        {
            System.out.println("Enter the name of the player on board " + j + " for " + team2Array.get(0));
            input = in.next();
            team2Array.add(input);
            System.out.println("Enter the rating of the player on board " + j + " for " + team2Array.get(0));
            input = in.next();
            team2Array.add(input);
            System.out.println("Enter the deviation of the player on board " + j + " for " + team2Array.get(0));
            input = in.next();
            team2Array.add(input);
        }
        Team teamOne = new Team(team1Array.get(0),
                                new Player(team1Array.get(1), Double.parseDouble(team1Array.get(2)), Double.parseDouble(team1Array.get(3))),
                                new Player(team1Array.get(4), Double.parseDouble(team1Array.get(5)), Double.parseDouble(team1Array.get(6))),
                                new Player(team1Array.get(7), Double.parseDouble(team1Array.get(8)), Double.parseDouble(team1Array.get(9))),
                                new Player(team1Array.get(10), Double.parseDouble(team1Array.get(11)), Double.parseDouble(team1Array.get(12))),
                                new Player(team1Array.get(13), Double.parseDouble(team1Array.get(14)), Double.parseDouble(team1Array.get(15))));
        Team teamTwo = new Team(team2Array.get(0),
                                new Player(team2Array.get(1), Double.parseDouble(team2Array.get(2)), Double.parseDouble(team2Array.get(3))),
                                new Player(team2Array.get(4), Double.parseDouble(team2Array.get(5)), Double.parseDouble(team2Array.get(6))),
                                new Player(team2Array.get(7), Double.parseDouble(team2Array.get(8)), Double.parseDouble(team2Array.get(9))),
                                new Player(team2Array.get(10), Double.parseDouble(team2Array.get(11)), Double.parseDouble(team2Array.get(12))),
                                new Player(team2Array.get(13), Double.parseDouble(team2Array.get(14)), Double.parseDouble(team2Array.get(15))));
        System.out.printf("%-30s %30s %n", teamOne.getTeamName(), teamTwo.getTeamName());
        System.out.printf("%-30s %30s %n",
                          teamOne.getPlayerOne().getName() + "     " + teamOne.getPlayerOne().getRating() + "\u00B1" + teamOne.getPlayerOne().getDeviation(),
                          teamTwo.getPlayerOne().getRating() + "\u00B1" + teamTwo.getPlayerOne().getDeviation() + "     " + teamTwo.getPlayerOne().getName());

        // stores the score for team one
        int teamOneScore = 0;
        // stores the score for team two
        int teamTwoScore = 0;
        // odds of team one player winnig, drawing, or losing at board one
        double[] boardOneOdds = {0, 0, 1};
        // odds of team one player winnig, drawing, or losing at board two
        double[] boardTwoOdds = {.416, 0.1, .484};
        // odds of team one player winnig, drawing, or losing at board three
        double[] boardThreeOdds = {1, 0, 0};
        // odds of team one player winnig, drawing, or losing at board four
        double[] boardFourOdds = {.371, 0.1, .529};
        // odds of team one player winnig, drawing, or losing at board five
        double[] boardFiveOdds = {.576, 0.1, .324};
        /*
         * stores the results of the simulations:
         * first position = 0-10, second position = 1-9, third position = 2-8
         * fourth position = 3-7, fifth position = 4-6, sixth position = 5-5
         * seventh position = 6-4, eigth position = 7-3, ninth position = 8-2
         * tenth position = 9-1, eleventh position = 10-0
        */
        int[] results = new int[11];
        // number of trials to run
        final int NUMBER_OF_TRIALS = (int)Math.pow(10, 2);
        // holds random number
        double random;
        // runs the trials
        for(long i = 0; i < NUMBER_OF_TRIALS; i++)
        {
            // set the scores for both teams to zero
            teamOneScore = 0;
            teamTwoScore = 0;
            // generate a random number
            random = Math.random();
            // simulate game 1
            if(random < boardOneOdds[0])
            {
                teamOneScore += 2;
            }
            else if(random < (boardOneOdds[0] + boardOneOdds[1]))
            {
                teamOneScore += 1;
                teamTwoScore += 1;
            }
            else
            {
                teamTwoScore += 2;
            }
            // gnenerate a different random number for game 2
            random = Math.random();
            // simulate game 2
            if(random < boardTwoOdds[0])
            {
                teamOneScore += 2;
            }
            else if(random < (boardTwoOdds[0] + boardTwoOdds[1]))
            {
                teamOneScore += 1;
                teamTwoScore += 1;
            }
            else
            {
                teamTwoScore += 2;
            }
            // generate a random number for game 3
            random = Math.random();
            // simulate game 3
            if(random < boardThreeOdds[0])
            {
                teamOneScore += 2;
            }
            else if(random < (boardThreeOdds[0] + boardThreeOdds[1]))
            {
                teamOneScore += 1;
                teamTwoScore += 1;
            }
            else
            {
                teamTwoScore += 2;
            }
            // generate a random number for game 4
            random = Math.random();
            // simulate game 4
            if(random < boardFourOdds[0])
            {
                teamOneScore += 2;
            }
            else if(random < (boardFourOdds[0] + boardFourOdds[1]))
            {
                teamOneScore += 1;
                teamTwoScore += 1;
            }
            else
            {
                teamTwoScore += 2;
            }
            // generate a random number for game 5
            random = Math.random();
            // simulate game 5
            if(random < boardFiveOdds[0])
            {
                teamOneScore += 2;
            }
            else if(random < (boardFiveOdds[0] + boardFiveOdds[1]))
            {
                teamOneScore += 1;
                teamTwoScore += 1;
            }
            else
            {
                teamTwoScore += 2;
            }
            // if there was an error simulating the games somehow, print an error report
            if(!((teamOneScore + teamTwoScore) == 10))
            {
                System.out.println("Error: Sum of scores equal to " + (teamOneScore + teamTwoScore));
            }
            // record the results in the results array
            if(teamOneScore == 0)
            {
                results[0]++;
            }
            if(teamOneScore == 1)
            {
                results[1]++;
            }
            if(teamOneScore == 2)
            {
                results[2]++;
            }
            if(teamOneScore == 3)
            {
                results[3]++;
            }
            if(teamOneScore == 4)
            {
                results[4]++;
            }
            if(teamOneScore == 5)
            {
                results[5]++;
            }
            if(teamOneScore == 6)
            {
                results[6]++;
            }
            if(teamOneScore == 7)
            {
                results[7]++;
            }
            if(teamOneScore == 8)
            {
                results[8]++;
            }
            if(teamOneScore == 9)
            {
                results[9]++;
            }
            if(teamOneScore == 10)
            {
                results[10]++;
            }
            // Print out a progress report while running the trials
            if((i % (NUMBER_OF_TRIALS / 10)) == 0)
            {
                System.out.print((100 * i / NUMBER_OF_TRIALS) + "% ");
            }
        }
        // print out a completion statement
        System.out.println("Complete");
        // print out the likelihood of all possible results
        System.out.println("0.0-5.0 " + results[0] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("0.5-4.5 " + results[1] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("1.0-4.0 " + results[2] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("1.5-3.5 " + results[3] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("2.0-3.0 " + results[4] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("2.5-2.5 " + results[5] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("3.0-2.0 " + results[6] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("3.5-1.5 " + results[7] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("4.0-1.0 " + results[8] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("4.5-0.5 " + results[9] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("5.0-0.0 " + results[10] / (NUMBER_OF_TRIALS / 100.0) + "%");
        // calculate the total chances of losing
        int lossSum = results[0] + results[1] + results[2] + results[3] + results[4];
        // calculate the total change of winning
        int winSum = results[6] + results[7] + results[8] + results[9] + results[10];
        // print the summary statistics
        System.out.println("Total chance of loss: " + lossSum / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("Total chance of draw: " + results[5] / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("Total chance of win: " + winSum / (NUMBER_OF_TRIALS / 100.0) + "%");
        System.out.println("Total percentage sum: " + (lossSum + results[5] + winSum) / (NUMBER_OF_TRIALS / 100.0) + "%");
    }
}
