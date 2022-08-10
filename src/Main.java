import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void output(ArrayList<String> list) {
        System.out.println("Список покупок:");
        for (String s : list) {
            System.out.println((list.indexOf(s) + 1) + ". " + s);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.println("Выберите операцию.");
            System.out.println("1 - добавить, 2 - показать, 3 - удалить, 4 - поиск");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");

                    String addProd = scanner.nextLine();
                    list.add(addProd);
                    System.out.println("Итого в списке продуктов " + list.size());
                    break;
                case 2:
                    output(list);
                    break;
                case 3:
                    output(list);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    Scanner scanner1 = new Scanner(System.in);
                    try {
                        int delProd = scanner1.nextInt();
                        System.out.println("Покупка " + list.get(delProd - 1) + " удалена.");
                        list.remove(delProd - 1);
                    } catch (InputMismatchException exception) {
                        String delProd = scanner1.nextLine();
                        list.remove(delProd);
                        System.out.println("Покупка " + delProd + " удалена.");
                    }
                    output(list);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    Scanner scanner2 = new Scanner(System.in);
                    String search = scanner2.nextLine();
                    String queryLower = search.toLowerCase();
                    System.out.println("Найдено:");
                    for (int i = 0; i < list.size(); i++) {
                        String itemLower = list.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                        }
                    }
                    break;
            }
        }
    }
}
