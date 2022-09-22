package GameStats;

import Collections.LnkList;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Iterator;

public class CustomPlayer implements Player, Serializable{

    private final static long SerialVersionUID = 10002l;

    private String playerName;
    private int points, numStats;
    private LnkList<Stat> stats; //TODO Modify to take GameStats.Stat

    RandomNameGenerator RNG;


    public CustomPlayer() throws FileNotFoundException {
        RNG = new RandomNameGenerator();
        playerName = RNG.getPlayerName();
        points = 0;
        stats = new LnkList<>();
    } //TODO add random name generator

    public CustomPlayer(String name){
        playerName = name;
        points = 0;
        stats = new LnkList<>();
    }

    @Override
    public void setPlayerName(String name) {
        playerName = name;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void setPlayerPoints(int s) {
        points = s;
    }

    @Override
    public int getPlayerPoints() {
        return points;
    }

    @Override
    public void addPlayerPoints(int n){
        points = points + n;
    }

    @Override
    public void removePlayerPoints(int n){
        points = points - n;
    }

    @Override
    public void addStat(String statName, int statType) {
        stats.add(new CustomStat(statName,statType));
        numStats++;
    }

    @Override
    public void addStat(CustomStat c) {
        stats.add(c);
        numStats++;
    }

    @Override
    public Stat getStat(String name) {
        stats.toFront();

        while (!stats.offEnd()){
            if (stats.get().getStatName().equals(name))
                return stats.get();
            stats.advance();
        }
        return null;
    }

    @Override
    public void removeStat(CustomStat c) {
        stats.toFront();

        while (!stats.offEnd()){
            if (stats.get().compareTo(c) == 0) {
                stats.remove();
                numStats--;
            }
            else
                stats.advance();
        }
    }

    @Override
    public void addToAllStats(int n) {
        stats.toFront();
        while(!stats.offEnd()){
            stats.get().addStatValue(n);
            stats.advance();
        }
    }

    @Override
    public void subtractFromAllStats(int n) {
        stats.toFront();
        while(!stats.offEnd()){
            stats.get().subtractStatValue(n);
            stats.advance();
        }
    }

    @Override
    public int compareTo(Player o) {
        return this.getPlayerName().compareTo(o.getPlayerName());
    }

    @Override
    public Iterator<Stat> iterator() {
        return new StatIterator(stats);
    }
}
