import java.util.List;
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
        for(int i=0;i<=4;i++){
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
    public void progressMove(int newX,int newY){
        this.savepointx=newX;
        this.savepointy=newY;
        changemap();
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
    public void processing_market(Marketplace market){
        market.showItems();
        while (true) {
            Scanner scan=new Scanner(System.in);
            String instruction=scan.nextLine();
            if (instruction=="buy weapon"&&player.getInventory().size()<Player.getMaxItemsNumber()) {
                System.out.println("type weapon number: ");
                int order=scan.nextInt();
                List<Items> re= player.getInventory();
                re.add(market.getWeapons().get(order));
                player.setInventory(re, this);
            }
            else if (instruction=="buy armor" && player.getInventory().size()<Player.getMaxItemsNumber()) {
                System.out.println("type armor number: ");
                int order=scan.nextInt();
                List<Items> re= player.getInventory();
                re.add(market.getArmors().get(order));
                player.setInventory(re, this);
            }
            else if (instruction=="exit market") {
                System.out.println("Exitting the Marketplay");
                break;
            }else{
                System.out.println("Invalid Operation!!!");
            }
            scan.close();
        }

    }
    public void processing_drug(Drugs drugs){
        drugs.showPotions();
        while (true) {
            Scanner scan= new Scanner(System.in);
            String instruction=scan.nextLine();
            if (instruction=="buy potion" && player.getInventory().size()<Player.getMaxItemsNumber()) {
                System.out.println("type potion number: ");
                int order=scan.nextInt();
                List<Items> re= player.getInventory();
                re.add(drugs.getPotions().get(order));
                player.setInventory(re, this);
            }
            else if (instruction=="exit drugs") {
                System.out.println("Exitting drugstore!!");
                break;
            }else{
                System.out.println("Invalid Operation!!!");
            }
            scan.close();
        }
    }
}