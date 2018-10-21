package homeworks.HW.patterns;

import java.util.Arrays;
import java.util.List;

public class Sql {

    public static void main(String[] args) {
        Sql sql = new SqlBuilder().buildSelect(Arrays.asList("list", "list1"))
                .buildFrom("house")
                .build();
        System.out.println(sql.toString());

    }

    private List<String> select;
    private String update;
    private List<String> set;
    private String from;
    private String where;
    private String groupBy;

    public Sql(List<String> select, String update, List<String> set, String from, String where, String groupBy) {
        this.select = select;
        this.update = update;
        this.set = set;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
    }

    //
//    public Sql() {
//    }
//
//    public Sql setSelect(String select) {
//        this.select = select;
//        return this;
//    }
//
//    public Sql setParameters(List<String> parameters) {
//        this.parameters = parameters;
//        return this;
//    }
//
//
//    public Sql setFrom(String from) {
//        this.from = from;
//        return this;
//    }
//
//    public Sql setTable(String table) {
//        this.table = table;
//        return this;
//    }
//
//    public Sql setWhere(String where) {
//        this.where = where;
//        return this;
//    }
    @Override
    public String toString() {
        return "Sql{" +
                "select=" + select +
                ", update='" + update + '\'' +
                ", set=" + set +
                ", from='" + from + '\'' +
                ", where='" + where + '\'' +
                ", groupBy='" + groupBy + '\'' +
                '}';
    }
}

class SqlBuilder {
    private List<String> select;
    private String update;
    private List<String> set;
    private String from;
    private String where;
    private String groupBy;

//    public SqlBuilder() {
//    }

//    public SqlBuilder(String select, List<String> parameters, String from, String table, String where) {
//        this.select = select;
//        this.parameters = parameters;
//        this.from = from;
//        this.table = table;
//        this.where = where;
//    }

    public SqlBuilder buildSelect(List<String> select) {
        this.select = select;
        return this;
    }

    public SqlBuilder buildUpdate(String update) {
        this.update = update;
        return this;
    }

    public SqlBuilder buildFrom(String from) {
        this.from = from;
        return this;
    }

    public SqlBuilder buildSet(List<String> set) {
        this.set = set;
        return this;
    }

    public SqlBuilder buildWhere(String where) {
        this.where = where;
        return this;
    }

    public SqlBuilder builbGroupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public Sql build() {
        return new Sql(select, update, set, from, where, groupBy);
    }
}

