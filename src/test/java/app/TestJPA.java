package app;

import util.Context;

public class TestJPA {


	public static void main(String[] args) {
		
		Context.getInstance().getEmf();
		
		Context.getInstance().closeEmf();

	}
}
