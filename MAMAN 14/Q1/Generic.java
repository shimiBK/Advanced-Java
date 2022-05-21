import java.util.Iterator;

/*
* Generic Methods gets a set and returns the min value
 */
public class Generic {

    static <T extends Comparable>T findMin(Set<T> set){

       Iterator<T> it = set.iterator();
       if(!it.hasNext())
           return null;
        T minValue = it.next();


        while(it.hasNext())
        {
            T nextValue = it.next();
            if (nextValue.compareTo(minValue) < 0)
                    minValue = nextValue;
        }

        return minValue;
    }
}
