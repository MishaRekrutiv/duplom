package ua.lviv.nulp;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class MethodsForImage {
  public static  File  f = new File("D:\\images/img1.jpeg");

    public static BufferedImage readImage(String s) throws IOException {
        BufferedImage image = ImageIO.read(new File(s));
        return image;
    }

    public static void writeImage(BufferedImage image, String s) throws IOException {
        ImageIO.write(image, "jpeg", new File(s));
    }
    public static void cropImage(BufferedImage image) throws IOException {

      int w = 39;
      int h = 39;
      int lim= 72;
      BufferedImage image1 = image.getSubimage(64,175,1110,255);
      writeImage(image1,"D:\\docs/f/img1.jpeg");
//        System.out.println(image.getMinX());
//        System.out.println(image.getWidth());
//        System.out.println(image.getHeight());
//        System.out.println(image.getMinY());
////      for (int i = 0; i < 4; i++) {
//        BufferedImage image2= image1.getSubimage(0,0+i*lim ,w,h);
//        writeImage(image2, "D:\\docs/f/imgage"+i+".jpeg");
//      }
        for (int j = 1; j < 16; j++) {

      for (int i = 1; i < 5; i++) {
        BufferedImage image2= image1.getSubimage(0+(j-1)*lim,0+(i-1)*lim ,w,h);
//          System.out.println(image1.getWidth() + " " + j*lim + "  " + j);
//          System.out.println(image1.getHeight());

          writeImage(image2, "D:\\docs/f/image"+j+"i"+i+".jpeg");
      }
        }
//
//    BufferedImage image2= image1.getSubimage(0,0 ,39,39);
//    writeImage(image2, "D:\\docs/f/img2.jpeg");
//    BufferedImage image3= image1.getSubimage(72,0 ,39,39);
//    writeImage(image3, "D:\\docs/f/img3.jpeg");
//    BufferedImage image4= image1.getSubimage(144,0 ,39,39);
//    writeImage(image4, "D:\\docs/f/img4.jpeg");
//    BufferedImage image5= image1.getSubimage(216,0 ,39,39);
//    writeImage(image5, "D:\\docs/f/img5.jpeg");

    }
    public static void convertPdfToImage(String file){
      try {
        String sourceDir = file; // Pdf files are read from this folder
        String destinationDir = "D:\\docs/f/"; // converted images from pdf document are saved here

        File sourceFile = new File(sourceDir);
        File destinationFile = new File(destinationDir);
        if (!destinationFile.exists()) {
          destinationFile.mkdir();
          System.out.println("Folder Created -> "+ destinationFile.getAbsolutePath());
        }
        if (sourceFile.exists()) {
          System.out.println("Images copied to Folder: "+ destinationFile.getName());
          PDDocument document = PDDocument.load(sourceDir);
          List<PDPage> list = document.getDocumentCatalog().getAllPages();
          System.out.println("Total files to be converted -> "+ list.size());

          String fileName = sourceFile.getName().replace(".pdf", "");
          int pageNumber = 1;
          for (PDPage page : list) {
            BufferedImage image = page.convertToImage();
            File outputfile = new File(destinationDir + fileName +"_"+ pageNumber +".jpeg");
            System.out.println("Image Created -> "+ outputfile.getName());
            ImageIO.write(image, "jpeg", outputfile);
            pageNumber++;
          }
          document.close();
          System.out.println("Converted Images are saved at -> "+ destinationFile.getAbsolutePath());
        } else {
          System.err.println(sourceFile.getName() +" File not exists");
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
