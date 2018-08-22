package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Stream1 {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("I am a boy");
        list.add("I love the girl");
        list.add("But the girl loves another girl");

        List<String[]> lists = list.stream()
                .map(line->line.split(" "))
//                .flatMap(Arrays::stream)
//                .distinct()
                .collect(toList());

        for(String[] i : lists){
            System.out.println(i+"");
        }
    }
}
