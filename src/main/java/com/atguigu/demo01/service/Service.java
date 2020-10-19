package com.atguigu.demo01.service;

import com.atguigu.demo01.Utility;

import java.util.Map;

/**
 * @author CHENWEI
 * @create 2020-09-07 11:05
 */
public class Service {
    public static void particulars(Map map){
        System.out.println("-----------------当前收支明细记录----------------");
        System.out.println("收支\t\t账户金额\t\t收支金额\t\t说 明");
        if (map != null && map.size() > 0){
            System.out.println(map.get("mingXi"));
        }
        System.out.println("-------------------------------------------------");
    }
    public static Map income(Map map){
        System.out.print("本次收入金额：");
        int num = Utility.readNumber();
        System.out.print("说明：");
        //说明
        String readString = Utility.readString();
        if (map != null && map.size() > 0){
            int balance = (int) map.get("balance");
            balance = balance + num;
            String mingXi = (String) map.get("mingXi");
            mingXi = mingXi + "收入\t\t" + balance + "\t\t\t\t" + num + "\t\t\t" + readString + "\n";
            map.put("balance",balance);
            map.put("mingXi",mingXi);
            return map;
        }
        return null;
    }
    public static Map  expenditure(Map map){
        System.out.print("本次支出金额：");
        int num = Utility.readNumber();
        System.out.print("说明：");
        //说明
        String readString = Utility.readString();
        if (map != null && map.size() > 0){
            int balance = (int) map.get("balance");
            if (balance < num){
                System.out.println("余额不足");
                return map;
            }
            balance = balance - num;
            String mingXi = (String) map.get("mingXi");
            mingXi = mingXi + "支出\t\t" + balance + "\t\t\t\t" + num + "\t\t\t" + readString + "\n";
            map.put("balance",balance);
            map.put("mingXi",mingXi);
            return map;
        }
        return null;
    }
}
