public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    private String[] underlying;
    private int occupancy;

    public DynamicArray(int size) {
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        this.underlying = new String[size];
        this.occupancy = 0;
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    private void resize() {
        String[] temp = new String[this.underlying.length * RESIZE_FACTOR];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    }

    public void add(String string) {
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    }

    public int indexOf(String string) {
        for (int i = 0; i < this.occupancy; i++) {
            if (this.underlying[i].equals(string)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String string) {
        return this.indexOf(string) != -1;
    }

    public int countOf(String string) {
        int count = 0;
        for (int i = 0; i < this.occupancy; i++) {
            if (this.underlying[i].equals(string)) {
                count++;
            }
        }
        return count;
    }

    public String remove(int index) {
        if (index < 0 || index >= this.occupancy) {
            return null;
        }
        String removed = this.underlying[index];
        for (int i = index; i < this.occupancy - 1; i++) {
            this.underlying[i] = this.underlying[i + 1];
        }
        this.underlying[this.occupancy - 1] = null;
        this.occupancy--;
        return removed;
    }

    public String remove(String string) {
        int index = this.indexOf(string);
        if (index == -1) {
            return null;
        }
        return this.remove(index);
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < this.occupancy; i++) {
            result += this.underlying[i];
            if (i < this.occupancy - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
