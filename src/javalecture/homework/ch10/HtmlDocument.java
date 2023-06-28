package javalecture.homework.ch10;

public class HtmlDocument extends Document{
    @Override
    void bodyPrint(String body) {
        System.out.println("<body>");
        System.out.println(body);
        System.out.println("</body>");
    }

    @Override
    void headerPrint(String header) {
        System.out.println("<head>");
        System.out.println(header);
        System.out.println("</head>");
    }

    @Override
    void footerPrint(String footer) {
        System.out.println("<footer>");
        System.out.println(footer);
        System.out.println("</footer>");
    }
}
