package GameStats;

public interface League extends Comparable<League>, Iterable<Team>{

    void setLeagueName(String s);

    String getLeagueName();

    void addTeam(Team t);

    void removeTeam(Team t);

    Team getTeam(String name);
}
