import java.util.Arrays;

public class map {
    private String name;
    private int[][] grid; // Ma trận grid
    private Monster[] monsters; // Mảng quái vật
    private int endpointX; // Tọa độ x của điểm kết thúc
    private int endpointY; // Tọa độ y của điểm kết thúc
    private map nextMap;
    private map previousMap; // Bản đồ trước đó
    // Hằng số cho giá trị quái vật
    //private static final int MONSTER_VALUE = 5; // Giá trị đại diện cho quái vật
    //private static final int PLAYER_VALUE = 3; // Giá trị đại diện cho người chơi
    //private static final int OBSTACLE_VALUE = 1; // Giá trị đại diện cho chướng ngại vật

    // Constructor mặc định
    public map() {
        this(5, 9, 6, 6, 3); // Kích thước mặc định và số lượng quái vật mặc định
    }

    // Constructor với tham số
    public map(int rows, int cols, int endpointX, int endpointY, int monsterCount) {
        this.grid = new int[rows][cols];
        this.monsters = new Monster[monsterCount];
        this.endpointX = endpointX;
        this.endpointY = endpointY;


    }
    // Khởi tạo grid với dữ liệu cụ thể
    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], 0); // 0 có thể đại diện cho ô trống
        }
        // Đặt chướng ngại vật


        // Đặt vị trí người chơi
        //grid[playerX][playerY] = 3; // 3 đại diện cho người chơi

        // Đặt vị trí quái vật

        // Các quái vật khác có thể được thêm vào tại các tọa độ khác vào từng map rồi viết rõ
    }
    // Phương thức thiết lập bản đồ trước đó
    public void setPreviousMap(map previousMap) {
        this.previousMap = previousMap;
    }

    // Phương thức quay lại bản đồ trước đó
    // Phương thức load map
    public map loadMap(Player player) {
        if (check_previousMap(player)==true) {
            player.setX(previousMap.endpointX-1);
            player.setY(previousMap.endpointY-1);
            return previousMap;
            
        }
        if (checkEndpoint(player)==true) {
            player.setX(0);
            player.setY(0);
            return nextMap;
        }
        return null;
        
    }

    public boolean check_previousMap(Player player){
        if ((player.getX() == 0 && player.getY() == -1) || (player.getX() == -1 && player.getY() == 0)) {
            if (previousMap != null) {
                System.out.println("Quay lại bản đồ trước đó...");
                return true; // Trả về bản đồ trước đó
            } else {
                System.out.println("Không có bản đồ trước đó để quay lại.");
                return false;
            }
        }
        return false;
    }


// Phương thức kiểm tra điểm kết thúc
    public boolean checkEndpoint(Player player) {
        if (player.getX()==endpointX&&player.getY()==endpointY) {
            if (nextMap!=null) {
                System.out.println("Đang tải bản đồ"+nextMap.getName());
                return true;

            }else{
                System.out.println("không còn bản đồ.");
                return false;
            }
        }
        return false;

    
    }
// Getter cho kích thước grid
    public int getGridWidth() {
        return grid.length;
    }

    public int getGridHeight() {
        return grid[0].length;
    }

    // Getter cho số lượng quái vật
    public int getMonstersCount() {
        return this.monsters.length;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public int getEndpointX() {
        return endpointX;
    }

    public int getEndpointY() {
        return endpointY;
    }
    public String getName(){
        return name;
    }

    // Phương thức hiển thị thông tin về bản đồ
    private void displayMapInfo(map gameMap) {
        System.out.println("Thông tin bản đồ:");
        System.out.println("Kích thước: " + gameMap.getGridWidth() + "x" + gameMap.getGridHeight());
        System.out.println("Điểm kết thúc: (" + gameMap.getEndpointX() + ", " + gameMap.getEndpointY() + ")");
        System.out.println("Số lượng quái vật: " + gameMap.getMonstersCount());

        // Hiển thị vị trí quái vật
        for (int i = 0; i < gameMap.getMonstersCount(); i++) {

        }

        // Hiển thị trạng thái của grid
        System.out.println("Trạng thái grid:");
        for (int i = 0; i < gameMap.getGridHeight(); i++) {
            for (int j = 0; j < gameMap.getGridWidth(); j++) {
                System.out.print(gameMap.grid[j][i] + " "); // Hiển thị trạng thái ô
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }

        // Thông tin về chướng ngại vật
        System.out.println("Thông tin chướng ngại vật: ");
        for (int i = 0; i < gameMap.getGridHeight(); i++) {
            for (int j = 0; j < gameMap.getGridWidth(); j++) {
                if (gameMap.grid[j][i] == 1) {
                    System.out.println("Chướng ngại vật tại: (" + j + ", " + i + ")");
                }
            }
        }
    }

}
