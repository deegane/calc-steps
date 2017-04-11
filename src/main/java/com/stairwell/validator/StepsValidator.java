package com.stairwell.validator;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class StepsValidator {

    public void validate(final List<Integer> flights,
                         final int stepsPerStride) {

        validateStairWell(flights);
        validateSteps(stepsPerStride);
    }

    private void validateStairWell(final List<Integer> flights) throws NullPointerException, IllegalArgumentException {

        Objects.requireNonNull(flights, "invalid stairwell parameter");

        Preconditions.checkArgument(flights.size()>=1 && flights.size() <=30,
                "invalid stairwell flight size");

        validateStepsPerFlight(flights);
    }

    private void validateStepsPerFlight(final List<Integer> flights) throws NullPointerException, IllegalArgumentException {

        for(Integer flight : flights) {
            if(flight==null) {
                throw new NullPointerException("stairwell contains a null flight value");
            }
            if(flight>20) {
                throw new IllegalArgumentException("stairwell contains a flight with invalid size");
            }
        }
    }

    private void validateSteps(final int stepsPerStride) throws IllegalArgumentException {
        Preconditions.checkArgument(stepsPerStride >= 1 && stepsPerStride <= 4,
                "invalid stepsPerStride");
    }
}