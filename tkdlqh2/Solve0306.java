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
		// 나가는 시간 기준으로 priority Queue 를  사용하는 유명한 greedy 문제라고 알고 있습니다.
		// 정렬을 편하게 하기 위해 BookTime 이란 객체를 만들고
		// 들어가는 시간 순으로 정렬을 해줍니다.
		List<BookTime> bookTimeList= IntStream.range(0,book_time.length)
				.mapToObj(x-> new BookTime(book_time[x]))
				.sorted((x,y) -> {
					if(x.inHour == y.inHour){
						return x.inMinute -y.inMinute;
					}
					return x.inHour-y.inHour;
				})
				.collect(Collectors.toList());

		// 나가는 시간이 빠른 순서의 Priority Queue 를  생성해줍니다.
		PriorityQueue<BookTime> pq = new PriorityQueue<>((x,y) -> {
			if(y.outHour == x.outHour){
				return x.outMinute -y.outMinute;
			}
			return x.outHour-y.outHour;
			});

		int size = 1;
		pq.add(bookTimeList.get(0));

		// 들어가는 시간 순으로 하나씩 가져오면서
		// 들어오는 시간에 이미 나갔어야 되는 BootTime 들을  퇴장처리 해줍니다.
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
