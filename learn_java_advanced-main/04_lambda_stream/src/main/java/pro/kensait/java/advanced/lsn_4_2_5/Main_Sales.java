package pro.kensait.java.advanced.lsn_4_2_5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_Sales {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        Map<String, Integer> resultMap = salesList.stream() //【1】
                .filter(sales -> sales.getProductName().startsWith("A")) //【2】
                .map(sales -> { //【3】
                    String newName = sales.getProductName().replace("-", "");
                    return new Sales(sales.getId(), newName, sales.getCount());
                    })
                .collect(Collectors.groupingBy( //【4】
                        Sales::getProductName,
                        Collectors.summingInt(Sales::getCount)));

        for (String key : resultMap.keySet()) {
            System.out.println(key + " => " + resultMap.get(key));
        }
    }
}