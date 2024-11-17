package org.muberra;

import java.text.DecimalFormat;

public class TurkishConverter implements NumberConverter{
    private static final String[] tensNames={
            "",
            "on ",
            "yirmi ",
            "otuz ",
            "kırk ",
            "elli ",
            "altmış ",
            "yetmiş ",
            "seksen ",
            "doksan "
    };
    private static final String[] numNames={
            "",
            "bir ",
            "iki ",
            "üç ",
            "dört ",
            "beş ",
            "altı ",
            "yedi ",
            "sekiz ",
            "dokuz "
    };

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 10) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        if(number == 1) return "yüz " + soFar;
        return numNames[number] + "yüz " + soFar;
    }

    @Override
    public String convert(long number) {
        if (number == 0) {
            return "sıfır ";
        }

        if (number == 0) {
            return "sıfır ";
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3)); //milyar
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));//milyon
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));//bin
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions)
                        + "milyar ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions)
                        + "milyar ";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions)
                        + "milyon ";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions)
                        + "milyon ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "bin ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + "bin ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");

    }
}
