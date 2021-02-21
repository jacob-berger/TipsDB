import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tips {
    private static Scanner kb;
    private FileReader fileReader;
    private ArrayList<TipEntry> list;

    public static void main(String[] args) {
        int selection = displayMenu();
        switch (selection) {
            case 0:
                System.out.println("Exiting");
                System.exit(0);
            case 1:
                addRecord();
                break;
            case 2:
                modifyRecord();
                break;
            case 3:
                deleteRecord();
                break;
            case 4:
                upload();
                break;
            case 5:
                download();
                break;
            case 6:
                getRange();
                break;
            case 7:
                getTotals();
                break;
        }
    }

    private static void addRecord() {
        System.out.println("Enter the date (MM/DD/YY) or 'q' to quit: ");
        kb = new Scanner(System.in);
        String rawDate = "";
        boolean valid = false;
        try {
            rawDate = kb.nextLine();
            Pattern pattern = Pattern.compile("^(1[0-2]|0?[1-9])/(0?[1-9]|[1-2][0-9]|3[0-1])/([0-9][0-9])$");
            Matcher matcher = pattern.matcher(rawDate);
            if (matcher.matches()) {
                valid = true;
                String[] formattedDate = rawDate.split("/");
                int month = Integer.parseInt(formattedDate[0]);
                int day = Integer.parseInt(formattedDate[1]);
                int year = Integer.parseInt(formattedDate[2]);

                System.out.format("Month: %d, Day: %d, Year: %d\n", month, day, year);
            }
        } catch (Exception e) {
            System.out.println("Invalid entry.");
            rawDate = "";
        }
    }

    private static void modifyRecord() {
    }

    private static void deleteRecord() {
    }

    private static void upload() {
    }

    private static void download() {
    }

    private static void getRange() {
    }

    private static void getTotals() {
    }

    private static int displayMenu() {
        Scanner kb = new Scanner(System.in);
        boolean valid = false;
        int selection = -1;
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Add a record");
            System.out.println("2. Modify a record");
            System.out.println("3. Delete a record");
            System.out.println("4. Upload .csv");
            System.out.println("5. Download .csv");
            System.out.println("6. View range");
            System.out.println("7. View totals");
            System.out.println("0. Quit");
            String rawSelection = kb.nextLine();
            try {
                selection = Integer.parseInt(rawSelection);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Invalid selection.");
            }
            if (!(selection < 0 || selection > 7)) {
                valid = true;
            }
        } while (!valid);

        return selection;

    }
}
