import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by ThinkPad on 2018/2/27.
 */
public class Main {

    public static void main(String[] arg){
     /*   System.out.println(   System.getProperty("java.io.tmpdir") );
        System.out.println(System.getProperty("os.name"));*/

        Integer i0 = new Integer(11);
        Integer i1 = new Integer(13);
        Integer i2 = new Integer(12);

        ArrayList arraylist = new ArrayList<Integer>();

        arraylist.add( i0 );
        arraylist.add( i1 );
        arraylist.add( i2 );


        java.util.Collections.sort(arraylist, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if ( o1.intValue() < o2.intValue())
                    return -1;
                return 0;
            }
        });
        //System.out.println(i1.compareTo( i2));


        Iterator<Integer> iterator = arraylist.iterator();
        while (iterator.hasNext()){
            System.out.println( iterator.next().intValue());
        }


    }
}
