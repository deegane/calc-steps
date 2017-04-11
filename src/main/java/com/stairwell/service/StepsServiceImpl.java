package com.stairwell.service;

import com.stairwell.validator.StepsValidator;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class StepsServiceImpl implements StepsService {

    private StepsValidator stepsValidator;

    private static int STEPS_TO_NEXT_FLIGHT = 2;

    public StepsServiceImpl(final StepsValidator stepsValidator) {
        this.stepsValidator = stepsValidator;
    }

    public int calcSteps(final List<Integer> stairwell, final int stepsPerStride)
            throws NullPointerException, IllegalArgumentException {

        stepsValidator.validate(stairwell, stepsPerStride);

        int totalSteps=0;

        for(Iterator<Integer> it = stairwell.iterator();it.hasNext();) {

            Integer i = it.next();

            int fullSteps = i / stepsPerStride;
            int stridesToFinishFlight = i % stepsPerStride == 0 ? 0 : 1;

            totalSteps+=fullSteps + stridesToFinishFlight;

            if(it.hasNext()) {
                totalSteps+=STEPS_TO_NEXT_FLIGHT;
            }
        }
        return totalSteps;
    }
}