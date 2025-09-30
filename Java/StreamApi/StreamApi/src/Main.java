import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        System.out.print("Enter total movie : ");
        int totalMovie = scanner.nextInt();
        for (int i = 1; i <= totalMovie; i++) {
            list.add("Movie # " + i);
            System.out.println("Movie # " + i);
        }
        System.out.print("Enter count movie  in one page : ");
        int pageSize = scanner.nextInt();
        System.out.print("Enter page : ");
        int pageNum = scanner.nextInt();
        
        ///////////////////////////////////////
//              logic
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalMovie);

        List<String> result = new ArrayList<>();

        if (startIndex >= totalMovie) {
            System.out.println("Dannaya stranica ne suwestvuet");
        } else {
            for (int i = startIndex; i < endIndex; i++) {
                result.add(list.get(i));
            }

            System.out.println((startIndex + 1) + "->" + endIndex);
        }
        ///////////////////////////////////////

        if (!result.isEmpty()) {
            for (String value : result) {
                System.out.println(value);
            }
        }
    }
}
