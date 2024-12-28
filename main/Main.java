
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
        int[][] grid1=
                {
                    {3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {7, 0, 0, 5, 0, 1, 0, 0, 0, 0},
                    {0, 0, 5, 0, 0, 1, 0, 5, 0, 0},
                    {0, 0, 1, 5, 0, 1, 0, 0, 0, 0},
                    {0, 0, 5, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 1, 1, 5, 1, 0, 1, 0, 0},
                    {0, 5, 0, 0, 0, 0, 5, 1, 0, 0},
                    {0, 0, 1, 5, 0, 5, 0, 1, 0, 0},
                    {0, 0, 1, 0, 0, 0, 5, 0, 0, 0},
                    {0, 0, 1, 0, 0, 5, 0, 0, 0, 9}
                };
        int[][] grid2={
                    {3, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {7, 0, 0, 5, 0, 1, 0, 0, 1, 0},
                    {0, 0, 5, 0, 0, 1, 0, 5, 1, 0},
                    {0, 0, 1, 5, 0, 1, 0, 0, 0, 0},
                    {5, 0, 5, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                    {0, 5, 0, 0, 0, 0, 5, 0, 1, 0},
                    {5, 0, 1, 5, 0, 5, 0, 0, 1, 0},
                    {0, 0, 1, 0, 0, 0, 5, 0, 1, 0},
                    {0, 0, 1, 0, 0, 5, 0, 5, 0, 9}
        };
        int[][] grid3={
            {3, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {7, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 5, 0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 5, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 5, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 5, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 5, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 9}
        };
        map Map1=new map("map1",grid1,9,9,1,0);
        map Map2=new map("map2",grid2,9,9,1,0);
        map Map3=new map("map 3",grid3,9,9,1,0);
        Map1.setNextMap(Map2);
        Map2.setPreviousMap(Map1);
        Map2.setNextMap(Map3);
        Map3.setPreviousMap(Map2);





        gameSystem sys=new gameSystem(Map1, mainplayer, 0, 0);
        Marketplace market=new Marketplace();
        AncientTemple temple=new AncientTemple();
        Drugs drugs=new Drugs();
        mainplayer.setInventory(mainplayer.getInventory() , sys);
        int status=1;
        map currentMap = Map1;
        while (status==1) {
            System.out.println("nhap instruction");

            
            
            String instruction=scanner.nextLine();




            if (instruction .equals("w") || instruction.equals("a")||instruction.equals("s")||instruction.equals("d")) {
              
                mainplayer.move(instruction, sys);
                
                if (mainplayer.getX()==sys.getMap().getEndpointX() && mainplayer.getY()==sys.getMap().getEndpointY()) {
                    System.out.println("You have reached the endpoint of the map");
                    if (sys.getMap().getNextMap()!=null) {
                        sys.getMap().getGrid()[mainplayer.getX()][mainplayer.getY()]=9;
                        System.out.println("Loading map "+sys.getMap().getNextMap().getName());
                        sys.setMap(sys.getMap().getNextMap());
                        mainplayer.setX(0);
                        mainplayer.setY(0);


                    }
                    
                    
                }
   
                if (mainplayer.getX()==sys.getMap().getBackmapX() && mainplayer.getY()==sys.getMap().getBackmapY()) {
                    System.out.println("You have reached the backmap of the map");
                    if (sys.getMap().getPreviousMap()!=null) {
                        sys.getMap().getGrid()[mainplayer.getX()][mainplayer.getY()]=7;
                        System.out.println("Loading map "+sys.getMap().getPreviousMap().getName());
                        sys.setMap(sys.getMap().getPreviousMap());
                        mainplayer.setX(sys.getMap().getGridHeight()-2);
                        mainplayer.setY(sys.getMap().getGridWidth()-2);
                    }
                    
                }
               
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
                    currentMap.updateMonsters();
                    break;
                case "end":
                    status=0;
                    break;
                case "usingskill":
                    sys.process_use_skill(scanner);
                    break;
                case "temple":
                    sys.process_learn_skill(temple,scanner);
                    break;
                case "player status":
                    break;
                default:
                    System.out.println("Invalid instruction!!");
            }
           
        }
        
    }
    
}
