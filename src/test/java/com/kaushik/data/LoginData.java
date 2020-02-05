package com.kaushik.data;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LoginData {
    @DataProvider
    public Object [] []  loginProvider()
    {
        Object [][] data =  { {"Kaushik","pass123"},{"Swati","3h43kj43"},{"Gauthami","skjhshd"} };
        return data;
    }

    @DataProvider
    public Iterator<Object []> fancyLogin()
    {
        List<Object []> data = new ArrayList<>();
        data.add(Arrays.asList("Tom Hanks","TomHanks123").toArray());
        data.add(Arrays.asList("Hrithik Roshan","HK123").toArray());
        data.add(Arrays.asList("John De","JD1123").toArray());
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object []> dataFromExcel()
    {
        ExcelReader excelReader = new ExcelReader();
        List<Object[]> logins = excelReader.getDataFromSheet("Logins", false);
        return logins.iterator();
    }
}
