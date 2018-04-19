import ua.lviv.nulp.MethodsForImage;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        MethodsForImage.cropImage(MethodsForImage.readImage("D:\\docs/f/Test_1.jpeg"));
    }
}
