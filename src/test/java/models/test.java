package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class test {
    public static  void main(String[] args){
        Artist1 a1 = new Artist1();
        a1.city = "a";
        a1.setAge(1);
        Artist1 a2 = new Artist1();
        a2.city = "b";
        a2.setAge(4);
        Artist1 a3 = new Artist1();
        a3.city = "b";
        a3.setAge(6);
//        Artist1 a3 = new Artist1();
        Artist1 a4 = new Artist1();
        Artist1 a5 = new Artist1();

        Artist2 a6 = new Artist2();
        Artist2 a7 = new Artist2();

        List<Artist1> allArtists = new ArrayList<Artist1>();
        allArtists.add(a1);
        allArtists.add(a2);
        allArtists.add(a3);

        int count = 0;
        for(Artist3 artist: allArtists){
            if(artist.isFrom("London")){
                count++;
            }
        }

        long count2 = allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .limit(2)
                .count();

        List<String> cityList =allArtists.stream().map(artist->artist.city).collect(toList());

        System.out.println(count2);
        List <Integer> together = Stream.of(asList(1,2),asList(3,4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        together.forEach(n -> System.out.println(n));

//        Artist1 theMaxAgeArtist = allArtists.stream()
//                .max(Comparator.comparing(artist -> artist.getAge()))
//                .get();
//        System.out.println(theMaxAgeArtist.getAge());

//        int count = Stream.of(1,2,3,5,7,8)
//                .reduce(0,(acc,element) -> acc + element);
//        System.out.println(count);
    }

//    public static List<String> getArtistNamesAndNations(List<Artist1> artists){
//        return artists.stream().flatMap(artist -> artist.getName(),artist.getNationality()).collect(toList());
//    }

    public static List<Artist1> getAlbumsWithMostThreeTracks(List<Artist1> albums){
        return albums.stream()
                .filter(artist -> artist.getAge() <= 34)
                .collect(toList());
    }

//    public static int countAllArtistMembers(List<Aritst1> artists){
//        return artists.stream()
//                .map(artist -> artist.getMembers().count())
//                .reduce(0,Integer::sum);
//    }

//    public static int countAllArtistMembers(List<Artist1> artists) {
//        return artists.stream()
//                .mapToInt(artist -> artist.getMembers().count())//统计人数,转换成数值流
//                .sum();//对人数求和
//    }
//
//    public Stream<Artist> getMembers() {
//        return members.stream();
//    }

//    public static int countStringLowercaseLetters(String string){
//        return string.chars()//获得字母流
//                .filter(Character::isLowerCase)//筛选出所有小写字母
//                .count;//统计数量
//    }
}
