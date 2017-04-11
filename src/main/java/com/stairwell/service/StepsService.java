package com.stairwell.service;

import java.util.List;

public interface StepsService {

    int calcSteps(final List<Integer> params, final int stepsPerStride)
            throws NullPointerException, IllegalArgumentException;
}
