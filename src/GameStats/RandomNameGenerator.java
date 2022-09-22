package GameStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RandomNameGenerator {

   // FileReader nouns = new FileReader(
   //         "C:\\Users\\combe\\Desktop\\InteliJ Projects\\GameStats\\src\\.txt\\english-nouns.txt");

    File nounFile = new File(
            "C:\\Users\\combe\\Desktop\\InteliJ Projects\\GameStats\\src\\.txt\\english-nouns.txt");
    File adjFile = new File(
            "C:\\Users\\combe\\Desktop\\InteliJ Projects\\GameStats\\src\\.txt\\english-adjectives.txt");
    File firstNameFile = new File(
            "C:\\Users\\combe\\Desktop\\InteliJ Projects\\GameStats\\src\\.txt\\First-Names.txt");

    Scanner scanner;

    String[] nouns = new String[2000];
    String[] adjectives = new String[2000];
    String[] firstNames = new String[5000];


    public RandomNameGenerator() throws FileNotFoundException {

        scanner = new Scanner(nounFile);
        int i = 0;
        while (scanner.hasNext()){
            nouns[i] = scanner.next();
            i++;
        }
       // System.out.println("nouns: " + nouns[0]+ ", " + nouns[1] + ", " + nouns[2]);

        scanner = new Scanner(adjFile);
        i = 0;
        while (scanner.hasNext()){
            adjectives[i] = scanner.next();
            i++;
        }
        //System.out.println("Adjectives: " + adjectives[0]+ ", " + adjectives[1] + ", " + adjectives[2]);

        scanner = new Scanner(firstNameFile);
        i = 0;
        while (scanner.hasNext()){
            firstNames[i] = scanner.next();
            i++;
        }
    }

    public String getTeamName(){
        int ind1, ind2;
        String adj, noun;

        while (true){
            ind1 = Rand(0, 2000);
            ind2 = Rand(0, 2000);
            if (adjectives[ind1] != null && nouns[ind2] != null){
                adj = Capitalize(adjectives[ind1]);
                noun = Capitalize(nouns[ind2]);
                return "The " + adj + " " + noun;
            }
        }

    }

    public String getPlayerName(){
        int ind1, ind2;
        String adj, name;

        while (true){
            ind1 = Rand(0, 2000);
            ind2 = Rand(0, 5000);
            if (adjectives[ind1] != null && firstNames[ind2] != null){
                adj = Capitalize(adjectives[ind1]);
                name = firstNames[ind2];
                return adj + " " + name;
            }
        }
    }

    public  String getUserName(){
        int ind1, ind2;
        String adj, noun;

        while (true){
            ind1 = Rand(0, 2000);
            ind2 = Rand(0, 2000);
            if (adjectives[ind1] != null && nouns[ind2] != null){
                adj = Capitalize(adjectives[ind1]);
                noun = Capitalize(nouns[ind2]);
                return adj + noun + Rand(1, 1000);
            }
        }
    }

    private int Rand(int min, int max){
        return (int)((max-min)*Math.random())+min;
    }

    private String Capitalize(String w){
        String result = "";
        char[] lowLet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] capLet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] let = w.toCharArray();

        for (int i = 0; i < lowLet.length; i++){
            if (let[0] == lowLet[i] || let[0] == capLet[i]){
                let[0] = capLet[i];
            }
        }
        for(int i = 0; i < w.length(); i++){
            result += let[i];
        }
        return result;
    }
}
