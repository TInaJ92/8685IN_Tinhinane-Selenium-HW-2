package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class GenerateData {

    static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());
    static Faker faker = new Faker();

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String email() {
        String[] domains = {"gmail.com", "yahoo.com", "me.com", "live.com", "hotmail.com"};
        Random random = new Random();
        int randomNum = random.nextInt(5);
        String domain = domains[randomNum];

        return fakeValuesService.bothify("test_???????####@" + domain);
    }

    public static String streetAddress() {
        return String.format("%s %s", faker.address().streetAddressNumber(), faker.address().streetName());
    }

    public static String city() {
        return faker.address().city();
    }

    public static String state() {
        return faker.address().state();
    }

    public static String zipCode() {
        return faker.address().zipCode().substring(0, 5);
    }

    public static String mobilePhone() {
        return faker.phoneNumber().cellPhone().replace('.', '-');
    }

    public static String password() {
        return faker.bothify("!??##?$#?##?##??#");

    }

    public static String[] dateOfBirth() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date dob = faker.date().birthday();
        String formattedDob = df.format(dob);

        String year = formattedDob.substring(0, 4);
        String month = formattedDob.substring(4, 6);
        String day = formattedDob.substring(6);

        if (day.startsWith("0")) {
            day = day.substring(1);
        }

        if (month.startsWith("0")) {
            month = month.substring(1);
        }

        return new String[]{day, month, year};
    }

}
