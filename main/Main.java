
import java.util.Scanner;

public class Main {
    Monster monster;
    
    public static void main (String [] args){
        
        String ins=new String();
        int status=0;
        Scanner scanner=new Scanner(System.in);
        status=scanner.nextInt();
        scanner.nextLine();
        if (status==0) {
            ins="exit";
        }else{
            ins="start";
        }
       
        if (ins=="start") {
            starting(scanner);
        }
        if (ins=="exit") {
            System.exit(0);
        }
        scanner.close();
    }
    public static void starting(Scanner scanner){
        Player mainplayer=new Player("Player_1");
        map default_map= new map();
        gameSystem sys=new gameSystem(default_map, mainplayer, 0, 0);
        Marketplace market=new Marketplace();
        Drugs drugs=new Drugs();
        mainplayer.setInventory(mainplayer.getInventory() , sys);
        int status=1;
        while (status==1) {
            System.out.println("nhap instruction");
            
            
            String instruction=scanner.nextLine();
            
            
            if (instruction .equals("w") || instruction.equals("a")||instruction.equals("s")||instruction.equals("d")) {
              
                mainplayer.move(instruction, sys);
                continue;
            }
            switch (instruction) {
                case "marketplace":
                    sys.processing_market(market,scanner);
                    break;
                case "drugs":
                    sys.processing_drug(drugs,scanner);
                    break;
                case "drop item":
                    sys.process_drop(scanner);
                    break;
                case "attack":
                    sys.process_attack();
                    break;
                case "end":
                    status=0;
                    break;
                case "usingskill":
                    break;
                case "player status":
                    break;
                default:
                    System.out.println("Invalid instruction!!");
            }
            
            
            
            
            
            
            
          
        }
        
    }
    
}
