package utils;

/**
 * @Description
 * @Author lzj
 * @Date 2019/5/8 12:14
 */
public class Util {
    public static <T> void printArr(T[] arrs) {
        for (T s : arrs) {
            System.out.print(s + ", ");
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"a","b"};
        printArr(strings);
    }
}
