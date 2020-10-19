package com.atguigu.demo02;

import java.util.Arrays;

/**
 * @author CHENWEI
 * @create 2020-09-07 11:42
 */
public class CustomerList {
    // 用来保存客户对象的数组
    public Customer[] customers;
    //记录已保存客户对象的数量
    public int total = 0;

    /**
     * 用途：构造器，用来初始化customers数组
     *
     * @param：totalCustomer：指定customers数组的最大空间
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * 用途：将参数customer添加到数组中最后一个客户对象记录之后
     * 参数：customer指定要添加的客户对象
     * 返回：添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer) {
        if (total >= this.customers.length) {
            return false;
        }
        this.customers[total++] = customer;
        return true;
    }

    /**
     * 用途：用参数customer替换数组中由index指定的对象
     *
     * @param index 指定所替换对象在数组中的位置，从0开始
     * @param cust  customer指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer cust) {
        if (index >= total && index < 0) {
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 用途：从数组中删除参数index指定索引位置的客户对象记录
     * 参数： index指定所删除对象在数组中的索引位置，从0开始
     * 返回：删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index) {
        if (index >= total && index < 0) {
            return false;
        }
        for (int i = index ; i < total ; i++){
          customers[i] = customers[i+1];
        }
        customers[--total] = null;
        return true;
    }

    /**
     * 用途：返回数组中记录的所有客户对象
     * 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
     *
     * @return
     */
    public Customer[] getAllCustomers() {
        Customer[] allCustomers = Arrays.copyOf(this.customers, total);
        return allCustomers;
    }
    public int getTotal() {
        return total;
    }

    /**
     * 用途：返回参数index指定索引位置的客户对象记录
     * 参数： index指定所要获取的客户在数组中的索引位置，从0开始
     * 返回：封装了客户信息的Customer对象
     *
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        if (index < 0 && index >= total) return null;
        return customers[index];
    }


}
