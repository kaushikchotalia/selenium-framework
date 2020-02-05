package com.kaushik.testcaes;

import com.kaushik.data.LoginData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @Test(dataProvider = "loginProvider", dataProviderClass = LoginData.class)
    public void login(String user, String password)
    {
        System.out.println("Username from Data Provider - "+user);
        System.out.println("Password from Data Provider - "+password);
    }

    @Test(dataProvider = "fancyLogin", dataProviderClass = LoginData.class)
    public void loginGetDataThroughIterator(String user, String password)
    {
        System.out.println("Username from Data Provider - "+user);
        System.out.println("Password from Data Provider - "+password);
    }

    @Test(dataProvider = "dataFromExcel", dataProviderClass = LoginData.class)
    public void loginGetDataFromExcel(String user, String password)
    {
        System.out.println("Username from Data Provider - "+user);
        System.out.println("Password from Data Provider - "+password);
    }
}
