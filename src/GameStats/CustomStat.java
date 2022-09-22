package GameStats;

import java.io.Serializable;

public class CustomStat implements Stat, Serializable {

    private final static long SerialVersionUID = 10001l;

    private String statName;
    private int statType, statValue;

    public CustomStat(){
        this("Default", 0);
    }

    public CustomStat(String name, int type){
        statName = name;
        statType = type;

        if (statType == 0)
            statValue = 0;
        else {
            statValue = 100;
        }
    }


    @Override
    public void setStatName(String name) {
        statName = name;
    }

    @Override
    public String getStatName() {
        return statName;
    }

    @Override
    public void setStatType(int n) {
        if (n < 2 && n >= 0)
            statType = n;
    }

    @Override
    public void setStatValue(int n) {
        statValue = n;
    }

    @Override
    public int getStatValue() {
        return statValue;
    }

    @Override
    public void addStatValue(int n) {
        statValue = statValue + n;
    }

    @Override
    public void subtractStatValue(int n) {
        statValue = statValue - n;
    }

    @Override
    public int compareTo(Stat o) {
        return this.getStatName().compareTo(o.getStatName());
    }
}
