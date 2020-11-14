import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Database {
	private final HashMap<String, Table> tables;
	
	Database() {
		tables = new HashMap<String, Table>();
	}

	public void addTable(Table table) {
		tables.put(table.getName(), table);
	}

	public Table getTable(String name) {
		return tables.get(name);
	}
}
