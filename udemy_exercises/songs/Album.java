package udemy_exercises.songs;
import java.util.*;

class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for(Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public static void main(String[] args) {
        Album album = new Album("Ascend", "Illenium");
        album.addSong("I Care (Intro)", 0.33);
        album.addSong("Hold On", 3.55);
        album.addSong("Good Things Fall Apart", 3.36);
        album.addSong("That's Why", 4.12);
        album.addSong("Blood", 4.08);
        album.addSong("Take You Down", 3.41);
        album.addSong("All Together", 3.58);
        album.addSong("Crashing" , 3.50);
        album.addSong("Broken Ones" , 3.18);
        album.addSong("Every Piece of Me", 3.43);
        album.addSong("Takeaway", 3.29);
        album.addSong("Sad Songs", 3.30);
        album.addSong("Pray", 4.55);
        album.addSong("In Your Arms" , 3.40);
        album.addSong("Gorgeous", 4.37);
        album.addSong("Angel (Lonely Prelude)", 0.41);
        album.addSong("Lonely", 4.30);
        albums.add(album);

        album = new Album("Coloring Book", "Chance the Rapper");
        album.addSong("All We Got", 3.23);
        album.addSong("No Problem", 5.05);
        album.addSong("Summer Friends", 4.50);
        album.addSong("D.R.A.M. Sings Special", 1.41);
        album.addSong("Blessings", 3.41);
        album.addSong("Same Drugs", 4.17);
        album.addSong("Mixtape" , 4.52);
        album.addSong("Angels", 3.26);
        album.addSong("Juke Jam", 3.39);
        album.addSong("All Night", 2.21);
        album.addSong("How Great", 5.37);
        album.addSong("Smoke Break" , 3.46);
        album.addSong("Finish Line / Drown", 6.46);
        album.addSong("Blessings Again", 3.50);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Ascend", playList);
        albums.get(0).addToPlaylist("Coloring Book", playList);
        albums.get(0).addToPlaylist("Fractures", playList); // shouldn't work
        albums.get(0).addToPlaylist(7, playList);
        albums.get(1).addToPlaylist(8, playList);
        albums.get(1).addToPlaylist(12, playList);
        albums.get(1).addToPlaylist(27, playList); // There is no track 27

        play(playList);
    }

    private static void stop() {
        System.out.println("Playlist complete.");
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    stop();
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        } else {
                            System.out.println("The playlist is now empty");
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - to list songs in playlist\n" +
                "5 - to print available actions\n" +
                "6 - to remove current song\n");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==========================");
        while ((iterator.hasNext())) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
    }

}

/*
**Song Player w/ Java Classes**
     - **Album class** 
       - Playlist of **Songs**.
       - addPlayist() (songs must appear in the list in the order by which they were added)
       - stop()
       - nextSong()
       - previousSong()
       - repeatSong()
       - showPlaylist()
       - removePlaylist()
     - **A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)**
*/