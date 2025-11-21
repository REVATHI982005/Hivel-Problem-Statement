import java.math.BigInteger;
import java.nio.file.*;
import java.util.*;

class Poly {

    List<BigInteger> c;

    Poly() {
        c = new ArrayList<>();
        c.add(BigInteger.ONE); // constant polynomial 1
    }

    Poly(List<BigInteger> list) {
        c = list;
    }

    // Multiply current polynomial by (x - r)
    Poly multiply(BigInteger r) {
        List<BigInteger> next = new ArrayList<>();

        next.add(c.get(0).negate().multiply(r));

        for (int i = 1; i < c.size(); i++) {
            next.add(c.get(i - 1).add(c.get(i).negate().multiply(r)));
        }

        next.add(c.get(c.size() - 1));

        return new Poly(next);
    }
}

public class PolynomialRoots {

    // Convert base-s value into BigInteger
    static BigInteger convert(String value, int base) {
        return new BigInteger(value, base);
    }

    // Simple JSON parser for your specific input format
    static Map<String, String> getObject(String json, String key) {
        Map<String, String> m = new HashMap<>();

        int start = json.indexOf("\"" + key + "\"");
        if (start == -1)
            return m;

        int brace = json.indexOf("{", start);
        int end = json.indexOf("}", brace);

        String block = json.substring(brace + 1, end);

        String[] lines = block.split(",");

        for (String s : lines) {
            s = s.trim();
            if (!s.contains(":"))
                continue;

            String[] kv = s.split(":");
            String k = kv[0].replace("\"", "").trim();
            String v = kv[1].replace("\"", "").trim();
            m.put(k, v);
        }
        return m;
    }

    public static void main(String[] args) throws Exception {

        String json = Files.readString(Paths.get("input.json"));

        // Parse keys
        Map<String, String> keys = getObject(json, "keys");
        int n = Integer.parseInt(keys.get("n"));
        int k = Integer.parseInt(keys.get("k"));

        List<BigInteger> roots = new ArrayList<>();

        // Parse roots
        for (int i = 1; i <= n; i++) {
            String key = String.valueOf(i);
            Map<String, String> obj = getObject(json, key);
            if (obj.isEmpty())
                continue;

            BigInteger val = convert(obj.get("value"), Integer.parseInt(obj.get("base")));
            roots.add(val);
        }

        // Build polynomial product
        Poly p = new Poly();
        for (int i = 0; i < k; i++) {
            p = p.multiply(roots.get(i));
        }

        // Output
        System.out.println("Final coefficients:");
        for (BigInteger coef : p.c) {
            System.out.println(coef);
        }
    }
}
