import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // music player
        Scanner scanner = new Scanner(System.in);
        String filePath = "";
        int choice = 0;

        while(choice != 5) {
            int response = 0;
            System.out.print("""
                    Welcome to Popify music player
                    Music available :
                    1. Bhangra
                    2. Punjabi
                    3. Rajasthani
                    4. Dhol
                    5. EXIT MUSIC PLAYER
                    Which would you like to listen :""");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> filePath = "src\\music1.wav";
                case 2 -> filePath = "src\\music2.wav";
                case 3 -> filePath = "src\\music3.wav";
                case 4 -> filePath = "src\\music4.wav";
                case 5 -> System.out.println("boring admi kahi ka nikal");
                default -> System.out.println("anpadh h kya dhank se daal");
            }

            File file = new File(filePath);

            try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                while (response != 4) {
                    System.out.print("""
                            Popify music player
                            1. Play music 
                            2. Pause music 
                            3. Reset
                            4. Change music / exit
                            Select a option :""");
                    response = scanner.nextInt();
                    switch (response) {
                        case 1 -> clip.start();
                        case 2 -> clip.stop();
                        case 3 -> clip.setMicrosecondPosition(0);
                        case 4 -> clip.close();
                        default -> System.out.println("Invalid choice");
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("Could not locate file");
            } catch (LineUnavailableException e) {
                System.out.println("unable to access audio");
            } catch (IOException e) {
                System.out.println("Something went wrong");
            } catch (UnsupportedAudioFileException e) {
                System.out.println("File type not supported");
            }
        }

    }
}