import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class SyncSortList implements Runnable {
    List<Integer> list;

    SyncSortList(List<Integer> list) {
        this.list = Collections.synchronizedList(list);
    }

    List<Integer> getList() {
        return this.list;
    }
    public void run() {
        synchronized (list) {
            Collections.sort(list);
        }
    }
}
