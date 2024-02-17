package assign03;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A generic class with a priority queue.
 *
 * @author Deya Tallman
 * @version 1/31/2024
 * @param <E> The type of elements stored in the priority queue.
 */
public class SimplePriorityQueue<E> implements PriorityQueue<E> {

	private static final int INITIAL = 16;
	private Object[] array;
	private int size;
	private Comparator<? super E> comparator;

	/**
	 * Constructs a SimplePriorityQueue with the natural ordering of elements.
	 */
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue() {
		this.array = (E[]) new Object[INITIAL];
		this.size = 0;
		this.comparator = null;
	}

	/**
	 * Constructs a SimplePriorityQueue with the provided comparator.
	 *
	 * @param cmp The comparator to be used for ordering elements.
	 */
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue(Comparator<? super E> cmp) {
		this.array = (E[]) new Object[INITIAL];
		this.size = 0;
		this.comparator = cmp;
	}

	private int binarySearch(E key) {
		int low = 0;
		int high = size - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int cmp = compare(array[mid], key);

			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return -(low + 1);
	}

	private int compare(Object o1, Object o2) {
		if (comparator == null) {
			return ((Comparable<? super E>) o1).compareTo((E) o2);
		} else {
			return comparator.compare((E) o1, (E) o2);
		}
	}

	@Override
	public void insert(E item) {
		int index = binarySearch(item);
		if (index < 0) {
			index = -index - 1;
		}

		if (size == array.length) {
			resizeArray();
		}

		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = item;
		size++;
	}

	@Override
	public void insertAll(Collection<? extends E> coll) {
		for (E item : coll) {
			insert(item);
		}
	}

	@Override
	public boolean contains(E item) {
		return binarySearch(item) >= 0;
	}

	@Override
	public E findMax() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Priority queue is empty");
		}
		return (E) array[size - 1];
	}

	@Override
	public E deleteMax() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Priority queue is empty");
		}
		E max = (E) array[--size];
		array[size] = null;
		return max;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}

	private void resizeArray() {
		int newCapacity = array.length * 2;
		array = Arrays.copyOf(array, newCapacity);
	}
}