package pro.kensait.java.advanced.lsn_4_2_6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pro.kensait.java.advanced.lsn_4_2_5.Sales;
import pro.kensait.java.advanced.lsn_4_2_5.SalesHolder;

public class Main_Sales {
    public static void main(String[] args) {
        List<Sales> salesList = SalesHolder.getSalesList();
        Map<String, Integer> resultMap = salesList.parallelStream() //【1】
                .filter(sales -> sales.getProductName().startsWith("A"))
                .map(sales -> {
                    String newName = sales.getProductName().replace("-", "");
                    return new Sales(sales.getId(), newName, sales.getCount());
                    })
                .collect(Collectors.groupingBy(
                        Sales::getProductName,
                        Collectors.summingInt(Sales::getCount)));

        for (String key : resultMap.keySet()) {
            System.out.println(key + " => " + resultMap.get(key));
        }
    }
}