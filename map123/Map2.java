
public static void main(String[] args) {
    // Tạo một ma trận lưới 5x5 với các vị trí tường (1), ô trống (0), điểm kết thúc (9), vị trí quái vật (5) và vị trí người chơi (3)
    int[][] grid = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 5, 0, 0, 0, 0, 0, 1},
            {1, 3, 5, 0, 0, 0, 0, 5, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 9, 1},
            {1, 0, 0, 0, 0, 0, 0, 5, 0, 1},
            {1, 0, 0, 0, 0, 5, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 5, 0, 0, 0, 5, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
// 3 là người chơi 5 là quái vật

    class Creature {
        String name;
        int hp;
        int attack;
        int defense;
        float speed;
        int x, y;
        int directionX, directionY;

        public Creature(String name, int hp, int attack, int defense, float speed, int x, int y, int directionX, int directionY) {
            this.name = name;
            this.hp = hp;
            this.attack = attack;
            this.defense = defense;
            this.speed = speed;
            this.x = x;
            this.y = y;
            this.directionX = directionX;
            this.directionY = directionY;
        }

        public String getName() { return name; }
        public int getHP() { return hp; }
        public int getAttack() { return attack; }
        public int getDefense() { return defense; }
        public float getSpeed() { return speed; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getDirectionX() { return directionX; }
        public int getDirectionY() { return directionY; }
    }

    class Dragon extends Creature {
        public Dragon() {
            super("Dragon", 120, 20, 10, 1.5f, 3, 1, 1, 0);
        }
    }

    class Goblin extends Creature {
        public Goblin() {
            super("Goblin", 100, 25, 5, 2.0f, 1, 3, 0, -1);
        }
    }

    class Troll extends Creature {
        public Troll() {
            super("Troll", 300, 30, 15, 0.5f, 2, 2, -1, 0);
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

