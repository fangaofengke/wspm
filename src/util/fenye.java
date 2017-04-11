package util;

public class fenye {
	
	private int count;
	
	private int totalpage;
	
	private final int pagesie=5;
	
	private int pageindex=1;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalpage() {
		return count%pagesie==0?count/pagesie:(count/pagesie)+1;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int getPagesie() {
		return pagesie;
	}




	
	

}
