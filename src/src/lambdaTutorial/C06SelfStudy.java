package src.lambdaTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Stream;

public class C06SelfStudy {

    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a print ediniz.)

        Files. // Files class'tan lines method call edilerek data cekilecek dosya yolu (path) parameter girildi.
                lines(Paths.get("src/src/lambdaTutorial/haluk.txt")). // path deki dosyanın dataları akısa alındı.
                forEach(System.out::println); // akıstaki datalar ( her satırdaki stringler ) yazdırıldı


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle print ediniz.)
        System.out.println("\n*************\n");

        Files. // Files class'tan lines method call edilerek data cekilecek dosya yolu (path) parameter girildi.
                lines(Paths.get("src/src/lambdaTutorial/haluk.txt")). // path deki dosyanın dataları akısa alındı.
                map(String::toUpperCase). // akıstaki her eleman buyuk harfe update edildi.
                forEach(System.out::println); // akıstaki datalar ( her satırdaki stringler ) yazdırıldı

        System.out.println("\n*************\n");

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle print ediniz..

        Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).map(String::toLowerCase).limit(1).forEach(System.out::println);
        System.out.println("\n*************\n");

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz print ediniz.
        System.out.println(Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).map(line-> line.contains("basari")).distinct().count());

        System.out.println("\n*************\n");
        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..

        Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).map(line -> line.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..



        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız print ediniz.
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini print eden  programi create ediniz.
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri print ediniz.
        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini print ediniz.
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini print ediniz.
        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz

    }
}
