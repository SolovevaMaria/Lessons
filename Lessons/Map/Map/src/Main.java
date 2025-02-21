import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Map<String, String> dictionary = new LinkedHashMap<>();
        dictionary.put("dog", "sobaka");
        dictionary.put("mother", "mama");
        dictionary.put("brother", "brat");
        dictionary.put("sister", "sestra");
        dictionary.put("father", "papa");
        dictionary.put("home", "dom");
        dictionary.put("1", "4");


        System.out.println("ssss".length());

        do {
            System.out.println();
            System.out.print("VVedite slovo dlya perevoda : ");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            word = word.toLowerCase();//dog


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //1) cls -> ociwaet ves slovar
            //2) size -> pecataet skolko vseqo slov
            //3) letter -> pecataet skolko vseqo simvolov v slovare
            //4) num -> pecataet skolko vseqo cisel v slovare
            //5) delete -> udalenie po klucu ili  po zznaceniyu
            //6) update -> izmenit slowo na ctoto
            //   6.1 = esli para s takim je key i value est -> to osibka cto dannaya para uej susestvuet
            //   6.2 = esli pervoe vvedennoe slovo sovpadaet s klucom -> to obnavit tolko znacenie
            //   6.3 = esli pervoe vvedennoe slovo sovpadaet s value -> to obnavit kluc


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            if (word.equals("command")) {
                System.out.print("VVedite comandu : ");
                word = scanner.nextLine();
                word = word.toLowerCase();

                if (word.equals("print")) {
                    System.out.println("\n-----------------------------------------\nPrint all words\n");
                    for (String key : dictionary.keySet()) {
                        System.out.println(key + " (en) => " + dictionary.get(key) + " (ru)");
                    }
                }

                if (word.equals("cls")) {
                    System.out.println("\n-----------------------------------------\nВсе слова удалены. Словарь очищен\n");
                    dictionary = new LinkedHashMap<>();
                }

                if (word.equals("size")) {
                    System.out.println("\n-----------------------------------------\nРазмер словаря (количество слов) : \n");
                    System.out.println(dictionary.size());
                }

                if (word.equals("letter")) {
                    int symvols = 0;
                    for (String key : dictionary.keySet()) {
                        symvols  += key.length();
                        symvols  += dictionary.get(key).length();
                    }
                    System.out.println("\n-----------------------------------------\nОбщее количество символов в словаре : " + symvols + "\n");

                }

                if (word.equals("num")) {
                    int count = 0;
                    for (String key : dictionary.keySet()) {
                        for (int i = 0; i < key.length(); i++) {
                            char c = key.charAt(i);
                            if (c >= '0' && c <= '9') {
                                count++;
                            }
                        }
                        String value = dictionary.get(key);
                        for (int i = 0; i < value.length(); i++) {
                            char c = value.charAt(i);
                            if (c >= '0' && c <= '9') {
                                count++;
                            }
                        }
                    }
                    System.out.println("\n-----------------------------------------\nВсего чисел : " + count + "\n");
                }

                
                if (word.equals("delete")) {
                    System.out.print("Удалить слово (ключ) или его перевод (значение) ? ");
                    String deleteChoice = scanner.nextLine().toLowerCase();

                    if (deleteChoice.equals("слово")) {
                        System.out.print("Введите слово на английском языке (ключ) : ");
                        String keyToDelete = scanner.nextLine().toLowerCase();
                        if (dictionary.containsKey(keyToDelete)) {
                            dictionary.remove(keyToDelete);
                            System.out.println("Слово " + keyToDelete + " удалено\n");
                        } else {
                            System.out.println("Слово " + keyToDelete + " не найдено в словаре\n");
                        }
                    } else if (deleteChoice.equals("перевод")) {
                        System.out.print("Введите перевод слова : ");
                        String valueToDelete = scanner.nextLine();
                        

                    }
                }

                    if (word.equals("update")) {
                        System.out.print("Введите слово для изменения: ");
                        String keyToUpdate = scanner.nextLine().toLowerCase();
                        if (dictionary.containsKey(keyToUpdate)) {
                            System.out.print("Что вы хотите изменить (ключ/значение)? ");
                            String choice = scanner.nextLine().toLowerCase();

                            if (choice.equals("ключ")) {
                                System.out.print("Введите новое слово на английском языке : ");
                                String newKey = scanner.nextLine().toLowerCase();

                                if (dictionary.containsKey(newKey)) {
                                    System.out.println("Слово " + newKey + " уже существует в словаре\n");
                                } else {
                                    String value = dictionary.get(keyToUpdate);
                                    dictionary.put(newKey, value);
                                    System.out.println("Слово " + keyToUpdate + " изменено на " + newKey + "\n");
                                }
                            } else if (choice.equals("значение")) {
                                System.out.print("Введите новое значение: ");
                                String newTranslat = scanner.nextLine();
                                dictionary.put(keyToUpdate, newTranslat);
                                System.out.println("Перевод для слова " + keyToUpdate + " изменен на " + newTranslat + "\n");
                            } else {
                                System.out.println("Введите 'ключ' или 'значение'\n");
                            }
                        } else {
                            System.out.println("Слово " + keyToUpdate + " не найдено в словаре\n");
                        }

                    }

                } else if (dictionary.containsKey(word)) {
                    System.out.println(word + "(en) => " + dictionary.get(word) + " (ru)");
                } else if (dictionary.containsValue(word)) {
                    for (String key : dictionary.keySet()) {
                        if (dictionary.get(key).equals(word)) {
                            System.out.println(word + " (ru) => " + key + " (en)");
                            break;
                        }
                    }
                } else {
                    System.out.println("Dannoe slovo otsutsvuet , ne xotite li vi eqo dobavit?\n1 - da\n2 - net");
                    int select = scanner.nextInt();

                    if (select == 1) {
                        System.out.print("Vvedite perevod dannoqo slovo : ");
                        scanner = new Scanner(System.in);

                        String translate = scanner.nextLine();
                        translate = translate.toLowerCase();
                        if (
                                dictionary.containsKey(word) || dictionary.containsValue(word) ||
                                        dictionary.containsKey(translate) || dictionary.containsValue(translate)
                        ) {
                            System.out.println("Dannoe slovo imeet perevod");
                        } else {
                            System.out.println("Dannoe slovo bilo perevedeno s \n1 - en -> ru\n2 - ru -> en");
                            select = scanner.nextInt();
                            if (select == 1) {
                                dictionary.put(word, translate);
                            } else if (select == 2) {
                                dictionary.put(translate, word);
                            } else {
                                System.out.println("Slovo ne bilo dobavleno vi sdelali ne pravilniy vibor");
                            }

                            System.out.println("Slovo bilo uspewno dobavleno");
                        }
                    } else if (select == 2) {
                        System.out.println("Vaw vibor.");
                    } else {
                        System.out.println("Vi sdelali ne pravilniy vibor");
                    }

                }

            }
            while (true) ;
        }
    }
