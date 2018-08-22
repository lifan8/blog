package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream2 {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        Optional<Integer> nums = list.stream().collect(Collectors.reducing((i, j)->i+j));
        int sum =  list.stream().mapToInt(i->i).sum();
        System.out.println(sum);
    }
}
