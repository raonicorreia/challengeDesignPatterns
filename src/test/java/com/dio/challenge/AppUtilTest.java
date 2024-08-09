package com.dio.challenge;

import com.dio.challenge.common.AppUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class AppUtilTest {

    @Test
    void numbersToString() {
        String resut = AppUtil.numbersToString(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        Assertions.assertEquals("1;2;3;4;5;6", resut);
    }
}
