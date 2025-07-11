//Design and develop an application maze game by sorting the no of entry and exit in a maze in which the entry has multiple inputs and restricted outputs 
import java.util.ArrayList;
import java.util.List;      
public class scenario3 {
    public static void main(String[] args) {
        List<Maze> mazes = new ArrayList<>();
        mazes.add(new Maze("Maze A", 3, 1));
        mazes.add(new Maze("Maze B", 2, 2));
        mazes.add(new Maze("Maze C", 4, 0));
        mazes.add(new Maze("Maze D", 1, 3));

        selectionSort(mazes);

        for (Maze maze : mazes) {
            System.out.println(maze.getName() + " - Entry: " + maze.getEntryCount() + ", Exit: " + maze.getExitCount());
        }
    }

    public static void selectionSort(List<Maze> mazes) {
        for (int i = 0; i < mazes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < mazes.size(); j++) {
                if (mazes.get(j).getEntryCount() < mazes.get(minIndex).getEntryCount()) {
                    minIndex = j;
                }
            }
            Maze temp = mazes.get(minIndex);
            mazes.set(minIndex, mazes.get(i));
            mazes.set(i, temp);
        }
    }
}
class Maze {
    private String name;
    private int entryCount;
    private int exitCount;

    public Maze(String name, int entryCount, int exitCount) {
        this.name = name;
        this.entryCount = entryCount;
        this.exitCount = exitCount;
    }

    public String getName() {
        return name;
    }

    public int getEntryCount() {
        return entryCount;
    }

    public int getExitCount() {
        return exitCount;
    }
}