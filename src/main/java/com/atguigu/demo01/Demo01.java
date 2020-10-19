package com.atguigu.demo01;

import com.atguigu.demo01.service.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CHENWEI
 * @create 2020-09-07 10:02
 */
public class Demo01 {
    public static void main(String[] args) {
        int balance = 10000;
        String mingXi = "收入\t\t" + balance + "\t\t\t" + balance + "\t\t\t" + "初始余额" + "\n";;
        Map map = new HashMap();
        map.put("balance",balance);
        map.put("mingXi",mingXi);
        boolean isFlag = true;
        while (isFlag){
            System.out.println("-----------------家庭收支记账软件----------------\n");
            System.out.println("\t\t\t\t1 收支明细 ");
            System.out.println("\t\t\t\t2 登记收入");
            System.out.println("\t\t\t\t3 登记支出");
            System.out.println("\t\t\t\t4 退    出\n");
            System.out.print("\t\t\t\t请选择（1-4）：");
            char choose = Utility.readMenuSelection();
            switch (choose){
                case '1' :
                    Service.particulars(map);
                    break;
                case '2' :
                    map = Service.income(map);
                    break;
                case '3' :
                    map = Service.expenditure(map);
                    break;
                case '4' :
                    isFlag = false;
                    System.out.println("已退出，谢谢使用");
                    break;

            }
        }



    }
}
