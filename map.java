import java.util.Arrays;

public class map {
    private String name;
    private int[][] grid; // Grid matrix
    private Monster[] monsters; // Array of monsters
    private int endpointX; // X coordinate of the endpoint
    private int endpointY; // Y coordinate of the endpoint
    private map nextMap;
    private map previousMap; // Previous map

    // Default constructor
    public map() {
        this.grid = new int[][]{};

        this.monsters = new Monster[0]; // Empty monster array
    }

    // Display the current grid state
    public void displayGrid() {
        System.out.println("Current Grid State:");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("--------------------------------");
    }

    // Update player's position and display the grid
    public void updatePlayerPosition(int oldX, int oldY, int newX, int newY) {
        grid[oldX][oldY] = 0; // Clear old position
        grid[newX][newY] = 3; // Set new position
        displayGrid(); // Display the updated grid
    }

    // Respawn a monster and display the grid
    public void respawnMonster(Monster monster) {
        grid[monster.getX()][monster.getY()] = 5; // Set monster position to 5
        System.out.println(monster.getName() + " has respawned at (" + monster.getX() + ", " + monster.getY() + ")");
        displayGrid(); // Display the updated grid
    }

    // Getter for grid
    public int[][] getGrid() {
        return grid;
    }

    public int getGridWidth() {
        return grid.length;
    }

    public int getGridHeight() {
        return grid[0].length;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public String getName() {
        return name;
    }

    public void setPreviousMap(map previousMap) {
        this.previousMap = previousMap;
    }

    public int getEndpointX() {
        return endpointX;
    }

    public int getEndpointY() {
        return endpointY;
    }

    public int getMonstersCount() {
        return this.monsters.length;
    }

    // Load map method
    public map loadMap(Player player) {
        if (check_previousMap(player)) {
            player.setX(previousMap.endpointX - 1);
            player.setY(previousMap.endpointY - 1);
            return previousMap;
        }
        if (checkEndpoint(player)) {
            player.setX(0);
            player.setY(0);
            return nextMap;
        }
        return null;
    }

    // Check for previous map
    public boolean check_previousMap(Player player) {
        if ((player.getX() == 0 && player.getY() == -1) || (player.getX() == -1 && player.getY() == 0)) {
            if (previousMap != null) {
                System.out.println("Returning to the previous map...");
                return true;
            } else {
                System.out.println("No previous map to return to.");
                return false;
            }
        }
        return false;
    }

    // Check for endpoint
    public boolean checkEndpoint(Player player) {
        if (player.getX() == endpointX && player.getY() == endpointY) {
            if (nextMap != null) {
                System.out.println("Loading next map: " + nextMap.getName());
                return true;
            } else {
                System.out.println("No more maps available.");
                return false;
            }
        }
        return false;
    }

    // Display map information
    public void displayMapInfo() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Map Information:");
        System.out.println("Size: " + getGridWidth() + "x" + getGridHeight());
        System.out.println("Endpoint: (" + getEndpointX() + ", " + getEndpointY() + ")");
        System.out.println("Number of Monsters: " + getMonstersCount());

        // Display grid status
        System.out.println("Grid Status:");
        for (int i = 0; i < getGridHeight(); i++) {
            System.out.print("{ ");
            for (int j = 0; j < getGridWidth(); j++) {
                System.out.print(grid[j][i] + " ");
            }
            System.out.println("}");
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}
