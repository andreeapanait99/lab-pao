import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int a = 5, b = 10;
//        int sum = a + b;
//        System.out.println("Suma nr " + a + " si " + b + " este " + sum);
//        Scanner scanner = new Scanner(System.in);
//        String ceAmCitiDinConsola = scanner.nextLine();
//        System.out.println("Am citit: " + ceAmCitiDinConsola);

        //Citim actiuni: 0 - exit, 1 - suma, 2 - diferenta
        System.out.println("Citim actiuni: 0 - exit, 1 - suma, 2 - diferenta");
        Scanner scanner = new Scanner(System.in);
        int ceAmCititDinScanner = scanner.nextInt();
        while (ceAmCititDinScanner != 0)
        {
            if (ceAmCititDinScanner == 1)
            {
                System.out.println("Introduceti 2 numere:");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int sum = a + b;
                System.out.println("Suma nr " + a + " si " + b + " este " + sum);
            }
            if (ceAmCititDinScanner == 2)
            {
                System.out.println("Introduceti 2 numere:");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int dif = a - b;
                System.out.println("Diferenta nr " + a + " si " + b + " este " + dif);
            }
            ceAmCititDinScanner = scanner.nextInt();
        }
    }
}
