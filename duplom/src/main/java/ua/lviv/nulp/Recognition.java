package ua.lviv.nulp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Recognition {
    public static RedGreenBlue printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        //System.out.println("argb: "  + red + ", " + green + ", " + blue);
        return new RedGreenBlue(red, green, blue);
    }

    public static boolean getAnswer(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();
        // System.out.println("width, height: " + w + ", " + h);
        int white = 0;
        int black = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getRGB(j, i);
                RedGreenBlue redGreenBlue = printPixelARGB(pixel);
                //System.out.println("");
                if (redGreenBlue.getRed() > 190 || redGreenBlue.getGreen() > 190 || redGreenBlue.getBlue() > 190) {
                    white++;
                } else if (redGreenBlue.getRed() < 60 || redGreenBlue.getGreen() < 60 || redGreenBlue.getBlue() < 60) {
                    black++;
                }

            }
        }
        //System.out.println("white" + " " + white + " " + "black " + black);
        if (white > black) {
            return false;
        } else {
            return true;
        }
    }

    public static Task fillingTask(int column) throws IOException {
        Task task = new Task();
        for (int i = 1; i < 5; i++) {
            BufferedImage image = MethodsForImage.readImage("D:\\docs/f/image" + column + "i" + i + ".jpeg");
            if (i == 1) {
                task.setA(Recognition.getAnswer(image));

                System.out.println(Recognition.getAnswer(image) + "  " + i + "  " + task.isA());
            }
            if (i == 2) {
                task.setB(Recognition.getAnswer(image));

                System.out.println(Recognition.getAnswer(image) + "  " + i + "  " + task.isB());
            }
            if (i == 3) {
                task.setC(Recognition.getAnswer(image));
                System.out.println(Recognition.getAnswer(image) + "  " + i + "  " + task.isC());
            }
            if (i == 4) {
                task.setD(Recognition.getAnswer(image));
                System.out.println(Recognition.getAnswer(image) + "  " + i + "  " + task.isD());
            }


        }
        return task;
    }

    public static ExamPaper fillingExamPaper(String s) throws IOException {
        ExamPaper examPaper = new ExamPaper();
        List<Task> tasks = new ArrayList<Task>();
        MethodsForImage.convertPdfToImage("D:\\docs/123.pdf");
        MethodsForImage.cropImage(MethodsForImage.readImage("D:\\docs/f/123_1.jpeg"));

        for (int j = 1; j < 16; j++) {
            tasks.add(fillingTask(j));
        }
        examPaper.setTasks(tasks);
        for (Task task : examPaper.getTasks()) {
            System.out.println(task);
        }
        return examPaper;

    }
}