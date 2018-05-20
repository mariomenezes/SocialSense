package analysis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteContagem {

    public static void main(String[] args) {

        @SuppressWarnings("serial")
        ArrayList<String> seussCountActivities = new ArrayList<String>() {
            {
                add("findow");
                add("Balloons");
                add("Elephants");
                add("Boom Bands");
                add("findow");
                add("Hakken-Kraks");
                add("Hakken-Kraks");
                add("Hakken-Kraks");
                add("Elephants");
            }
        };

        Map<String, Integer> seussCount = new HashMap<String, Integer>();
        for (String t : seussCountActivities) {
            Integer i = seussCount.get(t);
            if (i == null) {
                i = 0;
            }
            seussCount.put(t, i + 1);
        }

        System.out.println(seussCount);

        //int numberOfElephants = seussCount.get("Elephants");
        //assertEquals(2, numberOfElephants);
    }
}