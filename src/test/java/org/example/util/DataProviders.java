package org.example.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviders {
    @DataProvider
    public static Iterator<Object[]> dataProviderFirst() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/dataFirst.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> dataProviderCreateList() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/createList.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
    @DataProvider
    public static Iterator<Object[]> dataProviderLoginEmailIncorrect() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class
                        .getResourceAsStream("/loginIncorrect.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> dataProviderSecond() {
        List<Object[]> data = new ArrayList();
        data.add(new Object[]{"alexandra13sark@gmail.com", "alex613e"});
        data.add(new Object[]{"alexandra13sark@gmail.com", "data22"});
        data.add(new Object[]{"alexandra13sark@gmail.com", "alex613e"});

        return data.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataProviderThird() {
        List<Object[]> data = new ArrayList();

        for(int i = 0; i < 4; ++i) {
            data.add(new Object[]{this.generateRandomName(),this.generateRandomPassword()});
        }

        return data.iterator();
    }


    private Object generateRandomName() {

        return "demo" + (new Random()).nextInt()+"@gmail.com";
    }

    private Object generateRandomPassword() {

        return "pass" + (new Random()).nextInt();
    }
    @DataProvider
    public Iterator<Object[]> dataProviderCreateListRandom() {
        List<Object[]> data = new ArrayList();
        for(int i = 0; i < 3; ++i) {
            data.add(new Object[]{this.generateRandomString2(2,8)});
        }
        return data.iterator();
    }

    private Object generateRandomString1() {
        String symbols = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
        Random random = new Random();
        String title="";
        for (int i = 2; i < 10 ; i++)
            title += symbols.charAt(random.nextInt(symbols.length()));

        return title;

    }
    public String generateRandomString2(int min,int max) {
        String str = "";
        int length = 0;
        int i = 0;
        int number;
        if (min > max) return "";
        Random gen = new Random();
        length = min + gen.nextInt(max - min +1);
        do {
            number = '0' + gen.nextInt('z' - '0' + 1);
            if ((number < 58 || number > 96 || (number > 64 && number < 91)))
            {
                str = str + (char) number;
                i++;
            }
        }
        while (i < length);

        return str;
    }


}

