package src.lambdaTutorial;

import java.util.stream.IntStream;

public class C05SelfStudy {
    public static void main(String[] args) {

        System.out.println("TASK 01 amele topla-->" + toplaAmele(5));
        System.out.println("TASK 01 cincix topla-->" + toplaCincix(5));
        System.out.println("task 02 : " + toplaCift(10)); //2+4+6+8+10 =30
        System.out.println("task 03: " + toplaIlkXCift(10)); //2+4+6+8+10+12+14+16+18+20=110
        System.out.println("task 04 : " + toplaIlkTek(10)); // 1+3+5+7+9+11+13+15+17+19=100
        ikininIlkXKuvvetPrint (7); // 2 4 8 16 32 64 128
        System.out.println();
        istenenSayiIlkXKuvvetPrint(4,3);//4 16 64
        System.out.println();
        istenenSayiIlkXKuvvetPrint(3,4);//3 9 27 81

        System.out.println();
        istenenSayiIlkXKuvvetPrint(2,7);//2 4 8 16 32 64 128

        System.out.println();
        System.out.println("task 7 : " +istenenSayiFaktoriyel(5)); // 1*2*3*4*5 = 120

        System.out.println("task 08 : " + xKuvveti(3, 4));//81


        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

        //Structured(AMELE) Programming

    }

    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 0; i < x; i++) {
            toplam += i;
        }

        return toplam;
    }

    //Functional(cincix) Programming
    public static int toplaCincix(int x) {

        return IntStream.range(1, x).sum(); // 1 den x e kadar (x dahil) integer degerler akısa alındı, sonra toplandı,sonra return.


    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x) {

        return IntStream.rangeClosed(1, x).filter(Lambda01::ciftBul).sum(); // x dahil degerlerden cıftker filtlenerek toplandı.
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz

    public static int toplaIlkXCift(int x) {

        return IntStream.
                iterate(2, t -> t + 2).// 2 den sonsuza kadar elemanları 2 artırarak akım alır.--->2,4,6,8,10,...
                        limit(x).// akıstakı ılk x degerini akısa alır
                        sum(); // akıstakı ınt degerleri toplar.

    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkTek(int x) {

        return IntStream.iterate(1, t-> t+2).limit(x).sum();
    }
    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininIlkXKuvvetPrint (int x){
         IntStream.
                 iterate(2, t-> t*2).limit(x).// 2 den sonsuza kadar elemanları 2 ile carparak akısa alır 2,4,8,16,32,64,128..
                 forEach(Lambda01::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x) {
        IntStream.iterate(istenenSayi, t-> t*istenenSayi ).limit(x).forEach(Lambda01::yazdir);

    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFaktoriyel(int x){

        return IntStream.
                rangeClosed(1,x).
                //reduce(Math::multiplyExact).
                reduce(1, (t,u)-> t*u);
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int xKuvveti(int istenenSayi, int x) {
        return IntStream.iterate(istenenSayi, t->t*istenenSayi).limit(x).reduce(0, (t,u)->u);
    } //  return Math.pow(istenenSayi, x)
}