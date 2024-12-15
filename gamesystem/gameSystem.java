
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
    public void start(){
        
    }

    public void updateAbility(){
        for(int i=0;i<=4;i++){
            Items items=player.getInventory()[i];
            String fetch=items.getType();
            if (fetch=="Weapon") {
                player.setAttackPoint(player.getAttackPoint()+items.getAttributePoints());;
            }
            if (fetch=="Armor") {
                player.setDefensePoint(player.getDefensePoint()+items.getAttributePoints());;
            }
            if (fetch=="Drug") {
                Potion drug= (Potion)items;
                for (int j=0;j<drug.getDuration();j++){
                    player.setHP(player.getHP()+drug.getAttributePoints());
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){   
                        System.err.println(e.getMessage());                     
                    }
                }
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
        if (currentMap.checkendpoint()==true) {
            currentMap=currentMap.nextmap();
        }
    }
}
