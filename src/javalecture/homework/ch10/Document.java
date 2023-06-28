package javalecture.homework.ch10;

class Contents{
    private String header;
    private String body;
    private String footer;

    Contents(String header, String body, String footer){
        this.header = header;
        this.body = body;
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getFooter() {
        return footer;
    }
}

abstract public class Document {
    final void printDoc(Contents contents){
        headerPrint(contents.getHeader());
        bodyPrint(contents.getBody());
        footerPrint(contents.getFooter());
    }

    abstract void headerPrint(String header);
    abstract void bodyPrint(String body);
    abstract void footerPrint(String footer);
}
