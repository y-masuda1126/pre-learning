package pro.kensait.java.advanced.lsn_7_1_5.unknown;

import java.util.ArrayList;
import java.util.List;

public class Main_2 {

    @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        // 原型Listの場合
        // 原型（List）と総称型（List<Integer>）の間には互換性があるので、以下はOK
        List list2 = list1;
        // 原型Listには、どんな総称型Listも代入可能
        List list3 = new ArrayList<>();
        List list4 = list3;
        list2.add("foo"); // 要素の追加も可能（型の安全性が保証されない）

        // List<Object>の場合
        // List<Object>とList<Integer>は非変なので、以下はコンパイルエラー
        // List<Object> list5 = list1;
        // List<Object>には任意の要素を追加可能
        List<Object> list6 = new ArrayList<>();
        list6.add(100);
        list6.add("foo"); // 要素の追加も可能（型の安全性が保証されない）

        // List<?>の場合
        // List<?>とList<Integer>の間には互換性があるので、以下はOK
        List<?> list7 = list1;
        // List<?>には、どんな総称型Listも代入可能
        List<String> list8 = new ArrayList<>();
        List<?> list9 = list8;
        // list9.add(100); // ただし要素の追加はできない（型の安全性が保証される）
    }
}