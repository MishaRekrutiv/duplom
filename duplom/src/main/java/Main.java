import ua.lviv.nulp.ExamPaper;
import ua.lviv.nulp.MethodsForImage;
import ua.lviv.nulp.Recognition;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
    //    MethodsForImage.convertPdfToImage("D:\\docs/123.pdf");
      // MethodsForImage.cropImage(MethodsForImage.readImage("D:\\docs/f/123_1.jpeg"));

      //  Recognition.getAnswer(MethodsForImage.readImage("D:\\docs/f/imgage1i1.jpeg"));
        ExamPaper examPaper = Recognition.fillingExamPaper("D:\\docs/123.pdf");

    }
}
