public class Exception {
    public static void main(String[] args) {
        foo();
        try {
            bar();
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("ERROR 1");
        } catch (ArithmeticException ae) {
            System.out.println("ERROR 2");
        } finally {
            System.out.println("DONE");
        }
    }

    public static void foo() {
        // PROGRAM LINE A
   //    int arr = (new int[]{})[3];

        try {
//            System.out.println(1/0);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
            npe.printStackTrace();
        }
    }

    public static void bar() {
        // PROGRAM LINE C
    //  int formati = Integer.parseInt("Exception per formatin e numrit");
    //  int arr = (new int[] {})[3]; // DETYRA 8

        try {
            // PROGRAM LINE D
            methodX();
        } catch (NullPointerException npe) {
            System.out.println("ERROR 3");
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("ERROR 4");
        }
        System.out.println("DONE BAR");
    }

    public static void methodX() {
        // PROGRAM LINE E
     /*   String zbrast = null; 
        System.out.println(zbrast.length()); 
        String stoint = ((String) Integer.valueOf(7)); */

        try {
//            int arr = (new int[] {})[9];
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println(iobe.getMessage());
            iobe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("ERROR 5");
            return;
        } finally {
            System.out.println("DONE METHODX");
        }
    }
}


