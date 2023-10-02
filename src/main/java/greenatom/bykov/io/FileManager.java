package greenatom.bykov.io;

import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            Command command = new Command(sc.nextLine());
            command.process();
        }
    }
}
