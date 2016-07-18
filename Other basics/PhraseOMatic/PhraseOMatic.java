package defaultpackage;

/**
 * Created by Gav on 23-Oct-15.
 */
public class PhraseOMatic {
    public static void main (String[] args) {
        String[] wordListOne = {"24/7", "win-win", "smart", "what", "There we go", "dynamic"};

        String[] wordListTwo = {"empowered", "sticky", "clustered", "experienced", "focused", "winner"};

        String[] wordListThree = {"process", "solution", "strategy", "space", "vision", "paradigm"};

        // Find out how many words are in each list:
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength= wordListThree.length;

        // Generate three random numbers:
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLength);

        // Building a phrase:
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        // Print out phrase:
        System.out.println("What we need is a " + phrase);
    }
}
