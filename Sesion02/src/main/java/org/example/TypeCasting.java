package org.example;

public class TypeCasting {

    public static void main(String[] args) {
        byte a = 121, b =6;
        byte c = (byte)(a + b);
        int aInt = a + b;
        int bInt = a/b;
        float fNum = a/b;  // 20.0F

        byte x  = 121 + 6;  // 127

        System.out.println("fNum " + fNum);

        float f2Num =  (float)(a/b);
        System.out.println("f2Num " + f2Num);

        float f3Num =  (float)a/b;
        System.out.println("f3Num " + f3Num);

        float f4Num = a/(float) b;
        System.out.println("f4Num " + f4Num);


        b = (byte)(b + 1);

        float f1 = 25.0f, f2 = 13.0f;

        float result = f1 + f2;
        System.out.println("result " + result);

        float f3 = 25.0f;
        float result2 = (float) (13.0 + f3);
        System.out.println("result2 " + result2);

        float resultado = bInt + f1 + x;  //  int  + float + byte
        System.out.println("resultado " + resultado);


        short sh = 15;

        sh = (short) (sh + 65);

        sh = (short) (b + sh + bInt);
        System.out.println("sh " + sh);

        byte otroByte = 127;

        otroByte = (byte) (otroByte + 15);
        System.out.println("otroByte " + otroByte);
    }
}
