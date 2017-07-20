package dandb;

public class GenreVO {
	
	private String genreId;
	private String genreName;
	private String genreUrl;
	
	public String getGenreId() {
		return genreId;
	}
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getGenreUrl() {
		return genreUrl;
	}
	
	public void setGenreUrl(String genreUrl) {
		this.genreUrl = genreUrl;
	}
	@Override
	public String toString() {
		return "GenreVO [genreId=" + genreId + ", genreName=" + genreName + ", genreUrl=" + genreUrl + "]";
	}
	
	
} //end class
