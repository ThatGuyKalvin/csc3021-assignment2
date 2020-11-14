public class ReadWriteSafe implements ReadWrite {

	private int readers = 0;
	private boolean writing = false;
	
	@Override
	public synchronized void acquireRead() throws InterruptedException {
		// TODO Auto-generated method stub
		while(writing) wait();
		++readers;
	}

	@Override
	public synchronized void releaseRead() {
		// TODO Auto-generated method stub
		--readers;
		if(readers == 0) notify();
	}

	@Override
	public synchronized void acquireWrite() throws InterruptedException {
		// TODO Auto-generated method stub
		while(readers > 0 || writing) wait();
		writing = true;
	}

	@Override
	public synchronized void releaseWrite() {
		// TODO Auto-generated method stub
		writing = false;
		notifyAll();
	}

	
}
