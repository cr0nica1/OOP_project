import java.util.Scanner;
import map;
import item;
import monster;
import marketplace;
import player;
public class main {

    public static void main(){
        system Sys= new system(map_1, mainplayer, 0, 0);
        String ins=new String();
        int status=0;
        Scanner scanner=new Scanner(System.in);
        status=scanner.nextInt();
        if (status==0) {
            ins="exit";
        }else{
            ins="start";
        }
        if (ins=="start") {
            Sys.start();
        }
        if (ins=="exit") {
            Sys.endgame();
        }
    }
}
