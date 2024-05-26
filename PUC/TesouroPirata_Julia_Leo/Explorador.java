//- módulo:c01/def-estado/Explorador.java
import java.util.List;
import java.util.ArrayList;

class Explorador {
    List<String> s;
    Explorador () { // método construtor
        s = new ArrayList<> ();
    }

    Explorador tocar (String t) {
        if (t.equals ("CHA") && s.isEmpty ()) {
            s.add ("CHA");
            return this;
        }
        if (t.equals ("CHA") && s.get (0).equals ("CHA")) {
            return this;
        }
        if (t.equals ("BAÚ") && s.isEmpty ()) {
            return this;
        }
        if (t.equals ("BAÚ") && s.get (0).equals ("CHA")) {
            s.add ("BAÚ");
            return this;
        }
        System.out.println (t);
        System.out.println (s);
        throw new RuntimeException ("Transição inválida");
    }
}