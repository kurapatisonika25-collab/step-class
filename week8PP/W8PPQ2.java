import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

interface LibraryItem {
    LocalDate getDueDate(LocalDate currentDate);
}

class Book implements LibraryItem {
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class W8PPQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int spaceIndex = line.indexOf(" ");
            String type = line.substring(0, spaceIndex);

            int firstQuote = line.indexOf("\"");
            int lastQuote = line.lastIndexOf("\"");
            String title = line.substring(firstQuote + 1, lastQuote);

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book();
            } else if (type.equals("DVD")) {
                item = new DVD();
            } else {
                item = new Magazine();
            }

            LocalDate dueDate = item.getDueDate(currentDate);

            System.out.println(title + ": " + dueDate.format(formatter));
        }

        sc.close();
    }
}