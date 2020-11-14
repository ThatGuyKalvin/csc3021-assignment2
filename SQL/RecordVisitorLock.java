import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Collections;

class RecordVisitorLock implements RecordVisitor {
	private Table table;
	public LockSet locks = new LockSet();
	

	RecordVisitorLock(Table table_) {
		table = table_;
	}

	public void visit(Record row) {
		// The record row needs to be locked.
		row.lock.lock();
		//System.out.println("RowLock: " +row.lock);
		locks.add(row.lock);
	}

	// This comparator class can be helpful to sort records as part of the
	// deadlock prevention policy.
	class Cmp implements Comparator<Record> {
		// Return a value less than zero if lhs < rhs
		// Return zero if lhs == rhs
		// Return a value greater than zero if lhs > rhs
		public int compare(Record lhs, Record rhs) {
			return 0;
		}
	}

}
