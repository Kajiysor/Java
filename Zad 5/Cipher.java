import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

public class Cipher {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you wish to encode (1) or decode (2)? Enter 1 or 2: ");
        final int answer = Integer.parseInt(scanner.nextLine());
        if (answer < 1 || answer > 2){
            System.out.println("Your answer must be 1 or 2!");
            scanner.close();
            System.exit(-1);
        }

        System.out.print("What is the input file name? ");
        Path filePath = Paths.get(scanner.nextLine());

        System.out.print("What is the output file name? ");
        Path encodedFilePath = Paths.get(scanner.nextLine());

        if (filePath.equals(encodedFilePath)){
            System.out.println("Input file name can't be the same as output file name!");
            scanner.close();
            System.exit(-2);
        }

        System.out.print("Caesar cipher offset? ");
        final int offset = Integer.parseInt(scanner.nextLine());

        scanner.close();

        Stream<String> mappedFileStream = null;
        // Retrieve a a stream of the input file, where each line is mapped using the encrypt function
        if (answer == 1){
            mappedFileStream = Files.lines(filePath).map(msg -> Cipher.encrypt(msg, offset));
        }
        else if (answer == 2){
            mappedFileStream = Files.lines(filePath).map(msg -> Cipher.decrypt(msg, offset));
        }


        // Write encrypted content to a new file using our mapped stream as an iterable
        Files.write(
                encodedFilePath,
                (Iterable<String>) mappedFileStream::iterator,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        // Decrypt the encoded file content and print it
        // Files.lines(encodedFilePath)
        //         .map((fileLine) -> Cipher.decrypt(fileLine, offset))
        //         .forEach(System.out::println);
    }

    public static String encrypt(String msg, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder(msg.length());
        for (char i : msg.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                encoded.append((char) (base + (i - base + offset) % 26));
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static String decrypt(String enc, int offset) {
        return encrypt(enc, 26 - offset);
    }
}