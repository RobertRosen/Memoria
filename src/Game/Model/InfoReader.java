package Game.Model;

import java.io.File;
import java.io.FileNotFoundException;       
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The class infopanel reads 2 textfiles and first puts them in two arraylist and then a hashmap.
 * @author Joakim Tell och Robert Rozencrantz
 * @version 1.0
 */
public class InfoReader {

    /**
     * Variables
     */
    private HashMap<String,String> infoMap = new HashMap();
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<String> arrayList2 = new ArrayList<>();
    private File file;
    private File file2;


    /**
     * Constructor
     * @param infoPanelFile reads the infopanelfile
     * @param symbolfile reads the symbolfile
     */
    public InfoReader(String infoPanelFile, String symbolfile) {
        file = new File(infoPanelFile);
        file2 = new File(symbolfile);
        readTextFile();
        readTextFile2();
        createHashMap();
    }

    /**
     * reads the the first infoPanel.txt file and puts it in an arraylist
     */
    private void readTextFile() {
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (input != null) {
            while (input.hasNext()) {
                String nextLine = input.nextLine();
                arrayList.add(nextLine);

            }
            input.close();
        }

    }

    /**
     * reads the the first symbol.txt file and puts it in an arraylist
     */
    private void readTextFile2() {
        Scanner input = null;
        try {
            input = new Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (input != null) {
            while (input.hasNext()) {
                String nextLine = input.nextLine();
                arrayList2.add(nextLine);

            }
            input.close();
        }

    }

    public void createHashMap() {
        for(int i = 0; i<arrayList2.size(); i++) {
            infoMap.put(arrayList2.get(i), arrayList.get(i));
        }
    }

    public void printline() {
        for(String line : arrayList2) {
            System.out.println(infoMap.get(line));
        }
    }

    public static void main(String[] args) {
        new InfoReader("textfiles/infopanel.txt","textfiles/symbol.txt").printline();
    }

    public HashMap<String, String> getInfoMap() {
        return infoMap;
    }
    /*
    När AL och AL matchas i boardgui behövs en metod som kollar vilka det är som matchats (AL & AL).
    Då behöver AL matchas med (AL i symbol.txt) och därefter hämta ut rätt info och visa det i infopanelen i boardgui.
    Använda metoden igen när kort matchas eller kalla på en metod?

     */

    public void showInfoTextOnPanel()
    {
//        String firstSymbol = gameController.getPairOfCards.toString();
//        String secondSymbol = pairOfCards[1].getPathSymbol().substring(0,9);
    }

}
