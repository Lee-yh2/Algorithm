package javalecture.homework.ch13;

public class Ch13Hw이윤형 {
    public static void main(String[] args) {
        String str = "안녕하세요!";

        System.out.println(str);
        System.out.println(str.replace("안녕하세요", "반갑습니다"));
        String str2 = str.substring(0, 2);
        System.out.println(str2.concat("1"));
        System.out.println(str2.concat("i"));
        StringBuilder sb = new StringBuilder(str2);
        System.out.println(sb.insert(0, '1').append('2'));
        System.out.println(sb.delete(0,1).insert(2, 1));
        System.out.println(sb.replace(0, 2,"hello"));
        str2 = sb.toString();
        System.out.println(str2 = str2.toUpperCase());
        System.out.println(str2.contains("HELL"));
        System.out.println(str2.length());
        System.out.println(str2.substring(1, 3));

    }
}
