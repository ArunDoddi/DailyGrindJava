package com.Udemy;

public class ArgumentCheck {
    public static void main(String[] args) {
        if (args.length < 1) {
            return;
        } else {
            if (args.length == 1 && args[0].contains(" ")) {
                args = args[0].split(" ");
            }
        }

        boolean guest = false, admin = false;
        for (String arg : args) {
            if (arg.equals("--admin")) {
                admin = true;
            } else if (arg.equals("--guest")) {
                guest = true;
            }
        }
        if (admin) {
            if (guest) {
                System.out.println("Please, select either 'ADMIN' or 'GUEST' mode for this program");
            } else {
                System.out.println("Hello, Admin!");
            }
        } else if (guest) {
            System.out.println("Hello, Guest!");
        }
    }
}
