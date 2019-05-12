package kladionicaii.kladionica.utility;

import java.util.ArrayList;
import java.util.List;

// not used
public class CollectionConversion {

	public static <E> List<E> makeCollection(Iterable<E> iter) {
	    List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
	
}
