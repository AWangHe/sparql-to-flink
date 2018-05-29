package org.univalle.rdf.runner.functions;

import org.apache.flink.api.common.functions.FilterFunction;

//SolutionMapping to SolutionMapping - Filter Function
public class SM2SM_FF implements FilterFunction<SolutionMapping> {

    private String expression = null;

    public SM2SM_FF(String expression){
        //System.out.println("********* FilterFunction Constructor *********");
        this.expression = expression;
    }

    @Override
    public boolean filter(SolutionMapping sm) {
        //System.out.println("********* FilterFunction in BatchQuery_AND_02: E_Equals *********");
        return sm.filter(expression);
    }

	public static class SM_KS2 {
    }
}
