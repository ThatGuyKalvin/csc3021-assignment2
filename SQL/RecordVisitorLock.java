import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Collections;

class RecordVisitorLock implements RecordVisitor {
	private Table table;
	public Lock lock = new ReentrantLock();
	public Lock lockIndex;
	private final Lock newLock = new ReentrantLock();
	

	RecordVisitorLock(Table table_) {
		table = table_;
	}

	public void visit(Record row) {
		// The record row needs to be locked.
		lock.lock();
		row.getLock().lock(); // lock index
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
