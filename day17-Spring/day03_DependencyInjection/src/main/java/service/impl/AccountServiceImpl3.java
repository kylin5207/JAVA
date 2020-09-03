package service.impl;

import service.IAccountService;

import java.util.*;

/**
 * 复杂类型数据的依赖注入
 */

public class AccountServiceImpl3 implements IAccountService {

   private String[] myStrs;
   private List<String> myList;
   private Set<String> mySet;
   private Map<String,String> myMap;
   private Properties properties;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myList);
    }
}
