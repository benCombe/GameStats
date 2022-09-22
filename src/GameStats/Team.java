package GameStats;

public interface Team extends Comparable<Team>, Iterable<Player> {


    void setTeamName(String name);

    String getTeamName();

    void addPlayer(CustomPlayer p);

    void removePlayer(CustomPlayer p);

    //takes player name (String) returns player of same name
    Player getPlayer(String pName);

    void setTeamScore(int s);

    int getTeamScore();

    void addTeamStat(CustomStat c);

    void removeTeamStat(CustomStat c);


}
