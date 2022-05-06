package src.lambdaTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C06SelfStudy {

    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a print ediniz.)

        Path gokhan = Path.of("src/src/lambdaTutorial/haluk.txt");// PAth i Gokhan obeje atandı
        Stream<String> akıs=Files.lines(gokhan); // harıcteki dataya gittik onu dataya bagladık, haluk.txt dataaları akıs stream a atandı.


        //1. yol
        Files. // Files class'tan lines method call edilerek data cekilecek dosya yolu (path) parameter girildi.
                lines(Paths.get("src/src/lambdaTutorial/haluk.txt")). // path deki dosyanın dataları akısa alındı.
                forEach(System.out::println); // akıstaki datalar ( her satırdaki stringler ) yazdırıldı

        Files.lines(gokhan);// aynı sey oldu yukarıdakı ile aynı oldu.
        System.out.println("\n*************\n");

        //2.yol
        akıs.forEach(System.out::println);


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle print ediniz.)
        System.out.println("\n*************\n");

        Files. // Files class'tan lines method call edilerek data cekilecek dosya yolu (path) parameter girildi.
                lines(Paths.get("src/src/lambdaTutorial/haluk.txt")). // path deki dosyanın dataları akısa alındı.
                map(String::toUpperCase). // akıstaki her eleman buyuk harfe update edildi.
                forEach(System.out::println); // akıstaki datalar ( her satırdaki stringler ) yazdırıldı

        System.out.println("\n*************\n");

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle print ediniz..
//1. yol limit methodu ile
        Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).map(String::toLowerCase).limit(1).forEach(System.out::println);
        System.out.println("\n*************\n");

        Files.lines(gokhan).map(String::toLowerCase).limit(1).forEach(System.out::println);

        System.out.println("\n*************\n");
//2. yol findfirst Methodu ile,

        Files.lines(gokhan).map(String::toLowerCase).findFirst();


        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz print ediniz.
        System.out.println("task 04 : " + Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).map(String::toLowerCase).filter(t-> t.contains("basari")).count());

        Files.lines(gokhan).map(line-> line.contains("basari")).count();

        System.out.println("\n*************\n");


        System.out.println("task 04 :" +Files.lines(gokhan).map(String::toLowerCase).filter(t -> t.contains("basari")).count());
        System.out.println("\n*************\n");
        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  print ediniz..
// 1. yol :
        Files.lines(gokhan).
                map(t-> t.split(" ")).// satırlardaki kelimeler array e atandı.
                flatMap(Arrays::stream).// 2D arraydaki elemanlar tek eleman olarak akısa alındı.
                distinct().// akıstajki elemanlar tekrarsız yapıldı.
                collect(Collectors.toList()). // tekrarsız elemanlar liste atıldı.
                forEach(System.out::println);


        //2. yol toset ile ;
        System.out.println(Files.lines(gokhan).
                map(t -> t.split(" ")).// satırlardaki kelimeler array e atandı.
                        flatMap(Arrays::stream).// 2D arraydaki elemanlar tek eleman olarak akısa alındı. set ile
                        collect(Collectors.toSet()));


        Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).map(line -> line.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  print ediniz..

        Files.lines(gokhan).map(t-> t.split(" ")).flatMap(Arrays::stream).sorted().forEach(System.out::println);

        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız print ediniz.
       System.out.println(Files.lines(Paths.get("src/src/lambdaTutorial/haluk.txt")).
                map(t -> t.split("")).
               flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
               count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini print eden  programi create ediniz.

       //  System.out.println( " task 08 : " + Files.lines(gokhan).map(t -> t.split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).count());
       // System.out.println(Files.lines(gokhan).//txt dosyasıne erişldi
               // map(t -> t.split(" ")).//satırlar akısa alındı
               // flatMap(Arrays::stream).//her satırdaki her kelime akısa alındı
               // filter(t -> t.contains("a")).//a bulunduran kelimeler fitrelenedi
               // count());//a bulunduran kelimeler sayıldı

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri print ediniz.
        System.out.println(Files.lines(gokhan).map(t -> t.split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).collect(Collectors.toList()));

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini print ediniz.
        System.out.println("task 10 : " +  Files.lines(gokhan).map(t -> t.replaceAll("\\W", "").replaceAll("\\d", " ").split("")).flatMap(Arrays::stream).distinct().count());

        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini print ediniz.

        System.out.println("task 11 : " + Files.lines(gokhan).map(t -> t.replaceAll("\\W", "").replaceAll("\\d", " ").split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));

        //2. yol
        System.out.println(Files.lines(gokhan).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                        flatMap(Arrays::stream).
                distinct().
                count());
        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz

        Files.lines(gokhan ).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                flatMap(Arrays::stream).
                distinct().forEach(System.out::println);


    }
}
