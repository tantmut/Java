package del;


public enum Color {

    d ("Nazar");

      static   String code;



      Color(String s) {
    }

     private void valueOf(){

    }

    public static void main(String[] args) {

        Color[] values = Color.values();
        System.out.println(values[0].toString());

    }
}
