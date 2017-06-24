package com.amardeep.utils;

import org.modelmapper.ModelMapper;

public class AppUtils {
	
	private static ModelMapper modelMapper=new ModelMapper();
	
	public static ModelMapper getMapper(){
		return modelMapper;
	}

}
