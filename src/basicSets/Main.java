package basicSets;
import java.io.File;
import java.util.*;

public class Main {

    static class State {
        String name, abbr, capital;

        State(String name, String abbr, String capital) {
            this.name = name;
            this.abbr = abbr;
            this.capital = capital;
        }

        String getName() {
            return name;
        }

        String getAbbr() {
            return abbr;
        }

        String getCapital() {
            return capital;
        }

        @Override
        public String toString() {
            return "" + capital + "";
        }
    }

    static class Menu {
        static void userSelection(Map<String, State> refer) {
            System.out.println("\n======QUIZ=======");
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("\nType a US state name: ");
                String sName = input.nextLine();

                if (refer.containsKey(sName)) {
                    System.out.print("\nOK. That is an actual state. What is the capital of " + sName + " ? ");
                    String sCapital = input.nextLine();
                    String result = refer.get(sName).toString();

                    if (sCapital.equals(result)) {
                        System.out.println("CORRECT.");
                    } else {
                        System.out.println("INCORRECT, the professional answer is " + result);
                    }
                } else {
                    System.out.println("Either the word is misspelled or the state was not found in the DB" +
                            "\nPlease capitalize the first letter of every word ");
                }
            }
        }
    }

    static List<State> readingStatesFromFile() throws Exception {
        List<State> states = new ArrayList<>();
        Scanner sc = new Scanner(new File("states.txt"));

        while (sc.hasNextLine()) {
            states.add(new State(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        sc.close();

        return states;
    }

    static Map<String, State> getAllStateAnswers() throws Exception {
        List<State> states = readingStatesFromFile();
        Map<String, State> refer = new HashMap<>();

        String[] allStates = {"Alabama", "Alaska", "Arizona", "Arkansas",
                "California", "Colorado", "Connecticut", "Delaware", "Florida",
                "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
                "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
                "North Carolina", "North Dakota", "Ohio", "Oklahoma",
                "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
        };

        for (int i = 0; i < allStates.length; i++) {
            refer.put(allStates[i], states.get(i));
        }
        return refer;
    }

    static void beginQuiz() throws Exception {
        Map<String, State> refer = getAllStateAnswers();
        Menu.userSelection(refer);
    }


    public static void main(String[] args) throws Exception {
        beginQuiz();
    }
}
