package com.clean.code.solid.ocp.lsp.badrequest;

import com.clean.code.exceptions.CannotWalkException;

public class Delphin extends Mammal {

	  @Override
	    public void walk() {
	        throw new CannotWalkException("I am a dolphin, I cannot walk!");
	    }
}
