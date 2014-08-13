import java.io.UnsupportedEncodingException;

/**
 * Created by jeril on 2014/08/05.
 */
public class Main {

    public static void main(String[] args) {

        String a ="Ròse Byrne";
//        String a="RÃ²se Byrne";
        String str=null;

        byte b[];
        try {
            b=a.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            b= new byte[1];
        }

        try {
            str = new String(b,"ISO-8859-1");
        }
        catch (Exception e)
        {

        }


//
//
        System.err.println("ISO-8859-1 String "+ str);
//
        String charsetName="UTF-8";
        try {
            String test = new String(str.getBytes(), charsetName);
            System.err.println("Test name  "+test);
////
////
////            String test1 = new String(test.getBytes(), charsetName);
////            System.err.println("Test name  "+test1);
//
//
//            charsetName="ISO-8859-1";
//            String test2 = new String(a.getBytes(), charsetName);
//            System.err.println("Test name  "+test2);
        }
        catch (Exception io)
        {

        }




    }
}
