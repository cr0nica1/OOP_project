
public static void main(String[] args) {
        // Tạo một ma trận lưới 5x5 với các vị trí tường (1), ô trống (0), điểm kết thúc (9), vị trí quái vật (5) và vị trí người chơi (3)
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 1, 0, 0, 0, 0},
                {0, 3, 5, 0, 0, 1, 0, 5, 0, 0},
                {0, 0, 1, 5, 0, 1, 0, 0, 9, 0},
                {0, 0, 5, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 5, 1, 0, 1, 0, 0},
                {0, 5, 0, 0, 0, 0, 5, 1, 0, 0},
                {0, 0, 1, 5, 0, 5, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 5, 0, 0, 0},
                {0, 0, 1, 0, 0, 5, 0, 0, 0, 0}
        };
// 3 là người chơi 5 là quái vật

        class Creature {
                String name;
                int hp;
                int attack;
                int defense;
                float speed;
                int directionX, directionY;

                public Creature(String name, int hp, int attack, int defense, float speed, int directionX, int directionY) {
                        this.name = name;
                        this.hp = hp;
                        this.attack = attack;
                        this.defense = defense;
                        this.speed = speed;

                        this.directionX = directionX;
                        this.directionY = directionY;
                }

                public String getName() { return name; }
                public int getHP() { return hp; }
                public int getAttack() { return attack; }
                public int getDefense() { return defense; }
                public float getSpeed() { return speed; }

                public int getDirectionX() { return directionX; }
                public int getDirectionY() { return directionY; }
        }

        class Dragon extends Creature {
                public Dragon() {
                        super("Dragon", 100, 20, 10, 3, 1, 3);
                }
        }

        class Goblin extends Creature {
                public Goblin() {
                        super("Goblin", 50, 10, 5, 2.0f, 0, -1);
                }
        }

        class Troll extends Creature {
                public Troll() {
                        super("Troll", 200, 25, 15, 0.5f, 2, 2,);
                }
        }

        // Khởi tạo bản đồ với dữ liệu cụ thể
        map customMap = new map();
        customMap.grid = grid;
        customMap.monsters = monsters;
        customMap.endpointX = 8;
        customMap.endpointY = 3;
        customMap.name = "Dungeon";

        // Đặt quái vật vào các vị trí cụ thể trên bản đồ
        for (Monster monster : monsters) {
                customMap.grid[monster.getX()][monster.getY()] = 5;
        }

        // Hiển thị thông tin bản đồ
        customMap.displayMapInfo();
}

