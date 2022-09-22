package GameStats;

public interface Player extends Comparable<Player>, Iterable<Stat>{

    public void setPlayerName(String name);

    public String getPlayerName();

    public void setPlayerPoints(int s);

    public int getPlayerPoints();

    void addPlayerPoints(int n);

    void removePlayerPoints(int n);

    void addStat(String statName, int statType);

    void addStat(CustomStat c);

    Stat getStat(String name);

    void removeStat(CustomStat c);

    void addToAllStats(int n);

    void subtractFromAllStats(int n);

}
