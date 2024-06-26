import java.io.*;

class encryptordecryptor {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter 'encrypt' to encrypt or 'decrypt' to decrypt: ");
            String operation = reader.readLine();

            System.out.println("Enter the file name or path: ");
            String fileName = reader.readLine();

            File inputFile = new File(fileName);
            File outputFile = new File("output.txt");

            switch (operation) {
                case "encrypt" -> {
                    encryptFile(inputFile, outputFile);
                    System.out.println("File encrypted successfully. Check output.txt for the result.");
                }
                case "decrypt" -> {
                    decryptFile(inputFile, outputFile);
                    System.out.println("File decrypted successfully. Check output.txt for the result.");
                }
                default -> System.out.println("Invalid operation. Please enter 'encrypt' or 'decrypt'.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void encryptFile(File inputFile, File outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                // Simple encryption algorithm (shifting characters by 1)
                char encryptedChar = (char) (c + 1);
                writer.write(encryptedChar);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during encryption: " + e.getMessage());
        }
    }

    private static void decryptFile(File inputFile, File outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                // Simple decryption algorithm (shifting characters back by 1)
                char decryptedChar = (char) (c - 1);
                writer.write(decryptedChar);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during decryption: " + e.getMessage());
        }
    }
}

