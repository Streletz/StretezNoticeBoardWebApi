package response;

import java.util.List;

import com.example.demo.repo.Category;

public class DbResponse {

	private List<Category> items;

	public DbResponse(List<Category> dbItems) {
		items = dbItems;
	}

	public List<Category> getItems() {
		return items;
	}

}
