package stream.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
        List<User> users = new ArrayList<User>();
        users.add(new User(22, "王旭", "123456", (short)1, true));
        users.add(new User(22, "王旭", "123456", (short)1, true));
        users.add(new User(22, "王旭", "123456", (short)1, true));
        users.add(new User(21, "孙萍", "a123456", (short)2, false));
        users.add(new User(23, "步传宇", "b123456", (short)1, false));
        users.add(new User(18, "蔡明浩", "c123456", (short)1, true));
        users.add(new User(17, "郭林杰", "d123456", (short)1, false));
        users.add(new User(5, "韩凯", "e123456", (short)1, true));
        users.add(new User(22, "韩天琪", "f123456", (short)2, false));
        users.add(new User(21, "郝玮", "g123456", (short)2, false));
        users.add(new User(19, "胡亚强", "h123456", (short)1, false));
        users.add(new User(14, "季恺", "i123456", (short)1, false));
        users.add(new User(17, "荆帅", "j123456", (short)1, true));
        users.add(new User(16, "姜有琪", "k123456", (short)1, false));

//        List<User> usersSort = users.stream().sorted().distinct().collect(Collectors.toList());
//        System.out.println(usersSort.size());
//
//        List<User> usersFilt = users.stream().filter(i->i.getName().startsWith("韩")&&i.getGendar()==2).collect(Collectors.toList());
//        System.out.println(usersFilt.size());
//
//        List<String> usersStr = users.stream().map(i->i.getName()+":".concat(i.getAge().toString())).collect(Collectors.toList());
//        System.out.println(usersStr.size());
//
//        int sum = users.stream().filter(i->i.getName().equals("王旭")).mapToInt(i->i.getAge()).sum();
//        System.out.println(sum);
//
//        users.stream().filter(i->i.getName().startsWith("韩")).forEach(System.out::println);

    }
}
