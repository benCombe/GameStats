package GameStats;

public interface Stat extends Comparable<Stat> {

    void setStatName(String name);

    String getStatName();

    //type 0 - points
    //type 1 - percentage
    void setStatType(int n);

    void setStatValue(int n);

    int getStatValue();

    void addStatValue(int n);

    void subtractStatValue(int n);



}
