package Programmers.해시_빈출_상;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 11 : 10
public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = solution(genres, plays);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i] + " ");
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<Genre> arrayList = new ArrayList<>();
        for (String key : genrePlays.keySet()) {
            arrayList.add(new Genre(key, genrePlays.get(key)));
        }
        Collections.sort(arrayList);

        ArrayList<Song> songs = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(i, genres[i], plays[i]));
        }
        Collections.sort(songs);

        ArrayList<Integer> answerArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String findGenre = arrayList.get(i).genre;
            int findNum = 2;
            for (int j = 0; j < songs.size(); j++) {
                if (songs.get(j).genres.equals(findGenre) && findNum > 0) {
                    answerArrayList.add(songs.get(j).index);
                    findNum--;
                }
            }
        }

        int[] answer = new int[answerArrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerArrayList.get(i);
        }
        return answer;
    }
}

class Genre implements Comparable<Genre> {
    public int plays;
    public String genre;

    public Genre(String genre, int plays) {
        this.plays = plays;
        this.genre = genre;
    }

    @Override
    public int compareTo(Genre o) {
        if (this.plays > o.plays) {
            return -1;
        } else if (this.plays < o.plays) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Song implements Comparable<Song> {
    public int index;
    public String genres;
    public int plays;

    public Song(int index, String genres, int plays) {
        this.genres = genres;
        this.index = index;
        this.plays = plays;
    }

    @Override
    public int compareTo(Song o) {
        if (this.plays > o.plays) {
            return -1;

        } else if (this.plays < o.plays) {
            return 1;
        } else {
            return 0;
        }
    }
}