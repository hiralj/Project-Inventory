package inventory.dao;

public class RawSQL {

    public static String totalStock = String.join("\n",
            "SELECT grade, shape, size, size2, sum(Wt) as Weight FROM materialdomain md",
                    "INNER JOIN materialsuperdomain msd",
                    "ON md.id = msd.mid",
                    "INNER JOIN inventory",
                    "ON msd.MSID = inventory.MSID",
                    "GROUP BY MID",
                    "ORDER BY grade, shape, size, size2");
}
