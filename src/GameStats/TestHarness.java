package GameStats;

import java.io.FileNotFoundException;

public class TestHarness {

    RandomNameGenerator RNG = new RandomNameGenerator();

    CustomPlayer playerOne = new CustomPlayer("Ricky Bobby");
    CustomPlayer playerTwo = new CustomPlayer();

    Team TheTeam = new CustomTeam("Wabba Wabbas");

    League TheLeague = new CustomLeague();

    public TestHarness() throws FileNotFoundException {

        System.out.println(playerOne.getPlayerName());
        System.out.println(playerTwo.getPlayerName());

        playerTwo.setPlayerPoints(15);
        playerOne.addPlayerPoints(10);
        System.out.println("PlayerOne: "+ playerOne.getPlayerPoints()+" PlayerTwo: " + playerTwo.getPlayerPoints());
        playerTwo.removePlayerPoints(3);
        playerOne.addPlayerPoints(6);
        System.out.println("PlayerOne: "+ playerOne.getPlayerPoints()+" PlayerTwo: " + playerTwo.getPlayerPoints());

        playerOne.addStat("MyStat", 0);
        playerOne.getStat("MyStat").setStatValue(5);
        System.out.print(playerOne.getStat("MyStat").getStatName()+": ");
        System.out.print(playerOne.getStat("MyStat").getStatValue());

        playerOne.addStat("MyOtherStat", 1);
        playerOne.getStat("MyOtherStat").setStatValue(4);
        playerOne.getStat("MyStat").addStatValue(3);

        System.out.println("\n == ADDED 3 to 'MyStat', SET 5 to 'MyOtherStat'");
        System.out.println("MyStat: "+playerOne.getStat("MyStat").getStatValue());
        System.out.println("MyOtherStat: "+playerOne.getStat("MyOtherStat").getStatValue());


        playerOne.getStat("MyStat").subtractStatValue(5);
        playerOne.getStat("MyOtherStat").addStatValue(2);

        System.out.println("\n == SUBTRACTED 5 from 'MyStat', ADDED 2 to 'MyOtherStat'");
        System.out.println("MyStat: "+playerOne.getStat("MyStat").getStatValue());
        System.out.println("MyOtherStat: "+playerOne.getStat("MyOtherStat").getStatValue());

        playerOne.addToAllStats(4);

        System.out.println("\n == ADDED 4 to ALL stats");
        System.out.println("\nMyStat: "+playerOne.getStat("MyStat").getStatValue());
        System.out.println("MyOtherStat: "+playerOne.getStat("MyOtherStat").getStatValue());

        playerOne.subtractFromAllStats(7);

        System.out.println("\n == SUBTRACTED 7 to ALL stats");
        System.out.println("\nMyStat: "+playerOne.getStat("MyStat").getStatValue());
        System.out.println("MyOtherStat: "+playerOne.getStat("MyOtherStat").getStatValue());

        TheTeam.addPlayer(playerOne);
        TheTeam.addPlayer(playerTwo);

        for(Player p : TheTeam){
            System.out.println(p.getPlayerName());
        }

        System.out.println(RNG.getTeamName());
        System.out.println((RNG.getPlayerName()));

        TheLeague.addTeam(TheTeam);
        for (Team t: TheLeague) {
            System.out.println(t.getTeamName());
        }

        System.out.println(RNG.getUserName());

        /*
        LnkList<GameStats.Player> list = TheTeam.getMembers();

        while (!list.offEnd()){
            System.out.println(list.get().getPlayerName());
            list.advance();
        }

         */

    }

    public static void main(String[] args) throws FileNotFoundException {
        new TestHarness();
    }
}
