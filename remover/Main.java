package remover;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void removeOggy(ArrayList<String> names) {
        
        int i = 0;
	//i is used as index of vector.
	while (i < names.size())
	{
		//startwith function returns true if string starts with provided substring else returns false.
		if (startwith(names.get(i), "oggy"))
		{
			//calling removeString function
			//vector colour is passed as address to remove the string from original address 
			removeString(names, i);

		}
		else
		{
			//if not start with substring increment index by 1.
			i++;
		}

	};
        return;
    }
    public static boolean oggyIsRemoved(ArrayList<String> names) {
        List<String> oggys = names.stream().filter(it -> it.contains("oggy")).collect(Collectors.toList());
        return oggys.size() == 0;
    }
    public static boolean startwith(String cmp, String start)
    {
    	//if string is smaller than substring return false.
    	int cmp_length=cmp.length();
    	int start_length=start.length();
    	if (cmp_length < start_length)
    	{
    		return false;
    	}
    	else
    	{
    		int i = 0;
    		while (i < start_length)
    		{
    			//comparing characters position by position
    			if (cmp.charAt(i) == start.charAt(i))
    			{
    				i++;
    			}
    			else
    			{
    				return false;
    			}
    		};
    		return true;
    	}
    }
    public static void removeString(ArrayList<String> vect, int index)
    {
    	int vect_size=vect.size();
    	for (int i = index; i < vect_size - 1; i++)
    	{
    		vect.set(i, vect.get(i+1));
    		//vect.get(i) = vect.get(i + 1);
    	}
    	//removing last string from vector.
    	int last_index=vect_size-1;
    	vect.remove(last_index);
    }
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("nobita", "bheem", "oggy", "oggy cockroach", "ninja"));
        removeOggy(names);
        if(oggyIsRemoved(names)) {
            System.out.println("Passed!");
            System.exit(0);
        } else {
            System.out.println("Failed!!");
            System.exit(1);
        }
    }
    
}
