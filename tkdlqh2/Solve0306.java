package tkdlqh2;

import java.util.*;
import java.util.stream.*;
public class Solve0306 {
	class BookTime {
		public int inHour;
		public int inMinute;
		public int outHour;
		public int outMinute;

		BookTime(String[] book_time){
			this.inHour = Integer.parseInt(book_time[0].split(":")[0]);
			this.inMinute = Integer.parseInt(book_time[0].split(":")[1]);
			this.outHour = Integer.parseInt(book_time[1].split(":")[0]);
			this.outMinute = Integer.parseInt(book_time[1].split(":")[1]);
		}
	}

	public int solution(String[][] book_time) {
		List<BookTime> bookTimeList= IntStream.range(0,book_time.length)
				.mapToObj(x-> new BookTime(book_time[x]))
				.sorted((x,y) -> {
					if(x.inHour == y.inHour){
						return x.inMinute -y.inMinute;
					}
					return x.inHour-y.inHour;
				})
				.collect(Collectors.toList());

		PriorityQueue<BookTime> pq = new PriorityQueue<>((x,y) -> {
			if(y.outHour == x.outHour){
				return x.outMinute -y.outMinute;
			}
			return x.outHour-y.outHour;
			});

		int size = 1;
		pq.add(bookTimeList.get(0));
		for (int i = 1; i < bookTimeList.size(); i++) {
			BookTime curTime = bookTimeList.get(i);
			BookTime lastTime = pq.peek();

			while(pq.size() != 0 && (lastTime.outHour< curTime.inHour - 1 ||
				(lastTime.outHour == curTime.inHour && lastTime.outMinute + 10 <= curTime.inMinute) ||
					(lastTime.outHour == curTime.inHour-1 && curTime.inMinute+60 - lastTime.outMinute >= 10))){
					pq.poll();
					lastTime = pq.peek();
			}

			pq.add(curTime);
			size = Math.max(size,pq.size());
		}
		return size;
	}
}
