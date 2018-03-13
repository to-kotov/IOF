import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.ws.handler.Handler;
import java.io.*;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

/**
 * Created by sbt-kotov-vyu on 06.03.2018.
 */
public class IOF {
    /*
    public class SAXPars extends DefaultHandler {


    }
*/

    String thisElement;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


        /* чтение файла целиком
        System.out.println();
        System.out.println("Чтение файла с помощью буфера");
        try {
            FileInputStream inFile = new FileInputStream("C:\\Users\\sbt-kotov-vyu\\IdeaProjects\\Java_Test\\src\\file.txt");
            //На вход буффера передаем стрим
            InputStream inBuff = new BufferedInputStream(inFile);

            PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\sbt-kotov-vyu\\IdeaProjects\\Java_Test\\src\\file1.txt"));

            //Метод чтения строки
            String Read = inBuff.readline;
            pw.println(pw);
        } catch (FileNotFoundException e) {
            System.out.println("Файла то нет");
        } catch (IOException e) {
            System.out.print("Файла то нет");
        }
         */


        File dir = new File("C:\\Users\\User\\IdeaProjects\\IOF\\src");
        File[] files = dir.listFiles();
        try {
            for (File F : files) {
                if (F.isFile()) System.out.println(F.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            System.out.println("А файлов то нет ");
        }
        // */

        File nameFile = new File("C:\\Users\\User\\IdeaProjects\\IOF\\src\\temp.out");


        InputStream is = null;
        try {
            is = new FileInputStream(nameFile);
            OutputStream os = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\IOF\\src\\temp.out1");

            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
                //System.out.print(b);
                //b = is.read();
            }
            is.close();
            os.close();

        } catch (FileNotFoundException e) {
            System.out.println("А файла то нет " + e);
        } catch (IOException e) {
            System.out.println("Ошибка записи " + e);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\IdeaProjects\\IOF\\src\\temp.out1"));
            String line;
            while ((line=br.readLine())!=null)
            {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("А файла то нет" + e);
        } catch (IOException e) {
            System.out.println("Ошибка записи" + e);
        }

        //Нужно скачать библиотечку commons-oi.jar копировать/перемещать файлы с FileUtils
        //String s = FileUtils.readFileToString(file);


        //--------------------------XML------------------------

        SAXParserFactory f = SAXParserFactory.newInstance();
        SAXParser p = f.newSAXParser();
        DefaultHandler h = new DefaultHandler(){
         /*
          public void startElement(String uri, String name, String qname, Atributes atr){}
          public void endElement(){}
          public void characters(char[] ch,int start, int length ){}
          */



        };
        p.parse(nameFile,h);

    }

}

