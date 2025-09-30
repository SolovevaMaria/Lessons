import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
//  +  create-folder <путь> – создать папку
//  +  create-file <путь> – создать пустой файл
//  +  delete <путь> – удалить файл или папку
//  +  delete r <путь> – удалить файл или папку (содержимое папки удаляется рекурсивно)
//  +  rename <старое_имя> <новое_имя> – переименовать файл или папку
//  +  move <откуда> <куда> – переместить файл или папку
//  +  list <путь> – вывести содержимое папки (файлы и папки)
//  +  size <путь> – вывести размер файла или папки (считая размер всех вложенных файлов)
//  +  sort <путь> [name|size] – вывести содержимое папки с сортировкой по имени или размеру
//  +  exit – выход из программы
public static boolean deleteR(File dir) {
    if (dir.isDirectory()) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!deleteR(file)) {
                    return false;
                }
            }
        }
    }
    return dir.delete();
}

    public static void main(String[] args) throws IOException {
        String path ;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter command : ");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                System.out.println("Выход из программы ");
                break;
            } else if (command.startsWith("create-folder")) {
                path = command.split(" ")[1];
                File file = new File(path);
                if (file.mkdir()) {
                    System.out.println("Папка была успешно создана  " + file.getName());
                } else {
                    System.out.println("Создать папку невозможно");
                }
            } else if (command.startsWith("create-file")) {
                path = command.split(" ")[1];
                File file = new File(path);
                if (file.createNewFile()) {
                    System.out.println("Файл успешно создан : " + file.getName());
                } else {
                    System.out.println("Не удалось создать файл ");
                }
            } else if (command.startsWith("delite")) {
                String[] parts = command.substring("delete".length()).trim().split(" ");
                if (parts.length > 0) {
                    path = parts[0];
                    File file = new File(path);

                    if (!file.exists()) {
                        System.out.println("Файл или папка не существуют ");
                    } else {
                        if (deleteR(file)) {
                            System.out.println("Файл или папка успешно удалены " );
                        } else {
                            System.out.println("Не удалось удалить файл или папку ");
                        }
                    }
                } else {
                    System.out.println("Неверный формат команды ");
                }
            }else if (command.startsWith("delete r")) {
                String[] parts = command.substring("delete r".length()).trim().split(" ");
                if (parts.length > 0) {
                    path = parts[0];
                    File file = new File(path);
                    if (!file.exists()) {
                        System.out.println("Файл или папка не существуют ");
                    } else {
                        if (file.isFile()) {
                            if (file.delete()) {
                                System.out.println("Файл успешно удален ");
                            } else {
                                System.out.println("Не удалось удалить файл ");
                            }
                        } else if (file.isDirectory()) { // Если это папка
                            if (deleteR(file)) {
                                System.out.println("Файл или папка успешно удалены ");
                            } else {
                                System.out.println("Не удалось удалить файл или папку ");
                            }
                        }
                    }
                } else {
                    System.out.println("Неверный формат команды ");
                }
                
            } else if (command.startsWith("rename")) {
                String[] parts = command.substring("rename".length()).trim().split(" ");
                if (parts.length != 2) {
                    System.out.println("Неверный формат команды ");
                    continue;
                }
                path = parts[0];
                String newName = parts[1];
                File oldFile = new File(path);
                File newFile = new File(oldFile.getParent(), newName);
                if (!oldFile.exists()) {
                    System.out.println("Файл или папка не существуют.");
                } else {
                    if (oldFile.renameTo(newFile)) {
                        System.out.println("Файл или папка успешно переименованы в " + newName);
                    } else {
                        System.out.println("Не удалось переименовать файл или папку ");
                    }
                }
            } else if (command.startsWith("move")) {
                    String[] parts = command.substring("move".length()).split(" ");
                    if (parts.length != 2) {
                        System.out.println("Неверный формат команды.  move <откуда> <куда>");
                        continue;
                    }
                    String sourcePath = parts[0];
                    String targetPath = parts[1];
                    File sourceFile = new File(sourcePath);
                    Path targetDirectory = Paths.get(targetPath);
                    Path sourceFileToMove = Paths.get(sourcePath);
                    if (!sourceFile.exists()) {
                        System.out.println("Файл или папка для перемещения не существуют ");
                        continue;
                    }

                    if (!Files.exists(targetDirectory) || !Files.isDirectory(targetDirectory)) {
                        System.out.println("Указанная папка куда переместить файл не существует ");
                        continue;
                    }
                    Path target = targetDirectory.resolve(sourceFile.getName());
                    Files.move(sourceFileToMove, target);
                    System.out.println("Файл или папка успешно перемещены в - " + targetPath);
                }else if (command.startsWith("list")) {
                    path = command.substring("list".length()).trim();
                    File directory = new File(path);
                    if (!directory.exists()) {
                        System.out.println("Указанная папка не существует ");
                        continue;
                    }
                    if (!directory.isDirectory()) {
                        System.out.println("Указанный путь не является папкой ");
                        continue;
                    }
                    String[] contents = directory.list();

                    if (contents == null) {
                        System.out.println("Не удалось получить содержимое папки ");
                        continue;
                    }
                    System.out.println("Содержимое папки " + path + ":");
                    for (String item : contents) {
                        System.out.println(item);
                    }
                }    else  if (command.startsWith("size")){
                    path = command.substring("size".length()).trim();
                    File file = new File(path);

                    if (!file.exists()) {
                        System.out.println("Указанный файл или папка не существуют ");
                        continue;
                    }
                    long size = file.length();
                    System.out.println("Размер " + (file.isDirectory() ? "папки" : "файла") + " " + path + ": " + size + " байт");

                }    else  if (command.startsWith("sort")){
                String[] parts = command.substring("sort".length()).trim().split(" ");
                if (parts.length < 2 || parts.length > 2) {
                    System.out.println("Неверный формат команды. Используйте sort <путь> [name|size]");
                    continue;
                }
                path = parts[0];
                String sortBy = parts[1];
                File directory = new File(path);
                if (!directory.exists()) {
                    System.out.println("Указанная папка не существует ");
                    continue;
                }
                if (!directory.isDirectory()) {
                    System.out.println("Указанный путь не является папкой ");
                    continue;
                }
                File[] files = directory.listFiles();
                if(files == null) {
                    System.out.println("Не удалось получить содержимое папки ");
                    continue;
                }
                List<File> fileList = new ArrayList<>(Arrays.asList(files));
                if (sortBy.equalsIgnoreCase("name")) {
                    Collections.sort(fileList, Comparator.comparing(File::getName));
                } else if (sortBy.equalsIgnoreCase("size")) {
                    Collections.sort(fileList, Comparator.comparingLong(File::length));
                } else {
                    System.out.println("Неверный параметр сортировки. Используйте name или size ");
                    continue;
                }
                System.out.println("Содержимое папки " + path + " (отсортировано по " + sortBy + "):");
                for (File file : fileList) {
                    System.out.println(file.getName());
                }

            }else{
                System.out.println("Такой команды нет ");
            }
            System.out.println(command);

        }while (true);
    }
   


}
