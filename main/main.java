import java.util.List;
import java.util.Scanner;

public class Main {

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
                market.showItems();
        
                // buy items processing
                while (true) {
                    instruction=scan.nextLine();
                    if (instruction=="buy weapon") {
                        System.out.println("type weapon number: ");
                        int order=scan.nextInt();
                        List<Items> re= mainplayer.getInventory();
                        re.add(market.getWeapons().get(order));
                        mainplayer.setInventory(re, sys);                       
                    }
                    else if (instruction=="buy armor") {
                        System.out.println("type armor number: ");
                        int order=scan.nextInt();
                        List<Items> re= mainplayer.getInventory();
                        re.add(market.getArmors().get(order));
                        mainplayer.setInventory(re, sys);
                    }
                    else if (instruction=="exit market") {
                        System.out.println("Exitting the Marketplay");
                        break;
                    }else{
                        System.out.println("Invalid Operation!!!");
                    }
                }

            }
            //buy potion processing
            if (instruction=="drugs") {
                drugs.showPotions();
                instruction=scan.nextLine();
                while (true) {
                    instruction=scan.nextLine();
                    if (instruction=="buy potion" && mainplayer.getInventory().size()<Player.getMaxItemsNumber()) {
                        System.out.println("type potion number: ");
                        int order=scan.nextInt();
                        List<Items> re= mainplayer.getInventory();
                        re.add(drugs.getPotions().get(order));
                        mainplayer.setInventory(re, sys);
                    }
                    else if (instruction=="exit drugs") {
                        System.out.println("Exitting drugstore!!");
                        break;
                    }else{
                        System.out.println("Invalid Operation!!!");
                    }
                }
            }
            // attack processing
            if(instruction=="attack"){
                
            }
        }
        
    }
    
}
