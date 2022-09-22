package GameStats;

import Collections.LnkList;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Iterator;

public class CustomTeam implements Team, Serializable {

    private final static long SerialVersionUID = 10003l;

    private String teamName;
    private int teamScore, numPlayers;
    private LnkList<Player> members; //TODO Modify to take GameStats.Player
    RandomNameGenerator RNG;


    public CustomTeam() throws FileNotFoundException {
        RNG = new RandomNameGenerator();
        teamName = RNG.getTeamName();
        numPlayers = 0;
        teamScore = 0;
        members = new LnkList<>();
    }

    public CustomTeam(String name){
        teamName = name;
        numPlayers = 0;
        teamScore = 0;
        members = new LnkList<>();
    }
    @Override
    public void setTeamName(String name) {
        teamName = name;
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void addPlayer(CustomPlayer p) {
        members.add(p);
        numPlayers++;
    }

    @Override
    public void removePlayer(CustomPlayer p) {
        members.toFront();

        while (!members.offEnd()){
            if (members.get().compareTo(p) == 0) {
                members.remove();
                numPlayers--;
                return;
            }
                members.advance();
        }
    }

    @Override
    public Player getPlayer(String pName) {
        members.toFront();

        while (!members.offEnd()){
            if (members.get().getPlayerName().equals(pName)) {
                return members.get();
            }
            members.advance();
        }
        return null;
    }

    @Override
    public void setTeamScore(int s) {
        teamScore = s;
    }

    @Override
    public int getTeamScore() {
        return teamScore;
    }

    @Override
    public void addTeamStat(CustomStat c) {
        members.toFront();

        while (!members.offEnd()){
            members.get().addStat(c);
            members.advance();
        }
    }

    @Override
    public void removeTeamStat(CustomStat c) {
        members.toFront();

        while (!members.offEnd()){
            members.get().removeStat(c);
            members.advance();
        }
    }

    //TODO create Iterator to iterate through Players on GameStats.Team
    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator(members);
    }

    @Override
    public int compareTo(Team o) {
        return this.getTeamName().compareTo(o.getTeamName());
    }


    private String RandomName(){
        String result = "";
        return result;
    }
}
