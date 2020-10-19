package com.atguigu.demo02;

import sun.java2d.cmm.CMSManager;

/**
 * @author CHENWEI
 * @create 2020-09-07 11:42
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(5);

    /**
     * 用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
     */
    public void enterMainMenu() {
        boolean idFlag = true;
        while (idFlag) {
            System.out.println("-----------------客户信息管理软件-----------------\n");
            System.out.println("\t\t\t1 添加客户");
            System.out.println("\t\t\t2 修改客户");
            System.out.println("\t\t\t3 删除客户");
            System.out.println("\t\t\t4 客户列表");
            System.out.println("\t\t\t5 退\t出");
            System.out.print("\t\t\t请选择：");
            char choose = CMUtility.readMenuSelection();
            switch (choose) {
                case '1':
                    this.addNewCustomer();
                    break;
                case '2':
                    this.modifyCustomer();
                    break;
                case '3':
                    this.deleteCustomer();
                    break;
                case '4':
                    this.listAllCustomers();
                    break;
                case '5':
                    idFlag = false;
                    System.out.println("感谢使用，再见！");
                    break;
            }
        }

    }

    /**
     * 用途：这四个方法分别完成“添加客户”、“修改客户”、“删除客户”和“客户列表”等各菜单功能。
     */
    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------\n");
        System.out.print("姓名：");
        String name = CMUtility.readString(5);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(25);
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(age);
        customer.setGender(gender);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerList.addCustomer(customer);
        System.out.println("---------------------添加完成---------------------\n");

    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------\n");
        System.out.print("请选择待修改的客户编号：(-1退出)：");
        int index = CMUtility.readInt();
       if (index != -1 && index > 0){
           Customer customer = customerList.getCustomer(index - 1);
           System.out.println("姓名：（" + customer.getName() +")");
           String name = CMUtility.readString(5, customer.getName());
           System.out.println("性别：("+ customer.getGender() +")");
           char gender = CMUtility.readChar(customer.getGender());
           System.out.println("年龄：("+ customer.getAge() +")");
           int age = CMUtility.readInt(customer.getAge());
           System.out.println("电话：("+ customer.getPhone() +")");
           String phone = CMUtility.readString(13, customer.getPhone());
           System.out.println("邮箱：("+ customer.getEmail() +")");
           String email = CMUtility.readString(25, customer.getEmail());
           customer.setName(name);
           customer.setAge(age);
           customer.setGender(gender);
           customer.setPhone(phone);
           customer.setEmail(email);
           customerList.replaceCustomer(index - 1, customer);
           System.out.println("---------------------修改完成---------------------\n");
       }

    }

    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------\n");
        System.out.print("请选择待删除的客户编号：(-1退出)：");
        int index = CMUtility.readInt();
        System.out.print("确认是否删除（Y/N）：");
        char choose = CMUtility.readConfirmSelection();
        if ('Y' == choose) {
            customerList.deleteCustomer(index - 1);
            System.out.println("---------------------删除成功---------------------\n");
        }


    }

    private void listAllCustomers() {
        System.out.println("---------------------客户列表---------------------\n");
        System.out.println("编号\t姓名\t性别\t\t年龄\t\t电话\t\t\t\t\t邮箱");
        Customer[] allCustomers = customerList.getAllCustomers();
        for (int i = 0; i < allCustomers.length; i++) {
            Customer customer = allCustomers[i];
            System.out.println(i + 1 + "\t\t" + customer.getName() + "\t" + customer.getGender() + "\t\t\t" +
                    customer.getAge() + "\t\t\t" + customer.getPhone() + "\t\t\t" + customer.getEmail());
        }


    }

    /**
     * 用途：创建CustomerView实例，并调用 enterMainMenu()方法以执行程序。
     *
     * @param args
     */
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();

    }

}
