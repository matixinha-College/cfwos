package cfwos.server;

import cfwos.model.entity.WorkOrder;
import cfwos.model.tree.TreeAVL;

public class Database{
    private TreeAVL<Integer, WorkOrder> database;

    public Database() {
        this.database = new TreeAVL<>();
    }

    public void addWorkOrder(int code, String name, String description) {
        WorkOrder workOrder = new WorkOrder(code, name, description);
        database.Insert(code, workOrder);
        
    }

    public void removeWorkOrder(int code) {
        database.Remove(code);
    }

    public void updateWorkOrder(int code, WorkOrder workOrder) {
        database.Remove(code);
        database.Insert(code, workOrder);
    }

    public WorkOrder searchWorkOrder(int code) {
        return database.Search(code);
    }

    public void showDatabase() {
        database.Show();
    }

    public void showDatabaseReverse() {
        database.ShowReverse();
    }

    public int getTreeHeight() {
        return database.getTreeHeight();
    }

    public int getSize() {
        return database.getSize();
    }

    public int getBalanceCounter() {
        return database.getBalanceCounter();
    }
}
