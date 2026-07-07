import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String email = "";
        String username = "";
        String domain = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your email: ");
            email = sc.nextLine();

            // 1. Basic check for '@' symbol
            if (email.contains("@")) {
                username = email.substring(0, email.indexOf("@"));
                domain = email.substring(email.indexOf("@") + 1);

                // 2. Syntax check: Make sure text exists before and after '@'
                if (!username.isEmpty() && !domain.isEmpty()) {

                    System.out.println("Checking if domain '" + domain + "' exists on the internet...");

                    // 3. Network check: Does this domain actually exist?
                    if (isRealDomain(domain)) {
                        System.out.println("\n--- Success! ---");
                        System.out.println("Username: " + username);
                        System.out.println("Domain: " + domain);
                        isValid = true; // The domain is real, exit the loop!
                    } else {
                        System.out.println("Invalid email! The domain @" + domain + " does not exist. Try again!\n");
                    }

                } else {
                    System.out.println("Invalid email! Must have text before and after the @ symbol. Try again!\n");
                }
            } else {
                System.out.println("Invalid email, must contain @, try again!\n");
            }
        }

        System.out.println("Program finished.");
        sc.close();
    }

    // Helper method to ping the domain's DNS
    public static boolean isRealDomain(String domain) {
        try {
            // This attempts a real-time DNS lookup to find the IP of the domain
            InetAddress address = InetAddress.getByName(domain);
            return true; // If it finds an IP address, the domain is real!
        } catch (UnknownHostException e) {
            return false; // If the domain doesn't exist, this exception triggers
        }
    }
}