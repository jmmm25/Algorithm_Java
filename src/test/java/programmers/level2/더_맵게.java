package programmers.level2;

import java.util.Iterator;
import java.util.PriorityQueue;

public class 더_맵게 {
    private boolean checkScovilleK(PriorityQueue priorityQueue, int K) {
        Iterator<Integer> iterator = priorityQueue.iterator();
        boolean checkScoville = true;
        while (iterator.hasNext()) {
            if (iterator.next() <= K) {
                checkScoville = false;
                break;
            }
        }
        return checkScoville;
    }


    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        while (priorityQueue.size() >= 2) {
            int firstScoville = priorityQueue.peek();
            priorityQueue.poll();
            int secondScoville = priorityQueue.peek();
            priorityQueue.poll();
            int mixedScoville = firstScoville + (secondScoville * 2);
            priorityQueue.add(mixedScoville);
            answer++;

            if (!checkScovilleK(priorityQueue, K)) {
                if (priorityQueue.size() >= 2) {
                    continue;
                } else {
                    answer = -1;
                    break;
                }
            } else {
                break;
            }
        }

        return answer;
    }

//    public static void main(String[] args) {
//        int[] scoville = {1, 2, 3, 9, 10, 12};
////        int[] scoville = {1, 2};
//        int K = 7;
//        더_맵게 s = new 더_맵게();
//
//        System.out.println(s.solution(scoville, K));
//    }
}
