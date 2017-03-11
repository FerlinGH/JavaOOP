package net.ukr.grygorenko_d;

import java.math.BigInteger;

public class MyThread implements Runnable {
	private BigInteger number;

	public MyThread(BigInteger number) {
		super();
		this.number = number;
	}

	public MyThread() {
		super();
	}

	public BigInteger factorial (BigInteger x){
		BigInteger res = BigInteger.ONE;
		if(x == BigInteger.ZERO){
			return BigInteger.ONE;
		}else{
			res = x.multiply(factorial(x.subtract(BigInteger.ONE)));
		}
		return res;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +  ": factorial of " + number + " is " + factorial(number));
	}

}
