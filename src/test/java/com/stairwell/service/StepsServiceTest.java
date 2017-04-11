package com.stairwell.service;

import com.stairwell.validator.StepsValidator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StepsServiceTest {

    private StepsService stepsService;

    @Before
    public void before() {
        stepsService = new StepsServiceImpl(new StepsValidator());
    }

    @Test
    public void scenario1() throws NullPointerException, IllegalArgumentException {
        testSteps(Lists.newArrayList(17),3,6);
    }

    @Test
    public void scenario2() throws NullPointerException, IllegalArgumentException {
        testSteps(Lists.newArrayList(17,17),3,14);
    }

    @Test
    public void scenario3() throws NullPointerException, IllegalArgumentException {
        testSteps(Lists.newArrayList(4,9,8,11,7,20,14),2,50);
    }

    // error scenarios with expected exceptions...


    private void testSteps(List<Integer> stairwell, int stepsPerStride,int expected)
            throws NullPointerException, IllegalArgumentException {
        int steps = stepsService.calcSteps(stairwell, stepsPerStride);
        assert steps == expected;
    }
}