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

//  int x=0;
//  int y=0;
//     int z = 0;
//  while (y<=6 && x<=6){
//      System.out.println("* ");
//       y++;
//      System.out.println(" ");
//      x++;
// }




      

//Фигура 3
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
//        while (x>0){
//            for (int i = 0; i < y; i++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//            y++;
//            x--;
//        }

// Треугольник 3
//int x = 8;       // строки в треугольнике
//int y = 1; // начальное количество *
//   while (x>0) {   //пока количество строк больше 0
//    for (int i = 0; i < y; i++) {           //* в строке
//                System.out.print("* ");
//
//            }
//
//            System.out.println();
//            y++;                       // увеличение *
//            x--;                       // уменьшение строк
//
//        }


//Ромб



// Do while
//Прямоугольник
//int x = 0;
// do  {
//     System.out.println("* * * * *");
//     x++;
// }
//  while (x<=10);

// Фигура 2
// int x=0;
// int y=0;
// int z = 0;
//       do   {
//    System.out.println("* ");
//       y++;
//    System.out.println(" ");
//    x++;
// }
//  while (y<=6 && x<=6);

//Фигура 3
// Треугольник 1
//Треугольник   2
// Треугольник 3
//Ромб

//Только границы фигур
//Прямоугольник
        for (int i = 0; i <= 7; i++) {
             if (i==0){
                 System.out.println("* * * * *");
             }
             if (i == 7)   {
                 System.out.println("* * * * *");
                 break;
             }
            System.out.println("*       *");
        }
// Фигура 2
//Фигура 3
// Треугольник 1
//Треугольник   2
// Треугольник 3
//Ромб
    }
}
