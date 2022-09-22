package GameStats;

import Collections.LnkList;

import java.io.Serializable;
import java.util.Iterator;

public class CustomLeague implements League, Serializable {

    private final static long SerialVersionUID = 10004l;

    private String leagueName;
    private int numTeams;

    private LnkList<Team> teams;

    public CustomLeague(){
        this("Default");
    }

    public CustomLeague(String name){
        leagueName = name;
        numTeams = 0;
        teams = new LnkList<>();
    }

    @Override
    public void setLeagueName(String s) {
        leagueName = s;
    }

    @Override
    public String getLeagueName() {
        return leagueName;
    }

    @Override
    public void addTeam(Team t) {
        teams.add(t);
        numTeams++;
    }

    @Override
    public void removeTeam(Team t) {
        teams.toFront();

        while (!teams.offEnd()){
            if (teams.get().compareTo(t) == 0){
                teams.remove();
                numTeams--;
            }
            teams.advance();
        }
    }

    @Override
    public Team getTeam(String name) {
        teams.toFront();
        while (!teams.offEnd()){
            if (teams.get().getTeamName().compareTo(name) == 0){
                return teams.get();
            }
            teams.advance();
        }
        return null;
    }


    @Override
    public int compareTo(League o) {
        return this.getLeagueName().compareTo(o.getLeagueName());
    }

    @Override
    public Iterator<Team> iterator() {
        return new TeamIterator(teams);
    }
}
