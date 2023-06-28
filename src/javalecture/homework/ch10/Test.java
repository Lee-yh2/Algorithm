package javalecture.homework.ch10;

public class Test {
    public static void main(String[] args) {
        String header = "엄청난 제목";
        String body = "흥미로운 내용";
        String footer = "출처 및 기자";
        Contents contents = new Contents(header, body, footer);

        Document htmlDoc = new HtmlDocument();
        htmlDoc.printDoc(contents);
    }
}
