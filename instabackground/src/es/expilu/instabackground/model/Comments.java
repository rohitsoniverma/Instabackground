package es.expilu.instabackground.model;

public class Comments {

	private int count;
	private CommentsData[] data;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CommentsData[] getData() {
		return data;
	}

	public void setData(CommentsData[] data) {
		this.data = data;
	}
}
