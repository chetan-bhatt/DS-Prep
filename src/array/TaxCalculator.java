package array;

import java.util.Arrays;

public class TaxCalculator {
	
	public Float calculateTax(Float income, Float[][] bracket) {
		if(income == null || income == 0.0 || bracket == null || bracket.length == 0) {
			return 0f;
		}
		
		return iterativeHelper(income, bracket);
		
		//return helper(income, bracket, 0);
	}
	
	private Float iterativeHelper(Float income, Float[][] bracket) {
		
		Float tax = 0f;
		int index = 0;
		while(income > 0 && index < bracket.length) {
			Float taxableIncome = bracket[index][0];
			if(taxableIncome == null) {
				tax += bracket[index][1] * income;
			} else {
				if(taxableIncome > income) {
					taxableIncome = income;
				}
				tax += taxableIncome * bracket[index][1];
				income = income - taxableIncome;
			}
			index++;
		}
		return tax;
	}
	
	private Float helper(Float income, Float[][] bracket, int index) {
		if(index >= bracket.length || income <= 0f) {
			return 0f;
		}
		
		if(bracket[index][0] == null) {
			return (float) (bracket[index][1] * income);
		}
		
		Float taxableIncome = bracket[index][0];
		if(taxableIncome > income) {
			taxableIncome = income;
		}
		
		return taxableIncome * bracket[index][1] + helper(income - taxableIncome, bracket, index + 1);
		
	}
	
	public static void main(String[] args) {
		TaxCalculator calculator = new TaxCalculator();
		Float[][] bracket = {
								{10000f, .1f},
								{20000f, .2f},
								{10000f, .3f},
								{null, .4f}
							};
		
		Float tax = calculator.calculateTax(50000f, bracket);
		System.out.println(tax);
	}

}
