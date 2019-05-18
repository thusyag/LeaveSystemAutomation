package com.TecIT.LMS.testData;

import com.TecIT.LMS.utils.ExcelDataConfig;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class LoginData extends ExcelDataConfig {
    private static final Logger LOGGER = Logger.getLogger(LoginData.class);

    public LoginData () {
        super("src\\test\\resources\\ExcelFile\\LMS.xlsx");
    }



    @DataProvider(name = "Login")
    public Object[][] Login() {

        int rows = getRowCount("Login");
        int col = getColumnCount("Login");

        LOGGER.info("row = "+ rows + " columns = "+ col);

        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = getData("Login", i, j);
            }
        }
        return data;
    }


}
