
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
        if (currentMap.checkEndpoint(savepointx, savepointy)==true) {
            currentMap=currentMap.loadMap();;
        }
    }
}
