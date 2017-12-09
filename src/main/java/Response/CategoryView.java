package Response;

public class CategoryView {

		private int categoryId;
		private String categoryName;
		private int numOfQuestions;
		private int numOfVocab;
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public int getNumOfQuestions() {
			return numOfQuestions;
		}
		public void setNumOfQuestions(int numOfQuestions) {
			this.numOfQuestions = numOfQuestions;
		}
		public int getNumOfVocab() {
			return numOfVocab;
		}
		public void setNumOfVocab(int numOfVocab) {
			this.numOfVocab = numOfVocab;
		}
	}

