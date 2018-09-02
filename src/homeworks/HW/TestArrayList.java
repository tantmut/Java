package homeworks.HW;

import homeworks.HW.array_list.ImitationArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by nazar on 2/26/2017.
 */
public class TestArrayList {
    public static void main(String[] args) {
        ImitationArrayList arrayList = new ImitationArrayList();

       /* System.out.println(Arrays.toString(arrayList.getArray()));
        System.out.println(Arrays.toString(arrayList.getArray()));*/

    }


    //        List<String> strings = Files.readAllLines(path);

    /*
    * String text = "Hello";
    * text = text.concat("I'm");new String("HelloI'm")
    * text = text.concat("I'm from"); new String("HelloI'mI'm from")
    * */


       /* public static String read(String FILE_NAME) throws FileNotFoundException {
            //Этот спец. объект для построения строки
            StringBuilder sb = new StringBuilder();

            exists(FILE_NAME);
            File file = new File(FILE_NAME);

            try {
                //Объект для чтения файла в буфер
                BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    //В цикле построчно считываем файл
                    String s;
                    while ((s = in.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                } finally {
                    //Также не забываем закрыть файл
                    in.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //Возвращаем полученный текст с файла
            return sb.toString();

        }*/

}


