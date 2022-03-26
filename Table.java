public class Table {
    private int tableID;
    private int capacity;

    public Table(int tableID, int capacity) {
        this.tableID = tableID;
        this.capacity = capacity;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
