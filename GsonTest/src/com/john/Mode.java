package com.john;

import java.util.*;

public class Mode {

	public static int mode(int[] arr){ 
		int modeCount = 0;	
		int mode = 0;		

		int currCount = 0;	
		int currElement;
		
		for (int candidateMode : arr)
		{
			currCount = 0;
			

			for (int element : arr)
			{

				if (candidateMode == element)
				{
					currCount++;
				}
			}
			
			if (currCount > modeCount)
			{
				modeCount = currCount;
				mode = candidateMode;
			}
		}
		
		return mode;
    }
}
