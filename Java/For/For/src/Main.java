//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //        фигура 1. прямоугольник
        for (int i = 0; i < 10; i++) {
            System.out.println("* * * * *");
        }

//        фигура 2

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }


//фигура 3

        for (int i = 0; i < 6; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            System.out.println("*");
        }



        //    фигура 4
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j <i; j++) {
                System.out.print("  ");
                System.out.print("* ");
            }
            System.out.println();
        }



        //фигура 5

        for (int i = 7; i > 0; i--) {
            for (int j = 0; j <i; j++) {
                System.out.print("  ");
                System.out.print("* ");
            }

            System.out.println();
        }



//        треугольник

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= 10-i; j++) {
                System.out.print("  ");
            }
            for (int a = 1; a <= 2*i-1; a++) {
                System.out.print("* ");
            }
            System.out.println();
        }

//        ромб

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= 10-i; j++) {
                System.out.print("  ");
            }
            for (int a = 1; a <= 2*i-1; a++) {
                System.out.print("* ");
            }
            System.out.println();
        }for (int i = 10; i >1; i--) {
            for (int j = 0; j <= 10-i; j++) {
                System.out.print("  ");
            }
            for (int a = 1; a <= 2*i-1; a++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
