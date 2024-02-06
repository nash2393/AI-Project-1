import java.io.*;
import java.util.*;

public class NishantWaterPouring {

    int[] capacities;

    class NishantState {
        int[] pitchers;
        int cost;
        int remaining;

        public NishantState(int[] pitchers, int cost, int remaining) {
            this.pitchers = pitchers;
            this.cost = cost;
            this.remaining = remaining;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NishantState state = (NishantState) o;
            return Arrays.equals(pitchers, state.pitchers);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(pitchers);
        }
    }

    public int nishantSolve(int[] caps, int target) {
        capacities = caps;
        PriorityQueue<NishantState> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost + nishantHeuristic(s)));
        Set<NishantState> visited = new HashSet<>();

        pq.offer(new NishantState(new int[caps.length], 0, target));

        while (!pq.isEmpty()) {
            NishantState state = pq.poll();

            if (state.remaining == 0) {
                return state.cost;
            }

            if (visited.contains(state)) {
                continue;
            }

            visited.add(state);

            for (int i = 0; i < state.pitchers.length; i++) {
                // Fill pitcher
                NishantState filledState = nishantFillPitcher(state, i);
                if (filledState != null && !visited.contains(filledState)) {
                    pq.offer(filledState);
                }

                // Empty pitcher
                NishantState emptyState = nishantEmptyPitcher(state, i);
                if (emptyState != null && !visited.contains(emptyState)) {
                    pq.offer(emptyState);
                }

                // Transfer water between pitchers
                for (int j = 0; j < state.pitchers.length; j++) {
                    if (i == j) continue;
                    NishantState nextState = nishantGetNextState(state, i, j);
                    if (nextState != null && !visited.contains(nextState)) {
                        pq.offer(nextState);
                    }
                }
            }
        }

        return -1; // No solution found
    }

    // Transfers water from one pitcher to another
    NishantState nishantGetNextState(NishantState cur, int from, int to) {
        int amountToTransfer = Math.min(cur.pitchers[from], capacities[to] - cur.pitchers[to]);
        if (amountToTransfer == 0) {
            return null;
        }

        int[] nextPitchers = cur.pitchers.clone();
        nextPitchers[from] -= amountToTransfer;
        nextPitchers[to] += amountToTransfer;

        int newRemaining = Math.max(cur.remaining - amountToTransfer, 0);
        return new NishantState(nextPitchers, cur.cost + 1, newRemaining);
    }

    // Empties a specific pitcher
    NishantState nishantEmptyPitcher(NishantState cur, int i) {
        if (cur.pitchers[i] == 0) {
            return null;
        }

        int[] nextPitchers = cur.pitchers.clone();
        nextPitchers[i] = 0;

        return new NishantState(nextPitchers, cur.cost + 1, cur.remaining);
    }

    // Fills a specific pitcher
    NishantState nishantFillPitcher(NishantState cur, int i) {
        if (cur.pitchers[i] == capacities[i]) {
            return null; // Pitcher is already full
        }

        int[] nextPitchers = cur.pitchers.clone();
        nextPitchers[i] = capacities[i];

        int newRemaining = Math.max(cur.remaining - (capacities[i] - cur.pitchers[i]), 0);
        return new NishantState(nextPitchers, cur.cost + 1, newRemaining);
    }

    // Heuristic based on remaining quantity
    int nishantHeuristic(NishantState s) {
        return s.remaining;
    }

    public static void main(String[] args) {
        NishantWaterPouring wp = new NishantWaterPouring();

        try {
            File file = new File("/path/to/your/input.txt"); // Replace with your file path
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line1 = br.readLine();
            String[] parts = line1.split(",");
            int[] capacities = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                capacities[i] = Integer.parseInt(parts[i].trim());
            }

            String line2 = br.readLine();
            int target = Integer.parseInt(line2.trim());

            System.out.println(wp.nishantSolve(capacities, target));

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
