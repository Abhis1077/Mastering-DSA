import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TicketItenary {
    
    public static void ItenaryPrint(HashMap<String,String> tickets){
        HashSet<String> desti = new HashSet<>();
        String strt = "";

        for (String key : tickets.keySet()) {
            desti.add(tickets.get(key));
        }
        for (String key : tickets.keySet()) {
            if(!desti.contains(key)){
                strt = key;
                break;
            }
        }
        System.out.print(strt);
        for (String key : tickets.keySet()) {
            
            System.out.print(" -> " + tickets.get(strt));
            strt = tickets.get(strt);
        }

    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        ItenaryPrint(tickets);

    }
}
