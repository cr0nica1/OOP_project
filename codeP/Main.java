import java.util.Scanner;

public class Main {
    Monster monster;

    public static void main (String [] args){

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
            starting();
        }
        if (ins=="exit") {
            System.exit(0);
        }
        scanner.close();
    }
    public static void starting(){
        Player mainplayer=new Player("Player_1");
        map default_map= new map();
        gameSystem sys=new gameSystem(default_map, mainplayer, 0, 0);
        Marketplace market=new Marketplace();
        Drugs drugs=new Drugs();
        mainplayer.setInventory(mainplayer.getInventory() , sys);
        int status=1;
        while (status==1) {
            Scanner scan=new Scanner(System.in);
            String instruction=scan.nextLine();

            if (instruction =="w" || instruction=="a"||instruction=="s"||instruction=="d") {
                mainplayer.move(instruction, sys);
                continue;
            }
            if (instruction=="marketplace") {
                sys.processing_market(market);
                continue;
            }
            //buy potion processing
            if (instruction=="drugs") {
                sys.processing_drug(drugs);
                continue;
            }
            // attack processing
            if(instruction=="attack"){

            }

            if(instruction=="end"){
                break;
            }
            scan.close();
        }

    }

}