//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// While
//Прямоугольник
//
// int x = 0;
// while (x<=10){
//     System.out.println("* * * * *");
//     x++;
// }

// Фигура 2

//  int x=8;
//  int y=0;
//  while (y<x) {
//      int z = 0;
//      while (z < y) {
//          System.out.print(" ");
//      z++;
//  }
//      System.out.println("*");
//      y++;
// }
        
//Фигура 3
//        int x=8;
//        int y=0;
//        while (y<x) {
//            int z = x-1-y;
//            int c = 0;
//            while (c < z) {
//                System.out.print(" ");
//                c++;
//            }
//            System.out.println("*");
//            y++;
//        }

// Треугольник 1
//      int x =8;
//      int y = x;
//        while (y > 0){
//          for (int i = 0; i < y; i++) {
//                   System.out.print("* ");
//               }
//               System.out.println();
//               y--;
//               x--;
//           }


//Треугольник   2
//        int x = 8;
//        int y = 1;
//        while (x > 0) {
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//            }
//            for (int i = 0; i < x - 1; i++) {
//                System.out.print(" ");
//            }
//            System.out.println();
//            y++;
//            x--;
//        }


// Треугольник 3
//
//        int x = 8;
//        int y = 1;
//        while (x>0) {
//            for (int i = 0; i < x-1; i++) {
//                System.out.print(" ");
//
//            }
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//
//            }
//
//            System.out.println();
//            y++;
//            x--;
//
//        }

//Ромб
//        int x = 5;
//        int y = 1;
//        while (x>0) {
//            for (int i = 0; i < x-1; i++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//            y++;
//            x--;
//        }
//        y=5;
//        while (x<= 5 ) {
//            for (int i = 0; i < x; i++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//            y--;
//            x++;
//        }

// Do while
//Прямоугольник
//int x = 0;
// do  {
//     System.out.println("* * * * *");
//     x++;
// }
//  while (x<=10);

// Фигура 2
//   int x=8;
//  int y=0;
//  do {
//      int z = 0;
//      while (z < y) {
//          System.out.print(" ");
//      z++;
//  }
//      System.out.println("*");
//      y++;
// }
//    while (y<x);

//Фигура 3
//        int x=8;
//        int y=0;
//       do {
//            int z = x-1-y;
//            int c = 0;
//            while (c < z) {
//                System.out.print(" ");
//                c++;
//            }
//            System.out.println("*");
//            y++;
//        }
//        while (y<x);

        // Треугольник 1
//      int x =8;
//      int y = x;
//      do {
//          for (int i = 0; i < y; i++) {
//                   System.out.print("* ");
//               }
//               System.out.println();
//               y--;
//               x--;
//           }
//        while (y > 0);

//Треугольник   2
//        int x = 8;
//        int y = 1;
//        do {
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//            }
//            for (int i = 0; i < x - 1; i++) {
//                System.out.print(" ");
//            }
//            System.out.println();
//            y++;
//            x--;
//        }
//        while (x > 0);


// Треугольник 3
////
//        int x = 8;
//        int y = 1;
//        do {
//            for (int i = 0; i < x-1; i++) {
//                System.out.print(" ");
//
//            }
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//
//            }
//
//            System.out.println();
//            y++;
//            x--;
//
//        }
//        while (x>0);

//Ромб   не понимаю, как сделат ьтак, чтобы линия в середине не повторялась
//        int x = 5;
//        int y = 1;
//        do  {
//            for (int i = 0; i < x-1; i++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//            y++;
//            x--;
//        } while (x>0);
//        y=5;
//       do   {
//            for (int i = 0; i < x; i++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < y; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//            y--;
//            x++;
//        } while (x<= 5 );

//Только границы фигур
//Прямоугольник
//        for (int i = 0; i <= 7; i++) {
//             if (i==0){
//                 System.out.println("* * * * *");
//             }
//             if (i == 7)   {
//                 System.out.println("* * * * *");
//                 break;
//             }
//            System.out.println("*       *");
//        }
        // Фигура 2

//  int x=8;
//  int y=0;
//  while (y<x) {
//      int z = 0;
//      while (z < y) {
//          System.out.print(" ");
//      z++;
//  }
//      System.out.println("*");
//      y++;
// }

//Фигура 3
//        int x=8;
//        int y=0;
//        while (y<x) {
//            int z = x-1-y;
//            int c = 0;
//            while (c < z) {
//                System.out.print(" ");
//                c++;
//            }
//            System.out.println("*");
//            y++;
//        }
// Треугольник 1
//        int x = 6;
//        for (int i = 1; i <= x; i++) {
//            for (int j = 0; j <= x-i; j++) {
//                System.out.print("  ");
//            }
//            if(i==1 || i==x) {
//                for (int a = 1; a <= 2 * i - 1; a++) {
//                    System.out.print("* ");
//                }
//            } else {
//                    System.out.print("*");
//                    for (int a = 0; a <= 2*i-3 ; a++) {
//                        System.out.print("  ");
//                    }
//                System.out.print("* ");
//            }
//
//            System.out.println();
//        }

//Треугольник   2

//        int x = 5;
//        for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= x; j++) {
//                if (j == 1 || j == i || i == x) {
//                    System.out.print("* ");
//                } else if(j > i && j < x + 1 - i) {
//                    System.out.print("  ");
//                }
//                else {
//                    System.out.print("  ");
//                }
//
//            }
//            System.out.println();
//        }
// Треугольник 3
//         int x = 5;
//        for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= x; j++) {
//                if (j == x || j == x - i + 1 || i == x) {
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }
//Ромб  не понимаю, как убрать полоску повередине
// int x = 6;
//     for (int i = 1; i <= x; i++) {
//            for (int j = 1; j <= x - i; j++) {
//                System.out.print("  ");
//            }
//
//            if (i == 1 || i == x) {
//                for (int k = 1; k <= 2 * i - 1; k++) {
//                    System.out.print("* ");
//                }
//            } else {
//                System.out.print("* ");
//                for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
//                    System.out.print("  ");
//                }
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = x - 1; i >= 1; i--) {
//
//            for (int j = 1; j <= x - i; j++) {
//                System.out.print("  ");
//            }
//
//            if (i == 1 || i == x) {
//                for (int k = 1; k <= 2 * i - 1; k++) {
//                    System.out.print("* ");
//                }
//            } else {
//                System.out.print("* ");
//                for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
//                    System.out.print("  ");
//                }
//                System.out.print("* ");
//            }
//            System.out.println();
//        }

    }
}
