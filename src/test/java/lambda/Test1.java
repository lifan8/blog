package lambda;

import java.util.ArrayList;
import java.util.Collections;

public class Test1
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(10);
        list.add(3);
        list.add(34);
        list.add(40);
        Collections.sort(list, (x, y) -> x - y);

        System.out.println(list);
    }
}
