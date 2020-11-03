package com.company;

import java.io.*;
import java.sql.SQLOutput;


public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите выражение используя +, -, *, /");

		String operation = reader.readLine();
		Calculator c = new Calculator(operation);
		c.deleteSpaces();
		c.getOperation();
		c.getOps();
		c.calculate();
		System.out.println(c.resultStr());





		//System.out.println(operation + " =" + calculator.calculate);

	}
}
