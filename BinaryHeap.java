import java.util.Arrays;
public class BinaryHeap{
	public int size=0;
	public int[] data=new int[10];
	public BinaryHeap(){
		size = 0;
		data = new int[10];
	}

	public void add(int item) {
		if(size==data.length){
			grow_array();
		}
		data[size++] = item;
		int curr = size-1;
		int parent = (curr-1)/2;
		while(curr != 0 && data[curr] < data[parent]){
			swap(data, curr, parent);
			//need to compare parent to its parent
			curr = parent;
			parent = (parent-1)/2;
		}
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public int remove() {
		//swap first with last in data
		swap(data, 0, size-1);
		size--;
		if(size > 0){
			shiftdown(0);
		}
		return data[size]; //+1
	}
	public boolean isLeaf(int pos){
		return((pos>size/2)&&(pos<=size));
	}
	void shiftdown(int pos) {
		int parent = pos;
		int left = parent*2+1;
		int right = parent*2+2;
		if(left>=size || right >= size){
			return;
		}
		if(data[left]<data[right]&&data[left]<data[pos]){
			swap(data,left,pos);
			shiftdown(left);
		}
		else if(data[right]<data[left]&&data[right]<data[pos]){
			swap(data,right,pos);
			shiftdown(right);
		}

		//recursively call to compare children and move down
	}
	public void grow_array(){
		int[] temp = new int[data.length*2];
		for(int i = 0; i<size; i++)
			temp[i] = data[i];
		data = temp;
	}

}