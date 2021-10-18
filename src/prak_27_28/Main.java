package prak_27_28;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args)
    {
        int n = 6;
        Runtime runtime = Runtime.getRuntime();
        int a = runtime.availableProcessors();
        System.out.println(a);

        String srcFolder = "/home/pasta/Pictures/java_start_pictures/";
        String dstFolder = "/home/pasta/Pictures/java_finish_pictures/";
        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }

            File[] files1 = new File[n];
            File[] files2 = new File[n];
            File[] files3 = new File[n];
            File[] files4 = new File[n];
            int i = 0, j = 1;
            for(File file : files)
            {
                if((i < 6)&&(j == 4))
                {
                    files4[i] = file;
                    i++;
                }
                if((i < 6)&&(j == 3))
                {
                    files3[i] = file;
                    i++;
                }
                if((i < 6)&&(j == 2))
                {
                    files2[i] = file;
                    i++;
                }
                if((i < 6)&&(j == 1))
                {
                    files1[i] = file;
                    i++;
                }
                if(i >= 6){
                    j++;
                    i = 0;
                }
            }
            Foto foto1 = new Foto(files1);
            Foto foto2 = new Foto(files2);
            Foto foto3 = new Foto(files3);
            Foto foto4 = new Foto(files4);


            Thread thread1 = new Thread(new Minimum(foto1, dstFolder));
            Thread thread2 = new Thread(new Minimum(foto2, dstFolder));
            Thread thread3 = new Thread(new Minimum(foto3, dstFolder));
            Thread thread4 = new Thread(new Minimum(foto4, dstFolder));

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
