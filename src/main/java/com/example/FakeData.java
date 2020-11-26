package com.example;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Locale;

import static com.github.javafaker.CreditCardType.JCB;

public class FakeData {

    @Test
    public void test() {
        Faker faker = new Faker(Locale.CHINA);
        // 卢街62号
        System.out.println(faker.address().streetAddress());
        // 胡昊强
        System.out.println(faker.name().fullName());
        // By Grand Central Station I Sat Down and Wept
        System.out.println(faker.book().title());
        // 15128552972
        System.out.println(faker.phoneNumber().cellPhone());
        // Bytecard
        System.out.println(faker.app().name());
        // pink
        System.out.println(faker.color().name());
        // Fri Jan 29 16:04:50 CST 1960
        System.out.println(faker.date().birthday());
        // 000-63-7175
        System.out.println(faker.idNumber().invalid());
        System.out.println(faker.company().url());
        System.out.println(faker.finance().creditCard(JCB));
    }

    @Test
    public void JOBtest() {
        Faker faker = new Faker(Locale.CHINA);
        // 卢街62号
        System.out.println(faker.job().field());
        System.out.println(faker.job().keySkills());
        System.out.println(faker.job().position());

        System.out.println(faker.random().nextInt(1,100));
        System.out.println(faker.random());
        System.out.println(faker.country().name().toUpperCase());


        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i= 1;i<10;i++){
            String country= faker.country().name().toUpperCase();
            arrayList.add(country);

        }
        System.out.println(arrayList.toString());

        System.out.println(faker.random().nextInt(6));


    }


}
