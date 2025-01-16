package pro.kensait.java.advanced.lsn_4_2_5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_Collection {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            List<Sales> salesList = SalesHolder.getSalesList();
            List<Sales> resultList = salesList.stream() //【1】
                    .filter(sales -> sales.getProductName().startsWith("A")) //【2】
                    .collect(Collectors.toList()); //【3】
            System.out.println(resultList);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            List<Sales> salesList = SalesHolder.getSalesList();
            Map<Integer, Integer> resultMap = salesList.stream()
                    .filter(sales -> sales.getProductName().startsWith("A"))
                    .collect(Collectors.toMap( //【1】
                            Sales::getId, //【2】
                            Sales::getCount, //【3】
                            (oldVal, newVal) -> newVal)); //【4】
            System.out.println(resultMap);
            System.out.println("=> end");
        }
    }
}