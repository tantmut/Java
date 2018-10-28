package homeworks.HW.patterns;

import java.util.*;

public class Sql {

    public static void main(String[] args) {
        UpdateBuilder builder = new UpdateBuilder();

        WhereObject whereObject =
                new WhereObject("country", "==", "'Canada'", "AND");

        WhereObject whereObject1 =
                new WhereObject("numberOfHome", "==", "3", "OR");
        WhereObject whereObject2 =
                new WhereObject("age", ">=", "25", null);

        List<Map.Entry> columns = Arrays.asList(Map.entry("nazar", "bazar"),
                Map.entry("nazar1", "bazar1"));

        builder.buildTable("Man").buildSet(columns);

        System.out.println(builder.build());

        SelectBuilder builder1 = new SelectBuilder();

        builder1.buildFrom(Arrays.asList("count(*)", "nazar", "bazar"))
                .buildTable("city")
                .buildWhere(Arrays.asList(whereObject, whereObject1, whereObject2));

        System.out.println(builder1.build());

    }
}

class SelectBuilder {

    private StringBuilder builder;

    public SelectBuilder() {
        builder = new StringBuilder("Select ");
    }

    public SelectBuilder buildFrom(List<String> parametrs) {
        parametrs.forEach(f ->
        {
            builder.append(f);
            if (!parametrs.get(parametrs.size() - 1).equals(f))
                builder.append(", ");
        });
        builder.append(" FROM ");
        return this;
    }

    public SelectBuilder buildTable(final String table) {
        builder.append(table);
        return this;
    }

    public SelectBuilder buildGroupBy(final List<String> parametrs) {
        builder.append(" group by ");
        parametrs.forEach(f ->
        {
            builder.append(f);
            if (!parametrs.get(parametrs.size() - 1).equals(f))
                builder.append(", ");
        });
        return this;
    }

    public SelectBuilder buildWhere(final List<WhereObject> parametrs) {

        builder.append(" where ");
        parametrs.forEach(f ->
        {
            builder.append(f.getParam1()).append(f.getCompare())
                    .append(f.getParam2()).append(" ");
            if(!(f.getStatement() == null))
                builder.append(f.getStatement()).append(" ");

          });
        return this;
    }

    public String build() {
        return builder.toString();
    }

}

class UpdateBuilder {
    private StringBuilder builder;

    public UpdateBuilder() {
        builder = new StringBuilder("UDPATE ");
    }

    public UpdateBuilder buildTable(String table) {
        builder.append(table).append(" SET ");

        return this;
    }

    public UpdateBuilder buildSet(List<Map.Entry> columns) {

        List<AbstractMap.Entry> revert = columns;

        revert.forEach(k -> {
            builder.append(k.getKey()).append(" = ").append(k.getValue());
            if (!revert.get(revert.size() - 1).equals(k))
                builder.append(", ");
        });


        return this;

    }

    public String build() {
        return builder.toString();
    }


}

class WhereObject {

    private String param1;
    private String compare;
    private String param2;
    private String statement;

    public String getParam1() {
        return param1;
    }

    public String getCompare() {
        return compare;
    }

    public String getParam2() {
        return param2;
    }

    public String getStatement() {
        return statement;
    }

    public WhereObject(String param1, String compare, String param2, String statement) {
        this.param1 = param1;
        this.compare = compare;
        this.param2 = param2;
        this.statement = statement;
    }
}
