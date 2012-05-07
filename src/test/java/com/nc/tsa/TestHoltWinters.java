package com.nc.tsa;

import org.junit.Assert;
import org.junit.Test;

public class TestHoltWinters {

    @Test
    public void forecastNISTData() {

        /**
         * NIST data available at:
         * http://www.itl.nist.gov/div898/handbook/pmc/section4/pmc436.htm
         */
        long[] y = { 362, 385, 432, 341, 382, 409, 498, 387, 473, 513, 582, 474,
                544, 582, 681, 557, 628, 707, 773, 592, 627, 725, 854, 661 };
        int period = 4;
        int m = 4;

        double alpha = 0.5;
        double beta = 0.4;
        double gamma = 0.6;

        double[] prediction = HoltWinters.forecast(y, alpha, beta, gamma,
                period, m);

        // These are the expected results
        double[] expected = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                594.8043646513713, 357.12171044215734, 410.9203094983815,
                444.67743912921156, 550.9296957593741, 421.1681718160631,
                565.905732450577, 639.2910221068818, 688.8541669002238,
                532.7122406111591, 620.5492369959037, 668.5662327429854,
                773.5946568453546, 629.0602103529998, 717.0290609530134,
                836.4643466657625, 884.1797655866865, 617.6686414831381,
                599.1184450128665, 733.227872348479, 949.0708357438998,
                748.6618488792186 };
        Assert.assertArrayEquals("Forecast does not match", expected,
                prediction, 0.0000000000001);
    }
}
