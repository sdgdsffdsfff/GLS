package cn.gls.geocoding.engine.batch;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @date 2012-8-14
 * @author "Daniel Zhang"
 * @update 2012-8-14
 * @description TODO
 *
 */
public class GeoCodingTaskQueue {
	/**任务队列*/
	private List<GeoCodingTaskInterface> queue = new LinkedList<GeoCodingTaskInterface>();

	public synchronized GeoCodingTaskInterface getTask() {
		// while (queue.size() == 0) {
		// try {
		//
		// // this.wait();
		// return null;
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// return null;
		// }
		// }
		if (queue.size() == 0)
			return null;
//		System.out.println("当前线程:" + Thread.currentThread().getId() + "拿走了任务"
//				+ queue.get(0).toString())
		
		GeoCodingTaskInterface task = (GeoCodingTaskInterface) queue.remove(0);
		return task;
	}

	public synchronized void putTask(GeoCodingTaskInterface task) {
		// while (queue.size() > QUEUE_SIZE) {
		// try {
		// wait();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		queue.add(task);
	//	this.notifyAll();

	}

}