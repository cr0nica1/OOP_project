import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class gameSystem {
    map currentMap;
    Player player;
    int savepointx;
    int savepointy;

    public gameSystem( map Map,Player player,int savepointx, int savepointy){
        this.currentMap=Map;
        this.player=player;
        this.savepointx=savepointx;
        this.savepointy=savepointy;
    }
    public void init(){
        
    }

    public void updateAbility(){
        for(int i=0;i<player.getInventory().size();i++){
            Items items=player.getInventory().get(i);
            String fetch=items.getType();
            if (fetch=="Weapon") {
                player.setAttackPoint(player.getAttackPoint()+items.getAttributePoints());;
            }
            if (fetch=="Armor") {
                player.setDefensePoint(player.getDefensePoint()+items.getAttributePoints());;
            }
        }
    }
    public void processMove(int newX,int newY){
        this.savepointx=newX;
        this.savepointy=newY;
        changemap();
        currentMap.displayMapInfo();
    }
    public void endgame(){
        System.exit(0);
    }
    public void changemap(){
        if (currentMap.loadMap(player)!=null) {
            currentMap=currentMap.loadMap(player);
            this.savepointx=player.getX();
            this.savepointy=player.getY();                        
        }
    }
    public void processing_market(Marketplace market,Scanner scan){
        System.out.println("in thu");
        market.showItems();
        while (true) {

                    
                    String instruction=scan.nextLine();
                   
                    if (instruction.equals("buy weapon")&&player.getInventory().size()<Player.getMaxItemsNumber()) {
                        System.out.println("type weapon number: ");
                        int order=scan.nextInt();
                        List<Items> re= player.getInventory();
                        re.add(market.getWeapons().get(order));
                        player.setInventory(re, this);    
                                   
                    }
                    else if (instruction.equals("buy armor") && player.getInventory().size()<Player.getMaxItemsNumber()) {
                        System.out.println("type armor number: ");
                        int order=scan.nextInt();
                        List<Items> re= player.getInventory();
                        re.add(market.getArmors().get(order));
                        player.setInventory(re, this);
                    }
                    else if (instruction.equals("exit market")) {
                        System.out.println("Exitting the Marketplay");
                        break;
                    }
                    
                }
                
    }
    public void processing_drug(Drugs drugs,Scanner scan){
        drugs.showPotions();
        while (true) {
            
            String instruction=scan.nextLine();
            if (instruction.equals("buy potion") && player.getInventory().size()<Player.getMaxItemsNumber()) {
                System.out.println("type potion number: ");
                int order=scan.nextInt();
                List<Items> re= player.getInventory();
                re.add(drugs.getPotions().get(order));
                player.setInventory(re, this);
                System.out.println("test");
            }
            else if (instruction.equals("exit drugs")) {
                System.out.println("Exitting drugstore!!");
                break;
            }
            
        }
    }
    public void process_attack(){
        Monster monster=scan_monster();
        if (monster!=null) {
            player.attack(monster);
            System.out.println(monster.toString());
        }
    }
    public Monster target(Monster[] monster,int x, int y){
        for(int i=0;i<monster.length;i++){
            if (x==monster[i].getX()&&y==monster[i].getY()) {
                return monster[i];
            }
        }
        return null;
    }
    public Monster scan_monster(){
       int[] dRow = {-1, 1, 0, 0};
       int[] dCol = {0, 0, -1, 1};
       Queue<int []> q= new LinkedList<>();
       boolean[][] visited=new boolean[currentMap.getGridHeight()][currentMap.getGridWidth()];
       q.add(new int[]{player.getX(), player.getY()});
       visited[player.getX()][player.getY()]=true;
       while (!q.isEmpty()) {
            int [] current =q.poll();
            int row=current[0];
            int col=current[1];
            
            if (row<(currentMap.getGridHeight())&&col<(currentMap.getGridWidth())&&row<currentMap.getGridWidth()&&col<currentMap.getGridHeight()) {
                
            
                if (currentMap.getGrid()[row][col]==5) {
                return target(currentMap.getMonsters(),row,col);
                }
            }
            System.out.println("Duyệt ô: (" + row + ", " + col + ")");
            for(int i =0;i<4;i++){
                int newRow=row+dRow[i];
                int newCol=col+dCol[i];
                if (newCol>=0 &&newRow>=0&&newCol<currentMap.getGridWidth()&&newRow<currentMap.getGridHeight()) {
                    
                
                if (visited[newRow][newCol]==false&&row>=0&&row<currentMap.getGridHeight()&&col<currentMap.getGridWidth()&&col>=0) {
                    q.add(new int[]{newRow,newCol});
                    visited[newRow][newCol]=true;

                }
            }
            }

            
       }
       return null;
    }
}
